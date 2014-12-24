import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class DBForm extends JFrame {
    private JTabbedPane tabbedPane;
    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public DBForm(String title) throws Exception {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 450);
        setupMySQL();
        placeComponents();
    }

    private void setupMySQL() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://127.0.01:3306/mydblili?user=root&password=кщще");
        statement = connection.createStatement();

    }

    private void placeComponents() throws SQLException {
        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(new BorderLayout());
        tabbedPane = new JTabbedPane();
        makePanel("Auto");
        makePanel("Colors");
        makePanel("Customers");
        makePanel("Kompl");
        makePanel("Managers");
        //makePanel("Marks");
        makePanel("Models");
        makePanel("Orders");
        //makePanel("Prices");
        panel.add(tabbedPane, BorderLayout.CENTER);
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        setVisible(true);
    }

    private void makePanel(final String tableName) throws SQLException {
        final JPanel p = new JPanel();
        p.setSize(500, 350);
        p.setLayout(new BorderLayout());
        final ResultSet[] rs = {statement.executeQuery("SELECT * FROM " + tableName)};
        final JTable[] table = {refresh(rs[0])};
        final int cc = rs[0].getMetaData().getColumnCount();
        p.add(table[0].getTableHeader(), BorderLayout.PAGE_START);
        p.add(table[0], BorderLayout.CENTER);
        JPanel subpanel = new JPanel(new GridLayout(2, 1));
        final JPanel fields = new JPanel(new GridLayout(cc, 2));
        JPanel buttons = new JPanel(new GridLayout(1, 6));
        final JTextField[] tf = new JTextField[cc];
        for (int i = 0; i < cc; i++) {
            JLabel l = new JLabel(table[0].getColumnName(i));
            fields.add(l, i, 0);
            tf[i] = new JTextField();
            fields.add(tf[i], i, 1);
        }
        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = "INSERT INTO " + tableName + " VALUES (";
                for (int i = 0; i < cc; i++) {
                    sql += "'" + tf[i].getText() + "'";
                    if (i != cc - 1) sql += ", ";
                }
                sql += ");";
                try {
                    statement.execute(sql);
                    ResultSet rs = statement.executeQuery("SELECT * FROM " + tableName);
                    p.remove(table[0]);
                    table[0] = refresh(rs);
                    p.add(table[0]);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        buttons.add(btnAdd, 0, 0);
        JButton btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = "DELETE FROM " + tableName + " WHERE ";
                int r = table[0].getSelectedRow();
                for (int i = 0; i < cc; i++) {
                    sql += table[0].getColumnName(i) + " = '" + table[0].getModel().getValueAt(r, i) + "'";
                    if (i != cc - 1) sql += "AND ";
                }
                sql += ";";
                try {
                    statement.execute(sql);
                    ResultSet rs = statement.executeQuery("SELECT * FROM " + tableName);
                    table[0] = refresh(rs);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        buttons.add(btnDelete, 0, 1);
        JButton btnPrev = new JButton("Prev");
        btnPrev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = table[0].getSelectedRow();
                if (i > 0)
                    table[0].setRowSelectionInterval(i - 1, i - 1);
            }
        });
        buttons.add(btnPrev, 0, 2);
        JButton btnNext = new JButton("Next");
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = table[0].getSelectedRow();
                if (i < table[0].getRowCount())
                    table[0].setRowSelectionInterval(i + 1, i + 1);
            }
        });
        buttons.add(btnNext, 0, 3);
        JButton btnFirst = new JButton("First");
        btnFirst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table[0].setRowSelectionInterval(0, 0);
            }
        });
        buttons.add(btnFirst, 0, 4);
        JButton btnLast = new JButton("Last");
        btnLast.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table[0].setRowSelectionInterval(table[0].getRowCount() - 1, table[0].getRowCount() - 1);
            }
        });
        buttons.add(btnLast, 0, 5);
        buttons.setPreferredSize(new Dimension(600, 30));
        subpanel.add(fields, 0, 0);
        subpanel.add(buttons, 1, 0);
        p.add(subpanel, BorderLayout.SOUTH);
        tabbedPane.addTab(tableName, p);
    }

    private JTable refresh(ResultSet rs) throws SQLException {
        rs.beforeFirst();
        final int cc = rs.getMetaData().getColumnCount();
        Vector<String> colnames = new Vector<String>();
        colnames.setSize(cc);
        for (int i = 0; i < cc; i++) {
            colnames.set(i, rs.getMetaData().getColumnName(i + 1));
        }
        Vector<Vector<String>> data = new Vector<Vector<String>>();
        while (rs.next()) {
            Vector<String> v = new Vector<String>();
            v.setSize(cc);
            for (int i = 0; i < cc; i++) {
                v.set(i, rs.getString(i + 1));
            }
            data.add(v);
        }
        JTable t = new JTable(data, colnames);
        return t;
    }
}

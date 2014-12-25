package ru.kpfu.disciplines.db.gtf.pages;

import ru.kpfu.disciplines.db.gtf.GamedevTeamFinder;
import ru.kpfu.disciplines.db.gtf.helpers.ConnectorDB;
import ru.kpfu.disciplines.db.gtf.helpers.GamedevTypes;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.MouseInputAdapter;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PersonalArea extends JPanel {
    private ConnectorDB connector;
    private String currentUser = StartPage.getCurrentUser();
    private Font titleFont = new Font("titleFont", Font.BOLD, 26);
    private java.util.List<JComponent> componentList = new ArrayList<JComponent>();
    private Font labelsFont = new Font("labelsFont", Font.BOLD, 15);

    @SuppressWarnings("unchecked")
    public PersonalArea(ConnectorDB connectorDB) {
        super();
        connector = connectorDB;

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        add(createSearchPanel());
        Box verticalBox = Box.createVerticalBox();
        add(verticalBox);

        verticalBox.add(createTeamsPanel());
        verticalBox.add(createResumesPanel());

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
                doThemNull(componentList);
                ((JComboBox)componentList.get(3)).setModel(new DefaultComboBoxModel<String>());
                componentList.get(componentList.size() - 1).removeAll();
                componentList.get(componentList.size() - 1).revalidate();
                componentList.get(componentList.size() - 1).repaint();
                componentList.get(componentList.size() - 1).add(new JLabel("results:"));
                componentList.get(componentList.size() - 1).add(new JSeparator(SwingConstants.HORIZONTAL));
                componentList.get(componentList.size() - 1).revalidate();
            }
        });
    }

    // создание панели поиска объявлений о вакансиях
    private JPanel createSearchPanel() {
        JPanel forSearchPanel = new JPanel();
        forSearchPanel.setLayout(new BoxLayout(forSearchPanel, BoxLayout.PAGE_AXIS));
        forSearchPanel.setBorder(new LineBorder(GamedevTeamFinder.DARK, 2, true));
        forSearchPanel.setPreferredSize(new Dimension(880, 780));
        forSearchPanel.setLocation(10, 10);

        // добавление заголовка
        JPanel forTitle = new JPanel();
        forTitle.setPreferredSize(new Dimension(880, 80));
        forSearchPanel.add(forTitle);
        JLabel title = new JLabel("Search announcements");
        forTitle.add(title);
        // редактирование заголовка
        title.setFont(titleFont);
        title.setForeground(GamedevTeamFinder.DARK);

        // добавление панели поиска
        JPanel searchPanel = new JPanel();
        forSearchPanel.add(searchPanel);
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.LINE_AXIS));
        searchPanel.setPreferredSize(new Dimension(880, 700));

        // добавление панели критериев поиска
        JPanel criteria = new JPanel();
        searchPanel.add(criteria);
        criteria.setLayout(new BoxLayout(criteria, BoxLayout.PAGE_AXIS));
        criteria.setPreferredSize(new Dimension(380, 700));
        criteria.setBorder(new LineBorder(GamedevTeamFinder.DARK, 2, true));
        // добавляение заголовка над критериями
        JLabel criteriaLabel = new JLabel("search criteria");
        criteriaLabel.setFont(labelsFont);
        criteriaLabel.setForeground(GamedevTeamFinder.DARK);
        criteria.add(criteriaLabel);
        criteria.add(new JSeparator(SwingConstants.HORIZONTAL));
        criteria.add(Box.createRigidArea(new Dimension(380, 10)));
        // определение самих критерием с их названиями сверху
        JLabel teamName = new JLabel("team name");
        teamName.setFont(labelsFont);
        teamName.setForeground(GamedevTeamFinder.DARK);
        JLabel position = new JLabel(" vacancy's position");
        position.setForeground(GamedevTeamFinder.DARK);
        position.setFont(labelsFont);
        JLabel globalGenres = new JLabel("game's global genre");
        globalGenres.setForeground(GamedevTeamFinder.DARK);
        globalGenres.setFont(labelsFont);
        JLabel genres = new JLabel("game's genre");
        genres.setForeground(GamedevTeamFinder.DARK);
        genres.setFont(labelsFont);
        JLabel platforms = new JLabel("platform(s)");
        platforms.setForeground(GamedevTeamFinder.DARK);
        platforms.setFont(labelsFont);
        final JTextField teamNameField = new JTextField();
        JPanel forTeamNameField = new JPanel();
        teamNameField.setPreferredSize(new Dimension(200, 30));
        forTeamNameField.add(teamNameField);
        final JComboBox<String> positionField = new JComboBox<String>(GamedevTypes.Positions);
        final JComboBox<String> globalGenresField = new JComboBox<String>();
        final JComboBox<String> genresField = new JComboBox<String>();
        final JComboBox<String> platformsField = new JComboBox<String>(GamedevTypes.Platforms);
        try {
            Connection conn = connector.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet globalGenresResult = stmt.executeQuery("select name from genres where parent_id is null order by name");
            String[] globals = new String[12];
            int i = 0;
            while(globalGenresResult.next()) {
                globals[i] = globalGenresResult.getString("name");
                i++;
            }
            globalGenresField.setModel(new DefaultComboBoxModel<String>(globals));
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
        // добавление критериев на экран
        criteria.add(teamName);
        criteria.add(forTeamNameField);
        criteria.add(position);
        criteria.add(positionField);
        criteria.add(globalGenres);
        criteria.add(globalGenresField);
        criteria.add(genres);
        criteria.add(genresField);
        criteria.add(platforms);
        criteria.add(platformsField);
        // добавляем поля в список, чтобы обнулять при потере фокуса окна
        componentList.add(teamNameField);
        componentList.add(positionField);
        componentList.add(globalGenresField);
        componentList.add(genresField);
        componentList.add(platformsField);
        // добавление кнопки для запуска поиска
        JPanel forSearchButton = new JPanel();
        JButton searchButton = new JButton("Search");
        forSearchButton.add(searchButton);
        criteria.add(forSearchButton);

        // добавляем листенер для изменения списка жанров при выборе глобального жанра
        globalGenresField.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                if(event.getStateChange() == ItemEvent.SELECTED) {
                    String selectedValue = (String) event.getItem();
                    if(!selectedValue.equals("")) {
                        try {
                            Connection conn = connector.getConnection();
                            Statement stmt = conn.createStatement();
                            ResultSet genresResult = stmt.executeQuery("select name from genres where name='' or parent_id=" +
                                    "(select id from genres where name='" +
                                    globalGenresField.getSelectedItem() + "') order by name");
                            int rowCount = 0;
                            genresResult.first();
                            while (genresResult.next()) {
                                rowCount++;
                            }
                            rowCount++;
                            String[] privateGenres = new String[rowCount];
                            int i = 0;
                            genresResult.first();
                            while(genresResult.next()) {
                                privateGenres[i] = genresResult.getString("name");
                                i++;
                            }
                            genresField.setModel(new DefaultComboBoxModel<String>(privateGenres));
                        } catch (SQLException sqlExcept) {
                            sqlExcept.printStackTrace();
                        }
                    } else {
                        genresField.setModel(new DefaultComboBoxModel<String>());
                    }
                }
            }
        });

        // добавление панели для вывода результатов на экран
        final JPanel forResults = new JPanel();
        forResults.setLayout(new BoxLayout(forResults, BoxLayout.PAGE_AXIS));
        searchPanel.add(forResults);
        forResults.setPreferredSize(new Dimension(500, 700));
        forResults.setBorder(new LineBorder(GamedevTeamFinder.DARK, 2, true));
        // добавление титутла "результаты"
        final JLabel resultsLabel = new JLabel("results:");
        forResults.add(resultsLabel);
        forResults.add(new JSeparator(SwingConstants.HORIZONTAL));
        componentList.add(forResults);

        searchButton.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    String nameCopy = teamNameField.getText();
                    if(nameCopy == null) {
                        nameCopy = "";
                    }
                    String positionCopy = (String) positionField.getSelectedItem();
                    if(positionCopy == null) {
                        positionCopy = "";
                    }
                    String globalGenresCopy = (String) globalGenresField.getSelectedItem();
                    if(globalGenresCopy == null) {
                        globalGenresCopy = "";
                    }
                    String genresCopy = (String) genresField.getSelectedItem();
                    if(genresCopy == null) {
                        genresCopy = "";
                    }
                    String platformsCopy = (String) platformsField.getSelectedItem();
                    if(platformsCopy == null) {
                        platformsCopy = "";
                    }

                    Connection conn = connector.getConnection();
                    Statement stmt = conn.createStatement();
                    stmt.execute("call select_announcements_by_params('" +
                            nameCopy + "','" + positionCopy + "','" + globalGenresCopy + "','" +
                            genresCopy + "','" + platformsCopy + "')");
                    final ResultSet announcementsResult = stmt.getResultSet();
                    // создание таблицы для вывода результатов
                    if(announcementsResult.next()) {
                        announcementsResult.first();
                        AbstractTableModel newModel = new AbstractTableModel() {
                            @Override
                            public int getRowCount() {
                                int rowCount = 0;
                                try {
                                    announcementsResult.first();
                                    while (announcementsResult.next()) {
                                        rowCount++;
                                    }
                                    rowCount++;
                                } catch (SQLException sqlExcept) {
                                    sqlExcept.printStackTrace();
                                }
                                return rowCount;
                            }

                            @Override
                            public int getColumnCount() {
                                int columnCount = 0;
                                try {
                                    columnCount = announcementsResult.getMetaData().getColumnCount();
                                } catch (SQLException sqlExcept) {
                                    sqlExcept.printStackTrace();
                                }
                                return columnCount;
                            }

                            @Override
                            public Object getValueAt(int rowIndex, int columnIndex) {
                                int i = 0;
                                try {
                                    announcementsResult.first();
                                    while (i < rowIndex && announcementsResult.next()) {
                                        i++;
                                    }
                                    return announcementsResult.getObject(columnIndex + 1);
                                } catch (SQLException sqlExcept) {
                                    sqlExcept.printStackTrace();
                                    return null;
                                }
                            }

                            @Override
                            public String getColumnName(int columnIndex) {
                                try {
                                    return announcementsResult.getMetaData().getColumnLabel(columnIndex + 1);
                                } catch (SQLException sqlExcept) {
                                    sqlExcept.printStackTrace();
                                    return "";
                                }
                            }
                        };
                        JTable newTable = new JTable();
                        newTable.setModel(newModel);
                        forResults.removeAll();
                        forResults.revalidate();
                        forResults.repaint();
                        forResults.add(resultsLabel);
                        forResults.add(new JSeparator(SwingConstants.HORIZONTAL));
                        JScrollPane newScrollPane = new JScrollPane(newTable);
                        newScrollPane.setPreferredSize(new Dimension(480, 660));
                        newScrollPane.setLocation(10, 30);
                        forResults.add(newScrollPane);
                        forResults.revalidate();
                    } else {
                        forResults.removeAll();
                        forResults.revalidate();
                        forResults.repaint();
                        forResults.add(resultsLabel);
                        forResults.add(new JSeparator(SwingConstants.HORIZONTAL));
                        JPanel forSorryLabel = new JPanel();
                        forSorryLabel.add(new JLabel("SORRY, THERE ARE NO SUCH ANNOUNCEMENTS =("));
                        forResults.add(forSorryLabel);
                        forResults.add(Box.createRigidArea(new Dimension(500, 630)));
                        forResults.revalidate();
                    }
                } catch(SQLException sqlExcept) {
                    sqlExcept.printStackTrace();
                }
            }
        });

        return forSearchPanel;
    }

    // создание панели команд
    private JPanel createTeamsPanel() {
        JPanel forTeams = new JPanel();
        forTeams.setBorder(new LineBorder(GamedevTeamFinder.DARK, 2, true));
        forTeams.setPreferredSize(new Dimension(280, 380));
        forTeams.setLocation(910, 10);

        return forTeams;
    }

    // создание панели резюме пользователя
    private JPanel createResumesPanel() {
        JPanel forResumes = new JPanel();
        forResumes.setBorder(new LineBorder(GamedevTeamFinder.DARK, 2, true));
        forResumes.setPreferredSize(new Dimension(280, 380));
        forResumes.setLocation(910, 410);


        return forResumes;
    }

    // обнуляет, значения переданных компонент
    public static void doThemNull(java.util.List<JComponent> fields) {
        for(JComponent component : fields) {
            if(component instanceof JTextField) {
                ((JTextField) component).setText(null);
            } else {
                if(component instanceof JComboBox) {
                    ((JComboBox) component).setSelectedItem(null);
                }
            }
        }
    }
}
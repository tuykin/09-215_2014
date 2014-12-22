package myapp;

import java.awt.*;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

class LoginWin extends JDialog { // модальное окно
    // for DB
    private static String dbURL = "jdbc:mysql://localhost:3306/gto?user=root&password=root";
    private static Connection conn = null; // переменная, которая хранит подключение к БД
    private static Statement stmt = null; // переменная для того, чтобы делать запросы к БД
    static ResultSet results = null;
    // ссылка на объект класса
	LoginWin lwframe = this; 
	// текстовые поля
	JTextField tLogin, tPas;
	// для реализации функционала
	static boolean teacherLogin = false;
	static boolean studentLogin = false;
	static boolean guestLogin = false;
	static Integer student_id = null;

	LoginWin(JFrame f, String s) throws SQLException {
		super(f, s, true);
		setSize(300, 200);
		setResizable(false);
		setLocationRelativeTo(null);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent ev) {
				shutdown();
				System.exit(0);
			}
		});
		
        // подключаемся к БД
        createConnection();
		
		JPanel panel = new JPanel(); // общая панель
		add(panel);
		
		// лейблы и текстовые поля
		JLabel lLogin = new JLabel("Логин:", JLabel.RIGHT);
		JLabel lPas = new JLabel("Пароль:", JLabel.RIGHT);
		tLogin = new JTextField(10);
		tPas = new JPasswordField();
		
		// панель для лейблов и тексовых полей
		JPanel p1 = new JPanel(new GridLayout(2, 2, 10, 15));
		p1.add(lLogin); p1.add(tLogin); p1.add(lPas); p1.add(tPas); 
		JPanel p = new JPanel();
		p.add(p1);

		// кнопки
		JButton bLogin = new JButton("Вход");
		bLogin.addActionListener(new LoginActionEventHandler());
		JButton bGuest = new JButton("Зайти гостем");
		bGuest.addActionListener(new GuestActionEventHandler());
		
		// бокс для кнопок
		Box butbox = Box.createVerticalBox();
		JPanel pb1 = new JPanel(); pb1.add(bLogin);
		JPanel pb2 = new JPanel(); pb2.add(bGuest);
		butbox.add(pb1); butbox.add(Box.createVerticalStrut(5)); butbox.add(pb2);
		
		// добавляем панели на общуюю панель
		panel.add(p);
		panel.add(butbox);	
	}
	
    public class LoginActionEventHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // проверка полей на пустоту (создаём диалоговое окно)
            if(tLogin.getText().equals("")) {
                JOptionPane.showMessageDialog(lwframe, "Введите логин.", "Предупреждение",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            if(tPas.getText().equals("")) {
                JOptionPane.showMessageDialog(lwframe, "Введите пароль.", "Предупреждение",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            // проверяем логин
            boolean loginflag = false;
            try {
            	stmt = conn.createStatement();
                results = stmt.executeQuery("call get_accounts()");
                while (results.next()) {
                	if (tLogin.getText().equals(results.getString(2))) { // сравниваем логин с логинами из БД
                		loginflag = true;
                		break; // выходим из цикла
                	}
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            // проверяем пароль
            boolean passwordflag = false;
            if (loginflag == true) {
	            try {
	                if (tPas.getText().equals(results.getString(3))) // сравниваем пароль с паролем из БД
	                	passwordflag = true;
	            } catch (SQLException e1) {
	                e1.printStackTrace();
	            }
            }
            // выводим окно, если неверный логин или пароль
            if(loginflag == false || passwordflag == false) {
                JOptionPane.showMessageDialog(lwframe, "Введён неправильный логин или пароль.", "Ошибка",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            // проверяем, кто вошел в систему: препод или студент
            try {
                if (results.getBoolean(4) == true)
                	teacherLogin = true;
                else {
                	studentLogin = true;
                	student_id = results.getInt(1);
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            dispose();
        }
    }
    
    public class GuestActionEventHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	guestLogin = true;
        	dispose();
        }
    }
    
    private static void createConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // Get a connection
            conn = DriverManager.getConnection(dbURL);
        } catch (Exception except) {
            except.printStackTrace();
        }
    }

    private static void shutdown() {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
            if (results != null) {
                results.close();
            }
        } catch (SQLException sqlExcept) {
        }
    }
}
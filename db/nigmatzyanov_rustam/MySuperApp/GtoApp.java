package myapp;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class GtoApp extends JFrame {
    // for DB
    private static String dbURL = "jdbc:mysql://localhost:3306/gto?user=root&password=root";
    private static Connection conn = null; // переменная, которая хранит подключение к БД
    private static Statement stmt = null; // переменная для того, чтобы делать запросы к БД
    static ArrayList<String> tableNames; // список таблиц БД
    static ResultSet results = null;
    // формат даты для добавления в БД
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
    // массив курсов для 1 и 4 вкладки
    Integer[] courses = { null, 1, 2, 3, 4, 5 };
    // вкладки
    static JTabbedPane jtp;
    // общие панели для вкладок
    JPanel addStudentPanel, addResultPanel, exercisePanel, studentsPanel, resultsPanel;
    // для вкладки "Добавить студента" 1
    JTextField tStCard1, tSname1, tName1, tPatr1, tGroupNum1;
    JFormattedTextField tBirthday1;
    JComboBox cGender1, cFaculty1, cCourse1;
    JButton bAdd1;
    // для вкладки "Добавить результат" 2
    JTextField tStCard2;
    JComboBox cGender2, cExercise2;
    JFormattedTextField tResult2;
    JButton bAdd2;
    // для вкладки "Нормативы" 3
    JComboBox cForWhom;
    JTable exerciseTable;
    JScrollPane exerciseJsp;
    // для вкладки "Студенты" 4
    JTextField tStCard4, tSname4, tName4, tPatr4, tGroupNum4;
    JFormattedTextField tBirthday4;
    JComboBox cGender4, cFaculty4, cCourse4, cBadge4;
    JButton bSearch4;
    JTable studentsTable;
    JScrollPane studentsJsp;
    // для вкладки "Результаты" 5
    JTextField tStCard5;
    JButton bSearch5;
    JTable resultsTable;
    JScrollPane resultsJsp;
    // ссылка на объект нашего класса
    GtoApp jframe = this;

    GtoApp(String s) throws SQLException {
        super(s);
        setSize(650, 500);
        setVisible(true);
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                shutdown();
                System.exit(0);
            }
        });
        // создаём окно входа
        LoginWin d = new LoginWin(this, "Авторизация"); // создаём модальное окно
        d.setVisible(true);
        // шрифты
        Font fjtp = new Font("Arial", Font.BOLD, 11); // шрифт для вкладок
        Font f = new Font("Calibri", Font.BOLD, 16); // шрифт для 1-3, 5 вкладок
        Font f4 = new Font("Calibri", Font.BOLD, 14); // шрифт для 4 вкладки

        // подключаемся к БД
        createConnection();

        jtp = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
        jtp.setFont(fjtp);
        add(jtp);

        //1**********вкладка "Добавить студента"
        addStudentPanel = new JPanel(new BorderLayout()); // общая панель
//        jtp.add("Добавить студента", addStudentPanel);

        // лейблы и текстовые поля
        JLabel lStCard1 = new JLabel("№ студенческого билета:", JLabel.RIGHT); lStCard1.setFont(f);
        JLabel lSname1 = new JLabel("Фамилия:", JLabel.RIGHT); lSname1.setFont(f);
        JLabel lName1 = new JLabel("Имя:", JLabel.RIGHT); lName1.setFont(f);
        JLabel lPatr1 = new JLabel("Отчество:", JLabel.RIGHT); lPatr1.setFont(f);
        JLabel lBirthday1 = new JLabel("Дата рождения:", JLabel.RIGHT); lBirthday1.setFont(f);
        JLabel lGender1 = new JLabel("Пол:", JLabel.RIGHT); lGender1.setFont(f);
        JLabel lFaculty1 = new JLabel("Факультет:", JLabel.RIGHT); lFaculty1.setFont(f);
        JLabel lGroupNum1 = new JLabel("Номер группы:", JLabel.RIGHT); lGroupNum1.setFont(f);
        JLabel lCourse1 = new JLabel("Курс:", JLabel.RIGHT); lCourse1.setFont(f);
        tStCard1 = new JTextField(15);
        tSname1 = new JTextField();
        tName1 = new JTextField();
        tPatr1 = new JTextField();
        DateFormat nf1 = DateFormat.getDateInstance(); // формат записи для поля (можно вводить тольку дату)
        tBirthday1 = new JFormattedTextField(nf1);
        tBirthday1.setToolTipText("формат ввода: dd.MM.yyyy"); // доб. подсказку
        cGender1 = new JComboBox(); cGender1.addItem("мужской"); cGender1.addItem("женский");
        cFaculty1 = new JComboBox(); cFaculty1.addItem("");
        // заполняем выпадающий список факультетов данными из БД
        try {
        	stmt = conn.createStatement();
            results = stmt.executeQuery("call get_faculties()");
            while (results.next())
                cFaculty1.addItem(results.getObject(2)); // добавляем имя факультета в выпад. список
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        tGroupNum1 = new JTextField();
        cCourse1 = new JComboBox(courses); cCourse1.removeItemAt(0);

        // панель для лейблов и текстовых полей
        JPanel addStudentP1 = new JPanel(new GridLayout(9, 2, 10, 15));
        addStudentP1.add(lStCard1); addStudentP1.add(tStCard1);
        addStudentP1.add(lSname1); addStudentP1.add(tSname1);
        addStudentP1.add(lName1); addStudentP1.add(tName1);
        addStudentP1.add(lPatr1); addStudentP1.add(tPatr1);
        addStudentP1.add(lBirthday1); addStudentP1.add(tBirthday1);
        addStudentP1.add(lGender1); addStudentP1.add(cGender1);
        addStudentP1.add(lFaculty1); addStudentP1.add(cFaculty1);
        addStudentP1.add(lGroupNum1); addStudentP1.add(tGroupNum1);
        addStudentP1.add(lCourse1); addStudentP1.add(cCourse1);
        JPanel addStudentP = new JPanel(); // панель для центр-го расп-я
        addStudentP.add(addStudentP1);

        // кнопка
        bAdd1 = new JButton("Добавить");
        bAdd1.addActionListener(new AddStudentActionEventHandler());
        JPanel panelbAdd1 = new JPanel(); // панель для центр-го расп-я кнопки
        panelbAdd1.add(bAdd1);

        // добавляем панели в общую панель
        addStudentPanel.add(addStudentP, BorderLayout.NORTH); // доб. панель для лейблов и текст.п. в общую панель
        addStudentPanel.add(panelbAdd1, BorderLayout.SOUTH); // доб. кнопку в общую панель
        //1**********конец

        //2**********вкладка "Добавить результат"
        addResultPanel = new JPanel(new BorderLayout()); // общая панель

        // лейблы и текстовые поля
        JLabel lStCard2 = new JLabel("№ студенческого билета:", JLabel.RIGHT); lStCard2.setFont(f);
        JLabel lGender2 = new JLabel("Пол:", JLabel.RIGHT); lGender2.setFont(f);
        JLabel lExercise2 = new JLabel("Испытание:", JLabel.RIGHT); lExercise2.setFont(f);
        JLabel lResult2 = new JLabel("Результат:", JLabel.RIGHT); lResult2.setFont(f);
        tStCard2 = new JTextField(21);
        cGender2 = new JComboBox(); cGender2.addItem("мужской"); cGender2.addItem("женский"); cGender2.setSelectedItem(null);
        cGender2.addActionListener(new GenderItemActionEventHandler());
        cExercise2 = new JComboBox();
        NumberFormat nf2 = NumberFormat.getNumberInstance(); // формат записи для поля (только цифры)
        nf2.setMaximumFractionDigits(2); // кол-во цифр после запятой
        tResult2 = new JFormattedTextField(nf2); tResult2.setValue(1); tResult2.setText("");

        // панель для лейблов и текстовых полей
        JPanel addResultP1 = new JPanel(new GridLayout(5, 2, 10, 15));
        addResultP1.add(new JLabel()); addResultP1.add(new JLabel());
        addResultP1.add(lStCard2); addResultP1.add(tStCard2);
        addResultP1.add(lGender2); addResultP1.add(cGender2);
        addResultP1.add(lExercise2); addResultP1.add(cExercise2);
        addResultP1.add(lResult2); addResultP1.add(tResult2);
        JPanel addResultP = new JPanel(); // панель для центр-го расп-я
        addResultP.add(addResultP1);

        // кнопка
        bAdd2 = new JButton("Добавить");
        bAdd2.addActionListener(new AddResultActionEventHandler());
        JPanel panelbAdd2 = new JPanel(); // панель для центр-го расп-я кнопки
        panelbAdd2.add(bAdd2);

        // добавляем панели в общую панель
        addResultPanel.add(addResultP, BorderLayout.NORTH); // доб. панель для лейблов и текст.п. в общую панель
        addResultPanel.add(panelbAdd2, BorderLayout.SOUTH); // доб. кнопку в общую панель
        //2**********конец

        //3**********вкладка "Нормативы"
        exercisePanel = new JPanel(new BorderLayout()); // общая панель

        // лейбл и выпадающий список
        JLabel lExercise3 = new JLabel("Испытания и нормативы"); lExercise3.setFont(f);
        cForWhom = new JComboBox(); cForWhom.addItem("Испытания для мужчин"); cForWhom.addItem("Испытания для женщин");
        cForWhom.setSelectedItem(null);
        cForWhom.addActionListener(new ForWhomItemActionEventHandler()); // добавляем listener для обработки выбора пункта

        // бокс для лейбла и выпад.списка
        Box exerciseP = Box.createVerticalBox();
        exerciseP.add(new JLabel(" ")); // для отступа сверху
        Box lExercise3Box = Box.createHorizontalBox(); // бокс для центр-го расп-я лейбла
        lExercise3Box.add(lExercise3);
        exerciseP.add(lExercise3Box); // доб.
        JPanel cForWhomPanel = new JPanel(); // панель для стандартных размеров выпад. списка
        cForWhomPanel.add(cForWhom);
        exerciseP.add(cForWhomPanel); // доб.

        // добавляем бокс в общую панель
        exercisePanel.add(exerciseP, BorderLayout.NORTH);
        //3**********конец

        //4**********вкладка "Студенты"
        studentsPanel = new JPanel(new BorderLayout()); // общая панель

        // лейблы и текстовые поля
        JLabel lStCard4 = new JLabel("№ студ. билета:", JLabel.RIGHT); lStCard4.setFont(f4);
        JLabel lSname4 = new JLabel("Фамилия:", JLabel.RIGHT); lSname4.setFont(f4);
        JLabel lName4 = new JLabel("Имя:", JLabel.RIGHT); lName4.setFont(f4);
        JLabel lPatr4 = new JLabel("Отчество:", JLabel.RIGHT); lPatr4.setFont(f4);
        JLabel lBirthday4 = new JLabel("Дата рождения:", JLabel.RIGHT); lBirthday4.setFont(f4);
        JLabel lGender4 = new JLabel("Пол:", JLabel.RIGHT); lGender4.setFont(f4);
        JLabel lFaculty4 = new JLabel("Факультет:", JLabel.RIGHT); lFaculty4.setFont(f4);
        JLabel lGroupNum4 = new JLabel("Номер группы:", JLabel.RIGHT); lGroupNum4.setFont(f4);
        JLabel lCourse4 = new JLabel("Курс:", JLabel.RIGHT); lCourse4.setFont(f4);
        JLabel lBadge4 = new JLabel("Значок:", JLabel.RIGHT); lBadge4.setFont(f4);
        tStCard4 = new JTextField();
        tSname4 = new JTextField();
        tName4 = new JTextField();
        tPatr4 = new JTextField();
        DateFormat nf4 = DateFormat.getDateInstance(); // формат записи для поля (можно вводить тольку дату)
        tBirthday4 = new JFormattedTextField(nf4);
        tBirthday4.setToolTipText("формат ввода: dd.MM.yyyy"); // доб. подсказку
        tBirthday4.addFocusListener(new FocusListener() { // при фокусе поле ввода очищается
            public void focusGained(FocusEvent arg0) {
                tBirthday4.setValue(null);
            }
            public void focusLost(FocusEvent arg0) {
            }
        });
        cGender4 = new JComboBox(); cGender4.addItem(""); cGender4.addItem("мужской"); cGender4.addItem("женский");
        cFaculty4 = new JComboBox(); cFaculty4.addItem("");
        // заполняем выпадающий список факультетов данными из БД
        try {
        	stmt = conn.createStatement();
            results = stmt.executeQuery("call get_faculties()");
            while (results.next())
                cFaculty4.addItem(results.getObject(2)); // добавляем имя факультета в выпад. список
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        tGroupNum4 = new JTextField();
        cCourse4 = new JComboBox(courses);
        cBadge4 = new JComboBox(); cBadge4.addItem(""); cBadge4.addItem("бронзовый"); cBadge4.addItem("серебряный");
        cBadge4.addItem("золотой");

        // панель для лейблов и текстовых полей
        JPanel studentP1 = new JPanel(new GridLayout(5, 4, 5, 10));
        studentP1.add(lStCard4); studentP1.add(tStCard4);
        studentP1.add(lGender4); studentP1.add(cGender4);
        studentP1.add(lSname4); studentP1.add(tSname4);
        studentP1.add(lFaculty4); studentP1.add(cFaculty4);
        studentP1.add(lName4); studentP1.add(tName4);
        studentP1.add(lGroupNum4); studentP1.add(tGroupNum4);
        studentP1.add(lPatr4); studentP1.add(tPatr4);
        studentP1.add(lCourse4); studentP1.add(cCourse4);
        studentP1.add(lBirthday4); studentP1.add(tBirthday4);
        studentP1.add(lBadge4); studentP1.add(cBadge4);
        JPanel studentP = new JPanel(); // панель для центр-го расп-я
        studentP.add(studentP1);

        // кнопка
        bSearch4 = new JButton("Поиск");
        bSearch4.addActionListener(new SearchStudentActionEventHandler());
        JPanel panelbSearch4 = new JPanel(); // панель для станд. размеров кнопки
        panelbSearch4.add(bSearch4);

        Box studentsBox = Box.createVerticalBox(); // бокс для панелей
        studentsBox.add(studentP); studentsBox.add(panelbSearch4);

        // добавляем бокс в общую панель
        studentsPanel.add(studentsBox, BorderLayout.NORTH); // добавляем бокс в общую панель
        //4**********конец

        //5**********вкладка "Результаты"
        resultsPanel = new JPanel(new BorderLayout()); // общая панель

        // лейблы и текстовые поля
        JLabel lStCard5 = new JLabel("№ студенческого билета:", JLabel.RIGHT); lStCard5.setFont(f);
        tStCard5 = new JTextField();

        // панель для лейблов и текстовых полей
        JPanel resultP1 = new JPanel(new GridLayout(2, 2, 5, 0));
        resultP1.add(new JLabel()); resultP1.add(new JLabel());
        resultP1.add(lStCard5); resultP1.add(tStCard5);
        JPanel resultP = new JPanel(); // панель для центр-го расп-я
        resultP.add(resultP1);

        // кнопка
        bSearch5 = new JButton("Поиск");
        bSearch5.addActionListener(new SearchResultActionEventHandler());
        JPanel panelbSearch5 = new JPanel(); // панель для центр-го расп-я кнопки
        panelbSearch5.add(bSearch5);

        Box resultsBox = Box.createVerticalBox(); // бокс для панелей
        resultsBox.add(resultP); resultsBox.add(panelbSearch5);

        // добавляем бокс в общую панель
        resultsPanel.add(resultsBox, BorderLayout.NORTH); // добавляем бокс в общую панель
        //5**********конец
        
        // добавляем вкладки на панель в зависимости от того, кто вошёл в систему
        if (LoginWin.teacherLogin == true) { // если вошёл препод
        	jtp.add("Добавить студента", addStudentPanel);
        	jtp.add("Добавить результат", addResultPanel);
        	jtp.add("Нормативы", exercisePanel);
        	jtp.add("Студенты", studentsPanel);
        	jtp.add("Результаты", resultsPanel);
        }
        if (LoginWin.studentLogin == true) { // если вошёл студент
        	jtp.add("Нормативы", exercisePanel);
        	
        	// изменяем вкладку "Студенты"
        	jtp.add("Мои данные", studentsPanel);
        	studentsBox.removeAll();
            // новая кнопка
            JButton bSearch44 = new JButton("Показать");
            bSearch44.addActionListener(new ActionListener () {
				public void actionPerformed(ActionEvent arg0) {
		            if (studentsPanel.getComponentCount() == 2) // если уже была создана таблица
		                studentsPanel.remove(studentsJsp); // удаляем старую таблицу
					try {
						stmt = conn.createStatement();
		                results = stmt.executeQuery("call get_student_on_id(" + LoginWin.student_id + ")");
		                studentsTable = new JTable(new StudentsTableModel(results));
		            } catch (SQLException e1) {
		                e1.printStackTrace();
		            }
		            studentsJsp = new JScrollPane(studentsTable);
		            studentsPanel.add(studentsJsp); // добавляем панель прокрутки в общую панель
		            studentsPanel.revalidate(); // обновить панель
				}
            });
            JPanel panelbSearch44 = new JPanel(); // панель для станд. размеров кнопки
            panelbSearch44.add(bSearch44);
            studentsBox.add(panelbSearch44);
            
        	// изменяем вкладку "Результы"
        	jtp.add("Результаты сдачи", resultsPanel);
        	resultsBox.removeAll();
            // новая кнопка
            JButton bSearch55 = new JButton("Показать");
            bSearch55.addActionListener(new ActionListener () {
				public void actionPerformed(ActionEvent arg0) {
		            if (resultsPanel.getComponentCount() == 2) // если уже была создана таблица
		                resultsPanel.remove(resultsJsp); // удаляем старую таблицу
		            try {
		            	stmt = conn.createStatement();
		                results = stmt.executeQuery("call get_results_on_studentid(" + LoginWin.student_id + ")");
		                resultsTable = new JTable(new ResultsTableModel(results));
		            } catch (SQLException e1) {
		                e1.printStackTrace();
		            }
		            resultsJsp = new JScrollPane(resultsTable);
		            resultsPanel.add(resultsJsp); // добавляем панель прокрутки в общую панель
		            resultsPanel.revalidate(); // обновить панель
				}
            });
            JPanel panelbSearch55 = new JPanel(); // панель для станд. размеров кнопки
            panelbSearch55.add(bSearch55);
            resultsBox.add(panelbSearch55);
        }
        if (LoginWin.guestLogin == true) { // если вошёл гость
        	jtp.add("Нормативы", exercisePanel);
        }  	
    }

    public class AddStudentActionEventHandler implements ActionListener { // вкладка 1
        public void actionPerformed(ActionEvent e) {
            // проверка полей на пустоту (создаём диалоговое окно)
            if(tStCard1.getText().equals("") || tSname1.getText().equals("") ||
                    tName1.getText().equals("") || tPatr1.getText().equals("") ||
                    tBirthday1.getText().equals("") || cFaculty1.getSelectedItem().equals("") ||
                    tGroupNum1.getText().equals("")) {
                JOptionPane.showMessageDialog(jframe, "Заполните пустые поля.", "Предупреждение",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            // проверка на дубликат № студ. билета с уже существующим № ст. билета из БД
            try {
            	stmt = conn.createStatement();
                results = stmt.executeQuery("call get_students()");
                while (results.next())
                    if (tStCard1.getText().equals(results.getString(2))) {
                    	JOptionPane.showMessageDialog(jframe, "Данный студент уже есть в базе данных.", "Ошибка",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            // диалоговое окно для подтверждения добавления
            int n = JOptionPane.showConfirmDialog(jframe, "Добавить нового студента в базу данных?",
                    "Добавление", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            switch(n) {
                case JOptionPane.YES_OPTION:
                    // вычисляем id для нового студента
                    int id = 1;
                    try {
                        id = getStudentsRowCount() + 1;
                    } catch (SQLException e2) {
                        e2.printStackTrace();
                    }
                    String birthday = sdf.format(tBirthday1.getValue()); // конвертируем дату в нужный формат (YYYY-MM-DD)
                    String gender = "m";
                    if (cGender1.getSelectedItem().equals("женский")) gender = "f";
                    // добавляем студента в таблицу STUDENTS в БД
                    try {
                    	stmt = conn.createStatement();
                        stmt.execute("call insert_student(" + id + ",'" + tStCard1.getText() + "','" +
                                tSname1.getText() + "','" + tName1.getText() + "','" + tPatr1.getText() + "','" +
                                birthday + "','" + gender + "','" + cFaculty1.getSelectedIndex() +
                                "','" + tGroupNum1.getText() + "'," + cCourse1.getSelectedItem() + ")");
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    // устанавливаем начальные значения после добавления
                    tStCard1.setText("");
                    tSname1.setText("");
                    tName1.setText("");
                    tPatr1.setText("");
                    tBirthday1.setValue(null);
                    cGender1.setSelectedItem("мужской");
                    tGroupNum1.setText("");
                    cCourse1.setSelectedItem(1);
                    break;
            }
        }
    }

    public class AddResultActionEventHandler implements ActionListener { // вкладка 2
        public void actionPerformed(ActionEvent e) {
            // проверка полей на пустоту (создаём диалоговое окно)
            if(tStCard2.getText().equals("") || cGender2.getSelectedItem() == null ||
                    cExercise2.getSelectedItem() == null || tResult2.getText().equals("")) {
                JOptionPane.showMessageDialog(jframe, "Заполните пустые поля.", "Предупреждение",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            // диалоговое окно для подтверждения добавления
            int n = JOptionPane.showConfirmDialog(jframe, "Добавить результат в базу данных?",
                    "Добавление", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            switch(n) {
                case JOptionPane.YES_OPTION:
                    // получить id студента по № студенческого билета
                    int student_id = -1;
                    try {
                    	stmt = conn.createStatement();
                        results = stmt.executeQuery("call get_student_on_studentcard(" +
                                "'" + tStCard2.getText() + "')");
                        if (results.next()) // если непустая строка
                            student_id = results.getInt(1); // берём id из строки
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    // если студента с таким № ст. билета не существует, то выводим окно
                    if(student_id == -1) {
                        JOptionPane.showMessageDialog(jframe, "Данный студент не зарегистрирован.",
                                "Ошибка", JOptionPane.ERROR_MESSAGE);
                        tStCard2.setText("");
                        return;
                    }
                    // вычисляем id выбранного испытания
                    int discipline_id = 1;
                    if (cGender2.getSelectedItem() == "мужской")
                        discipline_id = cExercise2.getSelectedIndex() + 1; // индекс упр-я для мужчин
                    else
                        discipline_id = cExercise2.getSelectedIndex() + 6; // индекс упр-я для женщин
                    // проверка на дубликат одного и того же результата
                    try {
                    	stmt = conn.createStatement();
                        results = stmt.executeQuery("call get_tests()");
                        while (results.next()) {
                        	if (student_id == results.getInt(1) && discipline_id == results.getInt(2)) {
                            	JOptionPane.showMessageDialog(jframe, "Данный результат уже записан.", "Ошибка",
                                        JOptionPane.ERROR_MESSAGE);
                            	cExercise2.setSelectedItem(null);
                                tResult2.setText("");
                                return;
                        	}
                        }
                           
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    // добавляем результат в таблицу TESTS в БД
                    try {
                    	stmt = conn.createStatement();
                        stmt.execute("call insert_test(" + student_id + "," + discipline_id + "," +
                                tResult2.getValue() + ")");
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    // устанавливаем начальные значения после добавления
                    cExercise2.setSelectedItem(null);
                    tResult2.setText("");
                    break;
            }
        }
    }

    // кол-во строк в таблице STUDENTS
    public static int getStudentsRowCount() throws SQLException { // вкладка 1 (доп.)
    	stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("call get_students()"); // мнв строк
        int rowCount = 0;

        if (rs.first()) {// если есть хотя бы 1 строка
            rowCount = 1;
            while (rs.next())
                rowCount++;
        }
        rs.close();
        return rowCount;
    }

    public class GenderItemActionEventHandler implements ActionListener { // вкладка 2 (доп.)
        public void actionPerformed(ActionEvent e) {
            switch (cGender2.getSelectedIndex()) {
                case 0:
                    cExercise2.removeAllItems();
                    cExercise2.addItem("Бег на 100 м (сек.)");
                    cExercise2.addItem("Бег на 3 км (мин., сек.)");
                    cExercise2.addItem("Прыжок в длину с места (см)");
                    cExercise2.addItem("Подтягивания (кол-во раз)");
                    cExercise2.addItem("Наклон вперёд из положения стоя (см)");
                    break;
                case 1:
                    cExercise2.removeAllItems();
                    cExercise2.addItem("Бег на 100 м (сек.)");
                    cExercise2.addItem("Бег на 2 км (мин., сек.)");
                    cExercise2.addItem("Прыжок в длину с места (см)");
                    cExercise2.addItem("Отжимания от пола (кол-во раз)");
                    cExercise2.addItem("Наклон вперёд из положения стоя (см)");
                    break;
            }
        }
    }

    public class ForWhomItemActionEventHandler implements ActionListener { // вкладка 3
        public void actionPerformed(ActionEvent e) {
            switch (cForWhom.getSelectedIndex()) {
                case 0:
                    if (exercisePanel.getComponentCount() == 2)
                        exercisePanel.remove(exerciseJsp); // удаляем старую таблицу
                    try {
                    	stmt = conn.createStatement();
                        results = stmt.executeQuery("call get_disciplines_for_men()");
                        exerciseTable = new JTable(new ExerciseTableModel(results));
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    exerciseJsp = new JScrollPane(exerciseTable);
                    exercisePanel.add(exerciseJsp); // добавляем панель прокрутки в общую панель
                    exercisePanel.revalidate(); // обновить панель
                    break;
                case 1:
                    if (exercisePanel.getComponentCount() == 2)
                        exercisePanel.remove(exerciseJsp); // удаляем старую таблицу
                    try {
                    	stmt = conn.createStatement();
                        results = stmt.executeQuery("call get_disciplines_for_women()");
                        exerciseTable = new JTable(new ExerciseTableModel(results));
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    exerciseJsp = new JScrollPane(exerciseTable);
                    exercisePanel.add(exerciseJsp); // добавляем панель прокрутки в общую панель
                    exercisePanel.revalidate(); // обновить панель
                    break;
            }
        }
    }

    public class SearchStudentActionEventHandler implements ActionListener { // вкладка 4
        public void actionPerformed(ActionEvent e) {
            if (studentsPanel.getComponentCount() == 2) // если уже была создана таблица
                studentsPanel.remove(studentsJsp); // удаляем старую таблицу
            // изменяем параметры для процедуры call get_students
            String birthday4 = "";
            if (tBirthday4.getValue() != null)
                birthday4 = sdf.format(tBirthday4.getValue()); // конвертируем дату в нужный формат (YYYY-MM-DD)
            String gender4 = "";
            if (cGender4.getSelectedItem().equals("мужской")) gender4 = "m";
            if (cGender4.getSelectedItem().equals("женский")) gender4 = "f";
            String badge4 = null;
            if (cBadge4.getSelectedItem().equals("бронзовый")) badge4 = "bronze";
            if (cBadge4.getSelectedItem().equals("серебряный")) badge4 = "silver";
            if (cBadge4.getSelectedItem().equals("золотой")) badge4 = "gold";
            try {
            	stmt = conn.createStatement();
                results = stmt.executeQuery("call get_students_on_params(" + "'" + tStCard4.getText() + "','" +
                        tSname4.getText() + "','" + tName4.getText() + "','" + tPatr4.getText() + "','" +
                        birthday4 + "','" + gender4 + "','" + cFaculty4.getSelectedIndex() + "','" +
                        tGroupNum4.getText() + "'," + cCourse4.getSelectedItem() + ",'" +
                        badge4 + "'" + ")");
                studentsTable = new JTable(new StudentsTableModel(results));
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            studentsJsp = new JScrollPane(studentsTable);
            studentsPanel.add(studentsJsp); // добавляем панель прокрутки в общую панель
            studentsPanel.revalidate(); // обновить панель
        }
    }

    public class SearchResultActionEventHandler implements ActionListener { // вкладка 5
        public void actionPerformed(ActionEvent e) {
            // проверка полей на пустоту (создаём диалоговое окно)
            if(tStCard5.getText().equals("")) {
                JOptionPane.showMessageDialog(jframe, "Введите № студенческого билета.", "Предупреждение",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            //******* получить id студента по № студенческого билета
            int student_id = -1;
            try {
            	stmt = conn.createStatement();
                results = stmt.executeQuery("call get_student_on_studentcard(" +
                        "'" + tStCard5.getText() + "')");
                if (results.next()) // если непустая строка
                    student_id = results.getInt(1); // берём id из строки
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            // если студента с таким № ст. билета не существует, то выводим окно
            if(student_id == -1) {
                JOptionPane.showMessageDialog(jframe, "Данный студент не зарегистрирован.",
                        "Ошибка", JOptionPane.ERROR_MESSAGE);
                tStCard5.setText("");
                return;
            }
            //******* таблица
            if (resultsPanel.getComponentCount() == 2) // если уже была создана таблица
                resultsPanel.remove(resultsJsp); // удаляем старую таблицу
            try {
            	stmt = conn.createStatement();
                results = stmt.executeQuery("call get_results_on_studentid(" + student_id + ")");
                resultsTable = new JTable(new ResultsTableModel(results));
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            resultsJsp = new JScrollPane(resultsTable);
            resultsPanel.add(resultsJsp); // добавляем панель прокрутки в общую панель
            resultsPanel.revalidate(); // обновить панель
        }
    }

    private static void createConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // Get a connection
            conn = DriverManager.getConnection(dbURL);
            System.out.println("Connection established");
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
            System.out.println("Connection interrupted");
        } catch (SQLException sqlExcept) {
        }
    }

    public static void main(String[] args) throws SQLException {
        new GtoApp("ГТО");
    }
}
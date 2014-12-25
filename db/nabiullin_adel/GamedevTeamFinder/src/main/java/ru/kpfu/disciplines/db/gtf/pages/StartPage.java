package ru.kpfu.disciplines.db.gtf.pages;

import ru.kpfu.disciplines.db.gtf.GamedevTeamFinder;
import ru.kpfu.disciplines.db.gtf.MainFrame;
import ru.kpfu.disciplines.db.gtf.gtfMenuBar;
import ru.kpfu.disciplines.db.gtf.helpers.ConnectorDB;
import ru.kpfu.disciplines.db.gtf.helpers.HashSumCreator;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StartPage extends JPanel {
    private ConnectorDB connector = null;
    private static java.util.List<JTextField> fieldsList;
    private static String currentUser;

    public static String getCurrentUser() {
        return currentUser;
    }

    public StartPage(ConnectorDB connectorDB) {
        super();
        connector = connectorDB;
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        Box horizontalBox = Box.createHorizontalBox();
        add(horizontalBox);
        Box verticalBox = Box.createVerticalBox();
        horizontalBox.add(verticalBox);

        verticalBox.add(createTopText());
        verticalBox.add(createNewsTable());

        horizontalBox.add(createLogPassPanel());
    }

    // создание заголовка на стартовой странице
    private JTextPane createTopText() {
        JTextPane topText = new JTextPane();

        topText.setText("The best way to assemble a team\n" +
                "for the joint development of games.");
        topText.setEditable(false);
        topText.setPreferredSize(new Dimension(600, 300));

        topText.setBackground(GamedevTeamFinder.DARK);
        topText.setForeground(GamedevTeamFinder.LIGHT);
        Font topTextFont = new Font("topTextFont", Font.PLAIN, 24);
        topText.setFont(topTextFont);

        return topText;
    }

    // создание новостной панели
    private JPanel createNewsTable() {
        JPanel newsTable = new JPanel();

        // добавление заголовка новостной ленты
        JPanel forLabel = new JPanel();
        JLabel newsLabel = new JLabel("News Table");
        Font labelFont = new Font("labelFont", Font.BOLD, 20);
        newsLabel.setForeground(GamedevTeamFinder.DARK);
        newsLabel.setFont(labelFont);
        forLabel.add(newsLabel);
        newsTable.add(forLabel);

        // добавление области с прокруткой для новостей
        JPanel forScroll = new JPanel();
        forScroll.setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane();
        forScroll.add(scrollPane);
        newsTable.add(forScroll);

        newsTable.setPreferredSize(new Dimension(600, 500));
        newsTable.setLayout(new BoxLayout(newsTable, BoxLayout.PAGE_AXIS));

        return newsTable;
    }

    // создание панели для регистрации и входа в аккаунт
    private JPanel createLogPassPanel() {
        final JPanel getStarted = new JPanel();
        getStarted.setPreferredSize(new Dimension(600, 800));

        // добавление меню, всплывающего при неудачной аутентификации
        final JPopupMenu wrongLoginPopup = new JPopupMenu();
        wrongLoginPopup.add(" You've entered wrong name/password =(");
        wrongLoginPopup.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                wrongLoginPopup.setVisible(false);
            }
        });

        // добавление меню, всплывающего при введении некорректных данных при регистрации
        final JPopupMenu wrongSignUpPopup = new JPopupMenu();
        wrongSignUpPopup.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                wrongSignUpPopup.setVisible(false);
                wrongSignUpPopup.removeAll();
            }
        });

        // добавление окошка входа в систему
        JPanel forEnter = new JPanel();
        getStarted.add(forEnter);
        forEnter.setLayout(new GridLayout(3, 2, 12, 50));
        forEnter.setPreferredSize(new Dimension(550, 250));
        forEnter.setLocation(25, 25);
        forEnter.setBorder(new LineBorder(GamedevTeamFinder.LIGHT, 2, true));

        // добавление компонентов в окно входа в систему
        final JLabel enteringName = new JLabel("Name:", SwingConstants.RIGHT);
        forEnter.add(enteringName);
        final JTextField enteringNameField = new JTextField();
        forEnter.add(enteringNameField);
        final JLabel enteringPassword = new JLabel("Password:", SwingConstants.RIGHT);
        forEnter.add(enteringPassword);
        final JPasswordField enteringPasswordField = new JPasswordField();
        forEnter.add(enteringPasswordField);
        forEnter.add(new JPanel());
        JPanel forLogin = new JPanel();
        final JButton login = new JButton("Log In");
        forLogin.add(login);
        forEnter.add(forLogin);

        // редактирование компонентов окна входа в систему
        Font font = new Font("labelsFont", Font.BOLD, 15);
        enteringName.setFont(font);
        enteringName.setForeground(GamedevTeamFinder.DARK);
        enteringPassword.setFont(font);
        enteringPassword.setForeground(GamedevTeamFinder.DARK);
        enteringNameField.setBackground(GamedevTeamFinder.DARK);
        enteringNameField.setForeground(GamedevTeamFinder.LIGHT);
        enteringPasswordField.setBackground(GamedevTeamFinder.DARK);
        enteringPasswordField.setForeground(GamedevTeamFinder.LIGHT);
        login.setFont(font);
        login.setBackground(GamedevTeamFinder.DARK);
        login.setForeground(GamedevTeamFinder.LIGHT);

        // добавление окошка для регистрации
        JPanel forRegistration = new JPanel();
        getStarted.add(forRegistration);
        forRegistration.setLayout(new BoxLayout(forRegistration, BoxLayout.PAGE_AXIS));
        forRegistration.setPreferredSize(new Dimension(550, 450));
        forRegistration.setLocation(25, 325);
        forRegistration.setBorder(new LineBorder(GamedevTeamFinder.DARK, 2, true));

        // добавление основных компонентов в окно регистрации
        JPanel forStart = new JPanel();
        forRegistration.add(forStart);
        JLabel startLabel = new JLabel("Get Started!");
        forStart.add(startLabel);
        JPanel registrationPanel = new JPanel();
        forRegistration.add(registrationPanel);
        registrationPanel.setLayout(new GridLayout(5, 2, 12, 30));
        // добавление лейблов и полей для ввода в окно регистрации
        JLabel signingName = new JLabel("Name:", SwingConstants.RIGHT);
        registrationPanel.add(signingName);
        final JTextField signingNameField = new JTextField();
        registrationPanel.add(signingNameField);
        JLabel signingEmail = new JLabel("Email:", SwingConstants.RIGHT);
        registrationPanel.add(signingEmail);
        final JTextField signingEmailField = new JTextField();
        registrationPanel.add(signingEmailField);
        JLabel signingPassword = new JLabel("Password:", SwingConstants.RIGHT);
        registrationPanel.add(signingPassword);
        final JPasswordField signingPasswordField = new JPasswordField();
        registrationPanel.add(signingPasswordField);
        JLabel signingPassConfirm = new JLabel("Confirm password:", SwingConstants.RIGHT);
        registrationPanel.add(signingPassConfirm);
        final JPasswordField signingPassConfirmField = new JPasswordField();
        registrationPanel.add(signingPassConfirmField);
        registrationPanel.add(new JPanel());
        JPanel signPanel = new JPanel();
        registrationPanel.add(signPanel);
        final JButton signUp = new JButton("Sign up now - it's free!");
        signPanel.add(signUp);

        // редактирование компонентов окна регистрации
        Font startTextFont = new Font("topTextFont", Font.BOLD, 26);
        startLabel.setFont(startTextFont);
        startLabel.setForeground(GamedevTeamFinder.DARK);
        signingName.setFont(font);
        signingName.setForeground(GamedevTeamFinder.DARK);
        signingEmail.setFont(font);
        signingEmail.setForeground(GamedevTeamFinder.DARK);
        signingPassword.setFont(font);
        signingPassword.setForeground(GamedevTeamFinder.DARK);
        signingPassConfirm.setFont(font);
        signingPassConfirm.setForeground(GamedevTeamFinder.DARK);
        signingNameField.setBackground(GamedevTeamFinder.LIGHT);
        signingNameField.setForeground(GamedevTeamFinder.DARK);
        signingEmailField.setBackground(GamedevTeamFinder.LIGHT);
        signingEmailField.setForeground(GamedevTeamFinder.DARK);
        signingPasswordField.setBackground(GamedevTeamFinder.LIGHT);
        signingPasswordField.setForeground(GamedevTeamFinder.DARK);
        signingPassConfirmField.setBackground(GamedevTeamFinder.LIGHT);
        signingPassConfirmField.setForeground(GamedevTeamFinder.DARK);
        signUp.setFont(font);
        signUp.setBackground(GamedevTeamFinder.LIGHT);
        signUp.setForeground(GamedevTeamFinder.DARK);

        // добавление полей для ввода в список
        fieldsList = new ArrayList<JTextField>(6);
        fieldsList.add(enteringNameField);
        fieldsList.add(enteringPasswordField);
        fieldsList.add(signingNameField);
        fieldsList.add(signingEmailField);
        fieldsList.add(signingPasswordField);
        fieldsList.add(signingPassConfirmField);

        // добавление листенера кнопки "Log In"
        login.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent click) {
                String name = "'" + enteringNameField.getText() + "'";
                String pass = String.valueOf(enteringPasswordField.getPassword());
                try {
                    Connection conn = connector.getConnection();
                    Statement stmt = conn.createStatement();
                    ResultSet usersResult = stmt.executeQuery("select * from users where login=" + name);
                    Object passHash;
                    if (!usersResult.next()) {
                        wrongLoginPopup.setVisible(true);
                        wrongLoginPopup.show(login, 0, 0);
                        stmt.close();
                        return;
                    } else {
                        usersResult.first();
                        passHash = usersResult.getObject(3);
                    }
                    if (new String(HashSumCreator.createMD5(pass), "UTF-8").equals(passHash.toString())) {
                        gtfMenuBar.setNickNameOnMenu(enteringNameField.getText());
                        currentUser = enteringNameField.getText();
                        MainFrame.addOtherPages();
                        enterSystem();
                        stmt.close();
                    } else {
                        wrongLoginPopup.setVisible(true);
                        wrongLoginPopup.show(login, 0, 0);
                        stmt.close();
                    }
                } catch (SQLException sqlExcept) {
                    sqlExcept.printStackTrace();
                } catch (UnsupportedEncodingException encodeExcept) {
                    encodeExcept.printStackTrace();
                }
            }
        });

        // добавление листенера кнопки "Sign Up"
        signUp.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent click) {
                String name = signingNameField.getText();
                String email = signingEmailField.getText();
                String pass = String.valueOf(signingPasswordField.getPassword());
                String confirmPass = String.valueOf(signingPassConfirmField.getPassword());
                if(name == null || email == null || name.equals("") || email.equals("") || pass.equals("")) {
                    wrongSignUpPopup.add("Don't leave empty fields!");
                    wrongSignUpPopup.setVisible(true);
                    wrongSignUpPopup.show(signUp, 0, 0);
                    return;
                }
                boolean areWarns = false;
                if(!isValidName(name)) {
                    wrongSignUpPopup.add("Name can consist only from: A-Z,a-z,0-9 and it's length must be 4<=x<=20");
                    areWarns = true;
                }
                if(!isValidEmailAddress(email)) {
                    wrongSignUpPopup.add("Email is in the wrong format");
                    areWarns = true;
                }
                if(!isValidName(pass)) {
                    wrongSignUpPopup.add("Password can consist only from: A-Z,a-z,0-9 and it's length must be 4<=x<=20");
                    areWarns = true;
                }
                if(!pass.equals(confirmPass)) {
                    wrongSignUpPopup.add("Password confirmation failed");
                    areWarns = true;
                }
                if(areWarns) {
                    wrongSignUpPopup.setVisible(true);
                    wrongSignUpPopup.show(signUp, 0, 0);
                    return;
                }
                try {
                    Connection conn = connector.getConnection();
                    Statement stmt = conn.createStatement();
                    ResultSet suchNameUsersResult = stmt.executeQuery("call select_users_by_login('" + name + "')");
                    if(suchNameUsersResult.next()) {
                        wrongSignUpPopup.add("Such name has already been taken");
                        wrongSignUpPopup.setVisible(true);
                        wrongSignUpPopup.show(signUp, 0, 0);
                        stmt.close();
                        return;
                    }
                    ResultSet suchEmailUsersResult = stmt.executeQuery("call select_users_by_email('" + email + "')");
                    if(suchEmailUsersResult.next()) {
                        wrongSignUpPopup.add("User with such email exists");
                        wrongSignUpPopup.setVisible(true);
                        wrongSignUpPopup.show(signUp, 0, 0);
                        stmt.close();
                        return;
                    }
                    stmt.executeUpdate("call insert_user_main_data('" + name +
                            "','" + new String(HashSumCreator.createMD5(pass), "UTF-8") + "','" + email + "')");
                    gtfMenuBar.setNickNameOnMenu(name);
                    currentUser = name;
                    stmt.close();
                    MainFrame.addOtherPages();
                    enterSystem();
                } catch (SQLException sqlExcept) {
                    sqlExcept.printStackTrace();
                } catch (UnsupportedEncodingException encodeExcept) {
                    encodeExcept.printStackTrace();
                }
            }
        });
        return getStarted;
    }

    // проверка email адреса на валидность
    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }

    // проверка логина/пароля на валидность
    public static boolean isValidName(String name) {
        if(name.length() < 4 || name.length() > 20)
            return false;
        for(char character : name.toCharArray()) {
            if(!((character >= 'A' && character <= 'Z') || (character >= 'a' && character <= 'z') ||
                    (character >= '0' && character <= '9'))) {
                return false;
            }
        }
        return true;
    }

    // вход в систему (с обнулением всех полей для ввода)
    private static void enterSystem() {
        for(JTextField field : fieldsList) {
            field.setText("");
        }
        gtfMenuBar.setNavigationAndNicknameVisible(true);
        MainFrame.showWelcomePage();
    }
}
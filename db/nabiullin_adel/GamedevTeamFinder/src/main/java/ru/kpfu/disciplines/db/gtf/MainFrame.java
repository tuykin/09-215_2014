package ru.kpfu.disciplines.db.gtf;

import ru.kpfu.disciplines.db.gtf.helpers.ConnectorDB;
import ru.kpfu.disciplines.db.gtf.pages.*;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private static ConnectorDB connector = null;
    public static CardLayout cardLayout = null;
    public static JPanel panel = null;
    public static JPanel switchablePage;

    MainFrame(String title, ConnectorDB connectorDB) {
        super(title);
        connector = connectorDB;
        setGeneralParams();


        // добавление панели меню
        gtfMenuBar menu = new gtfMenuBar();
        setJMenuBar(menu);

        // задаем корневой компонент с типом размещения слоями
        cardLayout = new CardLayout();
        switchablePage = new JPanel(cardLayout);
        setContentPane(switchablePage);
        panel = switchablePage;

        // 1. добавляем стартовую страницу "Start Page"
        StartPage startPage = new StartPage(connector);
        switchablePage.add("startPage", startPage);
    }

    // задать основные параметры
    private void setGeneralParams() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setMinimumSize(new Dimension(1200, 800));
        setLocation(100, 20);
        // изменяем тему оформления приложения
        try {
            com.jtattoo.plaf.texture.TextureLookAndFeel.setTheme("Black");
            UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // метод добавления остальных страниц в мейн фрейм
    public static void addOtherPages() {

        // 2. добавляем страницу приветствия "Welcome Page"
        WelcomePage welcomePage = new WelcomePage();
        switchablePage.add("welcomePage", welcomePage);

        // 3. добавляем личный кабинет "Personal Area"
        PersonalArea personalArea = new PersonalArea(connector);
        switchablePage.add("personalArea", personalArea);

        // 4. добавляем страничку настроек, где можно редактировать информацию аккаунта "Settings Page"
        SettingsPage settingsPage = new SettingsPage(connector);
        switchablePage.add("settingsPage", settingsPage);

        // 5. добавляем почтовый ящик
        Mailbox mailbox = new Mailbox(connector);
        switchablePage.add("mailbox", mailbox);
    }

    // удаляем все странички, кроме стартовой
    public static void deleteOtherPages() {
        switchablePage.removeAll();

        StartPage startPage = new StartPage(connector);
        switchablePage.add("startPage", startPage);
    }

    // переход на стартовую страничку
    public static void showStartPage() {
        cardLayout.show(panel, "startPage");
    }

    // переход на страничку приветствия
    public static void showWelcomePage() {
        cardLayout.show(panel, "welcomePage");
    }

    // переход в личный кабинет
    public static void showPersonalArea() {
        cardLayout.show(panel, "personalArea");
    }

    // переход в меню настроек
    public static void showSettingsPage() {
        cardLayout.show(panel, "settingsPage");
    }

    // переход в меню настроек
    public static void showMailbox() {
        cardLayout.show(panel, "mailbox");
    }
}
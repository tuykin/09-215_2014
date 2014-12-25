package ru.kpfu.disciplines.db.gtf.pages;

        import ru.kpfu.disciplines.db.gtf.helpers.ConnectorDB;

        import javax.swing.*;

public class SettingsPage extends JPanel {
    private ConnectorDB connector;

    public SettingsPage(ConnectorDB connectorDB) {
        super();
        connector = connectorDB;
    }
}

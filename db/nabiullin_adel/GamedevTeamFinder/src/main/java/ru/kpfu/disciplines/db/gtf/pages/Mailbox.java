package ru.kpfu.disciplines.db.gtf.pages;

import ru.kpfu.disciplines.db.gtf.helpers.ConnectorDB;

import javax.swing.*;

public class Mailbox extends JPanel {
    private ConnectorDB connector;

    public Mailbox(ConnectorDB connectorDB) {
        super();
        connector = connectorDB;
    }
}
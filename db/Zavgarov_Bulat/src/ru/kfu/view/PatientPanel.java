package ru.kfu.view;

import ru.kfu.bean.Patient;
import ru.kfu.controller.MainController;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Bulat on 25.12.14.
 */
public class PatientPanel extends JPanel implements ListSelectionListener {

  private MainController mainController;

  private JTable patientTable;
  private JButton addButton;
  private JButton editButton;
  private JButton deleteButton;

  private JTextField filterPolisNumber;
  private JTextField filterFirstName;
  private JTextField filterSecondName;

  private JPanel panel;

  public PatientPanel(MainController mainController) {
    super();

    this.mainController = mainController;
    patientTable = new JTable(new PatientTableModel(mainController.getAllPatients(null, null, null)));
    patientTable.getSelectionModel().addListSelectionListener(this);
    patientTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

    panel = new JPanel(new BorderLayout());

    initToolBar();
    JScrollPane scrollPane = new JScrollPane(this.patientTable);
    scrollPane.setPreferredSize(new Dimension(850, 500));
    panel.add(scrollPane, BorderLayout.CENTER);
    add(panel);
  }

  private void initToolBar() {
    JToolBar toolBar = new JToolBar();

    addButton = new JButton("Добавить");
    toolBar.add(addButton);

    addButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        mainController.addNewPatient();
      }
    });

    editButton = new JButton("Редактировать");
    editButton.setEnabled(false);
    toolBar.add(editButton);
    editButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        mainController.editPatient(getSelectedItem());
      }
    });

    deleteButton = new JButton("Удалить");
    deleteButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        mainController.deletePatient(getSelectedItem());
      }
    });
    deleteButton.setEnabled(false);
    toolBar.add(deleteButton);

    toolBar.addSeparator();

    filterPolisNumber = new JTextField(10);
    toolBar.add(new JLabel("Полис"));
    toolBar.add(filterPolisNumber);

    filterFirstName = new JTextField(10);
    toolBar.add(new JLabel("Имя"));
    toolBar.add(filterFirstName);

    filterSecondName = new JTextField(10);
    toolBar.add(new JLabel("Фамилия"));
    toolBar.add(filterSecondName);


    JButton search = new JButton("Поиск");
    toolBar.add(search);

    JButton clear = new JButton("Очистить");
    toolBar.add(clear);

    search.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        refresh();
      }
    });
    clear.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        filterPolisNumber.setText(null);
        filterFirstName.setText(null);
        filterSecondName.setText(null);
        refresh();
      }
    });

    panel.add(toolBar, BorderLayout.PAGE_START);
  }

  @Override
  public void valueChanged(ListSelectionEvent e) {
    boolean isEmpty = patientTable.getSelectionModel().isSelectionEmpty();
    deleteButton.setEnabled(!isEmpty);
    editButton.setEnabled(!isEmpty);
  }

  public void refresh() {
    patientTable.setModel(new PatientTableModel(mainController.getAllPatients(filterPolisNumber.getText(), filterFirstName.getText(), filterSecondName.getText())));
  }

  private Patient getSelectedItem() {
    return ((PatientTableModel) patientTable.getModel()).get(patientTable.getSelectedRow());
  }
}

package ru.kfu.view;

import org.jdatepicker.JDateComponentFactory;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import ru.kfu.bean.Patient;
import ru.kfu.controller.MainController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by Bulat on 25.12.14.
 */
public class PatientEditDialog extends JDialog {

  private Patient patient;
  private MainController mainController;

  private JTextField firstNameField;
  private JTextField secondNameField;
  private JTextField polisNumberField;
  private JDatePickerImpl jDatePicker;

  public PatientEditDialog(final Patient profession, final MainController mainController) {
    super();
    this.patient = profession;
    this.mainController = mainController;


    setSize(500, 300);
    setModal(true);
    setLocationRelativeTo(null);
    JPanel panel = new JPanel();
    panel.setLayout(new GridBagLayout());

    panel.add(new JLabel("Имя"), new GridBagConstraints(0, 0, 1, 1, 1, 1,
        GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,
        new Insets(0, 20, 1, 1), 0, 0));
    firstNameField = new JTextField(10);
    panel.add(firstNameField, new GridBagConstraints(1, 0, 1, 1, 1, 1,
        GridBagConstraints.NORTH, GridBagConstraints.NONE,
        new Insets(0, 0, 1, 1), 0, 0));

    panel.add(new JLabel("Фамилия"), new GridBagConstraints(0, 1, 1, 1, 1, 1,
        GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,
        new Insets(0, 20, 1, 1), 0, 0));
    secondNameField = new JTextField(10);
    panel.add(secondNameField, new GridBagConstraints(1, 1, 1, 1, 1, 1,
        GridBagConstraints.NORTH, GridBagConstraints.NONE,
        new Insets(0, 0, 1, 1), 0, 0));


    panel.add(new JLabel("Номер полиса"), new GridBagConstraints(0, 2, 1, 1, 1, 1,
        GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,
        new Insets(0, 20, 1, 1), 0, 0));
    polisNumberField = new JTextField(10);
    panel.add(polisNumberField, new GridBagConstraints(1, 2, 1, 1, 1, 1,
        GridBagConstraints.NORTH, GridBagConstraints.NONE,
        new Insets(0, 0, 1, 1), 0, 0));

    panel.add(new JLabel("Дата рождения"), new GridBagConstraints(0, 3, 1, 1, 1, 1,
        GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,
        new Insets(0, 20, 1, 1), 0, 0));
    jDatePicker = (JDatePickerImpl) new JDateComponentFactory(UtilDateModel.class, null, null).createJDatePicker();
    panel.add(jDatePicker, new GridBagConstraints(1, 3, 1, 1, 1, 1,
        GridBagConstraints.NORTH, GridBagConstraints.NONE,
        new Insets(0, 0, 1, 1), 0, 0));

    JButton saveButton = new JButton("Сохранить");
    JButton cancelButton = new JButton("Отмена");

    panel.add(saveButton, new GridBagConstraints(0, 4, 1, 1, 1, 1,
        GridBagConstraints.NORTH, GridBagConstraints.NONE,
        new Insets(0, 0, 1, 1), 0, 0));

    panel.add(cancelButton, new GridBagConstraints(1, 4, 1, 1, 1, 1,
        GridBagConstraints.NORTH, GridBagConstraints.NONE,
        new Insets(0, 0, 1, 1), 0, 0));

    if (this.patient == null) {
      this.patient = new Patient();
    } else {
      firstNameField.setText(this.patient.getFirstName());
      secondNameField.setText(this.patient.getSecondName());
      polisNumberField.setText(this.patient.getPolisNumber());
      ((UtilDateModel) jDatePicker.getModel()).setValue(this.patient.getBirthDate());
    }
    saveButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        PatientEditDialog.this.patient.setFirstName(firstNameField.getText());
        PatientEditDialog.this.patient.setSecondName(secondNameField.getText());
        PatientEditDialog.this.patient.setPolisNumber(polisNumberField.getText());
        PatientEditDialog.this.patient.setBirthDate((Date) jDatePicker.getModel().getValue());
        mainController.savePatient(PatientEditDialog.this.patient);
        PatientEditDialog.this.setVisible(false);
      }
    });
    cancelButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        PatientEditDialog.this.setVisible(false);
      }
    });

    add(panel);
  }
}

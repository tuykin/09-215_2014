package ru.kfu.controller;

import ru.kfu.bean.Patient;
import ru.kfu.dao.PatientDao;
import ru.kfu.dao.PatientDaoImpl;
import ru.kfu.view.MainFrame;
import ru.kfu.view.PatientEditDialog;
import ru.kfu.view.PatientPanel;

import java.util.List;

/**
 * Created by Bulat on 25.12.14.
 */
public class MainController {

  private PatientDao patientDao = new PatientDaoImpl();


  private MainFrame mainFrame;
  private PatientPanel patientPanel;

  public MainController() {
    this.mainFrame = new MainFrame(this);
    this.mainFrame.setVisible(true);

    patientPanel = new PatientPanel(this);
    this.mainFrame.setMainPanel(patientPanel);

  }

  public List<Patient> getAllPatients(String polisNumber, String firstName, String secondName) {
    return patientDao.find(polisNumber, firstName, secondName);
  }

  public void addNewPatient() {
    new PatientEditDialog(null, this).setVisible(true);
  }

  public void savePatient(Patient patient) {
    patientDao.saveOrUpdate(patient);
    if (patientPanel != null) {
      patientPanel.refresh();
    }
  }


  public void deletePatient(Patient selectedItem) {
    patientDao.delete(selectedItem);
    if (patientPanel != null) {
      patientPanel.refresh();
    }
  }

  public void editPatient(Patient selectedItem) {
    new PatientEditDialog(selectedItem, this).setVisible(true);
  }
}

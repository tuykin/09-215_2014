package ru.kfu.view;

import ru.kfu.bean.Patient;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Bulat on 25.12.14.
 */
public class PatientTableModel extends AbstractTableModel {

  private List<Patient> data;

  private String[] columns = new String[]{"Номер полиса", "Имя", "Фамилия", "Дата рождения"};


  public PatientTableModel(List<Patient> data) {
    super();
    this.data = data;
  }

  @Override
  public int getRowCount() {
    return this.data.size();
  }

  @Override
  public int getColumnCount() {
    return columns.length;
  }

  @Override
  public String getColumnName(int columnIndex) {
    return columns[columnIndex];
  }

  @Override
  public Class<?> getColumnClass(int columnIndex) {
    return String.class;
  }

  @Override
  public boolean isCellEditable(int rowIndex, int columnIndex) {
    return false;
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    Patient patient = data.get(rowIndex);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
    switch (columnIndex) {
      case 0:
        return patient.getPolisNumber();
      case 1:
        return patient.getFirstName();
      case 2:
        return patient.getSecondName();
      case 3:
        return patient.getBirthDate() != null ? simpleDateFormat.format(patient.getBirthDate()) : "";
    }
    return null;
  }

  public Patient get(Integer index) {
    return data.get(index);
  }

  @Override
  public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

  }

  @Override
  public void addTableModelListener(TableModelListener l) {

  }

  @Override
  public void removeTableModelListener(TableModelListener l) {

  }

  public void setData(List<Patient> data) {
    this.data = data;
  }

  public List<Patient> getData() {
    return data;
  }
}

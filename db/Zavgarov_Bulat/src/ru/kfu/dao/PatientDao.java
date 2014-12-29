package ru.kfu.dao;

import ru.kfu.bean.Patient;

import java.util.List;

/**
 * Created by Bulat on 25.12.14.
 */
public interface PatientDao {
  public List<Patient> getAll();

  public void saveOrUpdate(Patient patient);

  public void delete(Patient data);

  public List<Patient> find(String polis, String firtsName, String secondName);
}

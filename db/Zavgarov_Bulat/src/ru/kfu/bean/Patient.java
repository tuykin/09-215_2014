package ru.kfu.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Bulat on 25.12.14.
 */
public class Patient implements Serializable {

  private Long id;
  private String firstName;
  private String secondName;
  private String polisNumber;
  private Date birthDate;

  public Patient(){

  }

  public Patient(Long id, String firstName, String secondName, String polisNumber, Date birthDate) {
    this.id = id;
    this.firstName = firstName;
    this.secondName = secondName;
    this.polisNumber = polisNumber;
    this.birthDate = birthDate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getSecondName() {
    return secondName;
  }

  public void setSecondName(String secondName) {
    this.secondName = secondName;
  }

  public String getPolisNumber() {
    return polisNumber;
  }

  public void setPolisNumber(String polisNumber) {
    this.polisNumber = polisNumber;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }
}

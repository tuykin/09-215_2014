package ru.kfu.dao;

import ru.kfu.bean.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bulat on 25.12.14.
 */
public class PatientDaoImpl implements PatientDao {

  private static final String SQL_SELECT_ALL = "SELECT id,first_name,second_name,polis_number,birth_date FROM patients";
  private static final String SQL_INSERT = "INSERT INTO patients(first_name,second_name,polis_number,birth_date) VALUES(?,?,?,?)";
  private static final String SQL_UPDATE = "UPDATE patients SET first_name=?, second_name=?, polis_number=?,birth_date=? WHERE id=?";
  private static final String SQL_DELETE = "DELETE FROM patients WHERE id=?";
  private static final String SQL_FIND = "SELECT id,first_name,second_name,polis_number,birth_date FROM patients WHERE polis_number LIKE (?) AND first_name LIKE(?) AND second_name LIKE(?)";
  private Connection conn = null;

  public PatientDaoImpl() {
    try {
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", null);
    } catch (ClassNotFoundException e1) {
      e1.printStackTrace();
    } catch (SQLException e1) {
      e1.printStackTrace();
    }
  }

  @Override
  public List<Patient> getAll() {
    Statement stmt = null;
    List<Patient> patients = new ArrayList<Patient>();
    try {
      stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(SQL_SELECT_ALL);

      //STEP 5: Extract data from result set
      while (rs.next()) {
        //Retrieve by column name
        Long id = rs.getLong("id");
        String firstName = rs.getString("first_name");
        String secondName = rs.getString("second_name");
        String polisNumber = rs.getString("polis_number");
        Date birthDate = rs.getDate("birth_date");
        patients.add(new Patient(id, firstName, secondName, polisNumber, birthDate));
      }
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (stmt != null) {
        try {
          stmt.close();
        } catch (SQLException e) {
          e.printStackTrace();
          //ignore
        }
      }
    }

    return patients;
  }

  @Override
  public void saveOrUpdate(Patient patient) {
    PreparedStatement stmt = null;
    List<Patient> patients = new ArrayList<Patient>();
    try {

      if (patient.getId() == null) {
        stmt = conn.prepareStatement(SQL_INSERT);
      } else {
        stmt = conn.prepareStatement(SQL_UPDATE);
        stmt.setLong(5, patient.getId());
      }

      stmt.setString(1, patient.getFirstName());
      stmt.setString(2, patient.getSecondName());
      stmt.setString(3, patient.getPolisNumber());
      stmt.setDate(4, new Date(patient.getBirthDate().getTime()));
      stmt.execute();

      stmt.close();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (stmt != null) {
        try {
          stmt.close();
        } catch (SQLException e) {
          e.printStackTrace();
          //ignore
        }
      }
    }
  }

  @Override
  public void delete(Patient patient) {
    PreparedStatement stmt = null;
    try {

      stmt = conn.prepareStatement(SQL_DELETE);
      stmt.setLong(1, patient.getId());
      stmt.execute();

      stmt.close();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (stmt != null) {
        try {
          stmt.close();
        } catch (SQLException e) {
          e.printStackTrace();
          //ignore
        }
      }
    }
  }

  @Override
  public List<Patient> find(String filterPolisNumber, String filterFirstName, String filterSecondName) {
    CallableStatement stmt = null;
    List<Patient> patients = new ArrayList<Patient>();
    try {
      stmt = conn.prepareCall(SQL_FIND);
      if (filterPolisNumber == null) {
        filterPolisNumber = "";
      }
      filterPolisNumber += "%";

      if (filterFirstName == null) {
        filterFirstName = "";
      }
      filterFirstName += "%";

      if (filterSecondName == null) {
        filterSecondName = "";
      }
      filterSecondName += "%";

      stmt.setString(1, filterPolisNumber);
      stmt.setString(2, filterFirstName);
      stmt.setString(3, filterSecondName);

      ResultSet rs = stmt.executeQuery();

      //STEP 5: Extract data from result set
      while (rs.next()) {
        //Retrieve by column name
        Long id = rs.getLong("id");
        String firstName = rs.getString("first_name");
        String secondName = rs.getString("second_name");
        String polisNumber = rs.getString("polis_number");
        Date birthDate = rs.getDate("birth_date");
        patients.add(new Patient(id, firstName, secondName, polisNumber, birthDate));
      }
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (stmt != null) {
        try {
          stmt.close();
        } catch (SQLException e) {
          e.printStackTrace();
          //ignore
        }
      }
    }

    return patients;
  }

  @Override
  protected void finalize() throws Throwable {
    super.finalize();
    if (conn != null) {
      conn.close();
    }
  }
}

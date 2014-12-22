/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelapplication;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author DEAkishin
 */
public class EmployeePanel extends javax.swing.JPanel {

    //id работника, вошедшего в систему
    private int empID;

    private Statement stmt;

    /**
     * Creates new form EmployeePanel
     */
    public EmployeePanel(int employee) {
        stmt = HotelForm.stmt;
        empID = employee;
        initComponents();
        updateRegisteredRoomsTable();
        guestInfoButton.setEnabled(false);
        showGuestHistoryButton.setEnabled(false);
        showGuestReservationsButton.setEnabled(false);
        showRoomHistoryButton.setEnabled(false);
        showRoomReservationsButton.setEnabled(false);

        //кнопки и поля на вкладке заселения
    }

    //Запрос - все занятые комнаты
    private String registeredRoomsQuery() {
        /*
         String query = "SELECT guest_id, room_number, floor, last_name, date_end "
         + "FROM registrations, rooms, guests"
         + " WHERE archived=0 AND room_number=rooms.number"
         + " AND guest_id=guests.id";
         query += " ORDER BY room_number";
         */

        String query = "CALL selectRegisteredRooms();";
        return query;
    }

    //Запрос - информация по посетителю
    private String guestInfoQuery(int guestID) {
        /*
         String query = "SELECT last_name, first_name, patronymic_name, "
         + "passport, birthdate, country, city, street, "
         + "housenumber, flatnumber, points "
         + "FROM guests WHERE id=" + guestID;
         */
        String query = "CALL selectGuestInfo(" + guestID + ")";
        return query;
    }

    //Запрос - все посетители
    private String guestsQuery() {
        String query = "SELECT id, last_name, first_name, patronymic_name, "
                + "passport, birthdate, country, city, street, "
                + "housenumber, flatnumber, points "
                + "FROM guests";
        return query;
    }

    //Запрос - история посещений для посетителя
    private String guestHistoryQuery(int guestID) {
        /*
         String query = "SELECT room_number, employees.last_name, date_begin, date_end, "
         + "cost, commentary "
         + "FROM registrations, employees"
         + " WHERE archived=1 AND employee_id=employees.id"
         + " AND guest_id=" + guestID;
         query += " ORDER BY date_begin";
         */
        String query = "CALL selectGuestHistory(" + guestID + ")";
        return query;
    }

    //Запрос - забронированные посетителем номера
    private String guestReservationsQuery(int guestID) {
        String query = "SELECT room_number, reservation_date, date_begin, date_end "
                + "FROM reservations"
                + " WHERE guest_id=" + guestID;
        query += " ORDER BY reservation_date";
        return query;
    }

    //Запрос - все номера
    private String roomsQuery() {
        String query = "SELECT number, floor, type, view, "
                + "class, price "
                + "FROM rooms, roomtypes, roomviews, roomclasses"
                + " WHERE type_id=roomtypes.id AND view_id=roomviews.id"
                + " AND class_id=roomclasses.id";
        query += " ORDER BY number";
        return query;
    }

    //Запрос - история посещений для комнаты
    private String roomHistoryQuery(int roomNumber) {
        String query = "SELECT guests.last_name, employees.last_name, date_begin, date_end, "
                + "cost, commentary "
                + "FROM registrations, employees, guests"
                + " WHERE archived=1 AND employee_id=employees.id"
                + " AND guest_id=guests.id"
                + " AND room_number=" + roomNumber;
        query += " ORDER BY date_begin";
        return query;
    }

    //Запрос - бронь для номера
    private String roomReservationsQuery(int roomNumber) {
        String query = "SELECT last_name, reservation_date, date_begin, date_end "
                + "FROM reservations, guests"
                + " WHERE guest_id=guests.id AND room_number=" + roomNumber;
        query += " ORDER BY reservation_date";
        return query;
    }

    //Запрос - добавление записи в табл регистраций
    private String registrate(int room, int emp, int guest, java.sql.Date dateBegin,
            java.sql.Date dateEnd, BigDecimal cost) {
        String query = "INSERT INTO Registrations (room_number, employee_id, guest_id,"
                + " date_begin, date_end, cost, archived) VALUES"
                + " (" + room + ", " + emp + ", " + guest + ", "
                + "'" + dateBegin + "', '" + dateEnd + "', " + cost + ", 0)";
        return query;
    }

    //Запрос - истекшие регистрации
    private String expiredRegistrationsQuery(java.sql.Date curdate) {
        String query = "SELECT registrations.id, room_number, employees.last_name,"
                + " guests.last_name, date_begin, date_end, cost "
                + "FROM registrations, employees, guests"
                + " WHERE archived=0 AND date_end<'" + curdate + "'"
                + " AND employee_id=employees.id"
                + " AND guest_id=guests.id";
        query += " ORDER BY date_end";
        return query;
    }

    //Запрос - услуги по номеру и дате
    private String servicesQuery(int room, java.sql.Date dateBegin, java.sql.Date dateEnd) {
        String query = "SELECT date, type, price "
                + "FROM services, servicetypes"
                + " WHERE room_number=" + room
                + " AND date<='" + dateEnd + "'"
                + " AND date>='" + dateBegin + "'"
                + " AND servicetype_id=servicetypes.id";
        query += " ORDER BY date";
        return query;
    }

    //Запрос - закрытие регистрации
    private String closeRegistrationQuery(int id, BigDecimal servCost, String commentary) {
        String query = "UPDATE registrations SET archived=true,"
                + " cost=cost+" + servCost + ", commentary=" + commentary
                + " WHERE id=" + id;
        return query;
    }

    //Запрос - все типы услуг
    private String servicetypesQuery() {
        String query = "SELECT * FROM servicetypes";
        return query;
    }

    //Запрос - занятые комнаты
    private String registeredRoomNumbersQuery(java.sql.Date curdate) {
        String query = "SELECT room_number FROM registrations"
                + " WHERE archived=false AND date_begin<='" + curdate + "'"
                + " AND date_end>='" + curdate + "'";
        query += " ORDER BY room_number";
        return query;
    }

    //Запрос - добавить услугу
    private String addServiceQuery(int room, java.sql.Date date, int type) {
        String query = "INSERT INTO services(room_number,date,servicetype_id) "
                + "VALUES (" + room + ", '" + date + "', " + type + ")";
        return query;
    }

    private void updateRegisteredRoomsTable() {
        String[] columnNames = {"guest_id", "номер", "этаж", "посетитель", "оплачено до"};
        try {
            ResultSet results;
            results = stmt.executeQuery(registeredRoomsQuery());
            registeredRoomsTable.setModel(new MyTableModel(results, columnNames));
            registeredRoomsTable.removeColumn(registeredRoomsTable.getColumn("guest_id"));
            results.close();
        } catch (SQLException ex) {
            Logger.getLogger(TablesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane8 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        registeredRoomsTable = new javax.swing.JTable();
        guestInfoButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        guestInfoTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        showGuestsButton = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        guestsTable = new javax.swing.JTable();
        showGuestHistoryButton = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        guestHistoryTable = new javax.swing.JTable();
        showGuestReservationsButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        roomHistoryTable = new javax.swing.JTable();
        showRoomReservationsButton = new javax.swing.JButton();
        showRoomsButton = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        roomsTable = new javax.swing.JTable();
        showRoomHistoryButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        durationSpinner = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        roomNumberField = new javax.swing.JTextField();
        selectRoomButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        guestField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        costField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        selectGuestButton = new javax.swing.JButton();
        confirmRegistrationButton = new javax.swing.JButton();
        calculateCostButton = new javax.swing.JButton();
        cleanButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        showExpiredRegistrationsButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        expiredRegistrationsTable = new javax.swing.JTable();
        showServicesButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        servicesCostField = new javax.swing.JTextField();
        closeRegistrationButton = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        servicesTable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        commentaryArea = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        showServicetypesButton = new javax.swing.JButton();
        jScrollPane15 = new javax.swing.JScrollPane();
        servicetypesTable = new javax.swing.JTable();
        addServiceButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        roomBox = new javax.swing.JComboBox();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane8.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(jTable2);

        registeredRoomsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        registeredRoomsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        registeredRoomsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registeredRoomsTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(registeredRoomsTable);

        guestInfoButton.setText("Показать информацию о посетителе");
        guestInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guestInfoButtonActionPerformed(evt);
            }
        });

        guestInfoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        guestInfoTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane4.setViewportView(guestInfoTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane4)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(guestInfoButton)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(guestInfoButton)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Занятые номера", jPanel1);

        showGuestsButton.setText("Открыть базу посетителей");
        showGuestsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showGuestsButtonActionPerformed(evt);
            }
        });

        guestsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        guestsTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        guestsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        guestsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guestsTableMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(guestsTable);

        showGuestHistoryButton.setText("Показать историю посещений");
        showGuestHistoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showGuestHistoryButtonActionPerformed(evt);
            }
        });

        guestHistoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane10.setViewportView(guestHistoryTable);

        showGuestReservationsButton.setText("Показать забронированные номера");
        showGuestReservationsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showGuestReservationsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10)
                    .addComponent(jScrollPane7)
                    .addComponent(showGuestsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(showGuestReservationsButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(showGuestHistoryButton)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(showGuestsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showGuestHistoryButton)
                    .addComponent(showGuestReservationsButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Посетители", jPanel2);

        roomHistoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane11.setViewportView(roomHistoryTable);

        showRoomReservationsButton.setText("Показать бронь");
        showRoomReservationsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showRoomReservationsButtonActionPerformed(evt);
            }
        });

        showRoomsButton.setText("Открыть каталог номеров");
        showRoomsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showRoomsButtonActionPerformed(evt);
            }
        });

        roomsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        roomsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        roomsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roomsTableMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(roomsTable);

        showRoomHistoryButton.setText("Показать историю номера");
        showRoomHistoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showRoomHistoryButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11)
                    .addComponent(jScrollPane12)
                    .addComponent(showRoomsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(showRoomReservationsButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(showRoomHistoryButton)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(showRoomsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showRoomHistoryButton)
                    .addComponent(showRoomReservationsButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Номера", jPanel3);

        jLabel1.setText("Количество дней");

        durationSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        durationSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                durationSpinnerStateChanged(evt);
            }
        });

        jLabel2.setText("Номер");

        roomNumberField.setEditable(false);
        roomNumberField.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                roomNumberFieldPropertyChange(evt);
            }
        });

        selectRoomButton.setText("Выбрать свободный номер");
        selectRoomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectRoomButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Посетитель");

        guestField.setEditable(false);

        jLabel4.setText("Стоимость");

        costField.setEditable(false);

        jLabel5.setText("рублей");

        selectGuestButton.setText("Выбрать посетителя");
        selectGuestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectGuestButtonActionPerformed(evt);
            }
        });

        confirmRegistrationButton.setText("Заселить");
        confirmRegistrationButton.setEnabled(false);
        confirmRegistrationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmRegistrationButtonActionPerformed(evt);
            }
        });

        calculateCostButton.setText("Рассчитать стоимость");
        calculateCostButton.setEnabled(false);
        calculateCostButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateCostButtonActionPerformed(evt);
            }
        });

        cleanButton.setText("Очистить");
        cleanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cleanButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(costField, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(calculateCostButton))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(roomNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(durationSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(selectRoomButton))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(guestField, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(selectGuestButton))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(cleanButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 377, Short.MAX_VALUE)
                        .addComponent(confirmRegistrationButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(durationSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(roomNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectRoomButton))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(guestField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectGuestButton))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(costField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(calculateCostButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmRegistrationButton)
                    .addComponent(cleanButton))
                .addContainerGap(88, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Заселение", jPanel4);

        showExpiredRegistrationsButton.setText("Показать закончившиеся регистрации");
        showExpiredRegistrationsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showExpiredRegistrationsButtonActionPerformed(evt);
            }
        });

        jScrollPane3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane3MouseClicked(evt);
            }
        });

        expiredRegistrationsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        expiredRegistrationsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        expiredRegistrationsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                expiredRegistrationsTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(expiredRegistrationsTable);

        showServicesButton.setText("Рассчет оказанных услуг");
        showServicesButton.setEnabled(false);
        showServicesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showServicesButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("Стоимость услуг:");

        servicesCostField.setEditable(false);

        closeRegistrationButton.setText("Освободить комнату");
        closeRegistrationButton.setEnabled(false);
        closeRegistrationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeRegistrationButtonActionPerformed(evt);
            }
        });

        servicesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane9.setViewportView(servicesTable);

        jLabel7.setText("Комментарий");

        commentaryArea.setEditable(false);
        commentaryArea.setColumns(20);
        commentaryArea.setRows(5);
        jScrollPane13.setViewportView(commentaryArea);

        jLabel8.setText("руб.");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(showServicesButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane13, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addComponent(closeRegistrationButton))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
                    .addComponent(showExpiredRegistrationsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(servicesCostField, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(showExpiredRegistrationsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(showServicesButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(servicesCostField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 36, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 26, Short.MAX_VALUE)
                        .addComponent(closeRegistrationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Выселение", jPanel5);

        showServicetypesButton.setText("Открыть каталог услуг");
        showServicetypesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showServicetypesButtonActionPerformed(evt);
            }
        });

        servicetypesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        servicetypesTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        servicetypesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                servicetypesTableMouseClicked(evt);
            }
        });
        jScrollPane15.setViewportView(servicetypesTable);

        addServiceButton.setText("Предоставить услугу");
        addServiceButton.setEnabled(false);
        addServiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addServiceButtonActionPerformed(evt);
            }
        });

        jLabel9.setText("Номер");

        roomBox.setEnabled(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(showServicetypesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(roomBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addServiceButton))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addComponent(showServicetypesButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roomBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addServiceButton))
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(129, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Услуги", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void registeredRoomsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registeredRoomsTableMouseClicked
        guestInfoButton.setEnabled(true);
        guestInfoTable.setModel(new EmptyTableModel());
    }//GEN-LAST:event_registeredRoomsTableMouseClicked

    private void guestInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guestInfoButtonActionPerformed
        int guestID;
        int row = registeredRoomsTable.getSelectedRow();
        guestID = Integer.parseInt((String) registeredRoomsTable.getModel().getValueAt(row, 0));
        String[] columnNames = {"фамилия", "имя", "отчество", "паспорт", "дата рождения",
            "страна", "город", "улица", "дом", "квартира", "баллы"};
        try {
            ResultSet results;
            results = stmt.executeQuery(guestInfoQuery(guestID));
            guestInfoTable.setModel(new MyTableModel(results, columnNames));
            results.close();
        } catch (SQLException ex) {
            Logger.getLogger(TablesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_guestInfoButtonActionPerformed

    //открыта ли база посетителей
    private boolean guestsAreShown = false;

    private void showGuestsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showGuestsButtonActionPerformed
        if (guestsAreShown) {
            guestsTable.setModel(new EmptyTableModel());
            guestHistoryTable.setModel(new EmptyTableModel());
            showGuestHistoryButton.setEnabled(false);
            showGuestReservationsButton.setEnabled(false);
            showGuestsButton.setText("Открыть базу посетителей");
            guestsAreShown = false;
        } else {
            String[] columnNames = {"id", "фамилия", "имя", "отчество", "паспорт", "дата рождения",
                "страна", "город", "улица", "дом", "квартира", "баллы"};
            try {
                ResultSet results;
                results = stmt.executeQuery(guestsQuery());
                guestsTable.setModel(new MyTableModel(results, columnNames));
                guestsTable.removeColumn(guestsTable.getColumn("id"));
                results.close();
            } catch (SQLException ex) {
                Logger.getLogger(TablesPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            showGuestsButton.setText("Закрыть базу посетителей");
            guestsAreShown = true;
        }
    }//GEN-LAST:event_showGuestsButtonActionPerformed

    private void guestsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guestsTableMouseClicked
        showGuestHistoryButton.setEnabled(true);
        showGuestReservationsButton.setEnabled(true);
        guestHistoryTable.setModel(new EmptyTableModel());
    }//GEN-LAST:event_guestsTableMouseClicked

    private void showGuestHistoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showGuestHistoryButtonActionPerformed
        int guestID;
        int row = guestsTable.getSelectedRow();
        guestID = Integer.parseInt((String) guestsTable.getModel().getValueAt(row, 0));
        String[] columnNames = {"номер", "ключ выдал", "посещение с ", "до", "стоимость",
            "комментарий"};
        try {
            ResultSet results;
            results = stmt.executeQuery(guestHistoryQuery(guestID));
            guestHistoryTable.setModel(new MyTableModel(results, columnNames));
            results.close();
        } catch (SQLException ex) {
            Logger.getLogger(TablesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_showGuestHistoryButtonActionPerformed

    private void showGuestReservationsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showGuestReservationsButtonActionPerformed
        int guestID;
        int row = guestsTable.getSelectedRow();
        guestID = Integer.parseInt((String) guestsTable.getModel().getValueAt(row, 0));
        String[] columnNames = {"номер", "дата брони", "начало", "конец"};
        try {
            ResultSet results;
            results = stmt.executeQuery(guestReservationsQuery(guestID));
            guestHistoryTable.setModel(new MyTableModel(results, columnNames));
            results.close();
        } catch (SQLException ex) {
            Logger.getLogger(TablesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_showGuestReservationsButtonActionPerformed

    private void showRoomReservationsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showRoomReservationsButtonActionPerformed
        int roomNumber;
        int row = roomsTable.getSelectedRow();
        roomNumber = Integer.parseInt((String) roomsTable.getModel().getValueAt(row, 0));
        String[] columnNames = {"посетитель", "дата брони", "начало", "конец"};
        try {
            ResultSet results;
            results = stmt.executeQuery(roomReservationsQuery(roomNumber));
            roomHistoryTable.setModel(new MyTableModel(results, columnNames));
            results.close();
        } catch (SQLException ex) {
            Logger.getLogger(TablesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_showRoomReservationsButtonActionPerformed

    //Открыт ли каталог номеров
    private boolean roomsAreShown = false;

    private void showRoomsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showRoomsButtonActionPerformed
        if (roomsAreShown) {
            roomsTable.setModel(new EmptyTableModel());
            roomHistoryTable.setModel(new EmptyTableModel());
            showRoomHistoryButton.setEnabled(false);
            showRoomReservationsButton.setEnabled(false);
            showRoomsButton.setText("Открыть каталог номеров");
            roomsAreShown = false;
        } else {
            String[] columnNames = {"номер", "этаж", "тип", "вид", "класс", "цена"};
            try {
                ResultSet results;
                results = stmt.executeQuery(roomsQuery());
                roomsTable.setModel(new MyTableModel(results, columnNames));
                //roomsTable.removeColumn(roomsTable.getColumn("id"));
                results.close();
            } catch (SQLException ex) {
                Logger.getLogger(TablesPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            showRoomsButton.setText("Закрыть каталог номеров");
            roomsAreShown = true;
        }
    }//GEN-LAST:event_showRoomsButtonActionPerformed

    private void roomsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomsTableMouseClicked
        showRoomHistoryButton.setEnabled(true);
        showRoomReservationsButton.setEnabled(true);
        roomHistoryTable.setModel(new EmptyTableModel());
    }//GEN-LAST:event_roomsTableMouseClicked

    private void showRoomHistoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showRoomHistoryButtonActionPerformed
        int roomNumber;
        int row = roomsTable.getSelectedRow();
        roomNumber = Integer.parseInt((String) roomsTable.getModel().getValueAt(row, 0));
        String[] columnNames = {"посетитель", "ключ выдал", "посещение с ", "до", "стоимость",
            "комментарий"};
        try {
            ResultSet results;
            results = stmt.executeQuery(roomHistoryQuery(roomNumber));
            roomHistoryTable.setModel(new MyTableModel(results, columnNames));
            results.close();
        } catch (SQLException ex) {
            Logger.getLogger(TablesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_showRoomHistoryButtonActionPerformed

    private void selectGuestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectGuestButtonActionPerformed
        GuestSelectionDialog guestSelectionDialog
                = new GuestSelectionDialog(new JFrame(), true);
        if (guestSelectionDialog.isGuestSelected()) {
            guestIsSelected = true;
            selectedGuestId = guestSelectionDialog.getSelectedGuestId();
            selectedGuestPoints = guestSelectionDialog.getSelectedGuestPoints();
            guestField.setText(guestSelectionDialog.getSelectedGuestFullName());
            calculateCostButton.setEnabled(roomIsSelected);
            costField.setText("");
            confirmRegistrationButton.setEnabled(false);
        }
    }//GEN-LAST:event_selectGuestButtonActionPerformed

    private void durationSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_durationSpinnerStateChanged
        roomNumberField.setText("");
        costField.setText("");
        roomIsSelected = false;
        calculateCostButton.setEnabled(false);
        confirmRegistrationButton.setEnabled(true);
    }//GEN-LAST:event_durationSpinnerStateChanged

    private void roomNumberFieldPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_roomNumberFieldPropertyChange
    }//GEN-LAST:event_roomNumberFieldPropertyChange

    private int selectedRoomNumber;
    private int selectedGuestId;
    private int selectedGuestPoints;
    private double selectedRoomPrice;
    private boolean roomIsSelected = false;
    private boolean guestIsSelected = false;
    private double calculatedCost;

    private void selectRoomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectRoomButtonActionPerformed
        int duration = (int) durationSpinner.getValue();
        RoomSelectionDialog roomSelectionDialog
                = new RoomSelectionDialog(new JFrame(), true, new Date(), duration);
        if (roomSelectionDialog.isRoomSelected()) {
            roomIsSelected = true;
            selectedRoomNumber = roomSelectionDialog.getSelectedRoom();
            roomNumberField.setText(String.valueOf(selectedRoomNumber));
            selectedRoomPrice = roomSelectionDialog.getSelectedRoomPrice();
            calculateCostButton.setEnabled(guestIsSelected);
            costField.setText("");
            confirmRegistrationButton.setEnabled(false);
        }
    }//GEN-LAST:event_selectRoomButtonActionPerformed

    private void cleanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cleanButtonActionPerformed
        durationSpinner.setValue(1);
        roomNumberField.setText("");
        guestField.setText("");
        costField.setText("");
        calculateCostButton.setEnabled(false);
        confirmRegistrationButton.setEnabled(false);
        roomIsSelected = false;
        guestIsSelected = false;
    }//GEN-LAST:event_cleanButtonActionPerformed

    private void calculateCostButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateCostButtonActionPerformed
        // Рассчет стоимости комнаты с учетов баллов посетителя
        //  = цена * (100 - 2*баллы) / 100, макс скидка = 50%
        int discount = Math.min(50, 2 * selectedGuestPoints);
        int duration = (int) durationSpinner.getValue();
        calculatedCost = selectedRoomPrice * duration * (100 - discount) / 100;
        costField.setText(String.valueOf(calculatedCost));
        confirmRegistrationButton.setEnabled(true);
    }//GEN-LAST:event_calculateCostButtonActionPerformed

    private void confirmRegistrationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmRegistrationButtonActionPerformed
        try {
            Date dateBegin = new Date();
            int duration = (int) durationSpinner.getValue();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateBegin);
            calendar.add(Calendar.DAY_OF_MONTH, duration - 1);
            Date dateEnd = calendar.getTime();
            stmt.executeUpdate(registrate(selectedRoomNumber, empID, selectedGuestId,
                    new java.sql.Date(dateBegin.getTime()),
                    new java.sql.Date(dateEnd.getTime()),
                    BigDecimal.valueOf(calculatedCost)));
            JOptionPane.showMessageDialog(this, "Регистрация проведена успешно.",
                    null, JOptionPane.INFORMATION_MESSAGE);
            cleanButtonActionPerformed(null);
            updateRegisteredRoomsTable();
        } catch (SQLException ex) {
            Logger.getLogger(TablesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_confirmRegistrationButtonActionPerformed

    private boolean expiredRegistrationsAreShown = false;

    private void showExpiredRegistrationsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showExpiredRegistrationsButtonActionPerformed
        if (expiredRegistrationsAreShown) {
            expiredRegistrationsTable.setModel(new EmptyTableModel());
            showExpiredRegistrationsButton.setText("Показать закончившиеся регистрации");
            showServicesButton.setEnabled(false);
            servicesTable.setModel(new EmptyTableModel());
            servicesCostField.setText("");
            commentaryArea.setText("");
            closeRegistrationButton.setEnabled(false);
            commentaryArea.setEditable(false);
            expiredRegistrationsAreShown = false;
        } else {
            String[] columnNames = {"id", "номер", "посетитель", "ключ выдал", "посещение с ",
                "до", "стоимость",};
            try {
                ResultSet results;
                results = stmt.executeQuery(expiredRegistrationsQuery(
                        new java.sql.Date(new Date().getTime())));
                expiredRegistrationsTable.setModel(new MyTableModel(results, columnNames));
                expiredRegistrationsTable.removeColumn(expiredRegistrationsTable.getColumn("id"));
                results.close();
                showExpiredRegistrationsButton.setText("Скрыть закончившиеся регистрации");
                expiredRegistrationsAreShown = true;
            } catch (SQLException ex) {
                Logger.getLogger(TablesPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_showExpiredRegistrationsButtonActionPerformed

    private void expiredRegistrationsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expiredRegistrationsTableMouseClicked
        showServicesButton.setEnabled(true);
        servicesTable.setModel(new EmptyTableModel());
        servicesCostField.setText("");
        commentaryArea.setText("");
        closeRegistrationButton.setEnabled(false);
        commentaryArea.setEditable(false);
    }//GEN-LAST:event_expiredRegistrationsTableMouseClicked

    private Date getDateFromString(String str) {
        StringTokenizer st = new StringTokenizer(str, ".");
        int day = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken()) - 1;
        int year = Integer.parseInt(st.nextToken());
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar.getTime();
    }

    private void showServicesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showServicesButtonActionPerformed
        Date dateBegin, dateEnd;
        int row = expiredRegistrationsTable.getSelectedRow();
        registrationId = Integer.parseInt((String) expiredRegistrationsTable.getModel().getValueAt(row, 0));
        int roomNumber = Integer.parseInt((String) expiredRegistrationsTable.getModel().getValueAt(row, 1));
        dateBegin = getDateFromString(
                (String) expiredRegistrationsTable.getModel().getValueAt(row, 4));
        dateEnd = getDateFromString(
                (String) expiredRegistrationsTable.getModel().getValueAt(row, 5));
        String[] columnNames = {"дата", "вид услуги", "цена"};
        try {
            ResultSet results;
            results = stmt.executeQuery(servicesQuery(roomNumber,
                    new java.sql.Date(dateBegin.getTime()),
                    new java.sql.Date(dateEnd.getTime())));
            servicesTable.setModel(new MyTableModel(results, columnNames));
            results.close();
            int rowCount = servicesTable.getModel().getRowCount();
            servicesCost = 0;
            for (int i = 0; i < rowCount; i++) {
                servicesCost += Double.parseDouble((String) servicesTable.getModel().getValueAt(i, 2));
            }
            servicesCostField.setText(String.valueOf(servicesCost));
            commentaryArea.setEditable(true);
            closeRegistrationButton.setEnabled(true);
        } catch (SQLException ex) {
            Logger.getLogger(TablesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_showServicesButtonActionPerformed

    private void jScrollPane3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane3MouseClicked
    }//GEN-LAST:event_jScrollPane3MouseClicked

    private int registrationId;
    private double servicesCost;
    private String commentary;

    private void closeRegistrationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeRegistrationButtonActionPerformed
        commentary = commentaryArea.getText();
        if ("".equals(commentary)) {
            commentary = null;
        }
        try {
            stmt.executeUpdate(closeRegistrationQuery(registrationId,
                    BigDecimal.valueOf(servicesCost),
                    commentary));
            JOptionPane.showMessageDialog(this, "Комната освобождена.",
                    null, JOptionPane.INFORMATION_MESSAGE);
            showExpiredRegistrationsButtonActionPerformed(null);
        } catch (SQLException ex) {
            Logger.getLogger(TablesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_closeRegistrationButtonActionPerformed

    private boolean servicetypesAreShown = false;

    private void showServicetypesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showServicetypesButtonActionPerformed
        if (servicetypesAreShown) {
            servicetypesTable.setModel(new EmptyTableModel());
            showServicetypesButton.setText("Открыть каталог услуг");
            roomBox.removeAllItems();
            roomBox.setEnabled(false);
            addServiceButton.setEnabled(false);
            servicetypesAreShown = false;
        } else {
            String[] columnNames = {"id", "вид услуги", "цена"};
            try {
                ResultSet results;
                results = stmt.executeQuery(servicetypesQuery());
                servicetypesTable.setModel(new MyTableModel(results, columnNames));
                servicetypesTable.removeColumn(servicetypesTable.getColumn("id"));
                results.close();
                showServicetypesButton.setText("Закрыть каталог услуг");
                getItemsForRoomBox();
                servicetypesAreShown = true;
            } catch (SQLException ex) {
                Logger.getLogger(TablesPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_showServicetypesButtonActionPerformed

    private void servicetypesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_servicetypesTableMouseClicked
        roomBox.setEnabled(true);
        addServiceButton.setEnabled(true);
    }//GEN-LAST:event_servicetypesTableMouseClicked

    private void addServiceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addServiceButtonActionPerformed
        int row = servicetypesTable.getSelectedRow();
        int servicetypeId = Integer.parseInt(
                (String) servicetypesTable.getModel().getValueAt(row, 0));
        int room = Integer.parseInt((String) roomBox.getSelectedItem());
        try {
            stmt.executeUpdate(addServiceQuery(room,
                    new java.sql.Date(new Date().getTime()), servicetypeId));
            JOptionPane.showMessageDialog(this, "Услуга предоставлена.",
                    null, JOptionPane.INFORMATION_MESSAGE);
            showServicetypesButtonActionPerformed(null);
        } catch (SQLException ex) {
            Logger.getLogger(TablesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addServiceButtonActionPerformed

    private void getItemsForRoomBox() {
        //roomBox.addItem("");
        try {
            ResultSet results;
            results = stmt.executeQuery(registeredRoomNumbersQuery(
                    new java.sql.Date(new Date().getTime())));
            while (results.next()) {
                roomBox.addItem(results.getString(1));
            }
            results.close();
        } catch (SQLException ex) {
            Logger.getLogger(TablesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addServiceButton;
    private javax.swing.JButton calculateCostButton;
    private javax.swing.JButton cleanButton;
    private javax.swing.JButton closeRegistrationButton;
    private javax.swing.JTextArea commentaryArea;
    private javax.swing.JButton confirmRegistrationButton;
    private javax.swing.JTextField costField;
    private javax.swing.JSpinner durationSpinner;
    private javax.swing.JTable expiredRegistrationsTable;
    private javax.swing.JTextField guestField;
    private javax.swing.JTable guestHistoryTable;
    private javax.swing.JButton guestInfoButton;
    private javax.swing.JTable guestInfoTable;
    private javax.swing.JTable guestsTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable registeredRoomsTable;
    private javax.swing.JComboBox roomBox;
    private javax.swing.JTable roomHistoryTable;
    private javax.swing.JTextField roomNumberField;
    private javax.swing.JTable roomsTable;
    private javax.swing.JButton selectGuestButton;
    private javax.swing.JButton selectRoomButton;
    private javax.swing.JTextField servicesCostField;
    private javax.swing.JTable servicesTable;
    private javax.swing.JTable servicetypesTable;
    private javax.swing.JButton showExpiredRegistrationsButton;
    private javax.swing.JButton showGuestHistoryButton;
    private javax.swing.JButton showGuestReservationsButton;
    private javax.swing.JButton showGuestsButton;
    private javax.swing.JButton showRoomHistoryButton;
    private javax.swing.JButton showRoomReservationsButton;
    private javax.swing.JButton showRoomsButton;
    private javax.swing.JButton showServicesButton;
    private javax.swing.JButton showServicetypesButton;
    // End of variables declaration//GEN-END:variables
}

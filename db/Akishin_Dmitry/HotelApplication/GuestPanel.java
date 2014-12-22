/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelapplication;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author DEAkishin
 */
public class GuestPanel extends javax.swing.JPanel {

    //id посетителя, вошедшего в систему
    private int guestID;

    private Statement stmt;

    /**
     * Creates new form GuestPanel
     */
    public GuestPanel(int guest) {
        stmt = HotelForm.stmt;
        guestID = guest;
        initComponents();
        updatePersonalInfoTab();
        setPersonalInfoEditable(false);
        setButtonsToEditMode(false);
        //поле с баллами всегда нередактируемо
        pointsField.setEditable(false);
        //кнопка удаления брони вначале невидима
        deleteReservButton.setVisible(false);
        //получаем элементы для полей ввода на во вкладке "забронировать"
        getItemsForReservationPanel();
        //кнопка бронирования вначале невидима
        reserveButton.setVisible(false);
    }

    //Запрос - поиск посетителя по id;
    // подразумевается его наличие
    private String guestByIdQuery(int id) {
        String query = "SELECT last_name, first_name, patronymic_name, passport, country, "
                + "city, street, housenumber, flatnumber, birthdate, points "
                + "FROM guests WHERE id=" + id;
        return query;
    }

    //Запрос - вывод истории регистраций для посетителя
    private String historyQuery(int id) {
        String query = "SELECT room_number, date_begin, date_end, cost, commentary "
                + "FROM registrations WHERE guest_id=" + id;
        return query;
    }

    //Запрос - вывод бронирований для посетителя
    //поле id нужно для последующего удаления записи
    private String reservationsQuery(int id) {
        String query = "SELECT id, room_number, reservation_date, date_begin, date_end "
                + "FROM reservations WHERE guest_id=" + id;
        return query;
    }

    //Запрос - обновление записи посетителя
    private String updateGuestQuery(int id, String surname, String name, String patrname,
            String passport, String country, String city, String street, int house, int flat, Date birthdate) {
        String query = "UPDATE guests SET last_name='" + surname + "', first_name='" + name + "', "
                + "patronymic_name='" + patrname + "', passport='" + passport + "', "
                + "country='" + country + "', city='" + city + "', street='" + street + "', "
                + "housenumber=" + house + ", flatnumber=" + flat + ", "
                + "birthdate='" + birthdate + "' WHERE id=" + id;
        return query;
    }

    //Запрос - удаление брони
    private String deleteReservationQuery(int id) {
        String query = "DELETE FROM reservations WHERE id=" + id;
        return query;
    }

    //Запрос - поиск номеров, отвечающих заданным критериям в полях ввода и свободных в заданные сроки
    private String roomsForReservationQuery(Date dateBegin, Date dateEnd) {
        String query = "SELECT number, floor, type, "
                + "class, view , price FROM rooms, roomtypes, roomclasses, roomviews "
                + "WHERE rooms.type_id = roomtypes.id "
                + "AND rooms.class_id = roomclasses.id "
                + "AND rooms.view_id = roomviews.id";

        query += " AND price <= " + priceSpinner.getValue().toString();
        if (floorBox.getSelectedIndex() > 0) {
            query += " AND floor = " + floorBox.getSelectedItem();
        }
        if (typeBox.getSelectedIndex() > 0) {
            query += " AND type_id = " + typeIDs.get(typeBox.getSelectedIndex() - 1);
        }
        if (classBox.getSelectedIndex() > 0) {
            query += " AND class_id = " + classIDs.get(classBox.getSelectedIndex() - 1);
        }
        if (viewBox.getSelectedIndex() > 0) {
            query += " AND view_id = " + viewIDs.get(viewBox.getSelectedIndex() - 1);
        }

        //условие незабронированности номера
        query += " AND (SELECT count(id) FROM reservations WHERE room_number=rooms.number AND "
                + "NOT(('" + dateBegin + "'<date_begin AND '" + dateEnd + "'<date_begin) OR "
                + "('" + dateBegin + "'>date_end AND '" + dateEnd + "'>date_end)))=0";

        //условие незанятости номера
        query += " AND (SELECT count(id) FROM registrations "
                + "WHERE room_number=rooms.number AND archived=false "
                + "AND '" + dateBegin + "'<=date_end)=0";

        query += " ORDER BY number";

        return query;
    }

    //Запрос - добавление брони
    private String createReservationQuery(int room, int guest, Date reservDate, 
        Date begin, Date end) {
        String query = "INSERT INTO reservations(room_number, guest_id, reservation_date, date_begin, date_end)"
                + " VALUES (" + room + "," + guest + ",'" + reservDate + "','" + begin + "','" + end + "')";
        return query;
    }

    //обновлений полей во вкладке "персональные данные"
    private void updatePersonalInfoTab() {
        try {
            ResultSet results;
            results = stmt.executeQuery(guestByIdQuery(guestID));
            results.next();

            surnameField.setText(results.getString(1));
            nameField.setText(results.getString(2));
            patrnameField.setText(results.getString(3));
            passportField.setText(results.getString(4));
            countryField.setText(results.getString(5));
            cityField.setText(results.getString(6));
            streetField.setText(results.getString(7));
            houseField.setText(Integer.toString(results.getInt(8)));
            flatField.setText(Integer.toString(results.getInt(9)));
            birthdateField.setText(MyDateFormatter.format(results.getDate(10)));
            pointsField.setText(Integer.toString(results.getInt(11)));

            results.close();
        } catch (SQLException ex) {
            Logger.getLogger(TablesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //разрешение или запрет на редактирование полей во вкладке "персональные данные"
    private void setPersonalInfoEditable(boolean editable) {
        surnameField.setEditable(editable);
        nameField.setEditable(editable);
        patrnameField.setEditable(editable);
        passportField.setEditable(editable);
        countryField.setEditable(editable);
        cityField.setEditable(editable);
        streetField.setEditable(editable);
        houseField.setEditable(editable);
        flatField.setEditable(editable);
        birthdateField.setEditable(editable);
    }

    //Перевод кнопок в режим редактирования и обратно
    private void setButtonsToEditMode(boolean editMode) {
        editButton.setVisible(!editMode);
        saveButton.setVisible(editMode);
        cancelButton.setVisible(editMode);
    }

    //массивы id-шников типов комнат, чтобы заново их не искать
    //используются во вкладке "забронировать"
    private ArrayList<Integer> typeIDs = new ArrayList<>();
    private ArrayList<Integer> classIDs = new ArrayList<>();
    private ArrayList<Integer> viewIDs = new ArrayList<>();

    //получение элементов для полей ввода во вкладке "забронировать"
    private void getItemsForReservationPanel() {
        floorBox.addItem("");
        for (int i = 1; i <= 4; i++) {
            floorBox.addItem(i);
        }

        try {
            ResultSet results;
            results = stmt.executeQuery("SELECT id, type FROM roomtypes;");
            typeBox.addItem("");
            while (results.next()) {
                typeBox.addItem(results.getString(2));
                typeIDs.add(results.getInt(1));
            }
            results.close();
        } catch (SQLException ex) {
            Logger.getLogger(TablesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            ResultSet results;
            results = stmt.executeQuery("SELECT id, class FROM roomclasses;");
            classBox.addItem("");
            while (results.next()) {
                classBox.addItem(results.getString(2));
                classIDs.add(results.getInt(1));
            }
            results.close();
        } catch (SQLException ex) {
            Logger.getLogger(TablesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            ResultSet results;
            results = stmt.executeQuery("SELECT id, view FROM roomviews;");
            viewBox.addItem("");
            while (results.next()) {
                viewBox.addItem(results.getString(2));
                viewIDs.add(results.getInt(1));
            }
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

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        surnameField = new javax.swing.JTextField();
        patrnameField = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();
        passportField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cityField = new javax.swing.JTextField();
        countryField = new javax.swing.JTextField();
        streetField = new javax.swing.JTextField();
        flatField = new javax.swing.JTextField();
        houseField = new javax.swing.JTextField();
        birthdateField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        pointsField = new javax.swing.JTextField();
        editButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        historyButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        historyTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        reservationsButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        reservationsTable = new javax.swing.JTable();
        deleteReservButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        viewBox = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        searchRoomsButton = new javax.swing.JButton();
        floorBox = new javax.swing.JComboBox();
        priceSpinner = new javax.swing.JSpinner();
        typeBox = new javax.swing.JComboBox();
        roomsTablePane = new javax.swing.JScrollPane();
        roomsTable = new javax.swing.JTable();
        classBox = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        dateBeginField = new javax.swing.JTextField();
        dateEndField = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        reserveButton = new javax.swing.JButton();

        jLabel1.setText("Фамилия");

        jLabel2.setText("Имя");

        jLabel3.setText("Отчество");

        jLabel4.setText("Паспорт");

        jLabel5.setText("страна");

        jLabel6.setText("город");

        jLabel7.setText("улица");

        jLabel8.setText("дом");

        jLabel9.setText("кв.");

        jLabel10.setText("Дата рождения");

        jLabel11.setText("Домашний адрес:");

        cityField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cityFieldActionPerformed(evt);
            }
        });

        countryField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countryFieldActionPerformed(evt);
            }
        });

        streetField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                streetFieldActionPerformed(evt);
            }
        });

        flatField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flatFieldActionPerformed(evt);
            }
        });

        houseField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                houseFieldActionPerformed(evt);
            }
        });

        jLabel12.setText("Баллы");

        editButton.setText("Редактировать");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        saveButton.setText("Сохранить");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Отменить");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(surnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(patrnameField, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                    .addComponent(passportField))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(birthdateField, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                        .addContainerGap(129, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(countryField)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                                        .addGap(41, 41, 41)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cityField)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                                        .addGap(46, 46, 46)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                                        .addGap(65, 65, 65))
                                    .addComponent(streetField))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(houseField)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                        .addGap(10, 10, 10)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(flatField)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                                        .addGap(13, 13, 13))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(264, 264, 264))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pointsField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(77, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(saveButton)
                .addGap(18, 18, 18)
                .addComponent(cancelButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {nameField, passportField, patrnameField, surnameField});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(surnameField)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nameField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(patrnameField))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(birthdateField)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                            .addComponent(passportField))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(countryField)
                    .addComponent(cityField)
                    .addComponent(streetField)
                    .addComponent(flatField)
                    .addComponent(houseField))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pointsField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editButton, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(25, 25, 25)))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Личные данные", jPanel1);

        historyButton.setText("Открыть мою историю посещений");
        historyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historyButtonActionPerformed(evt);
            }
        });

        historyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(historyTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(historyButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(historyButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Моя история", jPanel2);

        reservationsButton.setText("Показать забронированные мной номера");
        reservationsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservationsButtonActionPerformed(evt);
            }
        });

        reservationsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        reservationsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        reservationsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reservationsTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(reservationsTable);

        deleteReservButton.setText("Удалить");
        deleteReservButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteReservButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(deleteReservButton))
                    .addComponent(reservationsButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reservationsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(deleteReservButton)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Моя бронь", jPanel3);

        jLabel13.setText("Этаж");

        jLabel14.setText("Тип");

        jLabel15.setText("Класс");

        jLabel16.setText("Вид из окна");

        jLabel17.setText("Макс. цена");

        searchRoomsButton.setText("Искать");
        searchRoomsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchRoomsButtonActionPerformed(evt);
            }
        });

        priceSpinner.setModel(new javax.swing.SpinnerNumberModel(3000, 1000, 40000, 100));

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
        roomsTablePane.setViewportView(roomsTable);

        jLabel18.setText("ВЫБЕРИТЕ ПОДХОДЯЩИЙ НОМЕР");

        jLabel19.setText("Сроки брони (ДД.ММ.ГГГГ)");

        jLabel20.setText(" - ");

        reserveButton.setText("Забронировать");
        reserveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reserveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(roomsTablePane, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
                    .addComponent(reserveButton)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel18)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(floorBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(typeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(classBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(viewBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(priceSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(100, 100, 100)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(dateBeginField, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel20)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dateEndField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchRoomsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(typeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(floorBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(classBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(dateBeginField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(dateEndField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel20))
                            .addComponent(priceSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchRoomsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(roomsTablePane, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(reserveButton)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Забронировать номер", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cityFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cityFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cityFieldActionPerformed

    private void countryFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countryFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_countryFieldActionPerformed

    private void streetFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_streetFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_streetFieldActionPerformed

    private void flatFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flatFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_flatFieldActionPerformed

    private void houseFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_houseFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_houseFieldActionPerformed

    private boolean historyIsOpen = false;

    private void historyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyButtonActionPerformed
        if (historyIsOpen) {
            historyTable.setModel(new EmptyTableModel());
            historyButton.setText("Открыть мою историю посещений");
            historyIsOpen = false;
        } else {
            String[] columnNames = {"номер", "дата заселения", "дата выселения", "стоимость", "комментарий"};
            try {
                ResultSet results;
                results = stmt.executeQuery(historyQuery(guestID));
                historyTable.setModel(new MyTableModel(results, columnNames));
                historyButton.setText("Закрыть мою историю посещений");
                historyIsOpen = true;
                results.close();
            } catch (SQLException ex) {
                Logger.getLogger(TablesPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_historyButtonActionPerformed


    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        setPersonalInfoEditable(true);
        setButtonsToEditMode(true);
    }//GEN-LAST:event_editButtonActionPerformed

    private boolean reservationsAreOpen = false;

    private void reservationsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservationsButtonActionPerformed
        if (reservationsAreOpen) {
            reservationsTable.setModel(new EmptyTableModel());
            reservationsButton.setText("Показать забронированные мной номера");
            reservationsAreOpen = false;
            deleteReservButton.setVisible(false);
        } else {
            String[] columnNames = {"№ брони", "номер", "дата бронирования", "старт брони", "конец брони"};
            try {
                ResultSet results;
                results = stmt.executeQuery(reservationsQuery(guestID));
                reservationsTable.setModel(new MyTableModel(results, columnNames));

                reservationsButton.setText("Скрыть забронированные мной номера");
                reservationsAreOpen = true;
                deleteReservButton.setVisible(true);
                deleteReservButton.setEnabled(false);
                results.close();
            } catch (SQLException ex) {
                Logger.getLogger(TablesPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_reservationsButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        //проверка на непустоту полей
        if (surnameField.getText().isEmpty() || nameField.getText().isEmpty()
                || patrnameField.getText().isEmpty() || passportField.getText().isEmpty()
                || countryField.getText().isEmpty() || cityField.getText().isEmpty()
                || streetField.getText().isEmpty() || houseField.getText().isEmpty()
                || flatField.getText().isEmpty() || birthdateField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Все поля обязательны для заполнения", "Ошибка",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        //считываем информацию из полей ввода
        Date birthdate;
        try {
            StringTokenizer st = new StringTokenizer(birthdateField.getText(),
                    " .");
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken()) - 1;
            int year = Integer.parseInt(st.nextToken());
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month, day);
            birthdate = calendar.getTime();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Неверно введена дата рождения.\nФормат: ДД.ММ.ГГГГ",
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //переводим дату в понятный для БД формат
        java.sql.Date birthdateDB = new java.sql.Date(birthdate.getTime());
        int house;
        try {
            house = Integer.parseInt(houseField.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Неверно введен номер дома.\nДопустимо только число.",
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
            // updateTeamFields();
            return;
        }
        int flat;
        try {
            flat = Integer.parseInt(flatField.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Неверно введен номер квартиры.\nДопустимо только число.",
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
            // updateTeamFields();
            return;
        }
        //если дошли досюда, значит поля заполнены корректно
        String surname = surnameField.getText();
        String name = nameField.getText();
        String patrname = patrnameField.getText();
        String passport = passportField.getText();
        String country = countryField.getText();
        String city = cityField.getText();
        String street = streetField.getText();
        //обновление БД
        try {
            stmt.executeUpdate(updateGuestQuery(guestID, surname, name, patrname, passport,
                    country, city, street, house, flat, birthdateDB));
        } catch (SQLException ex) {
            Logger.getLogger(TablesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        //обновление панели
        setButtonsToEditMode(false);
        setPersonalInfoEditable(false);
        updatePersonalInfoTab();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        setButtonsToEditMode(false);
        setPersonalInfoEditable(false);
        updatePersonalInfoTab();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void reservationsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reservationsTableMouseClicked
        deleteReservButton.setEnabled(true);
    }//GEN-LAST:event_reservationsTableMouseClicked

    private void deleteReservButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteReservButtonActionPerformed
        int row = reservationsTable.getSelectedRow();
        int reservID = Integer.parseInt((String) reservationsTable.getModel().getValueAt(row, 0));
        String[] opts = {"Да", "Нет"};
        int n = JOptionPane.showOptionDialog(this, "Вы действительно хотите удалить бронь?", "",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, opts, "Нет");
        switch (n) {
            case JOptionPane.YES_OPTION:
                try {
                    stmt.executeUpdate(deleteReservationQuery(reservID));
                    //по-хорошему, тут должно быть удаление строки из таблицы,
                    //но мы просто два раза нажмем на кнопку показа брони
                    reservationsButtonActionPerformed(null);
                    reservationsButtonActionPerformed(null);
                } catch (SQLException ex) {
                    Logger.getLogger(TablesPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case JOptionPane.NO_OPTION:
                break;
            case JOptionPane.CLOSED_OPTION:
                break;
            default:
        }
    }//GEN-LAST:event_deleteReservButtonActionPerformed

    //получение введенных сроков брони; 
    // возвращает false при некорректности введенных дат
    private boolean getReservationDates(java.sql.Date[] reservDates) {
        if (dateBeginField.getText().isEmpty() || dateEndField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Укажите сроки брони.", "Ошибка",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        Date dateBegin;
        try {
            StringTokenizer st = new StringTokenizer(dateBeginField.getText(),
                    " .");
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken()) - 1;
            int year = Integer.parseInt(st.nextToken());
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month, day);
            dateBegin = calendar.getTime();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Неверно введена дата начала брони.\nФормат: ДД.ММ.ГГГГ",
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        Date dateEnd;
        try {
            StringTokenizer st = new StringTokenizer(dateEndField.getText(),
                    " .");
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken()) - 1;
            int year = Integer.parseInt(st.nextToken());
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month, day);
            dateEnd = calendar.getTime();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Неверно введена дата окончания брони.\nФормат: ДД.ММ.ГГГГ",
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (dateEnd.before(dateBegin)) {
            JOptionPane.showMessageDialog(this,
                    "Дата окончания брони должна быть позже даты начала.",
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (dateBegin.before(new Date())) {
            JOptionPane.showMessageDialog(this,
                    "Дата начала брони не должна быть раньше текущей даты.",
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        //переводим дату в понятный для БД формат
        java.sql.Date dateBeginDB = new java.sql.Date(dateBegin.getTime());
        java.sql.Date dateEndDB = new java.sql.Date(dateEnd.getTime());
        reservDates[0] = dateBeginDB;
        reservDates[1] = dateEndDB;
        return true;
    }

    private Date mDateBegin, mDateEnd = new Date();

    private void searchRoomsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchRoomsButtonActionPerformed
        java.sql.Date[] reservDates = new java.sql.Date[2];
        //Date dateBegin, dateEnd;
        if (getReservationDates(reservDates)) {
            mDateBegin = reservDates[0];
            mDateEnd = reservDates[1];
        } else {
            return;
        }
        //названия столбцов таблицы
        String[] columnNames = {"номер", "этаж", "тип", "класс", "вид", "цена"};
        try {
            ResultSet results;
            results = stmt.executeQuery(roomsForReservationQuery(mDateBegin, mDateEnd));
            roomsTable.setModel(new MyTableModel(results, columnNames));
            reserveButton.setVisible(true);
            reserveButton.setEnabled(false);
            results.close();
        } catch (SQLException ex) {
            Logger.getLogger(TablesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchRoomsButtonActionPerformed

    private void reserveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reserveButtonActionPerformed
        int row = roomsTable.getSelectedRow();
        int roomNumber = Integer.parseInt((String) roomsTable.getModel().getValueAt(row, 0));
        try {
            stmt.executeUpdate(createReservationQuery(roomNumber, guestID, 
                    new java.sql.Date(new Date().getTime()), mDateBegin, mDateEnd));
            JOptionPane.showMessageDialog(this, "Номер забронирован!", "", JOptionPane.INFORMATION_MESSAGE);
            searchRoomsButtonActionPerformed(null);
        } catch (SQLException ex) {
            Logger.getLogger(TablesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_reserveButtonActionPerformed

    private void roomsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomsTableMouseClicked
        reserveButton.setEnabled(true);
    }//GEN-LAST:event_roomsTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField birthdateField;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField cityField;
    private javax.swing.JComboBox classBox;
    private javax.swing.JTextField countryField;
    private javax.swing.JTextField dateBeginField;
    private javax.swing.JTextField dateEndField;
    private javax.swing.JButton deleteReservButton;
    private javax.swing.JButton editButton;
    private javax.swing.JTextField flatField;
    private javax.swing.JComboBox floorBox;
    private javax.swing.JButton historyButton;
    private javax.swing.JTable historyTable;
    private javax.swing.JTextField houseField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField passportField;
    private javax.swing.JTextField patrnameField;
    private javax.swing.JTextField pointsField;
    private javax.swing.JSpinner priceSpinner;
    private javax.swing.JButton reservationsButton;
    private javax.swing.JTable reservationsTable;
    private javax.swing.JButton reserveButton;
    private javax.swing.JTable roomsTable;
    private javax.swing.JScrollPane roomsTablePane;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton searchRoomsButton;
    private javax.swing.JTextField streetField;
    private javax.swing.JTextField surnameField;
    private javax.swing.JComboBox typeBox;
    private javax.swing.JComboBox viewBox;
    // End of variables declaration//GEN-END:variables
}

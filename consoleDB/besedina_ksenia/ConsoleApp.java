package myapp;

import java.sql.*;
import java.util.Scanner;

public class ConsoleApp {
	String url = "jdbc:mysql://localhost:3306/";
    String dbName = "tableapp";
    String driver = "com.mysql.jdbc.Driver";
    String userName = "root";
    String password = "root";
	private static String dbURL = "jdbc:mysql://localhost:3306/tableapp?user=root&password=root";
    private static String tableCustomers = "customers";
    private static String tableGoods = "goods";
    private static String tableProcreator = "procreator";
    private static String tableOrders = "orders";
    private static String tableCreditCard = "credit_card";
    private static String tablePoint = "point";
    private static String tableDelivery = "delivery";
    private static String tableWallet = "e_wallet";
    private static String tableGoodsOrders = "goods_orders";
    private static Connection conn = null;
    private static Statement stmt = null;

	public static void main(String[] args) {
		createConnection();

        selectTable();

		shutdown();
	}

    private static void selectTable() {
        String tables[] = {"Покупатели", "Товары", "Производители",
                "Кредитные карты", "Заказы", "Точки выдачи", "Доставка",
                "Электронные кошельки","Товары/Заказы"};
        for(int i=0;i<tables.length; i++) {
            System.out.println((i+1) + ") " + tables[i]);
        }
        System.out.println("Введите номер таблицы, которую Вы хотите вывести (0 для выхода): ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        while(number!=0) {
            switch (number) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    selectCustomers();
                    break;
                case 2:
                    selectGoods();
                    break;
                case 3:
                    selectProcreator();
                    break;
                case 4:
                    selectCreditCard();
                    break;
                case 5:
                    selectOrders();
                    break;
                case 6:
                    selectPoint();
                    break;
                case 7:
                    selectDelivery();
                    break;
                case 8:
                    selectWallet();
                    break;
                case 9:
                    selectGoodsOrders();
                    break;
            }
            System.out.println("Введите номер таблицы, которую Вы хотите вывести (0 для выхода): ");
            number = sc.nextInt();
        }


    }
	private static void createConnection()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection(dbURL);
            System.out.println("Connection established");
        }
        catch (Exception except)
        {
            except.printStackTrace();
        }
    }
//Вывод таблицы "Покупатели"
	private static void selectCustomers()
    {
        try
        {
            System.out.println("\n\n\t\t\t\t\t\tПокупатели\n" + "\n------------------------------------------" +
                    "-------------------------------------------------------" +
                    "-------------------------------------------------------");

            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("select * from " + tableCustomers);
            ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();
            for (int i=1; i<=numberCols; i++)
            {
                System.out.print(rsmd.getColumnLabel(i)+"\t\t\t");
            }

            System.out.println("\n------------------------------------------" +
                    "-------------------------------------------------------" +
                    "-------------------------------------------------------");

            String format = "%-16s%-16s%-20s%-19s%-17s%-16s%-20s%-16s%-16s%n";
            while(results.next())
            {
                String login = results.getString(1);
                String password = results.getString(2);
                String e_mail = results.getString(3);
                String t_number = results.getString(4);
                String surname = results.getString(5);
                String name = results.getString(6);
                String patronymic = results.getString(7);
                String address = results.getString(8);
                String date_of_b = results.getString(9);

                System.out.printf(format, login, password, e_mail, t_number, surname, name, patronymic, address, date_of_b);
            }
            results.close();
            stmt.close();

            System.out.println("------------------------------------------" +
                    "-------------------------------------------------------" +
                    "-------------------------------------------------------");
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    }
    //Вывод таблицы "Товары"
    private static void selectGoods()
    {
        try
        {
            System.out.println("\n\n\t\t\t\t\t\tТовары\n" + "\n----------------------------------------------" +
                    "-----------------------------------------------------------" +
                    "-----------------------------------------------------------");

            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("select * from " + tableGoods);
            ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();
            for (int i=1; i<=numberCols; i++)
            {
                System.out.print(rsmd.getColumnLabel(i)+"\t\t");
            }

            System.out.println("\n----------------------------------------------" +
                    "-----------------------------------------------------------" +
                    "-----------------------------------------------------------");

            String format = "%-12s%-16s%-16s%-12s%-12s%-12s%-12s%-12s%-12s%-16s%-16s%-12s%n";
            while(results.next())
            {
                int id_gds = results.getInt(1);
                String name_gts = results.getString(2);
                String specifics = results.getString(3);
                String price = results.getString(4);
                Float weight = results.getFloat(5);
                Float length = results.getFloat(6);
                Float width = results.getFloat(7);
                Float height = results.getFloat(8);
                String image = results.getString(9);
                String category = results.getString(10);
                String subcategory = results.getString(11);
                String name_creator = results.getString(12);

                System.out.printf(format, id_gds, name_gts, specifics, price, weight, length, width, height, image, category, subcategory,name_creator);
            }
            results.close();
            stmt.close();

            System.out.println("-----------------------------------------------" +
                    "----------------------------------------------------------" +
                    "----------------------------------------------------------");
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    }
    //Вывод таблицы "Производители"
    private static void selectProcreator()
    {
        try
        {
            System.out.println("\n\n\t\t\t\t\t\tПроизводители\n" +
                    "\n------------------------------------------------------------------------");

            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("select * from " + tableProcreator);
            ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();
            for (int i=1; i<=numberCols; i++)
            {
                System.out.print(rsmd.getColumnLabel(i)+"\t\t\t");
            }

            System.out.println("\n------------------------------------------------------------------------");

            String format = "%-23s%-17s%-16s%-12s%n";
            while(results.next())
            {
                String name_creator = results.getString(1);
                String t_number = results.getString(2);
                String fax = results.getString(3);
                String e_mail = results.getString(4);

                System.out.printf(format, name_creator, t_number, fax, e_mail);
            }
            results.close();
            stmt.close();

            System.out.println("-------------------------------------------------------------------------");
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    }
     //Вывод таблицы "Кредитные карты"
    private static void selectCreditCard()
    {
        try
        {
            System.out.println("\n\n\t\t\t\t\t\tКредитные карты\n" +
                    "\n---------------------------------------------------------------------------------------");

            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("select * from " + tableCreditCard);
            ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();
            for (int i=1; i<=numberCols; i++)
            {
                System.out.print(rsmd.getColumnLabel(i)+"\t\t");
            }

            System.out.println("\n---------------------------------------------------------------------------------------");

            String format = "%-12s%-12s%-12s%-16s%-12s%-12s%-12s%n";
            while(results.next())
            {
                int id_card = results.getInt(1);
                String login = results.getString(2);
                String pr_code = results.getString(3);
                String date_close = results.getString(4);
                String surname = results.getString(5);
                String name = results.getString(6);
                String patronymic=results.getString(7);

                System.out.printf(format, id_card, login, pr_code, date_close, surname, name, patronymic);
            }
            results.close();
            stmt.close();

            System.out.println("---------------------------------------------------------------------------------------");
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    }
    //Вывод таблицы "Заказы"
    private static void selectOrders()
    {
        try
        {
            System.out.println("\n\n\t\t\t\t\t\tЗаказы\n" +
                    "\n----------------------------------------------------------------------" +
                    "-------------------------------------------------------------------------");

            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("select * from " + tableOrders);
            ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();
            for (int i=1; i<=numberCols; i++)
            {
                System.out.print(rsmd.getColumnLabel(i)+"\t\t\t");
            }

            System.out.println("\n-----------------------------------------------------------------" +
                    "------------------------------------------------------------------------------");

            String format = "%-20s%-16s%-21s%-23s%-20s%-16s%-16s%-12s%n";
            while(results.next())
            {
                int id_orders = results.getInt(1);
                String login = results.getString(2);
                String type_pay = results.getString(3);
                String type_receipt = results.getString(4);
                String sum_price = results.getString(5);
                String date = results.getString(6);
                String state =results.getString(7);
                String name_point =results.getString(8);

                System.out.printf(format, id_orders, login, type_pay, type_receipt, sum_price, date, state, name_point);
            }
            results.close();
            stmt.close();

            System.out.println("------------------------------------------------------------------" +
                    "-----------------------------------------------------------------------------");
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    }
    //Вывод таблицы "Точки выдачи"
    private static void selectPoint()
    {
        try
        {
            System.out.println("\n\n\t\t\t\t\t\tТочки выдачи\n" +
                    "\n-------------------------------------------------------------------------------");

            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("select * from " + tablePoint);
            ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();
            for (int i=1; i<=numberCols; i++)
            {
                System.out.print(rsmd.getColumnLabel(i)+"\t\t");
            }

            System.out.println("\n-------------------------------------------------------------------------------");

            String format = "%-13s%-17s%-20s%-17s%-12s%n";
            while(results.next())
            {
                String name_point = results.getString(1);
                String addres = results.getString(2);
                String time_opening = results.getString(3);
                String time_closing = results.getString(4);
                String t_namber = results.getString(5);


                System.out.printf(format, name_point, addres, time_opening, time_closing, t_namber);
            }
            results.close();
            stmt.close();

            System.out.println("-------------------------------------------------------------------------------");
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    }
    //Вывод таблицы "Доставка"
    private static void selectDelivery()
    {
        try
        {
            System.out.println("\n\n\t\t\t\t\t\tДоставка\n" +
                    "\n-------------------------------------------------------------------------------------" +
                    "---------------------------------------------------------------------------------------");

            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("select * from " + tableDelivery);
            ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();
            for (int i=1; i<=numberCols; i++)
            {
                System.out.print(rsmd.getColumnLabel(i)+"\t\t\t");
            }

            System.out.println("\n-------------------------------------------------------------------------------------" +
                               "---------------------------------------------------------------------------------------");

            String format = "%-20s%-20s%-20s%-24s%-22s%-14s%-24s%-12s%n";
            while(results.next())
            {
                int id_orders = results.getInt(1);
                String sum_weight = results.getString(2);
                String sum_volume = results.getString(3);
                String date_delivery = results.getString(4);
                String price_delivery = results.getString(5);
                String state = results.getString(6);
                String district=results.getString(7);
                String type_delivery=results.getString(8);

                System.out.printf(format, id_orders, sum_weight, sum_volume, date_delivery, price_delivery, state, district, type_delivery);
            }
            results.close();
            stmt.close();

            System.out.println("-------------------------------------------------------------------------------------" +
                             "---------------------------------------------------------------------------------------");
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    }
    //Вывод таблицы "Электронные кошельки"
    private static void selectWallet()
    {
        try
        {
            System.out.println("\n\n\tЭлектронные кошельки\n" +
                    "\n----------------------------");

            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("select * from " + tableWallet);
            ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();
            for (int i=1; i<=numberCols; i++)
            {
                System.out.print(rsmd.getColumnLabel(i)+"\t\t\t");
            }

            System.out.println("\n----------------------------");

            String format = "%-20s%-12s%n";
            while(results.next())
            {
                String id_wallet = results.getString(1);
                String login = results.getString(2);

                System.out.printf(format, id_wallet, login);
            }
            results.close();
            stmt.close();

            System.out.println("----------------------------");
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    }
    //Вывод таблицы "Товары/Заказы"
    private static void selectGoodsOrders()
    {
        try
        {
            System.out.println("\n\n\t\t\t\t\t\tТовары/Заказы\n" +
                    "\n----------------------");

            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("select * from " + tableGoodsOrders);
            ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();
            for (int i=1; i<=numberCols; i++)
            {
                System.out.print(rsmd.getColumnLabel(i)+"\t\t");
            }

            System.out.println("\n----------------------");

            String format = "%-12s%-12s%n";
            while(results.next())
            {
                int id_gds = results.getInt(1);
                int id_orders = results.getInt(1);

                System.out.printf(format, id_gds, id_orders);
            }
            results.close();
            stmt.close();

            System.out.println("----------------------");
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    }

	private static void shutdown()
    {
        try
        {
            if (stmt != null)
            {
                stmt.close();
            }
            if (conn != null)
            {
                DriverManager.getConnection(dbURL + ";shutdown=true");
                conn.close();
            }
        }
        catch (SQLException sqlExcept)
        {

        }

    }

}

using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using MySql.Data.MySqlClient;

namespace WindowsFormsApplication3
{
    public partial class Form5 : Form
    {
        public Form5()
        {
            InitializeComponent();
        }

        private void touristsBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.touristsBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.tourDataSet);

        }

        private void Form5_Load(object sender, EventArgs e)
        {
            MySqlConnection myConnection = new MySqlConnection("Database=tour;Data Source=127.0.0.1;User Id=root ;password=root");
            MySqlDataAdapter adapter = new MySqlDataAdapter("select * from hotel", myConnection);
            DataTable table = new DataTable();
            myConnection.Open();//Устанавливаем соединение .
            adapter.Fill(table);
            HotelIdcomboBox.DataSource = table;
            HotelIdcomboBox.DisplayMember = "Country";
            HotelIdcomboBox.ValueMember = "id";
            myConnection.Close();// закрываем соединение! 


            // TODO: данная строка кода позволяет загрузить данные в таблицу "tourDataSet.tourists". При необходимости она может быть перемещена или удалена.
            this.touristsTableAdapter.Fill(this.tourDataSet.tourists);

        }

        private void touristsDataGridView_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            panel1.Visible = true;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            panel1.Visible = false;
        }

        private void button2_Click(object sender, EventArgs e)
        {
             
             MySqlConnection conn = new MySqlConnection("Database=tour;Data Source=127.0.0.1;User Id=root ;password=root");
             conn.Open();
            MySqlCommand cmd = new MySqlCommand("call neww()",conn);

            MySqlDataReader dr = cmd.ExecuteReader();
            dr.Read();
            //MySqlCommand myCommand = conn.CreateCommand();
             //myCommand.CommandType = CommandType.StoredProcedure;
             //myCommand.CommandText = "call info()";
            // MySqlDataReader dr = myCommand.ExecuteReader();
            //DataRow row;
            

            textBox1.Text = dr[0].ToString(); 
             conn.Close(); 
             

            /*MySqlConnection conn = new MySqlConnection("Database=tour;Data Source=127.0.0.1;User Id=root ;password=root");
            MySqlCommand myCommand = conn.CreateCommand();
            myCommand.CommandType = CommandType.StoredProcedure;
            myCommand.CommandText = "info()";
            conn.Open();
            myCommand.ExecuteNonQuery();
            conn.Close();
            touristsTableAdapter.Fill(this.tourDataSet.tourists);*/
            // int position =Navigator.BindingSource.Position;

            //  this.touristsTableAdapter.Fill(this.sportclubDataSet.clients);

            //  bindingNavigator.BindingSource.Position = position;
        }

        private void button3_Click(object sender, EventArgs e)
        {
            MySqlConnection conn = new MySqlConnection("Database=tour;Data Source=127.0.0.1;User Id=root ;password=root");
            conn.Open();
            MySqlCommand cmd = new MySqlCommand("call proc_2()", conn);

            MySqlDataReader dr = cmd.ExecuteReader();
            dr.Read();

            textBox2.Text = dr[0].ToString();
            conn.Close(); 

        }
    }
}

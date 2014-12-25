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
    public partial class Form6 : Form
    {
        public Form6()
        {
            InitializeComponent();
        }

        private void reservationBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.reservationBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.tourDataSet);

        }

        private void Form6_Load(object sender, EventArgs e)
        {

            MySqlConnection myConnection = new MySqlConnection("Database=tour;Data Source=127.0.0.1;User Id=root ;password=root");
            MySqlDataAdapter adapter = new MySqlDataAdapter("select * from customer", myConnection);
            DataTable table = new DataTable();
            myConnection.Open();//Устанавливаем соединение .
            adapter.Fill(table);
            CustomerIdcomboBox.DataSource = table;
            CustomerIdcomboBox.DisplayMember = "FIO";
            CustomerIdcomboBox.ValueMember = "id";

                        MySqlDataAdapter adapter1 = new MySqlDataAdapter("select * from tourists", myConnection);
            DataTable table1 = new DataTable();
            //myConnection.Open();
            adapter1.Fill(table1);
            TouristIdcomboBox.DataSource = table1;
            TouristIdcomboBox.DisplayMember = "Surname";
            TouristIdcomboBox.ValueMember = "id";
            myConnection.Close();// закрываем соединение! 
            
            
            
            // TODO: данная строка кода позволяет загрузить данные в таблицу "tourDataSet.reservation". При необходимости она может быть перемещена или удалена.
            this.reservationTableAdapter.Fill(this.tourDataSet.reservation);

        }

        private void reservationDataGridView_CellContentClick(object sender, DataGridViewCellEventArgs e)
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

            MySqlDataAdapter filter = new MySqlDataAdapter("select * from reservation where K_days " + textBox1.Text , conn);
            DataTable table = new DataTable();
            filter.Fill(table);
            reservationDataGridView.DataSource = table;
        }
    }
}

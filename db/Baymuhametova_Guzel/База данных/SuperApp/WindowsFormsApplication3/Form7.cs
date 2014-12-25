using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.Common;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using MySql.Data.MySqlClient;

namespace WindowsFormsApplication3
{
    public partial class Form7 : Form
    {
        public Form7()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            MySqlConnection conn = new MySqlConnection("Database=tour;Data Source=127.0.0.1;User Id=root ;password=root");
            conn.Open();
            MySqlCommand cmd = new MySqlCommand("call proc_1()", conn);

            MySqlDataReader dr = cmd.ExecuteReader();
            dr.Read();

           
            conn.Close(); 
        }

        private void Form7_Load(object sender, EventArgs e)
        {
            // TODO: данная строка кода позволяет загрузить данные в таблицу "tourDataSet.proc_1". При необходимости она может быть перемещена или удалена.
            this.proc_1TableAdapter.Fill(this.tourDataSet.proc_1);

        }

        private void button2_Click(object sender, EventArgs e)
        {
            MySqlConnection conn = new MySqlConnection("Database=tour;Data Source=127.0.0.1;User Id=root ;password=root");

            dataGridView1.Visible = true;
            dataGridView2.Visible = true;
            dataGridView3.Visible = true;


            string sql = "select * from reservation where id= " + textBox1.Text;
            DataSet dataset1 = new DataSet();
            conn.Open();
            MySqlDataAdapter adapter = new MySqlDataAdapter();
            adapter.SelectCommand = new MySqlCommand(sql, conn);
            adapter.Fill(dataset1);
            dataGridView1.DataSource = dataset1;
            conn.Close();
            /*
            string s = "SELECT * FROM заказчик WHERE [Код договора]=" + textBox1.Text;
            string connectionstrin;
            DataSet dataset2 = new DataSet();
            connectionstrin = "Provider=Microsoft.Jet.OLEDB.4.0;" + @"Data Source=put.mdb";
            OleDbConnection connectio = new OleDbConnection(connectionstrin);
            connectio.Open();
            OleDbDataAdapter dataadapte = new OleDbDataAdapter();
            dataadapte.SelectCommand = new OleDbCommand(s, connectio);
            dataadapte.Fill(dataset2);
            dataGridView2.DataSource = dataset2;
            connectio.Close();

            string sq = "SELECT * FROM туристы WHERE [Код договора]=" + textBox1.Text;
            string connectionstring3;
            DataSet dataset3 = new DataSet();
            connectionstring3 = "Provider=Microsoft.Jet.OLEDB.4.0;" + @"Data Source=put.mdb";
            OleDbConnection connection3 = new OleDbConnection(connectionstring3);
            connection3.Open();
            OleDbDataAdapter dataadapter3 = new OleDbDataAdapter();
            dataadapter3.SelectCommand = new OleDbCommand(sq, connection3);
            dataadapter3.Fill(dataset3);
            dataGridView3.DataSource = dataset3;
            connection3.Close();*/
            
        }
    }
}

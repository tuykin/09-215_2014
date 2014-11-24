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

namespace ShowTables
{
    public partial class Form1 : Form
    {
        String ConStr;
        public Form1()
        {
            InitializeComponent();
            GetTablesNames();
        }

        MySqlConnection myConnectionOpen()
        {
            ConStr = "CharSet=utf8;Database=gai;Data Source=127.0.0.1;User Id=root;Password='1234'";
            MySqlConnection con = new MySqlConnection(ConStr);
            try
            {
                con.Open();
                return con;
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Подключение не установлено! ");
                return null;
            }
        }

        private void GetTablesNames()
        {
            MySqlCommand cmd = new MySqlCommand();
            cmd.CommandText = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES where TABLE_SCHEMA='gai';";
            MySqlConnection con = myConnectionOpen();
            cmd.Connection = con;
            cmd.CommandType = CommandType.Text;
            MySqlDataReader reader = null;

            try
            {
                reader = cmd.ExecuteReader();
            }
            catch (Exception f)
            {
                MessageBox.Show(f.Message);
            }

            if (reader != null)
            {

                StringBuilder str = new StringBuilder();
                while (reader.Read())
                {
                    str.Append(reader[0].ToString());
                    str.Append("\n");
                    comboBox1.Items.Add(reader[0].ToString());
                }
            }
            con.Close();
        }


        private void comboBox1_SelectedIndexChanged_1(object sender, EventArgs e)
        {
            textBox1.Clear();
            MySqlCommand cmd = new MySqlCommand();
            cmd.CommandText = "SELECT * FROM " + comboBox1.Text + ";";
            MySqlConnection con = myConnectionOpen();
            cmd.Connection = con;
            cmd.CommandType = CommandType.Text;
            MySqlDataReader reader = null;
            try
            {
                reader = cmd.ExecuteReader();
            }
            catch (Exception f)
            {
                MessageBox.Show(f.Message);
            }

            if (reader != null)
            {

                while (reader.Read())
                {
                    for (int i = 0; i < reader.FieldCount; i++)
                    {
                        textBox1.Text += reader[i].ToString();
                        textBox1.Text += " ";
                    }
                    textBox1.Text += Environment.NewLine;
                }
            }
            con.Close();
        }

    }
}

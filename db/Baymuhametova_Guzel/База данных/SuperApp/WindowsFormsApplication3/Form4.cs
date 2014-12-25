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
    public partial class Form4 : Form
    {
        public Form4()
        {
            InitializeComponent();
        }

        private void customerBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.customerBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.tourDataSet);

        }

        private void Form4_Load(object sender, EventArgs e)
        {
            // TODO: данная строка кода позволяет загрузить данные в таблицу "tourDataSet.customer". При необходимости она может быть перемещена или удалена.
            this.customerTableAdapter.Fill(this.tourDataSet.customer);

        }

        private void customerDataGridView_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            panel1.Visible = true;
        }

        private void panel1_Paint(object sender, PaintEventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            panel1.Visible = false;
        }

        private void button2_Click(object sender, EventArgs e)
        {

        }

        private void button2_Click_1(object sender, EventArgs e)
        {
            //private void btnRun_p1_Click(object sender, System.EventArgs e) { 
            MySqlConnection conn = new MySqlConnection("Database=tour;Data Source=127.0.0.1;User Id=root ;password=root");
            MySqlCommand myCommand = conn.CreateCommand();
            myCommand.CommandType = CommandType.StoredProcedure;
            myCommand.CommandText = "[proc_p1]";
            // string FamilyParameter = Convert.ToString(txtFamily_p1.Text); 

            // myCommand.Parameters.Add("@Фамилия", MySqlDbType.varchar(45), 50);                                        
            // myCommand.Parameters["@Фамилия"].Value = FamilyParameter; 
            //conn.Open(); 
            MySqlDataReader dataReader = myCommand.ExecuteReader();
            while (dataReader.Read())
            {
                // Создаем переменные, получаем для них значения из объекта dataReader, 
                //используя метод GetТипДанных 
                int id = dataReader.GetInt32(0);
                string Surname = dataReader.GetString(1);
                string HotelId = dataReader.GetString(2);
                //Выводим данные в элемент lbResult_p1 
                //     TextBox2.Items.Add("Код туриста: " + id+ " Фамилия: " + Surname + " Отель в : "+ HotelId); 
            }
            conn.Close();
        }
    }
}

       
    

using System;
using System.Collections.Generic;
using System.Collections;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace DB
{
    public partial class Form1 : Form
    {
        public static ArrayList numbers, agegroups;
        static string connectionString="Data Source=(local)\\sqlexpress;Initial Catalog=sportclub;Integrated Security=True";
        static bool surnamesearch;
        public Form1()
        {
            InitializeComponent();
            SetCurrentLessonsOnDgv();
            SetClientsOnDgv();
            SetToolTips();
            surnamesearch = false;
        }

        public string Agegroup(int id)
        {
            switch (id)
            {
                case 1: return "детская"; 
                case 2: return "взрослая"; 
                case 3: return "нет"; 
            }
            return "error";
        }

        public int Agegroup(string name)
        {
            switch (name)
            {
                case "детская": return 1;
                case "взрослая": return 2;
                case "нет": return 3;
            }
            return 0;
        }

        private void SetSectionsCombobox()
        {
            numbers = new ArrayList();
            agegroups = new ArrayList();
            sectionscombobox.Items.Clear();
            for (int i = 0; i < numberoflessonsDataGridView.Rows.Count-1; i++)
            {
                if (numberoflessonsDataGridView.Rows[i].Cells[0].Value != null)
                    if (idTextBox.Text == numberoflessonsDataGridView.Rows[i].Cells[1].Value.ToString())
                    {
                        for (int j = 0; j < sectionsDataGridView.Rows.Count-1; j++)
                        {
                            if (sectionsDataGridView.Rows[j].Cells[0].Value.ToString() == numberoflessonsDataGridView.Rows[i].Cells[0].Value.ToString())
                            {
                                sectionscombobox.Items.Add(sectionsDataGridView.Rows[j].Cells[1].Value.ToString());
                                numbers.Add(numberoflessonsDataGridView.Rows[i].Cells[2].Value);
                                agegroups.Add(Agegroup(Convert.ToInt32(sectionsDataGridView.Rows[j].Cells[2].Value)));
                            }
                        }
                    }
            }
            if (sectionscombobox.Items.Count != 0)
                sectionscombobox.SelectedIndex = 0;
            else
                sectionscombobox.Text = "";

        }

        private void SetToolTips()
        {
            backbuttontoolTip1.SetToolTip(backclientsbutton, "Вернуться к таблице");
            backbuttontoolTip1.SetToolTip(button1, "Вернуться к полному списку");
            backbuttontoolTip1.SetToolTip(checkinbutton, "Минус одно занятие по выбранной секции\nИзменение даты последнего посещения");
        }

        private void SetClientsOnDgv()
        {
            clientsDataGridView.Columns[0].Width = 25;
            clientsDataGridView.Columns[1].Width = 70;
            clientsDataGridView.Columns[2].Width = 90;
            clientsDataGridView.Columns[3].Width = 70;
            clientsDataGridView.Columns[4].Width = 50;
            clientsDataGridView.Columns[5].Width = 70;
        }

        private void SetCurrentLessonsOnDgv()
        {
            SetCurrentDayOnLabel();

            currDayDgv.Columns[0].Width = 120;
            currDayDgv.Columns[1].Width = 60;
            currDayDgv.Columns[2].Width = 60;
            currDayDgv.Columns[3].Width = 60;
        }

        private void SetCurrentDayOnLabel()
        {
            DateTime dt = DateTime.Today;
            string day = dt.DayOfWeek.ToString();
            switch (day)
            {
                case "Monday": day = "понедельник"; break;
                case "Tuesday": day = "вторник"; break;
                case "Wednesday": day = "среда"; break;
                case "Thursday": day = "четверг"; break;
                case "Friday": day = "пятница"; break;
                case "Saturday": day = "суббота"; break;
                case "Sunday": day = "воскресенье"; break;
            }
            daylabel.Text += day;
        }

        private void Form1_Load(object sender, EventArgs e)
        {
           
            // TODO: данная строка кода позволяет загрузить данные в таблицу "sportclubDataSet.instructorsandlessons". При необходимости она может быть перемещена или удалена.
            this.instructorsandlessonsTableAdapter.Fill(this.sportclubDataSet.instructorsandlessons);
            // TODO: данная строка кода позволяет загрузить данные в таблицу "sportclubDataSet.instructors". При необходимости она может быть перемещена или удалена.
            this.instructorsTableAdapter.Fill(this.sportclubDataSet.instructors);
            // TODO: данная строка кода позволяет загрузить данные в таблицу "sportclubDataSet.schedule". При необходимости она может быть перемещена или удалена.
            this.scheduleTableAdapter.Fill(this.sportclubDataSet.schedule);
            // TODO: данная строка кода позволяет загрузить данные в таблицу "sportclubDataSet.enddates". При необходимости она может быть перемещена или удалена.
            this.enddatesTableAdapter.Fill(this.sportclubDataSet.enddates);
            // TODO: данная строка кода позволяет загрузить данные в таблицу "sportclubDataSet.numberoflessons". При необходимости она может быть перемещена или удалена.
            this.numberoflessonsTableAdapter.Fill(this.sportclubDataSet.numberoflessons);
            
            // TODO: данная строка кода позволяет загрузить данные в таблицу "sportclubDataSet.sections". При необходимости она может быть перемещена или удалена.
            this.sectionsTableAdapter.Fill(this.sportclubDataSet.sections);
            // TODO: данная строка кода позволяет загрузить данные в таблицу "sportclubDataSet.clients". При необходимости она может быть перемещена или удалена.
            this.clientsTableAdapter.Fill(this.sportclubDataSet.clients);
            // TODO: данная строка кода позволяет загрузить данные в таблицу "sportclubDataSet.select_curr_day_sched". При необходимости она может быть перемещена или удалена.
            this.select_curr_day_schedTableAdapter.Fill(this.sportclubDataSet.select_curr_day_sched);

        }

        private void tabControl1_SelectedIndexChanged(object sender, EventArgs e)
        {
            switch (tabControl1.SelectedIndex)
            {
                case 0:
                    bindingNavigator.Enabled = false;
                    break;
                case 1:
                    bindingNavigator.BindingSource = clientsBindingSource;
                    if (clientspanel.Visible)
                    {
                        bindingNavigator.Enabled = true;
                    }
                    break;
                case 2:
                    break;
            }
        }

        private void clientsDataGridView_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            clientspanel.Visible = true;
            clientsDataGridView.Visible = false;
            surnamesearchLabel.Visible = false;
            surnamesearchTextBox.Visible = false;
            surnamesearchButton.Visible = false;
            button1.Visible = false;
            if (!surnamesearch)
            {
                bindingNavigator.Enabled = true;               
            }
        }

        private void backclientsbutton_Click(object sender, EventArgs e)
        {
            clientsDataGridView.Visible = true;
            clientspanel.Visible = false;
            surnamesearchLabel.Visible = true;
            surnamesearchTextBox.Visible = true;
            surnamesearchButton.Visible = true;
            bindingNavigator.Enabled = false;
            if (surnamesearch)
                button1.Visible = true;
        }

        private void bindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.clientsBindingSource.EndEdit();
            //this.BindingSource.EndEdit();
            //this.sellersBindingSource.EndEdit();
            MessageBox.Show("Сохранено");
            try
            {
                this.tableAdapterManager.UpdateAll(this.sportclubDataSet);
            }
            catch (Exception exc)
            {
                MessageBox.Show("Проблема с updateAll\n" + exc.Message);
            }
        }

        private void bindingNavigatorAddNewItem_Click(object sender, EventArgs e)
        {
            idTextBox.Text = "1";
        }

        private void idsearch_TextChanged(object sender, EventArgs e)
        {
            for (int i = 0; i < clientsDataGridView.Rows.Count; i++)
            {
                if(clientsDataGridView.Rows[i].Cells[0].Value!=null)
                if (idsearch.Text == clientsDataGridView.Rows[i].Cells[0].Value.ToString())
                    bindingNavigator.BindingSource.Position = i;
            }
        }

        private void surnamesearchButton_Click(object sender, EventArgs e)
        {
            this.clientsTableAdapter.FillBy(this.sportclubDataSet.clients, surnamesearchTextBox.Text);
            bindingNavigator.Enabled = false;
            button1.Visible = true;
            surnamesearch = true;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            this.clientsTableAdapter.Fill(this.sportclubDataSet.clients);
            button1.Visible = false;
            surnamesearch = false;
        }

        private void idTextBox_TextChanged(object sender, EventArgs e)
        {
            SetSectionsCombobox();
        }

        private void sectionscombobox_SelectedIndexChanged(object sender, EventArgs e)
        {
            numberoflessonstextBox.Text = numbers[sectionscombobox.SelectedIndex].ToString();
            agegrouptextBox.Text = agegroups[sectionscombobox.SelectedIndex].ToString();
        }


    }
}

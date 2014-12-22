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
        public static ArrayList numbers, agegroups, sectionids, enddates, agegroups2, sectionids2, typesofsub;
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

        public static string Agegroup(int id)
        {
            switch (id)
            {
                case 1: return "детская"; 
                case 2: return "взрослая"; 
                case 3: return "нет"; 
            }
            return "error";
        }

        public static int Agegroup(string name)
        {
            switch (name)
            {
                case "детская": return 1;
                case "взрослая": return 2;
                case "нет": return 3;
            }
            return 0;
        }

        public string TypeOfSub(int id)
        {
            switch (id)
            {
                case 1: return "дневной";
                case 2: return "вечерний";
                case 3: return "полный";
            }
            return "error";
        }

        public int TypeOfSub(string name)
        {
            switch (name)
            {
                case "дневной": return 1;
                case "вечерний": return 2;
                case "полный": return 3;
            }
            return 0;
        }

        private void SetSectionsCombobox()
        {
            numbers = new ArrayList();
            agegroups = new ArrayList();
            sectionids = new ArrayList();
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
                                sectionids.Add(sectionsDataGridView.Rows[j].Cells[0].Value);
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

        private void SetDateSectionsCombobox()
        {
            typesofsub = new ArrayList();
            enddates = new ArrayList();
            agegroups2 = new ArrayList();
            sectionids2 = new ArrayList();
            sectionscombobox2.Items.Clear();
            for (int i = 0; i < enddatesDataGridView.Rows.Count - 1; i++)
            {
                if (enddatesDataGridView.Rows[i].Cells[0].Value != null)
                    if (idTextBox.Text == enddatesDataGridView.Rows[i].Cells[0].Value.ToString())
                    {
                        for (int j = 0; j < sectionsDataGridView.Rows.Count - 1; j++)
                        {
                            if (sectionsDataGridView.Rows[j].Cells[0].Value.ToString() == enddatesDataGridView.Rows[i].Cells[1].Value.ToString())
                            {
                                sectionscombobox2.Items.Add(sectionsDataGridView.Rows[j].Cells[1].Value.ToString());
                                sectionids2.Add(sectionsDataGridView.Rows[j].Cells[0].Value);
                                enddates.Add(enddatesDataGridView.Rows[i].Cells[2].Value);
                                agegroups2.Add(Agegroup(Convert.ToInt32(sectionsDataGridView.Rows[j].Cells[2].Value)));
                                typesofsub.Add(TypeOfSub(Convert.ToInt32(enddatesDataGridView.Rows[i].Cells[3].Value)));
                            }
                        }
                    }
            }
            if (sectionscombobox2.Items.Count != 0)
                sectionscombobox2.SelectedIndex = 0;
            else
                sectionscombobox2.Text = "";

        }

        private void SetToolTips()
        {
            toolTip.SetToolTip(backclientsbutton, "Вернуться к таблице");
            toolTip.SetToolTip(button1, "Вернуться к полному списку");
            toolTip.SetToolTip(checkinbutton, "Минус одно занятие по выбранной секции\nИзменение даты последнего посещения");
            toolTip.SetToolTip(addbutton, "Прибавить количество занятий,\nзаданное в ячейке сверху");
            toolTip.SetToolTip(clearbutton, "Очистить записи, где есть просроченные абонементы");
        }

        private void SetClientsOnDgv()
        {
            clientsDataGridView.Columns[0].Width = 35;
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
            // TODO: данная строка кода позволяет загрузить данные в таблицу "sportclubDataSet.typesofsub". При необходимости она может быть перемещена или удалена.
            this.typesofsubTableAdapter.Fill(this.sportclubDataSet.typesofsub);
            // TODO: данная строка кода позволяет загрузить данные в таблицу "sportclubDataSet.selectdatesections". При необходимости она может быть перемещена или удалена.
            this.selectdatesectionsTableAdapter.Fill(this.sportclubDataSet.selectdatesections);
            // TODO: данная строка кода позволяет загрузить данные в таблицу "sportclubDataSet.selectnumbersections". При необходимости она может быть перемещена или удалена.
            this.selectnumbersectionsTableAdapter.Fill(this.sportclubDataSet.selectnumbersections);
           
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
            this.numberoflessonsBindingSource.EndEdit();
            this.enddatesBindingSource.EndEdit();
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
            nameTextBox.Select();
            idTextBox.Text = "000";
            toolTip.Show("id будет сгенерирован автоматически", idTextBox, -30, -23);
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
            agegrouptextBox.Text = "";
            numberoflessonstextBox.Text = "";
            SetSectionsCombobox();

            agegroupstextBox2.Text = "";
            typeofsubtextBox.Text = "";
            SetDateSectionsCombobox();
            
        }

        private void sectionscombobox_SelectedIndexChanged(object sender, EventArgs e)
        {
            numberoflessonstextBox.Text = numbers[sectionscombobox.SelectedIndex].ToString();
            agegrouptextBox.Text = agegroups[sectionscombobox.SelectedIndex].ToString();
        }

        private void sectionscombobox2_SelectedIndexChanged(object sender, EventArgs e)
        {
            endTimePicker.Value = Convert.ToDateTime(enddates[sectionscombobox2.SelectedIndex]);
            agegroupstextBox2.Text = agegroups2[sectionscombobox2.SelectedIndex].ToString();
            typeofsubtextBox.Text = typesofsub[sectionscombobox2.SelectedIndex].ToString();
        }

        private void checkinbutton_Click(object sender, EventArgs e)
        {
            int number = 0;
            if (numberoflessonstextBox.Text == "")
            {
                MessageBox.Show("Кажется, у этого клиента еще нет\nкупленных занятий");
                return;
            }
            else
            {
                number = Convert.ToInt32(numberoflessonstextBox.Text);
            }
            lastVisitDateTimePicker.Value = DateTime.Today;
            numberoflessonstextBox.Text = Convert.ToString(number - 1);

            for (int i = 0; i < numberoflessonsDataGridView.Rows.Count - 1; i++)
            {
                if (numberoflessonsDataGridView.Rows[i].Cells[0].Value != null)
                    if (idTextBox.Text == numberoflessonsDataGridView.Rows[i].Cells[1].Value.ToString())
                    {
                        for (int j = 0; j < numberoflessonsDataGridView.Rows.Count - 1; j++)
                        {
                            if (Convert.ToInt32(sectionids[sectionscombobox.SelectedIndex]) == Convert.ToInt32(numberoflessonsDataGridView.Rows[i].Cells[0].Value))
                            {
                                numberoflessonsTableAdapter.Update(number - 1, Convert.ToInt32(sectionids[sectionscombobox.SelectedIndex]), Convert.ToInt32(idTextBox.Text), number);
                                numberoflessonsDataGridView.Rows[i].Cells[2].Value = number - 1;
                                numbers[sectionscombobox.SelectedIndex] = number - 1;
                                //bindingNavigatorSaveItem_Click(sender, e);
                                return;
                            }
                        }
                    }
            }
            
        }

        private void addnumbertextBox_TextChanged(object sender, EventArgs e)
        {
            int number;
            if (!Int32.TryParse(addnumbertextBox.Text, out number) && addnumbertextBox.Text != "")
            {
                MessageBox.Show("Вводите целое число!");
                addnumbertextBox.Text = "";
            }
        }

        private void addbutton_Click(object sender, EventArgs e)
        {
            if(addnumbertextBox.Text == "")
            {
                MessageBox.Show("Нечего добавлять. Введите число");
                return;
            }
            if (numberoflessonstextBox.Text == "")
            {
                MessageBox.Show("Кажется, у этого клиента еще нет купленных занятий\nНужно добавить этому клиенту занятие");
                return;
            }
            if (numberoflessonstextBox.Text == "0")
            {
                MessageBox.Show("Придется заново добавить эту секцию. Так как она автоматически удалилась после того, как количество занятий стало 0");
                return;
            }
            int number = Convert.ToInt32(addnumbertextBox.Text);
            int curnumber = Convert.ToInt32(numberoflessonstextBox.Text);
            for (int i = 0; i < numberoflessonsDataGridView.Rows.Count - 1; i++)
            {
                if (numberoflessonsDataGridView.Rows[i].Cells[0].Value != null)
                    if (idTextBox.Text == numberoflessonsDataGridView.Rows[i].Cells[1].Value.ToString())
                    {
                        for (int j = 0; j < numberoflessonsDataGridView.Rows.Count - 1; j++)
                        {
                            if (Convert.ToInt32(sectionids[sectionscombobox.SelectedIndex]) == Convert.ToInt32(numberoflessonsDataGridView.Rows[i].Cells[0].Value))
                            {
                                numberoflessonsTableAdapter.Update(curnumber+number, Convert.ToInt32(sectionids[sectionscombobox.SelectedIndex]), Convert.ToInt32(idTextBox.Text), curnumber);
                                numberoflessonsDataGridView.Rows[i].Cells[2].Value = number + curnumber;
                                numbers[sectionscombobox.SelectedIndex] = number + curnumber;
                                numberoflessonstextBox.Text = (number + curnumber).ToString();
                                addnumbertextBox.Text = "";
                                //bindingNavigatorSaveItem_Click(sender, e);
                                return;
                            }
                        }
                    }
            }
            
        }

        private void extendbutton_Click(object sender, EventArgs e)
        {
            if (sectionscombobox2.Text == "")
            {
                MessageBox.Show("Нечего продлевать. Нет выбранной секции");
                return;
            }

            DateTime enddate;
            for (int i = 0; i < enddatesDataGridView.Rows.Count - 1; i++)
            {
                if (enddatesDataGridView.Rows[i].Cells[0].Value != null)
                    if (idTextBox.Text == enddatesDataGridView.Rows[i].Cells[0].Value.ToString())
                    {
                        for (int j = 0; j < enddatesDataGridView.Rows.Count - 1; j++)
                        {
                            if (Convert.ToInt32(sectionids2[sectionscombobox2.SelectedIndex]) == Convert.ToInt32(enddatesDataGridView.Rows[i].Cells[1].Value))
                            {
                                enddatesTableAdapter.UpdateQuery(moreTimePicker.Value.ToShortDateString(), Convert.ToInt32(sectionids2[sectionscombobox2.SelectedIndex]), Convert.ToInt32(idTextBox.Text)); 
                                enddatesDataGridView.Rows[i].Cells[2].Value = moreTimePicker.Value;
                                enddates[sectionscombobox.SelectedIndex] = moreTimePicker.Value;
                                endTimePicker.Text = moreTimePicker.Text;
                                //bindingNavigatorSaveItem_Click(sender, e);
                                return;
                            }
                        }
                    }
            }
        }

        private void bindingNavigatorDeleteItem_Click(object sender, EventArgs e)
        {
            if (MessageBox.Show("Вы действительно хотите безвозвратно удалить этого клиента?", "", MessageBoxButtons.YesNo) == DialogResult.Yes)
            {
                    bindingNavigatorSaveItem_Click(sender, e);
                    return;
            }
            else
            {
                    int navigator = bindingNavigator.BindingSource.Position;

                    this.clientsTableAdapter.Fill(this.sportclubDataSet.clients);

                    bindingNavigator.BindingSource.Position = navigator + 1;
            }
        }

        private void addsection_Click(object sender, EventArgs e)
        {
            panel2.Visible = true;
            
        }

        private void addsection2_Click(object sender, EventArgs e)
        {
            panel3.Visible = true;
        }

        private void addsectionbutton_Click(object sender, EventArgs e)
        {
            try
            {
                numberoflessonsTableAdapter.Insert(Convert.ToInt32(textBox3.Text), Convert.ToInt32(idTextBox.Text), Convert.ToInt32(textBox1.Text));
                this.numberoflessonsTableAdapter.Fill(this.sportclubDataSet.numberoflessons);
                SetSectionsCombobox();
                panel2.Visible = false;
            }
            catch (FormatException exc)
            {
                MessageBox.Show("Вы не ввели кол-во занятий");
            }
            catch (SqlException exc)
            {
                MessageBox.Show("У этого клиента уже добавлена данная секция либо вы еще не добавили клиента, но пытаетесь ему добавить занятия\n"+exc.Message);
            }
        }

        private void addsectionsbutton2_Click(object sender, EventArgs e)
        {
            try
            {
                enddatesTableAdapter.Insert(Convert.ToInt32(idTextBox.Text), Convert.ToInt32(textBox4.Text), dateTimePicker1.Value, TypeOfSub(comboBox2.Text));
                this.enddatesTableAdapter.Fill(this.sportclubDataSet.enddates);
                SetDateSectionsCombobox();
                panel3.Visible = false;
            }
            catch (FormatException exc)
            {
                MessageBox.Show("Скорее всего Вы не ввели дату\n"+exc.Message);
            }
            catch (SqlException exc)
            {
                MessageBox.Show("Такая секция уже добавлена, либо вы еще не добавили клиента\n"+exc.Message);
            }
        }

        private void ageGroup_idTextBox_TextChanged(object sender, EventArgs e)
        {
            agegrouptextBox2.Text = Agegroup(Convert.ToInt32(ageGroup_idTextBox.Text));
        }

        private void button2_Click(object sender, EventArgs e)
        {
            panel2.Visible = false;
        }

        private void button3_Click(object sender, EventArgs e)
        {
            panel3.Visible = false;
        }

        private void textBox5_TextChanged(object sender, EventArgs e)
        {
            textBox2.Text = Agegroup(Convert.ToInt32(textBox5.Text));
        }

        private void nullbutton_Click(object sender, EventArgs e)
        {
            if (numberoflessonstextBox.Text == "")
            {
                MessageBox.Show("Кажется, у этого клиента еще нет купленных занятий\nНужно добавить этому клиенту занятие");
                return;
            }
            
            int curnumber = Convert.ToInt32(numberoflessonstextBox.Text);
            for (int i = 0; i < numberoflessonsDataGridView.Rows.Count - 1; i++)
            {
                if (numberoflessonsDataGridView.Rows[i].Cells[0].Value != null)
                    if (idTextBox.Text == numberoflessonsDataGridView.Rows[i].Cells[1].Value.ToString())
                    {
                        for (int j = 0; j < numberoflessonsDataGridView.Rows.Count - 1; j++)
                        {
                            if (Convert.ToInt32(sectionids[sectionscombobox.SelectedIndex]) == Convert.ToInt32(numberoflessonsDataGridView.Rows[i].Cells[0].Value))
                            {
                                numberoflessonsTableAdapter.Update(0, Convert.ToInt32(sectionids[sectionscombobox.SelectedIndex]), Convert.ToInt32(idTextBox.Text), curnumber);
                                numberoflessonsDataGridView.Rows[i].Cells[2].Value = 0;
                                numbers[sectionscombobox.SelectedIndex] = 0;
                                numberoflessonstextBox.Text = (0).ToString();
                                addnumbertextBox.Text = "";
                                //bindingNavigatorSaveItem_Click(sender, e);
                                return;
                            }
                        }
                    }
            }
        }

        private void checkinbutton2_Click(object sender, EventArgs e)
        {
            clientsTableAdapter.UpdateQuery1(DateTime.Today.ToShortDateString(), Convert.ToInt32(idTextBox.Text));
            int position = bindingNavigator.BindingSource.Position;

            this.clientsTableAdapter.Fill(this.sportclubDataSet.clients);

            bindingNavigator.BindingSource.Position = position;
            //lastVisitDateTimePicker.Value = DateTime.Today;
            //bindingNavigatorSaveItem_Click(sender, e);
        }

        private void sectionshedulecombobox_Click(object sender, EventArgs e)
        {

        }

        private void fillToolStripButton_Click(object sender, EventArgs e)
        {
            try
            {
                this.selectdayscheduleTableAdapter.Fill(this.sportclubDataSet.selectdayschedule, textBox6.Text);
            }
            catch (System.Exception ex)
            {
                System.Windows.Forms.MessageBox.Show(ex.Message);
            }

        }

        private void clearbutton_Click(object sender, EventArgs e)
        {
            SqlConnection conn = new SqlConnection(connectionString);
            SqlCommand myCommand = conn.CreateCommand();
            myCommand.CommandType = CommandType.StoredProcedure;
            myCommand.CommandText = "[deleteenddates]";
            conn.Open();
            myCommand.ExecuteNonQuery();
            conn.Close();
            enddatesTableAdapter.Fill(this.sportclubDataSet.enddates);
            int position = bindingNavigator.BindingSource.Position;

            this.clientsTableAdapter.Fill(this.sportclubDataSet.clients);

            bindingNavigator.BindingSource.Position = position;
        }

        private void textBox11_TextChanged(object sender, EventArgs e)
        {
            textBox10.Text = Agegroup(Convert.ToInt32(textBox11.Text));
        }

        private void comboBox3_SelectedIndexChanged(object sender, EventArgs e)
        {
           // fillToolStripButton_Click(sender, e);
        }

    }
}

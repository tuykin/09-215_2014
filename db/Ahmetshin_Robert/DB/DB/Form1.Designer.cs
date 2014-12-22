namespace DB
{
    partial class Form1
    {
        /// <summary>
        /// Требуется переменная конструктора.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Освободить все используемые ресурсы.
        /// </summary>
        /// <param name="disposing">истинно, если управляемый ресурс должен быть удален; иначе ложно.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Код, автоматически созданный конструктором форм Windows

        /// <summary>
        /// Обязательный метод для поддержки конструктора - не изменяйте
        /// содержимое данного метода при помощи редактора кода.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            System.Windows.Forms.Label idLabel;
            System.Windows.Forms.Label nameLabel;
            System.Windows.Forms.Label surnameLabel;
            System.Windows.Forms.Label birthdayLabel;
            System.Windows.Forms.Label isStudentLabel;
            System.Windows.Forms.Label lastVisitLabel;
            System.Windows.Forms.Label numberLabel;
            System.Windows.Forms.Label ageGroup_idLabel;
            System.Windows.Forms.Label label16;
            System.Windows.Forms.Label label17;
            System.Windows.Forms.Label label19;
            System.Windows.Forms.Label label20;
            System.Windows.Forms.Label label21;
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.tabControl1 = new System.Windows.Forms.TabControl();
            this.tabPage1 = new System.Windows.Forms.TabPage();
            this.monthCalendar1 = new System.Windows.Forms.MonthCalendar();
            this.currDayDgv = new System.Windows.Forms.DataGridView();
            this.dataGridViewTextBoxColumn1 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn2 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn3 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn4 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.select_curr_day_schedBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.sportclubDataSet = new DB.sportclubDataSet();
            this.label2 = new System.Windows.Forms.Label();
            this.daylabel = new System.Windows.Forms.Label();
            this.tabPage2 = new System.Windows.Forms.TabPage();
            this.clientspanel = new System.Windows.Forms.Panel();
            this.splitContainer1 = new System.Windows.Forms.SplitContainer();
            this.panel2 = new System.Windows.Forms.Panel();
            this.button2 = new System.Windows.Forms.Button();
            this.addsectionbutton = new System.Windows.Forms.Button();
            this.label14 = new System.Windows.Forms.Label();
            this.agegrouptextBox2 = new System.Windows.Forms.TextBox();
            this.ageGroup_idTextBox = new System.Windows.Forms.TextBox();
            this.selectnumbersectionsBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.label15 = new System.Windows.Forms.Label();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.textBox3 = new System.Windows.Forms.TextBox();
            this.nameComboBox = new System.Windows.Forms.ComboBox();
            this.sectionsBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.addsection = new System.Windows.Forms.Button();
            this.checkinbutton = new System.Windows.Forms.Button();
            this.label7 = new System.Windows.Forms.Label();
            this.sectionscombobox = new System.Windows.Forms.ComboBox();
            this.label6 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.addnumbertextBox = new System.Windows.Forms.TextBox();
            this.numberoflessonstextBox = new System.Windows.Forms.TextBox();
            this.addbutton = new System.Windows.Forms.Button();
            this.agegrouptextBox = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.nullbutton = new System.Windows.Forms.Button();
            this.clearbutton = new System.Windows.Forms.Button();
            this.panel3 = new System.Windows.Forms.Panel();
            this.label23 = new System.Windows.Forms.Label();
            this.comboBox2 = new System.Windows.Forms.ComboBox();
            this.typesofsubBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.button3 = new System.Windows.Forms.Button();
            this.addsectionsbutton2 = new System.Windows.Forms.Button();
            this.label22 = new System.Windows.Forms.Label();
            this.dateTimePicker1 = new System.Windows.Forms.DateTimePicker();
            this.textBox5 = new System.Windows.Forms.TextBox();
            this.selectdatesectionsBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.label18 = new System.Windows.Forms.Label();
            this.textBox2 = new System.Windows.Forms.TextBox();
            this.textBox4 = new System.Windows.Forms.TextBox();
            this.comboBox1 = new System.Windows.Forms.ComboBox();
            this.addsection2 = new System.Windows.Forms.Button();
            this.extendbutton = new System.Windows.Forms.Button();
            this.typeofsubtextBox = new System.Windows.Forms.TextBox();
            this.label13 = new System.Windows.Forms.Label();
            this.agegroupstextBox2 = new System.Windows.Forms.TextBox();
            this.label12 = new System.Windows.Forms.Label();
            this.label8 = new System.Windows.Forms.Label();
            this.moreTimePicker = new System.Windows.Forms.DateTimePicker();
            this.label9 = new System.Windows.Forms.Label();
            this.label11 = new System.Windows.Forms.Label();
            this.sectionscombobox2 = new System.Windows.Forms.ComboBox();
            this.endTimePicker = new System.Windows.Forms.DateTimePicker();
            this.label10 = new System.Windows.Forms.Label();
            this.checkinbutton2 = new System.Windows.Forms.Button();
            this.backclientsbutton = new System.Windows.Forms.Button();
            this.idTextBox = new System.Windows.Forms.TextBox();
            this.clientsBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.nameTextBox = new System.Windows.Forms.TextBox();
            this.surnameTextBox = new System.Windows.Forms.TextBox();
            this.birthdayDateTimePicker = new System.Windows.Forms.DateTimePicker();
            this.isStudentCheckBox = new System.Windows.Forms.CheckBox();
            this.lastVisitDateTimePicker = new System.Windows.Forms.DateTimePicker();
            this.numberTextBox = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.idsearch = new System.Windows.Forms.TextBox();
            this.button1 = new System.Windows.Forms.Button();
            this.surnamesearchButton = new System.Windows.Forms.Button();
            this.surnamesearchLabel = new System.Windows.Forms.Label();
            this.surnamesearchTextBox = new System.Windows.Forms.TextBox();
            this.clientsDataGridView = new System.Windows.Forms.DataGridView();
            this.Column1 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn6 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn7 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn8 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewCheckBoxColumn1 = new System.Windows.Forms.DataGridViewCheckBoxColumn();
            this.dataGridViewTextBoxColumn9 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn10 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.tabPage3 = new System.Windows.Forms.TabPage();
            this.textBox6 = new System.Windows.Forms.TextBox();
            this.comboBox3 = new System.Windows.Forms.ComboBox();
            this.fillToolStrip = new System.Windows.Forms.ToolStrip();
            this.fillToolStripButton = new System.Windows.Forms.ToolStripButton();
            this.selectdayscheduleDataGridView = new System.Windows.Forms.DataGridView();
            this.dataGridViewTextBoxColumn49 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn47 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn48 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.selectdayscheduleBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.panel1 = new System.Windows.Forms.Panel();
            this.typesofsubDataGridView = new System.Windows.Forms.DataGridView();
            this.dataGridViewTextBoxColumn45 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn46 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.selectdatesectionsDataGridView = new System.Windows.Forms.DataGridView();
            this.dataGridViewTextBoxColumn39 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn40 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn41 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn42 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn43 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn44 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewCheckBoxColumn4 = new System.Windows.Forms.DataGridViewCheckBoxColumn();
            this.selectnumbersectionsDataGridView = new System.Windows.Forms.DataGridView();
            this.dataGridViewTextBoxColumn33 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn34 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn35 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn36 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn37 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn38 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewCheckBoxColumn3 = new System.Windows.Forms.DataGridViewCheckBoxColumn();
            this.instructorsandlessonsDataGridView = new System.Windows.Forms.DataGridView();
            this.dataGridViewTextBoxColumn31 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn32 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.instructorsandlessonsBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.instructorsDataGridView = new System.Windows.Forms.DataGridView();
            this.dataGridViewTextBoxColumn27 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn28 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn29 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn30 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.instructorsBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.enddatesDataGridView = new System.Windows.Forms.DataGridView();
            this.dataGridViewTextBoxColumn19 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn20 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn21 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn22 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.enddatesBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.sectionsDataGridView = new System.Windows.Forms.DataGridView();
            this.dataGridViewTextBoxColumn13 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn14 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn15 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn16 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn17 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn18 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewCheckBoxColumn2 = new System.Windows.Forms.DataGridViewCheckBoxColumn();
            this.scheduleDataGridView = new System.Windows.Forms.DataGridView();
            this.dataGridViewTextBoxColumn23 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn24 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn25 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn26 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.scheduleBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.numberoflessonsDataGridView = new System.Windows.Forms.DataGridView();
            this.dataGridViewTextBoxColumn5 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn11 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn12 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.numberoflessonsBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.sectionsBindingSource1 = new System.Windows.Forms.BindingSource(this.components);
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.файлToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.справкаToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.bindingNavigator = new System.Windows.Forms.BindingNavigator(this.components);
            this.bindingNavigatorAddNewItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorCountItem = new System.Windows.Forms.ToolStripLabel();
            this.bindingNavigatorDeleteItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorMoveFirstItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorMovePreviousItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorSeparator = new System.Windows.Forms.ToolStripSeparator();
            this.bindingNavigatorPositionItem = new System.Windows.Forms.ToolStripTextBox();
            this.bindingNavigatorSeparator1 = new System.Windows.Forms.ToolStripSeparator();
            this.bindingNavigatorMoveNextItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorMoveLastItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorSeparator2 = new System.Windows.Forms.ToolStripSeparator();
            this.bindingNavigatorSaveItem = new System.Windows.Forms.ToolStripButton();
            this.toolTip = new System.Windows.Forms.ToolTip(this.components);
            this.select_curr_day_schedTableAdapter = new DB.sportclubDataSetTableAdapters.select_curr_day_schedTableAdapter();
            this.tableAdapterManager = new DB.sportclubDataSetTableAdapters.TableAdapterManager();
            this.clientsTableAdapter = new DB.sportclubDataSetTableAdapters.clientsTableAdapter();
            this.sectionsTableAdapter = new DB.sportclubDataSetTableAdapters.sectionsTableAdapter();
            this.numberoflessonsTableAdapter = new DB.sportclubDataSetTableAdapters.numberoflessonsTableAdapter();
            this.enddatesTableAdapter = new DB.sportclubDataSetTableAdapters.enddatesTableAdapter();
            this.scheduleTableAdapter = new DB.sportclubDataSetTableAdapters.scheduleTableAdapter();
            this.instructorsTableAdapter = new DB.sportclubDataSetTableAdapters.instructorsTableAdapter();
            this.instructorsandlessonsTableAdapter = new DB.sportclubDataSetTableAdapters.instructorsandlessonsTableAdapter();
            this.selectnumbersectionsTableAdapter = new DB.sportclubDataSetTableAdapters.selectnumbersectionsTableAdapter();
            this.selectdatesectionsTableAdapter = new DB.sportclubDataSetTableAdapters.selectdatesectionsTableAdapter();
            this.typesofsubTableAdapter = new DB.sportclubDataSetTableAdapters.typesofsubTableAdapter();
            this.selectdayscheduleTableAdapter = new DB.sportclubDataSetTableAdapters.selectdayscheduleTableAdapter();
            this.textBox7 = new System.Windows.Forms.TextBox();
            this.label24 = new System.Windows.Forms.Label();
            this.textBox8 = new System.Windows.Forms.TextBox();
            this.textBox9 = new System.Windows.Forms.TextBox();
            this.label25 = new System.Windows.Forms.Label();
            this.label26 = new System.Windows.Forms.Label();
            this.textBox10 = new System.Windows.Forms.TextBox();
            this.textBox11 = new System.Windows.Forms.TextBox();
            this.hidepanel = new System.Windows.Forms.Panel();
            this.label27 = new System.Windows.Forms.Label();
            this.label28 = new System.Windows.Forms.Label();
            this.label29 = new System.Windows.Forms.Label();
            idLabel = new System.Windows.Forms.Label();
            nameLabel = new System.Windows.Forms.Label();
            surnameLabel = new System.Windows.Forms.Label();
            birthdayLabel = new System.Windows.Forms.Label();
            isStudentLabel = new System.Windows.Forms.Label();
            lastVisitLabel = new System.Windows.Forms.Label();
            numberLabel = new System.Windows.Forms.Label();
            ageGroup_idLabel = new System.Windows.Forms.Label();
            label16 = new System.Windows.Forms.Label();
            label17 = new System.Windows.Forms.Label();
            label19 = new System.Windows.Forms.Label();
            label20 = new System.Windows.Forms.Label();
            label21 = new System.Windows.Forms.Label();
            this.tabControl1.SuspendLayout();
            this.tabPage1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.currDayDgv)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.select_curr_day_schedBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.sportclubDataSet)).BeginInit();
            this.tabPage2.SuspendLayout();
            this.clientspanel.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.splitContainer1)).BeginInit();
            this.splitContainer1.Panel1.SuspendLayout();
            this.splitContainer1.Panel2.SuspendLayout();
            this.splitContainer1.SuspendLayout();
            this.panel2.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.selectnumbersectionsBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.sectionsBindingSource)).BeginInit();
            this.panel3.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.typesofsubBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.selectdatesectionsBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.clientsBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.clientsDataGridView)).BeginInit();
            this.tabPage3.SuspendLayout();
            this.fillToolStrip.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.selectdayscheduleDataGridView)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.selectdayscheduleBindingSource)).BeginInit();
            this.panel1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.typesofsubDataGridView)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.selectdatesectionsDataGridView)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.selectnumbersectionsDataGridView)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.instructorsandlessonsDataGridView)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.instructorsandlessonsBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.instructorsDataGridView)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.instructorsBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.enddatesDataGridView)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.enddatesBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.sectionsDataGridView)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.scheduleDataGridView)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.scheduleBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.numberoflessonsDataGridView)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.numberoflessonsBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.sectionsBindingSource1)).BeginInit();
            this.menuStrip1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.bindingNavigator)).BeginInit();
            this.bindingNavigator.SuspendLayout();
            this.SuspendLayout();
            // 
            // idLabel
            // 
            idLabel.AutoSize = true;
            idLabel.Location = new System.Drawing.Point(16, 79);
            idLabel.Name = "idLabel";
            idLabel.Size = new System.Drawing.Size(18, 13);
            idLabel.TabIndex = 29;
            idLabel.Text = "id:";
            // 
            // nameLabel
            // 
            nameLabel.AutoSize = true;
            nameLabel.Location = new System.Drawing.Point(16, 105);
            nameLabel.Name = "nameLabel";
            nameLabel.Size = new System.Drawing.Size(30, 13);
            nameLabel.TabIndex = 31;
            nameLabel.Text = "имя:";
            // 
            // surnameLabel
            // 
            surnameLabel.AutoSize = true;
            surnameLabel.Location = new System.Drawing.Point(16, 131);
            surnameLabel.Name = "surnameLabel";
            surnameLabel.Size = new System.Drawing.Size(56, 13);
            surnameLabel.TabIndex = 33;
            surnameLabel.Text = "фамилия:";
            // 
            // birthdayLabel
            // 
            birthdayLabel.AutoSize = true;
            birthdayLabel.Location = new System.Drawing.Point(16, 158);
            birthdayLabel.Name = "birthdayLabel";
            birthdayLabel.Size = new System.Drawing.Size(65, 13);
            birthdayLabel.TabIndex = 35;
            birthdayLabel.Text = "дата рожд.:";
            // 
            // isStudentLabel
            // 
            isStudentLabel.AutoSize = true;
            isStudentLabel.Location = new System.Drawing.Point(16, 185);
            isStudentLabel.Name = "isStudentLabel";
            isStudentLabel.Size = new System.Drawing.Size(49, 13);
            isStudentLabel.TabIndex = 37;
            isStudentLabel.Text = "студент:";
            // 
            // lastVisitLabel
            // 
            lastVisitLabel.AutoSize = true;
            lastVisitLabel.Location = new System.Drawing.Point(16, 212);
            lastVisitLabel.Name = "lastVisitLabel";
            lastVisitLabel.Size = new System.Drawing.Size(67, 26);
            lastVisitLabel.TabIndex = 39;
            lastVisitLabel.Text = "посл.\r\nпосещение:\r\n";
            // 
            // numberLabel
            // 
            numberLabel.AutoSize = true;
            numberLabel.Location = new System.Drawing.Point(16, 251);
            numberLabel.Name = "numberLabel";
            numberLabel.Size = new System.Drawing.Size(45, 13);
            numberLabel.TabIndex = 41;
            numberLabel.Text = "number:";
            // 
            // ageGroup_idLabel
            // 
            ageGroup_idLabel.AutoSize = true;
            ageGroup_idLabel.Location = new System.Drawing.Point(274, 59);
            ageGroup_idLabel.Name = "ageGroup_idLabel";
            ageGroup_idLabel.Size = new System.Drawing.Size(68, 13);
            ageGroup_idLabel.TabIndex = 17;
            ageGroup_idLabel.Text = "ageGroup id:";
            // 
            // label16
            // 
            label16.AutoSize = true;
            label16.Location = new System.Drawing.Point(274, 15);
            label16.Name = "label16";
            label16.Size = new System.Drawing.Size(18, 13);
            label16.TabIndex = 13;
            label16.Text = "id:";
            // 
            // label17
            // 
            label17.AutoSize = true;
            label17.Location = new System.Drawing.Point(5, 14);
            label17.Name = "label17";
            label17.Size = new System.Drawing.Size(96, 13);
            label17.TabIndex = 11;
            label17.Text = "Название секции";
            // 
            // label19
            // 
            label19.AutoSize = true;
            label19.Location = new System.Drawing.Point(274, 6);
            label19.Name = "label19";
            label19.Size = new System.Drawing.Size(18, 13);
            label19.TabIndex = 23;
            label19.Text = "id:";
            // 
            // label20
            // 
            label20.AutoSize = true;
            label20.Location = new System.Drawing.Point(5, 5);
            label20.Name = "label20";
            label20.Size = new System.Drawing.Size(96, 13);
            label20.TabIndex = 21;
            label20.Text = "Название секции";
            // 
            // label21
            // 
            label21.AutoSize = true;
            label21.Location = new System.Drawing.Point(274, 53);
            label21.Name = "label21";
            label21.Size = new System.Drawing.Size(68, 13);
            label21.TabIndex = 27;
            label21.Text = "ageGroup id:";
            // 
            // tabControl1
            // 
            this.tabControl1.Controls.Add(this.tabPage1);
            this.tabControl1.Controls.Add(this.tabPage2);
            this.tabControl1.Controls.Add(this.tabPage3);
            this.tabControl1.Location = new System.Drawing.Point(4, 27);
            this.tabControl1.Name = "tabControl1";
            this.tabControl1.SelectedIndex = 0;
            this.tabControl1.Size = new System.Drawing.Size(639, 374);
            this.tabControl1.TabIndex = 0;
            this.tabControl1.SelectedIndexChanged += new System.EventHandler(this.tabControl1_SelectedIndexChanged);
            // 
            // tabPage1
            // 
            this.tabPage1.AutoScroll = true;
            this.tabPage1.BackColor = System.Drawing.Color.LightGray;
            this.tabPage1.Controls.Add(this.monthCalendar1);
            this.tabPage1.Controls.Add(this.currDayDgv);
            this.tabPage1.Controls.Add(this.label2);
            this.tabPage1.Controls.Add(this.daylabel);
            this.tabPage1.Location = new System.Drawing.Point(4, 22);
            this.tabPage1.Name = "tabPage1";
            this.tabPage1.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage1.Size = new System.Drawing.Size(631, 348);
            this.tabPage1.TabIndex = 0;
            this.tabPage1.Text = "Текущие занятия";
            // 
            // monthCalendar1
            // 
            this.monthCalendar1.Location = new System.Drawing.Point(420, 77);
            this.monthCalendar1.Name = "monthCalendar1";
            this.monthCalendar1.TabIndex = 3;
            // 
            // currDayDgv
            // 
            this.currDayDgv.AutoGenerateColumns = false;
            this.currDayDgv.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.currDayDgv.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.dataGridViewTextBoxColumn1,
            this.dataGridViewTextBoxColumn2,
            this.dataGridViewTextBoxColumn3,
            this.dataGridViewTextBoxColumn4});
            this.currDayDgv.DataSource = this.select_curr_day_schedBindingSource;
            this.currDayDgv.Location = new System.Drawing.Point(19, 77);
            this.currDayDgv.Name = "currDayDgv";
            this.currDayDgv.Size = new System.Drawing.Size(363, 195);
            this.currDayDgv.TabIndex = 2;
            // 
            // dataGridViewTextBoxColumn1
            // 
            this.dataGridViewTextBoxColumn1.DataPropertyName = "name";
            this.dataGridViewTextBoxColumn1.HeaderText = "название";
            this.dataGridViewTextBoxColumn1.Name = "dataGridViewTextBoxColumn1";
            // 
            // dataGridViewTextBoxColumn2
            // 
            this.dataGridViewTextBoxColumn2.DataPropertyName = "name1";
            this.dataGridViewTextBoxColumn2.HeaderText = "возр. группа";
            this.dataGridViewTextBoxColumn2.Name = "dataGridViewTextBoxColumn2";
            // 
            // dataGridViewTextBoxColumn3
            // 
            this.dataGridViewTextBoxColumn3.DataPropertyName = "startTime";
            this.dataGridViewTextBoxColumn3.HeaderText = "начало";
            this.dataGridViewTextBoxColumn3.Name = "dataGridViewTextBoxColumn3";
            // 
            // dataGridViewTextBoxColumn4
            // 
            this.dataGridViewTextBoxColumn4.DataPropertyName = "endTime";
            this.dataGridViewTextBoxColumn4.HeaderText = "конец";
            this.dataGridViewTextBoxColumn4.Name = "dataGridViewTextBoxColumn4";
            // 
            // select_curr_day_schedBindingSource
            // 
            this.select_curr_day_schedBindingSource.DataMember = "select_curr_day_sched";
            this.select_curr_day_schedBindingSource.DataSource = this.sportclubDataSet;
            // 
            // sportclubDataSet
            // 
            this.sportclubDataSet.DataSetName = "sportclubDataSet";
            this.sportclubDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(16, 52);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(130, 13);
            this.label2.TabIndex = 1;
            this.label2.Text = "Сейчас идут занятия по:";
            // 
            // daylabel
            // 
            this.daylabel.AutoSize = true;
            this.daylabel.Location = new System.Drawing.Point(16, 21);
            this.daylabel.Name = "daylabel";
            this.daylabel.Size = new System.Drawing.Size(52, 13);
            this.daylabel.TabIndex = 0;
            this.daylabel.Text = "Сегодня ";
            // 
            // tabPage2
            // 
            this.tabPage2.AutoScroll = true;
            this.tabPage2.BackColor = System.Drawing.Color.LightGray;
            this.tabPage2.Controls.Add(this.clientspanel);
            this.tabPage2.Controls.Add(this.button1);
            this.tabPage2.Controls.Add(this.surnamesearchButton);
            this.tabPage2.Controls.Add(this.surnamesearchLabel);
            this.tabPage2.Controls.Add(this.surnamesearchTextBox);
            this.tabPage2.Controls.Add(this.clientsDataGridView);
            this.tabPage2.Location = new System.Drawing.Point(4, 22);
            this.tabPage2.Name = "tabPage2";
            this.tabPage2.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage2.Size = new System.Drawing.Size(631, 348);
            this.tabPage2.TabIndex = 1;
            this.tabPage2.Text = "Клиенты";
            // 
            // clientspanel
            // 
            this.clientspanel.Controls.Add(this.splitContainer1);
            this.clientspanel.Controls.Add(this.backclientsbutton);
            this.clientspanel.Controls.Add(idLabel);
            this.clientspanel.Controls.Add(this.idTextBox);
            this.clientspanel.Controls.Add(nameLabel);
            this.clientspanel.Controls.Add(this.nameTextBox);
            this.clientspanel.Controls.Add(surnameLabel);
            this.clientspanel.Controls.Add(this.surnameTextBox);
            this.clientspanel.Controls.Add(birthdayLabel);
            this.clientspanel.Controls.Add(this.birthdayDateTimePicker);
            this.clientspanel.Controls.Add(isStudentLabel);
            this.clientspanel.Controls.Add(this.isStudentCheckBox);
            this.clientspanel.Controls.Add(lastVisitLabel);
            this.clientspanel.Controls.Add(this.lastVisitDateTimePicker);
            this.clientspanel.Controls.Add(numberLabel);
            this.clientspanel.Controls.Add(this.numberTextBox);
            this.clientspanel.Controls.Add(this.label1);
            this.clientspanel.Controls.Add(this.idsearch);
            this.clientspanel.Location = new System.Drawing.Point(0, 0);
            this.clientspanel.Name = "clientspanel";
            this.clientspanel.Size = new System.Drawing.Size(625, 342);
            this.clientspanel.TabIndex = 16;
            this.clientspanel.Visible = false;
            // 
            // splitContainer1
            // 
            this.splitContainer1.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.splitContainer1.Location = new System.Drawing.Point(244, 7);
            this.splitContainer1.Name = "splitContainer1";
            this.splitContainer1.Orientation = System.Windows.Forms.Orientation.Horizontal;
            // 
            // splitContainer1.Panel1
            // 
            this.splitContainer1.Panel1.AutoScroll = true;
            this.splitContainer1.Panel1.Controls.Add(this.panel2);
            this.splitContainer1.Panel1.Controls.Add(this.addsection);
            this.splitContainer1.Panel1.Controls.Add(this.checkinbutton);
            this.splitContainer1.Panel1.Controls.Add(this.label7);
            this.splitContainer1.Panel1.Controls.Add(this.sectionscombobox);
            this.splitContainer1.Panel1.Controls.Add(this.label6);
            this.splitContainer1.Panel1.Controls.Add(this.label3);
            this.splitContainer1.Panel1.Controls.Add(this.addnumbertextBox);
            this.splitContainer1.Panel1.Controls.Add(this.numberoflessonstextBox);
            this.splitContainer1.Panel1.Controls.Add(this.addbutton);
            this.splitContainer1.Panel1.Controls.Add(this.agegrouptextBox);
            this.splitContainer1.Panel1.Controls.Add(this.label4);
            this.splitContainer1.Panel1.Controls.Add(this.label5);
            this.splitContainer1.Panel1.Controls.Add(this.nullbutton);
            // 
            // splitContainer1.Panel2
            // 
            this.splitContainer1.Panel2.Controls.Add(this.panel3);
            this.splitContainer1.Panel2.Controls.Add(this.addsection2);
            this.splitContainer1.Panel2.Controls.Add(this.extendbutton);
            this.splitContainer1.Panel2.Controls.Add(this.typeofsubtextBox);
            this.splitContainer1.Panel2.Controls.Add(this.label13);
            this.splitContainer1.Panel2.Controls.Add(this.agegroupstextBox2);
            this.splitContainer1.Panel2.Controls.Add(this.label12);
            this.splitContainer1.Panel2.Controls.Add(this.label8);
            this.splitContainer1.Panel2.Controls.Add(this.moreTimePicker);
            this.splitContainer1.Panel2.Controls.Add(this.label9);
            this.splitContainer1.Panel2.Controls.Add(this.label11);
            this.splitContainer1.Panel2.Controls.Add(this.sectionscombobox2);
            this.splitContainer1.Panel2.Controls.Add(this.endTimePicker);
            this.splitContainer1.Panel2.Controls.Add(this.label10);
            this.splitContainer1.Panel2.Controls.Add(this.checkinbutton2);
            this.splitContainer1.Panel2.Controls.Add(this.clearbutton);
            this.splitContainer1.Size = new System.Drawing.Size(372, 326);
            this.splitContainer1.SplitterDistance = 164;
            this.splitContainer1.TabIndex = 57;
            // 
            // panel2
            // 
            this.panel2.Controls.Add(this.button2);
            this.panel2.Controls.Add(this.addsectionbutton);
            this.panel2.Controls.Add(this.label14);
            this.panel2.Controls.Add(this.agegrouptextBox2);
            this.panel2.Controls.Add(ageGroup_idLabel);
            this.panel2.Controls.Add(this.ageGroup_idTextBox);
            this.panel2.Controls.Add(this.label15);
            this.panel2.Controls.Add(this.textBox1);
            this.panel2.Controls.Add(label16);
            this.panel2.Controls.Add(this.textBox3);
            this.panel2.Controls.Add(label17);
            this.panel2.Controls.Add(this.nameComboBox);
            this.panel2.Location = new System.Drawing.Point(3, 3);
            this.panel2.Name = "panel2";
            this.panel2.Size = new System.Drawing.Size(362, 154);
            this.panel2.TabIndex = 49;
            this.panel2.Visible = false;
            // 
            // button2
            // 
            this.button2.Location = new System.Drawing.Point(208, 83);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(65, 40);
            this.button2.TabIndex = 22;
            this.button2.Text = "Отмена";
            this.button2.UseVisualStyleBackColor = true;
            this.button2.Click += new System.EventHandler(this.button2_Click);
            // 
            // addsectionbutton
            // 
            this.addsectionbutton.Location = new System.Drawing.Point(136, 83);
            this.addsectionbutton.Name = "addsectionbutton";
            this.addsectionbutton.Size = new System.Drawing.Size(66, 40);
            this.addsectionbutton.TabIndex = 21;
            this.addsectionbutton.Text = "Добавить";
            this.addsectionbutton.UseVisualStyleBackColor = true;
            this.addsectionbutton.Click += new System.EventHandler(this.addsectionbutton_Click);
            // 
            // label14
            // 
            this.label14.AutoSize = true;
            this.label14.Location = new System.Drawing.Point(144, 14);
            this.label14.Name = "label14";
            this.label14.Size = new System.Drawing.Size(72, 13);
            this.label14.TabIndex = 20;
            this.label14.Text = "Возр. группа";
            // 
            // agegrouptextBox2
            // 
            this.agegrouptextBox2.Location = new System.Drawing.Point(147, 31);
            this.agegrouptextBox2.Name = "agegrouptextBox2";
            this.agegrouptextBox2.ReadOnly = true;
            this.agegrouptextBox2.Size = new System.Drawing.Size(100, 20);
            this.agegrouptextBox2.TabIndex = 19;
            // 
            // ageGroup_idTextBox
            // 
            this.ageGroup_idTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.selectnumbersectionsBindingSource, "ageGroup_id", true));
            this.ageGroup_idTextBox.Location = new System.Drawing.Point(291, 75);
            this.ageGroup_idTextBox.Name = "ageGroup_idTextBox";
            this.ageGroup_idTextBox.ReadOnly = true;
            this.ageGroup_idTextBox.Size = new System.Drawing.Size(51, 20);
            this.ageGroup_idTextBox.TabIndex = 18;
            this.ageGroup_idTextBox.TextChanged += new System.EventHandler(this.ageGroup_idTextBox_TextChanged);
            // 
            // selectnumbersectionsBindingSource
            // 
            this.selectnumbersectionsBindingSource.DataMember = "selectnumbersections";
            this.selectnumbersectionsBindingSource.DataSource = this.sportclubDataSet;
            // 
            // label15
            // 
            this.label15.AutoSize = true;
            this.label15.Location = new System.Drawing.Point(5, 54);
            this.label15.Name = "label15";
            this.label15.Size = new System.Drawing.Size(153, 26);
            this.label15.TabIndex = 16;
            this.label15.Text = "Первоначальное количество\r\nзанятий:";
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(8, 83);
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(100, 20);
            this.textBox1.TabIndex = 15;
            // 
            // textBox3
            // 
            this.textBox3.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.selectnumbersectionsBindingSource, "id", true));
            this.textBox3.Location = new System.Drawing.Point(291, 31);
            this.textBox3.Name = "textBox3";
            this.textBox3.ReadOnly = true;
            this.textBox3.Size = new System.Drawing.Size(51, 20);
            this.textBox3.TabIndex = 14;
            // 
            // nameComboBox
            // 
            this.nameComboBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.sectionsBindingSource, "name", true));
            this.nameComboBox.DataSource = this.selectnumbersectionsBindingSource;
            this.nameComboBox.DisplayMember = "name";
            this.nameComboBox.FormattingEnabled = true;
            this.nameComboBox.Location = new System.Drawing.Point(8, 30);
            this.nameComboBox.Name = "nameComboBox";
            this.nameComboBox.Size = new System.Drawing.Size(121, 21);
            this.nameComboBox.TabIndex = 12;
            this.nameComboBox.ValueMember = "name";
            // 
            // sectionsBindingSource
            // 
            this.sectionsBindingSource.DataMember = "sections";
            this.sectionsBindingSource.DataSource = this.sportclubDataSet;
            // 
            // addsection
            // 
            this.addsection.Location = new System.Drawing.Point(254, 5);
            this.addsection.Name = "addsection";
            this.addsection.Size = new System.Drawing.Size(111, 23);
            this.addsection.TabIndex = 48;
            this.addsection.Text = "Добавить секцию";
            this.addsection.UseVisualStyleBackColor = true;
            this.addsection.Click += new System.EventHandler(this.addsection_Click);
            // 
            // checkinbutton
            // 
            this.checkinbutton.Location = new System.Drawing.Point(13, 119);
            this.checkinbutton.Name = "checkinbutton";
            this.checkinbutton.Size = new System.Drawing.Size(76, 36);
            this.checkinbutton.TabIndex = 24;
            this.checkinbutton.Text = "Отметить";
            this.checkinbutton.UseVisualStyleBackColor = true;
            this.checkinbutton.Click += new System.EventHandler(this.checkinbutton_Click);
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.BackColor = System.Drawing.Color.WhiteSmoke;
            this.label7.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.label7.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.label7.Location = new System.Drawing.Point(10, 11);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(165, 17);
            this.label7.TabIndex = 47;
            this.label7.Text = "По количеству занятий";
            // 
            // sectionscombobox
            // 
            this.sectionscombobox.FormattingEnabled = true;
            this.sectionscombobox.Location = new System.Drawing.Point(13, 50);
            this.sectionscombobox.Name = "sectionscombobox";
            this.sectionscombobox.Size = new System.Drawing.Size(145, 21);
            this.sectionscombobox.TabIndex = 17;
            this.sectionscombobox.SelectedIndexChanged += new System.EventHandler(this.sectionscombobox_SelectedIndexChanged);
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(119, 80);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(62, 13);
            this.label6.TabIndex = 46;
            this.label6.Text = "Прибавить";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(10, 34);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(44, 13);
            this.label3.TabIndex = 19;
            this.label3.Text = "Секции";
            // 
            // addnumbertextBox
            // 
            this.addnumbertextBox.Location = new System.Drawing.Point(122, 96);
            this.addnumbertextBox.Name = "addnumbertextBox";
            this.addnumbertextBox.Size = new System.Drawing.Size(76, 20);
            this.addnumbertextBox.TabIndex = 45;
            this.addnumbertextBox.TextChanged += new System.EventHandler(this.addnumbertextBox_TextChanged);
            // 
            // numberoflessonstextBox
            // 
            this.numberoflessonstextBox.Location = new System.Drawing.Point(13, 96);
            this.numberoflessonstextBox.Name = "numberoflessonstextBox";
            this.numberoflessonstextBox.ReadOnly = true;
            this.numberoflessonstextBox.Size = new System.Drawing.Size(76, 20);
            this.numberoflessonstextBox.TabIndex = 20;
            // 
            // addbutton
            // 
            this.addbutton.Location = new System.Drawing.Point(122, 119);
            this.addbutton.Name = "addbutton";
            this.addbutton.Size = new System.Drawing.Size(76, 36);
            this.addbutton.TabIndex = 44;
            this.addbutton.Text = "Прибавить";
            this.addbutton.UseVisualStyleBackColor = true;
            this.addbutton.Click += new System.EventHandler(this.addbutton_Click);
            // 
            // agegrouptextBox
            // 
            this.agegrouptextBox.Location = new System.Drawing.Point(164, 51);
            this.agegrouptextBox.Name = "agegrouptextBox";
            this.agegrouptextBox.ReadOnly = true;
            this.agegrouptextBox.Size = new System.Drawing.Size(65, 20);
            this.agegrouptextBox.TabIndex = 21;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(161, 34);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(72, 13);
            this.label4.TabIndex = 22;
            this.label4.Text = "Возр. группа";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(10, 80);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(84, 13);
            this.label5.TabIndex = 23;
            this.label5.Text = "Колич. занятий";
            // 
            // nullbutton
            // 
            this.nullbutton.Location = new System.Drawing.Point(280, 132);
            this.nullbutton.Name = "nullbutton";
            this.nullbutton.Size = new System.Drawing.Size(75, 23);
            this.nullbutton.TabIndex = 50;
            this.nullbutton.Text = "Обнулить";
            this.nullbutton.UseVisualStyleBackColor = true;
            this.nullbutton.Click += new System.EventHandler(this.nullbutton_Click);
            // 
            // clearbutton
            // 
            this.clearbutton.Location = new System.Drawing.Point(222, 117);
            this.clearbutton.Name = "clearbutton";
            this.clearbutton.Size = new System.Drawing.Size(143, 26);
            this.clearbutton.TabIndex = 64;
            this.clearbutton.Text = "Очистить просроченные";
            this.clearbutton.UseVisualStyleBackColor = true;
            this.clearbutton.Click += new System.EventHandler(this.clearbutton_Click);
            // 
            // panel3
            // 
            this.panel3.Controls.Add(this.label23);
            this.panel3.Controls.Add(this.comboBox2);
            this.panel3.Controls.Add(this.button3);
            this.panel3.Controls.Add(this.addsectionsbutton2);
            this.panel3.Controls.Add(this.label22);
            this.panel3.Controls.Add(this.dateTimePicker1);
            this.panel3.Controls.Add(label21);
            this.panel3.Controls.Add(this.textBox5);
            this.panel3.Controls.Add(this.label18);
            this.panel3.Controls.Add(this.textBox2);
            this.panel3.Controls.Add(label19);
            this.panel3.Controls.Add(this.textBox4);
            this.panel3.Controls.Add(label20);
            this.panel3.Controls.Add(this.comboBox1);
            this.panel3.Location = new System.Drawing.Point(3, 3);
            this.panel3.Name = "panel3";
            this.panel3.Size = new System.Drawing.Size(362, 148);
            this.panel3.TabIndex = 61;
            this.panel3.Visible = false;
            // 
            // label23
            // 
            this.label23.AutoSize = true;
            this.label23.Location = new System.Drawing.Point(144, 58);
            this.label23.Name = "label23";
            this.label23.Size = new System.Drawing.Size(90, 13);
            this.label23.TabIndex = 34;
            this.label23.Text = "Вид абонемента";
            // 
            // comboBox2
            // 
            this.comboBox2.DataSource = this.typesofsubBindingSource;
            this.comboBox2.DisplayMember = "name";
            this.comboBox2.FormattingEnabled = true;
            this.comboBox2.Location = new System.Drawing.Point(147, 73);
            this.comboBox2.Name = "comboBox2";
            this.comboBox2.Size = new System.Drawing.Size(100, 21);
            this.comboBox2.TabIndex = 33;
            this.comboBox2.ValueMember = "name";
            // 
            // typesofsubBindingSource
            // 
            this.typesofsubBindingSource.DataMember = "typesofsub";
            this.typesofsubBindingSource.DataSource = this.sportclubDataSet;
            // 
            // button3
            // 
            this.button3.Location = new System.Drawing.Point(79, 97);
            this.button3.Name = "button3";
            this.button3.Size = new System.Drawing.Size(65, 40);
            this.button3.TabIndex = 32;
            this.button3.Text = "Отмена";
            this.button3.UseVisualStyleBackColor = true;
            this.button3.Click += new System.EventHandler(this.button3_Click);
            // 
            // addsectionsbutton2
            // 
            this.addsectionsbutton2.Location = new System.Drawing.Point(7, 97);
            this.addsectionsbutton2.Name = "addsectionsbutton2";
            this.addsectionsbutton2.Size = new System.Drawing.Size(66, 40);
            this.addsectionsbutton2.TabIndex = 31;
            this.addsectionsbutton2.Text = "Добавить";
            this.addsectionsbutton2.UseVisualStyleBackColor = true;
            this.addsectionsbutton2.Click += new System.EventHandler(this.addsectionsbutton2_Click);
            // 
            // label22
            // 
            this.label22.AutoSize = true;
            this.label22.Location = new System.Drawing.Point(5, 57);
            this.label22.Name = "label22";
            this.label22.Size = new System.Drawing.Size(89, 13);
            this.label22.TabIndex = 30;
            this.label22.Text = "Дата окончания";
            // 
            // dateTimePicker1
            // 
            this.dateTimePicker1.Location = new System.Drawing.Point(8, 73);
            this.dateTimePicker1.Name = "dateTimePicker1";
            this.dateTimePicker1.Size = new System.Drawing.Size(122, 20);
            this.dateTimePicker1.TabIndex = 29;
            // 
            // textBox5
            // 
            this.textBox5.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.selectdatesectionsBindingSource, "ageGroup_id", true));
            this.textBox5.Location = new System.Drawing.Point(291, 69);
            this.textBox5.Name = "textBox5";
            this.textBox5.ReadOnly = true;
            this.textBox5.Size = new System.Drawing.Size(51, 20);
            this.textBox5.TabIndex = 28;
            this.textBox5.TextChanged += new System.EventHandler(this.textBox5_TextChanged);
            // 
            // selectdatesectionsBindingSource
            // 
            this.selectdatesectionsBindingSource.DataMember = "selectdatesections";
            this.selectdatesectionsBindingSource.DataSource = this.sportclubDataSet;
            // 
            // label18
            // 
            this.label18.AutoSize = true;
            this.label18.Location = new System.Drawing.Point(144, 6);
            this.label18.Name = "label18";
            this.label18.Size = new System.Drawing.Size(72, 13);
            this.label18.TabIndex = 26;
            this.label18.Text = "Возр. группа";
            // 
            // textBox2
            // 
            this.textBox2.Location = new System.Drawing.Point(147, 23);
            this.textBox2.Name = "textBox2";
            this.textBox2.ReadOnly = true;
            this.textBox2.Size = new System.Drawing.Size(100, 20);
            this.textBox2.TabIndex = 25;
            // 
            // textBox4
            // 
            this.textBox4.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.selectdatesectionsBindingSource, "id", true));
            this.textBox4.Location = new System.Drawing.Point(291, 21);
            this.textBox4.Name = "textBox4";
            this.textBox4.ReadOnly = true;
            this.textBox4.Size = new System.Drawing.Size(51, 20);
            this.textBox4.TabIndex = 24;
            // 
            // comboBox1
            // 
            this.comboBox1.DataSource = this.selectdatesectionsBindingSource;
            this.comboBox1.DisplayMember = "name";
            this.comboBox1.FormattingEnabled = true;
            this.comboBox1.Location = new System.Drawing.Point(8, 21);
            this.comboBox1.Name = "comboBox1";
            this.comboBox1.Size = new System.Drawing.Size(122, 21);
            this.comboBox1.TabIndex = 22;
            this.comboBox1.ValueMember = "name";
            // 
            // addsection2
            // 
            this.addsection2.Location = new System.Drawing.Point(256, 8);
            this.addsection2.Name = "addsection2";
            this.addsection2.Size = new System.Drawing.Size(109, 23);
            this.addsection2.TabIndex = 60;
            this.addsection2.Text = "Добавить секцию";
            this.addsection2.UseVisualStyleBackColor = true;
            this.addsection2.Click += new System.EventHandler(this.addsection2_Click);
            // 
            // extendbutton
            // 
            this.extendbutton.Location = new System.Drawing.Point(122, 117);
            this.extendbutton.Name = "extendbutton";
            this.extendbutton.Size = new System.Drawing.Size(86, 26);
            this.extendbutton.TabIndex = 59;
            this.extendbutton.Text = "Продлить";
            this.extendbutton.UseVisualStyleBackColor = true;
            this.extendbutton.Click += new System.EventHandler(this.extendbutton_Click);
            // 
            // typeofsubtextBox
            // 
            this.typeofsubtextBox.Location = new System.Drawing.Point(250, 50);
            this.typeofsubtextBox.Name = "typeofsubtextBox";
            this.typeofsubtextBox.ReadOnly = true;
            this.typeofsubtextBox.Size = new System.Drawing.Size(100, 20);
            this.typeofsubtextBox.TabIndex = 58;
            // 
            // label13
            // 
            this.label13.AutoSize = true;
            this.label13.Location = new System.Drawing.Point(247, 33);
            this.label13.Name = "label13";
            this.label13.Size = new System.Drawing.Size(90, 13);
            this.label13.TabIndex = 57;
            this.label13.Text = "Вид абонемента";
            // 
            // agegroupstextBox2
            // 
            this.agegroupstextBox2.Location = new System.Drawing.Point(164, 50);
            this.agegroupstextBox2.Name = "agegroupstextBox2";
            this.agegroupstextBox2.ReadOnly = true;
            this.agegroupstextBox2.Size = new System.Drawing.Size(65, 20);
            this.agegroupstextBox2.TabIndex = 51;
            // 
            // label12
            // 
            this.label12.AutoSize = true;
            this.label12.Location = new System.Drawing.Point(161, 75);
            this.label12.Name = "label12";
            this.label12.Size = new System.Drawing.Size(71, 13);
            this.label12.TabIndex = 56;
            this.label12.Text = "Продлить до";
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.BackColor = System.Drawing.Color.WhiteSmoke;
            this.label8.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.label8.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.label8.Location = new System.Drawing.Point(10, 7);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(111, 17);
            this.label8.TabIndex = 48;
            this.label8.Text = "По абонементу";
            // 
            // moreTimePicker
            // 
            this.moreTimePicker.Location = new System.Drawing.Point(164, 91);
            this.moreTimePicker.Name = "moreTimePicker";
            this.moreTimePicker.Size = new System.Drawing.Size(145, 20);
            this.moreTimePicker.TabIndex = 55;
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.Location = new System.Drawing.Point(10, 33);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(44, 13);
            this.label9.TabIndex = 49;
            this.label9.Text = "Секции";
            // 
            // label11
            // 
            this.label11.AutoSize = true;
            this.label11.Location = new System.Drawing.Point(13, 75);
            this.label11.Name = "label11";
            this.label11.Size = new System.Drawing.Size(89, 13);
            this.label11.TabIndex = 54;
            this.label11.Text = "Дата окончания";
            // 
            // sectionscombobox2
            // 
            this.sectionscombobox2.FormattingEnabled = true;
            this.sectionscombobox2.Location = new System.Drawing.Point(13, 49);
            this.sectionscombobox2.Name = "sectionscombobox2";
            this.sectionscombobox2.Size = new System.Drawing.Size(145, 21);
            this.sectionscombobox2.TabIndex = 50;
            this.sectionscombobox2.SelectedIndexChanged += new System.EventHandler(this.sectionscombobox2_SelectedIndexChanged);
            // 
            // endTimePicker
            // 
            this.endTimePicker.Location = new System.Drawing.Point(13, 91);
            this.endTimePicker.Name = "endTimePicker";
            this.endTimePicker.Size = new System.Drawing.Size(145, 20);
            this.endTimePicker.TabIndex = 53;
            // 
            // label10
            // 
            this.label10.AutoSize = true;
            this.label10.Location = new System.Drawing.Point(161, 33);
            this.label10.Name = "label10";
            this.label10.Size = new System.Drawing.Size(72, 13);
            this.label10.TabIndex = 52;
            this.label10.Text = "Возр. группа";
            // 
            // checkinbutton2
            // 
            this.checkinbutton2.Location = new System.Drawing.Point(14, 117);
            this.checkinbutton2.Name = "checkinbutton2";
            this.checkinbutton2.Size = new System.Drawing.Size(90, 26);
            this.checkinbutton2.TabIndex = 62;
            this.checkinbutton2.Text = "Отметить";
            this.checkinbutton2.UseVisualStyleBackColor = true;
            this.checkinbutton2.Click += new System.EventHandler(this.checkinbutton2_Click);
            // 
            // backclientsbutton
            // 
            this.backclientsbutton.Image = global::DB.Properties.Resources._1170611806_11;
            this.backclientsbutton.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.backclientsbutton.Location = new System.Drawing.Point(19, 277);
            this.backclientsbutton.Name = "backclientsbutton";
            this.backclientsbutton.Size = new System.Drawing.Size(32, 26);
            this.backclientsbutton.TabIndex = 43;
            this.backclientsbutton.UseVisualStyleBackColor = true;
            this.backclientsbutton.Click += new System.EventHandler(this.backclientsbutton_Click);
            // 
            // idTextBox
            // 
            this.idTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.clientsBindingSource, "id", true));
            this.idTextBox.Enabled = false;
            this.idTextBox.Location = new System.Drawing.Point(89, 76);
            this.idTextBox.Name = "idTextBox";
            this.idTextBox.Size = new System.Drawing.Size(138, 20);
            this.idTextBox.TabIndex = 30;
            this.idTextBox.TextChanged += new System.EventHandler(this.idTextBox_TextChanged);
            // 
            // clientsBindingSource
            // 
            this.clientsBindingSource.DataMember = "clients";
            this.clientsBindingSource.DataSource = this.sportclubDataSet;
            // 
            // nameTextBox
            // 
            this.nameTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.clientsBindingSource, "name", true));
            this.nameTextBox.Location = new System.Drawing.Point(89, 102);
            this.nameTextBox.Name = "nameTextBox";
            this.nameTextBox.Size = new System.Drawing.Size(138, 20);
            this.nameTextBox.TabIndex = 32;
            // 
            // surnameTextBox
            // 
            this.surnameTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.clientsBindingSource, "surname", true));
            this.surnameTextBox.Location = new System.Drawing.Point(89, 128);
            this.surnameTextBox.Name = "surnameTextBox";
            this.surnameTextBox.Size = new System.Drawing.Size(138, 20);
            this.surnameTextBox.TabIndex = 34;
            // 
            // birthdayDateTimePicker
            // 
            this.birthdayDateTimePicker.DataBindings.Add(new System.Windows.Forms.Binding("Value", this.clientsBindingSource, "birthday", true));
            this.birthdayDateTimePicker.Location = new System.Drawing.Point(89, 154);
            this.birthdayDateTimePicker.Name = "birthdayDateTimePicker";
            this.birthdayDateTimePicker.Size = new System.Drawing.Size(138, 20);
            this.birthdayDateTimePicker.TabIndex = 36;
            // 
            // isStudentCheckBox
            // 
            this.isStudentCheckBox.DataBindings.Add(new System.Windows.Forms.Binding("CheckState", this.clientsBindingSource, "isStudent", true));
            this.isStudentCheckBox.Location = new System.Drawing.Point(89, 185);
            this.isStudentCheckBox.Name = "isStudentCheckBox";
            this.isStudentCheckBox.Size = new System.Drawing.Size(138, 24);
            this.isStudentCheckBox.TabIndex = 38;
            this.isStudentCheckBox.UseVisualStyleBackColor = true;
            // 
            // lastVisitDateTimePicker
            // 
            this.lastVisitDateTimePicker.DataBindings.Add(new System.Windows.Forms.Binding("Value", this.clientsBindingSource, "lastVisit", true));
            this.lastVisitDateTimePicker.Enabled = false;
            this.lastVisitDateTimePicker.Location = new System.Drawing.Point(89, 218);
            this.lastVisitDateTimePicker.Name = "lastVisitDateTimePicker";
            this.lastVisitDateTimePicker.Size = new System.Drawing.Size(138, 20);
            this.lastVisitDateTimePicker.TabIndex = 40;
            // 
            // numberTextBox
            // 
            this.numberTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.clientsBindingSource, "number", true));
            this.numberTextBox.Location = new System.Drawing.Point(89, 248);
            this.numberTextBox.Name = "numberTextBox";
            this.numberTextBox.Size = new System.Drawing.Size(138, 20);
            this.numberTextBox.TabIndex = 42;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(16, 33);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(66, 13);
            this.label1.TabIndex = 16;
            this.label1.Text = "поиск по id:";
            // 
            // idsearch
            // 
            this.idsearch.Location = new System.Drawing.Point(89, 30);
            this.idsearch.Name = "idsearch";
            this.idsearch.Size = new System.Drawing.Size(138, 20);
            this.idsearch.TabIndex = 15;
            this.idsearch.TextChanged += new System.EventHandler(this.idsearch_TextChanged);
            // 
            // button1
            // 
            this.button1.Image = global::DB.Properties.Resources._1170611806_11;
            this.button1.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.button1.Location = new System.Drawing.Point(6, 6);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(32, 26);
            this.button1.TabIndex = 15;
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Visible = false;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // surnamesearchButton
            // 
            this.surnamesearchButton.Location = new System.Drawing.Point(512, 8);
            this.surnamesearchButton.Name = "surnamesearchButton";
            this.surnamesearchButton.Size = new System.Drawing.Size(75, 23);
            this.surnamesearchButton.TabIndex = 4;
            this.surnamesearchButton.Text = "Найти";
            this.surnamesearchButton.UseVisualStyleBackColor = true;
            this.surnamesearchButton.Click += new System.EventHandler(this.surnamesearchButton_Click);
            // 
            // surnamesearchLabel
            // 
            this.surnamesearchLabel.AutoSize = true;
            this.surnamesearchLabel.Location = new System.Drawing.Point(273, 13);
            this.surnamesearchLabel.Name = "surnamesearchLabel";
            this.surnamesearchLabel.Size = new System.Drawing.Size(103, 13);
            this.surnamesearchLabel.TabIndex = 3;
            this.surnamesearchLabel.Text = "Поиск по фамилии";
            // 
            // surnamesearchTextBox
            // 
            this.surnamesearchTextBox.Location = new System.Drawing.Point(382, 10);
            this.surnamesearchTextBox.Name = "surnamesearchTextBox";
            this.surnamesearchTextBox.Size = new System.Drawing.Size(110, 20);
            this.surnamesearchTextBox.TabIndex = 2;
            // 
            // clientsDataGridView
            // 
            this.clientsDataGridView.AutoGenerateColumns = false;
            this.clientsDataGridView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.clientsDataGridView.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.Column1,
            this.dataGridViewTextBoxColumn6,
            this.dataGridViewTextBoxColumn7,
            this.dataGridViewTextBoxColumn8,
            this.dataGridViewCheckBoxColumn1,
            this.dataGridViewTextBoxColumn9,
            this.dataGridViewTextBoxColumn10});
            this.clientsDataGridView.DataSource = this.clientsBindingSource;
            this.clientsDataGridView.Location = new System.Drawing.Point(4, 36);
            this.clientsDataGridView.Name = "clientsDataGridView";
            this.clientsDataGridView.Size = new System.Drawing.Size(593, 220);
            this.clientsDataGridView.TabIndex = 0;
            this.clientsDataGridView.CellClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.clientsDataGridView_CellClick);
            // 
            // Column1
            // 
            this.Column1.DataPropertyName = "id";
            this.Column1.HeaderText = "id";
            this.Column1.Name = "Column1";
            this.Column1.ReadOnly = true;
            this.Column1.Visible = false;
            // 
            // dataGridViewTextBoxColumn6
            // 
            this.dataGridViewTextBoxColumn6.DataPropertyName = "name";
            this.dataGridViewTextBoxColumn6.HeaderText = "имя";
            this.dataGridViewTextBoxColumn6.Name = "dataGridViewTextBoxColumn6";
            // 
            // dataGridViewTextBoxColumn7
            // 
            this.dataGridViewTextBoxColumn7.DataPropertyName = "surname";
            this.dataGridViewTextBoxColumn7.HeaderText = "фамилия";
            this.dataGridViewTextBoxColumn7.Name = "dataGridViewTextBoxColumn7";
            // 
            // dataGridViewTextBoxColumn8
            // 
            this.dataGridViewTextBoxColumn8.DataPropertyName = "birthday";
            this.dataGridViewTextBoxColumn8.HeaderText = "дата рожд.";
            this.dataGridViewTextBoxColumn8.Name = "dataGridViewTextBoxColumn8";
            // 
            // dataGridViewCheckBoxColumn1
            // 
            this.dataGridViewCheckBoxColumn1.DataPropertyName = "isStudent";
            this.dataGridViewCheckBoxColumn1.HeaderText = "студент";
            this.dataGridViewCheckBoxColumn1.Name = "dataGridViewCheckBoxColumn1";
            // 
            // dataGridViewTextBoxColumn9
            // 
            this.dataGridViewTextBoxColumn9.DataPropertyName = "lastVisit";
            this.dataGridViewTextBoxColumn9.HeaderText = "посл. посещение";
            this.dataGridViewTextBoxColumn9.Name = "dataGridViewTextBoxColumn9";
            // 
            // dataGridViewTextBoxColumn10
            // 
            this.dataGridViewTextBoxColumn10.DataPropertyName = "number";
            this.dataGridViewTextBoxColumn10.HeaderText = "телефон";
            this.dataGridViewTextBoxColumn10.Name = "dataGridViewTextBoxColumn10";
            // 
            // tabPage3
            // 
            this.tabPage3.AutoScroll = true;
            this.tabPage3.BackColor = System.Drawing.Color.LightGray;
            this.tabPage3.Controls.Add(this.label29);
            this.tabPage3.Controls.Add(this.label28);
            this.tabPage3.Controls.Add(this.label27);
            this.tabPage3.Controls.Add(this.hidepanel);
            this.tabPage3.Controls.Add(this.textBox10);
            this.tabPage3.Controls.Add(this.label26);
            this.tabPage3.Controls.Add(this.label25);
            this.tabPage3.Controls.Add(this.textBox9);
            this.tabPage3.Controls.Add(this.textBox8);
            this.tabPage3.Controls.Add(this.label24);
            this.tabPage3.Controls.Add(this.textBox7);
            this.tabPage3.Controls.Add(this.textBox6);
            this.tabPage3.Controls.Add(this.comboBox3);
            this.tabPage3.Controls.Add(this.fillToolStrip);
            this.tabPage3.Controls.Add(this.selectdayscheduleDataGridView);
            this.tabPage3.Controls.Add(this.panel1);
            this.tabPage3.Controls.Add(this.textBox11);
            this.tabPage3.Location = new System.Drawing.Point(4, 22);
            this.tabPage3.Name = "tabPage3";
            this.tabPage3.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage3.Size = new System.Drawing.Size(631, 348);
            this.tabPage3.TabIndex = 2;
            this.tabPage3.Text = "Секции";
            // 
            // textBox6
            // 
            this.textBox6.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.selectnumbersectionsBindingSource, "id", true));
            this.textBox6.Location = new System.Drawing.Point(12, 28);
            this.textBox6.Name = "textBox6";
            this.textBox6.ReadOnly = true;
            this.textBox6.Size = new System.Drawing.Size(62, 20);
            this.textBox6.TabIndex = 5;
            // 
            // comboBox3
            // 
            this.comboBox3.DataSource = this.selectnumbersectionsBindingSource;
            this.comboBox3.DisplayMember = "name";
            this.comboBox3.FormattingEnabled = true;
            this.comboBox3.Location = new System.Drawing.Point(80, 28);
            this.comboBox3.Name = "comboBox3";
            this.comboBox3.Size = new System.Drawing.Size(125, 21);
            this.comboBox3.TabIndex = 4;
            this.comboBox3.ValueMember = "name";
            this.comboBox3.SelectedIndexChanged += new System.EventHandler(this.comboBox3_SelectedIndexChanged);
            // 
            // fillToolStrip
            // 
            this.fillToolStrip.Dock = System.Windows.Forms.DockStyle.None;
            this.fillToolStrip.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.fillToolStripButton});
            this.fillToolStrip.Location = new System.Drawing.Point(290, 25);
            this.fillToolStrip.Name = "fillToolStrip";
            this.fillToolStrip.Size = new System.Drawing.Size(130, 25);
            this.fillToolStrip.TabIndex = 3;
            this.fillToolStrip.Text = "fillToolStrip";
            // 
            // fillToolStripButton
            // 
            this.fillToolStripButton.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Text;
            this.fillToolStripButton.Name = "fillToolStripButton";
            this.fillToolStripButton.Size = new System.Drawing.Size(118, 22);
            this.fillToolStripButton.Text = "Заполнить таблицу";
            this.fillToolStripButton.Click += new System.EventHandler(this.fillToolStripButton_Click);
            // 
            // selectdayscheduleDataGridView
            // 
            this.selectdayscheduleDataGridView.AutoGenerateColumns = false;
            this.selectdayscheduleDataGridView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.selectdayscheduleDataGridView.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.dataGridViewTextBoxColumn49,
            this.dataGridViewTextBoxColumn47,
            this.dataGridViewTextBoxColumn48});
            this.selectdayscheduleDataGridView.DataSource = this.selectdayscheduleBindingSource;
            this.selectdayscheduleDataGridView.Location = new System.Drawing.Point(12, 65);
            this.selectdayscheduleDataGridView.Name = "selectdayscheduleDataGridView";
            this.selectdayscheduleDataGridView.Size = new System.Drawing.Size(350, 208);
            this.selectdayscheduleDataGridView.TabIndex = 1;
            // 
            // dataGridViewTextBoxColumn49
            // 
            this.dataGridViewTextBoxColumn49.DataPropertyName = "Column1";
            this.dataGridViewTextBoxColumn49.HeaderText = "день недели";
            this.dataGridViewTextBoxColumn49.Name = "dataGridViewTextBoxColumn49";
            this.dataGridViewTextBoxColumn49.ReadOnly = true;
            // 
            // dataGridViewTextBoxColumn47
            // 
            this.dataGridViewTextBoxColumn47.DataPropertyName = "startTime";
            this.dataGridViewTextBoxColumn47.HeaderText = "начало";
            this.dataGridViewTextBoxColumn47.Name = "dataGridViewTextBoxColumn47";
            // 
            // dataGridViewTextBoxColumn48
            // 
            this.dataGridViewTextBoxColumn48.DataPropertyName = "endTime";
            this.dataGridViewTextBoxColumn48.HeaderText = "конец";
            this.dataGridViewTextBoxColumn48.Name = "dataGridViewTextBoxColumn48";
            // 
            // selectdayscheduleBindingSource
            // 
            this.selectdayscheduleBindingSource.DataMember = "selectdayschedule";
            this.selectdayscheduleBindingSource.DataSource = this.sportclubDataSet;
            // 
            // panel1
            // 
            this.panel1.Controls.Add(this.typesofsubDataGridView);
            this.panel1.Controls.Add(this.selectdatesectionsDataGridView);
            this.panel1.Controls.Add(this.selectnumbersectionsDataGridView);
            this.panel1.Controls.Add(this.instructorsandlessonsDataGridView);
            this.panel1.Controls.Add(this.instructorsDataGridView);
            this.panel1.Controls.Add(this.enddatesDataGridView);
            this.panel1.Controls.Add(this.sectionsDataGridView);
            this.panel1.Controls.Add(this.scheduleDataGridView);
            this.panel1.Controls.Add(this.numberoflessonsDataGridView);
            this.panel1.Location = new System.Drawing.Point(444, 307);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(109, 35);
            this.panel1.TabIndex = 0;
            this.panel1.Visible = false;
            // 
            // typesofsubDataGridView
            // 
            this.typesofsubDataGridView.AutoGenerateColumns = false;
            this.typesofsubDataGridView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.typesofsubDataGridView.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.dataGridViewTextBoxColumn45,
            this.dataGridViewTextBoxColumn46});
            this.typesofsubDataGridView.DataSource = this.typesofsubBindingSource;
            this.typesofsubDataGridView.Location = new System.Drawing.Point(397, 17);
            this.typesofsubDataGridView.Name = "typesofsubDataGridView";
            this.typesofsubDataGridView.Size = new System.Drawing.Size(76, 64);
            this.typesofsubDataGridView.TabIndex = 8;
            // 
            // dataGridViewTextBoxColumn45
            // 
            this.dataGridViewTextBoxColumn45.DataPropertyName = "id";
            this.dataGridViewTextBoxColumn45.HeaderText = "id";
            this.dataGridViewTextBoxColumn45.Name = "dataGridViewTextBoxColumn45";
            this.dataGridViewTextBoxColumn45.ReadOnly = true;
            // 
            // dataGridViewTextBoxColumn46
            // 
            this.dataGridViewTextBoxColumn46.DataPropertyName = "name";
            this.dataGridViewTextBoxColumn46.HeaderText = "name";
            this.dataGridViewTextBoxColumn46.Name = "dataGridViewTextBoxColumn46";
            // 
            // selectdatesectionsDataGridView
            // 
            this.selectdatesectionsDataGridView.AutoGenerateColumns = false;
            this.selectdatesectionsDataGridView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.selectdatesectionsDataGridView.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.dataGridViewTextBoxColumn39,
            this.dataGridViewTextBoxColumn40,
            this.dataGridViewTextBoxColumn41,
            this.dataGridViewTextBoxColumn42,
            this.dataGridViewTextBoxColumn43,
            this.dataGridViewTextBoxColumn44,
            this.dataGridViewCheckBoxColumn4});
            this.selectdatesectionsDataGridView.DataSource = this.selectdatesectionsBindingSource;
            this.selectdatesectionsDataGridView.Location = new System.Drawing.Point(227, 80);
            this.selectdatesectionsDataGridView.Name = "selectdatesectionsDataGridView";
            this.selectdatesectionsDataGridView.Size = new System.Drawing.Size(67, 64);
            this.selectdatesectionsDataGridView.TabIndex = 7;
            // 
            // dataGridViewTextBoxColumn39
            // 
            this.dataGridViewTextBoxColumn39.DataPropertyName = "id";
            this.dataGridViewTextBoxColumn39.HeaderText = "id";
            this.dataGridViewTextBoxColumn39.Name = "dataGridViewTextBoxColumn39";
            this.dataGridViewTextBoxColumn39.ReadOnly = true;
            // 
            // dataGridViewTextBoxColumn40
            // 
            this.dataGridViewTextBoxColumn40.DataPropertyName = "name";
            this.dataGridViewTextBoxColumn40.HeaderText = "name";
            this.dataGridViewTextBoxColumn40.Name = "dataGridViewTextBoxColumn40";
            // 
            // dataGridViewTextBoxColumn41
            // 
            this.dataGridViewTextBoxColumn41.DataPropertyName = "ageGroup_id";
            this.dataGridViewTextBoxColumn41.HeaderText = "ageGroup_id";
            this.dataGridViewTextBoxColumn41.Name = "dataGridViewTextBoxColumn41";
            // 
            // dataGridViewTextBoxColumn42
            // 
            this.dataGridViewTextBoxColumn42.DataPropertyName = "currPeopleCount";
            this.dataGridViewTextBoxColumn42.HeaderText = "currPeopleCount";
            this.dataGridViewTextBoxColumn42.Name = "dataGridViewTextBoxColumn42";
            // 
            // dataGridViewTextBoxColumn43
            // 
            this.dataGridViewTextBoxColumn43.DataPropertyName = "maxPeopleCount";
            this.dataGridViewTextBoxColumn43.HeaderText = "maxPeopleCount";
            this.dataGridViewTextBoxColumn43.Name = "dataGridViewTextBoxColumn43";
            // 
            // dataGridViewTextBoxColumn44
            // 
            this.dataGridViewTextBoxColumn44.DataPropertyName = "price";
            this.dataGridViewTextBoxColumn44.HeaderText = "price";
            this.dataGridViewTextBoxColumn44.Name = "dataGridViewTextBoxColumn44";
            // 
            // dataGridViewCheckBoxColumn4
            // 
            this.dataGridViewCheckBoxColumn4.DataPropertyName = "isSched";
            this.dataGridViewCheckBoxColumn4.HeaderText = "isSched";
            this.dataGridViewCheckBoxColumn4.Name = "dataGridViewCheckBoxColumn4";
            // 
            // selectnumbersectionsDataGridView
            // 
            this.selectnumbersectionsDataGridView.AutoGenerateColumns = false;
            this.selectnumbersectionsDataGridView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.selectnumbersectionsDataGridView.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.dataGridViewTextBoxColumn33,
            this.dataGridViewTextBoxColumn34,
            this.dataGridViewTextBoxColumn35,
            this.dataGridViewTextBoxColumn36,
            this.dataGridViewTextBoxColumn37,
            this.dataGridViewTextBoxColumn38,
            this.dataGridViewCheckBoxColumn3});
            this.selectnumbersectionsDataGridView.DataSource = this.selectnumbersectionsBindingSource;
            this.selectnumbersectionsDataGridView.Location = new System.Drawing.Point(318, 17);
            this.selectnumbersectionsDataGridView.Name = "selectnumbersectionsDataGridView";
            this.selectnumbersectionsDataGridView.Size = new System.Drawing.Size(61, 64);
            this.selectnumbersectionsDataGridView.TabIndex = 6;
            // 
            // dataGridViewTextBoxColumn33
            // 
            this.dataGridViewTextBoxColumn33.DataPropertyName = "id";
            this.dataGridViewTextBoxColumn33.HeaderText = "id";
            this.dataGridViewTextBoxColumn33.Name = "dataGridViewTextBoxColumn33";
            this.dataGridViewTextBoxColumn33.ReadOnly = true;
            // 
            // dataGridViewTextBoxColumn34
            // 
            this.dataGridViewTextBoxColumn34.DataPropertyName = "name";
            this.dataGridViewTextBoxColumn34.HeaderText = "name";
            this.dataGridViewTextBoxColumn34.Name = "dataGridViewTextBoxColumn34";
            // 
            // dataGridViewTextBoxColumn35
            // 
            this.dataGridViewTextBoxColumn35.DataPropertyName = "ageGroup_id";
            this.dataGridViewTextBoxColumn35.HeaderText = "ageGroup_id";
            this.dataGridViewTextBoxColumn35.Name = "dataGridViewTextBoxColumn35";
            // 
            // dataGridViewTextBoxColumn36
            // 
            this.dataGridViewTextBoxColumn36.DataPropertyName = "currPeopleCount";
            this.dataGridViewTextBoxColumn36.HeaderText = "currPeopleCount";
            this.dataGridViewTextBoxColumn36.Name = "dataGridViewTextBoxColumn36";
            // 
            // dataGridViewTextBoxColumn37
            // 
            this.dataGridViewTextBoxColumn37.DataPropertyName = "maxPeopleCount";
            this.dataGridViewTextBoxColumn37.HeaderText = "maxPeopleCount";
            this.dataGridViewTextBoxColumn37.Name = "dataGridViewTextBoxColumn37";
            // 
            // dataGridViewTextBoxColumn38
            // 
            this.dataGridViewTextBoxColumn38.DataPropertyName = "price";
            this.dataGridViewTextBoxColumn38.HeaderText = "price";
            this.dataGridViewTextBoxColumn38.Name = "dataGridViewTextBoxColumn38";
            // 
            // dataGridViewCheckBoxColumn3
            // 
            this.dataGridViewCheckBoxColumn3.DataPropertyName = "isSched";
            this.dataGridViewCheckBoxColumn3.HeaderText = "isSched";
            this.dataGridViewCheckBoxColumn3.Name = "dataGridViewCheckBoxColumn3";
            // 
            // instructorsandlessonsDataGridView
            // 
            this.instructorsandlessonsDataGridView.AutoGenerateColumns = false;
            this.instructorsandlessonsDataGridView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.instructorsandlessonsDataGridView.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.dataGridViewTextBoxColumn31,
            this.dataGridViewTextBoxColumn32});
            this.instructorsandlessonsDataGridView.DataSource = this.instructorsandlessonsBindingSource;
            this.instructorsandlessonsDataGridView.Location = new System.Drawing.Point(61, 80);
            this.instructorsandlessonsDataGridView.Name = "instructorsandlessonsDataGridView";
            this.instructorsandlessonsDataGridView.Size = new System.Drawing.Size(57, 64);
            this.instructorsandlessonsDataGridView.TabIndex = 5;
            // 
            // dataGridViewTextBoxColumn31
            // 
            this.dataGridViewTextBoxColumn31.DataPropertyName = "instructor_id";
            this.dataGridViewTextBoxColumn31.HeaderText = "instructor_id";
            this.dataGridViewTextBoxColumn31.Name = "dataGridViewTextBoxColumn31";
            // 
            // dataGridViewTextBoxColumn32
            // 
            this.dataGridViewTextBoxColumn32.DataPropertyName = "section_id";
            this.dataGridViewTextBoxColumn32.HeaderText = "section_id";
            this.dataGridViewTextBoxColumn32.Name = "dataGridViewTextBoxColumn32";
            // 
            // instructorsandlessonsBindingSource
            // 
            this.instructorsandlessonsBindingSource.DataMember = "instructorsandlessons";
            this.instructorsandlessonsBindingSource.DataSource = this.sportclubDataSet;
            // 
            // instructorsDataGridView
            // 
            this.instructorsDataGridView.AutoGenerateColumns = false;
            this.instructorsDataGridView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.instructorsDataGridView.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.dataGridViewTextBoxColumn27,
            this.dataGridViewTextBoxColumn28,
            this.dataGridViewTextBoxColumn29,
            this.dataGridViewTextBoxColumn30});
            this.instructorsDataGridView.DataSource = this.instructorsBindingSource;
            this.instructorsDataGridView.Location = new System.Drawing.Point(3, 80);
            this.instructorsDataGridView.Name = "instructorsDataGridView";
            this.instructorsDataGridView.Size = new System.Drawing.Size(52, 64);
            this.instructorsDataGridView.TabIndex = 4;
            // 
            // dataGridViewTextBoxColumn27
            // 
            this.dataGridViewTextBoxColumn27.DataPropertyName = "id";
            this.dataGridViewTextBoxColumn27.HeaderText = "id";
            this.dataGridViewTextBoxColumn27.Name = "dataGridViewTextBoxColumn27";
            this.dataGridViewTextBoxColumn27.ReadOnly = true;
            // 
            // dataGridViewTextBoxColumn28
            // 
            this.dataGridViewTextBoxColumn28.DataPropertyName = "name";
            this.dataGridViewTextBoxColumn28.HeaderText = "name";
            this.dataGridViewTextBoxColumn28.Name = "dataGridViewTextBoxColumn28";
            // 
            // dataGridViewTextBoxColumn29
            // 
            this.dataGridViewTextBoxColumn29.DataPropertyName = "surname";
            this.dataGridViewTextBoxColumn29.HeaderText = "surname";
            this.dataGridViewTextBoxColumn29.Name = "dataGridViewTextBoxColumn29";
            // 
            // dataGridViewTextBoxColumn30
            // 
            this.dataGridViewTextBoxColumn30.DataPropertyName = "phoneNumber";
            this.dataGridViewTextBoxColumn30.HeaderText = "phoneNumber";
            this.dataGridViewTextBoxColumn30.Name = "dataGridViewTextBoxColumn30";
            // 
            // instructorsBindingSource
            // 
            this.instructorsBindingSource.DataMember = "instructors";
            this.instructorsBindingSource.DataSource = this.sportclubDataSet;
            // 
            // enddatesDataGridView
            // 
            this.enddatesDataGridView.AutoGenerateColumns = false;
            this.enddatesDataGridView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.enddatesDataGridView.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.dataGridViewTextBoxColumn19,
            this.dataGridViewTextBoxColumn20,
            this.dataGridViewTextBoxColumn21,
            this.dataGridViewTextBoxColumn22});
            this.enddatesDataGridView.DataSource = this.enddatesBindingSource;
            this.enddatesDataGridView.Location = new System.Drawing.Point(124, 17);
            this.enddatesDataGridView.Name = "enddatesDataGridView";
            this.enddatesDataGridView.Size = new System.Drawing.Size(88, 57);
            this.enddatesDataGridView.TabIndex = 2;
            // 
            // dataGridViewTextBoxColumn19
            // 
            this.dataGridViewTextBoxColumn19.DataPropertyName = "client_id";
            this.dataGridViewTextBoxColumn19.HeaderText = "client_id";
            this.dataGridViewTextBoxColumn19.Name = "dataGridViewTextBoxColumn19";
            // 
            // dataGridViewTextBoxColumn20
            // 
            this.dataGridViewTextBoxColumn20.DataPropertyName = "section_id";
            this.dataGridViewTextBoxColumn20.HeaderText = "section_id";
            this.dataGridViewTextBoxColumn20.Name = "dataGridViewTextBoxColumn20";
            // 
            // dataGridViewTextBoxColumn21
            // 
            this.dataGridViewTextBoxColumn21.DataPropertyName = "endDate";
            this.dataGridViewTextBoxColumn21.HeaderText = "endDate";
            this.dataGridViewTextBoxColumn21.Name = "dataGridViewTextBoxColumn21";
            // 
            // dataGridViewTextBoxColumn22
            // 
            this.dataGridViewTextBoxColumn22.DataPropertyName = "typeOfSub_id";
            this.dataGridViewTextBoxColumn22.HeaderText = "typeOfSub_id";
            this.dataGridViewTextBoxColumn22.Name = "dataGridViewTextBoxColumn22";
            // 
            // enddatesBindingSource
            // 
            this.enddatesBindingSource.DataMember = "enddates";
            this.enddatesBindingSource.DataSource = this.sportclubDataSet;
            // 
            // sectionsDataGridView
            // 
            this.sectionsDataGridView.AutoGenerateColumns = false;
            this.sectionsDataGridView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.sectionsDataGridView.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.dataGridViewTextBoxColumn13,
            this.dataGridViewTextBoxColumn14,
            this.dataGridViewTextBoxColumn15,
            this.dataGridViewTextBoxColumn16,
            this.dataGridViewTextBoxColumn17,
            this.dataGridViewTextBoxColumn18,
            this.dataGridViewCheckBoxColumn2});
            this.sectionsDataGridView.DataSource = this.sectionsBindingSource;
            this.sectionsDataGridView.Location = new System.Drawing.Point(61, 19);
            this.sectionsDataGridView.Name = "sectionsDataGridView";
            this.sectionsDataGridView.Size = new System.Drawing.Size(57, 55);
            this.sectionsDataGridView.TabIndex = 1;
            // 
            // dataGridViewTextBoxColumn13
            // 
            this.dataGridViewTextBoxColumn13.DataPropertyName = "id";
            this.dataGridViewTextBoxColumn13.HeaderText = "id";
            this.dataGridViewTextBoxColumn13.Name = "dataGridViewTextBoxColumn13";
            this.dataGridViewTextBoxColumn13.ReadOnly = true;
            // 
            // dataGridViewTextBoxColumn14
            // 
            this.dataGridViewTextBoxColumn14.DataPropertyName = "name";
            this.dataGridViewTextBoxColumn14.HeaderText = "name";
            this.dataGridViewTextBoxColumn14.Name = "dataGridViewTextBoxColumn14";
            // 
            // dataGridViewTextBoxColumn15
            // 
            this.dataGridViewTextBoxColumn15.DataPropertyName = "ageGroup_id";
            this.dataGridViewTextBoxColumn15.HeaderText = "ageGroup_id";
            this.dataGridViewTextBoxColumn15.Name = "dataGridViewTextBoxColumn15";
            // 
            // dataGridViewTextBoxColumn16
            // 
            this.dataGridViewTextBoxColumn16.DataPropertyName = "currPeopleCount";
            this.dataGridViewTextBoxColumn16.HeaderText = "currPeopleCount";
            this.dataGridViewTextBoxColumn16.Name = "dataGridViewTextBoxColumn16";
            // 
            // dataGridViewTextBoxColumn17
            // 
            this.dataGridViewTextBoxColumn17.DataPropertyName = "maxPeopleCount";
            this.dataGridViewTextBoxColumn17.HeaderText = "maxPeopleCount";
            this.dataGridViewTextBoxColumn17.Name = "dataGridViewTextBoxColumn17";
            // 
            // dataGridViewTextBoxColumn18
            // 
            this.dataGridViewTextBoxColumn18.DataPropertyName = "price";
            this.dataGridViewTextBoxColumn18.HeaderText = "price";
            this.dataGridViewTextBoxColumn18.Name = "dataGridViewTextBoxColumn18";
            // 
            // dataGridViewCheckBoxColumn2
            // 
            this.dataGridViewCheckBoxColumn2.DataPropertyName = "isSched";
            this.dataGridViewCheckBoxColumn2.HeaderText = "isSched";
            this.dataGridViewCheckBoxColumn2.Name = "dataGridViewCheckBoxColumn2";
            // 
            // scheduleDataGridView
            // 
            this.scheduleDataGridView.AutoGenerateColumns = false;
            this.scheduleDataGridView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.scheduleDataGridView.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.dataGridViewTextBoxColumn23,
            this.dataGridViewTextBoxColumn24,
            this.dataGridViewTextBoxColumn25,
            this.dataGridViewTextBoxColumn26});
            this.scheduleDataGridView.DataSource = this.scheduleBindingSource;
            this.scheduleDataGridView.Location = new System.Drawing.Point(227, 17);
            this.scheduleDataGridView.Name = "scheduleDataGridView";
            this.scheduleDataGridView.Size = new System.Drawing.Size(64, 57);
            this.scheduleDataGridView.TabIndex = 3;
            // 
            // dataGridViewTextBoxColumn23
            // 
            this.dataGridViewTextBoxColumn23.DataPropertyName = "section_id";
            this.dataGridViewTextBoxColumn23.HeaderText = "section_id";
            this.dataGridViewTextBoxColumn23.Name = "dataGridViewTextBoxColumn23";
            // 
            // dataGridViewTextBoxColumn24
            // 
            this.dataGridViewTextBoxColumn24.DataPropertyName = "dayy";
            this.dataGridViewTextBoxColumn24.HeaderText = "dayy";
            this.dataGridViewTextBoxColumn24.Name = "dataGridViewTextBoxColumn24";
            // 
            // dataGridViewTextBoxColumn25
            // 
            this.dataGridViewTextBoxColumn25.DataPropertyName = "startTime";
            this.dataGridViewTextBoxColumn25.HeaderText = "startTime";
            this.dataGridViewTextBoxColumn25.Name = "dataGridViewTextBoxColumn25";
            // 
            // dataGridViewTextBoxColumn26
            // 
            this.dataGridViewTextBoxColumn26.DataPropertyName = "endTime";
            this.dataGridViewTextBoxColumn26.HeaderText = "endTime";
            this.dataGridViewTextBoxColumn26.Name = "dataGridViewTextBoxColumn26";
            // 
            // scheduleBindingSource
            // 
            this.scheduleBindingSource.DataMember = "schedule";
            this.scheduleBindingSource.DataSource = this.sportclubDataSet;
            // 
            // numberoflessonsDataGridView
            // 
            this.numberoflessonsDataGridView.AutoGenerateColumns = false;
            this.numberoflessonsDataGridView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.numberoflessonsDataGridView.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.dataGridViewTextBoxColumn5,
            this.dataGridViewTextBoxColumn11,
            this.dataGridViewTextBoxColumn12});
            this.numberoflessonsDataGridView.DataSource = this.numberoflessonsBindingSource;
            this.numberoflessonsDataGridView.Location = new System.Drawing.Point(136, 80);
            this.numberoflessonsDataGridView.Name = "numberoflessonsDataGridView";
            this.numberoflessonsDataGridView.Size = new System.Drawing.Size(65, 64);
            this.numberoflessonsDataGridView.TabIndex = 0;
            // 
            // dataGridViewTextBoxColumn5
            // 
            this.dataGridViewTextBoxColumn5.DataPropertyName = "section_id";
            this.dataGridViewTextBoxColumn5.HeaderText = "section_id";
            this.dataGridViewTextBoxColumn5.Name = "dataGridViewTextBoxColumn5";
            // 
            // dataGridViewTextBoxColumn11
            // 
            this.dataGridViewTextBoxColumn11.DataPropertyName = "client_id";
            this.dataGridViewTextBoxColumn11.HeaderText = "client_id";
            this.dataGridViewTextBoxColumn11.Name = "dataGridViewTextBoxColumn11";
            // 
            // dataGridViewTextBoxColumn12
            // 
            this.dataGridViewTextBoxColumn12.DataPropertyName = "number";
            this.dataGridViewTextBoxColumn12.HeaderText = "number";
            this.dataGridViewTextBoxColumn12.Name = "dataGridViewTextBoxColumn12";
            // 
            // numberoflessonsBindingSource
            // 
            this.numberoflessonsBindingSource.DataMember = "numberoflessons";
            this.numberoflessonsBindingSource.DataSource = this.sportclubDataSet;
            // 
            // sectionsBindingSource1
            // 
            this.sectionsBindingSource1.DataMember = "sections";
            this.sectionsBindingSource1.DataSource = this.sportclubDataSet;
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.файлToolStripMenuItem,
            this.справкаToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(655, 24);
            this.menuStrip1.TabIndex = 1;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // файлToolStripMenuItem
            // 
            this.файлToolStripMenuItem.Name = "файлToolStripMenuItem";
            this.файлToolStripMenuItem.Size = new System.Drawing.Size(48, 20);
            this.файлToolStripMenuItem.Text = "Файл";
            // 
            // справкаToolStripMenuItem
            // 
            this.справкаToolStripMenuItem.Name = "справкаToolStripMenuItem";
            this.справкаToolStripMenuItem.Size = new System.Drawing.Size(65, 20);
            this.справкаToolStripMenuItem.Text = "Справка";
            // 
            // bindingNavigator
            // 
            this.bindingNavigator.AddNewItem = this.bindingNavigatorAddNewItem;
            this.bindingNavigator.BindingSource = this.select_curr_day_schedBindingSource;
            this.bindingNavigator.CountItem = this.bindingNavigatorCountItem;
            this.bindingNavigator.DeleteItem = this.bindingNavigatorDeleteItem;
            this.bindingNavigator.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.bindingNavigator.Enabled = false;
            this.bindingNavigator.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.bindingNavigatorMoveFirstItem,
            this.bindingNavigatorMovePreviousItem,
            this.bindingNavigatorSeparator,
            this.bindingNavigatorPositionItem,
            this.bindingNavigatorCountItem,
            this.bindingNavigatorSeparator1,
            this.bindingNavigatorMoveNextItem,
            this.bindingNavigatorMoveLastItem,
            this.bindingNavigatorSeparator2,
            this.bindingNavigatorAddNewItem,
            this.bindingNavigatorDeleteItem,
            this.bindingNavigatorSaveItem});
            this.bindingNavigator.Location = new System.Drawing.Point(0, 404);
            this.bindingNavigator.MoveFirstItem = this.bindingNavigatorMoveFirstItem;
            this.bindingNavigator.MoveLastItem = this.bindingNavigatorMoveLastItem;
            this.bindingNavigator.MoveNextItem = this.bindingNavigatorMoveNextItem;
            this.bindingNavigator.MovePreviousItem = this.bindingNavigatorMovePreviousItem;
            this.bindingNavigator.Name = "bindingNavigator";
            this.bindingNavigator.PositionItem = this.bindingNavigatorPositionItem;
            this.bindingNavigator.Size = new System.Drawing.Size(655, 25);
            this.bindingNavigator.TabIndex = 2;
            this.bindingNavigator.Text = "bindingNavigator1";
            // 
            // bindingNavigatorAddNewItem
            // 
            this.bindingNavigatorAddNewItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorAddNewItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorAddNewItem.Image")));
            this.bindingNavigatorAddNewItem.Name = "bindingNavigatorAddNewItem";
            this.bindingNavigatorAddNewItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorAddNewItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorAddNewItem.Text = "Добавить";
            this.bindingNavigatorAddNewItem.Click += new System.EventHandler(this.bindingNavigatorAddNewItem_Click);
            // 
            // bindingNavigatorCountItem
            // 
            this.bindingNavigatorCountItem.Name = "bindingNavigatorCountItem";
            this.bindingNavigatorCountItem.Size = new System.Drawing.Size(43, 22);
            this.bindingNavigatorCountItem.Text = "для {0}";
            this.bindingNavigatorCountItem.ToolTipText = "Общее число элементов";
            // 
            // bindingNavigatorDeleteItem
            // 
            this.bindingNavigatorDeleteItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorDeleteItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorDeleteItem.Image")));
            this.bindingNavigatorDeleteItem.Name = "bindingNavigatorDeleteItem";
            this.bindingNavigatorDeleteItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorDeleteItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorDeleteItem.Text = "Удалить";
            this.bindingNavigatorDeleteItem.Click += new System.EventHandler(this.bindingNavigatorDeleteItem_Click);
            // 
            // bindingNavigatorMoveFirstItem
            // 
            this.bindingNavigatorMoveFirstItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMoveFirstItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMoveFirstItem.Image")));
            this.bindingNavigatorMoveFirstItem.Name = "bindingNavigatorMoveFirstItem";
            this.bindingNavigatorMoveFirstItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMoveFirstItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorMoveFirstItem.Text = "Переместить в начало";
            // 
            // bindingNavigatorMovePreviousItem
            // 
            this.bindingNavigatorMovePreviousItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMovePreviousItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMovePreviousItem.Image")));
            this.bindingNavigatorMovePreviousItem.Name = "bindingNavigatorMovePreviousItem";
            this.bindingNavigatorMovePreviousItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMovePreviousItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorMovePreviousItem.Text = "Переместить назад";
            // 
            // bindingNavigatorSeparator
            // 
            this.bindingNavigatorSeparator.Name = "bindingNavigatorSeparator";
            this.bindingNavigatorSeparator.Size = new System.Drawing.Size(6, 25);
            // 
            // bindingNavigatorPositionItem
            // 
            this.bindingNavigatorPositionItem.AccessibleName = "Положение";
            this.bindingNavigatorPositionItem.AutoSize = false;
            this.bindingNavigatorPositionItem.Name = "bindingNavigatorPositionItem";
            this.bindingNavigatorPositionItem.Size = new System.Drawing.Size(50, 23);
            this.bindingNavigatorPositionItem.Text = "0";
            this.bindingNavigatorPositionItem.ToolTipText = "Текущее положение";
            // 
            // bindingNavigatorSeparator1
            // 
            this.bindingNavigatorSeparator1.Name = "bindingNavigatorSeparator1";
            this.bindingNavigatorSeparator1.Size = new System.Drawing.Size(6, 25);
            // 
            // bindingNavigatorMoveNextItem
            // 
            this.bindingNavigatorMoveNextItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMoveNextItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMoveNextItem.Image")));
            this.bindingNavigatorMoveNextItem.Name = "bindingNavigatorMoveNextItem";
            this.bindingNavigatorMoveNextItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMoveNextItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorMoveNextItem.Text = "Переместить вперед";
            // 
            // bindingNavigatorMoveLastItem
            // 
            this.bindingNavigatorMoveLastItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMoveLastItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMoveLastItem.Image")));
            this.bindingNavigatorMoveLastItem.Name = "bindingNavigatorMoveLastItem";
            this.bindingNavigatorMoveLastItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMoveLastItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorMoveLastItem.Text = "Переместить в конец";
            // 
            // bindingNavigatorSeparator2
            // 
            this.bindingNavigatorSeparator2.Name = "bindingNavigatorSeparator2";
            this.bindingNavigatorSeparator2.Size = new System.Drawing.Size(6, 25);
            // 
            // bindingNavigatorSaveItem
            // 
            this.bindingNavigatorSaveItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorSaveItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorSaveItem.Image")));
            this.bindingNavigatorSaveItem.Name = "bindingNavigatorSaveItem";
            this.bindingNavigatorSaveItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorSaveItem.Text = "Сохранить данные";
            this.bindingNavigatorSaveItem.Click += new System.EventHandler(this.bindingNavigatorSaveItem_Click);
            // 
            // select_curr_day_schedTableAdapter
            // 
            this.select_curr_day_schedTableAdapter.ClearBeforeFill = true;
            // 
            // tableAdapterManager
            // 
            this.tableAdapterManager.agegroupsTableAdapter = null;
            this.tableAdapterManager.BackupDataSetBeforeUpdate = false;
            this.tableAdapterManager.clientsTableAdapter = this.clientsTableAdapter;
            this.tableAdapterManager.enddatesTableAdapter = null;
            this.tableAdapterManager.instructorsandlessonsTableAdapter = null;
            this.tableAdapterManager.instructorsTableAdapter = null;
            this.tableAdapterManager.numberoflessonsTableAdapter = null;
            this.tableAdapterManager.scheduleTableAdapter = null;
            this.tableAdapterManager.sectionsTableAdapter = null;
            this.tableAdapterManager.typesofsubTableAdapter = null;
            this.tableAdapterManager.UpdateOrder = DB.sportclubDataSetTableAdapters.TableAdapterManager.UpdateOrderOption.InsertUpdateDelete;
            // 
            // clientsTableAdapter
            // 
            this.clientsTableAdapter.ClearBeforeFill = true;
            // 
            // sectionsTableAdapter
            // 
            this.sectionsTableAdapter.ClearBeforeFill = true;
            // 
            // numberoflessonsTableAdapter
            // 
            this.numberoflessonsTableAdapter.ClearBeforeFill = true;
            // 
            // enddatesTableAdapter
            // 
            this.enddatesTableAdapter.ClearBeforeFill = true;
            // 
            // scheduleTableAdapter
            // 
            this.scheduleTableAdapter.ClearBeforeFill = true;
            // 
            // instructorsTableAdapter
            // 
            this.instructorsTableAdapter.ClearBeforeFill = true;
            // 
            // instructorsandlessonsTableAdapter
            // 
            this.instructorsandlessonsTableAdapter.ClearBeforeFill = true;
            // 
            // selectnumbersectionsTableAdapter
            // 
            this.selectnumbersectionsTableAdapter.ClearBeforeFill = true;
            // 
            // selectdatesectionsTableAdapter
            // 
            this.selectdatesectionsTableAdapter.ClearBeforeFill = true;
            // 
            // typesofsubTableAdapter
            // 
            this.typesofsubTableAdapter.ClearBeforeFill = true;
            // 
            // selectdayscheduleTableAdapter
            // 
            this.selectdayscheduleTableAdapter.ClearBeforeFill = true;
            // 
            // textBox7
            // 
            this.textBox7.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.selectnumbersectionsBindingSource, "price", true));
            this.textBox7.Location = new System.Drawing.Point(409, 95);
            this.textBox7.Name = "textBox7";
            this.textBox7.Size = new System.Drawing.Size(100, 20);
            this.textBox7.TabIndex = 6;
            // 
            // label24
            // 
            this.label24.AutoSize = true;
            this.label24.Location = new System.Drawing.Point(406, 79);
            this.label24.Name = "label24";
            this.label24.Size = new System.Drawing.Size(62, 13);
            this.label24.TabIndex = 7;
            this.label24.Text = "Цена (руб):";
            // 
            // textBox8
            // 
            this.textBox8.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.selectnumbersectionsBindingSource, "currPeopleCount", true));
            this.textBox8.Location = new System.Drawing.Point(409, 138);
            this.textBox8.Name = "textBox8";
            this.textBox8.Size = new System.Drawing.Size(100, 20);
            this.textBox8.TabIndex = 8;
            // 
            // textBox9
            // 
            this.textBox9.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.selectnumbersectionsBindingSource, "maxPeopleCount", true));
            this.textBox9.Location = new System.Drawing.Point(409, 181);
            this.textBox9.Name = "textBox9";
            this.textBox9.Size = new System.Drawing.Size(100, 20);
            this.textBox9.TabIndex = 9;
            // 
            // label25
            // 
            this.label25.AutoSize = true;
            this.label25.Location = new System.Drawing.Point(406, 122);
            this.label25.Name = "label25";
            this.label25.Size = new System.Drawing.Size(126, 13);
            this.label25.TabIndex = 10;
            this.label25.Text = "Текущее кол-во людей:";
            // 
            // label26
            // 
            this.label26.AutoSize = true;
            this.label26.Location = new System.Drawing.Point(406, 165);
            this.label26.Name = "label26";
            this.label26.Size = new System.Drawing.Size(111, 13);
            this.label26.TabIndex = 11;
            this.label26.Text = "Макс. кол-во людей:";
            // 
            // textBox10
            // 
            this.textBox10.Location = new System.Drawing.Point(211, 29);
            this.textBox10.Name = "textBox10";
            this.textBox10.Size = new System.Drawing.Size(76, 20);
            this.textBox10.TabIndex = 12;
            // 
            // textBox11
            // 
            this.textBox11.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.selectnumbersectionsBindingSource, "ageGroup_id", true));
            this.textBox11.Location = new System.Drawing.Point(460, 227);
            this.textBox11.Name = "textBox11";
            this.textBox11.Size = new System.Drawing.Size(53, 20);
            this.textBox11.TabIndex = 13;
            this.textBox11.TextChanged += new System.EventHandler(this.textBox11_TextChanged);
            // 
            // hidepanel
            // 
            this.hidepanel.Location = new System.Drawing.Point(409, 221);
            this.hidepanel.Name = "hidepanel";
            this.hidepanel.Size = new System.Drawing.Size(119, 67);
            this.hidepanel.TabIndex = 14;
            // 
            // label27
            // 
            this.label27.AutoSize = true;
            this.label27.Location = new System.Drawing.Point(9, 12);
            this.label27.Name = "label27";
            this.label27.Size = new System.Drawing.Size(18, 13);
            this.label27.TabIndex = 15;
            this.label27.Text = "id:";
            // 
            // label28
            // 
            this.label28.AutoSize = true;
            this.label28.Location = new System.Drawing.Point(77, 12);
            this.label28.Name = "label28";
            this.label28.Size = new System.Drawing.Size(60, 13);
            this.label28.TabIndex = 16;
            this.label28.Text = "Название:";
            // 
            // label29
            // 
            this.label29.AutoSize = true;
            this.label29.Location = new System.Drawing.Point(208, 13);
            this.label29.Name = "label29";
            this.label29.Size = new System.Drawing.Size(75, 13);
            this.label29.TabIndex = 17;
            this.label29.Text = "Возр. группа:";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(655, 429);
            this.Controls.Add(this.bindingNavigator);
            this.Controls.Add(this.tabControl1);
            this.Controls.Add(this.menuStrip1);
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "Form1";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Спортклуб имени Роберта Дауни мл.";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.tabControl1.ResumeLayout(false);
            this.tabPage1.ResumeLayout(false);
            this.tabPage1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.currDayDgv)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.select_curr_day_schedBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.sportclubDataSet)).EndInit();
            this.tabPage2.ResumeLayout(false);
            this.tabPage2.PerformLayout();
            this.clientspanel.ResumeLayout(false);
            this.clientspanel.PerformLayout();
            this.splitContainer1.Panel1.ResumeLayout(false);
            this.splitContainer1.Panel1.PerformLayout();
            this.splitContainer1.Panel2.ResumeLayout(false);
            this.splitContainer1.Panel2.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.splitContainer1)).EndInit();
            this.splitContainer1.ResumeLayout(false);
            this.panel2.ResumeLayout(false);
            this.panel2.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.selectnumbersectionsBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.sectionsBindingSource)).EndInit();
            this.panel3.ResumeLayout(false);
            this.panel3.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.typesofsubBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.selectdatesectionsBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.clientsBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.clientsDataGridView)).EndInit();
            this.tabPage3.ResumeLayout(false);
            this.tabPage3.PerformLayout();
            this.fillToolStrip.ResumeLayout(false);
            this.fillToolStrip.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.selectdayscheduleDataGridView)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.selectdayscheduleBindingSource)).EndInit();
            this.panel1.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.typesofsubDataGridView)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.selectdatesectionsDataGridView)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.selectnumbersectionsDataGridView)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.instructorsandlessonsDataGridView)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.instructorsandlessonsBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.instructorsDataGridView)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.instructorsBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.enddatesDataGridView)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.enddatesBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.sectionsDataGridView)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.scheduleDataGridView)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.scheduleBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.numberoflessonsDataGridView)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.numberoflessonsBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.sectionsBindingSource1)).EndInit();
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.bindingNavigator)).EndInit();
            this.bindingNavigator.ResumeLayout(false);
            this.bindingNavigator.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TabControl tabControl1;
        private System.Windows.Forms.TabPage tabPage1;
        private System.Windows.Forms.TabPage tabPage2;
        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem файлToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem справкаToolStripMenuItem;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label daylabel;
        private System.Windows.Forms.TabPage tabPage3;
        private sportclubDataSet sportclubDataSet;
        private System.Windows.Forms.BindingSource select_curr_day_schedBindingSource;
        private sportclubDataSetTableAdapters.select_curr_day_schedTableAdapter select_curr_day_schedTableAdapter;
        private sportclubDataSetTableAdapters.TableAdapterManager tableAdapterManager;
        private System.Windows.Forms.BindingNavigator bindingNavigator;
        private System.Windows.Forms.ToolStripButton bindingNavigatorAddNewItem;
        private System.Windows.Forms.ToolStripLabel bindingNavigatorCountItem;
        private System.Windows.Forms.ToolStripButton bindingNavigatorDeleteItem;
        private System.Windows.Forms.ToolStripButton bindingNavigatorMoveFirstItem;
        private System.Windows.Forms.ToolStripButton bindingNavigatorMovePreviousItem;
        private System.Windows.Forms.ToolStripSeparator bindingNavigatorSeparator;
        private System.Windows.Forms.ToolStripTextBox bindingNavigatorPositionItem;
        private System.Windows.Forms.ToolStripSeparator bindingNavigatorSeparator1;
        private System.Windows.Forms.ToolStripButton bindingNavigatorMoveNextItem;
        private System.Windows.Forms.ToolStripButton bindingNavigatorMoveLastItem;
        private System.Windows.Forms.ToolStripSeparator bindingNavigatorSeparator2;
        private System.Windows.Forms.ToolStripButton bindingNavigatorSaveItem;
        private System.Windows.Forms.DataGridView currDayDgv;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn1;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn2;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn3;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn4;
        private System.Windows.Forms.BindingSource clientsBindingSource;
        private sportclubDataSetTableAdapters.clientsTableAdapter clientsTableAdapter;
        private System.Windows.Forms.DataGridView clientsDataGridView;
        private System.Windows.Forms.ToolTip toolTip;
        private System.Windows.Forms.TextBox surnamesearchTextBox;
        private System.Windows.Forms.Button surnamesearchButton;
        private System.Windows.Forms.Label surnamesearchLabel;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.DataGridViewTextBoxColumn Column1;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn6;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn7;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn8;
        private System.Windows.Forms.DataGridViewCheckBoxColumn dataGridViewCheckBoxColumn1;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn9;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn10;
        private System.Windows.Forms.BindingSource sectionsBindingSource;
        private sportclubDataSetTableAdapters.sectionsTableAdapter sectionsTableAdapter;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.BindingSource numberoflessonsBindingSource;
        private sportclubDataSetTableAdapters.numberoflessonsTableAdapter numberoflessonsTableAdapter;
        private System.Windows.Forms.DataGridView sectionsDataGridView;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn13;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn14;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn15;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn16;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn17;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn18;
        private System.Windows.Forms.DataGridViewCheckBoxColumn dataGridViewCheckBoxColumn2;
        private System.Windows.Forms.DataGridView numberoflessonsDataGridView;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn5;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn11;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn12;
        private System.Windows.Forms.BindingSource enddatesBindingSource;
        private sportclubDataSetTableAdapters.enddatesTableAdapter enddatesTableAdapter;
        private System.Windows.Forms.DataGridView enddatesDataGridView;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn19;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn20;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn21;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn22;
        private System.Windows.Forms.BindingSource scheduleBindingSource;
        private sportclubDataSetTableAdapters.scheduleTableAdapter scheduleTableAdapter;
        private System.Windows.Forms.DataGridView scheduleDataGridView;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn23;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn24;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn25;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn26;
        private System.Windows.Forms.BindingSource instructorsBindingSource;
        private sportclubDataSetTableAdapters.instructorsTableAdapter instructorsTableAdapter;
        private System.Windows.Forms.DataGridView instructorsDataGridView;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn27;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn28;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn29;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn30;
        private System.Windows.Forms.BindingSource instructorsandlessonsBindingSource;
        private sportclubDataSetTableAdapters.instructorsandlessonsTableAdapter instructorsandlessonsTableAdapter;
        private System.Windows.Forms.DataGridView instructorsandlessonsDataGridView;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn31;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn32;
        private System.Windows.Forms.Panel clientspanel;
        private System.Windows.Forms.TextBox idTextBox;
        private System.Windows.Forms.TextBox nameTextBox;
        private System.Windows.Forms.TextBox surnameTextBox;
        private System.Windows.Forms.DateTimePicker birthdayDateTimePicker;
        private System.Windows.Forms.CheckBox isStudentCheckBox;
        private System.Windows.Forms.DateTimePicker lastVisitDateTimePicker;
        private System.Windows.Forms.TextBox numberTextBox;
        private System.Windows.Forms.Button checkinbutton;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox agegrouptextBox;
        private System.Windows.Forms.TextBox numberoflessonstextBox;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.ComboBox sectionscombobox;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox idsearch;
        private System.Windows.Forms.Button backclientsbutton;
        private System.Windows.Forms.TextBox addnumbertextBox;
        private System.Windows.Forms.Button addbutton;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label12;
        private System.Windows.Forms.DateTimePicker moreTimePicker;
        private System.Windows.Forms.Label label11;
        private System.Windows.Forms.DateTimePicker endTimePicker;
        private System.Windows.Forms.Label label10;
        private System.Windows.Forms.TextBox agegroupstextBox2;
        private System.Windows.Forms.ComboBox sectionscombobox2;
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.SplitContainer splitContainer1;
        private System.Windows.Forms.MonthCalendar monthCalendar1;
        private System.Windows.Forms.Label label13;
        private System.Windows.Forms.TextBox typeofsubtextBox;
        private System.Windows.Forms.Button extendbutton;
        private System.Windows.Forms.Button addsection;
        private System.Windows.Forms.Button addsection2;
        private System.Windows.Forms.Panel panel2;
        private System.Windows.Forms.Label label14;
        private System.Windows.Forms.TextBox ageGroup_idTextBox;
        private System.Windows.Forms.Label label15;
        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.TextBox textBox3;
        private System.Windows.Forms.ComboBox nameComboBox;
        private System.Windows.Forms.Button addsectionbutton;
        private System.Windows.Forms.TextBox agegrouptextBox2;
        private System.Windows.Forms.Panel panel3;
        private System.Windows.Forms.TextBox textBox5;
        private System.Windows.Forms.Label label18;
        private System.Windows.Forms.TextBox textBox2;
        private System.Windows.Forms.TextBox textBox4;
        private System.Windows.Forms.ComboBox comboBox1;
        private System.Windows.Forms.BindingSource selectnumbersectionsBindingSource;
        private sportclubDataSetTableAdapters.selectnumbersectionsTableAdapter selectnumbersectionsTableAdapter;
        private System.Windows.Forms.DataGridView selectnumbersectionsDataGridView;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn33;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn34;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn35;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn36;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn37;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn38;
        private System.Windows.Forms.DataGridViewCheckBoxColumn dataGridViewCheckBoxColumn3;
        private System.Windows.Forms.Label label22;
        private System.Windows.Forms.DateTimePicker dateTimePicker1;
        private System.Windows.Forms.BindingSource selectdatesectionsBindingSource;
        private sportclubDataSetTableAdapters.selectdatesectionsTableAdapter selectdatesectionsTableAdapter;
        private System.Windows.Forms.DataGridView selectdatesectionsDataGridView;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn39;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn40;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn41;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn42;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn43;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn44;
        private System.Windows.Forms.DataGridViewCheckBoxColumn dataGridViewCheckBoxColumn4;
        private System.Windows.Forms.Button button2;
        private System.Windows.Forms.Button button3;
        private System.Windows.Forms.Button addsectionsbutton2;
        private System.Windows.Forms.ComboBox comboBox2;
        private System.Windows.Forms.BindingSource typesofsubBindingSource;
        private sportclubDataSetTableAdapters.typesofsubTableAdapter typesofsubTableAdapter;
        private System.Windows.Forms.Label label23;
        private System.Windows.Forms.DataGridView typesofsubDataGridView;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn45;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn46;
        private System.Windows.Forms.Button nullbutton;
        private System.Windows.Forms.Button checkinbutton2;
        private System.Windows.Forms.BindingSource sectionsBindingSource1;
        private System.Windows.Forms.BindingSource selectdayscheduleBindingSource;
        private sportclubDataSetTableAdapters.selectdayscheduleTableAdapter selectdayscheduleTableAdapter;
        private System.Windows.Forms.ToolStrip fillToolStrip;
        private System.Windows.Forms.ToolStripButton fillToolStripButton;
        private System.Windows.Forms.DataGridView selectdayscheduleDataGridView;
        private System.Windows.Forms.TextBox textBox6;
        private System.Windows.Forms.ComboBox comboBox3;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn49;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn47;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn48;
        private System.Windows.Forms.Button clearbutton;
        private System.Windows.Forms.TextBox textBox7;
        private System.Windows.Forms.Label label26;
        private System.Windows.Forms.Label label25;
        private System.Windows.Forms.TextBox textBox9;
        private System.Windows.Forms.TextBox textBox8;
        private System.Windows.Forms.Label label24;
        private System.Windows.Forms.TextBox textBox11;
        private System.Windows.Forms.TextBox textBox10;
        private System.Windows.Forms.Panel hidepanel;
        private System.Windows.Forms.Label label29;
        private System.Windows.Forms.Label label28;
        private System.Windows.Forms.Label label27;
    }
}


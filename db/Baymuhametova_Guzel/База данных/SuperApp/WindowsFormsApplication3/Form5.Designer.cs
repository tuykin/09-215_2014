namespace WindowsFormsApplication3
{
    partial class Form5
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            System.Windows.Forms.Label idLabel;
            System.Windows.Forms.Label sexLabel;
            System.Windows.Forms.Label surnameLabel;
            System.Windows.Forms.Label name_touristLabel;
            System.Windows.Forms.Label date_of_birthLabel;
            System.Windows.Forms.Label num_PassportLabel;
            System.Windows.Forms.Label series_passportLabel;
            System.Windows.Forms.Label issuedLabel;
            System.Windows.Forms.Label citizenshipLabel;
            System.Windows.Forms.Label hotelIdLabel;
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form5));
            this.tourDataSet = new WindowsFormsApplication3.tourDataSet();
            this.touristsBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.touristsTableAdapter = new WindowsFormsApplication3.tourDataSetTableAdapters.touristsTableAdapter();
            this.tableAdapterManager = new WindowsFormsApplication3.tourDataSetTableAdapters.TableAdapterManager();
            this.touristsBindingNavigator = new System.Windows.Forms.BindingNavigator(this.components);
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
            this.touristsBindingNavigatorSaveItem = new System.Windows.Forms.ToolStripButton();
            this.touristsDataGridView = new System.Windows.Forms.DataGridView();
            this.dataGridViewTextBoxColumn1 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn2 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn3 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn4 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn5 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn6 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn7 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn8 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn9 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn10 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.panel1 = new System.Windows.Forms.Panel();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.button2 = new System.Windows.Forms.Button();
            this.HotelIdcomboBox = new System.Windows.Forms.ComboBox();
            this.idTextBox = new System.Windows.Forms.TextBox();
            this.sexTextBox = new System.Windows.Forms.TextBox();
            this.surnameTextBox = new System.Windows.Forms.TextBox();
            this.name_touristTextBox = new System.Windows.Forms.TextBox();
            this.date_of_birthDateTimePicker = new System.Windows.Forms.DateTimePicker();
            this.num_PassportTextBox = new System.Windows.Forms.TextBox();
            this.series_passportTextBox = new System.Windows.Forms.TextBox();
            this.issuedTextBox = new System.Windows.Forms.TextBox();
            this.citizenshipTextBox = new System.Windows.Forms.TextBox();
            this.button1 = new System.Windows.Forms.Button();
            this.button3 = new System.Windows.Forms.Button();
            this.textBox2 = new System.Windows.Forms.TextBox();
            idLabel = new System.Windows.Forms.Label();
            sexLabel = new System.Windows.Forms.Label();
            surnameLabel = new System.Windows.Forms.Label();
            name_touristLabel = new System.Windows.Forms.Label();
            date_of_birthLabel = new System.Windows.Forms.Label();
            num_PassportLabel = new System.Windows.Forms.Label();
            series_passportLabel = new System.Windows.Forms.Label();
            issuedLabel = new System.Windows.Forms.Label();
            citizenshipLabel = new System.Windows.Forms.Label();
            hotelIdLabel = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.tourDataSet)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.touristsBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.touristsBindingNavigator)).BeginInit();
            this.touristsBindingNavigator.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.touristsDataGridView)).BeginInit();
            this.panel1.SuspendLayout();
            this.SuspendLayout();
            // 
            // idLabel
            // 
            idLabel.AutoSize = true;
            idLabel.Location = new System.Drawing.Point(3, 6);
            idLabel.Name = "idLabel";
            idLabel.Size = new System.Drawing.Size(18, 13);
            idLabel.TabIndex = 1;
            idLabel.Text = "id:";
            // 
            // sexLabel
            // 
            sexLabel.AutoSize = true;
            sexLabel.Location = new System.Drawing.Point(4, 32);
            sexLabel.Name = "sexLabel";
            sexLabel.Size = new System.Drawing.Size(28, 13);
            sexLabel.TabIndex = 3;
            sexLabel.Text = "Sex:";
            // 
            // surnameLabel
            // 
            surnameLabel.AutoSize = true;
            surnameLabel.Location = new System.Drawing.Point(4, 58);
            surnameLabel.Name = "surnameLabel";
            surnameLabel.Size = new System.Drawing.Size(52, 13);
            surnameLabel.TabIndex = 5;
            surnameLabel.Text = "Surname:";
            // 
            // name_touristLabel
            // 
            name_touristLabel.AutoSize = true;
            name_touristLabel.Location = new System.Drawing.Point(4, 84);
            name_touristLabel.Name = "name_touristLabel";
            name_touristLabel.Size = new System.Drawing.Size(69, 13);
            name_touristLabel.TabIndex = 7;
            name_touristLabel.Text = "Name tourist:";
            // 
            // date_of_birthLabel
            // 
            date_of_birthLabel.AutoSize = true;
            date_of_birthLabel.Location = new System.Drawing.Point(4, 111);
            date_of_birthLabel.Name = "date_of_birthLabel";
            date_of_birthLabel.Size = new System.Drawing.Size(68, 13);
            date_of_birthLabel.TabIndex = 9;
            date_of_birthLabel.Text = "Date of birth:";
            // 
            // num_PassportLabel
            // 
            num_PassportLabel.AutoSize = true;
            num_PassportLabel.Location = new System.Drawing.Point(4, 136);
            num_PassportLabel.Name = "num_PassportLabel";
            num_PassportLabel.Size = new System.Drawing.Size(76, 13);
            num_PassportLabel.TabIndex = 11;
            num_PassportLabel.Text = "Num Passport:";
            // 
            // series_passportLabel
            // 
            series_passportLabel.AutoSize = true;
            series_passportLabel.Location = new System.Drawing.Point(4, 162);
            series_passportLabel.Name = "series_passportLabel";
            series_passportLabel.Size = new System.Drawing.Size(82, 13);
            series_passportLabel.TabIndex = 13;
            series_passportLabel.Text = "Series passport:";
            // 
            // issuedLabel
            // 
            issuedLabel.AutoSize = true;
            issuedLabel.Location = new System.Drawing.Point(4, 188);
            issuedLabel.Name = "issuedLabel";
            issuedLabel.Size = new System.Drawing.Size(41, 13);
            issuedLabel.TabIndex = 15;
            issuedLabel.Text = "Issued:";
            // 
            // citizenshipLabel
            // 
            citizenshipLabel.AutoSize = true;
            citizenshipLabel.Location = new System.Drawing.Point(4, 214);
            citizenshipLabel.Name = "citizenshipLabel";
            citizenshipLabel.Size = new System.Drawing.Size(60, 13);
            citizenshipLabel.TabIndex = 17;
            citizenshipLabel.Text = "Citizenship:";
            // 
            // hotelIdLabel
            // 
            hotelIdLabel.AutoSize = true;
            hotelIdLabel.Location = new System.Drawing.Point(4, 240);
            hotelIdLabel.Name = "hotelIdLabel";
            hotelIdLabel.Size = new System.Drawing.Size(47, 13);
            hotelIdLabel.TabIndex = 19;
            hotelIdLabel.Text = "Hotel Id:";
            // 
            // tourDataSet
            // 
            this.tourDataSet.DataSetName = "tourDataSet";
            this.tourDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // touristsBindingSource
            // 
            this.touristsBindingSource.DataMember = "tourists";
            this.touristsBindingSource.DataSource = this.tourDataSet;
            // 
            // touristsTableAdapter
            // 
            this.touristsTableAdapter.ClearBeforeFill = true;
            // 
            // tableAdapterManager
            // 
            this.tableAdapterManager.BackupDataSetBeforeUpdate = false;
            this.tableAdapterManager.customerTableAdapter = null;
            this.tableAdapterManager.flightTableAdapter = null;
            this.tableAdapterManager.hotelTableAdapter = null;
            this.tableAdapterManager.reservationTableAdapter = null;
            this.tableAdapterManager.resortTableAdapter = null;
            this.tableAdapterManager.touristsTableAdapter = this.touristsTableAdapter;
            this.tableAdapterManager.UpdateOrder = WindowsFormsApplication3.tourDataSetTableAdapters.TableAdapterManager.UpdateOrderOption.InsertUpdateDelete;
            // 
            // touristsBindingNavigator
            // 
            this.touristsBindingNavigator.AddNewItem = this.bindingNavigatorAddNewItem;
            this.touristsBindingNavigator.BindingSource = this.touristsBindingSource;
            this.touristsBindingNavigator.CountItem = this.bindingNavigatorCountItem;
            this.touristsBindingNavigator.DeleteItem = this.bindingNavigatorDeleteItem;
            this.touristsBindingNavigator.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
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
            this.touristsBindingNavigatorSaveItem});
            this.touristsBindingNavigator.Location = new System.Drawing.Point(0, 0);
            this.touristsBindingNavigator.MoveFirstItem = this.bindingNavigatorMoveFirstItem;
            this.touristsBindingNavigator.MoveLastItem = this.bindingNavigatorMoveLastItem;
            this.touristsBindingNavigator.MoveNextItem = this.bindingNavigatorMoveNextItem;
            this.touristsBindingNavigator.MovePreviousItem = this.bindingNavigatorMovePreviousItem;
            this.touristsBindingNavigator.Name = "touristsBindingNavigator";
            this.touristsBindingNavigator.PositionItem = this.bindingNavigatorPositionItem;
            this.touristsBindingNavigator.Size = new System.Drawing.Size(436, 25);
            this.touristsBindingNavigator.TabIndex = 0;
            this.touristsBindingNavigator.Text = "bindingNavigator1";
            // 
            // bindingNavigatorAddNewItem
            // 
            this.bindingNavigatorAddNewItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorAddNewItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorAddNewItem.Image")));
            this.bindingNavigatorAddNewItem.Name = "bindingNavigatorAddNewItem";
            this.bindingNavigatorAddNewItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorAddNewItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorAddNewItem.Text = "Добавить";
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
            // touristsBindingNavigatorSaveItem
            // 
            this.touristsBindingNavigatorSaveItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.touristsBindingNavigatorSaveItem.Image = ((System.Drawing.Image)(resources.GetObject("touristsBindingNavigatorSaveItem.Image")));
            this.touristsBindingNavigatorSaveItem.Name = "touristsBindingNavigatorSaveItem";
            this.touristsBindingNavigatorSaveItem.Size = new System.Drawing.Size(23, 22);
            this.touristsBindingNavigatorSaveItem.Text = "Сохранить данные";
            this.touristsBindingNavigatorSaveItem.Click += new System.EventHandler(this.touristsBindingNavigatorSaveItem_Click);
            // 
            // touristsDataGridView
            // 
            this.touristsDataGridView.AutoGenerateColumns = false;
            this.touristsDataGridView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.touristsDataGridView.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.dataGridViewTextBoxColumn1,
            this.dataGridViewTextBoxColumn2,
            this.dataGridViewTextBoxColumn3,
            this.dataGridViewTextBoxColumn4,
            this.dataGridViewTextBoxColumn5,
            this.dataGridViewTextBoxColumn6,
            this.dataGridViewTextBoxColumn7,
            this.dataGridViewTextBoxColumn8,
            this.dataGridViewTextBoxColumn9,
            this.dataGridViewTextBoxColumn10});
            this.touristsDataGridView.DataSource = this.touristsBindingSource;
            this.touristsDataGridView.Location = new System.Drawing.Point(0, 28);
            this.touristsDataGridView.Name = "touristsDataGridView";
            this.touristsDataGridView.Size = new System.Drawing.Size(382, 211);
            this.touristsDataGridView.TabIndex = 1;
            this.touristsDataGridView.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.touristsDataGridView_CellContentClick);
            // 
            // dataGridViewTextBoxColumn1
            // 
            this.dataGridViewTextBoxColumn1.DataPropertyName = "id";
            this.dataGridViewTextBoxColumn1.HeaderText = "id";
            this.dataGridViewTextBoxColumn1.Name = "dataGridViewTextBoxColumn1";
            // 
            // dataGridViewTextBoxColumn2
            // 
            this.dataGridViewTextBoxColumn2.DataPropertyName = "Sex";
            this.dataGridViewTextBoxColumn2.HeaderText = "Sex";
            this.dataGridViewTextBoxColumn2.Name = "dataGridViewTextBoxColumn2";
            // 
            // dataGridViewTextBoxColumn3
            // 
            this.dataGridViewTextBoxColumn3.DataPropertyName = "Surname";
            this.dataGridViewTextBoxColumn3.HeaderText = "Surname";
            this.dataGridViewTextBoxColumn3.Name = "dataGridViewTextBoxColumn3";
            // 
            // dataGridViewTextBoxColumn4
            // 
            this.dataGridViewTextBoxColumn4.DataPropertyName = "Name_tourist";
            this.dataGridViewTextBoxColumn4.HeaderText = "Name_tourist";
            this.dataGridViewTextBoxColumn4.Name = "dataGridViewTextBoxColumn4";
            // 
            // dataGridViewTextBoxColumn5
            // 
            this.dataGridViewTextBoxColumn5.DataPropertyName = "Date_of_birth";
            this.dataGridViewTextBoxColumn5.HeaderText = "Date_of_birth";
            this.dataGridViewTextBoxColumn5.Name = "dataGridViewTextBoxColumn5";
            // 
            // dataGridViewTextBoxColumn6
            // 
            this.dataGridViewTextBoxColumn6.DataPropertyName = "Num_Passport";
            this.dataGridViewTextBoxColumn6.HeaderText = "Num_Passport";
            this.dataGridViewTextBoxColumn6.Name = "dataGridViewTextBoxColumn6";
            // 
            // dataGridViewTextBoxColumn7
            // 
            this.dataGridViewTextBoxColumn7.DataPropertyName = "Series_passport";
            this.dataGridViewTextBoxColumn7.HeaderText = "Series_passport";
            this.dataGridViewTextBoxColumn7.Name = "dataGridViewTextBoxColumn7";
            // 
            // dataGridViewTextBoxColumn8
            // 
            this.dataGridViewTextBoxColumn8.DataPropertyName = "Issued";
            this.dataGridViewTextBoxColumn8.HeaderText = "Issued";
            this.dataGridViewTextBoxColumn8.Name = "dataGridViewTextBoxColumn8";
            // 
            // dataGridViewTextBoxColumn9
            // 
            this.dataGridViewTextBoxColumn9.DataPropertyName = "Citizenship";
            this.dataGridViewTextBoxColumn9.HeaderText = "Citizenship";
            this.dataGridViewTextBoxColumn9.Name = "dataGridViewTextBoxColumn9";
            // 
            // dataGridViewTextBoxColumn10
            // 
            this.dataGridViewTextBoxColumn10.DataPropertyName = "HotelId";
            this.dataGridViewTextBoxColumn10.HeaderText = "HotelId";
            this.dataGridViewTextBoxColumn10.Name = "dataGridViewTextBoxColumn10";
            // 
            // panel1
            // 
            this.panel1.Controls.Add(this.textBox2);
            this.panel1.Controls.Add(this.button3);
            this.panel1.Controls.Add(this.textBox1);
            this.panel1.Controls.Add(this.button2);
            this.panel1.Controls.Add(this.HotelIdcomboBox);
            this.panel1.Controls.Add(idLabel);
            this.panel1.Controls.Add(this.idTextBox);
            this.panel1.Controls.Add(sexLabel);
            this.panel1.Controls.Add(this.sexTextBox);
            this.panel1.Controls.Add(surnameLabel);
            this.panel1.Controls.Add(this.surnameTextBox);
            this.panel1.Controls.Add(name_touristLabel);
            this.panel1.Controls.Add(this.name_touristTextBox);
            this.panel1.Controls.Add(date_of_birthLabel);
            this.panel1.Controls.Add(this.date_of_birthDateTimePicker);
            this.panel1.Controls.Add(num_PassportLabel);
            this.panel1.Controls.Add(this.num_PassportTextBox);
            this.panel1.Controls.Add(series_passportLabel);
            this.panel1.Controls.Add(this.series_passportTextBox);
            this.panel1.Controls.Add(issuedLabel);
            this.panel1.Controls.Add(this.issuedTextBox);
            this.panel1.Controls.Add(citizenshipLabel);
            this.panel1.Controls.Add(this.citizenshipTextBox);
            this.panel1.Controls.Add(hotelIdLabel);
            this.panel1.Controls.Add(this.button1);
            this.panel1.Location = new System.Drawing.Point(0, 28);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(412, 376);
            this.panel1.TabIndex = 2;
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(298, 35);
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(100, 20);
            this.textBox1.TabIndex = 22;
            // 
            // button2
            // 
            this.button2.Location = new System.Drawing.Point(298, 6);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(100, 23);
            this.button2.TabIndex = 21;
            this.button2.Text = "Общая сумма";
            this.button2.UseVisualStyleBackColor = true;
            this.button2.Click += new System.EventHandler(this.button2_Click);
            // 
            // HotelIdcomboBox
            // 
            this.HotelIdcomboBox.FormattingEnabled = true;
            this.HotelIdcomboBox.Location = new System.Drawing.Point(92, 240);
            this.HotelIdcomboBox.Name = "HotelIdcomboBox";
            this.HotelIdcomboBox.Size = new System.Drawing.Size(200, 21);
            this.HotelIdcomboBox.TabIndex = 20;
            // 
            // idTextBox
            // 
            this.idTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.touristsBindingSource, "id", true));
            this.idTextBox.Location = new System.Drawing.Point(92, 3);
            this.idTextBox.Name = "idTextBox";
            this.idTextBox.Size = new System.Drawing.Size(200, 20);
            this.idTextBox.TabIndex = 2;
            // 
            // sexTextBox
            // 
            this.sexTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.touristsBindingSource, "Sex", true));
            this.sexTextBox.Location = new System.Drawing.Point(92, 29);
            this.sexTextBox.Name = "sexTextBox";
            this.sexTextBox.Size = new System.Drawing.Size(200, 20);
            this.sexTextBox.TabIndex = 4;
            // 
            // surnameTextBox
            // 
            this.surnameTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.touristsBindingSource, "Surname", true));
            this.surnameTextBox.Location = new System.Drawing.Point(92, 55);
            this.surnameTextBox.Name = "surnameTextBox";
            this.surnameTextBox.Size = new System.Drawing.Size(200, 20);
            this.surnameTextBox.TabIndex = 6;
            // 
            // name_touristTextBox
            // 
            this.name_touristTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.touristsBindingSource, "Name_tourist", true));
            this.name_touristTextBox.Location = new System.Drawing.Point(92, 81);
            this.name_touristTextBox.Name = "name_touristTextBox";
            this.name_touristTextBox.Size = new System.Drawing.Size(200, 20);
            this.name_touristTextBox.TabIndex = 8;
            // 
            // date_of_birthDateTimePicker
            // 
            this.date_of_birthDateTimePicker.DataBindings.Add(new System.Windows.Forms.Binding("Value", this.touristsBindingSource, "Date_of_birth", true));
            this.date_of_birthDateTimePicker.Location = new System.Drawing.Point(92, 107);
            this.date_of_birthDateTimePicker.Name = "date_of_birthDateTimePicker";
            this.date_of_birthDateTimePicker.Size = new System.Drawing.Size(200, 20);
            this.date_of_birthDateTimePicker.TabIndex = 10;
            // 
            // num_PassportTextBox
            // 
            this.num_PassportTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.touristsBindingSource, "Num_Passport", true));
            this.num_PassportTextBox.Location = new System.Drawing.Point(92, 133);
            this.num_PassportTextBox.Name = "num_PassportTextBox";
            this.num_PassportTextBox.Size = new System.Drawing.Size(200, 20);
            this.num_PassportTextBox.TabIndex = 12;
            // 
            // series_passportTextBox
            // 
            this.series_passportTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.touristsBindingSource, "Series_passport", true));
            this.series_passportTextBox.Location = new System.Drawing.Point(92, 159);
            this.series_passportTextBox.Name = "series_passportTextBox";
            this.series_passportTextBox.Size = new System.Drawing.Size(200, 20);
            this.series_passportTextBox.TabIndex = 14;
            // 
            // issuedTextBox
            // 
            this.issuedTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.touristsBindingSource, "Issued", true));
            this.issuedTextBox.Location = new System.Drawing.Point(92, 185);
            this.issuedTextBox.Name = "issuedTextBox";
            this.issuedTextBox.Size = new System.Drawing.Size(200, 20);
            this.issuedTextBox.TabIndex = 16;
            // 
            // citizenshipTextBox
            // 
            this.citizenshipTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.touristsBindingSource, "Citizenship", true));
            this.citizenshipTextBox.Location = new System.Drawing.Point(92, 211);
            this.citizenshipTextBox.Name = "citizenshipTextBox";
            this.citizenshipTextBox.Size = new System.Drawing.Size(200, 20);
            this.citizenshipTextBox.TabIndex = 18;
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(6, 279);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(75, 23);
            this.button1.TabIndex = 0;
            this.button1.Text = "Назад";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // button3
            // 
            this.button3.Location = new System.Drawing.Point(298, 81);
            this.button3.Name = "button3";
            this.button3.Size = new System.Drawing.Size(100, 65);
            this.button3.TabIndex = 23;
            this.button3.Text = "Количесвто людей отправляемых  в месяц";
            this.button3.UseVisualStyleBackColor = true;
            this.button3.Click += new System.EventHandler(this.button3_Click);
            // 
            // textBox2
            // 
            this.textBox2.Location = new System.Drawing.Point(298, 162);
            this.textBox2.Name = "textBox2";
            this.textBox2.Size = new System.Drawing.Size(100, 20);
            this.textBox2.TabIndex = 24;
            // 
            // Form5
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(436, 378);
            this.Controls.Add(this.panel1);
            this.Controls.Add(this.touristsDataGridView);
            this.Controls.Add(this.touristsBindingNavigator);
            this.Name = "Form5";
            this.Text = "Данные о туристе";
            this.Load += new System.EventHandler(this.Form5_Load);
            ((System.ComponentModel.ISupportInitialize)(this.tourDataSet)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.touristsBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.touristsBindingNavigator)).EndInit();
            this.touristsBindingNavigator.ResumeLayout(false);
            this.touristsBindingNavigator.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.touristsDataGridView)).EndInit();
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private tourDataSet tourDataSet;
        private System.Windows.Forms.BindingSource touristsBindingSource;
        private tourDataSetTableAdapters.touristsTableAdapter touristsTableAdapter;
        private tourDataSetTableAdapters.TableAdapterManager tableAdapterManager;
        private System.Windows.Forms.BindingNavigator touristsBindingNavigator;
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
        private System.Windows.Forms.ToolStripButton touristsBindingNavigatorSaveItem;
        private System.Windows.Forms.DataGridView touristsDataGridView;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn1;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn2;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn3;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn4;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn5;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn6;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn7;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn8;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn9;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn10;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.TextBox idTextBox;
        private System.Windows.Forms.TextBox sexTextBox;
        private System.Windows.Forms.TextBox surnameTextBox;
        private System.Windows.Forms.TextBox name_touristTextBox;
        private System.Windows.Forms.DateTimePicker date_of_birthDateTimePicker;
        private System.Windows.Forms.TextBox num_PassportTextBox;
        private System.Windows.Forms.TextBox series_passportTextBox;
        private System.Windows.Forms.TextBox issuedTextBox;
        private System.Windows.Forms.TextBox citizenshipTextBox;
        private System.Windows.Forms.ComboBox HotelIdcomboBox;
        private System.Windows.Forms.Button button2;
        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.TextBox textBox2;
        private System.Windows.Forms.Button button3;
    }
}
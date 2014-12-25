namespace WindowsFormsApplication3
{
    partial class Form6
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
            System.Windows.Forms.Label date_pLabel;
            System.Windows.Forms.Label k_daysLabel;
            System.Windows.Forms.Label k_childLabel;
            System.Windows.Forms.Label k_grownLabel;
            System.Windows.Forms.Label customerIdLabel;
            System.Windows.Forms.Label touristsIdLabel;
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form6));
            this.reservationBindingNavigator = new System.Windows.Forms.BindingNavigator(this.components);
            this.bindingNavigatorAddNewItem = new System.Windows.Forms.ToolStripButton();
            this.reservationBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.tourDataSet = new WindowsFormsApplication3.tourDataSet();
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
            this.reservationBindingNavigatorSaveItem = new System.Windows.Forms.ToolStripButton();
            this.reservationDataGridView = new System.Windows.Forms.DataGridView();
            this.dataGridViewTextBoxColumn1 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn2 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn3 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn4 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn5 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn6 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn7 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.panel1 = new System.Windows.Forms.Panel();
            this.button2 = new System.Windows.Forms.Button();
            this.TouristIdcomboBox = new System.Windows.Forms.ComboBox();
            this.CustomerIdcomboBox = new System.Windows.Forms.ComboBox();
            this.idTextBox = new System.Windows.Forms.TextBox();
            this.date_pDateTimePicker = new System.Windows.Forms.DateTimePicker();
            this.k_daysTextBox = new System.Windows.Forms.TextBox();
            this.k_childTextBox = new System.Windows.Forms.TextBox();
            this.k_grownTextBox = new System.Windows.Forms.TextBox();
            this.button1 = new System.Windows.Forms.Button();
            this.reservationTableAdapter = new WindowsFormsApplication3.tourDataSetTableAdapters.reservationTableAdapter();
            this.tableAdapterManager = new WindowsFormsApplication3.tourDataSetTableAdapters.TableAdapterManager();
            this.textBox1 = new System.Windows.Forms.TextBox();
            idLabel = new System.Windows.Forms.Label();
            date_pLabel = new System.Windows.Forms.Label();
            k_daysLabel = new System.Windows.Forms.Label();
            k_childLabel = new System.Windows.Forms.Label();
            k_grownLabel = new System.Windows.Forms.Label();
            customerIdLabel = new System.Windows.Forms.Label();
            touristsIdLabel = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.reservationBindingNavigator)).BeginInit();
            this.reservationBindingNavigator.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.reservationBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.tourDataSet)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.reservationDataGridView)).BeginInit();
            this.panel1.SuspendLayout();
            this.SuspendLayout();
            // 
            // idLabel
            // 
            idLabel.AutoSize = true;
            idLabel.Location = new System.Drawing.Point(15, 19);
            idLabel.Name = "idLabel";
            idLabel.Size = new System.Drawing.Size(18, 13);
            idLabel.TabIndex = 1;
            idLabel.Text = "id:";
            // 
            // date_pLabel
            // 
            date_pLabel.AutoSize = true;
            date_pLabel.Location = new System.Drawing.Point(15, 46);
            date_pLabel.Name = "date_pLabel";
            date_pLabel.Size = new System.Drawing.Size(40, 13);
            date_pLabel.TabIndex = 3;
            date_pLabel.Text = "date p:";
            // 
            // k_daysLabel
            // 
            k_daysLabel.AutoSize = true;
            k_daysLabel.Location = new System.Drawing.Point(15, 71);
            k_daysLabel.Name = "k_daysLabel";
            k_daysLabel.Size = new System.Drawing.Size(42, 13);
            k_daysLabel.TabIndex = 5;
            k_daysLabel.Text = "K days:";
            // 
            // k_childLabel
            // 
            k_childLabel.AutoSize = true;
            k_childLabel.Location = new System.Drawing.Point(15, 97);
            k_childLabel.Name = "k_childLabel";
            k_childLabel.Size = new System.Drawing.Size(42, 13);
            k_childLabel.TabIndex = 7;
            k_childLabel.Text = "K child:";
            // 
            // k_grownLabel
            // 
            k_grownLabel.AutoSize = true;
            k_grownLabel.Location = new System.Drawing.Point(15, 123);
            k_grownLabel.Name = "k_grownLabel";
            k_grownLabel.Size = new System.Drawing.Size(49, 13);
            k_grownLabel.TabIndex = 9;
            k_grownLabel.Text = "K grown:";
            // 
            // customerIdLabel
            // 
            customerIdLabel.AutoSize = true;
            customerIdLabel.Location = new System.Drawing.Point(15, 149);
            customerIdLabel.Name = "customerIdLabel";
            customerIdLabel.Size = new System.Drawing.Size(66, 13);
            customerIdLabel.TabIndex = 11;
            customerIdLabel.Text = "Customer Id:";
            // 
            // touristsIdLabel
            // 
            touristsIdLabel.AutoSize = true;
            touristsIdLabel.Location = new System.Drawing.Point(15, 175);
            touristsIdLabel.Name = "touristsIdLabel";
            touristsIdLabel.Size = new System.Drawing.Size(59, 13);
            touristsIdLabel.TabIndex = 13;
            touristsIdLabel.Text = "Tourists Id:";
            // 
            // reservationBindingNavigator
            // 
            this.reservationBindingNavigator.AddNewItem = this.bindingNavigatorAddNewItem;
            this.reservationBindingNavigator.BindingSource = this.reservationBindingSource;
            this.reservationBindingNavigator.CountItem = this.bindingNavigatorCountItem;
            this.reservationBindingNavigator.DeleteItem = this.bindingNavigatorDeleteItem;
            this.reservationBindingNavigator.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
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
            this.reservationBindingNavigatorSaveItem});
            this.reservationBindingNavigator.Location = new System.Drawing.Point(0, 0);
            this.reservationBindingNavigator.MoveFirstItem = this.bindingNavigatorMoveFirstItem;
            this.reservationBindingNavigator.MoveLastItem = this.bindingNavigatorMoveLastItem;
            this.reservationBindingNavigator.MoveNextItem = this.bindingNavigatorMoveNextItem;
            this.reservationBindingNavigator.MovePreviousItem = this.bindingNavigatorMovePreviousItem;
            this.reservationBindingNavigator.Name = "reservationBindingNavigator";
            this.reservationBindingNavigator.PositionItem = this.bindingNavigatorPositionItem;
            this.reservationBindingNavigator.Size = new System.Drawing.Size(404, 25);
            this.reservationBindingNavigator.TabIndex = 0;
            this.reservationBindingNavigator.Text = "bindingNavigator1";
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
            // reservationBindingSource
            // 
            this.reservationBindingSource.DataMember = "reservation";
            this.reservationBindingSource.DataSource = this.tourDataSet;
            // 
            // tourDataSet
            // 
            this.tourDataSet.DataSetName = "tourDataSet";
            this.tourDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
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
            // reservationBindingNavigatorSaveItem
            // 
            this.reservationBindingNavigatorSaveItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.reservationBindingNavigatorSaveItem.Image = ((System.Drawing.Image)(resources.GetObject("reservationBindingNavigatorSaveItem.Image")));
            this.reservationBindingNavigatorSaveItem.Name = "reservationBindingNavigatorSaveItem";
            this.reservationBindingNavigatorSaveItem.Size = new System.Drawing.Size(23, 22);
            this.reservationBindingNavigatorSaveItem.Text = "Сохранить данные";
            this.reservationBindingNavigatorSaveItem.Click += new System.EventHandler(this.reservationBindingNavigatorSaveItem_Click);
            // 
            // reservationDataGridView
            // 
            this.reservationDataGridView.AutoGenerateColumns = false;
            this.reservationDataGridView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.reservationDataGridView.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.dataGridViewTextBoxColumn1,
            this.dataGridViewTextBoxColumn2,
            this.dataGridViewTextBoxColumn3,
            this.dataGridViewTextBoxColumn4,
            this.dataGridViewTextBoxColumn5,
            this.dataGridViewTextBoxColumn6,
            this.dataGridViewTextBoxColumn7});
            this.reservationDataGridView.DataSource = this.reservationBindingSource;
            this.reservationDataGridView.Location = new System.Drawing.Point(0, 28);
            this.reservationDataGridView.Name = "reservationDataGridView";
            this.reservationDataGridView.Size = new System.Drawing.Size(387, 225);
            this.reservationDataGridView.TabIndex = 1;
            this.reservationDataGridView.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.reservationDataGridView_CellContentClick);
            // 
            // dataGridViewTextBoxColumn1
            // 
            this.dataGridViewTextBoxColumn1.DataPropertyName = "id";
            this.dataGridViewTextBoxColumn1.HeaderText = "id";
            this.dataGridViewTextBoxColumn1.Name = "dataGridViewTextBoxColumn1";
            // 
            // dataGridViewTextBoxColumn2
            // 
            this.dataGridViewTextBoxColumn2.DataPropertyName = "date_p";
            this.dataGridViewTextBoxColumn2.HeaderText = "date_p";
            this.dataGridViewTextBoxColumn2.Name = "dataGridViewTextBoxColumn2";
            // 
            // dataGridViewTextBoxColumn3
            // 
            this.dataGridViewTextBoxColumn3.DataPropertyName = "K_days";
            this.dataGridViewTextBoxColumn3.HeaderText = "K_days";
            this.dataGridViewTextBoxColumn3.Name = "dataGridViewTextBoxColumn3";
            // 
            // dataGridViewTextBoxColumn4
            // 
            this.dataGridViewTextBoxColumn4.DataPropertyName = "K_child";
            this.dataGridViewTextBoxColumn4.HeaderText = "K_child";
            this.dataGridViewTextBoxColumn4.Name = "dataGridViewTextBoxColumn4";
            // 
            // dataGridViewTextBoxColumn5
            // 
            this.dataGridViewTextBoxColumn5.DataPropertyName = "K_grown";
            this.dataGridViewTextBoxColumn5.HeaderText = "K_grown";
            this.dataGridViewTextBoxColumn5.Name = "dataGridViewTextBoxColumn5";
            // 
            // dataGridViewTextBoxColumn6
            // 
            this.dataGridViewTextBoxColumn6.DataPropertyName = "CustomerId";
            this.dataGridViewTextBoxColumn6.HeaderText = "CustomerId";
            this.dataGridViewTextBoxColumn6.Name = "dataGridViewTextBoxColumn6";
            // 
            // dataGridViewTextBoxColumn7
            // 
            this.dataGridViewTextBoxColumn7.DataPropertyName = "TouristsId";
            this.dataGridViewTextBoxColumn7.HeaderText = "TouristsId";
            this.dataGridViewTextBoxColumn7.Name = "dataGridViewTextBoxColumn7";
            // 
            // panel1
            // 
            this.panel1.Controls.Add(this.textBox1);
            this.panel1.Controls.Add(this.button2);
            this.panel1.Controls.Add(this.TouristIdcomboBox);
            this.panel1.Controls.Add(this.CustomerIdcomboBox);
            this.panel1.Controls.Add(idLabel);
            this.panel1.Controls.Add(this.idTextBox);
            this.panel1.Controls.Add(date_pLabel);
            this.panel1.Controls.Add(this.date_pDateTimePicker);
            this.panel1.Controls.Add(k_daysLabel);
            this.panel1.Controls.Add(this.k_daysTextBox);
            this.panel1.Controls.Add(k_childLabel);
            this.panel1.Controls.Add(this.k_childTextBox);
            this.panel1.Controls.Add(k_grownLabel);
            this.panel1.Controls.Add(this.k_grownTextBox);
            this.panel1.Controls.Add(customerIdLabel);
            this.panel1.Controls.Add(touristsIdLabel);
            this.panel1.Controls.Add(this.button1);
            this.panel1.Location = new System.Drawing.Point(0, 28);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(404, 279);
            this.panel1.TabIndex = 2;
            // 
            // button2
            // 
            this.button2.Location = new System.Drawing.Point(317, 87);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(75, 23);
            this.button2.TabIndex = 16;
            this.button2.Text = "button2";
            this.button2.UseVisualStyleBackColor = true;
            this.button2.Click += new System.EventHandler(this.button2_Click);
            // 
            // TouristIdcomboBox
            // 
            this.TouristIdcomboBox.FormattingEnabled = true;
            this.TouristIdcomboBox.Location = new System.Drawing.Point(87, 172);
            this.TouristIdcomboBox.Name = "TouristIdcomboBox";
            this.TouristIdcomboBox.Size = new System.Drawing.Size(200, 21);
            this.TouristIdcomboBox.TabIndex = 15;
            // 
            // CustomerIdcomboBox
            // 
            this.CustomerIdcomboBox.FormattingEnabled = true;
            this.CustomerIdcomboBox.Location = new System.Drawing.Point(87, 145);
            this.CustomerIdcomboBox.Name = "CustomerIdcomboBox";
            this.CustomerIdcomboBox.Size = new System.Drawing.Size(200, 21);
            this.CustomerIdcomboBox.TabIndex = 14;
            // 
            // idTextBox
            // 
            this.idTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.reservationBindingSource, "id", true));
            this.idTextBox.Location = new System.Drawing.Point(87, 16);
            this.idTextBox.Name = "idTextBox";
            this.idTextBox.Size = new System.Drawing.Size(200, 20);
            this.idTextBox.TabIndex = 2;
            // 
            // date_pDateTimePicker
            // 
            this.date_pDateTimePicker.DataBindings.Add(new System.Windows.Forms.Binding("Value", this.reservationBindingSource, "date_p", true));
            this.date_pDateTimePicker.Location = new System.Drawing.Point(87, 42);
            this.date_pDateTimePicker.Name = "date_pDateTimePicker";
            this.date_pDateTimePicker.Size = new System.Drawing.Size(200, 20);
            this.date_pDateTimePicker.TabIndex = 4;
            // 
            // k_daysTextBox
            // 
            this.k_daysTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.reservationBindingSource, "K_days", true));
            this.k_daysTextBox.Location = new System.Drawing.Point(87, 68);
            this.k_daysTextBox.Name = "k_daysTextBox";
            this.k_daysTextBox.Size = new System.Drawing.Size(200, 20);
            this.k_daysTextBox.TabIndex = 6;
            // 
            // k_childTextBox
            // 
            this.k_childTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.reservationBindingSource, "K_child", true));
            this.k_childTextBox.Location = new System.Drawing.Point(87, 94);
            this.k_childTextBox.Name = "k_childTextBox";
            this.k_childTextBox.Size = new System.Drawing.Size(200, 20);
            this.k_childTextBox.TabIndex = 8;
            // 
            // k_grownTextBox
            // 
            this.k_grownTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.reservationBindingSource, "K_grown", true));
            this.k_grownTextBox.Location = new System.Drawing.Point(87, 120);
            this.k_grownTextBox.Name = "k_grownTextBox";
            this.k_grownTextBox.Size = new System.Drawing.Size(200, 20);
            this.k_grownTextBox.TabIndex = 10;
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(317, 41);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(75, 23);
            this.button1.TabIndex = 0;
            this.button1.Text = "Назад";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // reservationTableAdapter
            // 
            this.reservationTableAdapter.ClearBeforeFill = true;
            // 
            // tableAdapterManager
            // 
            this.tableAdapterManager.BackupDataSetBeforeUpdate = false;
            this.tableAdapterManager.customerTableAdapter = null;
            this.tableAdapterManager.flightTableAdapter = null;
            this.tableAdapterManager.hotelTableAdapter = null;
            this.tableAdapterManager.reservationTableAdapter = this.reservationTableAdapter;
            this.tableAdapterManager.resortTableAdapter = null;
            this.tableAdapterManager.touristsTableAdapter = null;
            this.tableAdapterManager.UpdateOrder = WindowsFormsApplication3.tourDataSetTableAdapters.TableAdapterManager.UpdateOrderOption.InsertUpdateDelete;
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(293, 123);
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(100, 20);
            this.textBox1.TabIndex = 3;
            // 
            // Form6
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(404, 331);
            this.Controls.Add(this.panel1);
            this.Controls.Add(this.reservationDataGridView);
            this.Controls.Add(this.reservationBindingNavigator);
            this.Name = "Form6";
            this.Text = "Данные о бронирование";
            this.Load += new System.EventHandler(this.Form6_Load);
            ((System.ComponentModel.ISupportInitialize)(this.reservationBindingNavigator)).EndInit();
            this.reservationBindingNavigator.ResumeLayout(false);
            this.reservationBindingNavigator.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.reservationBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.tourDataSet)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.reservationDataGridView)).EndInit();
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private tourDataSet tourDataSet;
        private System.Windows.Forms.BindingSource reservationBindingSource;
        private tourDataSetTableAdapters.reservationTableAdapter reservationTableAdapter;
        private tourDataSetTableAdapters.TableAdapterManager tableAdapterManager;
        private System.Windows.Forms.BindingNavigator reservationBindingNavigator;
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
        private System.Windows.Forms.ToolStripButton reservationBindingNavigatorSaveItem;
        private System.Windows.Forms.DataGridView reservationDataGridView;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn1;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn2;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn3;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn4;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn5;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn6;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn7;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.TextBox idTextBox;
        private System.Windows.Forms.DateTimePicker date_pDateTimePicker;
        private System.Windows.Forms.TextBox k_daysTextBox;
        private System.Windows.Forms.TextBox k_childTextBox;
        private System.Windows.Forms.TextBox k_grownTextBox;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.ComboBox TouristIdcomboBox;
        private System.Windows.Forms.ComboBox CustomerIdcomboBox;
        private System.Windows.Forms.Button button2;
        private System.Windows.Forms.TextBox textBox1;
    }
}
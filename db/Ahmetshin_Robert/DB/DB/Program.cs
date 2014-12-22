using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace DB
{
    static class Program
    {
        /// <summary>
        /// Главная точка входа для приложения.
        /// </summary>
        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            try
            {
                Application.Run(new Form1());
            }
            catch (NoNullAllowedException e)
            {
                MessageBox.Show("Что то с вводом\nСначала заполните аккуратно все поля, когда добавляете клиента\n" + e.Message);
                Application.Run(new Form1()); 
            }
        }
    }
}

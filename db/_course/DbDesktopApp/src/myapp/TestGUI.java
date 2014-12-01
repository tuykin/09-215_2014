package myapp;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TestGUI extends JFrame {

  TestGUI() {
    JPanel pnlButton = new JPanel();
    //Buttons
    JButton btnAddFlight = new JButton("Add Flight");

    //FlightInfo setbounds
      btnAddFlight.setBounds(60, 400, 220, 30);

      //JPanel bounds
      pnlButton.setBounds(800, 800, 200, 100);

      //Adding to JFrame
      pnlButton.add(btnAddFlight);
      add(pnlButton);

      JButton[][] btn_arr = new JButton[10][10];

        for (int i=0; i<10; i++) {
          for (int j=0; j<10; j++) {
            btn_arr[i][j] = new JButton("btn");
            btn_arr[i][j].setBounds(i * 10, j * 10, 10, 10);
            pnlButton.add(btn_arr[i][j]);
          }
        }

    setSize(400, 400);
      setBackground(Color.BLACK);
      setTitle("Air Traffic Control");
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }

  //Функция main, запускающаяся при старте приложения
    public static void main(String[] args) {
        //Создаем фрейм в потоке обработки событий
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestGUI();
            }
        });
    }

}

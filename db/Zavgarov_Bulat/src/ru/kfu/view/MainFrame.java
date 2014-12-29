package ru.kfu.view;


import ru.kfu.controller.MainController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * Created by Bulat on 25.12.14.
 */
public class MainFrame extends JFrame {

  private MainController mainController;

  public MainFrame(MainController mainController) {
    super();
    this.mainController = mainController;
    setSize(900, 900);
    setTitle("Application");
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    initMenuBar();
  }

  private void initMenuBar() {
    JMenuBar mb = new JMenuBar();
    setJMenuBar(mb);

    JMenu file = new JMenu("Файл");
    JMenuItem exit = file.add("Выход");
    mb.add(file);

    JMenu about = new JMenu("About");
    JMenuItem us = about.add("About us");
    mb.add(about);

    exit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        MainFrame.this.dispatchEvent(new WindowEvent(MainFrame.this, WindowEvent.WINDOW_CLOSING));
      }
    });

    us.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(MainFrame.this, "Автор: Завгаров Булат");
      }
    });

  }

  public void setMainPanel(JPanel mainPanel) {
    getContentPane().removeAll();
    getContentPane().add(mainPanel);
    getContentPane().revalidate();
    getContentPane().repaint();
  }
}

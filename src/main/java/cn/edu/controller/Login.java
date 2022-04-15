package cn.edu.controller;

import java.awt.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Sun Apr 03 11:08:57 CST 2022
 */



/**
 * @author unknown
 */
public class Login extends JFrame {
    public Login() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        button1 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u7528\u6237\u540d\uff1a");
        contentPane.add(label1);
        label1.setBounds(90, 35, 70, 25);

        //---- label2 ----
        label2.setText("\u5bc6\u7801\uff1a");
        contentPane.add(label2);
        label2.setBounds(90, 70, 50, label2.getPreferredSize().height);
        contentPane.add(textField1);
        textField1.setBounds(140, 35, 95, 25);
        contentPane.add(textField2);
        textField2.setBounds(140, 65, 95, 25);

        //---- button1 ----
        button1.setText("\u767b\u5f55");
        contentPane.add(button1);
        button1.setBounds(165, 100, 70, 35);

        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        new Login();
    }
}

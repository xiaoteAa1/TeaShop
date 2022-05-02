/*
 * Created by JFormDesigner on Tue Apr 19 11:46:54 CST 2022
 */

package cn.edu.controller;

import cn.edu.domain.Tea;
import cn.edu.service.Business_AddTeaSevice;
import cn.edu.service.impl.Business_AddTeaServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *@author  ZHH
 *@date    2022/04/19 16:08
 */
public class Business_AddTeaController extends JFrame {
    Business_AddTeaSevice bts = new Business_AddTeaServiceImpl();

    public Business_AddTeaController() {
        initComponents();
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        button1 = new JButton();
        textField1 = new JTextField();
        label1 = new JLabel();
        label2 = new JLabel();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();
        label3 = new JLabel();
        label4 = new JLabel();
        label10 = new JLabel();
        textField10 = new JTextField();
        button2 = new JButton();

        //======== this ========
        setTitle("\u6dfb\u52a0\u5976\u8336");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("\u65b0\u589e");
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(15, 215), button1.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(25, 55, 75, textField1.getPreferredSize().height);

        //---- label1 ----
        label1.setText("\u5976\u8336\u540d");
        contentPane.add(label1);
        label1.setBounds(30, 30, 45, 25);

        //---- label2 ----
        label2.setText("\u4ef7\u683c");
        contentPane.add(label2);
        label2.setBounds(140, 30, 45, 25);
        contentPane.add(textField2);
        textField2.setBounds(125, 55, 75, textField2.getPreferredSize().height);
        contentPane.add(textField3);
        textField3.setBounds(225, 55, 75, textField3.getPreferredSize().height);
        contentPane.add(textField4);
        textField4.setBounds(325, 55, 75, textField4.getPreferredSize().height);

        //---- label3 ----
        label3.setText("\u7c7b\u578b");
        contentPane.add(label3);
        label3.setBounds(230, 30, 45, 25);

        //---- label4 ----
        label4.setText("\u5907\u6ce8");
        contentPane.add(label4);
        label4.setBounds(335, 30, 45, 25);

        //---- label10 ----
        label10.setText("\u662f\u5426\u552e\u5356");
        contentPane.add(label10);
        label10.setBounds(35, 105, 55, 45);
        contentPane.add(textField10);
        textField10.setBounds(115, 110, 40, 30);

        //---- button2 ----
        button2.setText("\u8fd4\u56de\u754c\u9762");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(125, 215), button2.getPreferredSize()));

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTea();
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Business_TeaController bs=new Business_TeaController();
            }
        });
    }

    /**
     * 添加奶茶操作
     */
    void addTea(){

        Tea tea=new Tea();

        tea.setName(textField1.getText());
        tea.setPrice(Double.parseDouble(textField2.getText()));
        tea.setType(textField3.getText());
        tea.setRemark(textField4.getText());
        tea.setIsSale(Integer.parseInt(textField10.getText()));
        bts.addTea(tea);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JButton button1;
    private JTextField textField1;
    private JLabel label1;
    private JLabel label2;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JLabel label3;
    private JLabel label4;
    private JLabel label10;
    private JTextField textField10;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        new Business_AddTeaController();
    }
}

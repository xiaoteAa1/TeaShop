/*
 * Created by JFormDesigner on Sun May 01 00:33:25 CST 2022
 */

package cn.edu.controller;

import javax.swing.*;
import java.awt.*;

/**
 * @author 1
 */
public class User_SeeCar extends JFrame {
    public User_SeeCar() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label1 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(new Rectangle(new Point(0, 40), scrollPane1.getPreferredSize()));

        //---- label1 ----
        label1.setText("\u5df2\u9009\u5976\u8336\uff1a");
        contentPane.add(label1);
        label1.setBounds(15, 10, 75, label1.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u63d0\u4ea4\u8ba2\u5355");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(480, 390), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("\u53d6\u6d88\u52a0\u8d2d");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(480, 330), button2.getPreferredSize()));

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
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);





    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    static JTable table1;
    private JLabel label1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


}

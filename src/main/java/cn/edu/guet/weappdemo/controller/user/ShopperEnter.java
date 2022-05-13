/*
 * Created by JFormDesigner on Wed Apr 27 21:07:18 CST 2022
 */

package cn.edu.guet.weappdemo.controller.user;


import cn.edu.guet.weappdemo.controller.Login;

import javax.swing.*;
import java.awt.*;

/**
 * @author 1
 */
public class ShopperEnter extends JFrame {
    public ShopperEnter() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        button1 = new JButton();
        button3 = new JButton();
        button2 = new JButton();

        //======== this ========
        setTitle("购物入口");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("\u70b9\u8d2d\u5976\u8336");
        contentPane.add(button1);
        button1.setBounds(135, 45, 115, 55);

        //---- button3 ----
        button3.setText("\u8ba2\u5355\u67e5\u770b");
        contentPane.add(button3);
        button3.setBounds(135, 110, 115, 55);

        //---- button2 ----
        button2.setText("\u8fd4\u56de");
        contentPane.add(button2);
        button2.setBounds(5, 5, 80, 32);

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
        setSize(400, 300);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        //1、点购奶茶功能
        button1.addActionListener((e) -> {
            this.setVisible(false);

            User_SelectTea sb = new User_SelectTea();
            sb.setVisible(true);
            sb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });

        //2、查看订单功能
        button3.addActionListener((e) -> {
            this.setVisible(false);
            //HHS
            User_OrderController uoc = new User_OrderController();
            uoc.setVisible(true);
            uoc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });

        //3、返回上一级
        button2.addActionListener((e) -> {
            this.setVisible(false);

            Login login = new Login();
            login.setVisible(true);
            login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton button1;
    private JButton button3;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

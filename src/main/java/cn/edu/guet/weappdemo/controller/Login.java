/*
 * Created by JFormDesigner on Sun Apr 17 20:17:28 CST 2022
 */

package cn.edu.guet.weappdemo.controller;



import cn.edu.guet.weappdemo.controller.business.OwnerEnter;
import cn.edu.guet.weappdemo.controller.user.ShopperEnter;
import cn.edu.guet.weappdemo.service.Business_LoginService;
import cn.edu.guet.weappdemo.service.impl.Business_LoginServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author 1
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
        button2 = new JButton();

        //======== this ========
        setTitle("欢迎光临好运来奶茶店！");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u8d26\u53f7\uff1a");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(100, 40), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("\u5bc6\u7801\uff1a");
        contentPane.add(label2);
        label2.setBounds(100, 75, 45, 17);
        contentPane.add(textField1);
        textField1.setBounds(140, 35, 130, 30);
        contentPane.add(textField2);
        textField2.setBounds(140, 70, 130, 30);

        //---- button1 ----
        button1.setText("\u5546\u5bb6\u767b\u5f55");
        contentPane.add(button1);
        button1.setBounds(155, 110, 90, 45);

        //---- button2 ----
        button2.setText("\u5728\u7ebf\u70b9\u5355");
        contentPane.add(button2);
        button2.setBounds(155, 160, 90, 45);

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
        setSize(405, 310);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //1、商家管理入口
        button1.addActionListener((e) ->{
            String username = textField1.getText();
            String password = textField2.getText();
            if(username.equals("") || password.equals("")){
                JOptionPane.showMessageDialog(null, "请填写用户名和密码！");
                return;
            }

            boolean b = bls.login(username, password);
            if(!b){
                JOptionPane.showMessageDialog(null, "用户名或密码错误！");
                return;
            }else{
                JOptionPane.showMessageDialog(null, "登录成功！");

                this.setVisible(false);
                OwnerEnter oe = new OwnerEnter();
                oe.setVisible(true);
                oe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }

        });

        //2、消费者入口
        button2.addActionListener((e) ->{
            this.setVisible(false);

            ShopperEnter sp = new ShopperEnter();
            sp.setVisible(true);
            sp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private Business_LoginService bls = new Business_LoginServiceImpl();
    public static void main(String[] args) {
        new Login();
    }
}

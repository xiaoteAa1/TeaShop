/*
 * Created by JFormDesigner on Wed May 04 14:08:02 CST 2022
 */

package cn.edu.guet.weappdemo.controller;

import cn.edu.guet.weappdemo.controller.PayCode;
import cn.edu.guet.weappdemo.controller.user.User_SeeCar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author 1
 */
public class PatternOfPayment extends JFrame {
    public PatternOfPayment(User_SeeCar user_seeCar, String message, String total_fee) {
        this.message = message;
        this.total_fee = total_fee;
        this.user_seeCar = user_seeCar;
        initComponents();
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("\u5fae\u4fe1\u626b\u7801\u652f\u4ed8");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 3f));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(395, 35), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("\u5fae\u4fe1\u4ed8\u6b3e\u7801\u652f\u4ed8");
        button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 3f));
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(390, 90), button2.getPreferredSize()));

        //---- button3 ----
        button3.setText("\u53d6\u6d88\u652f\u4ed8");
        button3.setFont(button3.getFont().deriveFont(button3.getFont().getSize() + 3f));
        contentPane.add(button3);
        button3.setBounds(new Rectangle(new Point(410, 140), button3.getPreferredSize()));

        //---- label1 ----
        label1.setText("\u7528\u6237\u540d\uff1a");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 3f));
        contentPane.add(label1);
        label1.setBounds(20, 48, 70, 25);
        contentPane.add(textField1);
        textField1.setBounds(100, 45, 125, 30);

        //---- label2 ----
        label2.setText("\u8ba2\u5355\u5907\u6ce8\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 3f));
        contentPane.add(label2);
        label2.setBounds(15, 90, 82, label2.getPreferredSize().height);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(textArea1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(100, 95, 245, 95);

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


        // 微信二维码支付
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获取用户名
                String username = textField1.getText();
                // 获取用户订单备注
                String remark = textArea1.getText();
                // 订单信息格式化
//                String userInfos = "username," + username + ";" + "remark," + remark + ":";
                String userInfos = "1," + username + ";" + "1," + remark + ":";
                String itemInfos = userInfos + message;
                // 生成该订单信息的二维码
                MainQRCode.createQRCode(itemInfos,total_fee);
//                // 测试用的方法
//                MainQRCode.testQRCode(message,total_fee,"");
                setVisible(false);
                // 显示二维码
                new QRCodeJpg(patternOfPayment);
            }
        });

        // 微信付款码支付
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获取用户名
                String username = textField1.getText();
                // 获取用户订单备注
                String remark = textArea1.getText();
                // 订单信息格式化
//                String userInfos = "username," + username + ";" + "remark," + remark + ":";
                String userInfos = "1," + username + ";" + "1," + remark + ":";
                String itemInfos = userInfos + message;
                setVisible(false);
                new PayCode(patternOfPayment,itemInfos,total_fee);
            }
        });

        // 取消订单支付，返回到购物车界面
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                user_seeCar.setVisible(true);
            }
        });
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    // 订单金额
    private String total_fee;
    // 订单部分信息
    private String message;
    private PatternOfPayment patternOfPayment = this;
    private User_SeeCar user_seeCar;
}

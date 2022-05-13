package cn.edu.guet.weappdemo.controller.business;
/*
 * @author  tlj
 * @date  2022/5/10 20:58
 */


import cn.edu.guet.weappdemo.dao.impl.Business_UpdateDaoImpl;
import cn.edu.guet.weappdemo.domain.Order;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Timestamp;

public class Business_OrderUpdataController extends JFrame {

    Order order;
    public Business_OrderUpdataController(Order order) {
        this.order=order;
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField();
        textField1.setText(String.valueOf(order.getId()));

        label2 = new JLabel();
        textField2 = new JTextField();
        textField2.setText(String.valueOf(order.getMch_id()));

        label3 = new JLabel();
        textField3 = new JTextField();
        textField3.setText(order.getTransaction_id());

        label4 = new JLabel();
        textField4 = new JTextField();
        textField4.setText(order.getTransaction_id());

        label5 = new JLabel();
        textField5 = new JTextField();
        textField5.setText(String.valueOf(order.getStart_time()));


        label6 = new JLabel();
        textField6 = new JTextField();
        textField6.setText(order.getUsername());

        label7 = new JLabel();
        textField7 = new JTextField();
        textField7.setText(order.getList());

        label8 = new JLabel();
        textField8 = new JTextField();
        textField8.setText(String.valueOf(order.getAmount()));

        label9 = new JLabel();
        textField9 = new JTextField();
        textField9.setText(String.valueOf(order.getStatus()));

        label10 = new JLabel();
        textField10 = new JTextField();
        textField10.setText(order.getRemark());

        button1 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u8ba2  \u5355  \u7f16  \u53f7");
        contentPane.add(label1);
        label1.setBounds(0, 10, 80, 20);
        contentPane.add(textField1);
        textField1.setBounds(90, 5, 110, 30);

        //---- label2 ----
        label2.setText("\u5546\u6237id");
        contentPane.add(label2);
        label2.setBounds(205, 10, 50, 25);
        contentPane.add(textField2);
        textField2.setBounds(255, 5, 110, 30);

        //---- label3 ----
        label3.setText("out_trade_no");
        contentPane.add(label3);
        label3.setBounds(0, 45, 85, 25);
        contentPane.add(textField3);
        textField3.setBounds(90, 45, 110, 30);

        //---- label4 ----
        label4.setText("\u4e8b\u52a1id");
        contentPane.add(label4);
        label4.setBounds(205, 50, 45, label4.getPreferredSize().height);
        contentPane.add(textField4);
        textField4.setBounds(255, 45, 110, 30);

        //---- label5 ----
        label5.setText("\u5f00  \u59cb  \u65f6  \u95f4");
        contentPane.add(label5);
        label5.setBounds(0, 95, 75, label5.getPreferredSize().height);
        contentPane.add(textField5);
        textField5.setBounds(90, 90, 110, 30);

        //---- label6 ----
        label6.setText("\u7528\u6237\u540d");
        contentPane.add(label6);
        label6.setBounds(205, 95, 45, label6.getPreferredSize().height);
        contentPane.add(textField6);
        textField6.setBounds(255, 90, 110, 30);

        //---- label7 ----
        label7.setText("\u8ba2  \u5355  \u5217  \u8868");
        contentPane.add(label7);
        label7.setBounds(0, 140, 80, label7.getPreferredSize().height);
        contentPane.add(textField7);
        textField7.setBounds(90, 135, 110, 30);

        //---- label8 ----
        label8.setText("\u603b\u91d1\u989d");
        contentPane.add(label8);
        label8.setBounds(205, 140, 50, label8.getPreferredSize().height);
        contentPane.add(textField8);
        textField8.setBounds(255, 135, 110, 30);

        //---- label9 ----
        label9.setText("\u5b8c  \u6210  \u72b6  \u6001");
        contentPane.add(label9);
        label9.setBounds(0, 185, 75, 25);
        contentPane.add(textField9);
        textField9.setBounds(90, 185, 110, 30);

        //---- label10 ----
        label10.setText("\u5907   \u6ce8");
        contentPane.add(label10);
        label10.setBounds(205, 190, 45, label10.getPreferredSize().height);
        contentPane.add(textField10);
        textField10.setBounds(255, 185, 110, 30);

        //---- button1 ----
        button1.setText("\u63d0\u4ea4");
        contentPane.add(button1);
        button1.setBounds(160, 225, 85, button1.getPreferredSize().height);

        //给提交按钮安装监听事件
        button1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获得修改订单页面的新数据信息
                int mch_id= Integer.parseInt(textField2.getText());
                String out_trade_no=textField3.getText();
                String transaction_id=textField4.getText();
                Timestamp start_time= Timestamp.valueOf(textField5.getText());
                String username=textField6.getText();
                String list=textField7.getText();
                double amount= Double.parseDouble(textField8.getText());
                int status= Integer.parseInt(textField9.getText());
                String remark=textField10.getText();

                //order表重新更新数据
                order.setMch_id(mch_id);
                order.setOut_trade_no(out_trade_no);
                order.setTransaction_id(transaction_id);
                order.setStart_time(start_time);
                order.setUsername(username);
                order.setList(list);
                order.setAmount(amount);
                order.setStatus(status);
                order.setRemark(remark);
                Business_UpdateDaoImpl updateDao=new Business_UpdateDaoImpl();
                updateDao.setUpdateInformation(order);
                JOptionPane.showMessageDialog(null, "修改数据成功");
                dispose();

            }
        });


        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        super.setTitle("修改订单信息");
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JTextField textField3;
    private JLabel label4;
    private JTextField textField4;
    private JLabel label5;
    private JTextField textField5;
    private JLabel label6;
    private JTextField textField6;
    private JLabel label7;
    private JTextField textField7;
    private JLabel label8;
    private JTextField textField8;
    private JLabel label9;
    private JTextField textField9;
    private JLabel label10;
    private JTextField textField10;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        new Business_OrderManageController();
    }
}

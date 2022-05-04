/*
 * Created by JFormDesigner on Tue May 03 23:30:57 CST 2022
 */

package cn.edu.guet.weappdemo.controller.user;

import cn.edu.guet.weappdemo.domain.Order;

import java.awt.*;
import javax.swing.*;

/**
 * @author HHS
 */
public class User_OrderDetails extends JFrame {
    public User_OrderDetails(Order order) {
        this.order = order;
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        rt = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        scrollPane1 = new JScrollPane();
        list = new JTextArea();
        label9 = new JLabel();
        label10 = new JLabel();
        scrollPane2 = new JScrollPane();
        remark = new JTextArea();
        id = new JLabel();
        status = new JLabel();
        username = new JLabel();
        mch_id = new JLabel();
        out_trade_no = new JLabel();
        transaction_id = new JLabel();
        start_time = new JLabel();
        amount = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- rt ----
        rt.setText("\u8fd4\u56de");
        contentPane.add(rt);
        rt.setBounds(new Rectangle(new Point(325, 375), rt.getPreferredSize()));

        //---- label1 ----
        label1.setText("\u5e8f\u53f7");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(15, 15), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("\u8ba2\u5355\u72b6\u6001");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(255, 15), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u5546\u6237");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(15, 85), label3.getPreferredSize()));

        //---- label4 ----
        label4.setText("\u8ba2\u5355\u53f7");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(15, 120), label4.getPreferredSize()));

        //---- label5 ----
        label5.setText("\u4ea4\u6613\u53f7");
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(15, 155), label5.getPreferredSize()));

        //---- label6 ----
        label6.setText("\u8ba2\u5355\u53d1\u8d77\u65f6\u95f4");
        contentPane.add(label6);
        label6.setBounds(new Rectangle(new Point(15, 190), label6.getPreferredSize()));

        //---- label7 ----
        label7.setText("\u7528\u6237\u540d");
        contentPane.add(label7);
        label7.setBounds(new Rectangle(new Point(15, 50), label7.getPreferredSize()));

        //---- label8 ----
        label8.setText("\u5546\u54c1\u5217\u8868");
        contentPane.add(label8);
        label8.setBounds(new Rectangle(new Point(15, 225), label8.getPreferredSize()));

        //======== scrollPane1 ========
        {

            //---- list ----
            list.setBackground(new Color(0, 0, 0, 0));
            scrollPane1.setViewportView(list);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(75, 225, 295, 65);

        //---- label9 ----
        label9.setText("\u603b\u91d1\u989d");
        contentPane.add(label9);
        label9.setBounds(new Rectangle(new Point(255, 190), label9.getPreferredSize()));

        //---- label10 ----
        label10.setText("\u5907\u6ce8\u4fe1\u606f");
        contentPane.add(label10);
        label10.setBounds(new Rectangle(new Point(15, 315), label10.getPreferredSize()));

        //======== scrollPane2 ========
        {

            //---- remark ----
            remark.setBackground(new Color(0, 0, 0, 0));
            scrollPane2.setViewportView(remark);
        }
        contentPane.add(scrollPane2);
        scrollPane2.setBounds(75, 315, 295, 45);
        contentPane.add(id);
        id.setBounds(60, 10, 100, 25);
        contentPane.add(status);
        status.setBounds(315, 10, 70, 25);
        contentPane.add(username);
        username.setBounds(60, 45, 285, 25);
        contentPane.add(mch_id);
        mch_id.setBounds(60, 80, 285, 25);
        contentPane.add(out_trade_no);
        out_trade_no.setBounds(60, 115, 285, 25);
        contentPane.add(transaction_id);
        transaction_id.setBounds(60, 150, 285, 25);
        contentPane.add(start_time);
        start_time.setBounds(100, 185, 130, 25);
        contentPane.add(amount);
        amount.setBounds(300, 185, 75, 25);

        contentPane.setPreferredSize(new Dimension(390, 425));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        this.setTitle("订单详情");
        id.setText(String.valueOf(order.getId()) );
        mch_id.setText(String.valueOf(order.getMch_id()) );
        out_trade_no.setText(order.getOut_trade_no());
        transaction_id.setText(order.getTransaction_id());
        start_time.setText(String.valueOf(order.getStart_time()) );
        username.setText(order.getUsername());
        list.setText(order.getList());
        amount.setText(String.valueOf(order.getAmount()) );
        remark.setText(order.getRemark());
        int temp = order.getStatus();
        if (temp == 0)
            status.setText("进行中");
        else if (temp == 1)
            status.setText("已完成");
        else if (temp == -1)
            status.setText("失败");

        // 设置内容不可编辑
        list.setEditable(false);
        remark.setEditable(false);

        // 关闭“订单详情”页面，返回“我的订单”界面
        rt.addActionListener(e -> {
            this.setVisible(false);
        });
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton rt;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JScrollPane scrollPane1;
    private JTextArea list;
    private JLabel label9;
    private JLabel label10;
    private JScrollPane scrollPane2;
    private JTextArea remark;
    private JLabel id;
    private JLabel status;
    private JLabel username;
    private JLabel mch_id;
    private JLabel out_trade_no;
    private JLabel transaction_id;
    private JLabel start_time;
    private JLabel amount;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private Order order;
}

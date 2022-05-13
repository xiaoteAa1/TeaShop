/*
 * Created by JFormDesigner on Thu May 12 23:36:58 CST 2022
 */

package cn.edu.guet.weappdemo.controller;

import cn.edu.guet.weappdemo.controller.business.Business_OrderManageController;
import cn.edu.guet.weappdemo.dao.Business_UpdateDAO;
import cn.edu.guet.weappdemo.dao.impl.Business_UpdateDaoImpl;
import cn.edu.guet.weappdemo.print_receipt.Goods;
import cn.edu.guet.weappdemo.print_receipt.Printer;
import cn.edu.guet.weappdemo.print_receipt.SalesTicket;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * @author 1
 */
public class ReceiptDetails extends JFrame {
    public ReceiptDetails(String [] itemList,Business_OrderManageController boc) {
        this.boc = boc;
        this.itemList = itemList;
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();
        textField5 = new JTextField();
        label8 = new JLabel();
        textField6 = new JTextField();
        label9 = new JLabel();
        textField7 = new JTextField();
        button1 = new JButton();

        //======== this ========
        setTitle("\u5b9e\uff1a");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(list1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(125, 50, 305, 110);

        //---- label1 ----
        label1.setText("\u5546\u54c1\u5217\u8868\uff1a");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 5f));
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(20, 55), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("\u5c0f\u7968\u4fe1\u606f");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 7f));
        contentPane.add(label2);
        label2.setBounds(175, 10, 95, 30);

        //---- label3 ----
        label3.setText("\u8ba2\u5355\u7f16\u53f7\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 5f));
        contentPane.add(label3);
        label3.setBounds(20, 220, 100, 25);

        //---- label4 ----
        label4.setText("\u5546\u54c1\u603b\u6570\uff1a");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 5f));
        contentPane.add(label4);
        label4.setBounds(20, 260, 100, 25);

        //---- label5 ----
        label5.setText("\u603b\u91d1\u989d\uff1a");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 5f));
        contentPane.add(label5);
        label5.setBounds(20, 300, 100, 25);

        //---- label6 ----
        label6.setText("\u5b9e\u6536\u6b3e\uff1a");
        label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 5f));
        contentPane.add(label6);
        label6.setBounds(20, 340, 100, 25);

        //---- label7 ----
        label7.setText("\u627e\u96f6\uff1a");
        label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize() + 5f));
        contentPane.add(label7);
        label7.setBounds(20, 380, 100, 25);
        contentPane.add(textField1);
        textField1.setBounds(125, 218, 175, 30);
        contentPane.add(textField2);
        textField2.setBounds(125, 257, 175, 30);
        contentPane.add(textField3);
        textField3.setBounds(125, 297, 175, 30);
        contentPane.add(textField4);
        textField4.setBounds(125, 337, 175, 30);
        contentPane.add(textField5);
        textField5.setBounds(125, 377, 175, 30);

        //---- label8 ----
        label8.setText("\u5907\u6ce8\uff1a");
        label8.setFont(label8.getFont().deriveFont(label8.getFont().getSize() + 5f));
        contentPane.add(label8);
        label8.setBounds(20, 180, 100, 25);
        contentPane.add(textField6);
        textField6.setBounds(125, 179, 175, 30);

        //---- label9 ----
        label9.setText("\u4e0b\u5355\u65f6\u95f4\uff1a");
        label9.setFont(label9.getFont().deriveFont(label9.getFont().getSize() + 5f));
        contentPane.add(label9);
        label9.setBounds(20, 420, 100, 25);
        contentPane.add(textField7);
        textField7.setBounds(125, 416, 175, 30);

        //---- button1 ----
        button1.setText("\u63d0\u4ea4");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 5f));
        contentPane.add(button1);
        button1.setBounds(175, 460, 103, button1.getPreferredSize().height);

        contentPane.setPreferredSize(new Dimension(455, 510));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        dlm = loadData(itemList);
        list1.setModel(dlm);
        list1.setFont(new Font("宋体",Font.BOLD,15));
        // 添加列表鼠标单击事件
        list1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 获取选中的行
                int index = list1.getSelectedIndex();
                // 获取选中行的数据
                String itemInfo = dlm.getElementAt(index);
                // 输入提示框，用于对jlist修改数据
                String input = JOptionPane.showInputDialog(null,
                        "已选择第" + index + "行商品信息：" + "\n" + "请修改商品信息:", itemInfo);
                if ("".equals(input) || input == null){
                    return;
                } else {
                    if (!"null".equals(input)) {
                        if (!itemInfo.equals(input)) {
                            dlm.add(index + 1, input);
                            dlm.removeElementAt(index);
                        }
                    }
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        // 添加按钮动作事件
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 根据id修改订单状态
                Business_UpdateDAO bu = new Business_UpdateDaoImpl();
                bu.updateStatus(textField1.getText());
                // 打印小票
          /*      List<Goods> goods = new ArrayList<Goods>();
                int size = dlm.getSize();
                for (int i = 0;i < size;i++){
                    String [] str = dlm.getElementAt(i).split("   ");
                    String name = str[0].split(":")[1];
                    String price = str[1].split(":")[1];
                    String amount = str[2].split(":")[1];
                    String s = price.substring(0,price.length() - 1);
                    double a = Double.parseDouble(s);
                    double b = a * Integer.parseInt(amount);
                    int cost = Integer.parseInt(String.valueOf((int)a * 100));
                    int totalCost = Integer.parseInt(String.valueOf((int)b * 100));
                    String remark = textField6.getText();
                    goods.add(new Goods(name,String.valueOf(cost),amount,String.valueOf(totalCost),remark));
                }
                int goodsSize = goods.size();
                String s = Integer.toString(goodsSize);
                Date date = new Date();
                SalesTicket stk = new SalesTicket(goods, textField1.getText(), s, textField3.getText(), textField4.getText(), "0",date);
                Printer p = new Printer(stk);
                p.printer();*/
                dispose();
                boc.setVisible(true);
            }
        });

        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * 初始化jlist数据
     * @param itemList 商品列表信息
     * @return DefaultListModel
     */
    public DefaultListModel<String> loadData (String [] itemList){
        String [] list = itemList[0].split(",");
        DefaultListModel<String> dlm = new DefaultListModel<String>();
        int totalCount = 0;
        for (int i = 0;i < list.length;i++){
            System.out.println("------=");
            String [] tList = list[i].split(";");
            dlm.addElement("商品名称:" + tList[0].split(":")[1] +
                    "   价格:" +tList[1].split(":")[1] + "元" +
                    "   数量:" + tList[2].split(":")[1]);
            totalCount +=  Integer.parseInt(tList[2].split(":")[1]);
        }
        textField1.setText(itemList[1]);
        textField2.setText(String.valueOf(totalCount));
        textField3.setText(itemList[3]);
        textField4.setText(itemList[3]);
        textField5.setText("0");
        textField6.setText(itemList[4]);
        textField7.setText(itemList[2]);
        return dlm;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JList list1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JLabel label8;
    private JTextField textField6;
    private JLabel label9;
    private JTextField textField7;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    // 获取此界面，用于返回
    private Business_OrderManageController boc;
    // 商品订单信息
    private String [] itemList;
    // jlist数据
    private DefaultListModel<String> dlm;
    public static void main(String[] args) {
        new ReceiptDetails(new String []{},new Business_OrderManageController());
    }
}

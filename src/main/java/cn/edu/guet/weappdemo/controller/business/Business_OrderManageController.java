package cn.edu.guet.weappdemo.controller.business;
/*
 * @author  tlj
 * @date  2022/5/10 20:56
 */

import cn.edu.guet.weappdemo.domain.Order;
import cn.edu.guet.weappdemo.service.impl.Business_OrderManageServiceImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Timestamp;

public class Business_OrderManageController extends JFrame {
    public Business_OrderManageController() {

        initComponents();
    }

    private void initComponents() {
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        label1 =new JLabel();
        textField1=new JTextField();

        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        label1.setFont(new Font("宋体",Font.BOLD,30));
        label1.setText("商户后台订单信息");
        contentPane.add(label1);
        label1.setBounds(190,0,600,60);

        button1.setText("查询当前订单");
        contentPane.add(button1);
        button1.setBounds(10,470,130,30);

        button2.setText("查询异常订单");
        contentPane.add(button2);
        button2.setBounds(160,470,120,30);

        button3.setText("查询历史订单");
        contentPane.add(button3);
        button3.setBounds(300,470,120,30);

        button4.setText("修改");
        contentPane.add(button4);
        button4.setBounds(440,470,100,30);

        //button1查询当前订单，也就是order表中status=0的订单信息
        button1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //调用service层中的方法返回数据和列表名称
                Business_OrderManageServiceImpl boms=new Business_OrderManageServiceImpl();
                defaultModel=new DefaultTableModel(boms.getCurrentOrder(),boms.getOrderColumnNames()){
                    public boolean isCellEditable(int row, int column)
                    {
                        return false;
                    }
                };
                table1.setModel(defaultModel);
            }
        });

        //button2,查询异常订单，order表中属性status=-1的订单信息
        button2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Business_OrderManageServiceImpl boms=new Business_OrderManageServiceImpl();
                defaultModel=new DefaultTableModel(boms.getWrongOrder(),boms.getOrderColumnNames()){
                    public boolean isCellEditable(int row, int column)
                    {
                        return false;
                    }
                };
                table1.setModel(defaultModel);
            }
        });

        //button3查询历史订单，order表中属性status=1的订单信息
        button3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Business_OrderManageServiceImpl boms=new Business_OrderManageServiceImpl();
                defaultModel=new DefaultTableModel(boms.getFinishOrder(),boms.getOrderColumnNames()){
                    public boolean isCellEditable(int row, int column)
                    {
                        return false;
                    }
                };
                table1.setModel(defaultModel);
            }
        });

        //button4修改选中的订单信息
        button4.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowNo=table1.getSelectedRow();
                int id= (int) table1.getValueAt(rowNo,0);
                int mch_id= (int) table1.getValueAt(rowNo,1);
                String out_trade_no= (String) table1.getValueAt(rowNo,2);
                String transaction_id= (String) table1.getValueAt(rowNo,3);
                Timestamp start_time= (Timestamp) table1.getValueAt(rowNo,4);
                String username= (String) table1.getValueAt(rowNo,5);
                String list= (String) table1.getValueAt(rowNo,6);
                double amount= (double) table1.getValueAt(rowNo,7);
                int status= (int) table1.getValueAt(rowNo,8);
                String remark= (String) table1.getValueAt(rowNo,9);
                Order order=new Order(id,mch_id,out_trade_no,transaction_id,start_time,username,list,amount,status,remark);
                Business_OrderUpdataController updateController=new Business_OrderUpdataController(order);
                updateController.setVisible(true);

            }
        });

        table1.setBorder(BorderFactory.createLineBorder(Color.black));
        table1.setPreferredScrollableViewportSize(new Dimension(100,80));
        table1.setFillsViewportHeight(true);

        scrollPane1.setViewportView(table1);
        scrollPane1.setBounds(0,61,600,400);
        contentPane.add(scrollPane1);



        contentPane.setPreferredSize(new Dimension(600, 500));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        //禁止改变窗口大小

        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private DefaultTableModel defaultModel;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JTextField textField1;
    private JLabel label1;

    public static void main(String[] args) {

        new Business_OrderManageController();
    }


}

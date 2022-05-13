package cn.edu.guet.weappdemo.controller.user;/*
 * Created by JFormDesigner on Sat Apr 30 16:07:17 CST 2022
 */

import cn.edu.guet.weappdemo.domain.CarTea;
import cn.edu.guet.weappdemo.service.User_AddCarService;
import cn.edu.guet.weappdemo.service.impl.User_AddCarServiceImpl;
import cn.edu.guet.weappdemo.util.SwingUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

/**
 * @author WGJ
 * @date 2022/05/03 12:32
 */
public class User_SelectTea extends JFrame {
    User_AddCarService acs= new User_AddCarServiceImpl();
    public User_SelectTea() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        label1 = new JLabel();
        textField1 = new JTextField();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();

        //======== this ========
        setTitle("购物!");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(new Rectangle(new Point(0, 55), scrollPane1.getPreferredSize()));

        //---- button1 ----
        button1.setText("\u67e5\u770b\u5976\u8336");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(100, 10), button1.getPreferredSize()));

        //---- label1 ----
        label1.setText("\u5df2\u9009\u62e9\uff1a");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(470, 60), label1.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(515, 55, 65, textField1.getPreferredSize().height);

        //---- button2 ----
        button2.setText("\u52a0\u5165\u8d2d\u7269\u8f66");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(475, 360), button2.getPreferredSize()));

        //---- button3 ----
        button3.setText("\u67e5\u770b\u8d2d\u7269\u8f66");
        contentPane.add(button3);
        button3.setBounds(new Rectangle(new Point(475, 420), button3.getPreferredSize()));

        //---- button4 ----
        button4.setText("\u8fd4\u56de");
        contentPane.add(button4);
        button4.setBounds(10, 10, 82, 30);

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
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textField1.setEditable(false);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getTea();
            }
        });

        table1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int index = table1.getSelectedRow();//获取选中的行
                teaId = (int) table1.getValueAt(index,0);
                teaName =table1.getValueAt(index, 1).toString();
                price = (double) table1.getValueAt(index,2);
                textField1.setText(teaName);

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

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTea();
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                getCarTea();
                getPrice();
                new User_SeeCar();
                User_SeeCar.textField1.setText(String.valueOf(carPrice));
                System.out.println(carPrice);
                User_SeeCar.table1.setModel(dtm1);
                User_SeeCar.table1.invalidate();
            }
        });

        //返回上一级
        button4.addActionListener((e)->{
            this.setVisible(false);
            ShopperEnter se = new ShopperEnter();
            se.setVisible(true);
            se.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
    void getTea(){
        dtm.setRowCount(0);
        List<CarTea> list = acs.getTea();
        int len = list.size();
        Object[][] res = new Object[len][4];

        int idx = 0;
        for(CarTea t :list){
            res[0][0] = t.getTeaId();
            res[0][1] = t.getName();
            res[0][2] = t.getPrice();
            res[0][3] = t.getType();
            dtm.addRow(res[idx]);
        }
        table1.setModel(dtm);
        table1.invalidate();

    }
    void addTea(){
        if(table1.getSelectedRow() == -1)return ;//没有选择行
        CarTea carTea=new CarTea();
        carTea.setTeaId(teaId);
        carTea.setName(teaName);
        carTea.setPrice(price);
        if(acs.addTea(carTea)){
            JOptionPane.showMessageDialog(null, "加入成功！");
        }else {
            JOptionPane.showMessageDialog(null, "加入失败！", "错误点击",JOptionPane.WARNING_MESSAGE);
        }

    }
    void getCarTea(){
        dtm1.setRowCount(0);
        List<CarTea> list = acs.getCarTea();
        int len = list.size();
        Object[][] res = new Object[len][4];

        int idx = 0;
        for(CarTea t :list){
            res[0][0] = t.getId();
            res[0][1] = t.getName();
            res[0][2] = t.getCount();
            res[0][3] = t.getPrice();
            dtm1.addRow(res[idx]);
        }

    }
    void getPrice(){
        carPrice = acs.getSumPrice();
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JLabel label1;
    private JTextField textField1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private static DefaultTableModel dtm =  new DefaultTableModel(null, SwingUtils.columns_CarTea);;
    private static DefaultTableModel dtm1 = new DefaultTableModel(null, SwingUtils.columns_CarTea1);;
    String teaName =null;
    double price =0.0;
    double carPrice =0.0;
    int teaId = 0;


    public static void main(String[] args) {
        dtm = new DefaultTableModel(null, SwingUtils.columns_CarTea);
        dtm1 = new DefaultTableModel(null, SwingUtils.columns_CarTea1);
        new User_SelectTea();
    }
}

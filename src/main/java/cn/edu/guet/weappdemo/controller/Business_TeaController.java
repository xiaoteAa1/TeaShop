/*
 * Created by JFormDesigner on Mon Apr 18 19:01:00 CST 2022
 */

package cn.edu.guet.weappdemo.controller;



import cn.edu.guet.weappdemo.domain.Tea;
import cn.edu.guet.weappdemo.service.Business_TeaService;
import cn.edu.guet.weappdemo.service.impl.Business_TeaServiceImpl;
import cn.edu.guet.weappdemo.util.SwingUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 *@author  CCS/YJ
 *@date    2022/04/18 16:08
 */
public class Business_TeaController extends JFrame {
    Business_TeaService bts = new Business_TeaServiceImpl();
    public Business_TeaController() {
        initComponents();
    }

    private void button2KeyPressed(KeyEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        textField1 = new JTextField();
        label1 = new JLabel();
        textField2 = new JTextField();
        label2 = new JLabel();
        label3 = new JLabel();
        button4 = new JButton();
        textField3 = new JTextField();
        button5 = new JButton();

        //======== this ========
        setTitle("\u5546\u5bb6\u7ba1\u7406");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(10, 80, 560, 365);

        //---- button1 ----
        button1.setText("\u52a0\u8f7d\u6240\u6709\u5976\u8336\u4fe1\u606f");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(15, 5), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("\u6839\u636e\u5976\u8336\u7f16\u53f7\u641c\u7d22");
        button2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                button2KeyPressed(e);
            }
        });
        contentPane.add(button2);
        button2.setBounds(240, 10, 115, 20);

        //---- button3 ----
        button3.setText("\u6839\u636e\u5976\u8336\u540d\u5b57\u641c\u7d22");
        contentPane.add(button3);
        button3.setBounds(460, 10, 112, 20);
        contentPane.add(textField1);
        textField1.setBounds(190, 10, 45, 20);

        //---- label1 ----
        label1.setText("ID:");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(165, 10), label1.getPreferredSize()));
        contentPane.add(textField2);
        textField2.setBounds(405, 10, 50, 20);

        //---- label2 ----
        label2.setText("Name:");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(360, 10), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("type:");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(10, 45), label3.getPreferredSize()));

        //---- button4 ----
        button4.setText("\u6839\u636e\u5976\u8336\u7c7b\u578b\u641c\u7d22");
        contentPane.add(button4);
        button4.setBounds(110, 45, 125, 20);
        contentPane.add(textField3);
        textField3.setBounds(45, 45, 60, 20);

        //---- button5 ----
        button5.setText("\u67e5\u770b\u6240\u6709\u5976\u8336\u7684\u5728\u552e\u72b6\u6001");
        contentPane.add(button5);
        button5.setBounds(260, 45, 140, 20);

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

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getAllTea();
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.println(textField1.getText());
                if(textField1.getText() != "")
                    getTeaById(Integer.parseInt(textField1.getText()));
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField2.getText() != "")
                    getTeaByName(textField2.getText());
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField3.getText() != "")
                    getAllTeaByType(textField3.getText());
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getAllTeaOnSale();
            }
        });
    }
    //根据ID搜索：
    void getTeaById(int id){
        dtm = new DefaultTableModel(null, SwingUtils.columnsForShopOwner_Tea);
        dtm.setRowCount(0);
        Tea t = bts.getTeaById(id);
        Object[][] res = new Object[1][8];
        res[0][0] = t.getTeaId();
        res[0][1] = t.getName();
        res[0][2] = t.getPrice();
        res[0][3] = t.getType();
        res[0][4] = t.getIsSale();
        res[0][5] = t.getRemark();
        res[0][6] = t.getCount();
        res[0][7] = t.getSales();
        dtm.addRow(res[0]);
        table1.setModel(dtm);
        table1.invalidate();
    }
    //根据名字搜索：
    void getTeaByName(String name){
        System.out.println(222);
        dtm.setRowCount(0);
        Tea t = bts.getTeaByName(name);
        Object[][] res = new Object[1][8];
        res[0][0] = t.getTeaId();
        res[0][1] = t.getName();
        res[0][2] = t.getPrice();
        res[0][3] = t.getType();
        res[0][4] = t.getIsSale();
        res[0][5] = t.getRemark();
        res[0][6] = t.getCount();
        res[0][7] = t.getSales();

        dtm.addRow(res[0]);
        table1.setModel(dtm);
        table1.invalidate();
    }
    List<Tea> getAllTeaByType(String ByType){
//        System.out.println(ByType);
        dtm.setRowCount(0);
        List<Tea> list = bts.getAllTeaByType(ByType);
//        System.out.println(list.size());
        int len = list.size();
        Object[][] res = new Object[1][8];

        int idx = 0;
        for(Tea t :list){
            res[0][0] = t.getTeaId();
            res[0][1] = t.getName();
            res[0][2] = t.getPrice();
            res[0][3] = t.getType();
            res[0][4] = t.getIsSale();
            res[0][5] = t.getRemark();
            res[0][6] = t.getCount();
            res[0][7] = t.getSales();
            dtm.addRow(res[idx]);
        }
        table1.setModel(dtm);
        table1.invalidate();
        return list;
    };
    List<Tea> getAllTeaOnSale(){
        dtm.setRowCount(0);
        List<Tea> list = bts.getAllTeaOnSale();
        int len = list.size();
        Object[][] res = new Object[len][8];
        int idx = 0;
        for(Tea t :list){
            res[0][0] = t.getTeaId();
            res[0][1] = t.getName();
            res[0][2] = t.getPrice();
            res[0][3] = t.getType();
            res[0][4] = t.getIsSale();
            res[0][5] = t.getRemark();
            res[0][6] = t.getCount();
            res[0][7] = t.getSales();
            dtm.addRow(res[idx]);
        }
        table1.setModel(dtm);
        table1.invalidate();
        return list;
    };

    void getAllTea(){
        dtm.setRowCount(0);
        List<Tea> list = bts.getAllTea();
        int len = list.size();
        Object[][] res = new Object[len][8];

        int idx = 0;
        for(Tea t :list){
            res[0][0] = t.getTeaId();
            res[0][1] = t.getName();
            res[0][2] = t.getPrice();
            res[0][3] = t.getType();
            res[0][4] = t.getIsSale();
            res[0][5] = t.getRemark();
            res[0][6] = t.getCount();
            res[0][7] = t.getSales();
            dtm.addRow(res[idx]);
        }
        table1.setModel(dtm);
        table1.invalidate();

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JTextField textField1;
    private JLabel label1;
    private JTextField textField2;
    private JLabel label2;
    private JLabel label3;
    private JButton button4;
    private JTextField textField3;
    private JButton button5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private static DefaultTableModel dtm;
    public static void main(String[] args) {
        dtm = new DefaultTableModel(null,SwingUtils.columnsForShopOwner_Tea);
        new Business_TeaController();
    }
}

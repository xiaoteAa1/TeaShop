/*
 * Created by JFormDesigner on Mon Apr 18 19:01:00 CST 2022
 */

package cn.edu.guet.weappdemo.controller.business;

import cn.edu.guet.weappdemo.domain.Tea;
import cn.edu.guet.weappdemo.service.Business_TeaService;
import cn.edu.guet.weappdemo.service.impl.Business_TeaServiceImpl;
import cn.edu.guet.weappdemo.util.SwingUtils;

import javax.swing.*;

import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Objects;

/**
 *@author  CCS/YJ
 *@date    2022/04/18 16:08
 */
public class Business_TeaController extends JFrame {
    static Business_TeaService bts = new Business_TeaServiceImpl();

    public Business_TeaController() {
        ini();
        initComponents();
    }

    private void button2KeyPressed(KeyEvent e) {
        // TODO add your code here
    }

    private void ini(){
        dtm = new DefaultTableModel(null,SwingUtils.columnsForShopOwner_Tea);
        dtm.addTableModelListener(e -> {
            int type = e.getType();// 获得事件的类型
            int row = e.getFirstRow() + 1;// 获得触发此次事件的表格行索引
            int column = e.getColumn() + 1;// 获得触发此次事件的表格列索引
            if (type == TableModelEvent.UPDATE) {
                Integer id = (Integer)dtm.getValueAt(row - 1, 0);
                String name = (String)dtm.getValueAt(row - 1, 1);
                Object price = dtm.getValueAt(row - 1, 2);
                String type2 = (String)dtm.getValueAt(row - 1, 3);
                Object issale = dtm.getValueAt(row - 1, 4);
                String remark = (String)dtm.getValueAt(row - 1, 5);
                double realPrice = 0;
                int realIsSale = 0;
                if(price instanceof Double) realPrice = (Double)price;
                else realPrice = Double.valueOf((String)price);
                if(issale instanceof Integer) realIsSale = (Integer)issale;
                else realIsSale = Integer.valueOf((String)issale);
                Tea teaByName = new Tea(id,name,realPrice,type2,realIsSale,remark);
                bts.updateTea(teaByName);
                bts.getAllTea();
            }
        });
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

        label2 = new JLabel();
        label3 = new JLabel();
        button4 = new JButton();
        textField3 = new JTextField();

        textField2 = new JTextField();
        button6 = new JButton();
        button5 = new JButton();
        label4 = new JLabel();
        textField4 = new JTextField();
        button7 = new JButton();
        button8 = new JButton();

        //======== this ========
        setTitle("奶茶管理");

        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);

        scrollPane1.setBounds(10, 110, 560, 335);

        //---- button1 ----
        button1.setText("所有奶茶");
        contentPane.add(button1);
        button1.setBounds(5, 10, 90, 25);

        //---- button2 ----
        button2.setText("查询");

        button2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                button2KeyPressed(e);
            }
        });
        contentPane.add(button2);

        button2.setBounds(210, 15, 90, 20);

        //---- button3 ----
        button3.setText("查询");
        contentPane.add(button3);
        button3.setBounds(435, 15, 100, 20);
        contentPane.add(textField1);
        textField1.setBounds(135, 15, 60, 20);


        //---- label1 ----
        label1.setText("id:");
        contentPane.add(label1);

        label1.setBounds(100, 15, 25, label1.getPreferredSize().height);


        //---- label2 ----
        label2.setText("名称:");
        contentPane.add(label2);

        label2.setBounds(310, 15, 45, label2.getPreferredSize().height);


        //---- label3 ----
        label3.setText("类型:");
        contentPane.add(label3);

        label3.setBounds(new Rectangle(new Point(100, 45), label3.getPreferredSize()));

        //---- button4 ----
        button4.setText("查询");
        contentPane.add(button4);
        button4.setBounds(210, 45, 90, 20);
        contentPane.add(textField3);
        textField3.setBounds(135, 45, 60, 20);
        contentPane.add(textField2);
        textField2.setBounds(360, 15, 60, 20);

        //---- button6 ----
        button6.setText("删除");
        contentPane.add(button6);
        button6.setBounds(435, 45, 100, 20);

        //---- button5 ----
        button5.setText("在售奶茶");
        contentPane.add(button5);
        button5.setBounds(5, 40, 90, 25);

        //---- label4 ----
        label4.setText("id");
        contentPane.add(label4);
        label4.setBounds(310, 45, 45, 17);
        contentPane.add(textField4);
        textField4.setBounds(360, 45, 60, 20);

        //---- button7 ----
        button7.setText("添加奶茶");
        contentPane.add(button7);
        button7.setBounds(5, 75, 530, 25);

        //---- button8 ----
        button8.setText("返回");
        contentPane.add(button8);
        button8.setBounds(5, 445, 85, 25);

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
//        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button1.addActionListener(e -> getAllTea());
        button2.addActionListener(e -> {
            if(!"".equals(textField1.getText())){
                getTeaById(Integer.parseInt(textField1.getText()));
                textField1.setText("");
            }

        });
        button3.addActionListener(e -> {
            if(!"".equals(textField2.getText())){
                getTeaByName(textField2.getText());
                textField2.setText("");
            }
        });
        button4.addActionListener(e -> {
            if(!"".equals(textField3.getText())){
                getAllTeaByType(textField3.getText());
                textField3.setText("");
            }
        });
        button5.addActionListener(e -> getAllTeaOnSale());
        button6.addActionListener(e -> {
            if(!"".equals(textField4.getText())){
                deleteById(Integer.parseInt(textField4.getText()));
                textField4.setText("");
            }
        });
        button7.addActionListener(e -> {
            //TODO 跳转页面
            new Business_AddTeaController();
        });

        button8.addActionListener(e -> {
            //TODO 跳转页面
            this.setVisible(false);
            OwnerEnter on = new OwnerEnter();
            on.setVisible(true);
            on.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
    //

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

    //根据ID删除:
    int deleteById(int deleteId){
        int i = bts.deleteById(deleteId);
        return i;
    }
    //根据名字搜索：
    void getTeaByName(String name){

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

        dtm.setRowCount(0);
        List<Tea> list = bts.getAllTeaByType(ByType);

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

    private JLabel label2;
    private JLabel label3;
    private JButton button4;
    private JTextField textField3;

    private JTextField textField2;
    private JButton button6;
    private JButton button5;
    private JLabel label4;
    private JTextField textField4;
    private JButton button7;
    private JButton button8;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private DefaultTableModel dtm;
    public static void main(String[] args) {
//        dtm = new DefaultTableModel(null,SwingUtils.columnsForShopOwner_Tea);
//        dtm.addTableModelListener(e -> {
//            int type = e.getType();// 获得事件的类型
//            int row = e.getFirstRow() + 1;// 获得触发此次事件的表格行索引
//            int column = e.getColumn() + 1;// 获得触发此次事件的表格列索引
//            if (type == TableModelEvent.UPDATE) {
//                Integer id = (Integer)dtm.getValueAt(row - 1, 0);
//                String name = (String)dtm.getValueAt(row - 1, 1);
//                Object price = dtm.getValueAt(row - 1, 2);
//                String type2 = (String)dtm.getValueAt(row - 1, 3);
//                Object issale = dtm.getValueAt(row - 1, 4);
//                String remark = (String)dtm.getValueAt(row - 1, 5);
//                double realPrice = 0;
//                int realIsSale = 0;
//                if(price instanceof Double) realPrice = (Double)price;
//                else realPrice = Double.valueOf((String)price);
//                if(issale instanceof Integer) realIsSale = (Integer)issale;
//                else realIsSale = Integer.valueOf((String)issale);
//                Tea teaByName = new Tea(id,name,realPrice,type2,realIsSale,remark);
//                bts.updateTea(teaByName);
//                bts.getAllTea();
//            }
//        });
        //最终页面对象的展示：
        new Business_TeaController();



    }
}

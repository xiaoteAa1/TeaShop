/*
 * Created by JFormDesigner on Tue Apr 19 11:46:54 CST 2022
 */

package cn.edu.guet.weappdemo.controller.business;



import cn.edu.guet.weappdemo.domain.Tea;
import cn.edu.guet.weappdemo.service.Business_AddTeaSevice;
import cn.edu.guet.weappdemo.service.impl.Business_AddTeaServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 *@author  ZHH
 *@date    2022/04/30 14:08
 * @version 2.0
 */
public class Business_AddTeaController extends JFrame {
    Business_AddTeaSevice bts = new Business_AddTeaServiceImpl();

    public Business_AddTeaController() {
        initComponents();
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        button1 = new JButton();
        textField1 = new JTextField();
        label1 = new JLabel();
        label2 = new JLabel();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();
        label3 = new JLabel();
        label4 = new JLabel();
        label10 = new JLabel();
        textField10 = new JTextField();
        button2 = new JButton();
        label5 = new JLabel();
        label6 = new JLabel();
        textField5 = new JTextField();
        textField6 = new JTextField();

        //======== this ========
        setTitle("\u6dfb\u52a0\u5976\u8336");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("\u65b0\u589e");
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(25, 435), button1.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(25, 55, 115, textField1.getPreferredSize().height);

        //---- label1 ----
        label1.setText("\u5976\u8336\u540d");
        contentPane.add(label1);
        label1.setBounds(30, 30, 45, 25);

        //---- label2 ----
        label2.setText("\u4ef7\u683c");
        contentPane.add(label2);
        label2.setBounds(30, 90, 45, 25);
        contentPane.add(textField2);
        textField2.setBounds(25, 115, 115, textField2.getPreferredSize().height);
        contentPane.add(textField3);
        textField3.setBounds(25, 180, 115, textField3.getPreferredSize().height);
        contentPane.add(textField4);
        textField4.setBounds(25, 295, 140, 65);

        //---- label3 ----
        label3.setText("\u7c7b\u578b");
        contentPane.add(label3);
        label3.setBounds(30, 155, 45, 25);

        //---- label4 ----
        label4.setText("\u5907\u6ce8");
        contentPane.add(label4);
        label4.setBounds(30, 255, 45, 25);

        //---- label10 ----
        label10.setText("\u662f\u5426\u552e\u5356");
        contentPane.add(label10);
        label10.setBounds(180, 145, 55, 45);
        contentPane.add(textField10);
        textField10.setBounds(180, 180, 50, 30);

        //---- button2 ----
        button2.setText("\u8fd4\u56de\u754c\u9762");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(195, 435), button2.getPreferredSize()));

        //---- label5 ----
        label5.setText("\u5e93\u5b58\u6570\u91cf");
        contentPane.add(label5);
        label5.setBounds(185, 35, 70, label5.getPreferredSize().height);

        //---- label6 ----
        label6.setText("\u9500\u552e\u91cf");
        contentPane.add(label6);
        label6.setBounds(185, 95, 70, 17);
        contentPane.add(textField5);
        textField5.setBounds(180, 55, 115, textField5.getPreferredSize().height);
        contentPane.add(textField6);
        textField6.setBounds(180, 115, 115, textField6.getPreferredSize().height);

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
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    addTea();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        /**
         * 返回到界面
         */
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Business_TeaController();
            }
        });
    }

    /**
     * 添加奶茶操作2.0
     */
    boolean addTea() throws SQLException {

        Tea tea=new Tea();


        /**
         * 将所有数据获取进行判断
         */
        String name = textField1.getText();
        String price=textField2.getText();
        String type=textField3.getText();
        String remark=textField4.getText();
        String count = textField5.getText();
        String sale=textField6.getText();
        String isSale=textField10.getText();
        /**
         * 判断是否填写奶茶名字
         */
        if(name.equals("")){
            JOptionPane.showMessageDialog(null,"奶茶名称未填写！",
                    "提示",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        /**
         * 判断是否填写奶茶价格
         */
        if(price.equals("")){
            JOptionPane.showMessageDialog(null,"奶茶价格未填写！",
                    "提示",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        /**
         * 判断是否填写奶茶品种
         */
        if(type.equals("")){
            textField3.setText("其它奶茶");
        }
        /**
         * 判断是否填写库存量
         */
        if(count.equals("")){
            textField5.setText("0");
        }
        /**
         * 判断是否填写售卖量
         */
        if(count.equals("")){
            textField6.setText("0");
        }
        /**
         * 判断是否填写奶茶销售状态
         */
        if(isSale.equals("")){
            JOptionPane.showMessageDialog(null,"请填写销售状态0或1(0表示不销售，1表示销售)！",
                    "提示",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        /**
         * 判断奶茶销售状态是否正确
         */
        if(!(isSale.equals("1") || isSale.equals("0"))){
            JOptionPane.showMessageDialog(null,"销售状态只能填写0或1(0表示不销售，1表示销售)！",
                    "提示",JOptionPane.WARNING_MESSAGE);
            return false;
        }

        /**
         * 判断是否添加该产品
         */
        int add = JOptionPane.showConfirmDialog(null, "是否确认添加？", "添加奶茶信息",
                JOptionPane.YES_NO_OPTION);
        /**
         * 当add为0时添加奶茶，为1时不添加
         */
        if(add == 1){

            return false;
        }


        /**
         * 将奶茶相关数据放入Single实体类中
         */
        tea.setName(textField1.getText());
        tea.setPrice(Double.parseDouble(textField2.getText()));
        tea.setType(textField3.getText());
        tea.setRemark(textField4.getText());
        tea.setCount(Integer.parseInt(textField5.getText()));
        tea.setSales(Integer.parseInt(textField6.getText()));
        tea.setIsSale(Integer.parseInt(textField10.getText()));



        boolean addTea = bts.addTea(tea);

        /**
         * 对添加操作进行判断
         */
        if(addTea){
            JOptionPane.showMessageDialog(null,"添加成功！",
                    "提示",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"添加失败，请稍后重试！",
                    "提示",JOptionPane.INFORMATION_MESSAGE);
        }
        return addTea;
    }





    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JButton button1;
    private JTextField textField1;
    private JLabel label1;
    private JLabel label2;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JLabel label3;
    private JLabel label4;
    private JLabel label10;
    private JTextField textField10;
    private JButton button2;
    private JLabel label5;
    private JLabel label6;
    private JTextField textField5;
    private JTextField textField6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        new Business_AddTeaController();
    }


}

/*
 * Created by JFormDesigner on Wed May 04 15:37:18 CST 2022
 */

package cn.edu.guet.weappdemo.controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author 1
 */
public class PayCode extends JFrame {

    public PayCode (){
        initComponents();
    }

    public PayCode(PatternOfPayment patternOfPayment,String message,String total_fee) {
        this.message = message;
        this.total_fee = total_fee;
        this.patternOfPayment = patternOfPayment;
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u4ed8\u6b3e\u7801id\uff1a");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 6f));
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(25, 60), label1.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(115, 55, 235, 35);

        //---- button1 ----
        button1.setText("\u7ed3\u7b97");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 5f));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(160, 100), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("\u8fd4\u56de");
        button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 5f));
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(20, 10), button2.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(380, 170));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        // ???????????????id???????????????
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ???????????????id
                String auth_id = textField1.getText();
                try {
                    // ?????????????????????
                    MainPayCode.payCode(auth_id,message,total_fee);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        // ????????????????????????
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                patternOfPayment.setVisible(true);
            }
        });

        this.setTitle("?????????????????????");
        this.setVisible(true);
        this.setResizable(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField textField1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    // ??????????????????
    private PatternOfPayment patternOfPayment;
    // ??????????????????
    private String message;
    // ????????????
    private String total_fee;
    public static void main(String[] args) {
        new PayCode();
    }
}

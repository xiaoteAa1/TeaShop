/*
 * Created by JFormDesigner on Sun May 01 11:31:36 CST 2022
 */

package cn.edu.guet.weappdemo.controller.business;

import cn.edu.guet.weappdemo.controller.Login;
import cn.edu.guet.weappdemo.domain.Tea;
import cn.edu.guet.weappdemo.service.Business_TeaStatisticService;
import cn.edu.guet.weappdemo.service.impl.Business_TeaStatisticServiceImpl;
import cn.edu.guet.weappdemo.util.SwingUtils;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author hjk
 */
public class Business_TeaStatisticController extends JFrame {
    public Business_TeaStatisticController() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();

        //======== this ========
        setTitle("TeaStatistic");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("\u8fd4\u56de");
        contentPane.add(button1);
        button1.setBounds(50, 5, 90, 40);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(40, 55, 600, 360);

        //---- label1 ----
        label1.setText("\u6700\u53d7\u6b22\u8fce\u5976\u8336");
        contentPane.add(label1);
        label1.setBounds(30, 420, 90, 40);

        //---- label2 ----
        label2.setText("best for");
        contentPane.add(label2);
        label2.setBounds(120, 420, 200, 40);

        //---- label3 ----
        label3.setText("\u603b\u76c8\u5229");
        contentPane.add(label3);
        label3.setBounds(345, 425, 90, 40);

        //---- label4 ----
        label4.setText("0");
        contentPane.add(label4);
        label4.setBounds(445, 425, 90,40);

        //---- label5 ----
        label5.setText("\u603b\u9500\u552e\u91cf");
        contentPane.add(label5);
        label5.setBounds(35, 455, 90, 40);

        //---- label6 ----
        label6.setText("0");
        contentPane.add(label6);
        label6.setBounds(120, 455, 90, 40);

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
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



        //1、返回上一级(这里先设置回到到登陆界面，后续再修改)
        button1.addActionListener((e) -> {
            this.setVisible(false);
            OwnerEnter on = new OwnerEnter();
            on.setVisible(true);
            on.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });


    }


//获取统计表
    void getTeaStatistic(){
        dtm = new DefaultTableModel(null, SwingUtils.columnsForStatistic);
        dtm.setRowCount(0);

        List<Tea> list = bts.getAllTea();
        int len = list.size();
        Object[][] res = new Object[len][SwingUtils.columnsForStatistic.length];

        int idx = 0,cnt = 0;
        for(Tea t :list){
            res[idx][0] = ++cnt;
            res[idx][1] = t.getName();
            res[idx][2] = t.getType();
            res[idx][3] = t.getPrice();
            res[idx][4] = t.getCount();
            res[idx][5] = t.getSales();
            res[idx][6] = t.getIsSale();
            dtm.addRow(res[idx]);
        }

        table1.setModel(dtm);
        table1.invalidate();
//从表中获取总的销售量，最受欢迎奶茶和总盈利
        int allSales=0;
        double allEarning=0;
        int maxSale=0;
        for(int i=0;i<len;i++){
            int everySale= (int) table1.getValueAt(i,5);
            allSales=allSales+everySale;
            allEarning=allEarning+((double) everySale)*((double) table1.getValueAt(i,3));
            if(everySale>maxSale){
                maxSale=everySale;
            }
        }
        label4.setText(Double.valueOf(label4.getText())+allEarning+"");
        label6.setText(Double.valueOf(label6.getText())+allSales+"");


        for(int j=0;j<len;j++){
            if(maxSale==(int)table1.getValueAt(j,5)){
                String bestTea= (String) table1.getValueAt(j,1);
                label2.setText(label2.getText()+bestTea+"");
            }
        }



    }



    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private static DefaultTableModel dtm;
    private Business_TeaStatisticService bts = new Business_TeaStatisticServiceImpl();

    public static void main(String[] args) {
        Business_TeaStatisticController btsc= new Business_TeaStatisticController();
        btsc.getTeaStatistic();
    }
}

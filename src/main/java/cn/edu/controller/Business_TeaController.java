/*
 * Created by JFormDesigner on Mon Apr 18 19:01:00 CST 2022
 */

package cn.edu.controller;

import cn.edu.domain.Tea;
import cn.edu.service.Business_TeaService;
import cn.edu.service.impl.Business_TeaServiceImpl;
import cn.edu.util.SwingUtils;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *@author  LXJ
 *@date    2022/04/18 16:08
 */
public class Business_TeaController extends JFrame {
    Business_TeaService bts = new Business_TeaServiceImpl();
    public Business_TeaController() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();

        //======== this ========
        setTitle("\u5546\u5bb6\u7ba1\u7406");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(10, 40, 560, 405);

        //---- button1 ----
        button1.setText("\u52a0\u8f7d\u6240\u6709\u5976\u8336\u4fe1\u606f");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(15, 5), button1.getPreferredSize()));

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
    }

    void getAllTea(){
        dtm = new DefaultTableModel(null,SwingUtils.columns);
        dtm.setRowCount(0);

        List<Tea> list = bts.getAllTea();
        int len = list.size();
        Object[][] res = new Object[len][11];

        int idx = 0;
        for(Tea t :list){
            res[idx][0] = t.getTeaId();
            res[idx][1] = t.getName();
            res[idx][2] = t.getPrice();
            res[idx][3] = t.getType();
            res[idx][4] = t.getRemark();
            res[idx][5] = t.getIsSale();
            res[idx][6] = t.getRemain();
            res[idx][7] = t.getSales();
            res[idx][8] = t.getDaySales();
            res[idx][9] = t.getMonthSales();
            res[idx][10] = t.getYearSales();
            dtm.addRow(res[idx]);
        }
        table1.setModel(dtm);
        table1.invalidate();

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private DefaultTableModel dtm;
    public static void main(String[] args) {
        new Business_TeaController();
    }
}

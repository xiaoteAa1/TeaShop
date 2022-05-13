/*
 * Created by JFormDesigner on Mon May 02 18:34:09 CST 2022
 */

package cn.edu.guet.weappdemo.controller.user;

import cn.edu.guet.weappdemo.domain.Order;
import cn.edu.guet.weappdemo.service.User_OrderService;
import cn.edu.guet.weappdemo.service.impl.User_OrderServiceImpl;
import cn.edu.guet.weappdemo.util.SwingUtils;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 * @author HHS
 */
public class User_OrderController extends JFrame {
    public User_OrderController() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        rt = new JButton();
        comboBox1 = new JComboBox();
        label1 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(10, 25, 570, 345);

        //---- rt ----
        rt.setText("\u8fd4\u56de");
        contentPane.add(rt);
        rt.setBounds(new Rectangle(new Point(515, 380), rt.getPreferredSize()));
        contentPane.add(comboBox1);
        comboBox1.setBounds(400, 380, 104, comboBox1.getPreferredSize().height);

        //---- label1 ----
        label1.setText("\u70b9\u51fb\u5bf9\u5e94\u8ba2\u5355\u5373\u53ef\u67e5\u770b\u8be6\u60c5~");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(420, 5), label1.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(585, 420));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        setTitle("我的订单");

        comboBox1.addItem("所有订单");
        comboBox1.addItem("当前订单");
        comboBox1.addItem("历史订单");
        comboBox1.addItem("异常订单");

        this.setVisible(true);
        this.setResizable(false);// 设置不能调整界面大小
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        allList = uos.getAll();// 获取数据库中所有的订单
        selectAllOrder();// 打开界面默认显示"所有订单"
        getAllOrderId();// 获取所有订单的实际id

        // 返回上一级菜单
        rt.addActionListener(e -> {
            this.setVisible(false);
            ShopperEnter se = new ShopperEnter();
            se.setVisible(true);
            se.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });

        // 选择显示的订单类型，调用selectOrder方法（所有订单-2、当前订单0、历史订单1）
        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == 1)return;// 让该事件监听只执行1次

                String item = comboBox1.getSelectedItem().toString();
                switch (item) {
                    case "所有订单" :
                        selectAllOrder();
                        break;
                    case "当前订单" :
                        selectDqOrder();
                        break;
                    case "历史订单" :
                        selectLsOrder();
                        break;
                    case "异常订单" :
                        selectSbOrder();
                }
            }
        });

        // 点击显示所选中的订单详情
        table1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(e.getValueIsAdjusting())return;// 让该事件只触发一次

                int selectedRow = table1.getSelectedRow();
                if(selectedRow == -1)return;

                // 通过唯一的主键（实际id）来获取订单详情：
                // 声明实际id，并获取当前id（dqId）
                int id = 0, dqId = (int) table1.getValueAt(selectedRow, 0);
                // 判断当前界面显示的订单类型，再通过对应的列表查找实际id：
                String item = comboBox1.getSelectedItem().toString();
                if (item.equals("所有订单"))
                    id = (int) allIdList.get(dqId - 1);
                else if (item.equals("当前订单")) {
                    getDqOrderId();// 获取当前订单的实际id
                    id = (int) dqIdList.get(dqId - 1);
                }
                else if (item.equals("历史订单")) {
                    getLsOrderId();// 获取历史订单的实际id
                    id = (int) lsIdList.get(dqId - 1);
                }
                else if (item.equals("异常订单")) {
                    getSbOrderId();// 获取失败订单的实际id
                    id = (int) sbIdList.get(dqId - 1);
                }

                // 通过获取到的实际id，显示详情在新打开的界面中
                User_OrderDetails uodet = new User_OrderDetails(uos.getOrderById(id));
                uodet.setVisible(true);
                uodet.setResizable(false);

                table1.clearSelection();
            }
        });
    }

    // 获取所有订单的实际id
    void getAllOrderId() {
        for(Order t :allList){
            allIdList.add(t.getId());
        }
    }

    // 获取当前订单的实际id
    void getDqOrderId() {
        for(Order t :allList){
            if (t.getStatus() == 0)
                dqIdList.add(t.getId());
        }
    }

    // 获取历史订单的实际id
    void getLsOrderId() {
        for(Order t :allList){
            if (t.getStatus() == 1)
                lsIdList.add(t.getId());
        }
    }

    // 获取失败订单的实际id
    void getSbOrderId() {
        for(Order t :allList){
            if (t.getStatus() == -1)
                sbIdList.add(t.getId());
        }
    }

    // 显示所有订单信息
    void selectAllOrder() {
        dtm = new DefaultTableModel(null, SwingUtils.columnsForUser_Order);
        dtm.setRowCount(0);

        int len = allList.size();
        if(allList == null || len == 0) {
            return;
        }

        Object[][] res = new Object[len][6];
        int index = 1;
        for(Order t :allList){
            res[0][0] = index++;
            res[0][1] = t.getStart_time();
            res[0][2] = t.getUsername();
            res[0][3] = t.getList();
            res[0][4] = t.getAmount();
            int temp = t.getStatus();
            if (temp == 0)
                res[0][5] = "进行中";
            else if (temp == 1)
                res[0][5] = "已完成";
            else if (temp == -1)
                res[0][5] = "失败";
            dtm.addRow(res[0]);
        }
        table1.setModel(dtm);
        table1.invalidate();
    }

    // 显示当前订单信息
    void selectDqOrder() {
        dtm = new DefaultTableModel(null, SwingUtils.columnsForUser_Order);
        dtm.setRowCount(0);

        int len = allList.size();
        if(allList == null || len == 0) {
            return;
        }

        Object[][] res = new Object[len][6];
        int index = 1;
        for(Order t :allList){
            if (t.getStatus() != 0)
                continue;
            res[0][0] = index++;
            res[0][1] = t.getStart_time();
            res[0][2] = t.getUsername();
            res[0][3] = t.getList();
            res[0][4] = t.getAmount();
            res[0][5] = "进行中";
            dtm.addRow(res[0]);
        }
        table1.setModel(dtm);
        table1.invalidate();
    }

    // 显示历史订单信息
    void selectLsOrder() {
        dtm = new DefaultTableModel(null, SwingUtils.columnsForUser_Order);
        dtm.setRowCount(0);

        int len = allList.size();
        if(allList == null || len == 0) {
            return;
        }

        Object[][] res = new Object[len][6];
        int index = 1;
        for(Order t :allList){
            if (t.getStatus() != 1)
                continue;
            res[0][0] = index++;
            res[0][1] = t.getStart_time();
            res[0][2] = t.getUsername();
            res[0][3] = t.getList();
            res[0][4] = t.getAmount();
            res[0][5] = "已完成";
            dtm.addRow(res[0]);
        }
        table1.setModel(dtm);
        table1.invalidate();
    }

    // 显示历史订单信息
    void selectSbOrder() {
        dtm = new DefaultTableModel(null, SwingUtils.columnsForUser_Order);
        dtm.setRowCount(0);

        int len = allList.size();
        if(allList == null || len == 0) {
            return;
        }

        Object[][] res = new Object[len][6];
        int index = 1;
        for(Order t :allList){
            if (t.getStatus() != -1)
                continue;
            res[0][0] = index++;
            res[0][1] = t.getStart_time();
            res[0][2] = t.getUsername();
            res[0][3] = t.getList();
            res[0][4] = t.getAmount();
            res[0][5] = "失败";
            dtm.addRow(res[0]);
        }
        table1.setModel(dtm);
        table1.invalidate();
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton rt;
    private JComboBox comboBox1;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private static DefaultTableModel dtm;
    private User_OrderService uos = new User_OrderServiceImpl();
    private List<Order> allList = new ArrayList<>();// 储存读取到的所有订单信息
    private List allIdList = new ArrayList();// 储存所有订单的实际id
    private List dqIdList = new ArrayList();// 储存当前订单的实际id
    private List lsIdList = new ArrayList();// 储存历史订单的实际id
    private List sbIdList = new ArrayList();// 储存失败订单的实际id

    // 调试用
//    public static void main(String[] args) {
//        new User_OrderController();
//    }
}

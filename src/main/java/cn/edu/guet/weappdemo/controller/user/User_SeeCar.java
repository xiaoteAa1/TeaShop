/*
 * Created by JFormDesigner on Sun May 01 00:33:25 CST 2022
 */

package cn.edu.guet.weappdemo.controller.user;

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

import static org.apache.commons.lang.StringUtils.isNumeric;

/**
 * @author WGJ
 * @date 2022/05/03 12:32
 */
public class User_SeeCar extends JFrame {
    User_AddCarService acs= new User_AddCarServiceImpl();
    public User_SeeCar() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label1 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        label2 = new JLabel();
        textField1 = new JTextField();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(new Rectangle(new Point(0, 40), scrollPane1.getPreferredSize()));

        //---- label1 ----
        label1.setText("\u5df2\u9009\u5976\u8336\uff1a");
        contentPane.add(label1);
        label1.setBounds(15, 10, 75, label1.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u63d0\u4ea4\u8ba2\u5355");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(480, 390), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("\u53d6\u6d88\u52a0\u8d2d");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(480, 330), button2.getPreferredSize()));

        //---- label2 ----
        label2.setText("\u603b\u4ef7\uff1a");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(465, 45), label2.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(500, 40, 70, textField1.getPreferredSize().height);

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
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        textField1.setEditable(false);

        table1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int index = table1.getSelectedRow();//获取选中的行
                name =table1.getValueAt(index, 1).toString();
                count = (int) table1.getValueAt(index,2);


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
                String Input = JOptionPane.showInputDialog(null,
                        "已选择要删除的奶茶：" + "\n" + name + "\n" + "请输入要删除的个数:", String.valueOf(JOptionPane.PLAIN_MESSAGE),1);


                if (isNumeric(Input)) {
                    deleteCount = Integer.parseInt(Input);
                    System.out.println(deleteCount);
                    if (deleteCount == 0 || deleteCount < 0) {
                        JOptionPane.showMessageDialog(null, "取消数量不能为零", "错误输入", JOptionPane.WARNING_MESSAGE);
                    } else if (deleteCount > count) {
                        JOptionPane.showMessageDialog(null, "取消数量不能小于加购数量！", "错误输入", JOptionPane.WARNING_MESSAGE);
                    } else {
                        deleteTea();
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "输入类型只能为正整数！", "错误输入", JOptionPane.WARNING_MESSAGE);
                }
            }
        });





    }
    void deleteTea(){
        CarTea carTea = new CarTea();
        carTea.setName(name);
        carTea.setCount(deleteCount);
        if(acs.deleteTae(carTea)){
            JOptionPane.showMessageDialog(null, "取消成功！");
            getCarTea();
        }else {
            JOptionPane.showMessageDialog(null, "取消失败！", "错误点击",JOptionPane.WARNING_MESSAGE);
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
        table1.setModel(dtm1);
        table1.invalidate();
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    static JTable table1;
    private JLabel label1;
    private JButton button1;
    private JButton button2;
    private JLabel label2;
    static JTextField textField1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private static DefaultTableModel dtm1=new DefaultTableModel(null, SwingUtils.columns_CarTea1);
    String name =null;
    int deleteCount=0;
    int count=0;



}

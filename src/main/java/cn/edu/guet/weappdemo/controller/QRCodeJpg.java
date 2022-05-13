/*
 * Created by JFormDesigner on Mon May 02 21:17:39 CST 2022
 */

package cn.edu.guet.weappdemo.controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * @author 1
 */
public class QRCodeJpg extends JFrame {
    public QRCodeJpg(PatternOfPayment patternOfPayment) {
        this.patternOfPayment = patternOfPayment;
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        button1 = new JButton();

        //======== this ========
        setBackground(new Color(0, 60, 0));
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setLayout(null);
            panel1.add(label1);
            label1.setBounds(35, 55, 415, 375);

            //---- label2 ----
            label2.setText("\u5fae\u4fe1\u4e8c\u7ef4\u7801\u652f\u4ed8");
            label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 8f));
            panel1.add(label2);
            label2.setBounds(170, -5, 160, 55);

            //---- button1 ----
            button1.setText("\u8fd4\u56de");
            panel1.add(button1);
            button1.setBounds(new Rectangle(new Point(35, 15), button1.getPreferredSize()));

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel1);
        panel1.setBounds(45, 15, 470, 450);

        contentPane.setPreferredSize(new Dimension(595, 520));
        setSize(595, 520);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                patternOfPayment.setVisible(true);
                File f = new File("new.jpg");
                f.delete();

            }
        });
        contentPane.setBackground(new Color(0, 204, 0));
        ImageIcon img = null;
        try {
            img = new ImageIcon(ImageIO.read(new File("new.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        label1.setIcon(img);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private PatternOfPayment patternOfPayment;
}

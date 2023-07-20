import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Properties;


public abstract class Login extends JFrame implements ActionListener {

    public static void main(String[] args) {
        ZhuJieMian();
    }

    //主界面
    public static void ZhuJieMian() {


        //查询，录入的框

        JFrame jFrame = new JFrame("学生管理系统");

        //设置窗口大小
        jFrame.setSize(900, 507);

        //先将布局管理器置为null
        jFrame.setLayout(null);
        jFrame.setVisible(true);
        //添加按钮【查询】
        JButton jbs = new JButton("查询");
        jbs.setForeground(new Color(0x023BF6));
        jbs.setBackground(new Color(0x38FF00));
        jbs.setFont(new Font("黑体", Font.PLAIN, 20));
        jbs.setBorderPainted(false);
        jbs.setBounds(200, 230, 150, 100);
        jFrame.add(jbs);
        jbs.setVisible(true);

        //添加按钮【录入】
        JButton jbw = new JButton("录入");
        jbw.setForeground(new Color(0x0029FF));
        jbw.setBackground(new Color(0xECA871));
        jbw.setFont(new Font("黑体", Font.PLAIN, 20));
        jbw.setBorderPainted(false);
        jbw.setBounds(500, 230, 150, 100);
        jFrame.add(jbw);
        jbw.setVisible(true);
        //添加按钮【确定】
        JButton jbc = new JButton("确定");
        jbc.setForeground(new Color(0x0029FF));
        jbc.setBackground(new Color(0xECA871));
        jbc.setFont(new Font("黑体", Font.PLAIN, 20));
        jbc.setBorderPainted(false);
        jbc.setBounds(400, 330, 100, 50);

        JButton jbcS = new JButton("确定");
        jbcS.setForeground(new Color(0x0029FF));
        jbcS.setBackground(new Color(0xECA871));
        jbcS.setFont(new Font("黑体", Font.PLAIN, 20));
        jbcS.setBorderPainted(false);
        jbcS.setBounds(400, 330, 100, 50);


        //添加标签【序号】
        JLabel textnum = new JLabel("序号:");
        textnum.setForeground(new Color(0xFF0000));
        textnum.setFont(new Font("黑体", Font.PLAIN, 30));
        textnum.setBounds(200, 140, 200, 100);
        //添加输入框【序号输入框】
        JTextField num = new JTextField(20);
        num.setFont(new Font("序号", Font.PLAIN, 18));
        num.setSelectedTextColor(new Color(0xFF0000));
        num.setBounds(330, 170, 280, 40);
        //添加标签【姓名】
        JLabel textname = new JLabel("姓名:");
        textname.setForeground(new Color(0xFF0000));
        textname.setFont(new Font("黑体", Font.PLAIN, 30));
        textname.setBounds(200, 200, 200, 100);
        //添姓名输入框【姓名】
        JTextField name = new JTextField(20);
        name.setFont(new Font("姓名", Font.PLAIN, 18));
        name.setSelectedTextColor(new Color(0xFF0000));
        name.setBounds(330, 230, 280, 40);

        jbs.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame = new JFrame("学生管理系统");

                //设置窗口大小
                jFrame.setSize(900, 507);

                //先将布局管理器置为null
                jFrame.setLayout(null);
                jFrame.setVisible(true);
                jFrame.getContentPane().add(textnum);
                jFrame.getContentPane().add(num);
                jFrame.setVisible(true);
                jFrame.add(jbc);
                jbc.setVisible(true);

                jbc.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String str1 = new String(num.getText());
                        Properties props = new Properties();
                        try {
                            props.load(new FileReader("D:\\JAVAproject\\jiemian\\a.txt"));
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }


                        Object strs = props.get(str1);
                        if (strs == null) {
                            JOptionPane.showMessageDialog(jFrame, "没有这个序号", "提示", JOptionPane.INFORMATION_MESSAGE);
                            num.setText("");

                        }
                        //根据键获取值
                        else {

                            JOptionPane.showMessageDialog(jFrame, "序号"+str1+"\n"+"姓名"+":"+strs, "查询成功", JOptionPane.INFORMATION_MESSAGE);
                            jFrame.setVisible(true);
                            num.setText("");

                        }
                    }
                });


            }
        });

        jbw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame jFrame = new JFrame("学生管理系统");

                //设置窗口大小
                jFrame.setSize(900, 507);

                //先将布局管理器置为null
                jFrame.setLayout(null);
                jFrame.setVisible(true);
                jFrame.add(textnum);
                jFrame.add(num);
                jFrame.add(textname);
                jFrame.add(name);
                jFrame.setVisible(true);
                jFrame.add(jbcS);
                jbcS.setVisible(true);


                jbcS.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String str1 = new String(num.getText());
                        String str2 = new String(name.getText());
                        Properties props = new Properties();
                        try {
                            props.load(new FileReader("D:\\JAVAproject\\jiemian\\a.txt"));
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        Object strs = props.get(str1);
                        if(strs==null){
                            Properties prop = new Properties();
                            prop.put(str1, str2);
                            BufferedWriter bos = null;
                            try {
                                bos = new BufferedWriter(new FileWriter("D:\\JAVAproject\\jiemian\\a.txt",true));
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                            try {
                                prop.store(bos, null);
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                            JOptionPane.showMessageDialog(jFrame, "录入成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
                            num.setText("");
                            name.setText("");

                        }else{
                            JOptionPane.showMessageDialog(jFrame, "序号已存在", "提示", JOptionPane.INFORMATION_MESSAGE);
                            num.setText("");
                            name.setText("");
                        }
                    }
                });



            }
        });
    }
}

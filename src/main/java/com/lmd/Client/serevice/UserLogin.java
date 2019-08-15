package com.lmd.Client.serevice;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserLogin {

    private JPanel UserLogin;
    private JPanel userPanel;
    private JPanel insert;
    private JLabel passwdL;
    private JLabel usernameL;
    private JTextField textField1;
    private JTextField textField2;
    private JPanel btn;
    private JButton registerButton;
    private JButton loginButton;



    public UserLogin() {
        // 注册按钮
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 弹出注册页面
//                new UserReg();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("用户登录");
        frame.setContentPane(new UserLogin().UserLogin);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

}

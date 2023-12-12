package com.java.login;

import com.java.main.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
	private Login login;
	
	private JButton btnLogin, btnRegister, btnFindId, btnFindPw, btnExit;
	private JTextField tfUserId;
	private JPasswordField tfUserPw;
	Color color = new Color(39, 68, 136);
	
	public LoginFrame() {
		setTitle("로그인");
		setSize(360, 185);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		LoginPanel(panel);
		
		add(panel);
		
		setVisible(true);
	}
	
	public void LoginPanel(JPanel panel) {
		panel.setLayout(null);
		panel.setBackground(Color.white);
		
		JLabel labelUserId = new JLabel("아이디");
		labelUserId.setBounds(40, 10, 40, 25);
		labelUserId.setForeground(color);
		panel.add(labelUserId);
		
		tfUserId = new JTextField(20);
		tfUserId.setBounds(90, 10, 200, 25);
		panel.add(tfUserId);
		
		JLabel labelUserPw = new JLabel("비밀번호");
		labelUserPw.setBounds(30, 40, 60, 25);
		panel.add(labelUserPw);
		labelUserPw.setForeground(color);
		tfUserPw = new JPasswordField(20);
		tfUserPw.setBounds(90, 40, 200, 25);
		panel.add(tfUserPw);
		
		btnLogin = new JButton("로그인");
		btnLogin.setBounds(230, 80, 100, 25);
		btnLogin.setBackground(color);
		btnLogin.setForeground(Color.white);
		panel.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserDAO userDao = new UserDAO();
				String name = userDao.login(tfUserId.getText(), tfUserPw.getText());
				if(tfUserId.getText().equals("") || tfUserPw.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "입력하지않은 정보가 있습니다, 확인 후 다시 시도해주세요.", "로그인", JOptionPane.ERROR_MESSAGE);
				} else {
					if(name != null) {
						JOptionPane.showMessageDialog(null, name + "님 환영합니다." );
						MainFrame mainFrame = new MainFrame();
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.", "로그인", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		btnRegister = new JButton("회원 가입");
		btnRegister.setBounds(10, 80, 100, 25);
		btnRegister.setBackground(color);
		btnRegister.setForeground(Color.white);
		panel.add(btnRegister);
		btnRegister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RegisterFrame registerFrame = new RegisterFrame();
			}
		});
		
		btnFindId = new JButton("ID 찾기");
		btnFindId.setBounds(120, 80, 100, 25);
		btnFindId.setBackground(color);
		btnFindId.setForeground(Color.white);
		panel.add(btnFindId);
		btnFindId.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FindIdFrame findIdFrame = new FindIdFrame();
			}
		});
		btnFindPw = new JButton("PW 찾기");
		btnFindPw.setBounds(120, 110, 100, 25);
		btnFindPw.setBackground(color);
		btnFindPw.setForeground(Color.white);
		panel.add(btnFindPw);
		btnFindPw.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FindPwFrame findPwFrame = new FindPwFrame();
			}
		});
		
		btnExit = new JButton("끝내기");
		btnExit.setBounds(230, 110, 100, 25);
		btnExit.setBackground(color);
		btnExit.setForeground(Color.white);
		panel.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
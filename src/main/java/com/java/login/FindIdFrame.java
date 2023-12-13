package com.java.login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindIdFrame extends JFrame {
	private JTextField tfUserName, tfUserBirth;
	
	private JButton btnFind, btnCancel;
	Color color = new Color(39, 68, 136);

	public FindIdFrame() {
		setTitle("아이디 찾기");
		setSize(292, 190);
		setResizable(false);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		FindPanel(panel);
		
		add(panel);
		
		setVisible(true);
	}
	
	public void FindPanel(JPanel panel) {
		panel.setLayout(null);
		panel.setBackground(Color.white);
		
		JLabel labelUserName = new JLabel("이름");
		labelUserName.setBounds(10, 10, 40, 25);
		panel.add(labelUserName);
		
		tfUserName = new JTextField(20);
		tfUserName.setBounds(70, 10, 100, 25);
		panel.add(tfUserName);
		
		JLabel labelUserBirth = new JLabel("생년월일");
		labelUserBirth.setBounds(10, 40, 60, 25);
		panel.add(labelUserBirth);
		
		tfUserBirth = new JTextField(20);
		tfUserBirth.setBounds(70, 40, 180, 25);
		panel.add(tfUserBirth);
		
		btnFind = new JButton("아이디 찾기");
		btnFind.setBounds(50, 80, 180, 25);
		btnFind.setBackground(color);
		btnFind.setForeground(Color.white);
		panel.add(btnFind);
		btnFind.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserDAO UserDao = new UserDAO();
				String id = UserDao.findUserId(tfUserName.getText(), tfUserBirth.getText());
				if(tfUserBirth.getText().equals("") || tfUserName.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "입력하지않은 정보가 있습니다, 확인 후 다시 시도해주세요.", "아이디 찾기", JOptionPane.ERROR_MESSAGE);
				} else {
					if(id != null) {
						JOptionPane.showMessageDialog(null,"ID : " + id);
					} else {
						JOptionPane.showMessageDialog(null, "해당 정보로 가입된 아이디가 존재하지 않습니다.", "아이디 찾기", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		btnCancel = new JButton("취소");
		btnCancel.setBounds(190, 120, 80, 25);
		btnCancel.setBackground(color);
		btnCancel.setForeground(Color.white);
		panel.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
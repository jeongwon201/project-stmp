package com.java.login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindPwFrame extends JFrame {
	private JTextField tfUserId, tfUserPhone;
	private JButton btnFind, btnCancel;
	Color color = new Color(39, 68, 136);

	public FindPwFrame() {
		setTitle("��й�ȣ ã��");
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
		
		JLabel labelUserId = new JLabel("ID");
		labelUserId.setBounds(10, 10, 40, 25);
		panel.add(labelUserId);
		
		tfUserId = new JTextField(20);
		tfUserId.setBounds(70, 10, 100, 25);
		panel.add(tfUserId);
		
		JLabel labelUserPhone = new JLabel("����ó");
		labelUserPhone.setBounds(10, 40, 60, 25);
		panel.add(labelUserPhone);
		
		tfUserPhone = new JTextField(20);
		tfUserPhone.setBounds(70, 40, 180, 25);
		panel.add(tfUserPhone);
		
		btnFind = new JButton("��й�ȣ ã��");
		btnFind.setBounds(50, 80, 180, 25);
		btnFind.setBackground(color);
		btnFind.setForeground(Color.white);
		panel.add(btnFind);
		btnFind.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserDAO UserDao = new UserDAO();
				String pw = UserDao.findUserPw(tfUserId.getText(), tfUserPhone.getText());
				if(tfUserId.getText().equals("") || tfUserPhone.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "�Է��������� ������ �ֽ��ϴ�, Ȯ�� �� �ٽ� �õ����ּ���.", "��й�ȣ ã��", JOptionPane.ERROR_MESSAGE);
				} else {
					if(pw != null) {
						JOptionPane.showMessageDialog(null,"PW : " + pw);
					} else {
						JOptionPane.showMessageDialog(null, "�Է��Ͻ� �������� ��ȸ�� ������ �����ϴ�, Ȯ�� �� �ٽ� �õ����ּ���.", "��й�ȣ ã��", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		btnCancel = new JButton("���");
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
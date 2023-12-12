package com.java.login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterFrame extends JFrame {
	private JTextField tfUserId, tfUserPw, tfUserPw2, tfUserName, tfUserBirth, tfUserEmail, tfUserPhone;
	private JButton btnDuplicateCheck, btnRegister , btnCancel;
	Color color = new Color(39, 68, 136);

	
	public RegisterFrame() {
		setTitle("ȸ������");
		setSize(395, 285);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		RegisterPanel(panel);
		
		add(panel);
		
		setVisible(true);
	}
	
	public void RegisterPanel(JPanel panel) {
		panel.setLayout(null);
		panel.setBackground(Color.white);
		
		JLabel labelUserId = new JLabel("���̵�");
		labelUserId.setBounds(10, 10, 40, 25);
		panel.add(labelUserId);
		
		tfUserId = new JTextField(20);
		tfUserId.setBounds(60, 10, 200, 25);
		panel.add(tfUserId);
		
		btnDuplicateCheck = new JButton("�ߺ� Ȯ��");
		btnDuplicateCheck.setBounds(270, 10, 100, 25);
		btnDuplicateCheck.setBackground(color);
		btnDuplicateCheck.setForeground(Color.white);
		panel.add(btnDuplicateCheck);
		btnDuplicateCheck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserDAO userDao = new UserDAO();
				if(userDao.duplicateCheck(tfUserId.getText())) {
					JOptionPane.showMessageDialog(null, "�̹� �����ϴ� ���̵��Դϴ�.", "�ߺ�", JOptionPane.ERROR_MESSAGE);
					btnRegister.setEnabled(false);
				} else if(tfUserId.getText().equals("")){
					JOptionPane.showMessageDialog(null, "���̵� �Է����ּ���.", "�ߺ�", JOptionPane.ERROR_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "��� ������ ���̵��Դϴ�.");
					tfUserId.setEnabled(false);
					btnDuplicateCheck.setEnabled(false);
					btnRegister.setEnabled(true);
				}
			}
		});
		
		JLabel labelUserPw = new JLabel("��й�ȣ");
		labelUserPw.setBounds(10, 40, 60, 25);
		panel.add(labelUserPw);
		
		tfUserPw = new JTextField(20);
		tfUserPw.setBounds(70, 40, 200, 25);
		panel.add(tfUserPw);
		
		JLabel labelUserName = new JLabel("�̸�");
		labelUserName.setBounds(10, 70, 30, 25);
		panel.add(labelUserName);
		
		tfUserName = new JTextField(20);
		tfUserName.setBounds(45, 70, 100, 25);
		panel.add(tfUserName);
		
		JLabel labelUserBirth = new JLabel("�������");
		labelUserBirth.setBounds(10, 100, 60, 25);
		panel.add(labelUserBirth);
		
		tfUserBirth = new JTextField(20);
		tfUserBirth.setBounds(70, 100, 200, 25);
		panel.add(tfUserBirth);
		
		JLabel labelUserEmail = new JLabel("�̸���");
		labelUserEmail.setBounds(10, 130, 40, 25);
		panel.add(labelUserEmail);
		
		tfUserEmail = new JTextField(20);
		tfUserEmail.setBounds(60, 130, 300, 25);
		panel.add(tfUserEmail);
		
		JLabel labelUserPhone = new JLabel("����ó");
		labelUserPhone.setBounds(10, 160, 50, 25);
		panel.add(labelUserPhone);
		
		tfUserPhone = new JTextField(20);
		tfUserPhone.setBounds(60, 160, 180, 25);
		panel.add(tfUserPhone);
		
		btnCancel = new JButton("���");
		btnCancel.setBounds(160, 210, 100, 25);
		btnCancel.setBackground(color);
		btnCancel.setForeground(Color.white);
		panel.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btnRegister = new JButton("����");
		btnRegister.setBounds(270, 210, 100, 25);
		btnRegister.setBackground(color);
		btnRegister.setForeground(Color.white);
		panel.add(btnRegister);
		btnRegister.setEnabled(false);
		btnRegister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserDTO userDto = new UserDTO();
				UserDAO userDao = new UserDAO();
				
				userDto.setId(tfUserId.getText());
				userDto.setPw(tfUserPw.getText());
				userDto.setName(tfUserName.getText());
				userDto.setBirth(tfUserBirth.getText());
				userDto.setPhone(tfUserPhone.getText());
				userDto.setEmail(tfUserEmail.getText());
				
				if(tfUserPw.getText().equals("") || tfUserName.getText().equals("") || tfUserBirth.equals("")
					      || tfUserPhone.getText().equals("") || tfUserEmail.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "�Է��������� ������ �ֽ��ϴ�, Ȯ�� �� �ٽ� �õ����ּ���.", "����", JOptionPane.ERROR_MESSAGE);
				} else {
					if(userDao.register(userDto)) {
						JOptionPane.showMessageDialog(null, "ȸ�������� �Ϸ�Ǿ����ϴ�.");
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "ȸ������ ����, �ٽ� �õ��� �ּ���.", "����", JOptionPane.ERROR_MESSAGE);
						dispose();
					}
				}
			}
		});
	}
}
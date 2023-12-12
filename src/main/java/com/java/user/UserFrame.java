package com.java.user;

import com.java.login.UserDAO;
import com.java.login.UserDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserFrame extends JFrame {
	Color color = new Color(39, 68, 136);

	private JButton btnModify, btnDelete, btnExit, btnConfirm;
	private JTextField tfId, tfPw, tfName, tfBirth, tfPhone, tfEmail;
	
	public UserFrame() {
		setTitle("�� ����");
		setSize(295, 325);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JPanel panel = new JPanel();
		UserPanel(panel);
		
		add(panel);
		
		setVisible(true);
	}
	
	public void UserPanel(JPanel panel) {
		panel.setLayout(null);
		panel.setBackground(Color.white);
		
		JLabel labelInfo = new JLabel("[����] ���̵�� ��й�ȣ�� �Է����ּ���.");
		labelInfo.setBounds(10, 15, 275, 25);
		panel.add(labelInfo);
		
		JLabel labelId = new JLabel("���̵�");
		labelId.setBounds(10, 50, 40, 25);
		panel.add(labelId);
		
		tfId = new JTextField(20);
		tfId.setBounds(60, 50, 130, 25);
		panel.add(tfId);
		
		JLabel labelPw = new JLabel("��й�ȣ");
		labelPw.setBounds(10, 80, 100, 25);
		panel.add(labelPw);
		
		tfPw = new JTextField(20);
		tfPw.setBounds(70, 80, 130, 25);
		panel.add(tfPw);
		
		btnConfirm = new JButton("Ȯ��");
		btnConfirm.setBounds(210, 80, 60, 25);
		btnConfirm.setBackground(color);
		btnConfirm.setForeground(Color.white);
		panel.add(btnConfirm);
		btnConfirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserDAO userDAO = new UserDAO();
				String name = userDAO.login(tfId.getText(), tfPw.getText());
				if(name != null) {
					JOptionPane.showMessageDialog(null, "Ȯ���� �Ϸ�Ǿ����ϴ�." );
					UserDTO userDTO = userDAO.confirmUser(tfId.getText());
					btnConfirm.setEnabled(false);
					tfId.setEnabled(false); tfId.setText(userDTO.getId());
					tfPw.setEnabled(true); tfPw.setText(userDTO.getPw());
					tfName.setEnabled(true); tfName.setText(userDTO.getName());
					tfBirth.setEnabled(true); tfBirth.setText(userDTO.getBirth());
					tfPhone.setEnabled(true); tfPhone.setText(userDTO.getPhone());
					tfEmail.setEnabled(true); tfEmail.setText(userDTO.getEmail());
					btnModify.setEnabled(true);
					btnDelete.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "������ ��ġ���� �ʽ��ϴ�.", "�α��� ����", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JLabel labelName = new JLabel("�̸�");
		labelName.setBounds(10, 110, 50, 25);
		panel.add(labelName);
		
		tfName = new JTextField(20);
		tfName.setBounds(70, 110, 100, 25);
		tfName.setEnabled(false);
		panel.add(tfName);
		
		JLabel labelBirth = new JLabel("�������");
		labelBirth.setBounds(10, 140, 70, 25);
		panel.add(labelBirth);
		
		tfBirth = new JTextField(20);
		tfBirth.setBounds(75, 140, 100, 25);
		tfBirth.setEnabled(false);
		panel.add(tfBirth);
		
		JLabel labelBirthEx = new JLabel("ex) YYYYMMDD");
		labelBirthEx.setBounds(180, 140, 100, 25);
		panel.add(labelBirthEx);
		
		JLabel labelPhone = new JLabel("����ó");
		labelPhone.setBounds(10, 170, 60, 25);
		panel.add(labelPhone);
		
		tfPhone = new JTextField(20);
		tfPhone.setBounds(65, 170, 120, 25);
		tfPhone.setEnabled(false);
		panel.add(tfPhone);
		
		JLabel labelEmail = new JLabel("�̸���");
		labelEmail.setBounds(10, 200, 60, 25);
		panel.add(labelEmail);
		
		tfEmail = new JTextField(20);
		tfEmail.setBounds(65, 200, 170, 25);
		tfEmail.setEnabled(false);
		panel.add(tfEmail);
		
		btnDelete = new JButton("Ż��");
		btnDelete.setBounds(10, 250, 80, 30);
		btnDelete.setBackground(color);
		btnDelete.setForeground(Color.white);
		btnDelete.setEnabled(false);
		panel.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserDAO userDAO = new UserDAO();
				int result = JOptionPane.showConfirmDialog(null, "Ż���Ͻðڽ��ϱ�?", "Ż��", JOptionPane.OK_CANCEL_OPTION);
				if(result == 0) {
					if(userDAO.deleteUser(tfId.getText())) {
						JOptionPane.showMessageDialog(null, "Ż�� �Ϸ�Ǿ����ϴ�. �ٽ� �������ּ���.");
						System.exit(0);
					} else {
						JOptionPane.showMessageDialog(null, "Ż�� ����, �ٽ� �õ��� �ּ���.", "Ż��", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "��ҵǾ����ϴ�.");
				}
			}
		});
		
		btnModify = new JButton("����");
		btnModify.setBounds(100, 250, 80, 30);
		btnModify.setBackground(color);
		btnModify.setForeground(Color.white);
		btnModify.setEnabled(false);
		panel.add(btnModify);
		btnModify.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserDAO userDAO = new UserDAO();
				UserDTO userDTO = new UserDTO();
				userDTO.setId(tfId.getText());
				userDTO.setPw(tfPw.getText());
				userDTO.setName(tfName.getText());
				userDTO.setBirth(tfBirth.getText());
				userDTO.setPhone(tfPhone.getText());
				userDTO.setEmail(tfEmail.getText());
				
				if (tfName.getText().equals("") || tfBirth.getText().equals("") || tfPhone.getText().equals("") || tfEmail.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "�Է��������� ������ �ֽ��ϴ�, Ȯ�� ��  �ٽ� �õ��� �ּ���.", "����", JOptionPane.ERROR_MESSAGE);
				} else {
					int result = JOptionPane.showConfirmDialog(null, "�����Ͻðڽ��ϱ�?", "����", JOptionPane.OK_CANCEL_OPTION);
					if(result == 0) {
						if(userDAO.modifyUser(userDTO)) {
							JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�.");
							dispose();
						} else {
							JOptionPane.showMessageDialog(null, "���� ����, �ٽ� �õ��� �ּ���.", "����", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "��ҵǾ����ϴ�.");
					}
				}
			}
		});
		
		btnExit = new JButton("������");
		btnExit.setBounds(190, 250, 80, 30);
		btnExit.setBackground(color);
		btnExit.setForeground(Color.white);
		panel.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}

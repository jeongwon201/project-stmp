package com.java.pm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PDelFrame extends JFrame {
	private JTextField tfBackNum;
	
	private JButton btnDel;
	private JButton btnCancel;
	
	Color color = new Color(39, 68, 136);
	
	public PDelFrame() {
		setTitle("���� ����");
		setSize(305, 212);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JPanel panel = new JPanel();
		PAddPanel(panel);
		
		add(panel);
		
		setVisible(true);
	}
	
	public void PAddPanel(JPanel panel) {
		panel.setLayout(null);
		panel.setBackground(Color.white);
		
		JLabel label_logo = new JLabel(new ImageIcon("Images/everton_logo_small.png"));
		label_logo.setBounds(5, 5, 50, 50);
		panel.add(label_logo);
		
		JLabel labelPanelName = new JLabel("�� �� �� ��");
		labelPanelName.setFont(new Font("���� ���", Font.BOLD, 30));
		labelPanelName.setForeground(color);
		labelPanelName.setBounds(65, 0, 790, 50);
		panel.add(labelPanelName);
		
		JLabel labelExplain = new JLabel("������ ������ �� ��ȣ�� �Է��ϼ���.");
		labelExplain.setBounds(10, 65, 280, 25);
		panel.add(labelExplain);
		
		JLabel labelName = new JLabel("�� ��ȣ");
		labelName.setBounds(10, 95, 50, 25);
		panel.add(labelName);
		
		tfBackNum = new JTextField(20);
		tfBackNum.setBounds(70, 95, 50, 25);
		panel.add(tfBackNum);
		
		btnDel = new JButton("���� ����");
		btnDel.setBounds(70, 135, 100, 30);
		btnDel.setBackground(color);
		btnDel.setForeground(Color.white);
		panel.add(btnDel);
		btnDel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PlayerDAO playerDAO = new PlayerDAO();
				if(tfBackNum.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "�� ��ȣ �Է����ּ���.", "���� ����", JOptionPane.ERROR_MESSAGE);
				} else {
					int result = JOptionPane.showConfirmDialog(null, "�����Ͻðڽ��ϱ�?", "���� ����", JOptionPane.OK_CANCEL_OPTION);
					if(result == 0) {
						if(playerDAO.duplicateCheck(Integer.parseInt(tfBackNum.getText()))) {
							if(playerDAO.deletePlayer(Integer.parseInt(tfBackNum.getText()))) {
								JOptionPane.showMessageDialog(null, "�����Ǿ����ϴ�.");
								dispose();
							} else {
								JOptionPane.showMessageDialog(null, "���� ����, �ٽ� �õ��� �ּ���.", "���� ����", JOptionPane.ERROR_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null, "�ش� �� ��ȣ�� ������ �������� �ʽ��ϴ�.", "���� ����", JOptionPane.ERROR_MESSAGE);
							tfBackNum.setText("");
						}
					} else {
						tfBackNum.setText("");
					}
				}
			}
		});
		
		btnCancel = new JButton("���");
		btnCancel.setBounds(180, 135, 100, 30);
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

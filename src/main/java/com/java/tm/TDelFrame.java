package com.java.tm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TDelFrame extends JFrame {
	TacticsDAO tacticsDAO = new TacticsDAO();
	
	private JButton btnDel, btnExit;
	private JComboBox<String> cbTactics;
	
	Color color = new Color(39, 68, 136);
	
	public TDelFrame() {
		setTitle("���� ����");
		setSize(370, 135);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		tDelPanel(panel);
		
		add(panel);

		setVisible(true);
	}
	
	public void tDelPanel(JPanel panel) {
		panel.setLayout(null);
		panel.setBackground(Color.white);
		
		cbTactics = new JComboBox<String>(tacticsDAO.getTacticsName("del").toArray(new String[tacticsDAO.getTacticsName("del").size()]));
		cbTactics.setBounds(30, 25, 300, 25);
		cbTactics.setBackground(Color.white);
		panel.add(cbTactics);
		
		btnDel = new JButton("����");
		btnDel.setBounds(195, 65, 70, 25);
		btnDel.setBackground(color);
		btnDel.setForeground(Color.white);
		panel.add(btnDel);
		btnDel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(cbTactics.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "������ ������ �������ּ���.", "����", JOptionPane.ERROR_MESSAGE);
				} else {
					int result = JOptionPane.showConfirmDialog(null, "�����Ͻðڽ��ϱ�?", "����", JOptionPane.OK_CANCEL_OPTION);
					if(result == 0) {
						if(tacticsDAO.delTactics(cbTactics.getSelectedItem().toString())) {
							JOptionPane.showMessageDialog(null, "�����Ǿ����ϴ�.");
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
		
		btnExit = new JButton("���");
		btnExit.setBounds(275, 65, 70, 25);
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

package com.java.pm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class PModFrame extends JFrame {
	private JTextField tfModBackNum, tfBackNum, tfName, tfBirth, tfNationality, tfHeight, tfWeight, tfComment;
	private ButtonGroup rdoGroup;
	private JRadioButton FW, MF, DF, GK;
	private JButton btnConfirm, btnMod, btnCancel;
	private String selectedRdoPos;
	Color color = new Color(39, 68, 136);
	
	public PModFrame() {
		setTitle("���� ����");
		setSize(310, 490);
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
		
		JLabel labelModExplain = new JLabel("������ ������ �� ��ȣ�� �Է��ϼ���.");
		labelModExplain.setBounds(10, 65, 280, 25);
		panel.add(labelModExplain);
		
		JLabel labelModName = new JLabel("�� ��ȣ");
		labelModName.setBounds(10, 95, 50, 25);
		panel.add(labelModName);
		
		tfModBackNum = new JTextField(20);
		tfModBackNum.setBounds(70, 95, 50, 25);
		panel.add(tfModBackNum);
		
		btnConfirm = new JButton("Ȯ��");
		btnConfirm.setBounds(135, 95, 60, 25);
		btnConfirm.setBackground(color);
		btnConfirm.setForeground(Color.white);
		panel.add(btnConfirm);
		btnConfirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PlayerDAO playerDAO = new PlayerDAO();
				if(playerDAO.duplicateCheck(Integer.parseInt(tfModBackNum.getText()))) {
					PlayerDTO playerDTO = playerDAO.confirmPlayer(Integer.parseInt(tfModBackNum.getText()));
					JOptionPane.showMessageDialog(null, "Ȯ�εǾ����ϴ�.");
					tfBackNum.setText(Integer.toString(playerDTO.getBackNum()));
					tfName.setText(playerDTO.getName());
					tfBirth.setText(playerDTO.getBirth());
					tfNationality.setText(playerDTO.getNationality());
					tfHeight.setText(Integer.toString(playerDTO.getHeight()));
					tfWeight.setText(Integer.toString(playerDTO.getWeight()));
					tfComment.setText(playerDTO.getComment());
					
					btnMod.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "�ش� �� ��ȣ�� ������ �����ϴ�. �ٽ� �õ��� �ּ���.", "����", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JLabel labelLine = new JLabel(new ImageIcon("Images/line.png"));
		labelLine.setBounds(10, 125, 275, 25);
		panel.add(labelLine);
		
		JLabel labelBackNum = new JLabel("�� ��ȣ");
		labelBackNum.setBounds(10, 155, 50, 25);
		panel.add(labelBackNum);
		
		tfBackNum = new JTextField(20);
		tfBackNum.setBounds(70, 155, 50, 25);
		tfBackNum.setEnabled(false);
		panel.add(tfBackNum);
		
		JLabel labelPos = new JLabel("��ȣ ������");
		labelPos.setBounds(10, 185, 70, 25);
		panel.add(labelPos);
		
		JRadioButton FW = new JRadioButton("FW"); FW.setSelected(true);
		FW.setBounds(80, 185, 50, 25);
		JRadioButton MF = new JRadioButton("MF");
		MF.setBounds(130, 185, 50, 25);
		JRadioButton DF = new JRadioButton("DF");
		DF.setBounds(180, 185, 50, 25);
		JRadioButton GK = new JRadioButton("GK");
		GK.setBounds(230, 185, 50, 25);
		rdoGroup = new ButtonGroup();
		rdoGroup.add(FW); rdoGroup.add(MF); rdoGroup.add(DF); rdoGroup.add(GK);
		panel.add(FW); panel.add(MF); panel.add(DF); panel.add(GK);
		
		JLabel labelName = new JLabel("�̸�");
		labelName.setBounds(10, 215, 30, 25);
		panel.add(labelName);
		
		tfName = new JTextField(20);
		tfName.setBounds(50, 215, 180, 25);
		panel.add(tfName);
		
		JLabel labelBirth = new JLabel("�������");
		labelBirth.setBounds(10, 245, 60, 25);
		panel.add(labelBirth);
		
		tfBirth = new JTextField(20);
		tfBirth.setBounds(80, 245, 100, 25);
		panel.add(tfBirth);
		
		JLabel labelBirthEx = new JLabel("EX) YYYYMMDD");
		labelBirthEx.setBounds(190, 245, 100, 25);
		panel.add(labelBirthEx);
		
		JLabel labelNationality = new JLabel("����");
		labelNationality.setBounds(10, 275, 30, 25);
		panel.add(labelNationality);
		
		tfNationality = new JTextField(20);
		tfNationality.setBounds(50, 275, 100, 25);
		panel.add(tfNationality);
		
		JLabel labelHeight = new JLabel("Ű");
		labelHeight.setBounds(10, 305, 20, 25);
		panel.add(labelHeight);
		
		tfHeight = new JTextField(20);
		tfHeight.setBounds(40, 305, 60, 25);
		panel.add(tfHeight);
		
		JLabel labelWeight = new JLabel("������");
		labelWeight.setBounds(10, 335, 50, 25);
		panel.add(labelWeight);
		
		tfWeight = new JTextField(20);
		tfWeight.setBounds(70, 335, 60, 25);
		panel.add(tfWeight);
		
		JLabel labelComment = new JLabel("�ڸ�Ʈ");
		labelComment.setBounds(10, 365, 50, 25);
		panel.add(labelComment);
		
		tfComment = new JTextField(100);
		tfComment.setBounds(10, 365, 275, 25);
		panel.add(tfComment);
		
		btnMod = new JButton("���� ����");
		btnMod.setBounds(70, 410, 100, 30);
		btnMod.setBackground(color);
		btnMod.setForeground(Color.white);
		btnMod.setEnabled(false);
		panel.add(btnMod);
		btnMod.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PlayerDAO playerDAO = new PlayerDAO();
				PlayerDTO playerDTO = new PlayerDTO();
				playerDTO.setBackNum(Integer.parseInt(tfBackNum.getText()));
				getSelectedRdoPos();
				playerDTO.setPos(selectedRdoPos);
				playerDTO.setName(tfName.getText());
				playerDTO.setBirth(tfBirth.getText());
				playerDTO.setNationality(tfNationality.getText());
				playerDTO.setHeight(Integer.parseInt(tfHeight.getText()));
				playerDTO.setWeight(Integer.parseInt(tfWeight.getText()));
				playerDTO.setComment(tfComment.getText());
				
				if(tfName.getText().equals("") || tfBirth.getText().equals("") || tfNationality.getText().equals("")
						|| tfHeight.getText().equals("") || tfWeight.equals("") || tfComment.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "�Է��������� ������ �ֽ��ϴ�, Ȯ�� �� �ٽ� �õ����ּ���.", "����", JOptionPane.ERROR_MESSAGE);
				} else {
					if(playerDAO.updatePlayer(playerDTO)) {
						JOptionPane.showMessageDialog(null, "���� ������ �Ϸ�Ǿ����ϴ�.");
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "���� ���� ����, �ٽ� �õ��� �ּ���.", "����", JOptionPane.ERROR_MESSAGE);
						dispose();
					}
				}
			}
		});
		
		btnCancel = new JButton("���");
		btnCancel.setBounds(180, 410, 100, 30);
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
	public void getSelectedRdoPos() {
		Enumeration<AbstractButton> enums = rdoGroup.getElements();
		while(enums.hasMoreElements()) {
			AbstractButton ab = enums.nextElement();
			JRadioButton jb = (JRadioButton)ab;
			if(jb.isSelected()) {
				selectedRdoPos = jb.getText();
			}
		}
	}
}

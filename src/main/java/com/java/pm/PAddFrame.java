package com.java.pm;

import com.java.utils.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class PAddFrame extends JFrame {
	private JTextField tfBackNum, tfName, tfBirth, tfNationality, tfHeight, tfWeight, tfComment;
	private ButtonGroup rdoGroup;
	private JRadioButton FW, MF, DF, GK;
	private JButton btnDuplicateCheck, btnAdd, btnCancel;
	private String selectedRdoPos;
	Color color = new Color(39, 68, 136);
	
	public PAddFrame() {
		setTitle("선수 추가");
		setSize(310, 422);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JPanel panel = new JPanel();
		PAddPanel(panel);
		
		add(panel);
		
		setVisible(true);
	}
	
	public void PAddPanel(JPanel panel) {
		ImageLoader imageLoader = new ImageLoader();

		panel.setLayout(null);
		panel.setBackground(Color.white);
		
		JLabel label_logo = new JLabel(new ImageIcon(imageLoader.getImage("images/everton_logo_small.png")));
		label_logo.setBounds(5, 5, 50, 50);
		panel.add(label_logo);
		
		JLabel labelPanelName = new JLabel("선 수 추 가");
		labelPanelName.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		labelPanelName.setForeground(color);
		labelPanelName.setBounds(65, 0, 790, 50);
		panel.add(labelPanelName);
		
		JLabel labelBackNum = new JLabel("등 번호");
		labelBackNum.setBounds(10, 65, 50, 25);
		panel.add(labelBackNum);
		
		tfBackNum = new JTextField(20);
		tfBackNum.setBounds(70, 65, 50, 25);
		panel.add(tfBackNum);
		
		btnDuplicateCheck = new JButton("중복 확인");
		btnDuplicateCheck.setBounds(140, 65, 90, 25);
		btnDuplicateCheck.setBackground(color);
		btnDuplicateCheck.setForeground(Color.white);
		panel.add(btnDuplicateCheck);
		btnDuplicateCheck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PlayerDAO playerDAO = new PlayerDAO();
				if(playerDAO.duplicateCheck(Integer.parseInt(tfBackNum.getText()))) {
					JOptionPane.showMessageDialog(null, "사용중인 등 번호입니다.", "중복", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "사용 가능한 등 번호입니다.");
					tfBackNum.setEnabled(false);
					btnDuplicateCheck.setEnabled(false);
					btnAdd.setEnabled(true);
				}
			}
		});
		
		JLabel labelPos = new JLabel("선호 포지션");
		labelPos.setBounds(10, 95, 70, 25);
		panel.add(labelPos);
		
		JRadioButton FW = new JRadioButton("FW"); FW.setSelected(true);
		FW.setBounds(80, 95, 50, 25);
		JRadioButton MF = new JRadioButton("MF");
		MF.setBounds(130, 95, 50, 25);
		JRadioButton DF = new JRadioButton("DF");
		DF.setBounds(180, 95, 50, 25);
		JRadioButton GK = new JRadioButton("GK");
		GK.setBounds(230, 95, 50, 25);
		rdoGroup = new ButtonGroup();
		rdoGroup.add(FW); rdoGroup.add(MF); rdoGroup.add(DF); rdoGroup.add(GK);
		panel.add(FW); panel.add(MF); panel.add(DF); panel.add(GK);
		
		JLabel labelName = new JLabel("이름");
		labelName.setBounds(10, 125, 30, 25);
		panel.add(labelName);
		
		tfName = new JTextField(20);
		tfName.setBounds(50, 125, 180, 25);
		panel.add(tfName);
		
		JLabel labelBirth = new JLabel("생년월일");
		labelBirth.setBounds(10, 155, 60, 25);
		panel.add(labelBirth);
		
		tfBirth = new JTextField(20);
		tfBirth.setBounds(80, 155, 100, 25);
		panel.add(tfBirth);
		
		JLabel labelBirthEx = new JLabel("EX) YYYYMMDD");
		labelBirthEx.setBounds(190, 155, 100, 25);
		panel.add(labelBirthEx);
		
		JLabel labelNationality = new JLabel("국적");
		labelNationality.setBounds(10, 185, 30, 25);
		panel.add(labelNationality);
		
		tfNationality = new JTextField(20);
		tfNationality.setBounds(50, 185, 100, 25);
		panel.add(tfNationality);
		
		JLabel labelHeight = new JLabel("키");
		labelHeight.setBounds(10, 215, 20, 25);
		panel.add(labelHeight);
		
		tfHeight = new JTextField(20);
		tfHeight.setBounds(40, 215, 60, 25);
		panel.add(tfHeight);
		
		JLabel labelWeight = new JLabel("몸무게");
		labelWeight.setBounds(10, 245, 50, 25);
		panel.add(labelWeight);
		
		tfWeight = new JTextField(20);
		tfWeight.setBounds(70, 245, 60, 25);
		panel.add(tfWeight);
		
		JLabel labelComment = new JLabel("코멘트");
		labelComment.setBounds(10, 275, 50, 25);
		panel.add(labelComment);
		
		tfComment = new JTextField();
		tfComment.setBounds(10, 300, 275, 25);
		panel.add(tfComment);
		
		btnAdd = new JButton("선수 추가");
		btnAdd.setBounds(70, 345, 100, 30);
		btnAdd.setBackground(color);
		btnAdd.setForeground(Color.white);
		btnAdd.setEnabled(false);
		panel.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
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
					JOptionPane.showMessageDialog(null, "입력하지않은 정보가 있습니다, 확인 후 다시 시도해주세요.", "실패", JOptionPane.ERROR_MESSAGE);
				} else {
					if(playerDAO.addPlayer(playerDTO)) {
						JOptionPane.showMessageDialog(null, "선수 추가가 완료되었습니다.");
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "선수 추가 실패, 다시 시도해 주세요.", "실패", JOptionPane.ERROR_MESSAGE);
						dispose();
					}
				}
			}
		});
		
		btnCancel = new JButton("취소");
		btnCancel.setBounds(180, 345, 100, 30);
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
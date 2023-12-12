package com.java.main;

import com.java.login.LoginFrame;
import com.java.pm.PMFrame;
import com.java.tm.TMFrame;
import com.java.user.UserFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
	private JButton btnTM;
	private JButton btnPM;
	private JButton btnUser;
	private JButton btnExit;
	private JTextArea taManagerInfo;
	private JTextArea taPOTS;
	
	private String strManagerInfo = "이름 | Carlo Ancelotti\n"
            					  + "출생 | 1959/06/10, 이탈리아\n"
            					  + "신체 | 179cm, 74kg\n"
            					  + "경력 | 99.02~01.06 유벤투스\n"
            				+ "         | 01.11~09.05 AC 밀란\n"
            				+ "         | 09.07~11.05 첼시\n"
            			    + "         | 11.12~13.06 파리 생제르맹\n"
            			    + "         | 13.06~15.05 레알 마드리드\n"
            			    + "         | 16.07~17.09 바이에른 뮌헨\n"
            			    + "         | 18.07~19.12 SSC 나폴리\n"
            			    + "         | 19.12~            에버턴FC";
	private String strPOTS = "2006 | Mikel Arteta\n"
		   	   			   + "2007 | Mikel Artete\n"
		   	   			   + "2008 | Jolen Lescott\n"
		   	   			   + "2009 | Phil Jagielka\n"
		   	   			   + "2010 | Steven Pienaar\n"
		   	   			   + "2011 | Leighton Baines\n"
		   	   			   + "2012 | John Heitinga\n"
		   	   			   + "2013 | Leighton Baines\n"
		   	   			   + "2014 | Seamus Coleman\n"
		   	   			   + "2015 | Phil Jagielka\n"
		   	   			   + "2016 | Gareth Barry\n"
		   	   			   + "2017 | Romelu Lukaku\n"
		   	   			   + "2018 | Jordan Pickford\n"
		   	   			   + "2019 | Locas Digne";
	
	Color color = new Color(39, 68, 136);
	
	public MainFrame() {
		setTitle("Soccer Tactical Management Program");
		setSize(410, 805);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		mainPanel(panel);
		
		add(panel);

		setVisible(true);
	}
	public void mainPanel(JPanel panel) {
		panel.setLayout(null);
		panel.setBackground(Color.white);
		
		ImageIcon iconEvertonLogo = new ImageIcon("Images/everton_logo.png");
		JLabel label_logo = new JLabel(iconEvertonLogo);
		label_logo.setBounds(68, 30, 250, 250);
		panel.add(label_logo);
		
		JLabel labelManagerInfo = new JLabel("FootBall Manager");
		labelManagerInfo.setBounds(20, 290, 200, 25);
		labelManagerInfo.setForeground(color);
		panel.add(labelManagerInfo);
		
		ImageIcon iconManagerPic = new ImageIcon("Images/Carlo_Ancelotti.jpg");
		JLabel labelManagerPic = new JLabel(iconManagerPic);
		labelManagerPic.setBounds(20, 315, 130, 145);
		panel.add(labelManagerPic);
		
		taManagerInfo = new JTextArea(strManagerInfo);
		taManagerInfo.setBounds(20, 465, 200, 200);
		taManagerInfo.setForeground(color);
		taManagerInfo.setEditable(false);
		panel.add(taManagerInfo);
		
		JLabel labelIntro_POTS = new JLabel("Player of the Season");
		labelIntro_POTS.setBounds(220, 290, 160, 25);
		labelIntro_POTS.setForeground(color);
		panel.add(labelIntro_POTS);
		
		taPOTS = new JTextArea(strPOTS);
		taPOTS.setBounds(220, 315, 160, 325);
		taPOTS.setForeground(color);
		taPOTS.setEditable(false);
		panel.add(taPOTS);
		
		btnTM = new JButton("전술 관리");
		btnTM.setBounds(10, 690, 120, 30);
		btnTM.setBackground(color);
		btnTM.setForeground(Color.white);
		panel.add(btnTM);
		btnTM.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TMFrame tmFrame = new TMFrame();
			}
		});
		
		btnPM = new JButton("선수 관리");
		btnPM.setBounds(138, 690, 120, 30);
		btnPM.setBackground(color);
		btnPM.setForeground(Color.white);
		panel.add(btnPM);
		btnPM.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PMFrame pmFrame = new PMFrame();
			}
		});
		
		btnUser = new JButton("내 정보");
		btnUser.setBounds(265, 690, 120, 30);
		btnUser.setBackground(color);
		btnUser.setForeground(Color.white);
		panel.add(btnUser);
		btnUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserFrame userFrame = new UserFrame();
			}
		});
		
		btnExit = new JButton("끝내기");
		btnExit.setBounds(10, 730, 375, 30);
		btnExit.setBackground(color);
		btnExit.setForeground(Color.white);
		panel.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginFrame loginFrame = new LoginFrame();
				dispose();
			}
		});
	}
}
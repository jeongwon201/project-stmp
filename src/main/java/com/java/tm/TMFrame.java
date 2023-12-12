package com.java.tm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TMFrame extends JFrame {
	TacticsDAO tacticsDAO = new TacticsDAO();
	TacticsDTO tacticsDTO = new TacticsDTO();
	
	private JButton btnLoadTactics, btnDupCheck, btnAddTactics, btnModTactics, btnDelTactics, btnReset, btnExit;
	private JTextField tfTacticsName, tfT_TacticsComment;
	private JComboBox<String> cbTactics;
	
	private JLabel[] labelPos1 = new JLabel[11];
	private JLabel[] labelPos2 = new JLabel[11];
	private JComboBox[] cbPlayer = new JComboBox[11];
	private JTextField[] tfP_TacticsComment = new JTextField[11];
	
	private JLabel[] playerIcon = new JLabel[11];
	private JComboBox cbFormation;
	private String strFormation[] = {"532", "541", "4231", "433", "4321", "442", "4411", "451", "343", "352"};
	private int IconLoc532[][] = {{120,90},{230,90},{100,270},{175,270},{250,270},{60,430},{105,450},{175,450},{245,450},{290,430},{175,505}};
	private String strPos532[] = {"LS", "RS", "LCM", "CM", "RCM", "LB", "LCB", "CB", "RCB", "RB", "GK"};
	private int IconLoc541[][] = {{175,90},{60,240},{125, 270},{225, 270},{290, 240},{60, 430},{105, 450},{175, 450},{245, 450},{290, 430},{175, 505}};
	private String strPos541[] = {"ST", "LM", "LCM", "RCM", "RM", "LB", "LCB", "CB", "RCB", "RB", "GK"};
	private int IconLoc4231[][] = {{175, 90},{60, 180},{175, 180},{290, 180},{125, 360},{225, 360},{60, 430},{125, 450},{225, 450},{290, 430},{175, 505}};
	private String strPos4231[] = {"ST", "LAM", "CAM", "RAM", "LDM", "RDM", "LB", "LCB", "RCB", "RB", "GK"};
	private int IconLoc433[][] = {{60, 90},{175, 90},{290, 90},{100, 270},{175, 270},{250, 270},{60, 430},{125, 450},{225, 450},{290, 430},{175, 505}};
	private String strPos433[] = {"LW", "ST", "RW", "LCM", "CM", "RCM", "LB", "LCB", "RCB", "RB", "GK"};
	private int IconLoc4321[][] = {{175, 90},{125, 180},{225, 180},{60, 270},{175, 270},{290, 270},{60, 430},{125, 450},{225, 450},{290, 430},{175, 505}};
	private String strPos4321[] = {"ST", "LAM", "RAM", "LCM", "CM", "RCM", "LB", "LCB", "RCB", "RB", "GK"};
	private int IconLoc442[][] = {{120, 90},{230, 90},{60, 240},{125, 270},{225, 270},{290, 240},{60, 430},{125, 450},{225, 450},{290, 430},{175, 505}};
	private String strPos442[] = {"LS", "RS", "LM", "LCM", "RCM", "RM", "LB", "LCB", "RCB", "RB", "GK"};
	private int IconLoc4411[][] = {{175, 70},{175, 130},{60, 240},{125, 270},{225, 270},{290, 240},{60, 430},{125, 450},{225, 450},{290, 430},{175, 505}};
	private String strPos4411[] = {"ST", "CF", "LM", "LCM", "RCM", "RM", "LB", "LCB", "RCB", "RB", "GK"};
	private int IconLoc451[][] = {{175, 90},{60, 180},{125, 270},{175, 360},{225, 270},{290, 180},{60, 430},{125, 450},{225, 450},{290, 430},{175, 505}};
	private String strPos451[] = {"ST", "LM", "LCM", "CDM", "RCM", "RM", "LB", "LCB", "RCB", "RB", "GK"};
	private int IconLoc343[][] = {{60, 90},{175, 90},{290, 90},{60, 270},{125, 270},{225, 270},{290, 270},{105, 450},{175, 450},{245, 450},{175, 505}};
	private String strPos343[] = {"LW", "ST", "RW", "LM", "LCM", "RCM", "RM", "LCB", "CB", "RCB", "GK"};
	private int IconLoc352[][] = {{120, 90},{230, 90},{60, 240},{125, 270},{175, 320},{225, 270},{290, 240},{105, 450},{175, 450},{245, 450},{175, 505}};
	private String strPos352[] = {"LS", "RS", "LM", "LCM", "CDM", "RCM", "RM", "LCB", "CB", "RCB", "GK"};
	
	Color color = new Color(39, 68, 136);
	public TMFrame() {
		setTitle("전술 관리");
		setSize(1005, 632);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		tmPanel(panel);
		
		add(panel);

		setVisible(true);
	}
	
	public void tmPanel(JPanel panel) {
		panel.setLayout(null);
		panel.setBackground(Color.white);
		
		JLabel label_logo = new JLabel(new ImageIcon("Images/everton_logo_small.png"));
		label_logo.setBounds(5, 5, 50, 50);
		panel.add(label_logo);
		
		JLabel labelPanelName = new JLabel("전 술 관 리");
		labelPanelName.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		labelPanelName.setForeground(color);
		labelPanelName.setBounds(65, 0, 200, 50);
		panel.add(labelPanelName);
		
		cbTactics = new JComboBox<String>(tacticsDAO.getTacticsName("load").toArray(new String[tacticsDAO.getTacticsName("load").size()]));
		cbTactics.setBounds(245, 15, 200, 25);
		cbTactics.setBackground(Color.white);
		
		panel.add(cbTactics);
		
		
		btnLoadTactics = new JButton("전술 불러오기");
		btnLoadTactics.setBounds(455, 15, 140, 25);
		btnLoadTactics.setBackground(color);
		btnLoadTactics.setForeground(Color.white);
		panel.add(btnLoadTactics);
		btnLoadTactics.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tacticsDTO = tacticsDAO.loadTactics(cbTactics.getSelectedItem().toString());
				if(tacticsDTO != null) {
					tfTacticsName.setEnabled(false); btnDupCheck.setEnabled(false); btnModTactics.setEnabled(true);
					tfTacticsName.setText(tacticsDTO.getName());
					cbFormation.setSelectedItem(tacticsDTO.getFormation());
					cbPlayer[0].setSelectedItem(tacticsDTO.getP1()); tfP_TacticsComment[0].setText(tacticsDTO.getP1_t());
					cbPlayer[1].setSelectedItem(tacticsDTO.getP2()); tfP_TacticsComment[1].setText(tacticsDTO.getP2_t());
					cbPlayer[2].setSelectedItem(tacticsDTO.getP3()); tfP_TacticsComment[2].setText(tacticsDTO.getP3_t());
					cbPlayer[3].setSelectedItem(tacticsDTO.getP4()); tfP_TacticsComment[3].setText(tacticsDTO.getP4_t());
					cbPlayer[4].setSelectedItem(tacticsDTO.getP5()); tfP_TacticsComment[4].setText(tacticsDTO.getP5_t());
					cbPlayer[5].setSelectedItem(tacticsDTO.getP6()); tfP_TacticsComment[5].setText(tacticsDTO.getP6_t());
					cbPlayer[6].setSelectedItem(tacticsDTO.getP7()); tfP_TacticsComment[6].setText(tacticsDTO.getP7_t());
					cbPlayer[7].setSelectedItem(tacticsDTO.getP8()); tfP_TacticsComment[7].setText(tacticsDTO.getP8_t());
					cbPlayer[8].setSelectedItem(tacticsDTO.getP9()); tfP_TacticsComment[8].setText(tacticsDTO.getP9_t());
					cbPlayer[9].setSelectedItem(tacticsDTO.getP10()); tfP_TacticsComment[9].setText(tacticsDTO.getP10_t());
					cbPlayer[10].setSelectedItem(tacticsDTO.getP11()); tfP_TacticsComment[10].setText(tacticsDTO.getP11_t());
					tfT_TacticsComment.setText(tacticsDTO.getComment());
				}
			}
		});
		
		JLabel labelContour = new JLabel();
		labelContour.setBounds(0, 60, 1000, 5);
		labelContour.setOpaque(true);
		labelContour.setBackground(color);
		panel.add(labelContour);
		
		JLabel labelTacticsName = new JLabel("전술 이름");
		labelTacticsName.setBounds(20, 80, 60, 25);
		panel.add(labelTacticsName);
		
		tfTacticsName = new JTextField();
		tfTacticsName.setBounds(90, 80, 160, 25);
		panel.add(tfTacticsName);
		
		btnDupCheck = new JButton("중복");
		btnDupCheck.setBounds(255, 80, 60, 25);
		btnDupCheck.setBackground(color);
		btnDupCheck.setForeground(Color.white);
		panel.add(btnDupCheck);
		btnDupCheck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tacticsDAO.duplicateCheck(tfTacticsName.getText())) {
					JOptionPane.showMessageDialog(null, "사용 중인 이름입니다. 다시 시도해 주세요.", "실패", JOptionPane.ERROR_MESSAGE);
					btnAddTactics.setEnabled(false);
					btnModTactics.setEnabled(false);
				} else {
					JOptionPane.showMessageDialog(null, "사용 가능한 이름입니다.");
					tfTacticsName.setEnabled(false);
					btnDupCheck.setEnabled(false);
					btnAddTactics.setEnabled(true);
					btnModTactics.setEnabled(false);
				}
			}
		});
		
		JLabel labelFormation = new JLabel("포메이션");
		labelFormation.setBounds(20, 110, 60, 25);
		panel.add(labelFormation);
		
		cbFormation = new JComboBox<String>(strFormation);
		cbFormation.setBounds(90, 110, 100, 25);
		cbFormation.setBackground(Color.white);
		panel.add(cbFormation);
		int y=170;
		for(int i=0; i<11; i++) {
			playerIcon[i] = new JLabel(new ImageIcon("Images/uniform.png"));
			playerIcon[i].setOpaque(false);
			playerIcon[i].setBounds(IconLoc532[i][0]+305, IconLoc532[i][1]+35, 40, 50);
			labelPos1[i] = new JLabel(strPos532[i]);
			labelPos1[i].setBounds(10, y, 30, 25);
			labelPos2[i] = new JLabel(strPos532[i]);
			labelPos2[i].setBounds(685, y-55, 30, 25);
			cbPlayer[i] = new JComboBox<String>(tacticsDAO.getPlayerName().toArray(new String[tacticsDAO.getPlayerName().size()]));
			cbPlayer[i].setBounds(50, y, 255, 25);
			cbPlayer[i].setBackground(Color.white);
			tfP_TacticsComment[i] = new JTextField();
			tfP_TacticsComment[i].setBounds(725, y-55, 255, 25);
			panel.add(playerIcon[i]);
			panel.add(labelPos1[i]);
			panel.add(labelPos2[i]);
			panel.add(cbPlayer[i]);
			panel.add(tfP_TacticsComment[i]);
			y = y + 30;
		}
		cbFormation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox jcb =(JComboBox)e.getSource();
                String selectedItem = jcb.getSelectedItem().toString();
                
				switch (selectedItem) {
					case "532":
						for(int i=0; i<11; i++) {
							playerIcon[i].setBounds(IconLoc532[i][0]+305, IconLoc532[i][1]+35, 40, 50);
							labelPos1[i].setText(strPos532[i]);
							labelPos2[i].setText(strPos532[i]);
						} break;
					case "541":
						for(int i=0; i<11; i++) {
							playerIcon[i].setBounds(IconLoc541[i][0]+305, IconLoc541[i][1]+35, 40, 50);
							labelPos1[i].setText(strPos541[i]);
							labelPos2[i].setText(strPos541[i]);
						} break;
					case "4231":
						for(int i=0; i<11; i++) {
							playerIcon[i].setBounds(IconLoc4231[i][0]+305, IconLoc4231[i][1]+35, 40, 50);
							labelPos1[i].setText(strPos4231[i]);
							labelPos2[i].setText(strPos4231[i]);
						} break;
					case "433":
						for(int i=0; i<11; i++) {
							playerIcon[i].setBounds(IconLoc433[i][0]+305, IconLoc433[i][1]+35, 40, 50);
							labelPos1[i].setText(strPos433[i]);
							labelPos2[i].setText(strPos433[i]);
						} break;
					case "4321":
						for(int i=0; i<11; i++) {
							playerIcon[i].setBounds(IconLoc4321[i][0]+305, IconLoc4321[i][1]+35, 40, 50);
							labelPos1[i].setText(strPos4321[i]);
							labelPos2[i].setText(strPos4321[i]);
						} break;
					case "442":
						for(int i=0; i<11; i++) {
							playerIcon[i].setBounds(IconLoc442[i][0]+305, IconLoc442[i][1]+35, 40, 50);
							labelPos1[i].setText(strPos442[i]);
							labelPos2[i].setText(strPos442[i]);
						} break;
					case "4411":
						for(int i=0; i<11; i++) {
							playerIcon[i].setBounds(IconLoc4411[i][0]+305, IconLoc4411[i][1]+35, 40, 50);
							labelPos1[i].setText(strPos4411[i]);
							labelPos2[i].setText(strPos4411[i]);
						} break;
					case "451":
						for(int i=0; i<11; i++) {
							playerIcon[i].setBounds(IconLoc451[i][0]+305, IconLoc451[i][1]+35, 40, 50);
							labelPos1[i].setText(strPos451[i]);
							labelPos2[i].setText(strPos451[i]);
						} break;
					case "343":
						for(int i=0; i<11; i++) {
							playerIcon[i].setBounds(IconLoc343[i][0]+305, IconLoc343[i][1]+35, 40, 50);
							labelPos1[i].setText(strPos343[i]);
							labelPos2[i].setText(strPos343[i]);
						} break;
					case "352":
						for(int i=0; i<11; i++) {
							playerIcon[i].setBounds(IconLoc352[i][0]+305, IconLoc352[i][1]+35, 40, 50);
							labelPos1[i].setText(strPos352[i]);
							labelPos2[i].setText(strPos352[i]);
						} break;
					default: break;
				}
			}
		});
		
		JLabel labelContourTeam1 = new JLabel();
		labelContourTeam1.setBounds(0, 150, 325, 5);
		labelContourTeam1.setOpaque(true);
		labelContourTeam1.setBackground(color);
		panel.add(labelContourTeam1);
		
		JLabel labelContourTeam2 = new JLabel();
		labelContourTeam2.setBounds(0, 510, 325, 5);
		labelContourTeam2.setOpaque(true);
		labelContourTeam2.setBackground(color);
		panel.add(labelContourTeam2);
		
		JLabel labelCommnet = new JLabel("팀 전술 코멘트");
		labelCommnet.setBounds(20, 525, 100, 25);
		panel.add(labelCommnet);
		
		tfT_TacticsComment = new JTextField();
		tfT_TacticsComment.setBounds(20, 550, 285, 25);
		panel.add(tfT_TacticsComment);
		
		JLabel labelGroundImg = new JLabel(new ImageIcon("Images/ground.jpg"));
		labelGroundImg.setBounds(325, 60, 350, 540);
		panel.add(labelGroundImg);
		
		JLabel labelP_Tactics = new JLabel("개인전술");
		labelP_Tactics.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		labelP_Tactics.setForeground(color);
		labelP_Tactics.setBounds(695, 75, 300, 30);
		panel.add(labelP_Tactics);
		
		JLabel labelContourPlayer1 = new JLabel();
		labelContourPlayer1.setBounds(675, 455, 325, 5);
		labelContourPlayer1.setOpaque(true);
		labelContourPlayer1.setBackground(color);
		panel.add(labelContourPlayer1);
		
		btnAddTactics = new JButton("전술 추가");
		btnAddTactics.setBounds(690, 475, 140, 30);
		btnAddTactics.setBackground(color);
		btnAddTactics.setForeground(Color.white);
		btnAddTactics.setEnabled(false);
		panel.add(btnAddTactics);
		btnAddTactics.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tacticsDTO.setName(tfTacticsName.getText());
				tacticsDTO.setFormation(cbFormation.getSelectedItem().toString());
				tacticsDTO.setP1(cbPlayer[0].getSelectedItem().toString()); tacticsDTO.setP1_t(tfP_TacticsComment[0].getText());
				tacticsDTO.setP2(cbPlayer[1].getSelectedItem().toString()); tacticsDTO.setP2_t(tfP_TacticsComment[1].getText());
				tacticsDTO.setP3(cbPlayer[2].getSelectedItem().toString()); tacticsDTO.setP3_t(tfP_TacticsComment[2].getText());
				tacticsDTO.setP4(cbPlayer[3].getSelectedItem().toString()); tacticsDTO.setP4_t(tfP_TacticsComment[3].getText());
				tacticsDTO.setP5(cbPlayer[4].getSelectedItem().toString()); tacticsDTO.setP5_t(tfP_TacticsComment[4].getText());
				tacticsDTO.setP6(cbPlayer[5].getSelectedItem().toString()); tacticsDTO.setP6_t(tfP_TacticsComment[5].getText());
				tacticsDTO.setP7(cbPlayer[6].getSelectedItem().toString()); tacticsDTO.setP7_t(tfP_TacticsComment[6].getText());
				tacticsDTO.setP8(cbPlayer[7].getSelectedItem().toString()); tacticsDTO.setP8_t(tfP_TacticsComment[7].getText());
				tacticsDTO.setP9(cbPlayer[8].getSelectedItem().toString()); tacticsDTO.setP9_t(tfP_TacticsComment[8].getText());
				tacticsDTO.setP10(cbPlayer[9].getSelectedItem().toString()); tacticsDTO.setP10_t(tfP_TacticsComment[9].getText());
				tacticsDTO.setP11(cbPlayer[10].getSelectedItem().toString()); tacticsDTO.setP11_t(tfP_TacticsComment[10].getText());
				tacticsDTO.setComment(tfT_TacticsComment.getText());
				
				int result1=0, result2=0;
				for(int i=0; i<cbPlayer.length; i++) {
					if(cbPlayer[i].getSelectedIndex() == 0) {
						result1++;
					}
				}
				for(int i=0; i<11; i++) {
					for(int j=0; j<11; j++) {
						if(cbPlayer[i].getSelectedItem().toString().equals(cbPlayer[j].getSelectedItem().toString())) {
							result2 ++;
						}
					}
				}
				if(result1 == 0 && result2 == 11) {
					if(tacticsDAO.addTactics(tacticsDTO)) {
						JOptionPane.showMessageDialog(null, "전술 추가가 완료되었습니다.");
						cbTactics = new JComboBox<String>(tacticsDAO.getTacticsName("load").toArray(new String[tacticsDAO.getTacticsName("load").size()]));
					} else {
						JOptionPane.showMessageDialog(null, "전술 추가 중 오류가 발생하였습니다. 확인 후 다시 시도해 주세요.", "실패", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "선수를 추가하지 않은 포지션이 있거나, 중복된 선수가 있습니다. 확인 후 다시 시도해 주세요.", "실패", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		btnModTactics = new JButton("전술 수정");
		btnModTactics.setBounds(840, 475, 140, 30);
		btnModTactics.setBackground(color);
		btnModTactics.setForeground(Color.white);
		btnModTactics.setEnabled(false);
		panel.add(btnModTactics);
		btnModTactics.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tacticsDTO.setName(tfTacticsName.getText());
				tacticsDTO.setFormation(cbFormation.getSelectedItem().toString());
				tacticsDTO.setP1(cbPlayer[0].getSelectedItem().toString()); tacticsDTO.setP1_t(tfP_TacticsComment[0].getText());
				tacticsDTO.setP2(cbPlayer[1].getSelectedItem().toString()); tacticsDTO.setP2_t(tfP_TacticsComment[1].getText());
				tacticsDTO.setP3(cbPlayer[2].getSelectedItem().toString()); tacticsDTO.setP3_t(tfP_TacticsComment[2].getText());
				tacticsDTO.setP4(cbPlayer[3].getSelectedItem().toString()); tacticsDTO.setP4_t(tfP_TacticsComment[3].getText());
				tacticsDTO.setP5(cbPlayer[4].getSelectedItem().toString()); tacticsDTO.setP5_t(tfP_TacticsComment[4].getText());
				tacticsDTO.setP6(cbPlayer[5].getSelectedItem().toString()); tacticsDTO.setP6_t(tfP_TacticsComment[5].getText());
				tacticsDTO.setP7(cbPlayer[6].getSelectedItem().toString()); tacticsDTO.setP7_t(tfP_TacticsComment[6].getText());
				tacticsDTO.setP8(cbPlayer[7].getSelectedItem().toString()); tacticsDTO.setP8_t(tfP_TacticsComment[7].getText());
				tacticsDTO.setP9(cbPlayer[8].getSelectedItem().toString()); tacticsDTO.setP9_t(tfP_TacticsComment[8].getText());
				tacticsDTO.setP10(cbPlayer[9].getSelectedItem().toString()); tacticsDTO.setP10_t(tfP_TacticsComment[9].getText());
				tacticsDTO.setP11(cbPlayer[10].getSelectedItem().toString()); tacticsDTO.setP11_t(tfP_TacticsComment[10].getText());
				tacticsDTO.setComment(tfT_TacticsComment.getText());

				int result1=0, result2=0;
				for(int i=0; i<cbPlayer.length; i++) {
					if(cbPlayer[i].getSelectedIndex() == 0) {
						result1++;
					}
				}
				for(int i=0; i<11; i++) {
					for(int j=0; j<11; j++) {
						if(cbPlayer[i].getSelectedItem().toString().equals(cbPlayer[j].getSelectedItem().toString())) {
							result2 ++;
						}
					}
				}
				if(result1 == 0 && result2 == 11) {
					if(tacticsDAO.updateTactics(tacticsDTO)) {
						JOptionPane.showMessageDialog(null, "전술 수정이 완료되었습니다.");
					} else {
						JOptionPane.showMessageDialog(null, "전술 수정 중 오류가 발생하였습니다. 확인 후 다시 시도해 주세요.", "실패", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "선수를 추가하지 않은 포지션이 있거나, 중복된 선수가 있습니다. 확인 후 다시 시도해 주세요.", "실패", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		btnDelTactics = new JButton("전술 삭제");
		btnDelTactics.setBounds(690, 515, 140, 30);
		btnDelTactics.setBackground(color);
		btnDelTactics.setForeground(Color.white);
		panel.add(btnDelTactics);
		btnDelTactics.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TDelFrame tDelFrame = new TDelFrame();
			}
		});
		
		btnReset = new JButton("전술판 초기화");
		btnReset.setBounds(840, 515, 140, 30);
		btnReset.setBackground(color);
		btnReset.setForeground(Color.white);
		panel.add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cbTactics.setSelectedIndex(0);
				tfTacticsName.setEnabled(true);
				tfTacticsName.setText("");
				cbFormation.setSelectedIndex(0);
				for(int i=0; i<cbPlayer.length; i++) {
					cbPlayer[i].setSelectedIndex(0);
					tfP_TacticsComment[i].setText("");
				}
				tfT_TacticsComment.setText("");
				btnDupCheck.setEnabled(true);
				btnAddTactics.setEnabled(false);
				btnModTactics.setEnabled(false);
				JOptionPane.showMessageDialog(null, "초기화 되었습니다.");
			}
		});
		
		btnExit = new JButton("나가기");
		btnExit.setBounds(840, 555, 140, 30);
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
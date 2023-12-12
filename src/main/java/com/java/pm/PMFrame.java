package com.java.pm;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class PMFrame extends JFrame {
	private JButton btnPlayerAdd, btnPlayerDel, btnPlayerMod, btnRefresh, btnExit;
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scrollPane;
	private Vector data, cols;
	Color color = new Color(39, 68, 136);
	
	public PMFrame() {
		setTitle("선수 관리");
		setSize(810, 505);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JPanel panel = new JPanel();
		PMPanel(panel);
		
		add(panel);
		
		setVisible(true);
	}
	
	public void PMPanel(JPanel panel) {
		panel.setLayout(null);
		panel.setBackground(Color.white);
		
		JLabel label_logo = new JLabel(new ImageIcon("Images/everton_logo_small.png"));
		label_logo.setBounds(5, 5, 50, 50);
		panel.add(label_logo);
		
		JLabel labelPanelName = new JLabel("선 수 관 리");
		labelPanelName.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		labelPanelName.setForeground(color);
		labelPanelName.setBounds(65, 0, 790, 50);
		panel.add(labelPanelName);
		
		btnPlayerAdd = new JButton("선수 추가");
		btnPlayerAdd.setBounds(10, 65, 150, 30);
		btnPlayerAdd.setBackground(color);
		btnPlayerAdd.setForeground(Color.white);
		panel.add(btnPlayerAdd);
		btnPlayerAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PAddFrame pAddFrame = new PAddFrame();
			}
		});
		
		btnPlayerMod = new JButton("선수 수정");
		btnPlayerMod.setBounds(170, 65, 150, 30);
		btnPlayerMod.setBackground(color);
		btnPlayerMod.setForeground(Color.white);
		panel.add(btnPlayerMod);
		btnPlayerMod.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PModFrame pModFrame = new PModFrame();
			}
		});
		
		btnPlayerDel = new JButton("선수 삭제");
		btnPlayerDel.setBounds(330, 65, 150, 30);
		btnPlayerDel.setBackground(color);
		btnPlayerDel.setForeground(Color.white);
		panel.add(btnPlayerDel);
		btnPlayerDel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PDelFrame pDelFrame = new PDelFrame();
			}
		});
		
		btnRefresh = new JButton(new ImageIcon("Images/refresh.png"));
		btnRefresh.setBounds(490, 65, 30, 30);
		panel.add(btnRefresh);
		btnRefresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PlayerDAO playerDAO = new PlayerDAO();
				data = playerDAO.getPlayer();
				model = new DefaultTableModel(data, getColumn()) {
					public boolean isCellEditable(int row, int col) {
		                return false;
		            }
		        };
				table.setModel(model);
				jTableSet();
			}
		});
		
		PlayerDAO playerDAO = new PlayerDAO();
		data = playerDAO.getPlayer();
		cols = getColumn();
		
		model = new DefaultTableModel(data, cols)  {
			public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

		table = new JTable(model);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 100, 775, 300);
		jTableSet();
		panel.add(scrollPane);
		
		btnExit = new JButton("돌아가기");
		btnExit.setBounds(630, 430, 150, 30);
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
	public Vector getColumn() {
		Vector col = new Vector();
		col.add("등 번호");
		col.add("포지션");
		col.add("이름");
		col.add("생년월일");
		col.add("국적");
		col.add("키");
		col.add("몸무게");
		col.add("코멘트");
		
		return col;
	}
	public void jTableSet() {
	    table.getTableHeader().setReorderingAllowed(false);
	    table.getTableHeader().setResizingAllowed(false);
	    table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

	    DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
	    celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
	    DefaultTableCellRenderer celAlignLeft = new DefaultTableCellRenderer();
	    celAlignLeft.setHorizontalAlignment(JLabel.LEFT);
	    
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    table.getColumnModel().getColumn(0).setPreferredWidth(55);
	    table.getColumnModel().getColumn(0).setCellRenderer(celAlignCenter);
	    table.getColumnModel().getColumn(1).setPreferredWidth(50);
	    table.getColumnModel().getColumn(1).setCellRenderer(celAlignCenter);
	    table.getColumnModel().getColumn(2).setPreferredWidth(200);
	    table.getColumnModel().getColumn(2).setCellRenderer(celAlignCenter);
	    table.getColumnModel().getColumn(3).setPreferredWidth(70);
	    table.getColumnModel().getColumn(3).setCellRenderer(celAlignCenter);
	    table.getColumnModel().getColumn(4).setPreferredWidth(70);
	    table.getColumnModel().getColumn(4).setCellRenderer(celAlignCenter);
	    table.getColumnModel().getColumn(5).setPreferredWidth(40);
	    table.getColumnModel().getColumn(5).setCellRenderer(celAlignCenter);
	    table.getColumnModel().getColumn(6).setPreferredWidth(50);
	    table.getColumnModel().getColumn(6).setCellRenderer(celAlignCenter);
	    table.getColumnModel().getColumn(7).setPreferredWidth(237);
	    table.getColumnModel().getColumn(7).setCellRenderer(celAlignCenter);
	  }
}
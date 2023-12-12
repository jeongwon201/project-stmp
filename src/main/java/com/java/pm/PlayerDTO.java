package com.java.pm;

public class PlayerDTO {
	private int backNum;
	private String pos;
	private String name;
	private String birth;
	private String nationality;
	private int height;
	private int weight;
	private String comment;
	
	public PlayerDTO() {
	}
	
	public PlayerDTO(int backNum, String pos, String name, String birth, String nationality, int height, int weight, String comment) {
		super();
		this.backNum = backNum;
		this.pos = pos;
		this.name = name;
		this.birth = birth;
		this.nationality = nationality;
		this.height = height;
		this.weight = weight;
		this.comment = comment;
	}

	public int getBackNum() {
		return backNum;
	}
	public void setBackNum(int backNum) {
		this.backNum = backNum;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}

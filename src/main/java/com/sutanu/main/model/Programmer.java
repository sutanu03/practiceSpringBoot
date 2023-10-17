package com.sutanu.main.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity //helps to understand that it is a entity of db
public class Programmer {
	
	@Id // which will be primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto generated
	private int pID;
	private String pName;
	private String pLang;
	public int getpID() {
		return pID;
	}
	public void setpID(int pID) {
		this.pID = pID;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpLang() {
		return pLang;
	}
	public void setpLang(String pLang) {
		this.pLang = pLang;
	}
	public Programmer(int pID, String pName, String pLang) {
		super();
		this.pID = pID;
		this.pName = pName;
		this.pLang = pLang;
	}
	public Programmer() {
		super();
	}
	@Override
	public String toString() {
		return "Programmer [pID=" + pID + ", pName=" + pName + ", pLang=" + pLang + "]";
	}
	
	

}

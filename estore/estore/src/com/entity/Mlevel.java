package com.entity;

import java.io.Serializable;

public class Mlevel implements Serializable{
	private int lid;
	private String levelName;
	private double favourable;
	public Mlevel() {
		super();
	}
	public Mlevel(int lid, String levelName, double favourable) {
		super();
		this.lid = lid;
		this.levelName = levelName;
		this.favourable = favourable;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLevelName() {
		return levelName;
	}
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	public double getFavourable() {
		return favourable;
	}
	public void setFavourable(double favourable) {
		this.favourable = favourable;
	}
	@Override
	public String toString() {
		return "Memberlevel [favourable=" + favourable + ", levelName="
				+ levelName + ", lid=" + lid + "]";
	}
	
}

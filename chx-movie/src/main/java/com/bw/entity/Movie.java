package com.bw.entity;

/**
 * @author MACHENIKE
 *
 */
public class Movie {

	private Integer id;
	private String name;
	private String actor;
	private double pice;
	private String startime;
	private Integer longtime;
	private String type;
	private Integer years;
	private String area;
	private Integer status;//1：即将上映 2,正在热映 3：已经下架
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Movie(Integer id, String name, String actor, double pice, String startime, Integer longtime, String type,
			Integer years, String area, Integer status) {
		super();
		this.id = id;
		this.name = name;
		this.actor = actor;
		this.pice = pice;
		this.startime = startime;
		this.longtime = longtime;
		this.type = type;
		this.years = years;
		this.area = area;
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public double getPice() {
		return pice;
	}
	public void setPice(double pice) {
		this.pice = pice;
	}
	public String getStartime() {
		return startime;
	}
	public void setStartime(String startime) {
		this.startime = startime;
	}
	public Integer getLongtime() {
		return longtime;
	}
	public void setLongtime(Integer longtime) {
		this.longtime = longtime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getYears() {
		return years;
	}
	public void setYears(Integer years) {
		this.years = years;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", actor=" + actor + ", pice=" + pice + ", startime=" + startime
				+ ", longtime=" + longtime + ", type=" + type + ", years=" + years + ", area=" + area + ", status="
				+ status + "]";
	}
	
	
	
	
}

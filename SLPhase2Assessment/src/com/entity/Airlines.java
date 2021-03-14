package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="airlines")
public class Airlines {
	@Id
	private int id;
	@Column(name="flights")
	private String airline;
	@Column(name="price")
	private double price;

	public Airlines() {
		super();
	}
	public Airlines(int id, String airline, double cost) {
		super();
		this.id = id;
		this.airline = airline;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}

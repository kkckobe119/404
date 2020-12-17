package com.example.Movie404;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HubioStructure {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
    String category;
    String entity;
    Boolean winner;
    int year;
    
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getEntity() {
		return entity;
	}
	
	public void setEntity(String entity) {
		this.entity = entity;
	}
	
	public Boolean getWinner() {
		return winner;
	}
	
	public void setWinner(Boolean winner) {
		this.winner = winner;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	@Override
	public String toString() {
		return "HubioStructure [id=" + id + ", category=" + category + ", entity=" + entity + ", winner=" + winner
				+ ", year=" + year + "]";
	}
	
	public HubioStructure() {}
	
	public HubioStructure(Long id, String category, String entity, Boolean winner, int year) {
		super();
		this.id = id;
		this.category = category;
		this.entity = entity;
		this.winner = winner;
		this.year = year;
	}
    
}
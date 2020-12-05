package com.example.MovieDB;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name = "Movies")
public class Movie {
	
	@Id
	@Column(name = "Id")
	private long id;
	
	@Column(name = "Year_film")
	private String year_film;
	
	@Column(name = "Year_ceremony")
	private String year_ceremony;
	
	@Column(name = "Ceremony")
	private String ceremony;
	
	@Column(name = "Category")
	private String category;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Film")
	private String film;
	
	@Column(name = "Winner")
	private boolean winner;
	
	Movie() {}
	
	public String getYear_film() {
		return year_film;
	}
	public void setYear_film(String year_film) {
		this.year_film = year_film;
	}
	public String getYear_ceremony() {
		return year_ceremony;
	}
	public void setYear_ceremony(String year_ceremony) {
		this.year_ceremony = year_ceremony;
	}
	public String getCeremony() {
		return ceremony;
	}
	public void setCeremony(String ceremony) {
		this.ceremony = ceremony;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFilm() {
		return film;
	}
	public void setFilm(String film) {
		this.film = film;
	}
	public boolean isWinner() {
		return winner;
	}
	public void setWinner(boolean winner) {
		this.winner = winner;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((ceremony == null) ? 0 : ceremony.hashCode());
		result = prime * result + ((film == null) ? 0 : film.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (winner ? 1231 : 1237);
		result = prime * result + ((year_ceremony == null) ? 0 : year_ceremony.hashCode());
		result = prime * result + ((year_film == null) ? 0 : year_film.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (ceremony == null) {
			if (other.ceremony != null)
				return false;
		} else if (!ceremony.equals(other.ceremony))
			return false;
		if (film == null) {
			if (other.film != null)
				return false;
		} else if (!film.equals(other.film))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (winner != other.winner)
			return false;
		if (year_ceremony == null) {
			if (other.year_ceremony != null)
				return false;
		} else if (!year_ceremony.equals(other.year_ceremony))
			return false;
		if (year_film == null) {
			if (other.year_film != null)
				return false;
		} else if (!year_film.equals(other.year_film))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", year_film=" + year_film + ", year_ceremony=" + year_ceremony + ", ceremony="
				+ ceremony + ", category=" + category + ", name=" + name + ", film=" + film + ", winner=" + winner
				+ "]";
	}

	public Movie(long id, String year_film, String year_ceremony, String ceremony, String category, String name,
			String film, boolean winner) {
		super();
		this.id = id;
		this.year_film = year_film;
		this.year_ceremony = year_ceremony;
		this.ceremony = ceremony;
		this.category = category;
		this.name = name;
		this.film = film;
		this.winner = winner;
	}
}

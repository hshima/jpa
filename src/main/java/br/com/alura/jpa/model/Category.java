package br.com.alura.jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;

	// Deprecated method so Hibernate could access this method
	@Deprecated
	public Category() {
	}

	public Category(String string) {
		setDescription(string);
	}

	public String toString() {
		return description + " - " + id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(long id) {
		this.id = id;
		
	}

}

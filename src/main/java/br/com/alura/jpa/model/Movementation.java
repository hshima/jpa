package br.com.alura.jpa.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Movementation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private BigDecimal value;
	
	@Enumerated(EnumType.STRING)
	private MovementType movementType;
	private LocalDateTime date;
	private String description;

	@ManyToOne
	private Account account;

	@ManyToMany
	private List<Category> categories;

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public MovementType getMovementType() {
		return movementType;
	}

	public void setMovementType(MovementType MovementType) {
		this.movementType = MovementType;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}

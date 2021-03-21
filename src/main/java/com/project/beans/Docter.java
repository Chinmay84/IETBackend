package com.project.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class Docter {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@NotNull
	float experience;
	int rating;
	@Column(nullable = false)
	String officeAddress;
	@Column(nullable = false)
	String qualification;

/*	@ManyToMany(mappedBy = "dlist")
	List<User> ulist;
*/
	@OneToOne
	@JoinTable(name="userid")
	User user;
}

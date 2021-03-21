package com.project.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class FosterHome {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String description;
	
	@OneToOne
	@JoinColumn(name = "userid")
	User user;
	
	
}

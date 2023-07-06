package com.app.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude="password")
@Table(name="student")
@JsonIgnoreProperties(value= {"course"})
public class Student extends BaseEntity {
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	private String password;
	
	@ManyToOne
	private Course title;
	
	private int score;
}

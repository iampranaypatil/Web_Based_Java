package com.app.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
@ToString
@Table(name="course")
@JsonIgnoreType
public class Course extends BaseEntity {
	@Column(unique=true)
	
	private String title;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private int fees;
	
	private int  minScore;
	
	@OneToMany(mappedBy = "title", cascade=CascadeType.ALL)//,fetch=FetchType.EAGER
	@Fetch(FetchMode.JOIN)
	private List<Student> listStudent;
}

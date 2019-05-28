package com.exercisetwo.entity;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Student_Classes")
public class StudentClass {

//	@Id
//	@Column(name = "student_id")
//	private Student student;
//	@Id
//	@Column(name = "class_id")
//	private Class classe;
	@EmbeddedId
	private StudentClassKey id;

	@ManyToOne
	@MapsId("student_id")
	@JoinColumn(name = "student_id")
	private Student student;
	
	@ManyToOne
	@MapsId("class_id")
	@JoinColumn(name = "class_id")
	private Class classe;
	
	private Date dateTo;
//	@Id
//	private Date dateFrom;
//	private Date dateTo;
}

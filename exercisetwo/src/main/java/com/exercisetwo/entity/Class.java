package com.exercisetwo.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Classes")
public class Class {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int classId;
//	@Column(name = "class_id")
//	private int subjectId;
	@ManyToOne
	@JoinColumn(name = "subject_id")
	private Subject subject;
	@ManyToOne
	@JoinColumn(name = "teacher_id")
	private Teacher teacher;
	@Column(name = "class_code")
	@NotBlank(message = "Class code cannot be empty")
	@Size(min = 2, max = 200)
	private String classCode;
	@Column(name = "class_name")
	@NotBlank(message = "Class name cannot be empty")
	@Size(min = 2, max = 200)
	private String className;
	@Column(name = "date_from")
	private Date dateFrom;
	@Column(name = "date_to")
	private Date dateTo;
	@Column(name = "class_status")
	@NumberFormat
	private int classStatus;

	@JsonBackReference
//	@JsonIgnore
	@OneToMany(mappedBy = "classe")
	Set<StudentClass> studentClass;
	
//	private List<DTOStudent> listDtoStudents;
	
//	@JsonIgnore
//	@ManyToMany(mappedBy = "classes", cascade = CascadeType.PERSIST)
//	private Set<Student> students = new HashSet<>();
}

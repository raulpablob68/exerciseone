package com.exercisetwo.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	@Column(name = "gender")
	private String gender;
	@NotBlank(message = "First name cannot be empty")
	@Size(min = 2, max = 200)
	@Column(name = "first_name")
	private String firstName;
	@Nullable
	@Size(min = 2, max = 200)
	@Column(name = "middle_name")
	private String middleName;
	@NotBlank(message = "Last name cannot be empty")
	@Size(min = 2, max = 200)
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "date_of_birth")
	private Date dateOfBirth;
	@Nullable
	@Size(min = 2, max = 200)
	@Column(name = "other_student_details")
	private String otherStudentDetails;
	@Column(name = "student_status")
	private int studentStatus;

	//@JsonIgnore
	@JsonBackReference
	@OneToMany(mappedBy = "student")
	Set<StudentClass> studentClass;
//	@JsonIgnore
//	@ManyToMany(cascade = CascadeType.PERSIST)
//	@JoinTable(name = "Student_Classes",  
//		joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "studentId"), 
//		inverseJoinColumns = @JoinColumn(name = "class_id", referencedColumnName = "classId"))
//	private Set<Class> classes;
}

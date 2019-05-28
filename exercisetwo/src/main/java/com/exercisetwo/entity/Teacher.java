package com.exercisetwo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.lang.Nullable;

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
@Table(name = "Teachers")
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teacherId;
	@Column(name = "school_id")
	private int schoolId;
	@Column(name = "gender")
	private String gender;
	@Column(name = "first_name")
	@NotBlank(message = "First name cannot be empty")
	@Size(min = 2, max = 200)
	private String firstName;
	@Column(name = "middle_name")
	@Nullable
	@Size(min = 2, max = 200)
	private String middleName;
	@Column(name = "last_name")
	@NotBlank(message = "Last name cannot be empty")
	@Size(min = 2, max = 200)
	private String lastName;
	@Column(name = "other_teacher_details")
	@Nullable
	@Size(min = 2, max = 200)
	private String otherTeacherDetails;
	@Column(name = "teacher_status")
	@NumberFormat
	private int teacherStatus;
	@JsonIgnore
	@OneToMany(mappedBy = "teacher")
	private List<Class> classList;
}

package com.exercisetwo.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudent {
	private int studentId;

	private String gender;

	private String firstName;

	private String middleName;

	private String lastName;

	private Date dateOfBirth;

	private String otherStudentDetails;

	private int studentStatus;
}

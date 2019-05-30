package com.exercisetwo.entity;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoClass {
	private int classId;
	private Subject subject;
	private Teacher teacher;
	private String classCode;
	private String className;
	private Date dateFrom;
	private Date dateTo;
	private int classStatus;
	private List<DtoStudent> listDtoStudents;
}

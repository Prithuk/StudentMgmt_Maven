package com.prithu.sim.dto;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Student.class)
public abstract class Student_ extends com.prithu.sim.dto.AbstractUserTracker_ {

	public static volatile SingularAttribute<Student, Long> phone;
	public static volatile SingularAttribute<Student, String> sname;
	public static volatile SingularAttribute<Student, Grade> grade;
	public static volatile SingularAttribute<Student, String> email;

}


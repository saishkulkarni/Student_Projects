package mvc_student.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Student 
{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String name;
private long mob;
private double maths;
private double science;
private double english;
private double totalmarks;
private double percentage;

public double getTotalmarks() {
	return totalmarks;
}
public void setTotalmarks(double totalmarks) {
	this.totalmarks = totalmarks;
}
public double getPercentage() {
	return percentage;
}
public void setPercentage(double percentage) {
	this.percentage = percentage;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public long getMob() {
	return mob;
}
public void setMob(long mob) {
	this.mob = mob;
}
public double getMaths() {
	return maths;
}
public void setMaths(double maths) {
	this.maths = maths;
}
public double getScience() {
	return science;
}
public void setScience(double science) {
	this.science = science;
}
public double getEnglish() {
	return english;
}
public void setEnglish(double english) {
	this.english = english;
}

}

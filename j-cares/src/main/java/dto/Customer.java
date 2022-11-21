package dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer 
{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@Column(unique = true,nullable = false)
private String name;
@Column(unique = true,nullable = false)
private String email;
@Column(unique = true,nullable = false)
private long mobile;
private String password;
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public long getMobile() {
	return mobile;
}
public void setMobile(long mobile) {
	this.mobile = mobile;
}
public String getPassword() {
	return password;
}
public void setPassword(String passowrd) {
	this.password = passowrd;
}

}

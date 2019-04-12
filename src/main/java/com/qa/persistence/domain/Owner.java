package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Owner {
	

	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
private String fName;
private String lName;

public Owner() {
	
	
}

public String getlName() {
	return lName;
}

public void setlName(String lName) {
	this.lName = lName;
}

public String getfName() {
	return fName;
}

public void setfName(String fName) {
	this.fName = fName;
}


}

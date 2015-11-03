package com.shivang.socialapp.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Organization")
public class Organization {
	
	@Id
    @GeneratedValue
    @Column(name="org_id")
    private long id;
	
	@Column(name="org_name")
    private String name;
	
	@Column(name="org_desc")
    private String description;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="street", column = @Column(name = "street")),
		@AttributeOverride(name="city", column = @Column(name = "city")),
		@AttributeOverride(name="state", column = @Column(name = "state")),
		@AttributeOverride(name="zip", column = @Column(name = "zip"))
		})
	private Address address;
    
	public Organization(){
		
	}
	
	public Organization(String name, String description){
		this.name = name;
		this.description = description;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}

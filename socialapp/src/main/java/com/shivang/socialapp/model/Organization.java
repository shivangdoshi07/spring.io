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
    private long organization_id;
	
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
	
	
	/**
	 * @return the organization_id
	 */
	public long getOrganization_id() {
		return organization_id;
	}

	/**
	 * @param organization_id the organization_id to set
	 */
	public void setOrganization_id(long organization_id) {
		this.organization_id = organization_id;
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
	@Override
	public String toString(){
		 return new StringBuffer("{organization_id : ").append(this.organization_id).append("; name : ").append(this.name).append("; description : ").append(this.description).append("; address : ").append(this.address).append("}").toString();
	}
}

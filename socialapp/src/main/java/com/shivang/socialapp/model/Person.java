package com.shivang.socialapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.eclipse.persistence.oxm.annotations.XmlInverseReference;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

@Entity
@Table(name="Person", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "email"}) })
@XmlRootElement(name="person")
public class Person implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
	
	@Column(name="firstname")
    private String firstname;
	
	@Column(name="lastname")
    private String lastname;
	
	@Column(name="email")
    private String email;
	
	@Column(name="description")
    private String description;
	
	
    @Embedded
	@AttributeOverrides({
		@AttributeOverride(name="street", column = @Column(name = "street")),
		@AttributeOverride(name="city", column = @Column(name = "city")),
		@AttributeOverride(name="state", column = @Column(name = "state")),
		@AttributeOverride(name="zip", column = @Column(name = "zip"))
		})
    @JsonUnwrapped
	private Address address;
    
    @ManyToOne
    @JoinColumn(name="org_id")
    private Organization org;
    
    @JsonIgnoreProperties({"description","org","friends"})
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Friendship", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "friend_id"))
    private List<Person> friends = new ArrayList<Person>();

    public Person(){}
    
    public Person(String firstname, String lastname, String email){
    	this.firstname = firstname;
    	this.lastname = lastname;
    	this.email = email;
    }
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public Organization getOrg() {
		return org;
	}
	public void setOrg(Organization org) {
		this.org = org;
	}
	public List<Person> getFriends() {
		return friends;
	}
	public void setFriends(List<Person> friends) {
		this.friends = friends;
	}
/*
	*//**
	 * @return the befriended
	 *//*
	public List<Person> getBefriended() {
		return befriended;
	}

	*//**
	 * @param befriended the befriended to set
	 *//*
	public void setBefriended(List<Person> befriended) {
		this.befriended = befriended;
	}
*/	
	@Override
	public String toString(){
		 return new StringBuffer("{firstname : ").append(this.firstname).append(", lastname : ").append(this.lastname).append(", email : ").append(this.email).append(", description : ").append(this.description).append(", address : ").append(this.address.toString()).append(", org : ").append(this.org.toString()).append("}").toString();
	}
    
}
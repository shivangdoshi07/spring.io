package com.shivang.secretsharing.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class User {
	String name;
	HashMap<UUID, Secret> ownSecrets = new HashMap<UUID, Secret>();
	HashMap<UUID, Secret> receivedSecrets = new HashMap<UUID, Secret>();
	
	public User(){
		
	}
	
	public User(String name){
		this.name = name;
		this.ownSecrets.clear();
		this.receivedSecrets.clear();
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HashMap<UUID, Secret> getOwnSecrets() {
		return ownSecrets;
	}
	public HashMap<UUID, Secret> getReceivedSecrets() {
		return receivedSecrets;
	}
	
	public void addOwnSecret(UUID id, Secret s){
		ownSecrets.put(id,s);
	}
	
	public void addSharedSecret(UUID id,Secret s){
		receivedSecrets.put(id, s);
	}
	
	public Secret readOwnSecret(UUID secretId){
		return ownSecrets.get(secretId);
	}
	
	public Secret readSharedSecret(UUID secretId){
		return receivedSecrets.get(secretId);
	}
	
	public void unshareSecret(UUID secretId){
		receivedSecrets.remove(secretId);
	}

}

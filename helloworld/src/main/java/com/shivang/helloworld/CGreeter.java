package com.shivang.helloworld;

import java.util.List;


/* Class implemented by the bean */
public class CGreeter implements IGreeter{

	private List<String> names; // list of names of all authors
	private List<String> greetings; //list of authors title
	
	public void setNames(List<String> names) {
		this.names  = names;
		
	}

	public String getGreeting() {
		StringBuffer br = new StringBuffer();
		for (int i=0;i<names.size();i++){
			br.append(names.get(i));
		}
		return names.toString();
	}

	public List<String> getGreetings() {
		return greetings;
	}

	public void setGreetings(List<String> greetings) {
		this.greetings = greetings;
	}

	public String getName() {
		return names.toString();
	}

	public void setGreeting(List<String> g) {
		greetings = g;
	}
	
	
	/* Override toString() for custom output */
	@Override
	public String toString() {
		StringBuffer br = new StringBuffer();
		for (int i=0;i<names.size();i++){
			br.append("Hello world from "+ greetings.get(i) + " " + names.get(i) + "\n");
		}
		return br.toString();
	}
	
	

}

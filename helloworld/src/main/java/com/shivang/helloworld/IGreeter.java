package com.shivang.helloworld;

import java.util.List;


/* Interface IGreeter which is implemented by the bean*/
interface IGreeter {
	void setNames(List<String> names); // names of the authors
	String getName();
	
	void setGreeting(List<String> names); // title of the authors
	String getGreeting();
  }
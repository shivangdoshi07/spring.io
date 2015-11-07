package com.shivang.socialapp.service;

import java.util.List;

import com.shivang.socialapp.model.Person;

public interface FriendshipService {

	/**
	 * create/add friendship
	 */
	public Person create(long id1, long id2);
	
	/**
	 * remove/delete friendship
	 */
	public Person delete(long id1, long id2);
}

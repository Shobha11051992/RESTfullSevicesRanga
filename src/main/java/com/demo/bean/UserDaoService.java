package com.demo.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<Users> user = new ArrayList<Users>();

	private static int UserCount = 3;
	static {
		user.add(new Users(100, "Kiran", new Date()));
		user.add(new Users(200, "shobha", new Date()));
		user.add(new Users(300, "vitthal", new Date()));

	}

	public List<Users> findAll() {
		return user;
	}

	public Users save(Users users) {
		if (users.getId() == null) {
			users.setId(++UserCount);
		}

		user.add(users);
		{
			return users;
		}
	}

	public Users findOne(int id) {
		for (Users users : user) {
			if (users.getId() == id) {
				return users;
			}
		}
		return null;
	}

	/*
	 * public Users deleteById(int id) { Iterator<Users> it = user.iterator(); while
	 * (it.hasNext()) { Users user = it.next(); if (user.getId() == id) {
	 * it.remove(); return user; } } return null; }
	 */

	public Users deleteById(int id) {
		Iterator<Users> it = user.iterator();
		while (it.hasNext()) {
			Users user = it.next();
			if (user.getId() == id) {
				it.remove();
				return user;
			}
		}
		return null;
	}

	/*
	 * public Users deletById() { // TODO Auto-generated method stub return null; }
	 */

	// public list<User> findAll()
	// public User save(User user)
	// public User findOne(int id)
	// public User delete(int id)

}

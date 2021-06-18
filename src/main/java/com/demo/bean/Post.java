package com.demo.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Post {
	@Id
	@GeneratedValue
	private Integer id;
	private String Description;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Users user1;

	public Post() {
	}

	public Post(Integer id, String description, Users user1) {
		super();
		this.id = id;
		Description = description;
		this.user1 = user1;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Users getUser1() {
		return user1;
	}

	public void setUser1(Users user1) {
		this.user1 = user1;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", Description=" + Description + "]";
	}
}

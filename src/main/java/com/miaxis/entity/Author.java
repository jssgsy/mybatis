package com.miaxis.entity;

import java.util.List;

public class Author {

	private Long id;
	private String name;
	private List<Blog> blogList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Blog> getBlogList() {
		return blogList;
	}
	public void setBlogList(List<Blog> blogList) {
		this.blogList = blogList;
	}
}

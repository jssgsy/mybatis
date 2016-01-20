package com.miaxis.entity;

public class Blog {
	private int id;
	private String title;
	private String content;
	private Author author;
	
	
	public Blog() {
		super();
	}
	
	public Blog(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	
	public Blog(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
}

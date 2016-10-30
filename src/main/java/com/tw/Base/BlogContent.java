package com.tw.Base;

public class BlogContent {

	String name;
    String age;
    String experience;
    String blogContent;
    String profession;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getBlogContent() {
		return blogContent;
	}
	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	
	public BlogContent(String name, String age, String experience, String blogContent, String profession) {
		this.name = name;
		this.age = age;
		this.experience = experience;
		this.blogContent = blogContent;
		this.profession = profession;
	}
    
    
}

package springmvcdemo01.jt.example.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Message {
	private Integer id;
	private String title;
	private Date createdDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	
	@DateTimeFormat(pattern="yyyy-mm-dd")
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", title=" + title + ", createdDate=" + createdDate + "]";
	}
	
}

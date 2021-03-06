package mybatisdemo02.com.jt.module.entity;

import java.io.Serializable;
import java.util.Date;

public class Project implements Serializable{//ctrl shift o快速引入包的类
	/**
	 * 
	 */
	private static final long serialVersionUID = -1896713497517597352L;
	
	private Integer id;
	private String name;
	private String note;
	private Date createdTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", note=" + note + ", createdTime=" + createdTime + "]";
	}

}

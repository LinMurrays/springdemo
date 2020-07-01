package mybatisdemo02.com.jt.module.entity;

import java.util.Date;

public class OrderResult {
	private String id;
	private Integer state;
	private Double price;
	private Date createdTime;
	private Project project;
	@Override
	public String toString() {
		return "OrderResult [id=" + id + ", state=" + state + ", price=" + price + ", createdTime=" + createdTime
				+ ", project=" + project + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}

}

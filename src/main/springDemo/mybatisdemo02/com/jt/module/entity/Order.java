package mybatisdemo02.com.jt.module.entity;

import java.util.Date;

public class Order {
    private String id;
    private Integer state;
    private Double price;
    /**
     * 所属项目id
     */
    private Integer projectId;
    private Date createdTime;

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

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", state=" + state + ", price=" + price + ", projectId=" + projectId
                + ", createdTime=" + createdTime + "]";
    }
}

package mybatisdemo01.com.jt.module.entity;

import java.util.Date;

public class Project {//ctrl shift o快速引入包的类
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

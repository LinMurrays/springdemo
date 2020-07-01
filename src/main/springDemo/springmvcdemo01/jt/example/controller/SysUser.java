package springmvcdemo01.jt.example.controller;

public class SysUser {
    private Integer id;
    private String Username;
    private String Password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return "SysUser [id=" + id + ", Username=" + Username + ", Password=" + Password + "]";
    }
}

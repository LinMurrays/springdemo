package springdemo01.utils;


public class OpenDataSource {
    private String url;
    private String driver;
    private String user;
    private String password;
    private Integer sources;

    public OpenDataSource(Integer sources) {
        this.sources = sources;
    }

    public OpenDataSource(String url, String driver, String user, String password) {
        this.url = url;
        this.driver = driver;
        this.user = user;
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "OpenDataSource [url=" + url + ", driver=" + driver + ", user=" + user + ", password=" + password
                + ", sources=" + sources + "]";
    }


}

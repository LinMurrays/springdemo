package demo.jt.sys.dao.impl;

import demo.jt.sys.dao.SysConfigDao;
import demo.jt.sys.entity.SysConfig;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SysConfigDaoimpl implements SysConfigDao {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public SysConfig findById(Integer id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from sys_configs where id=?";

        try {
            SysConfig sys = null;
            conn = dataSource.getConnection();
            System.out.println("conn=" + conn);
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                sys = new SysConfig();
                sys.setId(id);
                sys.setName(rs.getString("name"));
                sys.setValue(rs.getString("value"));
            }
            return sys;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            //5.Close
            if (rs != null) try {
                rs.close();
            } catch (Exception e) {
            }
            if (ps != null) try {
                ps.close();
            } catch (Exception e) {
            }
            if (conn != null) try {
                conn.close();
            } catch (Exception e) {
            }
        }
    }


}



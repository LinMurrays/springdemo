package demo.jt.sys.dao.impl;

import demo.jt.sys.dao.SysConfigDao;
import demo.jt.sys.entity.SysConfig;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SysConfigDaoImpl2 implements SysConfigDao {

    private JdbcTemplate jdbcTemplate;

    //注意！此处set方法是用来根据xml文档的设置来创建对象的！根据set后面的参数名来设置xml中的内属性值！
    public void setJdbcTemplates(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public SysConfig findById(Integer id) {
        String sql = "select *from sys_configs where id=?";

        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<SysConfig>() {

            public SysConfig mapRow(ResultSet rs, int rowNum) throws SQLException {
                SysConfig cfg = new SysConfig();
                cfg.setName(rs.getString("name"));
                cfg.setValue(rs.getString("value"));
                cfg.setNote(rs.getString("note"));
                return cfg;
            }
        });
    }
}

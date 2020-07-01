package springdemo03.com.jt.sys.service.impl;


import springdemo03.com.jt.sys.dao.SysConfigDao;
import springdemo03.com.jt.sys.entity.SysConfig;
import springdemo03.com.jt.sys.service.SysConfigService;

//将此对象交给spring管理
//并为此对象注入一个SysConfigDao对象
public class SysConfigServicelmpl implements SysConfigService {

    private springdemo03.com.jt.sys.dao.SysConfigDao SysConfigDao;

    public void setSysConfigDao(SysConfigDao sysConfigDao) {
        this.SysConfigDao = sysConfigDao;
    }


    public SysConfig findObjectById(Integer id) {
        //1.参数合法性验证
        if (id == null || id < 1) {
            throw new IllegalArgumentException("参数不合法");
        }
        //2.基于id执行对象查询(调用DAO方法)
        SysConfig cfg = SysConfigDao.findById(id);
        //3.验证结果
        if (cfg == null) {
            throw new RuntimeException("此记录可能已经删除");
        }
        //4.返回结果
        return cfg;
    }

}

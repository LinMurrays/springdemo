package com.test;

import com.jt.sys.controller.SysConfigController;
import com.jt.sys.dao.SysConfigDao;
import com.jt.sys.entity.SysConfig;
import org.junit.Test;

public class TestBeans01 extends TestBase {

    @Test
    public void testDaoFindById() {
        SysConfigDao scf = ctx.getBean("sysConfigDao", SysConfigDao.class);
        SysConfig cfg = scf.findById(4);
        System.out.println(cfg.getName());
    }

    @Test
    public void testServlceFindById() {
        SysConfigDao scf = ctx.getBean("sysConfigDao", SysConfigDao.class);
        SysConfig cfg = scf.findById(4);
        System.out.println(cfg.getName());
    }

    @Test
    public void testControllerFindById() {
        SysConfigController sc = ctx.getBean(SysConfigController.class);
        System.out.println(sc.doFindById(4).getName());
    }

}

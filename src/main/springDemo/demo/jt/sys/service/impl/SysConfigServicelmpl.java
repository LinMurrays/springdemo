package demo.jt.sys.service.impl;

import demo.jt.sys.dao.SysConfigDao;
import demo.jt.sys.entity.SysConfig;
import demo.jt.sys.service.SysConfigService;

public class SysConfigServicelmpl implements SysConfigService{

	private SysConfigDao sysConfigDao;

	public void setSysConfigDao(SysConfigDao sysConfigDao) {
		this.sysConfigDao = sysConfigDao;
	}


	public SysConfig findObjectById(Integer id) {
		
		if(id==null||id<1){
			throw new IllegalArgumentException("参数不合法");
		}
		
		SysConfig cfg = sysConfigDao.findById(id);
		if(cfg==null){
			throw new RuntimeException("此记录可能已经删除");
		}
		return cfg;
	}
	
}

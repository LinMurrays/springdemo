package com.jt.sys.controller;

import com.jt.sys.entity.SysConfig;
import com.jt.sys.service.SysConfigService;

public class SysConfigController {
	private SysConfigService sysconfigservice;

	public void setSysconfigservice(SysConfigService sysconfigservice) {
		this.sysconfigservice = sysconfigservice;
	}
	
	public SysConfig doFindById(Integer id){
		return sysconfigservice.findObjectById(id);
		//后续可以将返回值转换为 json格式的字符串传输到客户端
	}

}

package springdemo03.com.jt.sys.controller;


import springdemo03.com.jt.sys.entity.SysConfig;
import springdemo03.com.jt.sys.service.SysConfigService;

public class SysConfigController {
	private SysConfigService sysconfigservice;

	public void setSysconfigservice(SysConfigService sysconfigservice) {
		this.sysconfigservice = sysconfigservice;
	}
	
	public void findById(Integer id){
		SysConfig cfg= sysconfigservice.findObjectById(4);
		System.out.println(cfg);
	}

}

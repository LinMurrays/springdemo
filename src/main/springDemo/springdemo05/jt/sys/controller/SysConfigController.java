package springdemo05.jt.sys.controller;

import org.springframework.stereotype.Controller;
import springdemo05.jt.sys.service.SysConfigService;

import javax.annotation.Resource;


@Controller
public class SysConfigController {
	private SysConfigService sysConfigService;
	/**
	 * 修饰属性和set方法，按属性名和set方法名为属性注入值
	 */
	@Resource//默认查找名字相同的，不常用
	private SysConfigService syConfigService;
	
}

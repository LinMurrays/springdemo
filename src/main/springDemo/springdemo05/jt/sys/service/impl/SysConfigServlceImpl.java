package springdemo05.jt.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import springdemo05.jt.sys.dao.SysConfigDao;
import springdemo05.jt.sys.service.SysConfigService;

@Service
public class SysConfigServlceImpl implements SysConfigService {

	//修饰属性时，按属性类型从IOC容器中查找对象，并为此属性注入值
	@Autowired
	@Qualifier("sysConfigDaoImpl")
	private SysConfigDao sysConfigDao;
}

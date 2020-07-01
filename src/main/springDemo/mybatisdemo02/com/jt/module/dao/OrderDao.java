package mybatisdemo02.com.jt.module.dao;

import mybatisdemo02.com.jt.module.entity.Order;
import mybatisdemo02.com.jt.module.entity.OrderResult;

import java.util.Map;

public interface OrderDao {
	int insertObjects(Order entity);
	
	/**
	 * 基于订单id查询订单信息以及订单
	 * 关联的项目信息,并将结果封装到map
	 * 对象(此次查询执行表关联查询.)
	 * @param id
	 * @return
	 */
	Map<String,Object> findObjectByid(String id);
	
	
	/**
	  * 基于订单id查询订单信息以及订单
	  * 关联的项目信息,并将结果封装到VO(Value Object)
	  * 对象(此次查询执行表关联查询.)
	  * @param id
	  * @return
	  */
	Map<String, Object> findOrderResultById(String id);
	
	
	/**
	 * 基于订单id查询订单信息以及订单
	 * 关联的项目信息，并将结果封装到VO
	 * 对象(通过多次查询实现)
	 * @param id
	 * @return
	 */
	OrderResult findOrderResultWithId(String id);
	
	
}

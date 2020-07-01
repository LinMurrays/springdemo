package mybatisdemo02.com.jt.module.dao;

import mybatisdemo02.com.jt.module.entity.Project;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectDao {
	/**
	 * 查询所有的项目信息
	 * @return
	 */
	List<Project> findObjects(@Param("column") String column, @Param("type") String type);
	
	/**
	 * 基于id查询项目信息
	 */
	Project findObjectById(Integer id);
	/**
	 * 
	 * @param name
	 * @param startIndex
	 * @param pageSize
	 * @return
	 *多于一个参数的时候建议使用注解方式
	 */
	//映射文件可以使用#{name}获取@Param注解定义的参数对应的值
	List<Project> findPageObjects
     (@Param("name") String name, @Param("startIndex") Integer startIndex, @Param("pageSize") Integer pageSize);
	
	/**
	 * 向表中插入一条记录
	 * @param entity
	 * @return
	 */
	int insertObject(Project entity);
	/**
	 * 更新表中记录
	 * @param p 封装了要更新的数据
	 * @return
	 */
	int insertinto2(Project p);
	
	/**
	 * 更新表中记录
	 * @param //entity 封装了要更新的数据
	 * @return
	 */
	int updateObject(Project p);
	/**
	 * 基于id执行删除操作
	 * @param id
	 * @return
	 */
	int deleteObject(Integer id);
	
	//可变参数，动态SQL基本实现
	int deleteObjects(@Param("ids") Integer... id);
	
	/**
	 * 向数据库中批量写入对象信息
	 * @param list
	 * @return
	 */
	int insertObjects2(@Param("list") List<Project> list);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

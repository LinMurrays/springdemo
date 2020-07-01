package mybatisdemo01.com.jt.module.dao;


import mybatisdemo01.com.jt.module.entity.Project;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectDao {
    /**
     * 查询所有的项目信息
     *
     * @return
     */
    List<Project> findObjects();

    /**
     * 基于id查询项目信息
     */
    Project findObjectById(Integer id);

    /**
     * @param name
     * @param startIndex
     * @param pageSize
     * @return 多于一个参数的时候建议使用注解方式
     */
    //映射文件可以使用#{name}获取@Param注解定义的参数对应的值
    List<Project> findPageObjects
    (@Param("name") String name, @Param("startIndex") Integer startIndex, @Param("pageSize") Integer pageSize);

    /**
     * 向表中插入一条记录
     *
     * @param entity
     * @return
     */
    int insertObject(Project entity);

    /**
     * 更新表中记录
     *
     * @param p 封装了要更新的数据
     * @return
     */
    int updateObject(Project p);

    /**
     * 基于id执行删除操作
     *
     * @param id
     * @return
     */
    int deleteObject(Integer id);


}

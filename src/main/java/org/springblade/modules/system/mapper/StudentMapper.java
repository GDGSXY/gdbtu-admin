package org.springblade.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import org.springblade.modules.system.bo.StudentBO;
import org.springblade.modules.system.entity.Student;
import org.springblade.modules.system.query.StudentQuery;

/**
 * @author Jover Zhang
 */
public interface StudentMapper extends BaseMapper<Student> {

    StudentBO getStudentById(long userId);

    IPage<StudentBO> getPage(IPage<Student> page, @Param("query") StudentQuery query);

}





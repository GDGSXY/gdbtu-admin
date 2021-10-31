package org.springblade.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.springblade.modules.system.bo.TeacherBO;
import org.springblade.modules.system.entity.Teacher;
import org.springblade.modules.system.query.TeacherQuery;

import java.util.List;
import java.util.Map;

/**
 * @author Jover Zhang
 */
public interface TeacherMapper extends BaseMapper<Teacher> {

    TeacherBO getTeacherById(long id);

    @MapKey("userId")
    Map<Long, Teacher> getMapByIds(List<Long> userIds);

    IPage<TeacherBO> getPage(IPage<Teacher> page, @Param("query") TeacherQuery query);

}





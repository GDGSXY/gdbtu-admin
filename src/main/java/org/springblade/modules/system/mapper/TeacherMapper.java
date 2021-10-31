package org.springblade.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.MapKey;
import org.springblade.modules.system.entity.Teacher;

import java.util.List;
import java.util.Map;

/**
 * @author Jover Zhang
 */
public interface TeacherMapper extends BaseMapper<Teacher> {

    @MapKey("userId")
    Map<Long, Teacher> getMapByIds(List<Long> userIds);

}





package org.springblade.modules.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.modules.system.entity.Teacher;

import java.util.List;
import java.util.Map;

/**
 *
 */
public interface TeacherService extends IService<Teacher> {

    Map<Long, Teacher> getMapByIds(List<Long> userIds);

}

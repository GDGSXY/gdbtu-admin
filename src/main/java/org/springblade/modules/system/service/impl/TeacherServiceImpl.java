package org.springblade.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springblade.modules.system.entity.Teacher;
import org.springblade.modules.system.mapper.TeacherMapper;
import org.springblade.modules.system.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 *
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Override
    public Map<Long, Teacher> getMapByIds(List<Long> userIds) {
        return baseMapper.getMapByIds(userIds);
    }

}





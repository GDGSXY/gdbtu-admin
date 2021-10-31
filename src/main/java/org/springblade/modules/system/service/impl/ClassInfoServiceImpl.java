package org.springblade.modules.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springblade.modules.system.entity.ClassInfo;
import org.springblade.modules.system.mapper.ClassInfoMapper;
import org.springblade.modules.system.service.ClassInfoService;
import org.springframework.stereotype.Service;

/**
 * @author Jover Zhang
 */
@Service
public class ClassInfoServiceImpl extends ServiceImpl<ClassInfoMapper, ClassInfo> implements ClassInfoService {

    @Override
    public long countByMajorId(long majorId) {
        LambdaQueryWrapper<ClassInfo> wrapper = Wrappers.lambdaQuery(ClassInfo.class)
                .eq(ClassInfo::getMajorId, majorId);
        return count(wrapper);
    }

}

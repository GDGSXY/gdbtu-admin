package org.springblade.modules.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springblade.common.tool.PageUtil;
import org.springblade.modules.system.entity.ClassInfo;
import org.springblade.modules.system.mapper.ClassInfoMapper;
import org.springblade.modules.system.query.ClassInfoQuery;
import org.springblade.modules.system.service.ClassInfoService;
import org.springframework.stereotype.Service;

/**
 * @author Jover Zhang
 */
@Service
public class ClassInfoServiceImpl extends ServiceImpl<ClassInfoMapper, ClassInfo> implements ClassInfoService {

    @Override
    public IPage<ClassInfo> getPage(ClassInfoQuery query) {
        LambdaQueryWrapper<ClassInfo> wrapper = Wrappers.lambdaQuery(ClassInfo.class)
                // 班级名称
                .likeRight(query.getName() != null, ClassInfo::getName, query.getName())
                // 所属专业
                .eq(query.getMajorId() != null, ClassInfo::getMajorId, query.getMajorId())
                // 辅导员
                .eq(query.getCounselorId() != null, ClassInfo::getCounselorId, query.getCounselorId())
                // 班主任
                .eq(query.getHeadTeacherId() != null, ClassInfo::getHeadTeacherId, query.getHeadTeacherId())
                // 开设年份
                .eq(query.getEstablishYear() != null, ClassInfo::getEstablishYear, query.getEstablishYear())
                // 培养层次
                .eq(query.getEducationLevel() != null, ClassInfo::getEducationLevel, query.getEducationLevel())
                // 毕业状态
                .eq(query.getStatus() != null, ClassInfo::getStatus, query.getStatus())
                // 学制
                .eq(query.getSchoolYear() != null, ClassInfo::getSchoolYear, query.getSchoolYear());
        return page(PageUtil.toPage(query), wrapper);
    }

    @Override
    public long countByMajorId(long majorId) {
        LambdaQueryWrapper<ClassInfo> wrapper = Wrappers.lambdaQuery(ClassInfo.class)
                .eq(ClassInfo::getMajorId, majorId);
        return count(wrapper);
    }

}

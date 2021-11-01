package org.springblade.modules.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springblade.common.tool.PageUtil;
import org.springblade.modules.system.entity.Major;
import org.springblade.modules.system.mapper.MajorMapper;
import org.springblade.modules.system.query.MajorQuery;
import org.springblade.modules.system.service.MajorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Jover Zhang
 */
@Service
public class MajorServiceImpl extends ServiceImpl<MajorMapper, Major> implements MajorService {

    @Override
    public IPage<Major> getPage(MajorQuery query) {
        LambdaQueryWrapper<Major> wrapper = Wrappers.lambdaQuery(Major.class)
                .eq(query.getName() != null, Major::getName, query.getName())
                .eq(query.getAcademyId() != null, Major::getAcademyId, query.getAcademyId());
        return page(PageUtil.toPage(query), wrapper);
    }

    @Override
    public Map<Long, Major> getMapByIds(List<Long> majorIds) {
        return baseMapper.getMapByIds(majorIds);
    }

    @Override
    public long countByAcademyId(long academyId) {
        LambdaQueryWrapper<Major> wrapper = Wrappers.lambdaQuery(Major.class)
                .eq(Major::getAcademyId, academyId);
        return count(wrapper);
    }

}

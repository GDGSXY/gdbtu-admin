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

import java.util.Objects;

/**
 * @author Jover Zhang
 */
@Service
public class MajorServiceImpl extends ServiceImpl<MajorMapper, Major> implements MajorService {

    @Override
    public IPage<Major> getPage(MajorQuery query) {
        LambdaQueryWrapper<Major> wrapper = Wrappers.lambdaQuery(Major.class)
                .eq(Objects.nonNull(query.getName()), Major::getName, query.getName());
        return page(PageUtil.toPage(query), wrapper);
    }

}





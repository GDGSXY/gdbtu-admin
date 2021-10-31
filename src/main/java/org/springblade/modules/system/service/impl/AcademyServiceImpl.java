package org.springblade.modules.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springblade.common.tool.PageUtil;
import org.springblade.modules.system.entity.Academy;
import org.springblade.modules.system.mapper.AcademyMapper;
import org.springblade.modules.system.query.AcademyQuery;
import org.springblade.modules.system.service.AcademyService;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 *
 */
@Service
public class AcademyServiceImpl extends ServiceImpl<AcademyMapper, Academy> implements AcademyService {

    @Override
    public IPage<Academy> getPage(AcademyQuery query) {
        LambdaQueryWrapper<Academy> wrapper = Wrappers.lambdaQuery(Academy.class)
                .eq(Objects.nonNull(query.getName()), Academy::getName, query.getName());
        return page(PageUtil.toPage(query), wrapper);
    }

}

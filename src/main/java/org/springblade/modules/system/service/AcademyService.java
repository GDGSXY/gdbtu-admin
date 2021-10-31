package org.springblade.modules.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.modules.system.entity.Academy;
import org.springblade.modules.system.query.AcademyQuery;

/**
 *
 */
public interface AcademyService extends IService<Academy> {

    IPage<Academy> getPage(AcademyQuery query);

}

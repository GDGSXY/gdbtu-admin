package org.springblade.modules.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.modules.system.entity.ClassInfo;
import org.springblade.modules.system.query.ClassInfoQuery;

/**
 * @author Jover Zhang
 */
public interface ClassInfoService extends IService<ClassInfo> {

    IPage<ClassInfo> getPage(ClassInfoQuery query);

    long countByMajorId(long majorId);

}

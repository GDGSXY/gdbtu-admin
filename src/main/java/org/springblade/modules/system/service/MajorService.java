package org.springblade.modules.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.modules.system.entity.Major;
import org.springblade.modules.system.query.MajorQuery;

/**
 * @author Jover Zhang
 */
public interface MajorService extends IService<Major> {

    IPage<Major> getPage(MajorQuery query);

}

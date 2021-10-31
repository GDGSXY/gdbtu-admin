package org.springblade.modules.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.modules.system.entity.Major;
import org.springblade.modules.system.query.MajorQuery;

import java.util.List;
import java.util.Map;

/**
 * @author Jover Zhang
 */
public interface MajorService extends IService<Major> {

    IPage<Major> getPage(MajorQuery query);

    Map<Long, Major> getMapByIds(List<Long> majorIds);

}

package org.springblade.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.MapKey;
import org.springblade.modules.system.entity.Major;

import java.util.List;
import java.util.Map;

/**
 * @author Jover Zhang
 */
public interface MajorMapper extends BaseMapper<Major> {

    @MapKey("id")
    Map<Long, Major> getMapByIds(List<Long> majorIds);

}

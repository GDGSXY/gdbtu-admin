package org.springblade.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springblade.modules.system.entity.ClassInfo;
import org.springblade.modules.system.mapper.ClassInfoMapper;
import org.springblade.modules.system.service.ClassInfoService;
import org.springframework.stereotype.Service;

/**
 * @author Jover Zhang
 */
@Service
public class ClassInfoServiceImpl extends ServiceImpl<ClassInfoMapper, ClassInfo>
	implements ClassInfoService {
}





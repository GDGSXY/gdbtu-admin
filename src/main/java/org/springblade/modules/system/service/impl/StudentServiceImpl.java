package org.springblade.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springblade.modules.system.entity.Student;
import org.springblade.modules.system.mapper.StudentMapper;
import org.springblade.modules.system.service.StudentService;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
	implements StudentService {
}





package org.springblade.modules.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.modules.system.bo.StudentBO;
import org.springblade.modules.system.cmd.CreateStudentCMD;
import org.springblade.modules.system.cmd.UpdateStudentCMD;
import org.springblade.modules.system.entity.Student;
import org.springblade.modules.system.query.StudentQuery;

import java.util.List;

/**
 *
 */
public interface StudentService extends IService<Student> {

    StudentBO getStudentById(long userId);

    IPage<StudentBO> getPage(StudentQuery query);

    int countByClassId(long classId);

    boolean createStudent(CreateStudentCMD cmd);

    boolean updateStudent(UpdateStudentCMD cmd);

    boolean removeStudentByIds(List<Long> userIds);

    Student getStudentByIdentificationNumber(String identificationNumber);

}

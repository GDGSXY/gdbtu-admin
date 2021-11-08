package org.springblade.modules.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springblade.common.tool.PageUtil;
import org.springblade.core.tool.utils.Func;
import org.springblade.modules.system.bo.StudentBO;
import org.springblade.modules.system.cmd.CreateStudentCMD;
import org.springblade.modules.system.cmd.UpdateStudentCMD;
import org.springblade.modules.system.entity.Student;
import org.springblade.modules.system.entity.User;
import org.springblade.modules.system.mapper.StudentMapper;
import org.springblade.modules.system.query.StudentQuery;
import org.springblade.modules.system.service.IUserService;
import org.springblade.modules.system.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 */
@Service
@RequiredArgsConstructor
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    private final IUserService userService;

    @Override
    public StudentBO getStudentById(long userId) {
        return baseMapper.getStudentById(userId);
    }

    @Override
    public IPage<StudentBO> getPage(StudentQuery query) {
        return baseMapper.getPage(PageUtil.toPage(query), query);
    }

    @Override
    public int countByClassId(long classId) {
        LambdaQueryWrapper<Student> wrapper = Wrappers.lambdaQuery(Student.class)
                .eq(Student::getClassId, classId);
        return count(wrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean createStudent(CreateStudentCMD cmd) {
        // Create User
        User user = new User();
        user.setAccount(cmd.getName());
        user.setPassword("NULL");
        user.setRoleId(Func.join(cmd.getRoleIds()));
        userService.save(user);
        // Create Student
        Student student = new Student()
                .setUserId(user.getId())
                .setStudentCode(cmd.getStudentCode())
                .setName(cmd.getName())
                .setGender(cmd.getGender())
                .setClassId(cmd.getClassId())
                .setIdentificationNumber(cmd.getIdentificationNumber())
                .setPoliticalOutlook(cmd.getPoliticalOutlook())
                .setStudentStatus(cmd.getStudentStatus());
        return save(student);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateStudent(UpdateStudentCMD cmd) {
        // Create User
        User user = userService.getById(cmd.getId());
        user.setRoleId(Func.join(cmd.getRoleIds()));
        userService.updateById(user);
        // Create Student
        Student student = getStudentByUserId(cmd.getId())
                .setStudentCode(cmd.getStudentCode())
                .setName(cmd.getName())
                .setGender(cmd.getGender())
                .setClassId(cmd.getClassId())
                .setIdentificationNumber(cmd.getIdentificationNumber())
                .setPoliticalOutlook(cmd.getPoliticalOutlook())
                .setStudentStatus(cmd.getStudentStatus());
        return updateById(student);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeStudentByIds(List<Long> userIds) {
        return userService.removeByIds(userIds) &&
                removeStudentByUserIds(userIds);
    }

    @Override
    public Student getStudentByIdentificationNumber(String identificationNumber) {
        LambdaQueryWrapper<Student> wrapper = Wrappers.lambdaQuery(Student.class)
                .eq(Student::getIdentificationNumber, identificationNumber);
        return getOne(wrapper);
    }

    private Student getStudentByUserId(long userId) {
        LambdaQueryWrapper<Student> wrapper = Wrappers.lambdaQuery(Student.class)
                .eq(Student::getUserId, userId);
        return getOne(wrapper);
    }

    private boolean removeStudentByUserIds(List<Long> userIds) {
        LambdaQueryWrapper<Student> wrapper = Wrappers.lambdaQuery(Student.class)
                .in(Student::getUserId, userIds);
        return remove(wrapper);
    }

}

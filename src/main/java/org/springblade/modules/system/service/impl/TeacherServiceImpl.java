package org.springblade.modules.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springblade.common.tool.PageUtil;
import org.springblade.core.tool.utils.Func;
import org.springblade.modules.system.bo.TeacherBO;
import org.springblade.modules.system.cmd.CreateTeacherCMD;
import org.springblade.modules.system.cmd.UpdateTeacherCMD;
import org.springblade.modules.system.entity.Teacher;
import org.springblade.modules.system.entity.User;
import org.springblade.modules.system.mapper.TeacherMapper;
import org.springblade.modules.system.query.TeacherQuery;
import org.springblade.modules.system.service.IUserService;
import org.springblade.modules.system.service.TeacherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 *
 */
@Service
@RequiredArgsConstructor
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    private final IUserService userService;

    @Override
    public TeacherBO getTeacherById(long id) {
        return baseMapper.getTeacherById(id);
    }

    @Override
    public IPage<TeacherBO> getPage(TeacherQuery query) {
        return baseMapper.getPage(PageUtil.toPage(query), query);
    }

    @Override
    public Map<Long, Teacher> getMapByIds(List<Long> userIds) {
        return baseMapper.getMapByIds(userIds);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean createTeacher(CreateTeacherCMD cmd) {
        // Create User
        User user = new User();
        user.setAccount(cmd.getName());
        user.setPassword("NULL");
        user.setRoleId(Func.join(cmd.getRoleIds()));
        userService.save(user);
        // Create Teacher
        Teacher teacher = new Teacher()
                .setUserId(user.getId())
                .setTeacherCode(cmd.getTeacherCode())
                .setName(cmd.getName())
                .setGender(cmd.getGender())
                .setIdentificationNumber(cmd.getIdentificationNumber())
                .setPoliticalOutlook(cmd.getPoliticalOutlook())
                .setJobStatus(cmd.getJobStatus());
        return save(teacher);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateTeacher(UpdateTeacherCMD cmd) {
        // Update User
        User user = userService.getById(cmd.getId());
        user.setRoleId(Func.join(cmd.getRoleIds()));
        userService.updateById(user);
        // Update Teacher
        Teacher teacher = getTeacherByUserId(cmd.getId())
                .setTeacherCode(cmd.getTeacherCode())
                .setName(cmd.getName())
                .setGender(cmd.getGender())
                .setIdentificationNumber(cmd.getIdentificationNumber())
                .setPoliticalOutlook(cmd.getPoliticalOutlook())
                .setJobStatus(cmd.getJobStatus());
        return updateById(teacher);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeTeacherByIds(List<Long> userIds) {
        return userService.removeByIds(userIds) &&
                removeTeacherByUserIds(userIds);
    }

    private Teacher getTeacherByUserId(long userId) {
        LambdaQueryWrapper<Teacher> wrapper = Wrappers.lambdaQuery(Teacher.class)
                .eq(Teacher::getUserId, userId);
        return getOne(wrapper);
    }

    private boolean removeTeacherByUserIds(List<Long> userIds) {
        LambdaQueryWrapper<Teacher> wrapper = Wrappers.lambdaQuery(Teacher.class)
                .in(Teacher::getUserId, userIds);
        return remove(wrapper);
    }

}

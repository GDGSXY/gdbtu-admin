package org.springblade.modules.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.modules.system.bo.TeacherBO;
import org.springblade.modules.system.cmd.CreateTeacherCMD;
import org.springblade.modules.system.cmd.UpdateTeacherCMD;
import org.springblade.modules.system.entity.Teacher;
import org.springblade.modules.system.query.TeacherQuery;

import java.util.List;
import java.util.Map;

/**
 *
 */
public interface TeacherService extends IService<Teacher> {

    TeacherBO getTeacherById(long id);

    IPage<TeacherBO> getPage(TeacherQuery query);

    Map<Long, Teacher> getMapByIds(List<Long> userIds);

    boolean createTeacher(CreateTeacherCMD cmd);

    boolean updateTeacher(UpdateTeacherCMD cmd);

    boolean removeTeacherByIds(List<Long> userIds);

}

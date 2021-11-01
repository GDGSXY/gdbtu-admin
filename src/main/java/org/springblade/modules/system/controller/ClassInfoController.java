package org.springblade.modules.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springblade.core.boot.ctrl.BladeController;
import org.springblade.core.secure.annotation.PreAuth;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.constant.RoleConstant;
import org.springblade.core.tool.utils.Func;
import org.springblade.modules.system.entity.ClassInfo;
import org.springblade.modules.system.entity.Major;
import org.springblade.modules.system.entity.Teacher;
import org.springblade.modules.system.query.ClassInfoQuery;
import org.springblade.modules.system.service.ClassInfoService;
import org.springblade.modules.system.service.MajorService;
import org.springblade.modules.system.service.StudentService;
import org.springblade.modules.system.service.TeacherService;
import org.springblade.modules.system.vo.ClassInfoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 班级信息控制器
 *
 * @author Jover Zhang
 * @date 2021/10/25
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "班级信息")
@PreAuth(RoleConstant.HAS_ROLE_ADMIN)
@RequestMapping("/blade-system/classInfo")
public class ClassInfoController extends BladeController {

    private final ClassInfoService service;

    private final MajorService majorService;

    private final StudentService studentService;

    private final TeacherService teacherService;

    @GetMapping("/{id}")
    @ApiOperation("查看详情")
    @ApiOperationSupport(order = 1)
    public R<ClassInfo> detail(@PathVariable("id") long id) {
        return R.data(service.getById(id));
    }

    @GetMapping
    @ApiOperation("分页")
    @ApiOperationSupport(order = 2)
    public R<IPage<ClassInfoVO>> page(ClassInfoQuery query) {
        IPage<ClassInfo> page = service.getPage(query);
        // 专业信息
        List<Long> majorIds = page.getRecords().stream().map(ClassInfo::getMajorId).collect(Collectors.toList());
        Map<Long, Major> majorMap = majorService.getMapByIds(majorIds);
        // 教职工信息
        HashSet<Long> teacherIds = Sets.newHashSet();
        teacherIds.addAll(page.getRecords().stream().map(ClassInfo::getCounselorId).collect(Collectors.toList()));
        teacherIds.addAll(page.getRecords().stream().map(ClassInfo::getHeadTeacherId).collect(Collectors.toList()));
        Map<Long, Teacher> teacherMap = teacherService.getMapByIds(Lists.newArrayList(teacherIds));
        // Convert
        return R.data(page.convert(v -> {
            ClassInfoVO vo = new ClassInfoVO();
            BeanUtils.copyProperties(v, vo);
            Major major = majorMap.get(v.getMajorId());
            vo.setMajorName(major.getName());
            vo.setAcademyName("I don't know");
            vo.setNumStudents(studentService.countByClassId(v.getId()));
            vo.setCounselorName(teacherMap.get(v.getCounselorId()).getName());
            vo.setHeadTeacherName(teacherMap.get(v.getHeadTeacherId()).getName());
            return vo;
        }));
    }

    @GetMapping("/select")
    @ApiOperation("下拉数据源")
    @ApiOperationSupport(order = 3)
    public R<List<ClassInfo>> select() {
        return R.data(service.list());
    }

    @ApiOperation("新增")
    @PostMapping("/save")
    @ApiOperationSupport(order = 4)
    public R<Void> create(@RequestBody ClassInfo classInfo) {
        return R.status(service.saveOrUpdate(classInfo));
    }

    @ApiOperation("修改")
    @PostMapping("/update")
    @ApiOperationSupport(order = 5)
    public R<Void> update(@RequestBody ClassInfo classInfo) {
        return R.status(service.saveOrUpdate(classInfo));
    }

    @ApiOperation("删除")
    @PostMapping("/remove")
    @ApiOperationSupport(order = 6)
    public R<Void> update(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
        return R.status(service.removeByIds(Func.toLongList(ids)));
    }

}

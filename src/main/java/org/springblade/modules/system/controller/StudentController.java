package org.springblade.modules.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springblade.core.boot.ctrl.BladeController;
import org.springblade.core.secure.annotation.PreAuth;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.constant.RoleConstant;
import org.springblade.core.tool.utils.Func;
import org.springblade.modules.system.bo.StudentBO;
import org.springblade.modules.system.cmd.CreateStudentCMD;
import org.springblade.modules.system.cmd.UpdateStudentCMD;
import org.springblade.modules.system.query.StudentQuery;
import org.springblade.modules.system.service.StudentService;
import org.springblade.modules.system.vo.StudentVO;
import org.springframework.web.bind.annotation.*;

/**
 * 学生信息控制器
 *
 * @author Jover Zhang
 * @date 2021/10/25
 */
@RestController
@RequiredArgsConstructor
@Api(value = "学生信息", tags = "接口")
@PreAuth(RoleConstant.HAS_ROLE_ADMIN)
@RequestMapping("/blade-system/student")
public class StudentController extends BladeController {

    private final StudentService service;

    @GetMapping("/{id}")
    @ApiOperation("查看详情")
    @ApiOperationSupport(order = 1)
    public R<StudentVO> detail(@PathVariable("id") long id) {
        return R.data(convert(service.getStudentById(id)));
    }

    @GetMapping
    @ApiOperation("分页")
    @ApiOperationSupport(order = 2)
    public R<IPage<StudentVO>> page(StudentQuery query) {
        return R.data(service.getPage(query).convert(this::convert));
    }

    @ApiOperation("新增")
    @PostMapping("/save")
    @ApiOperationSupport(order = 3)
    public R<Void> create(@RequestBody CreateStudentCMD cmd) {
        return R.status(service.createStudent(cmd));
    }

    @ApiOperation("修改")
    @PostMapping("/update")
    @ApiOperationSupport(order = 4)
    public R<Void> update(@RequestBody UpdateStudentCMD cmd) {
        return R.status(service.updateStudent(cmd));
    }

    @ApiOperation("删除")
    @PostMapping("/remove")
    @ApiOperationSupport(order = 5)
    public R<Void> update(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
        return R.status(service.removeStudentByIds(Func.toLongList(ids)));
    }

    private StudentVO convert(StudentBO bo) {
        return new StudentVO()
                .setId(bo.getId())
                .setStudentCode(bo.getStudentCode())
                .setName(bo.getName())
                .setGender(bo.getGender())
                .setClassId(bo.getClassId())
                .setIdentificationNumber(bo.getIdentificationNumber())
                .setPoliticalOutlook(bo.getPoliticalOutlook())
                .setStudentStatus(bo.getStudentStatus())
                .setAccount(bo.getAccount())
                .setRoleIds(Lists.newArrayList(bo.getRoleIds().split(",")));
    }

}

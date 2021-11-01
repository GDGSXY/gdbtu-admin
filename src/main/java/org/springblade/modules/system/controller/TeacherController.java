package org.springblade.modules.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springblade.core.secure.annotation.PreAuth;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.constant.RoleConstant;
import org.springblade.core.tool.utils.Func;
import org.springblade.modules.system.bo.TeacherBO;
import org.springblade.modules.system.cmd.CreateTeacherCMD;
import org.springblade.modules.system.cmd.UpdateTeacherCMD;
import org.springblade.modules.system.query.TeacherQuery;
import org.springblade.modules.system.service.ClassInfoService;
import org.springblade.modules.system.service.TeacherService;
import org.springblade.modules.system.vo.TeacherSelectVO;
import org.springblade.modules.system.vo.TeacherVO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 教职工信息控制器
 *
 * @author Jover Zhang
 * @date 2021/10/25
 */
@RestController
@RequiredArgsConstructor
@Api(value = "教职工信息", tags = "接口")
@PreAuth(RoleConstant.HAS_ROLE_ADMIN)
@RequestMapping("/blade-system/teacher")
public class TeacherController {

    private final TeacherService service;

    private final ClassInfoService classInfoService;

    @GetMapping("/{id}")
    @ApiOperation("查看详情")
    @ApiOperationSupport(order = 1)
    public R<TeacherVO> detail(@PathVariable("id") long id) {
        return R.data(convert(service.getTeacherById(id)));
    }

    @GetMapping
    @ApiOperation("分页")
    @ApiOperationSupport(order = 2)
    public R<IPage<TeacherVO>> page(TeacherQuery query) {
        return R.data(service.getPage(query).convert(this::convert));
    }

    @GetMapping("/select")
    @ApiOperation("下拉数据源")
    @ApiOperationSupport(order = 3)
    public R<List<TeacherSelectVO>> select() {
        List<TeacherSelectVO> selectList = service.list().stream()
                .map(t -> new TeacherSelectVO()
                        .setId(t.getUserId())
                        .setName(t.getName()))
                .collect(Collectors.toList());
        return R.data(selectList);
    }

    @ApiOperation("新增")
    @PostMapping("/save")
    @ApiOperationSupport(order = 4)
    public R<Void> create(@RequestBody CreateTeacherCMD cmd) {
        return R.status(service.createTeacher(cmd));
    }

    @ApiOperation("修改")
    @PostMapping("/update")
    @ApiOperationSupport(order = 5)
    public R<Void> update(@RequestBody UpdateTeacherCMD cmd) {
        return R.status(service.updateTeacher(cmd));
    }

    @ApiOperation("删除")
    @PostMapping("/remove")
    @ApiOperationSupport(order = 6)
    public R<Void> update(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
        return R.status(service.removeTeacherByIds(Func.toLongList(ids)));
    }

    private TeacherVO convert(TeacherBO bo) {
        return new TeacherVO()
                .setId(bo.getId())
                .setTeacherCode(bo.getTeacherCode())
                .setName(bo.getName())
                .setIdentificationNumber(bo.getIdentificationNumber())
                .setPoliticalOutlook(bo.getPoliticalOutlook())
                .setJobStatus(bo.getJobStatus())
                .setNumManageClass(classInfoService.countByTeacherId(bo.getId()))
                .setAccount(bo.getAccount())
                .setRoleIds(Lists.newArrayList(bo.getRoleIds().split(",")));
    }

}

package org.springblade.modules.system.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springblade.core.boot.ctrl.BladeController;
import org.springblade.core.secure.BladeUser;
import org.springblade.core.secure.utils.SecureUtil;
import org.springblade.core.tool.api.R;
import org.springblade.modules.system.bo.StudentBO;
import org.springblade.modules.system.service.StudentService;
import org.springblade.modules.system.vo.StudentVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jover Zhang
 * @date 2021/11/8
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "查询用户信息")
@RequestMapping("/blade-system/userInfo")
public class QueryUserController extends BladeController {

    private final StudentService studentService;

    @GetMapping("/student")
    @ApiOperation("查看自己的详情")
    @ApiOperationSupport(order = 6)
    public R<StudentVO> studentDetail() {
        BladeUser user = SecureUtil.getUser();
        return R.data(convert(studentService.getStudentById(user.getUserId())));
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

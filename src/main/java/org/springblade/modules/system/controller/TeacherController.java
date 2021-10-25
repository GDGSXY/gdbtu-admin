package org.springblade.modules.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springblade.core.mp.support.Condition;
import org.springblade.core.mp.support.Query;
import org.springblade.core.secure.annotation.PreAuth;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.constant.RoleConstant;
import org.springblade.modules.system.entity.Teacher;
import org.springblade.modules.system.service.TeacherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@GetMapping
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入分页")
	public R<IPage<Teacher>> page(Query query) {
		return R.data(service.page(Condition.getPage(query)));
	}

}

package org.springblade.modules.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springblade.core.boot.ctrl.BladeController;
import org.springblade.core.secure.annotation.PreAuth;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.constant.RoleConstant;
import org.springblade.core.tool.utils.Func;
import org.springblade.modules.system.entity.Major;
import org.springblade.modules.system.query.MajorQuery;
import org.springblade.modules.system.service.ClassInfoService;
import org.springblade.modules.system.service.MajorService;
import org.springblade.modules.system.vo.MajorVO;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

/**
 * 专业信息控制器
 *
 * @author Jover Zhang
 * @date 2021/10/25
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "专业信息")
@PreAuth(RoleConstant.HAS_ROLE_ADMIN)
@RequestMapping("/blade-system/major")
public class MajorController extends BladeController {

    private final MajorService service;

    private final ClassInfoService classInfoService;

    @GetMapping("/{id}")
    @ApiOperation("查看详情")
    @ApiOperationSupport(order = 1)
    public R<Major> detail(@PathVariable("id") long id) {
        return R.data(service.getById(id));
    }

    @GetMapping
    @ApiOperation("分页")
    @ApiOperationSupport(order = 2)
    public R<IPage<MajorVO>> page(MajorQuery query) {
        IPage<MajorVO> voPage = service.getPage(query)
                .convert(major -> {
                    MajorVO vo = new MajorVO();
                    BeanUtils.copyProperties(major, vo);
                    // 班级个数
                    vo.setNumClasses(classInfoService.countByMajorId(major.getId()));
                    return vo;
                });
        return R.data(voPage);
    }

    @ApiOperation("新增")
    @PostMapping("/save")
    @ApiOperationSupport(order = 3)
    public R<Void> create(@RequestBody Major major) {
        return R.status(service.saveOrUpdate(major));
    }

    @ApiOperation("修改")
    @PostMapping("/update")
    @ApiOperationSupport(order = 3)
    public R<Void> update(@RequestBody Major major) {
        return R.status(service.saveOrUpdate(major));
    }

    @ApiOperation("删除")
    @PostMapping("/remove")
    @ApiOperationSupport(order = 4)
    public R<Void> update(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
        return R.status(service.removeByIds(Func.toLongList(ids)));
    }

}

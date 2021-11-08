package org.springblade.modules.auth.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springblade.core.tool.api.R;
import org.springblade.modules.auth.WeappAuthInfoVO;
import org.springblade.modules.auth.cmd.LoginWeappCMD;
import org.springblade.modules.auth.cmd.RegisterWeappCMD;
import org.springblade.modules.auth.service.AuthWeappService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 小程序授权
 *
 * @author Jover Zhang
 * @date 2021/11/7
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("blade-auth")
@Api(value = "用户授权认证", tags = "授权接口")
public class AuthWeappController {

    private final AuthWeappService service;

    @PostMapping("/loginWeapp")
    @ApiOperation(value = "登录微信小程序")
    public R<WeappAuthInfoVO> loginWeapp(@RequestBody LoginWeappCMD cmd) {
        WeappAuthInfoVO vo = service.loginWeapp(cmd);
        if (vo == null) {
            return R.data(401, null, "未注册");
        }
        return R.data(vo);
    }

    @PostMapping("/registerWeapp/student")
    @ApiOperation("学生注册微信小程序")
    public R<Void> registerWeapp(@RequestBody RegisterWeappCMD cmd) {
        service.registerWeapp(cmd);
        return R.status(true);
    }

}

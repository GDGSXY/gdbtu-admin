package org.springblade.modules.auth.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springblade.core.secure.AuthInfo;
import org.springblade.modules.auth.WeappAuthInfoVO;
import org.springblade.modules.auth.client.dto.WeappJscode2sessionDTO;
import org.springblade.modules.auth.cmd.LoginWeappCMD;
import org.springblade.modules.auth.cmd.RegisterWeappCMD;
import org.springblade.modules.auth.utils.TokenUtil;
import org.springblade.modules.system.entity.Student;
import org.springblade.modules.system.entity.User;
import org.springblade.modules.system.entity.UserInfo;
import org.springblade.modules.system.service.IUserService;
import org.springblade.modules.system.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * @author Jover Zhang
 * @date 2021/11/8
 */
@Service
@RequiredArgsConstructor
public class AuthWeappService {

    private final IUserService userService;

    private final StudentService studentService;

    private final ObjectMapper objectMapper;

    private final RestTemplate restTemplate = new RestTemplate();

    @SneakyThrows
    public WeappAuthInfoVO loginWeapp(LoginWeappCMD cmd) {
        WeappJscode2sessionDTO dto = getWeappSession(cmd.getCode());
        if (dto.getOpenid() == null) {
            throw new IllegalArgumentException(dto.toString());
        }
        User user = userService.getByWeappOpenId(dto.getOpenid());
        if (user == null) {
            return null;
        }
        AuthInfo authInfo = doAuth(user);
        return new WeappAuthInfoVO(authInfo, dto.getSession_key(), dto.getOpenid());
    }

    @SneakyThrows
    @Transactional(rollbackFor = Exception.class)
    public void registerWeapp(RegisterWeappCMD cmd) {
        WeappJscode2sessionDTO dto = getWeappSession(cmd.getCode());
        if (dto.getOpenid() == null) {
            throw new IllegalArgumentException(dto.toString());
        }
        // 校验拥有此 openid 的用户是否已存在
        if (userService.getByWeappOpenId(dto.getOpenid()) != null) {
            throw new IllegalStateException("已注册");
        }
        // 获取身份证号对应的学生信息
        Student student = studentService.getStudentByIdentificationNumber(cmd.getIdentificationNumber());
        if (student == null) {
            throw new IllegalArgumentException("暂不存在该身份证对应的学生信息， 请联系管理员");
        }
        // 绑定 openid
        User user = userService.getById(student.getUserId());
        user.setWeappOpenid(dto.getOpenid());
        userService.updateById(user);
    }

    private AuthInfo doAuth(User user) {
        UserInfo info = userService.userInfo(user.getId());
        return TokenUtil.createAuthInfo(info);
    }

    private WeappJscode2sessionDTO getWeappSession(String jsCode) throws IOException {
        String res = restTemplate.getForObject("https://api.weixin.qq.com/sns/jscode2session?" +
                "appid=wx7931a80d0030182a&" +
                "secret=41ff52e2572e3bb986ce28adcb65739d&" +
                "js_code=" + jsCode + "&" +
                "grant_type=authorization_code", String.class);
        return objectMapper.readValue(res, WeappJscode2sessionDTO.class);
    }

}

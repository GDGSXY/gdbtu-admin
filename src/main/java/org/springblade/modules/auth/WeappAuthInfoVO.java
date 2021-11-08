package org.springblade.modules.auth;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.core.secure.AuthInfo;
import org.springframework.beans.BeanUtils;

/**
 * @author Jover Zhang
 * @date 2021/11/7
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WeappAuthInfoVO extends AuthInfo {

    @ApiModelProperty("Weapp 会话秘钥")
    private String sessionKey;

    @ApiModelProperty("Weapp 用户唯一标识")
    private String openid;

    public WeappAuthInfoVO(AuthInfo authInfo, String sessionKey, String openid) {
        BeanUtils.copyProperties(authInfo, this);
        this.sessionKey = sessionKey;
        this.openid = openid;
    }

}

package org.springblade.modules.auth.client.dto;

import lombok.Data;

/**
 * @author Jover Zhang
 * @date 2021/11/8
 */
@Data
public class WeappJscode2sessionDTO {

    private String openid;

    private String session_key;

    private String unionid;

    private String errcode;

    private String errmsg;

}

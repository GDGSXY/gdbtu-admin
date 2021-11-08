package org.springblade.modules.auth.cmd;

import lombok.Data;

/**
 * @author Jover Zhang
 * @date 2021/11/8
 */
@Data
public class RegisterWeappCMD {

    /**
     * 微信小程序 code
     */
    private String code;

    /**
     * 身份证号
     */
    private String identificationNumber;

}

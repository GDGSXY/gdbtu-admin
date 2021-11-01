package org.springblade.modules.system.bo;

import lombok.Data;
import org.springblade.modules.system.enums.PoliticalOutlookEnum;
import org.springblade.modules.system.enums.TeacherJobStatusEnum;

/**
 * @author Jover Zhang
 * @date 2021/11/1
 */
@Data
public class TeacherBO {

    /**
     * id
     */
    private Long id;

    /**
     * 工号
     */
    private String teacherCode;

    /**
     * 姓名
     */
    private String name;

    /**
     * 身份证号
     */
    private String identificationNumber;

    /**
     * 政治面貌
     */
    private PoliticalOutlookEnum politicalOutlook;

    /**
     * 入职状态
     */
    private TeacherJobStatusEnum jobStatus;

    /**
     * 登录账号
     */
    private String account;

    /**
     * 所属角色 ids
     */
    private String roleIds;

}

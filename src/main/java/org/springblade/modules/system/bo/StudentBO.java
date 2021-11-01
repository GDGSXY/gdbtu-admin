package org.springblade.modules.system.bo;

import lombok.Data;
import org.springblade.modules.system.enums.PoliticalOutlookEnum;
import org.springblade.modules.system.enums.StudentStatusEnum;
import org.springblade.modules.system.enums.UserGenderEnum;

/**
 * @author Jover Zhang
 * @date 2021/11/1
 */
@Data
public class StudentBO {

    /**
     * id
     */
    private Long id;

    /**
     * 学号
     */
    private String studentCode;

    /**
     * 学生姓名
     */
    private String name;

    /**
     * 性别
     */
    private UserGenderEnum gender;

    /**
     * 所属班级 id
     */
    private Long classId;

    /**
     * 身份证号
     */
    private String identificationNumber;

    /**
     * 政治面貌
     */
    private PoliticalOutlookEnum politicalOutlook;

    /**
     * 学籍状态
     */
    private StudentStatusEnum studentStatus;

    /**
     * 登录账号
     */
    private String account;

    /**
     * 所属角色 ids
     */
    private String roleIds;

}


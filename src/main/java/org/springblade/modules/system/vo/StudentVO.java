package org.springblade.modules.system.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springblade.modules.system.enums.PoliticalOutlookEnum;
import org.springblade.modules.system.enums.StudentStatusEnum;
import org.springblade.modules.system.enums.UserGenderEnum;

import java.util.List;

/**
 * @author Jover Zhang
 * @date 2021/11/1
 */
@Data
@Accessors(chain = true)
public class StudentVO {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("学号")
    private String studentCode;

    @ApiModelProperty("学生姓名")
    private String name;

    @ApiModelProperty("性别")
    private UserGenderEnum gender;

    @ApiModelProperty("所属班级 id")
    private Long classId;

    @ApiModelProperty("身份证号")
    private String identificationNumber;

    @ApiModelProperty("政治面貌")
    private PoliticalOutlookEnum politicalOutlook;

    @ApiModelProperty("学籍状态")
    private StudentStatusEnum studentStatus;

    @ApiModelProperty("登录账号")
    private String account;

    @ApiModelProperty("所属角色s")
    private List<String> roleIds;

}

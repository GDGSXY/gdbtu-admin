package org.springblade.modules.system.cmd;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springblade.modules.system.enums.PoliticalOutlookEnum;
import org.springblade.modules.system.enums.StudentStatusEnum;
import org.springblade.modules.system.enums.UserGenderEnum;

import java.util.List;

/**
 * @author Jover Zhang
 * @date 2021/11/1
 */
@Data
public class CreateStudentCMD {

    @ApiModelProperty(value = "学号", required = true)
    private String studentCode;

    @ApiModelProperty(value = "学生姓名", required = true)
    private String name;

    @ApiModelProperty(value = "性别", required = true)
    private UserGenderEnum gender;

    @ApiModelProperty(value = "所属班级 id", required = true)
    private Long classId;

    @ApiModelProperty(value = "身份证号", required = true)
    private String identificationNumber;

    @ApiModelProperty(value = "政治面貌", required = true)
    private PoliticalOutlookEnum politicalOutlook;

    @ApiModelProperty(value = "学籍状态", required = true)
    private StudentStatusEnum studentStatus;

    @ApiModelProperty(value = "所属角色 ids", required = true)
    private List<String> roleIds;

}

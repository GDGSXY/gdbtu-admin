package org.springblade.modules.system.cmd;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springblade.modules.system.enums.PoliticalOutlookEnum;
import org.springblade.modules.system.enums.TeacherJobStatusEnum;
import org.springblade.modules.system.enums.UserGenderEnum;

import java.util.List;

/**
 * @author Jover Zhang
 * @date 2021/10/31
 */
@Data
public class CreateTeacherCMD {

    @ApiModelProperty(value = "工号", required = true)
    private String teacherCode;

    @ApiModelProperty(value = "姓名", required = true)
    private String name;

    @ApiModelProperty(value = "性别", required = true)
    private UserGenderEnum gender;

    @ApiModelProperty(value = "身份证号", required = true)
    private String identificationNumber;

    @ApiModelProperty(value = "政治面貌", required = true)
    private PoliticalOutlookEnum politicalOutlook;

    @ApiModelProperty(value = "入职状态", required = true)
    private TeacherJobStatusEnum jobStatus;

    @ApiModelProperty(value = "所属角色s", required = true)
    private List<String> roleIds;

}

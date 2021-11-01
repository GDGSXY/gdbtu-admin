package org.springblade.modules.system.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springblade.modules.system.enums.PoliticalOutlookEnum;
import org.springblade.modules.system.enums.TeacherJobStatusEnum;

import java.util.List;

/**
 * @author Jover Zhang
 * @date 2021/10/31
 */
@Data
@Accessors(chain = true)
public class TeacherVO {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("工号")
    private String teacherCode;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("身份证号")
    private String identificationNumber;

    @ApiModelProperty("政治面貌")
    private PoliticalOutlookEnum politicalOutlook;

    @ApiModelProperty("入职状态")
    private TeacherJobStatusEnum jobStatus;

    @ApiModelProperty("管理班级个数")
    private Long numManageClass;

    @ApiModelProperty("登录账号")
    private String account;

    @ApiModelProperty("所属角色s")
    private List<String> roleIds;

}

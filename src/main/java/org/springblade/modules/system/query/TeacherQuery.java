package org.springblade.modules.system.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.entity.PagingQuery;
import org.springblade.modules.system.enums.TeacherJobStatusEnum;

/**
 * @author Jover Zhang
 * @date 2021/11/1
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TeacherQuery extends PagingQuery {

    @ApiModelProperty("工号")
    private String teacherCode;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("身份证号")
    private String identificationNumber;

    @ApiModelProperty("入职状态")
    private TeacherJobStatusEnum jobStatus;

    // User

    @ApiModelProperty("登录账号")
    private String account;

}

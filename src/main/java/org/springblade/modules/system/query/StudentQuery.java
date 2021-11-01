package org.springblade.modules.system.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.entity.PagingQuery;
import org.springblade.modules.system.enums.StudentStatusEnum;

/**
 * @author Jover Zhang
 * @date 2021/11/1
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class StudentQuery extends PagingQuery {

    @ApiModelProperty("学号")
    private String studentCode;

    @ApiModelProperty("学生姓名")
    private String name;

    @ApiModelProperty("所属班级 id")
    private Long classId;

    @ApiModelProperty("身份证号")
    private String identificationNumber;

    @ApiModelProperty("学籍状态")
    private StudentStatusEnum studentStatus;

    // User

    @ApiModelProperty("登录账号")
    private String account;

}

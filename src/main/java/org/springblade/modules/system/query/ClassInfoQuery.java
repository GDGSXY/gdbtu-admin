package org.springblade.modules.system.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.entity.PagingQuery;
import org.springblade.modules.system.enums.ClassGraduationStatusEnum;
import org.springblade.modules.system.enums.EducationLevelEnum;

/**
 * @author Jover Zhang
 * @date 2021/10/31
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ClassInfoQuery extends PagingQuery {

    //班级名称，所属专业，开设年份，培养层次，毕业状态，学制，辅导员，班主任
    @ApiModelProperty("班级名称")
    private String name;

    @ApiModelProperty("所属专业")
    private Long majorId;

    @ApiModelProperty("辅导员")
    private Long counselorId;

    @ApiModelProperty("班主任")
    private Long headTeacherId;

    @ApiModelProperty("开设年份")
    private String establishYear;

    @ApiModelProperty("培养层次")
    private EducationLevelEnum educationLevel;

    @ApiModelProperty("毕业状态")
    private ClassGraduationStatusEnum status;

    @ApiModelProperty("学制")
    private String schoolYear;

}

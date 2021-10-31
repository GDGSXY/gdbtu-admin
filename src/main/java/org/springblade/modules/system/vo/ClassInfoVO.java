package org.springblade.modules.system.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.modules.system.entity.ClassInfo;

/**
 * @author Jover Zhang
 * @date 2021/10/31
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ClassInfoVO extends ClassInfo {

    @ApiModelProperty("所属专业")
    private String majorName;

    @ApiModelProperty("所属学院")
    private String academyName;

    @ApiModelProperty("班级人数")
    private Integer numStudents;

    @ApiModelProperty("辅导员")
    private String counselorName;

    @ApiModelProperty("班主任")
    private String headTeacherName;

}

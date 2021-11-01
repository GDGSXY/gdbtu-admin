package org.springblade.modules.system.cmd;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Jover Zhang
 * @date 2021/11/1
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UpdateStudentCMD extends CreateStudentCMD {

    @ApiModelProperty(value = "id", required = true)
    private Long id;

}

package org.springblade.modules.system.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.modules.system.entity.Academy;

/**
 * @author Jover Zhang
 * @date 2021/11/1
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AcademyVO extends Academy {

    @ApiModelProperty("专业个数")
    private Long numMajors;

}

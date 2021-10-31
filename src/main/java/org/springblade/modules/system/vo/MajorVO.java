package org.springblade.modules.system.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.modules.system.entity.Major;

/**
 * @author Jover Zhang
 * @date 2021/10/31
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MajorVO extends Major {

    @ApiModelProperty("班级个数")
    private Long classesCount;

}

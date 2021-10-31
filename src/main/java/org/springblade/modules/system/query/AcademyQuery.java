package org.springblade.modules.system.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.entity.PagingQuery;

/**
 * @author Jover Zhang
 * @date 2021/10/31
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AcademyQuery extends PagingQuery {

    @ApiModelProperty("学院名称")
    private String name;

}

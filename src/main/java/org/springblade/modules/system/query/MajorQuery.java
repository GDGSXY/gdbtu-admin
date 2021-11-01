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
public class MajorQuery extends PagingQuery {

    @ApiModelProperty("专业名称")
    private String name;

    @ApiModelProperty("学院 id")
    private Long academyId;

}

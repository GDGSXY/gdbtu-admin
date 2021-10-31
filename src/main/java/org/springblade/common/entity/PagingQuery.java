package org.springblade.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author Jover Zhang
 * @date 2021/10/31
 */
@Data
@Accessors(chain = true)
@ApiModel("分页查询")
public class PagingQuery {

    /**
     * 当前页
     */
    @Min(1)
    @NotNull
    @ApiModelProperty(value = "当前页", required = true)
    private Integer current;

    /**
     * 每页的数量
     */
    @Min(1)
    @NotNull
    @ApiModelProperty(value = "每页的数量", required = true)
    private Integer size;

}

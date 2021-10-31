package org.springblade.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.entity.BaseEntity;

import java.io.Serializable;

/**
 * 专业信息表
 *
 * @author Jover Zhang
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Major extends BaseEntity implements Serializable {

    /**
     * 学院 id
     */
    private Long academyId;

    /**
     * 专业名称
     */
    private String name;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer sort;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}

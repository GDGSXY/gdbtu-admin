package org.springblade.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.entity.BaseEntity;

import java.io.Serializable;

/**
 * 学院信息表
 *
 * @author Jover Zhang
 */
@Data
@TableName(value = "academy")
@EqualsAndHashCode(callSuper = true)
public class Academy extends BaseEntity implements Serializable {

    /**
     * 学院名称
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

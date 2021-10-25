package org.springblade.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Jover Zhang
 * @date 2021/10/24
 */
@Data
public class BaseEntity {

	/**
	 * pk
	 */
	@TableId(type = IdType.ASSIGN_ID)
	private Long id;

	/**
	 * 创建时间
	 */
	private LocalDateTime gmtCreate;

	/**
	 * 更新时间
	 */
	private LocalDateTime gmtModified;

	/**
	 * 是否已删除
	 */
	@TableLogic
	private Boolean deleted;

}

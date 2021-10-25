package org.springblade.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.entity.BaseEntity;
import org.springblade.modules.system.enums.ClassGraduationStatusEnum;
import org.springblade.modules.system.enums.ClassScheduleStatusEnum;
import org.springblade.modules.system.enums.EducationLevelEnum;

import java.io.Serializable;

/**
 * 班级
 *
 * @author Jover Zhang
 * @date 2021/10/15
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ClassInfo extends BaseEntity implements Serializable {

	/**
	 * 班级名称
	 */
	private String name;

	/**
	 * 专业 id
	 */
	private Long majorId;

	/**
	 * 辅导员 id (user id)
	 */
	private Long counselorId;

	/**
	 * 班主任 id (user id)
	 */
	private Long headTeacherId;


	// 详细信息

	/**
	 * 开设年份
	 */
	private String establishYear;

	/**
	 * 学制
	 */
	private String schoolYear;

	/**
	 * 培养层次
	 */
	private EducationLevelEnum educationLevel;

	/**
	 * 校区代码
	 */
	private String campusCode;

	/**
	 * 校区名称
	 */
	private String campusName;

	/**
	 * 带班状态
	 */
	private ClassScheduleStatusEnum scheduleStatus;

	/**
	 * 毕业状态
	 */
	private ClassGraduationStatusEnum status;

	/**
	 * 班级人数
	 */
	private Integer count;

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

}

package org.springblade.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.common.entity.BaseEntity;
import org.springblade.modules.system.enums.PoliticalOutlookEnum;
import org.springblade.modules.system.enums.TeacherJobStatusEnum;
import org.springblade.modules.system.enums.UserGenderEnum;

import java.io.Serializable;

/**
 * 教师信息表
 *
 * @author Jover Zhang
 */
@Data
@TableName(value = "teacher")
@EqualsAndHashCode(callSuper = true)
public class Teacher extends BaseEntity implements Serializable {

	private Long userId;

	private Long academyId;

	private String teacherCode;

	// 详细信息

	/**
	 * 教师姓名
	 */
	private String name;

	/**
	 * 性别
	 */
	private UserGenderEnum gender;

	/**
	 * 身份证号码
	 */
	private String identificationNumber;

	/**
	 * 籍贯
	 */
	private String nativePlace;

	/**
	 * 联系电话
	 */
	private String concatNumber;

	/**
	 * 政治面貌
	 */
	private PoliticalOutlookEnum politicalOutlook;

	/**
	 * 本科毕业学校
	 */
	private String undergraduateSchool;

	/**
	 * 本科毕业专业
	 */
	private String undergraduateMajor;

	/**
	 * 硕士毕业学校
	 */
	private String masterGraduateSchool;

	/**
	 * 硕士毕业专业
	 */
	private String masterGraduateMajor;

	/**
	 * 入职状态
	 */
	private TeacherJobStatusEnum jobStatus;

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

}

package org.springblade.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springblade.common.entity.BaseEntity;
import org.springblade.modules.system.enums.EducationLevelEnum;
import org.springblade.modules.system.enums.PoliticalOutlookEnum;
import org.springblade.modules.system.enums.StudentStatusEnum;
import org.springblade.modules.system.enums.UserGenderEnum;

import java.io.Serializable;

/**
 * 学生信息表
 *
 * @author Jover Zhang
 */
@Data
@Accessors(chain = true)
@TableName(value = "student")
@EqualsAndHashCode(callSuper = true)
public class Student extends BaseEntity implements Serializable {

    private Long userId;

    private Long classId;

    private String studentCode;


    // 详细信息

    /**
     * 学生姓名
     */
    private String name;

    /**
     * 性别
     */
    private UserGenderEnum gender;

    /**
     * 姓名拼音
     */
    private String pinyinName;

    /**
     * 准考证号
     */
    private String admissionTicketNumber;

    /**
     * 出生日期
     */
    private String birthDate;

    /**
     * 民族
     */
    private String nationality;

    /**
     * 学制
     */
    private String schoolYear;

    /**
     * 学籍状态
     */
    private StudentStatusEnum studentStatus;

    /**
     * 年级
     */
    private String grade;

    /**
     * 照片
     */
    private String image;

    /**
     * 入学日期
     */
    private String enrollmentDate;

    /**
     * 考生类别
     */
    private String candidateCategory;

    /**
     * 原毕业学校
     */
    private String graduatedSchool;

    /**
     * 入学方式
     */
    private String enrollmentWay;

    /**
     * 办学形式
     */
    private String schoolForm;

    /**
     * 培养层次
     */
    private EducationLevelEnum educationLevel;

    /**
     * 生源所在地
     */
    private String originPlace;

    /**
     * 籍贯
     */
    private String nativePlace;

    /**
     * 出生地
     */
    private String birthPlace;

    /**
     * 家庭地址
     */
    private String address;

    /**
     * 邮政编码
     */
    private String postCode;

    /**
     * 宅电
     */
    private String homePhone;

    /**
     * 个人电话
     */
    private String phoneNumber;

    /**
     * 政治面貌
     */
    private PoliticalOutlookEnum politicalOutlook;

    /**
     * 健康状况
     */
    private String healthy;

    /**
     * 特长
     */
    private String hobby;

    /**
     * 身份证号
     */
    private String identificationNumber;

    /**
     * 宿舍号
     */
    private String dormitoryNumber;

    /**
     * 学习年限
     */
    private String learningTime;

    /**
     * 入学总分
     */
    private String enrollmentScore;

    /**
     * 备注
     */
    private String remark;

    /**
     * 学生类别
     */
    private String studentType;

    /**
     * 校区
     */
    private String campus;

    /**
     * e_mail
     */
    private String email;

    /**
     * 目的火车站
     */
    private String station;

    /**
     * 考生号
     */
    private String candidateNumber;

    /**
     * QQ号码
     */
    private String qq;

    /**
     * 入学年份
     */
    private String enrollmentYear;

    /**
     * 学科大类
     */
    private String subjectType;

    /**
     * 学科
     */
    private String subject;

    /**
     * 国际专业代码
     */
    private String nationMajorCode;

    /**
     * 专业培养层次
     */
    private String majorTrainingLevel;

    /**
     * 其他办学形式
     */
    private String otherSchoolForm;

    /**
     * 生源身份
     */
    private String originIdentity;

    /**
     * 毕业类别
     */
    private String graduateType;

    /**
     * 联系人
     */
    private String concatName;

    /**
     * 入党团日期
     */
    private String joinDate;

    /**
     * 招生季节
     */
    private String admissionSeason;

    /**
     * 入学文化程度
     */
    private String enrollmentEducationLevel;

    /**
     * 主修外语语种
     */
    private String foreignLanguage;

    /**
     * 学习形式
     */
    private String learningWay;

    /**
     * 办学类型
     */
    private String schoolFormType;

    /**
     * 培养对象
     */
    private String nourishObject;

    /**
     * 录取专业
     */
    private String admissionMajor;

    /**
     * 学校代码
     */
    private String schoolCode;

    /**
     * 是否报到
     */
    private String checkIn;

    /**
     * 联系电话
     */
    private String concatPhone;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}

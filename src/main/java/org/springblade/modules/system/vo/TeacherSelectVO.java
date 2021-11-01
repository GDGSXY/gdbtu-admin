package org.springblade.modules.system.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Jover Zhang
 * @date 2021/11/1
 */
@Data
@Accessors(chain = true)
public class TeacherSelectVO {

    private Long id;

    private String name;

}

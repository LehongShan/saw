package cn.shan.saw.auth.model.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色与部门对应关系
 * </p>
 *
 * @author shanlehong
 * @since 2018-03-07
 */
@Data
@Accessors(chain = true)
public class SysRoleDept implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 部门ID
     */
    private Long deptId;


}

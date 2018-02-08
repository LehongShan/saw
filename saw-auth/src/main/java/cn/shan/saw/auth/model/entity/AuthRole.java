package cn.shan.saw.auth.model.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author shanlehong
 * @since 2018-02-07
 */
@Data
@Accessors(chain = true)
public class AuthRole implements Serializable {

    private static final long serialVersionUID = 1L;

    private String authRoleId;
    /**
     * 角色名称
     */
    private String name;


}

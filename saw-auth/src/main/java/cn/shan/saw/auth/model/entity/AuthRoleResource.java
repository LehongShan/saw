package cn.shan.saw.auth.model.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
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
 * @since 2018-02-09
 */
@Data
@Accessors(chain = true)
public class AuthRoleResource implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId
    private String authRoleResourceId;
    private String authRoleId;
    private String authResourceId;


}

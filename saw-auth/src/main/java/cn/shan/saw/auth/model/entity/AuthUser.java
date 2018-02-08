package cn.shan.saw.auth.model.entity;

import java.util.Date;
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
public class AuthUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String authUserId;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 创建ID
     */
    private String createrId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新者ID
     */
    private String updaterId;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 版本
     */
    private Integer version;
    /**
     * 删除标识 0未删除 1已删除
     */
    private Integer deleteFlag;
    /**
     * 备注
     */
    private String remark;


}

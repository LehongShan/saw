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
 * 部门管理
 * </p>
 *
 * @author shanlehong
 * @since 2018-03-07
 */
@Data
@Accessors(chain = true)
public class SysDept implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "dept_id", type = IdType.AUTO)
    private Long deptId;
    /**
     * 上级部门ID，一级部门为0
     */
    private Long parentId;
    /**
     * 部门名称
     */
    private String name;
    /**
     * 排序
     */
    private Integer orderNum;
    /**
     * 是否删除  -1：已删除  0：正常
     */
    private Integer delFlag;


}

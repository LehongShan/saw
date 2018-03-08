package cn.shan.saw.auth.model.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 定时任务
 * </p>
 *
 * @author shanlehong
 * @since 2018-03-07
 */
@Data
@Accessors(chain = true)
public class ScheduleJob implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 任务id
     */
    @TableId(value = "job_id", type = IdType.AUTO)
    private Long jobId;
    /**
     * spring bean名称
     */
    private String beanName;
    /**
     * 方法名
     */
    private String methodName;
    /**
     * 参数
     */
    private String params;
    /**
     * cron表达式
     */
    private String cronExpression;
    /**
     * 任务状态  0：正常  1：暂停
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建时间
     */
    private Date createTime;


}

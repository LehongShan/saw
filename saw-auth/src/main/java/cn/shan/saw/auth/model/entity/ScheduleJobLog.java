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
 * 定时任务日志
 * </p>
 *
 * @author shanlehong
 * @since 2018-03-07
 */
@Data
@Accessors(chain = true)
public class ScheduleJobLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 任务日志id
     */
    @TableId(value = "log_id", type = IdType.AUTO)
    private Long logId;
    /**
     * 任务id
     */
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
     * 任务状态    0：成功    1：失败
     */
    private Integer status;
    /**
     * 失败信息
     */
    private String error;
    /**
     * 耗时(单位：毫秒)
     */
    private Integer times;
    /**
     * 创建时间
     */
    private Date createTime;


}

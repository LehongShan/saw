package cn.shan.saw.auth.service.impl;

import cn.shan.saw.auth.model.entity.ScheduleJobLog;
import cn.shan.saw.auth.mapper.ScheduleJobLogMapper;
import cn.shan.saw.auth.service.ScheduleJobLogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 定时任务日志 服务实现类
 * </p>
 *
 * @author shanlehong
 * @since 2018-03-07
 */
@Service
public class ScheduleJobLogServiceImpl extends ServiceImpl<ScheduleJobLogMapper, ScheduleJobLog> implements ScheduleJobLogService {

}

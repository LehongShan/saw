package cn.shan.saw.auth.service.impl;

import cn.shan.saw.auth.model.entity.ScheduleJob;
import cn.shan.saw.auth.mapper.ScheduleJobMapper;
import cn.shan.saw.auth.service.ScheduleJobService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 定时任务 服务实现类
 * </p>
 *
 * @author shanlehong
 * @since 2018-03-07
 */
@Service
public class ScheduleJobServiceImpl extends ServiceImpl<ScheduleJobMapper, ScheduleJob> implements ScheduleJobService {

}

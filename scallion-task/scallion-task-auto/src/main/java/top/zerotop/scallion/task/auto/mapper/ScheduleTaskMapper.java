package top.zerotop.scallion.task.auto.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.zerotop.scallion.task.auto.entity.ScheduleTask;

import java.util.List;

@Mapper
@Repository
public interface ScheduleTaskMapper {
    List<ScheduleTask> listAll();
}

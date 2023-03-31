package top.zerotop.scallion.task.common.config;

import org.quartz.Scheduler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class QuartzConfiguration {
    @Bean
    public Scheduler scheduler() {
        return schedulerFactory().getScheduler();
    }

    @Bean
    public SchedulerFactoryBean schedulerFactory() {
        SchedulerFactoryBean schedulerFactory = new SchedulerFactoryBean();
        schedulerFactory.setTaskExecutor(taskExecutor());
        return schedulerFactory;
    }

    private Executor taskExecutor() {
        int poolSize = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(poolSize,
                                                                poolSize * 2,
                                                                5,
                                                                TimeUnit.MINUTES,
                                                                new ArrayBlockingQueue<>(1024));
        return poolExecutor;
    }
}

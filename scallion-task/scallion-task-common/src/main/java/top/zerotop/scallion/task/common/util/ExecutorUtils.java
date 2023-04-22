package top.zerotop.scallion.task.common.util;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorUtils {
    /**
     * 生成线程池
     * @return
     */
    public static ExecutorService generateExecutorService() {
        int corePoolSize = Runtime.getRuntime().availableProcessors();
        return new ThreadPoolExecutor(corePoolSize,
                corePoolSize * 2,
                30,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1024));
    }
}

package com.radkoff26.springchatasynctask.async;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class AsyncTaskExecutor {
    private final BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
    private final ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(512, 512, 10_000, TimeUnit.MILLISECONDS, queue);

    public void executeTask(Runnable runnable) {
        poolExecutor.execute(runnable);
    }
}

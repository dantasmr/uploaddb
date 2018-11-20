package com.upload.db.uploaddb.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

@Service
public class AsynchronousService {
	
    @Autowired
    private ApplicationContext applicationContext;
    
    @Autowired
    private TaskExecutor taskExecutor;
    
    public void executeAsynchronously(String name) {
    	ImgThread ImgThread = applicationContext.getBean(ImgThread.class);
    	ImgThread.setName(name);
        taskExecutor.execute(ImgThread);
    }
}
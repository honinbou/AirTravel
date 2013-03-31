package com.itcast.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolManager {
	private ExecutorService service;
	
	private ThreadPoolManager(){
		int num = Runtime.getRuntime().availableProcessors();
		//创建CPU核数的双倍的线程
		service = Executors.newFixedThreadPool(num*2);
	}
//单例设计模式
	private static final ThreadPoolManager manager= new ThreadPoolManager();
	
	public static ThreadPoolManager getInstance(){
		return manager;
	}
	
	public void addTask(Runnable runnable){
		//线程池执行线程
		service.execute(runnable);
	}
}

package com.itcast.vo;

import java.util.HashMap;

import com.itcast.parser.BaseParser;

import android.content.Context;
/**
 * 1，请求url
 * 2.上下文
 * 3，请求数据的map
 * 4.json解析器集合
 * @author Wiper
 *
 */


public class RequestVo {
	//请求url
	public int requestUrl;
	public Context context;
	//是否用dopost方式请求
	public boolean doPost ;
	public HashMap<String,String> requestDataMap;
	//抽象类，要每个activity实现
	public BaseParser<?> jsonParser;
	
	public RequestVo() {
		// TODO Auto-generated constructor stub
	}
	public RequestVo(int requestUrl, Context context, boolean doPost,
			HashMap<String, String> requestDataMap, BaseParser<?> jsonParser) {
		super();
		this.requestUrl = requestUrl;
		this.context = context;
		this.doPost = doPost;
		this.requestDataMap = requestDataMap;
		this.jsonParser = jsonParser;
	}
	
	
	
}

package com.itcast.parser;

import org.json.JSONException;
import org.json.JSONObject;
/**
 * 
 * 解析器父类
 * @author Wiper
 *
 * @param <T>
 */
public abstract class BaseParser<T> {
	
	 public abstract T parseJSON(String paramString) throws JSONException;
	 
	 /**
	  * 
	  * @param res
	 * @throws JSONException 
	  */
	 public String checkResponse(String paramString) throws JSONException{
		if(paramString==null){ 
			return null;
		}else{
			//创建一个JSONObject封装服务端传回来的参数
			JSONObject jsonObject = new JSONObject(paramString);
			//获取回应信息
			String result = jsonObject.getString("response");
			if(result!=null && !result.equals("error")){
				return result;
			}else{
				return null;
			}
			
		}
	 }
}

package com.itcast.parser;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.itcast.vo.UserLogin;

public class UserLoginParser extends BaseParser<UserLogin> {

	@Override
	public UserLogin parseJSON(String paramString) throws JSONException {
		// TODO Auto-generated method stub
		
//		{
//		    "Meta": {
//		        "Code": null,
//		        "Message": null,
//		        "Method": "UserLogin",
//		        "Status": "ok"
//		    },
//		    "Page": null,
//		    "Response": {
//		        "ClientIp": "127.0.0.1",                       //客户端IP
//		        "Guid": "e3f3296f-6bc6-45bb-9802-e8026cdd188c",//用户唯一性标志
//		        "Tid": 1109043,                                //用户Id
//		        "UserName": "ceshi_b2c",
//		        "UserPwd": "123456"
//		    }
//		}
		UserLogin userLogin = new UserLogin();
		JSONObject jo = new JSONObject(paramString);
		jo = jo.getJSONObject("Response");
		userLogin.setClientIp(jo.getString("ClientIp"));
		userLogin.setGuid(jo.getString("Guid"));
		userLogin.setTid(jo.getString("Tid"));
		userLogin.setUserName(jo.getString("UserName"));
		userLogin.setUserPwd(jo.getString("UserPwd"));
		
		return userLogin;
	}

}

package com.itcast.activity;

import java.util.HashMap;

import com.itcast.R;
import com.itcast.parser.UserLoginParser;
import com.itcast.vo.RequestVo;
import com.itcast.vo.UserLogin;

import android.view.View;
import android.widget.TextView;

public class LoginActivity extends BaseActivity {
	TextView tv_userloginmsg_userlogin = null;
	@Override
	protected void onClickEvent(View paramView) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void findViewById() {
		// TODO Auto-generated method stub
		tv_userloginmsg_userlogin = (TextView) findViewById(R.id.tv_userloginmsg_userlogin);
		

	}

	@Override
	protected void loadViewLayout() {
		// TODO Auto-generated method stub
		setContentView(R.layout.layout_userlogin);

	}

	@Override
	protected void processLogic() {
		// TODO Auto-generated method stub
		
		HashMap<String,String> request  = new HashMap<String, String>();
		request.put("ClientId", "m_b2c_001");
		request.put("SafeCode", "");
		request.put("UserName", "18611722236");
		request.put("UserPwd", "123456");
		RequestVo vo = new RequestVo();
		vo.requestUrl = R.string.http_get_login;
		vo.context = context;
		vo.jsonParser = new UserLoginParser();
		vo.doPost = true;
		vo.requestDataMap = request;
		//18611722236 123456
		//从服务端获取数据，传入VO和回调类
		getDataFromServer(vo, new DataCallback<UserLogin>() {

			@Override
			public void processData(
					UserLogin paramObject,
					boolean paramBoolean) {
				tv_userloginmsg_userlogin.setText(paramObject.toString());
			}
		});
	}

	@Override
	protected void setListener() {
		// TODO Auto-generated method stub

	}

}

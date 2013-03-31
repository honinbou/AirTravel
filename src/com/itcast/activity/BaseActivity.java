package com.itcast.activity;

import com.itcast.R;
import com.itcast.util.CommonUtil;
import com.itcast.util.Constant;
import com.itcast.util.NetUtil;
import com.itcast.util.ThreadPoolManager;
import com.itcast.vo.RequestVo;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public abstract class BaseActivity extends Activity implements
		View.OnClickListener {
	protected int activityCase;
	private ImageView tool;
	private ImageView home;
	private ImageView more;
	protected ProgressDialog progressDialog;
	private ImageView search;
	private ImageView shopCar;
	protected TextView textShopCarNum; 
	protected Context context;
	private ThreadPoolManager threadPoolManager;
	
	public BaseActivity() {
		threadPoolManager = ThreadPoolManager.getInstance();
	}
	/**
	 * Android生命周期回调方法-创建
	 */
	@Override
	public void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		//全屏设定
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		//获取上下文
		context = getApplicationContext();
		//初始化界面
		initView();
	}

	/**
	 * 初始化界面
	 */
	private void initView() {
		loadViewLayout();
		//是否装载底部条
		if (isLoadBottomTab()) {
			loadBottomTab();
			//点击了以后转向activity，更换底部条的颜色
			selectedBottomTab(Constant.defaultIndex);
		}
		//三个抽象的方法，让activity子类实现，
		//寻找view
		findViewById();
		//设定监听器
		setListener();
		//向后台请求数据
		processLogic();
	}
	
	/**
	 *activity主线程处理数据
	 *初始化handler的时候要传入上下文菜单还有回调对象
	 * @author Mathew
	 *BaseHandler
	 */
	@SuppressWarnings("unchecked")
	class BaseHandler extends Handler{
		private Context context;
		private DataCallback callBack;
		private RequestVo reqVo;

		public BaseHandler(Context context, DataCallback callBack,
				RequestVo reqVo) {
			//上下文
			this.context = context;
			//网络回调
			this.callBack = callBack;
			//请求体（包含请求对象）
			this.reqVo = reqVo;
			
		}
		
		public void handleMessage(Message msg){ 
			closeProgressDialog();
			if(msg.what==Constant.SUCCESS){
				if(msg.obj==null){
					// 传入参数错误，显示对话框
					CommonUtil.showInfoDialog(context, getString(R.string.net_error));
				}else{
					//处理数据
					callBack.processData(msg.obj, true);
				}
			}else if(msg.what==Constant.NET_FAILED){
				// 返回网络错误，显示对话框
				CommonUtil.showInfoDialog(context, getString(R.string.net_error));
			}
		}
	}
	
	
	class BaseTask implements Runnable{
		private Context context;
		private RequestVo reqVo;
		private Handler handler;

		public BaseTask(Context context, RequestVo reqVo, Handler handler) {
			this.context = context;
			this.reqVo = reqVo;
			this.handler = handler;
		}
		
		@Override
		public void run() {
			Object obj = null;
			Message msg = new Message();
			if(NetUtil.hasNetwork(context)){
				if(reqVo.doPost){
					obj = NetUtil.post(reqVo);
				}else {
					obj = NetUtil.get(reqVo);
				}
				msg.what = Constant.SUCCESS;
				msg.obj = obj;
				handler.sendMessage(msg);
			}else{
				msg.what = Constant.NET_FAILED;
				msg.obj = obj;
				handler.sendMessage(msg);
			}
		}
		
	}

	/**
	 * 初始化底部条控件
	 */
	private void loadBottomTab() {
//		this.home = (ImageView) findViewById(R.id.imgHome);
//		this.classify = (ImageView) findViewById(R.id.imgClassify);
//		this.search = (ImageView) findViewById(R.id.imgSearch);
//		this.shopCar = (ImageView) findViewById(R.id.imgShoppingCar);
//		this.more = (ImageView) findViewById(R.id.imgMore);
//		this.textShopCarNum = (TextView) findViewById(R.id.textShopCarNum);
//		this.home.setOnClickListener(this);
//		this.classify.setOnClickListener(this);
//		this.search.setOnClickListener(this);
//		this.shopCar.setOnClickListener(this);
//		this.more.setOnClickListener(this);
	}

	/**
	 * tab条图片切换
	 * 
	 * @param paramViewId
	 */
	protected void selectedBottomTab(int paramViewId) {
//		this.home.setBackgroundResource(R.drawable.bar_home_normal);
//		this.classify.setBackgroundResource(R.drawable.bar_class_normal);
//		this.search.setBackgroundResource(R.drawable.bar_search_normal);
//		this.shopCar.setBackgroundResource(R.drawable.bar_shopping_normal);
//		this.more.setBackgroundResource(R.drawable.bar_more_normal);
//		switch (paramViewId) {
//		case Constant.HOME:
//			this.home.setBackgroundResource(R.drawable.bar_home_selected);
//			Constant.defaultIndex = Constant.HOME;
//			break;
//		case Constant.CLASSIFY:
//			this.classify.setBackgroundResource(R.drawable.bar_class_selected);
//			Constant.defaultIndex = Constant.CLASSIFY;
//			break;
//		case Constant.SEARCH:
//			this.search.setBackgroundResource(R.drawable.bar_search_selected);
//			Constant.defaultIndex = Constant.SEARCH;
//			break;
//		case Constant.SHOPCAR:
//			this.shopCar
//					.setBackgroundResource(R.drawable.bar_shopping_selected);
//			Constant.defaultIndex = Constant.SHOPCAR;
//			break;
//		case Constant.MORE:
//			this.more.setBackgroundResource(R.drawable.bar_more_selected);
//			Constant.defaultIndex = Constant.MORE;
//			break;
//		}
	}
	

	/**
	 * 是否加载底部tab
	 * 如果不需要请重写方法
	 * @return
	 */
	protected Boolean isLoadBottomTab() {
		return true;
	}

	/**
	 * 
	 * 回调接口
	 * @author Wiper
	 *
	 * @param <T>
	 */
	public abstract interface DataCallback<T> {
		//传入的是OBject参数，例如是返回的list数据，要放入adapter里面
		public abstract void processData(T paramObject,
				boolean paramBoolean);
	}
	
	
	/**
	 * 从服务器上获取数据，并回调处理
	 * @param reqVo
	 * @param callBack
	 */
	protected void getDataFromServer(RequestVo reqVo, DataCallback callBack) {
		showProgressDialog();
		BaseHandler handler = new BaseHandler(this, callBack, reqVo);
		BaseTask taskThread = new BaseTask(this, reqVo, handler);
		this.threadPoolManager.addTask(taskThread);
	}
	
	/**
	 * 显示正在更新数据的提示框
	 */
	protected void showProgressDialog() {
		if ((!isFinishing()) && (this.progressDialog == null)) {
			this.progressDialog = new ProgressDialog(this);
		}
		this.progressDialog.setTitle(getString(R.string.loadTitle));
		this.progressDialog.setMessage(getString(R.string.LoadContent));
		this.progressDialog.show();
	}
	
	
	/**
	 * 总体的点击事件
	 */
	public void onClick(View paramView) {
		//出发点击底部点击事件,如果不是底部点击时间，则传递到子类实现的onclickEvent中
		if (!onClickBottmBarEvent(paramView))
			onClickEvent(paramView);
	}
	
	
	/**
	 * 响应底部tab点击事件
	 * 
	 * @param paramView
	 * @return
	 */
	private boolean onClickBottmBarEvent(View paramView) {
		return false;
//		boolean isBar = true;
//		Intent intent = new Intent();
//		switch (paramView.getId()) {
//		case R.id.toolBar_search: {
//			intent.setClass(this, HomeActivity.class);
//			intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
//			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//			Log.e("TAB1", "Home");
//			startActivity(intent);
//		}
//			break;
//		case R.id.toolBar_ordermanager: {
//			intent.setClass(this, HomeActivity.class);
//			Log.e("TAB2", "Classify");
//			startActivity(intent);
//		}
//			break;
//		case R.id.toolBar_traveler: {
//			intent.setClass(this, HomeActivity.class);
//			Log.e("TAB3", "Search");
//			startActivity(intent);
//		}
//			break;
//		case R.id.toolBar_mytraverse: {
//			intent.setClass(this, HomeActivity.class);
//			Log.e("TAB4", "ShoppingCar");
//			startActivity(intent);
//		}
//			break;
//		
//		default:
//			isBar = false;
//			Log.e("TAB6", "DEFAULT");
//			break;
//		}
//		return isBar;
	}

	/**
	 * 关闭正在更新数据的提示框
	 */
	protected void closeProgressDialog() {
		if (this.progressDialog != null)
			this.progressDialog.dismiss();
	}
	
	/**
	 * 自己实现的点击事件
	 * @param paramView
	 */
	protected abstract void onClickEvent(View paramView);
	
	/**
	 * 
	 */
	protected abstract void findViewById();

	/**
	 * 
	 */
	protected abstract void loadViewLayout();

	/**
	 * 向后台请求数据
	 */
	protected abstract void processLogic();

	/**
	 * 
	 */
	protected abstract void setListener();

}

package com.meishixing.crazysight.location;

import android.content.*;
import android.app.*;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.meishixing.crazysight.CrazySightApplication;
import com.meishixing.crazysight.R;
import com.meishixing.crazysight.util.*;

public class BaiduLocationProxy implements BDLocationListener{

	private final static String 		TAG = BaiduLocationProxy.class.getSimpleName();
	private LocationClient 				mLocClient;
	private	MSXLocationListener 		msxListener;
	private	Context						context;

	public BaiduLocationProxy(Context context){
		this.context = context.getApplicationContext();
		mLocClient = new LocationClient(context);
		LocationClientOption option = new LocationClientOption();
		option.setProdName(context.getString(R.string.app_name));
		option.setCoorType("gcj02");
		option.setOpenGps(true);
		option.disableCache(true);
		option.setAddrType("all");
		mLocClient.setLocOption(option);
	}

	public void startListening(MSXLocationListener msxListener){
		this.msxListener = msxListener;
		if(mLocClient!= null && !mLocClient.isStarted()){
			mLocClient.registerLocationListener(this);
			mLocClient.start();
		}
		mLocClient.requestLocation();
	}

	public void stopListening(){
		mLocClient.unRegisterLocationListener(this);
		mLocClient.stop();
		this.msxListener = null;	
	}

	@Override
	public void onReceiveLocation(BDLocation location) {
		if (location == null || msxListener == null) return ;
		int errorCode = location.getLocType();
		if(errorCode >= 162){
			msxListener.enableMyLocation();
		} else {
            ((CrazySightApplication)context.getApplicationContext()).mBaiduLocation = location;
			msxListener.onLocationChanged(location);
			msxListener.disableMyLocation();
            context.sendBroadcast(new Intent(ReceiverManager.ACTION_LOCATION_CHANGED));
		}
		
	}

	@Override
	public void onReceivePoi(BDLocation localtion) {
		return;
	}

}

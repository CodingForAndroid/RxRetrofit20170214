package mvp.jorge.com.rxretrofit20170214;
//
//import com.womai.service.bean.MoreActivity;
//import com.womai.service.bean.ROMoreActivityList;

import java.util.List;
import java.util.Map;

/**
 * 获取全局变量
 * 
 * @author xiangming
 * 
 */
public interface IGlobal {
	// head
	// get================================================================================================
	
	public String getLoginName();
		
	public String getUdid();

	public String getOs();

	public String getOsVersion();

	public String getAppVersion();

	public String getSourceId();

	public String getVer();

	public String getTest();

	public String getHeight();

	public String getWidth();

	public String getUnique();

	public String getLevel();

	/**
	 * 获取设备信息
	 * @return
     */
	public String getDeviceModel();

	// common
	// get================================================================================================
	public String getMid();

	public String getUserId();

	public String getUserSession();

	public String getTest1();

	/**
	 * 获取登录类型 0：正常网站注册用户登录，1：联合登录用户
	 * 
	 * @return
	 */
	public int getLoginType();
	
	/**
	 * 获取绑定手机
	 * @return
	 */
	public String getBindingPhone();

	// head
	// get================================================================================================

	public void setLoginName(String _loginName);
	
	public void setHeight(String _height);

	public void setWidth(String _width);

	public void setUnique(String _unique);

	public void setLevel(String _level);

	// common
	// get================================================================================================
	public void setMid(String _mid);

	public void setUserId(String _userId);

	public void setUserSession(String _userSession);

	public void setTest1(String _test1);
	
	/**
	 * 设置绑定的手机
	 * @param _phone
	 */
	public void setBindingPhone(String _phone);

	/**
	 * 设置登录类型 0：正常网站注册用户登录，1：联合登录用户
	 * 
	 * @param _loginType
	 */
	public void setLoginType(int _loginType);

	/**
	 * 设置纬度
	 * 
	 * @param latitude
	 */
	public void setLatitude(String latitude);

	/**
	 * 得到纬度
	 */
	public String getLatitude();

	/**
	 * 设置经度
	 * 
	 * @param longitude
	 */
	public void setLongitude(String _longitude);

	/**
	 * 得到经度
	 */
	public String getLongitude();
	
	/**
	 * 获取百度cps
	 */
	public String getCpsKey();

	/**
	 * 设置手机mac地址
	 * 
	 * @param mac
	 */
	public void setMac(String _mac);
	/**
	 * 得到手机mac地址
	 * @return
	 */
	public String getMac();
	
	/**
	 * 设置androidId
	 * @param _androidId
	 */
	public void setAndroidId(String _androidId);
	
	/**
	 * 得到androidId
	 */
	public String getAndroidId();

	//
	public String getRSA();

	public String getJsessionId();

	public void setRSA(String _rsa);

	public void setJsessionId(String _jsessionId);

	public String getReferPage();

	public void setReferPage(String _referPage);

	// 秒杀定时提醒处理函数=========
	public Map<String, Long> getMeskillProductIds();

	public void saveMeskillProductIds();

	public boolean includeMeskillProductId(String id);

	public void delMeskillProductId(String id);

	public void putMeskillProductId(String _key, long _value);
	// 秒杀定时提醒处理函数=========
	
	//更多活动列表 ：如滴滴打车等
	//===========================================================================
//	public List<MoreActivity> getMoreActivityList();
//	public void setMoreActivityList(ROMoreActivityList roMoreActivityList);
	/**
	 * 设置是否显示在线充值入口
	 * 1：表示可以上线，0或者没有表示下线
	 * @param status
	 */
	public void setOnlineChargeMark(String status);
	/**
	 * 设置是否显示积分充值入口
	 * 1：表示可以上线，0或者没有表示下线
	 * @param status
	 */
	public void setIntegrationLuckDraw(String status);
	/**
	 * 得到是否显示积分充值入口
	 * 1：表示可以上线，0或者没有表示下线
	 */
	public String getIntegrationLuckDraw();
	
	/**
	 * 得到是否显示在线充值状态
	 * 1：表示可以上线，0或者没有表示下线
	 * @return
	 */
	public String getOnlineChargeMark();
	
	/**
	 * 是否处理商品售空 true 为app需要进行售罄处理；false为前置机已经做了售罄处理，app不需要处理
	 * 
	 * @param isSellOut
	 */
	public void setIsDellSellOut(boolean isSellOut);

	/**
	 * 是否处理商品售空 true 为app需要进行售罄处理；false为前置机已经做了售罄处理，app不需要处理
	 */
	public boolean getIsDellSellOut();
	
	/**
	 * 设置UnionId
	 * @param unionId
	 */
	public void setWXUnionId(String unionId);
	
	/**
	 * 获取UnionId
	 * @return
	 */
	public String getWXUnionId();
	
	
	/**
	 * 保存openId
	 * @param openId
	 */
	public void setWXOpenId(String openId);
	
	/**
	 * 获取openId
	 * @return
	 */
	public String getWXOpenId();

	/**
	 * 设置选中的城市
	 */
	public void setSelectedCity(String city);

	/**
	 * 获取选中城市
	 */
	public String getSelectCity();

	/**
	 * 设置选中城市ID
	 */
	public void setSelectedCityId(String cityid);

	/**
	 * 设置选中城市
	 */
	public String getSelectCityId();

	/**
	 * 是否设置过支付密码
	 * @param hasPayPassword
	 * @return
     */
	public void setHasPayPassword(boolean hasPayPassword);

	public boolean getHasPayPassword();

	/**
	 *  输入的我买卡支付金额
	 * @param price
     */
	public void setWmCardInputValue(String price);

	/**
	 * 获取我买卡输入的支付金额
	 * @return
     */
	public String getWmCardInputValue();
}

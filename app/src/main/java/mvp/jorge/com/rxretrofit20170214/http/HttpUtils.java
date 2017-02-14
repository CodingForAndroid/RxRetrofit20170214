package mvp.jorge.com.rxretrofit20170214.http;

import android.annotation.SuppressLint;

import com.womai.service.IGlobal;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class HttpUtils {
//	请求地址:http://wapi.m.womai.com/login.action
//	请求头信息:
//	{"userId":"","height":"2048","Accept-Encoding":"gzip","width":"1536","udid":"00000000000","longitude":"116.429463","latitude":"39.906567","test":"mwomai01","unique":"4edeea1a6e7891af3ab22f707612b8d2","mipSourceId":"1002","deviceModel":"Xiaomi|MI PAD","osVersion":"4.4.4","imei":"00000000000","os":"2","appVersion":"3.4.1","cpsKey":"","level":"","sourceId":"2024","time":"2017-02-14 16:33:29","ver":"1.0"}
//	请求参数:
//	{"data":{"password":"aaa123456","userName":"18611445571"},"common":{"userId":"","test1":"","userSession":"","mid":"0","cityCode":"31000"}}
//	请求开始时间:
//			2017 02-14 16:33:29 0239
//	HttpCode:200
//	请求结束时间:
//			2017 02-14 16:33:29 0294
//	请求花费时间(秒):
//			0.055
//	服务器CODE:00
//	服务器MESSAGE:操作成功！
//	服务器数据:
//	{"userid":"71339042","usersession":"d9715d4307abfe93334def28316ca385","sendcouponcard":{"message":"欢迎使用手机我买网","isshow":"false"},"test1":"03984a54a506a7b011c475ee6ab18a70"}
//	02-14 16:33:29.475 15336-15336/? I/TDLOG: onLogin called --> account is 71339042

	public static IGlobal global = null;

	/**
	 * 获取用户相关接口的commom对象
	 * 
	 * @return
	 */
	private static Map<String, String> getUserCommon() {
		Map<String, String> common = new ConcurrentHashMap<String, String>();
		common.put("mid", global.getMid());
		common.put("userId", global.getUserId());
		common.put("userSession", global.getUserSession());
		common.put("test1", global.getTest1());
		common.put("cityCode", global.getSelectCityId());
		return common;
	}

	/**
	 * 获取用户非相关接口commom对象
	 * 
	 * @return
	 */
	private static Map<String, String> getNoUserCommon() {
		Map<String, String> common = new ConcurrentHashMap<String, String>();
		common.put("mid", "0");
		common.put("userId", "");
		common.put("userSession", "");
		common.put("test1", "");
		common.put("cityCode", "31000");
		return common;
	}

	/**
	 * 获取header
	 * 
	 * @param
	 */
	@SuppressLint("SimpleDateFormat")
	public static Map<String, String> getHeader() {
		Map<String, String> header = new ConcurrentHashMap<String, String>();
		header.put("userId", ""); // 用户id
		header.put("udid", "00000000000");// 客户端唯一性标示
		header.put("os", "2");// 操作系统名称
		header.put("osVersion", "4.4.4");// 操作系统版本
		header.put("appVersion", "3.4.1");// APP 版本
		header.put("sourceId", "2024");// 推广id
		header.put("ver", "1.0");// 通讯协议版本
		header.put("test", "mwomai01");// 客户端唯一性标示
		header.put("height", "2048");
		header.put("width", "1536");
		header.put("unique", "4edeea1a6e7891af3ab22f707612b8d2");
		header.put("level", "");
		header.put("Accept-Encoding", "gzip");
		header.put("latitude", "39.906567");
		header.put("longitude", "116.429463");
		header.put("imei", "00000000000");
		header.put("cpsKey", "");
		header.put("mipSourceId", "1002");
		header.put("deviceModel","Xiaomi|MI PAD");
		header.put("time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));// 间戳(新增)yyyymmddSS
		return header;
	}

	/**
	 * 获取缓存的header
	 * 
	 * @param conn
	 */
	@SuppressLint("SimpleDateFormat")
	public static Map<String, String> getCacheHeader() {
		Map<String, String> header = new ConcurrentHashMap<String, String>();
		header.put("userId", global.getUserId()); // 用户id
		header.put("udid", global.getUdid());// 客户端唯一性标示
		header.put("os", global.getOs());// 操作系统名称
		header.put("osVersion", global.getOsVersion());// 操作系统版本
		header.put("appVersion", global.getAppVersion());// APP 版本
		header.put("sourceId", global.getSourceId());// 推广id
		header.put("ver", global.getVer());// 通讯协议版本
		header.put("test", global.getTest());// 客户端唯一性标示
		header.put("height", global.getHeight());
		header.put("width", global.getWidth());
		header.put("level", global.getLevel());
		header.put("mipSourceId", "1002");
		header.put("deviceModel",global.getDeviceModel());
		return header;
	}

	/**
	 * 获取用户相关接口的请求对象
	 * 
	 * @param data
	 * @return
	 */
	public static Map<String, Object> getUserRequestMap(Map<String, Object> data) {
		Map<String, Object> DATA = new HashMap<String, Object>();
		if (data != null) {
			DATA.put("data", data);
		}
		DATA.put("common", HttpUtils.getUserCommon());
		return DATA;
	}

	/**
	 * 获取非用户相关接口的请求对象
	 * 
	 * @param data
	 * @return
	 */
	public static Map<String, Object> getNoUserRequestMap(Map<String, Object> data) {
		Map<String, Object> DATA = new HashMap<String, Object>();
		if (data != null) {
			DATA.put("data", data);
		}
		DATA.put("common", HttpUtils.getNoUserCommon());
		return DATA;
	}

	/**
	 * 获取map的字符串连接
	 * 
	 * @param map
	 * @return
	 */
	public static String getMapString(Map<String, String> map) {
		try {
			StringBuffer params = new StringBuffer();
			if (map != null) {
				for (Iterator<Entry<String, String>> iter = map.entrySet().iterator(); iter.hasNext();) {
					Entry<String, String> element = (Entry<String, String>) iter.next();
					params.append(element.getKey().toString());
					params.append("=");
					params.append(element.getValue().toString());
					params.append("&");
				}
				if (params.length() > 0) {
					params = params.deleteCharAt(params.length() - 1);
				}
			}
			return params.toString();
		} catch (Exception e) {
			ServiceLog.e(e);
			return null;
		}
	}

	/**
	 * map 转 字符串(带编码的)
	 * 
	 * @param map
	 * @return
	 */
	public static String getMapEncodeString(Map<String, String> map, String encode) {
		try {
			StringBuffer params = new StringBuffer();
			if (map != null) {
				for (Iterator<Entry<String, String>> iter = map.entrySet().iterator(); iter.hasNext();) {
					Entry<String, String> element = (Entry<String, String>) iter.next();
					params.append(element.getKey().toString());
					params.append("=");
					params.append(URLEncoder.encode(element.getValue().toString(), encode));
					params.append("&");
				}
				if (params.length() > 0) {
					params = params.deleteCharAt(params.length() - 1);
				}
			}
			return params.toString();
		} catch (Exception e) {
			ServiceLog.e(e);
			return null;
		}
	}
}

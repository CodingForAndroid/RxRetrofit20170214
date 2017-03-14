package mvp.jorge.com.rxretrofit20170214;

import android.annotation.SuppressLint;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class HttpUtils {

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
		common.put("mid", global.getMid());
		common.put("userId", "");
		common.put("userSession", "");
		common.put("test1", "");
		common.put("cityCode", global.getSelectCityId());
		return common;
	}

	/**
	 * 获取header
	 * 
	 * @param conn
	 */
	@SuppressLint("SimpleDateFormat")
	public static Map<String, String> getHeader() {
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
		header.put("unique", global.getUnique());
		header.put("level", global.getLevel());
		header.put("Accept-Encoding", "gzip");
		header.put("latitude", global.getLatitude());
		header.put("longitude", global.getLongitude());
		header.put("imei", global.getUdid());
		header.put("cpsKey", global.getCpsKey());
		header.put("mipSourceId", "1002");
		header.put("deviceModel",global.getDeviceModel());
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
//			ServiceLog.e(e);
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
//			ServiceLog.e(e);
			return null;
		}
	}
}

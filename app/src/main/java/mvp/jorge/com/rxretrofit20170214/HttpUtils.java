package mvp.jorge.com.rxretrofit20170214;

import android.annotation.SuppressLint;
import android.util.Log;

import com.google.gson.Gson;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import mvp.jorge.com.rxretrofit20170214.bean.Resp;
import mvp.jorge.com.rxretrofit20170214.security.ThreeDES;

public class HttpUtils {

	public static final String SUCCESS = "00";

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
//		common.put("mid", global.getMid());
//		common.put("userId", "");
//		common.put("userSession", "");
//		common.put("test1", "");
//		common.put("cityCode", global.getSelectCityId());

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
	 */
	@SuppressLint("SimpleDateFormat")
	public static Map<String, String> getHeader() {
//		Map<String, String> header = new ConcurrentHashMap<String, String>();
//		header.put("userId", global.getUserId()); // 用户id
//		header.put("udid", global.getUdid());// 客户端唯一性标示
//		header.put("os", global.getOs());// 操作系统名称
//		header.put("osVersion", global.getOsVersion());// 操作系统版本
//		header.put("appVersion", global.getAppVersion());// APP 版本
//		header.put("sourceId", global.getSourceId());// 推广id
//		header.put("ver", global.getVer());// 通讯协议版本
//		header.put("test", global.getTest());// 客户端唯一性标示
//		header.put("height", global.getHeight());
//		header.put("width", global.getWidth());
//		header.put("unique", global.getUnique());
//		header.put("level", global.getLevel());
//		header.put("Accept-Encoding", "gzip");
//		header.put("latitude", global.getLatitude());
//		header.put("longitude", global.getLongitude());
//		header.put("imei", global.getUdid());
//		header.put("cpsKey", global.getCpsKey());
//		header.put("mipSourceId", "1002");
//		header.put("deviceModel",global.getDeviceModel());
//		header.put("time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));// 间戳(新增)yyyymmddSS
//		return header;


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



//		JsonNode jsonNode = Jackson.toJsonNode(json);
//		// 获取code 和 message 的值
//		Resp resp = new Resp();
//		JsonNode codeNode = jsonNode.get("code");
//		if (codeNode != null) {
//			resp.respCode = codeNode.getTextValue();
//			if(resp.respCode==null){
//				resp.respCode="";
//			}
//		}
//		JsonNode messageNode = jsonNode.get("message");
//		if (messageNode != null) {
//			resp.respMessage = messageNode.getTextValue();
//		}
//		// 日志
//		if (logBuffer != null) {
//			logBuffer.append("\n服务器CODE:").append(resp.respCode);
//			logBuffer.append("\n服务器MESSAGE:").append(resp.respMessage);
//		}
//		// 判断code是否存在
//		if ((resp.respCode == null || resp.respCode.length() == 0)&&(resp.respMessage==null||resp.respMessage.length()==0)) {
//			return null;
//		}
//		// 判断是否是Resp类型
//		if (Resp.class.getSimpleName().equals(type.getSimpleName())) {
//			return (T) resp;
//		}
//		// 解析data
//		String data = "{}";
//		if (SUCCESS.equals(resp.respCode)) {
//			JsonNode dataNode = jsonNode.get("data");
//			if (dataNode != null) {
//				data = dataNode.getTextValue();
//				byte[] Miwen = Base64.decodeBase64(data.getBytes());
//				if ((keybyte != null)) {
//					Miwen = ThreeDES.decryptMode(keybyte, Miwen);
//				}
//				data = new String(Miwen);
//			}
//		}
//		// 日志
//		if (logBuffer != null) {
//			logBuffer.append("\n服务器数据:\n").append(data);
//		}
//		// 返回值
//		T t = Jackson.toObject(data, type);
//		Resp r = (Resp) t;
//		r.respCode = resp.respCode;
//		r.respMessage = resp.respMessage;


	}


package mvp.jorge.com.rxretrofit20170214;

import android.util.Log;

import com.google.gson.Gson;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONException;
import org.json.JSONObject;

import mvp.jorge.com.rxretrofit20170214.bean.Resp;
import mvp.jorge.com.rxretrofit20170214.security.ThreeDES;

public class ServiceUtils {

	/**
	 * 服务器返回成功的code
	 */
	public static final String SUCCESS = "00";

	/**
	 * 服务器RSA失效
	 */
	public static final String RSA_KEY_EXPIRE = "-01";

	/**
	 * 用户登录过期
	 */
	public static final String USER_EXPIRE = "01";

	/**
	 * 微信app授权的appid
	 */
	public static final String WX_APPID = "wx46d3e2ec08aea63a";


	public static <T>  T  Decrypt(String response,String keyCode,Class<T> type) {
		Gson gson = new Gson();
		Resp resp = new Resp();
		try {
			JSONObject jsonObject = new JSONObject(response);
			String code = (String) jsonObject.get("code");
			String message = (String) jsonObject.get("message");

			// 判断code是否存在
			if ((code == null || code.length() == 0) && (message == null || message.length() == 0)) {
				return null;
			}
			resp.respCode = code;
			resp.respMessage = message;
			// 判断是否是Resp类型
			if (Resp.class.getSimpleName().equals(type.getSimpleName())) {
				return (T) resp;
			}

			// 解析data
			if (SUCCESS.equals(resp.respCode)) {
				String data = (String) jsonObject.get("data");
				byte[] Miwen = Base64.decodeBase64(data.getBytes());
				if ((keyCode != null)) {
					Miwen = ThreeDES.decryptMode(keyCode.getBytes(), Miwen);
				}
				data = new String(Miwen);
				Log.e("HttpUtils", "Decrypt =" + response + " data = " + data);
				T t = gson.fromJson(data, type);
				Resp r = (Resp) t;
				r.respCode = resp.respCode;
				r.respMessage = resp.respMessage;
				return t;
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return null;
	}}
//	/**
//	 * 解析json串，带64位解码和解密
//	 *
//	 * @param logBuffer
//	 *            日志
//	 * @param json
//	 * @param keybyte
//	 * @param type
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	public static <T> T toROObject(StringBuffer logBuffer, String json, byte[] keybyte, Class<T> type) {
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
//		return t;
//	}
//
//	/**
//	 * 解析json串
//	 *
//	 * @param logBuffer
//	 *            日志
//	 * @param json
//	 * @param type
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	public static <T> T toROObject(StringBuffer logBuffer, String json, Class<T> type) {
//		JsonNode jsonNode = Jackson.toJsonNode(json);
//		// 获取code 和 message 的值
//		Resp resp = new Resp();
//		JsonNode codeNode = jsonNode.get("code");
//		if (codeNode != null) {
//			resp.respCode = codeNode.getTextValue();
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
//		if (resp.respCode == null || resp.respCode.length() == 0) {
//			return null;
//		}
//		// 判断是否是Resp类型
//		if (Resp.class.getSimpleName().equals(type.getSimpleName())) {
//			return (T) resp;
//		}
//		// 解析data
//		String data = "";
//		if (SUCCESS.equals(resp.respCode)) {
//			JsonNode dataNode = jsonNode.get("data");
//			if (dataNode != null) {
//				data = dataNode.getTextValue();
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
//		return t;
//	}

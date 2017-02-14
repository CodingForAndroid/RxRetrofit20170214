package mvp.jorge.com.rxretrofit20170214.util;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * 用来对字符串和对象的转换
 */
public final class ObjectMaker {
	
	/** 把json串转换成相对应的类 */
	public static <T> T convert(String jsonStr, Class<T> classOfT) {
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(jsonStr);
		
		return gson.fromJson(element, classOfT);
	}
	
	public static <T> T convert(JSONObject jObject, Class<T> classOfT) {
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(jObject.toString());
		
		return gson.fromJson(element, classOfT);
	}
	
	public static <T> ArrayList<T> convert2List(JSONArray jsonArray, Class<T> classOfT){
		ArrayList<T> result = new ArrayList<T>();
		for (int i = 0; i < jsonArray.length(); i++) {
			result.add(convert(jsonArray.optJSONObject(i), classOfT));
		}
		return result ; 
	}
	
	
	/** 把对象转换成json串 */
	public static String unConVer(Object obj){
		Gson gson = new Gson();
		return gson.toJson(obj);
	}

}

package mvp.jorge.com.rxretrofit20170214.http;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by math on 2017/1/19.
 */

/**
 * {"userId":"","height":"1920","Accept-Encoding":"gzip","width":"1080","udid":"864516020038170","longitude":"116.429467","latitude":"39.906533","test":"mwomai01","unique":"59e51420825031a6fee670beb927da74","mipSourceId":"1002","deviceModel":"smartisan|SM701","osVersion":"4.4.2","imei":"864516020038170","os":"2","appVersion":"3.4.0","cpsKey":"","level":"","sourceId":"2024","time":"2017-02-03 10:17:45","ver":"1.0"}
 */
public class HttpUtilss {
    public static Map<String, String> getHeader() {
        Map<String, String> header = new ConcurrentHashMap<String, String>();
        header.put("userId", ""); // 用户id
        header.put("udid", "864516020038170");// 客户端唯一性标示
        header.put("os", "2");// 操作系统名称
        header.put("osVersion", "4.4.2");// 操作系统版本
        header.put("appVersion", "3.4.0");// APP 版本
        header.put("sourceId", "2024");// 推广id
        header.put("ver", "1.0");// 通讯协议版本
        header.put("test", "mwomai01");// 客户端唯一性标示
        header.put("height", "1920");
        header.put("width", "1080");
        header.put("unique", "59e51420825031a6fee670beb927da74");
        header.put("level", "");
        header.put("Accept-Encoding", "gzip");
        header.put("latitude", "39.906533");
        header.put("longitude", "116.429467");
        header.put("imei", "864516020038170");
        header.put("cpsKey", "");
        header.put("mipSourceId", "1002");
        header.put("deviceModel", "smartisan|SM701");
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
        header.put("userId",""); // 用户id
        header.put("udid", "864516020038170");// 客户端唯一性标示
        header.put("os", "2");// 操作系统名称
        header.put("osVersion", "4.4.2");// 操作系统版本
        header.put("appVersion", "3.4.0");// APP 版本
        header.put("sourceId","2024");// 推广id
        header.put("ver", "1.0");// 通讯协议版本
        header.put("test","mwomai01");// 客户端唯一性标示
        header.put("height", "1920");
        header.put("width", "1080");
        header.put("level", "");
        header.put("mipSourceId", "1002");
        header.put("deviceModel","smartisan|SM701");
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
        DATA.put("common", HttpUtilss.getUserCommon());
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
        DATA.put("common", HttpUtilss.getNoUserCommon());
        return DATA;
    }
/**
 *
 {"common":{"userId":"","test1":"","userSession":"","mid":"0","cityCode":"31000"}}
 */
    /**
     * 获取用户相关接口的commom对象
     *
     * @return
     */
    private static Map<String, String> getUserCommon() {
        Map<String, String> common = new ConcurrentHashMap<String, String>();
        common.put("mid", "0");
        common.put("userId", "");
        common.put("userSession", "");
        common.put("test1", "");
        common.put("cityCode", "31000");
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

    public  static String getJsessionId() {
        return JsessionId;
    }
    public static void  setJessionId(String lsessionId){
        JsessionId=lsessionId;
    }

    public static void setRSA(String rsa) {
        RSA=rsa;
    }

    public static String getRSA() {
        return RSA;
    }
    public static String RSA="";
    public static String JsessionId="";
}

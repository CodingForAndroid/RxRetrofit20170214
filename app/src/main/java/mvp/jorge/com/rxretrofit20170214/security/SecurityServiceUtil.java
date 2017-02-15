package mvp.jorge.com.rxretrofit20170214.security;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import mvp.jorge.com.rxretrofit20170214.bean.ROConsult;
import mvp.jorge.com.rxretrofit20170214.http.HttpUtils;
import mvp.jorge.com.rxretrofit20170214.http.ServiceUrl;
import mvp.jorge.com.rxretrofit20170214.util.ObjectMaker;

/**
 * @author zj on 2017/2/14.
 */

public class SecurityServiceUtil {

    public static String initRSA(){
        ROConsult roConsult = null;
        // 日志
        StringBuffer logBuffer = new StringBuffer("RSA->resquest->url->");
        // 对称密钥
        String originalKeyString = ThreeDES.WOMAI_PUBLIC_KEY;
        // 地址
        String urlString = ServiceUrl.CommonService_IP + "consult.action";
        logBuffer.append(urlString);
        try {
//        String header = Jackson.toJson(HttpUtils.getHeader());
            String header = ObjectMaker.unConVer(HttpUtils.getHeader());
            header = ThreeDES.orginalEncoded(originalKeyString, header);
            Map<String, String> headerMap = new HashMap<String, String>();
            headerMap.put("headerData", header);

            String src = "abc";
            Map<String, Object> data = new HashMap<String, Object>();

            data.put("consult", src);
            Map<String, Object> DATA = HttpUtils.getNoUserRequestMap(data);
            String base64str = ThreeDES.orginalEncoded(originalKeyString, ObjectMaker.unConVer(DATA));

            Map<String, String> param = new HashMap<String, String>();
            param.put("data", base64str);

//            String response = new HttpNet().doPost(logBuffer, urlString, headerMap, param);
//            if ((response != null) && (response.length() > 0)) {
//                roConsult = ServiceUtils.toROObject(logBuffer, response, originalKeyString.getBytes(), ROConsult.class);
//            }
        } catch (Exception e) {
//            ServiceLog.e(e);
        }
//        ServiceLog.d(logBuffer.toString());
        if (roConsult != null) {
            return roConsult.consult.public_key;
        }else{
            return null;
        }
    }
}

package mvp.jorge.com.rxretrofit20170214;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import mvp.jorge.com.rxretrofit20170214.security.RSAUtil;
import mvp.jorge.com.rxretrofit20170214.security.ThreeDES;
import mvp.jorge.com.rxretrofit20170214.util.ObjectMaker;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.Converter;

/**
 * @author zj on 2017-3-15.
 */

public class ComRequestBodyConverter<T> implements Converter <T, RequestBody> {
    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");
    private static final Charset UTF_8 = Charset.forName("UTF-8");

    private final Gson gson;
    private final TypeAdapter<T> adapter;
    ComRequestBodyConverter(Gson gson, TypeAdapter<T> adapter){
        this.gson = gson;
        this.adapter = adapter;
    }
    @Override
    public RequestBody convert(T value) throws IOException {

//        ObjectMaker.convert( value,)
        Buffer buffer = new Buffer();
        Writer writer = new OutputStreamWriter(buffer.outputStream(),UTF_8);
        JsonWriter jsonWriter = gson.newJsonWriter(writer);
        adapter.write(jsonWriter,value);
        jsonWriter.flush();

        RequestBody requestBody = RequestBody.create(MEDIA_TYPE, buffer.readByteString());
        String s = requestBody.toString();
        Log.e("ComConvertFactory",""+buffer.readByteString() +" s ="+s);
        return requestBody;
//
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("userName", userName);
//        params.put("password", passWord);
//        params = HttpUtils.getNoUserRequestMap(params);
//
//        String jiamiKEy = null;
//
//        if ((HttpUtils.global.getRSA() == null) || (HttpUtils.global.getRSA().length() == 0)) {
//            getRsa(subscriber);
//        }
//        if ((HttpUtils.global.getRSA() != null) && (HttpUtils.global.getRSA().length() > 0)) {
//            // 随机生成对称密钥, 通用rsa公钥加密对称密钥
//            String duichenKey = ThreeDES.genrateRandomPassword(24);
//            // body
//            HashMap<String, String> dataParam = new HashMap<String, String>();
//            try {
//                jiamiKEy = RSAUtil.rsaBase64(HttpUtils.global.getRSA(), duichenKey);
////            ObjectMaker.unConVer()
//                String paramString = ObjectMaker.unConVer(params);
////                String paramString = Jackson.toJson(params);
////                logBuffer.append("\n请求参数:\n").append(paramString);
//                String data = null;
//
//                    data = ThreeDES.orginalEncoded(duichenKey, paramString);
//
//                    dataParam.put("key", jiamiKEy);
//                    dataParam.put("data", data);
//                }
//
//                catch (Exception e) {
//                    e.printStackTrace();
//                }
//    }
}}

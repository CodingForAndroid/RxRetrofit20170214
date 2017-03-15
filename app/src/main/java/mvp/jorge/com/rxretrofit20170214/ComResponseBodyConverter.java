package mvp.jorge.com.rxretrofit20170214;

import android.util.Log;

import com.google.gson.TypeAdapter;

import java.io.IOException;

import mvp.jorge.com.rxretrofit20170214.bean.ROConsult;
import mvp.jorge.com.rxretrofit20170214.security.ThreeDES;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * @author zj on 2017-3-15.
 */

public class ComResponseBodyConverter<T> implements Converter<ResponseBody,T> {

    private final TypeAdapter<T> adapter;
    ComResponseBodyConverter(TypeAdapter<T> adapter){
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        //解密字符串
            Log.e("ComConvertFactory",""+value.string());
//        ROConsult roConsult = ServiceUtils.Decrypt(value.string(), ThreeDES.WOMAI_PUBLIC_KEY, ROConsult.class);
//        if (roConsult != null) {
//            HttpUtils.global.setRSA(roConsult.consult.public_key);
//        }

//        Log.e("JsonResponseBody"," "+HttpUtils.global.getRSA());
        return adapter.fromJson(value.string());
    }
}

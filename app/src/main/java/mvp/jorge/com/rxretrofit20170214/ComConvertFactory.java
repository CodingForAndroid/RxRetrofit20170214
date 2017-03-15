package mvp.jorge.com.rxretrofit20170214;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * 正常请求的 转换器
 * @author zj on 2017-3-15.
 */

public class ComConvertFactory extends Converter.Factory {

    public static ComConvertFactory create() {
        return create(new Gson());
    }

    public static ComConvertFactory create(Gson gson) {
        return new ComConvertFactory(gson);

    }

    private final Gson gson;

    private ComConvertFactory(Gson gson) {
        if (gson == null) throw new NullPointerException("gson == null");
        this.gson = gson;
    }
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        Log.e("ComConvertFactory","responseBodyConverter");
        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
        return new ComResponseBodyConverter<>(adapter);
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        Log.e("ComConvertFactory","requestBodyConverter");
        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
        return new ComRequestBodyConverter<>(gson,adapter);
    }
}

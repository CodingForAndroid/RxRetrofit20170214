package mvp.jorge.com.rxretrofit20170214;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author zj on 2017/2/14.
 */

public class RetrofitHelper {
    public static final String UserService_IP = "http://wapi.m.womai.com/";
    static  OkHttpClient okHttpClient ;

    public RetrofitHelper(){
        initOkHttp();
    }
    public static LoginApi  getLoginApi(){

        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(UserService_IP)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        retrofit.create(LoginApi.class);
    }

    private void initOkHttp(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        Interceptor httpInterceptor =  new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
//                Request request = chain.request();
//                return  null;
                Request request = chain.request();
                HttpUrl httpUrl = request.url().newBuilder()
                        .addQueryParameter("token", "tokenValue")
                        .build();
                request = request.newBuilder().url(httpUrl).build();
                return chain.proceed(request);

            }
        };
        builder.addInterceptor(httpInterceptor);
        okHttpClient = builder.build();
    };
}

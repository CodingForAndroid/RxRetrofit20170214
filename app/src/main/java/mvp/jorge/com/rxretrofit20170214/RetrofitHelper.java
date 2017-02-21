package mvp.jorge.com.rxretrofit20170214;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import mvp.jorge.com.rxretrofit20170214.bean.ROConsult;
import mvp.jorge.com.rxretrofit20170214.entity.HttpResult;
import mvp.jorge.com.rxretrofit20170214.entity.Subject;
import mvp.jorge.com.rxretrofit20170214.http.HttpUtils;
import mvp.jorge.com.rxretrofit20170214.security.ThreeDES;
import mvp.jorge.com.rxretrofit20170214.util.ObjectMaker;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * @author zj on 2017/2/14.
 */

public class RetrofitHelper {
    public  static  final String UserService_IP = "http://wapi.m.womai.com/";
    private  WoMaiApiService woMaiApiService;
    public  final int DEFAULT_TIMEOUT = 30;
    public RetrofitHelper(){

        getLoginApi();
    }
    public  void  getLoginApi(){
        OkHttpClient.Builder   OkBuilder = new OkHttpClient.Builder();
        Interceptor httpInterceptor =  new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Request.Builder builder = request.newBuilder();
                String originalKeyString = ThreeDES.WOMAI_PUBLIC_KEY;
                String header = ObjectMaker.unConVer(HttpUtils.getHeader());;
                try {
                    header = ThreeDES.orginalEncoded(originalKeyString, header);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                builder.addHeader("headerData",header);
                request = builder.build();
                return chain.proceed(request);

            }
        };
        Interceptor cookiesInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Request.Builder builder = request.newBuilder();
                builder.addHeader("Cookie","JSESSIONID=");
                Response response = chain.proceed(builder.build());
                return response;
            }
        };
        OkBuilder.addInterceptor(httpInterceptor);
        OkBuilder.addInterceptor(cookiesInterceptor);
        OkBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        OkBuilder.readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        Retrofit retrofit = new Retrofit.Builder()
                .client(OkBuilder.build())
                .baseUrl(UserService_IP)
                .addConverterFactory(ResponseConvertFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        woMaiApiService = retrofit.create(WoMaiApiService.class);
    }

    /**
     * 获取rsa 证书
     * @param subscriber
     */
    public void getRsa(Subscriber<List<Subject>> subscriber){
        String originalKeyString = ThreeDES.WOMAI_PUBLIC_KEY;
        Map<String, String> param  = new HashMap<String, String>();;
        try {
        String src = "abc";
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("consult", src);
        Map<String, Object> DATA = HttpUtils.getNoUserRequestMap(data);
        String base64str = ThreeDES.orginalEncoded(originalKeyString, ObjectMaker.unConVer(DATA));
        param.put("data", base64str);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Observable observable =  woMaiApiService.getRsa(param);
        toSubscribe(observable, subscriber);
    }

    /**
     *  登录 api
     * @param userName
     * @param passWord
     */
    public void  getLogin(String userName,String passWord ,Subscriber<String> subscriber){
        Observable observable = woMaiApiService.login(userName,passWord);
        toSubscribe(observable, subscriber);
    }


































    private <T> void toSubscribe(Observable<T> o, Subscriber<T> s){
        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }




    /**
     * 用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
     *
     * @param <T>   Subscriber真正需要的数据类型，也就是Data部分的数据类型
     */
    private class HttpResultFunc<T> implements Func1<HttpResult<T>, T>{

        @Override
        public T call(HttpResult<T> httpResult) {
            if (httpResult.getCount() == 0) {
                throw new ApiException(100);
            }
            return httpResult.getSubjects();
        }
    }

    public class AddCookiesInterceptor implements Interceptor {
        private Context context;

        public AddCookiesInterceptor(Context context) {
            super();
            this.context = context;

        }

        @Override
        public Response intercept(Chain chain) throws IOException {

            final Request.Builder builder = chain.request().newBuilder();
            SharedPreferences sharedPreferences = context.getSharedPreferences("cookie", Context.MODE_PRIVATE);
//最近在学习RxJava,这里用了RxJava的相关API大家可以忽略,用自己逻辑实现即可
            Observable.just(sharedPreferences.getString("cookie", ""))
                    .subscribe(new Action1<String>() {
                        @Override
                        public void call(String cookie) {
                            //添加cookie
                            builder.addHeader("Cookie", cookie);
                        }
                    });

            return chain.proceed(builder.build());
        }
    }

}

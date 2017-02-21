package mvp.jorge.com.rxretrofit20170214;

import java.util.List;
import java.util.Map;

import mvp.jorge.com.rxretrofit20170214.bean.ROConsult;
import mvp.jorge.com.rxretrofit20170214.entity.HttpResult;
import mvp.jorge.com.rxretrofit20170214.entity.Subject;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;
import rx.Subscriber;

/**
 * @author zj on 2017/2/14.
 */

public interface WoMaiApiService {

    @FormUrlEncoded
    @POST("login.action")
    Observable<String> login(@Field("userName")String userName,@Field("password")String password);

    @FormUrlEncoded
    @POST("consult.action")
    Observable<ROConsult> getRsa(@FieldMap Map<String, String> param );



}

package mvp.jorge.com.rxretrofit20170214;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Subscriber;

/**
 * @author zj on 2017/2/14.
 */

public interface LoginApi {

    @FormUrlEncoded
    @POST("login.action")
    Subscriber<String> login(@Field("userName")String userName,@Field("password")String password);
}

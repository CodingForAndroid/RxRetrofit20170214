package mvp.jorge.com.rxretrofit20170214;

import java.util.Map;

import mvp.jorge.com.rxretrofit20170214.bean.ROConsult;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;
import rx.Subscriber;

/**
 * @author zj on 2017/2/14.
 */

public interface RsaAPi {
//  @FormUrlEncoded
    @POST("consult.action")
    Subscriber<HttpResult2<ROConsult>> getRSA(@FieldMap Map<String, Object> fields);
}

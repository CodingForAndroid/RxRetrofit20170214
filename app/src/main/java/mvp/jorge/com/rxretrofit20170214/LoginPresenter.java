package mvp.jorge.com.rxretrofit20170214;

import android.content.Context;
import android.text.TextUtils;

import mvp.jorge.com.rxretrofit20170214.bean.ROConsult;
import mvp.jorge.com.rxretrofit20170214.subscribers.ProgressSubscriber;
import mvp.jorge.com.rxretrofit20170214.subscribers.SubscriberOnNextListener;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author zj on 2017/2/14.
 */

public class LoginPresenter implements LoginContract.ILoginPresenter {

    private  LoginContract.ILoginView mLoginView;
    private RetrofitHelper retrofitHelper;
    private Context mContext;
    public  LoginPresenter(Context context){
         mContext = context;
         retrofitHelper = new RetrofitHelper();
    }
    public void login(String userName, String passWord){
        if (TextUtils.isEmpty(userName)) {
            mLoginView.showUserNameError("请输入用户名");
            return;
        }
        if (TextUtils.isEmpty(passWord)) {
            mLoginView.showPassWordError("请输入密码");
            return;
        }
        mLoginView.showLoading();
        SubscriberOnNextListener  onNextListener = new SubscriberOnNextListener() {
            @Override
            public void onNext(Object o) {

            }
        };
//        retrofitHelper.getTopMovie(new ProgressSubscriber(onNextListener, mContext), 0, 10);
        retrofitHelper.getRsa(new ProgressSubscriber(onNextListener,mContext),mContext);
        // 网络请求
//        Observable<ROConsult> rsa = retrofitHelper.getRsa();
//        rsa.subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread());
//        retrofitHelper.getRsa();
    }

    @Override
    public void attachView(LoginContract.ILoginView view) {
        mLoginView =  view ;
    }

    @Override
    public void detachView() {

    }
}

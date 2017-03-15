package mvp.jorge.com.rxretrofit20170214;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

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
                Log.e("getLogin",""+o.toString());

            }
        };

          retrofitHelper.getLogin(userName,passWord,new ProgressSubscriber(onNextListener,mContext));
//
           }

    public void getRsa(){

        SubscriberOnNextListener  onNextListener = new SubscriberOnNextListener() {
            @Override
            public void onNext(Object o) {
                Log.e("getRsa",""+o.toString());

            }
        };
                retrofitHelper.getRsa(new ProgressSubscriber(onNextListener,mContext));
    }

    @Override
    public void attachView(LoginContract.ILoginView view) {
        mLoginView =  view ;
    }

    @Override
    public void detachView() {

    }
}

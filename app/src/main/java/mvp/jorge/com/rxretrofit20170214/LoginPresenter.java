package mvp.jorge.com.rxretrofit20170214;

import android.content.Context;
import android.text.TextUtils;

/**
 * @author zj on 2017/2/14.
 */

public class LoginPresenter implements LoginContract.ILoginPresenter {

    private  LoginContract.ILoginView mLoginView;
    public  LoginPresenter(Context context){

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

        // 网络请求
    }

    @Override
    public void attachView(LoginContract.ILoginView view) {
        mLoginView =  view ;
    }

    @Override
    public void detachView() {

    }
}

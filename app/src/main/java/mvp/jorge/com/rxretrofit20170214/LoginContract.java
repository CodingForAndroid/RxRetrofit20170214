package mvp.jorge.com.rxretrofit20170214;

/**
 * @author zj on 2017/2/14.
 */

public class LoginContract {

     interface ILoginView extends BaseView {
        void showLoading();

        void hideLoading();

        void showUserNameError(String error);

        void showPassWordError(String error);

        void loginSuccess();
    }

    interface ILoginPresenter extends BasePresenter<ILoginView>{
        void login(String userName, String passWord);
    }
}

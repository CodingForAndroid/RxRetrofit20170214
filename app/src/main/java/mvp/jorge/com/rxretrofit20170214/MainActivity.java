package mvp.jorge.com.rxretrofit20170214;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity  implements LoginContract.ILoginView{
    private Button loginButton ;
    private LoginPresenter loginPresenter;
    @Override
    protected void createContent() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void findViews() {
        loginButton = (Button) findViewById(R.id.logButton);
    }

    @Override
    protected void initData() {
        loginPresenter =  new  LoginPresenter(mActivity);
        loginPresenter.attachView(this);
    }

    @Override
    protected void setListener() {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.login("18611445571","aaa123456");
            }
        });
    }

    @Override
    public void free() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showUserNameError(String error) {

    }

    @Override
    public void showPassWordError(String error) {

    }

    @Override
    public void loginSuccess() {

    }
}

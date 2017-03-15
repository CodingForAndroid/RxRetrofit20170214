package mvp.jorge.com.rxretrofit20170214;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends BaseActivity  implements LoginContract.ILoginView{
    private Button loginButton ;
    private Button rsaButton ;
    private LoginPresenter loginPresenter;
    @Override
    protected void createContent() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void findViews() {
        loginButton = (Button) findViewById(R.id.logButton);
        rsaButton = (Button) findViewById(R.id.rsaButton);
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
        rsaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.getRsa();
            }
        });
    }

    @Override
    public void free() {

    }

    @Override
    public void showLoading() {
        Toast.makeText(this,"showLoading",Toast.LENGTH_LONG).show();
    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showUserNameError(String error) {
        Toast.makeText(this,error,Toast.LENGTH_LONG).show();
    }

    @Override
    public void showPassWordError(String error) {
        Toast.makeText(this,error,Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this,"loginSuccess",Toast.LENGTH_LONG).show();
    }
}

package mvp.jorge.com.rxretrofit20170214;

import android.app.Activity;
import android.os.Bundle;

/**
 * @author zj on 2017/2/14.
 */

public abstract class BaseActivity extends Activity {
    public BaseActivity mActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createContent();
        findViews();
        initData();
        setListener();
        mActivity = this;
    }

    /***
     * set layout
     */
    protected abstract void createContent();
    /***
     * find views
     */
    protected abstract void findViews();
    /***
     * initial data
     */
    protected abstract void initData();
    /***
     * set views listener
     */
    protected abstract void setListener();
    /**
     * free useless resource
     */
    public abstract void free();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        free();
    }

}

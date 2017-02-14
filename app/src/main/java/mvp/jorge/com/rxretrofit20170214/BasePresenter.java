package mvp.jorge.com.rxretrofit20170214;


/**
 * Created by sll on 2016/5/11.
 */
public interface BasePresenter<T extends BaseView> {

  void attachView( T view);

  void detachView();
}

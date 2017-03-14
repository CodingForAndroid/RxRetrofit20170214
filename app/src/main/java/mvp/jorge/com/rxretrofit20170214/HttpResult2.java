package mvp.jorge.com.rxretrofit20170214;

/**
 * Created by math on 2017/1/18.
 */

public class HttpResult2<T>{
    public String code;
    public String message;
    //用来模仿Data
    public  T data;

    public String getRespCode() {
        return code;
    }

    public void setRespCode(String requestCode) {
        this.code = requestCode;
    }

    public String getRespMsg() {
        return message;
    }

    public void setRespMsg(String requestMsg) {
        this.message = requestMsg;
    }

    public  T getData(){
        return  data;
    }
}

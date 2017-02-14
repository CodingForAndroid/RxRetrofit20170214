package mvp.jorge.com.rxretrofit20170214.bean;

/**
 * 错误信息
 */
public class ROConsult extends Resp {
    /**
     * 响应信息
     */
    public String response = "";

    /**
     * 错误信息
     */
    public ResError error;

    /**
     * 协商内容
     */
    public ConsultContest consult = new ConsultContest();

}

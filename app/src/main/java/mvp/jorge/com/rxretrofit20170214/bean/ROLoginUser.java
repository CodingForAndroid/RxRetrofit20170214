package mvp.jorge.com.rxretrofit20170214.bean;

/**
 * 用户登录对象
 */
public class ROLoginUser extends Resp {
    /**
     * 用户id
     */
    public String userid = "";

    /**
     * 用户会话
     */
    public String usersession = "";

    /**
     * 用户提示信息
     */
    public Sendcouponcard sendcouponcard = new Sendcouponcard();

    /**
     * 响应信息
     */
    public String response = "";

    /**
     * 错误信息
     */
    public ResError error;

    /**
     * md5校验
     */
    public String test1 = "";

}

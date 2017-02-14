package mvp.jorge.com.rxretrofit20170214.bean;

/**
 * 服务器响应
 * 
 * @author xiangming
 * 
 */
public class Resp {

	/**
	 * 响应代码
	 */
	public String respCode = "";

	/**
	 * 响应消息
	 */
	public String respMessage = "";
	/**
	 * 是否是正常获取的数据,true代表正常获取了数据，false表示数据请求失败了，需要用缓存的数据
	 */
	public boolean isNormalData = true;

}

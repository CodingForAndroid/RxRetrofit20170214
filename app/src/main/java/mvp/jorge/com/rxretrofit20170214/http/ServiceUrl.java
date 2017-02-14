package mvp.jorge.com.rxretrofit20170214.http;

public class ServiceUrl {

	public static final String ProductService_IP = "http://wapi.m.womai.com/";
	public static final String ProductService_getBrand = ProductService_IP + "brand/list.action";
	public static final String ProductService_getCategories = ProductService_IP + "categories/list.action";
	public static final String ProductService_getBrandProducts = ProductService_IP + "brand/index.action";
	public static final String ProductService_getCategorieProducts = ProductService_IP + "categories/index.action";
	public static final String ProductService_getSearchProducts = ProductService_IP + "search/index.action";
	public static final String ProductService_getIdsProducts = ProductService_IP + "sku/list.action";
	public static final String ProductService_getActiProducts = ProductService_IP + "activity/getactivity.action";
	public static final String ProductService_getActiProductsCity = ProductService_IP + "baseactivity/cityActivity.action";
	public static final String ProductService_getProductsFromActivity = ProductService_IP + "activeproductlist.action";
	public static final String ProductService_getSellerList = ProductService_IP + "seller/list.action";
	public static final String ProductService_getProductDetail = ProductService_IP + "skudetail/index.action";
	public static final String ProductService_getWxProductDetail = ProductService_IP + "tuan/getActSkuDetail.action";
	public static final String ProductService_getProductComments = ProductService_IP + "commentlist.action";
	public static final String ProductService_getSearchPrompt = ProductService_IP + "prompt/searchPrompt.action";
	public static final String ProductService_getWXProductInfoList = ProductService_IP + "tuan/getActivity.action";
    public static final String ProductService_getFilterCondition=ProductService_IP+"categories/childCategory.action";
	public static final String UserService_IP = "http://wapi.m.womai.com/";
	public static final String UserService_login = UserService_IP + "login.action";
	public static final String UserService_register = UserService_IP + "register.action";
	public static final String UserService_logout = UserService_IP + "logout.action";
	public static final String UserService_userinfo = UserService_IP + "userinfo.action";
	public static final String UserService_editpw = UserService_IP + "editpw.action";
	public static final String UserService_findPassword = UserService_IP + "findPassword.action";
	public static final String UserService_verifyPayPassword = UserService_IP + "verifyPayPassword.action";
	public static final String UserService_getZhiFuBaoWeb = UserService_IP + "wapPay.action";
	public static final String UserService_getAlipay = UserService_IP + "pay/alipay.action";
	public static final String UserService_getBaiduPay = UserService_IP + "pay/baiduMiniPay.action";
	public static final String UserService_getWXPay = UserService_IP + "wx/appayAction.action";
	public static final String UserService_getBestpay = UserService_IP + "pay/bestpay.action";
	public static final String UserService_cancelorder = UserService_IP + "cancelorder.action";
	public static final String UserService_checkout = UserService_IP + "checkout.action";
	public static final String UserService_submitorder = UserService_IP + "submitorder.action";
	public static final String UserService_couponcard = UserService_IP + "couponcard.action";
	public static final String UserService_addcouponcard = UserService_IP + "addcouponcard.action";
	public static final String UserService_logistics = UserService_IP + "logistics.action";
	public static final String UserService_orderdetail = UserService_IP + "orderdetail.action";
	public static final String UserService_orders = UserService_IP + "orders.action";
	public static final String UserService_addressadd = UserService_IP + "addressadd.action";
	public static final String UserService_addressedit = UserService_IP + "addressedit.action";
	public static final String UserService_addressdel = UserService_IP + "addressdel.action";
	public static final String UserService_addresslist = UserService_IP + "addresslist.action";
	public static final String UserService_addresslistCheckout = UserService_IP + "addressListWithKema.action";
	public static final String UserService_favoritedel = UserService_IP + "favoritedel.action";
	public static final String UserService_favoriteadd = UserService_IP + "favoriteadd.action";
	public static final String UserService_favorite = UserService_IP + "favorite.action";
	public static final String UserService_getSMSCheckCode = UserService_IP + "security/sendMsg.action";
	public static final String UserService_doValidNewMobile = UserService_IP + "security/mobileValidate.action";
	public static final String UserService_doValidOldMobile = UserService_IP + "security/checkOldMsg.action";
	public static final String UserService_GetBindMobile = UserService_IP + "security/getUserBindMobile.action";
	public static final String UserService_modifyMobile = UserService_IP + "security/modifyMobile.action";
	public static final String UserService_doValidPayPassword = UserService_IP + "security/setPayPasswordCheckMsg.action";
	public static final String UserService_setPayPassword = UserService_IP + "security/setPwdSuccess.action";
	public static final String UserService_reqAliLoginSignMsg = UserService_IP + "login/alipayLoginInfo.action";
	public static final String UserService_reqAliLoginResult = UserService_IP + "login/authQuickLogin.action";
	public static final String UserService_reqCheckCodeRegister = UserService_IP + "login/sendCode.action";
	public static final String UserService_submitCheckCodeRegister = UserService_IP + "login/verifyCode.action";
	public static final String UserService_submitPwdRegister = UserService_IP + "login/finishRegister.action";
	public static final String UserService_reqCheckCodeFindPwd = UserService_IP + "login/sendCaptcha.action";
	public static final String UserService_submitCheckCodeFindPwd = UserService_IP + "login/verifyCaptcha.action";
	public static final String UserService_submitPwdFindPwd = UserService_IP + "login/updateUserPassword.action";
	public static final String UserService_sendCode = UserService_IP + "login/sendCode.action";
	public static final String UserService_verifyCode = UserService_IP + "login/verifyCode.action";
	public static final String UserService_finishRegister = UserService_IP + "login/finishRegister.action";
	public static final String UserService_submitOrderBlessMsg = UserService_IP + "buildOrderImage.action";
	public static final String UserService_getOnlineChargeList = UserService_IP + "onlineRechargeList.action";
	public static final String UserService_reqOnlineChargeCheckout = UserService_IP + "onlineCheckout.action";
	public static final String UserService_submitOnlineChargeOrder = UserService_IP + "onlineRechargePay.action";
	public static final String UserService_getOnlineChargeRecords = UserService_IP + "onlineRechargeRecord.action";
	public static final String UserService_reOnlineRechargeIntegral = UserService_IP + "onlineRechargeIntegarl.action";
	public static final String UserService_createCPSLink = UserService_IP + "cps/createCPSLink.action";
	public static final String UserService_reqOldTakeNewShare = UserService_IP + "oldTakeNew/shareMsg.action";
	public static final String UserService_GetUserInfoHashCode = UserService_IP + "talkconn/getTalkHashCode.action";
	public static final String UserService_Upload_pic = UserService_IP + "createPicture.action";
	public static final String UserService_reqOrderComment = UserService_IP + "orderCommentAndAddPic.action";
	public static final String UserService_submitOrderServiceComment = UserService_IP + "addOrderServiceComment.action";
	public static final String UserService_requestProductComment = UserService_IP + "orderProductComment.action";
	public static final String UserService_requestCommentRule = UserService_IP + "commentRule.action";
	public static final String UserService_submitAddProductComment = UserService_IP + "addProductComment.action";
	public static final String UserService_getUserBase = UserService_IP + "tuan/getUserBase.action";
	public static final String UserService_createGroupStatus = UserService_IP + "tuan/createAndJoinStatus.action";
	public static final String UserService_requestWXExitGroup = UserService_IP + "tuan/leftTuan.action";
	public static final String UserService_requestWXMyJoinedGroup = UserService_IP + "tuan/myJoinedTuan.action";
	public static final String UserService_requestWXMyCreateGroup = UserService_IP + "tuan/myCreateTuan.action";
	public static final String UserService_getWXGroupInfo = UserService_IP + "tuan/tuanInfo.action";
	public static final String UserService_requestWXUnFullGroupList = UserService_IP + "tuan/unFullTuan.action";
	public static final String UserService_requestWXCreatGroup = UserService_IP + "tuan/createTuan.action";
	public static final String UserService_requestWXJoinGroup = UserService_IP + "tuan/joinTuan.action";
	public static final String UserServicr_requestOtherLogin = UserService_IP + "login/otherlogin.action";
	public static final String UserService_adressChangeTip = UserService_IP + "checkoutChangeAddress.action";
	public static final String UserService_ordersLogistics = UserService_IP + "helpCenter/logisticsList.action";
	public static final String UserService_ordersRemind = UserService_IP + "helpCenter/distributionList.action";
	public static final String UserService_ordersRemindSuccess = UserService_IP + "helpCenter/pushd.action";
	public static final String UserService_requestReceiveVoucher = UserService_IP + "card/cardCenterBind.action";
	public static final String UserService_getVoucher_List=UserService_IP+"card/getCardCenterInfo.action";
	public static final String UserService_requestUpopFastPay = UserService_IP + "pay/upopFastPay.action";
	public static final String UserService_requestUpopFastSendSMS = UserService_IP + "union/fastPaySendSMS.action";
	public static final String UserService_requestUpopFastSendSMSPay = UserService_IP + "pay/upopFastSMSPay.action";
	public static final String UserService_getUpopFastPayCardList = UserService_IP + "union/fastPayCardList.action";
	public static final String UserService_getOrderComment = UserService_IP + "comment/orderCommentAndAddPic.action";
	public static final String UserService_requestSubmitOrderComment = UserService_IP + "comment/addDistributionComment.action";



	public static final String CommonService_IP = "http://wapi.m.womai.com/";
	public static final String CommonService_getIntegrationLuckDraw = CommonService_IP  + "points/prizeShow.action";
    public static final String CommonService_getUnique = CommonService_IP + "getunique.action";
    public static final String CommonService_getMidCity = CommonService_IP + "getaddress.action";
    public static final String CommonService_scancode = CommonService_IP + "scancode.action";
    public static final String CommonService_getVoucherVerification = CommonService_IP + "mobile/coupon/passcodeImage.action";

    public static final String CartService_IP = "http://ctapi.m.womai.com/";
    //public static final String CartService_getCart = CartService_IP + "getCarts.action";
    //public static final String CartService_addCart = CartService_IP + "addCart.action";
    public static final String NewCartService_getCart = CartService_IP + "new/loadCart.action";
    public static final String NewCartService_changeCartProduct_Number = CartService_IP + "new/updateCartItem.action";
    public static final String NewCartService_selectedCartProduct = CartService_IP + "new/tickCartItem.action";
    public static final String NewCartService_selectCart = CartService_IP + "new/tickCarts.action";
    public static final String NewCartService_cartCheckout = CartService_IP + "new/cartCheck.action";
    public static final String NewCartService_deleteSingleProduct = CartService_IP + "new/delCartItem.action";
    public static final String CartService_new_addCart = CartService_IP + "new/add.action";
	public static final String CartService_addCart = CartService_IP + "addCart.action";
    public static final String CartService_editCart = CartService_IP + "editROCarts.action";
    public static final String CartService_editCacheCart = CartService_IP + "editCacheCarts.action";
    public static final String CartService_getCartNum = CartService_IP + "getCartsProductTotalCount.action";
    public static final String NewCartService_getAddPriceProducts = CartService_IP + "new/addPriceProducts.action";
	public static final String NewCartService_addAddPriceProducts = CartService_IP + "new/markupAdd.action";
    public static final String NewCartService_getAddOneItems = CartService_IP + "new/recommends/product.action";
    public static final String NewCartService_requestAddAddOneItem = CartService_IP + "new/recommends/checkProduct.action";
    public static final String NewCartService_getCartActiveInfo="http://capi.m.womai.com/cartActiveConf/getCartActiveInfo.action";

	public static final String CMSService_IP = "http://capi.m.womai.com/";
//	public static final String CMSService_getHome = CMSService_IP + "index/App_3.2.0_%s_index.html?cityId=%s";
	public static final String CMSService_getHome = CMSService_IP + "index/App_3.3.0_%s_index.html?cityId=%s&rc=%s&keyid=%s";
	public static final String CMSService_getMeskillActivityList = CMSService_IP + "activity/%s_2.3.0_1_1_%s_%s_app.json";
	public static final String CMSService_getActivity = CMSService_IP + "activity/%s_%s_app.json";
	public static final String CMSService_getActivityCity = CMSService_IP+ "city/getActivityBase.action";
	public static final String CMSService_getUpdateInfo = CMSService_IP + "versionupgrade/getVersionUpgrade.action";
	public static final String CMSService_getStartPicture = CMSService_IP + "startPic/getStartPic.action";
	public static final String CMSService_getNoticeList = CMSService_IP + "notice/getNoticeList.action";
	public static final String CMSService_getHotKeyWordList = CMSService_IP + "hotkeyword/getHotKeyWordList.action";
	public static final String CMSService_getHelpCenterList = CMSService_IP + "helpcenter/getHelpCenterList.action";
	public static final String CMSService_getStartPrompt = CMSService_IP + "startPrompt/getStartList.action";
	public static final String CMSService_getUpdatedAddressList = CMSService_IP + "address/getUpdatedAddressList.action";
	public static final String CMSService_getStroll = CMSService_IP + "stroll/getStroll.action";
	public static final String CMSService_saveUserFeedBack = CMSService_IP + "userfeedback/saveUserFeedBack.action";
	public static final String CMSService_getShareContent = CMSService_IP + "share/getShareContent.action";
	public static final String CMSService_getUnionLoginList = CMSService_IP + "unionLogin/getUnionLoginList.action";
	public static final String CMSService_getMoreActivity = CMSService_IP + "activitySpec/getAbleActivitysByPage.action";
	public static final String CMSService_getOnlineChargeFocus = CMSService_IP + "chargeActPic/getChargeActPicByMid.action";
	public static final String CMSService_getExchangeProducts = CMSService_IP + "chargeActItems/getChargeActIteamsByActivityId.action";
	public static final String CMSService_getOnlineChargeMark = CMSService_IP + "onlineMark/getZxczOnlineMark.action";
	public static final String CMSService_isDealSellout = CMSService_IP + "state/appConfig.action";
	public static final String CMSService_getStartImage = CMSService_IP + "startPic/getStartPicHref.action";
	public static final String CMSService_requestWXGroupProductsList = CMSService_IP + "tuan/app/goodslist";
	public static final String CMSService_getCityList = CMSService_IP + "city/cities.json";
	public static final String CMSService_getIndexResource = CMSService_IP + "index/getIndexResource.action";
	public static final String CMSService_toVoucherCenter=CMSService_IP+"coupon/hasCouponList.action";
	public static final String CMSService_getRedPacketInfo = CMSService_IP + "redPacket/getRedPacketInfo.action";
	//http://capi.m.womai.test/cartActiveConf/getCartActiveInfo.action
	public static final String CMSService_getCartActive=CMSService_IP+"cartActiveConf/getCartActiveInfo.action";

	public static final String PushService_IP = "http://push.m.womai.com/";
	public static final String PushService_getNotifications = PushService_IP + "push/getPushList.action";


	// 图片上传服务器
	public static final String UPLOAD_IMAGE = "http://upload1.womaiapp.com/fileupload.do";
	// 经纬度上传
	public static final String UPLOAD_LOCATION = "http://mip.m.womai.com/geo/getGeolocation";
	//快速注册 获取验证码
	public static final String UserService_getFastSignUpCode = UserService_IP + "login/fastSignUpSendCode.action";
	//快速注册 校验验证码并注册用户
	public static final String UserService_finishSignUp = UserService_IP + "login/fastFinishSignUp.action";

	//免密登录 获取验证码
	public static final String UserService_fastLoginSendCode=UserService_IP + "login/fastLoginSendCode.action";

	//免密登录  提交验证码完成登录
	public static final String UserService_captchaLogin=UserService_IP + "login/captchaLogin.action";

	//新的活动api 最新的 区别于旧的 CMSService_getActivity
	public static final String CMSService_getUrbanActivity=CMSService_IP + "act/%s_%s_app.json";
	//获取活动商品接口
	public static final String ProductService_getUrbanActivityList=ProductService_IP+"cmsActivity/cmsActivityList.action";

	// 首页商品列表
	public static final String ProductService_getHomeProducts=ProductService_IP + "home/resourceProducts.action";
	//新首页商品信息接口 价格回填
	public static final String ProductService_getProductsPrice=ProductService_IP + "home/homeProducts.action";
	// 结算中心新接口
	public static final String UserService_checkout2 = UserService_IP + "mergeCheckout.action";
	// 结算中心 购物车合并提交订单
	public static final String UserService_CommitOrder = UserService_IP +"mergeSubmit.action";
	//未完成订单页
	public static final String UserService_UnpaidOrder = UserService_IP + "unpaidOrder.action";

}

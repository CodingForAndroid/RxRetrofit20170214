package mvp.jorge.com.rxretrofit20170214;

import android.app.Application;
import android.util.Log;

import java.util.Map;

/**
 * @author zj on 2017-3-14.
 */

public class BaseApplication extends Application {
    private String rsa = "";
    @Override
    public void onCreate() {
        super.onCreate();
        HttpUtils.global = new IGlobal() {
            @Override
            public String getLoginName() {
                return null;
            }

            @Override
            public String getUdid() {
                return null;
            }

            @Override
            public String getOs() {
                return null;
            }

            @Override
            public String getOsVersion() {
                return null;
            }

            @Override
            public String getAppVersion() {
                return null;
            }

            @Override
            public String getSourceId() {
                return null;
            }

            @Override
            public String getVer() {
                return null;
            }

            @Override
            public String getTest() {
                return null;
            }

            @Override
            public String getHeight() {
                return null;
            }

            @Override
            public String getWidth() {
                return null;
            }

            @Override
            public String getUnique() {
                return null;
            }

            @Override
            public String getLevel() {
                return null;
            }

            @Override
            public String getDeviceModel() {
                return null;
            }

            @Override
            public String getMid() {
                return null;
            }

            @Override
            public String getUserId() {
                return null;
            }

            @Override
            public String getUserSession() {
                return null;
            }

            @Override
            public String getTest1() {
                return null;
            }

            @Override
            public int getLoginType() {
                return 0;
            }

            @Override
            public String getBindingPhone() {
                return null;
            }

            @Override
            public void setLoginName(String _loginName) {

            }

            @Override
            public void setHeight(String _height) {

            }

            @Override
            public void setWidth(String _width) {

            }

            @Override
            public void setUnique(String _unique) {

            }

            @Override
            public void setLevel(String _level) {

            }

            @Override
            public void setMid(String _mid) {

            }

            @Override
            public void setUserId(String _userId) {

            }

            @Override
            public void setUserSession(String _userSession) {

            }

            @Override
            public void setTest1(String _test1) {

            }

            @Override
            public void setBindingPhone(String _phone) {

            }

            @Override
            public void setLoginType(int _loginType) {

            }

            @Override
            public void setLatitude(String latitude) {

            }

            @Override
            public String getLatitude() {
                return null;
            }

            @Override
            public void setLongitude(String _longitude) {

            }

            @Override
            public String getLongitude() {
                return null;
            }

            @Override
            public String getCpsKey() {
                return null;
            }

            @Override
            public void setMac(String _mac) {

            }

            @Override
            public String getMac() {
                return null;
            }

            @Override
            public void setAndroidId(String _androidId) {

            }

            @Override
            public String getAndroidId() {
                return null;
            }

            @Override
            public String getRSA() {
                return rsa;
            }

            @Override
            public String getJsessionId() {
                return null;
            }

            @Override
            public void setRSA(String _rsa) {
                Log.e("setRSA",rsa);
                rsa = _rsa;
            }

            @Override
            public void setJsessionId(String _jsessionId) {

            }

            @Override
            public String getReferPage() {
                return null;
            }

            @Override
            public void setReferPage(String _referPage) {

            }

            @Override
            public Map<String, Long> getMeskillProductIds() {
                return null;
            }

            @Override
            public void saveMeskillProductIds() {

            }

            @Override
            public boolean includeMeskillProductId(String id) {
                return false;
            }

            @Override
            public void delMeskillProductId(String id) {

            }

            @Override
            public void putMeskillProductId(String _key, long _value) {

            }

            @Override
            public void setOnlineChargeMark(String status) {

            }

            @Override
            public void setIntegrationLuckDraw(String status) {

            }

            @Override
            public String getIntegrationLuckDraw() {
                return null;
            }

            @Override
            public String getOnlineChargeMark() {
                return null;
            }

            @Override
            public void setIsDellSellOut(boolean isSellOut) {

            }

            @Override
            public boolean getIsDellSellOut() {
                return false;
            }

            @Override
            public void setWXUnionId(String unionId) {

            }

            @Override
            public String getWXUnionId() {
                return null;
            }

            @Override
            public void setWXOpenId(String openId) {

            }

            @Override
            public String getWXOpenId() {
                return null;
            }

            @Override
            public void setSelectedCity(String city) {

            }

            @Override
            public String getSelectCity() {
                return null;
            }

            @Override
            public void setSelectedCityId(String cityid) {

            }

            @Override
            public String getSelectCityId() {
                return null;
            }

            @Override
            public void setHasPayPassword(boolean hasPayPassword) {

            }

            @Override
            public boolean getHasPayPassword() {
                return false;
            }

            @Override
            public void setWmCardInputValue(String price) {

            }

            @Override
            public String getWmCardInputValue() {
                return null;
            }
        };
    }
}

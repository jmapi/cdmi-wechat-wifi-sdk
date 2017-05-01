package pw.cdmi.wechat.wifi;

import java.util.List;

import pw.cdmi.wechat.wifi.model.ListWifiStoreResult;
import pw.cdmi.wechat.wifi.model.QRcodeStyle;
import pw.cdmi.wechat.wifi.model.StoreWifiResult;
import pw.cdmi.wechat.wifi.model.WifiStatistics;

public interface DeviceClient {

	// 添加密码型设备
	static final String Add_PasswordDrivice_API = "https://api.weixin.qq.com/bizwifi/device/add";

	// 添加portal型设备
	static final String Add_PortDrivice_API = "https://api.weixin.qq.com/bizwifi/apportal/register";

	// 查询设备
	static final String List_Drivices_API = "https://api.weixin.qq.com/bizwifi/device/list";

	// 删除设备
	static final String ToDelete_Drivice_API = "https://api.weixin.qq.com/bizwifi/device/delete";

	// 获取物料二维码
	static final String Get_QRcode_API = "https://api.weixin.qq.com/bizwifi/qrcode/get";
	
	// 获取公众号连网URL
	static final String Get_Public_Connect_Url_API = "https://api.weixin.qq.com/bizwifi/account/get_connecturl";
	
	// 获取Wi-Fi数据统计
	static final String List_WiFi_Statistics_API = "https://api.weixin.qq.com/bizwifi/statistics/list";

	// 第三方平台获取开插件wifi_token(暂不考虑这种形式)
	static final String Get_Wifi_Token_API = "https://api.weixin.qq.com/bizwifi/openplugin/token";
	
	// 获取WiFi门店列表
	static final String LIST_WIFI_STORES_API = "https://api.weixin.qq.com/bizwifi/shop/list";
	
	// 查询门店的WiFi信息
	static final String GET_WIFI_STORE_API = "https://api.weixin.qq.com/bizwifi/shop/get";
	
	// 修改门店网络信息
	static final String UPDATE_STORE_WIFI_API = "https://api.weixin.qq.com/bizwifi/shop/update";
	
	//清空门店网络及设备
	static final String CLEAN_STORE_WIFI_API = "https://api.weixin.qq.com/bizwifi/shop/clean";
	
	//设置商家主页
	static final String SET_STORE_HOMEPAGE_API = "https://api.weixin.qq.com/bizwifi/homepage/set";
	
	//查询商家主页
	static final String GET_STORE_HOMEPAGE_API = "https://api.weixin.qq.com/bizwifi/homepage/get";
	
	//设置顶部常驻入口文案
	static final String SET_STORE_BAR_API = "https://api.weixin.qq.com/bizwifi/bar/set";
	
	//设置连网完成页
	static final String GET_STORE_FINISHPAGE_API = "https://api.weixin.qq.com/bizwifi/finishpage/set";
	
	public void addPasswordDrivice(int shop_id,String ssid, String password);
	
	/**
	 * 
	 * @param shop_id
	 * @param ssid
	 * @param reset 重置secretkey，false-不重置，true-重置，默认为false
	 * @return 返回 secretkey 改造portal页面所需参数，该参数用于触发呼起微信的JSAPI接口的sign参数值的计算
	 */
	public String addPortDrivice(int shop_id,String ssid, boolean reset);
	
	public ListWifiStoreResult listDrivices(int pageindex, int pagesize);
	
	public ListWifiStoreResult listDrivices(int pageindex, int pagesize, int shop_id);
	
	public void deleteDrivice(String bssid);
	
	/**
	 * 获取物料二维码
	 * @param shop_id
	 * @param img_id
	 * @return
	 */
	public String getQRcode(String shop_id, QRcodeStyle img_id);
	
	/**
	 * 获取公众号连网URL
	 * 将此URL配置在公众号菜单上，可供用户点击菜单一键连网。只有当公众号为认证号，门店内所有设备均为密码型设备时才可以获得
	 * @return connect_url 公众号连网的URL
	 */
	public String getPublicConnectUrl();
	
	/**
	 * Wi-Fi数据统计
	 * 查询一定时间范围内的WiFi连接总人数、微信方式连Wi-Fi人数、商家主页访问人数、
	 * 连网后消息发送人数、新增公众号关注人数和累计公众号关注人数。
	 * 查询的最长时间跨度为30天
	 * @param begin_date
	 * @param end_date
	 * @param shop_id
	 */
	public List<WifiStatistics> ListStatistics(String begin_date, String end_date, String shop_id);
	
	/**
	 * 获取WiFi门店列表
	 * @param pageindex
	 * @param pagesize
	 * @return
	 */
	public ListWifiStoreResult listWifiStores(int pageindex,int pagesize);
	
	/**
	 * 查询门店的WiFi信息
	 * @param shop_id
	 * @return
	 */
	public StoreWifiResult getWifiStore(String shop_id);
	
	/**
	 * 修改门店网络信息
	 * @param credentials
	 * @param shop_id
	 * @param password
	 * @param ssid
	 */
	public void updateStoreWifi(String shop_id, String ssid, String password);
	
	/**
	 * 清空门店网络及设备
	 * @param credentials
	 * @param shop_id
	 */
	public void cleanStoreAllWifiDrivice(String shop_id);
}

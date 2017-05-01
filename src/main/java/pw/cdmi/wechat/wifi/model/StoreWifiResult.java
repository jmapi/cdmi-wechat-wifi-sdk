package pw.cdmi.wechat.wifi.model;

import lombok.Data;

@Data
public class StoreWifiResult {
	private String shop_id;					//门店ID
	private String shop_name;				//门店的名称
	private String ssid;					//无线网络设备的ssid
	private int protocol_type;				//门店内设备的设备类型，对应WifiDriviceType枚举
	private String sid;						//商户自己的id，与门店poi_id对应关系
	private String bssid;					//无线MAC地址
	
	private String password;
	private int ap_count;
	private int template_id;
	private String homepage_url;
	private int bar_type;					//顶部常驻入口上显示的文本内容,对应TopBarInfoStyle枚举
	private String finishpage_url;			//连网完成页链接
}

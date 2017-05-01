package pw.cdmi.wechat.wifi.model;

import lombok.Data;

@Data
public class WifiStatistics {
	private String shop_id;				//门店ID，-1为总统计
	private long statis_time;			//统计时间，单位为毫秒
	private int total_user;				//Wi-Fi连接总人数
	private int homepage_uv;			//商家主页访问人数
	private int new_fans;				//新增公众号关注人数
	private int total_fans;				//累计公众号关注人数
	private int wxconnect_user;			//微信方式连Wi-Fi人数
	private int connect_msg_user;		//连网后消息发送人数
}

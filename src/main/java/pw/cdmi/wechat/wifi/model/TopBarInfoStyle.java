package pw.cdmi.wechat.wifi.model;

/**
 * 顶部常驻入口上显示的文本内容,
 * 0--欢迎光临+公众号名称；
 * 1--欢迎光临+门店名称；
 * 2--已连接+公众号名称+WiFi；
 * 3--已连接+门店名称+Wi-Fi
 * @author 伍伟
 *
 */
public enum TopBarInfoStyle {
	WelcomeToPublicWXH(0),        	//欢迎光临+公众号名称
	WelcomeToStore(1),      		//欢迎光临+门店名称
    ConnectedToPublicWXH(2),       	//已连接+公众号名称+WiFi
    ConnectedToStore(3);       		//已连接+门店名称+Wi-Fi
    
    private int value;

    private TopBarInfoStyle(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return this.value;
    }
}

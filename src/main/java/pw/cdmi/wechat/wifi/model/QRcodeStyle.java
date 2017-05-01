package pw.cdmi.wechat.wifi.model;

/**
 * 微信二维码物料样式
 * @author 伍伟
 *
 */
public enum QRcodeStyle {
	PURE(0),        				//物料样式编号，0-纯二维码，可用于自由设计宣传材料；
	Complete(1);		     		//二维码物料，155mm×215mm(宽×高)，可直接张贴
    
    private int value;

    private QRcodeStyle(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return this.value;
    }
}

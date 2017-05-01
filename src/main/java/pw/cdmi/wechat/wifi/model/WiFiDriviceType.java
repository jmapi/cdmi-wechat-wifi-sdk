package pw.cdmi.wechat.wifi.model;

public enum WiFiDriviceType {
	
    NoDrivice(0),        			//未添加设备
    ProfessionalDrivice(1),      	//专业型设备
    PasswordDrivice(4),       		//密码型设备
    NativePortalDrivice(5),      	//portal自助型设备
    WXPortalDrivice(31);       		//portal改造型设备
    
    private int value;

    private WiFiDriviceType(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return this.value;
    }
}

package pw.cdmi.wechat.wifi;

public enum ErrorMessage {
    System_Error(-1,"系统错误，请稍后重试"),
    Invalid_Request(9002001, "不合法的请求方式"),
    System_Exception(9002002, "系统异常"),
    Network_Error(9002003, "网络异常，后台服务超时，请稍后再试"),
    Service_Request_Error(9002004, "后台服务调用异常"),
    Authentication_Failure(9002005, "签权失败"),
    Not_Allow_WIFI(9002006,"未开通微信连Wi-Fi连插件"),
    Missing_Required_Parameters(9002007, "缺少参数"),
    Invalid_Args(9002008, "不合法的参数"),
    Nonexistent_StoreId(9002009, "门店ID不存在"),
    Required_WX_Start(9002010, "ssid和密码均未以大写字母“WX”开头，两者中至少有一个以“WX”开头才可添加设备成功"),
    SSID_Exist_Chinese(9002011, "ssid不能包含中文字符"),
    Password_Exist_Chinese(9002012, "password不能包含中文字符"),
    Password_Length_Invalid(9002013, "password必需大于8个字符"),
    Password_Inconsistency(9002014, "门店下设备的密码不一样"),
    Device_Notbelong_Same_SSID(9002015, "门店下设备不属于同一SSID"),
    Device_Exists(9002016, "设备已添加过"),
    Device_Exists_Not_ToDelete(9002017, "设备不存在,无法删除"),
    Device_Not_ToTop(9002018, "门店下有专业设备，不能设置顶部常驻入口"),
	NoDevice_In_Store(9002019, "门店下没有设备"),
	Not_ToTop_StoreHome_Unauthorized_Account(9002020, "未认证的账号不能设置商家主页"),
	NoPassword_Device_Exists(9002022, "门店下已添加非密码型设备，无法再添加密码型设备"),
	Unauthorized_Public_Account(9002023, "未认证公众账号不能获取"),
	Not_NopasswordDevice_In_Account(9002024, "该账号下没有密码型设备"),
	AllPasswordDevice_Allow(9002025, "该账号下的所有设备，只有全为密码型设备才能获取"),
	List_Quantity_Exceeds_Limit(9002026, "查询列表超过最大限制"),
	NotDownload_QRCode_Img(9002027, "门店下是非密码型设备，不能下载二维码"),
	NoPortal_Drivice_Exists(9002028, "门店下已添加非portal改造型设备"),
	Not_Authorized(9002029, "非第三方授权不能获取"),
	Not_Registered_Portal_Drivice(9002030, "未开通注册portal型设备"),
	Networking_Not_Supported(9002031, "保留现有连网方式的门店，不支持扫二维码方式连网，无法下载二维码"),
	AllDrivice_Request_Support_WXWifi(9002032, "必需全部设备均为使用微信方式连网才可以获取"),
	NoDevice_In_Account(9002033, "该账号下无设备，至少有一台设备才能获取"),
	Exists_NotSupport_Drivice(9002034, "该账号下有专业设备，无法获取"),
	NotDelete_Not_Supported_Drivice(9002035, "保留现有连网方式的门店，无法清除门店网络及设备"),
	Portal_Drivice_Only_Modify_SSID(9002037, "portal型设备只能修改ssid"),
	SSID_Request_WX_Start(9002038, "ssid必须以大写字母“WX”开头"),
	No_Netword_In_Store(9002039, "门店下无网络信息，无法进行修改"),
	Professional_Drivice_NotAllow_Modify_NetInfo(9002040, "专业型设备的门店，不支持修改网络信息"),
	Unauthorized_Account_Forbidden_Operation(9002041, "未认证的账号不能设置"),
	Unmodified_Store_NotSupport_Operation(9002042, "保留现有连网方式的门店，不支持设置连网完成页"),
	SSID_Length_Dissatisfaction(9002044, "ssid长度需要在1到32个字节之间"),
	Duplicate_SSID(9007001, "门店下的ssid重复"),
	Different_DeviceType_In_Store(9007003, "与门店下的设备类型不一致"),
	NotFound_SSID_In_Store(9007004, "找不到门店ssid信息"),
	Different_SSID_Overlimit_In_Store(9007005, "门店下不同的ssid门店信息数量已超过最大限制"),
	Nosupport_Download_QRcode_For_Noagreement_store(9007006, "无协议设备的门店，不支持下载二维码"),
	Nosupport_Download_QRcode_For_Professional_Drivice_store(9007007, "专业型设备的门店，不支持下载二维码"),
	NotFound_CardCoupons(9008001, "找不到卡券"),
	Invalid_CardCoupons(9008002, "投放时间超过卡券有效期"),
	URL_Overlength(9008003, "url的长度不能超过255个英文字符"),
	URL_Contains_Chinese(9008004, "url不能包含中文字符");
    		
	
    private final int code;
    private final String description;
    
    private ErrorMessage(int code, String description){
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

}

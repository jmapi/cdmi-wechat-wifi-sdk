package pw.cdmi.wechat.wifi.model;

import java.util.List;

import lombok.Data;

@Data
public class ListWifiStoreResult {
	private int totalcount;
	private int pageindex;
	private int pagecount;
	private List<StoreWifiResult> records;
}

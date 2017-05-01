package pw.cdmi.wechat.wifi;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;
import pw.cdmi.core.http.HttpMethod;
import pw.cdmi.core.http.client.ClientException;
import pw.cdmi.core.http.client.RequestMessage;
import pw.cdmi.core.http.client.ResponseMessage;
import pw.cdmi.core.http.client.parser.ResponseParseException;
import pw.cdmi.wechat.WeChatClient;
import pw.cdmi.wechat.wifi.model.ListWifiStoreResult;
import pw.cdmi.wechat.wifi.model.QRcodeStyle;
import pw.cdmi.wechat.wifi.model.StoreWifiResult;
import pw.cdmi.wechat.wifi.model.WifiStatistics;
import pw.cdmi.wechat.wifi.parser.ResponseParsers;

public class DeviceClientImpl implements DeviceClient {
	protected WeChatClient client;

	public DeviceClientImpl(String accessKey, String secretAccessKey) {
		this.client = new WeChatClient(accessKey, secretAccessKey);
	}

	@Override
	public void addPasswordDrivice(int shop_id, String ssid, String password) {
		JSONObject wifi_request = new JSONObject();
		wifi_request.put("shop_id", shop_id);
		wifi_request.put("ssid", ssid);
		wifi_request.put("password", password);

		RequestMessage request = new RequestMessage();
		request.setEndpoint(URI.create(Add_PasswordDrivice_API));
		request.setMethod(HttpMethod.POST);
		request.setContent(wifi_request.toString());
		this.client.sendRequest(request);
	}

	@Override
	public String addPortDrivice(int shop_id, String ssid, boolean reset) {
		JSONObject wifi_request = new JSONObject();
		wifi_request.put("shop_id", shop_id);
		wifi_request.put("ssid", ssid);
		wifi_request.put("reset", reset);

		RequestMessage request = new RequestMessage();
		request.setEndpoint(URI.create(Add_PortDrivice_API));
		request.setMethod(HttpMethod.POST);
		request.setContent(wifi_request.toString());
		ResponseMessage response = this.client.sendRequest(request, true);
		try {
			return ResponseParsers.addPortDriviceResponseParser.parse(response);
		} catch (ResponseParseException rpe) {
			throw new ClientException(rpe.getMessage(), null, response.getRequestId(), rpe);
		}
	}

	@Override
	public ListWifiStoreResult listDrivices(int pageindex, int pagesize) {
		return listDrivices(pageindex, pagesize, -1);
	}

	@Override
	public ListWifiStoreResult listDrivices(int pageindex, int pagesize, int shop_id) {
		JSONObject wifi_request = new JSONObject();
		wifi_request.put("pageindex", pageindex);
		wifi_request.put("pagesize", pagesize);
		wifi_request.put("shop_id", shop_id);

		RequestMessage request = new RequestMessage();
		request.setEndpoint(URI.create(List_Drivices_API));
		request.setMethod(HttpMethod.POST);
		request.setContent(wifi_request.toString());
		ResponseMessage response = this.client.sendRequest(request, true);
		try {
			return ResponseParsers.listPageWifiResponseParser.parse(response);
		} catch (ResponseParseException rpe) {
			throw new ClientException(rpe.getMessage(), null, response.getRequestId(), rpe);
		}
	}

	@Override
	public void deleteDrivice(String bssid) {
		JSONObject wifi_request = new JSONObject();
		wifi_request.put("bssid", bssid);

		RequestMessage request = new RequestMessage();
		request.setEndpoint(URI.create(ToDelete_Drivice_API));
		request.setMethod(HttpMethod.POST);
		request.setContent(wifi_request.toString());
		this.client.sendRequest(request);
	}

	@Override
	public String getQRcode(String shop_id, QRcodeStyle img_id) {
		JSONObject wifi_request = new JSONObject();
		wifi_request.put("shop_id", shop_id);
		wifi_request.put("img_id", img_id.getValue());

		RequestMessage request = new RequestMessage();
		request.setEndpoint(URI.create(Get_QRcode_API));
		request.setMethod(HttpMethod.POST);
		request.setContent(wifi_request.toString());
		ResponseMessage response = this.client.sendRequest(request, true);
		try {
			return ResponseParsers.getWifiQRCodeUrlResponseParser.parse(response);
		} catch (ResponseParseException rpe) {
			throw new ClientException(rpe.getMessage(), null, response.getRequestId(), rpe);
		}
	}

	@Override
	public String getPublicConnectUrl() {

		RequestMessage request = new RequestMessage();
		request.setEndpoint(URI.create(Get_Public_Connect_Url_API));
		request.setMethod(HttpMethod.POST);
		ResponseMessage response = this.client.sendRequest(request, true);
		try {
			return ResponseParsers.getPublicConnectUrlResponseParser.parse(response);
		} catch (ResponseParseException rpe) {
			throw new ClientException(rpe.getMessage(), null, response.getRequestId(), rpe);
		}
	}

	@Override
	public List<WifiStatistics> ListStatistics(String begin_date, String end_date, String shop_id) {
		JSONObject wifi_request = new JSONObject();
		wifi_request.put("begin_date", begin_date);
		wifi_request.put("end_date", end_date);
		wifi_request.put("shop_id", shop_id);
		
		RequestMessage request = new RequestMessage();
		request.setEndpoint(URI.create(List_WiFi_Statistics_API));
		request.setMethod(HttpMethod.POST);
		request.setContent(wifi_request.toString());
		ResponseMessage response = this.client.sendRequest(request, true);
		try {
			return ResponseParsers.listWifiStatisticsResponseParser.parse(response);
		} catch (ResponseParseException rpe) {
			throw new ClientException(rpe.getMessage(), null, response.getRequestId(), rpe);
		}
	}

	@Override
	public ListWifiStoreResult listWifiStores(int pageindex, int pagesize) {
		Map<String, Integer> params = new LinkedHashMap<String, Integer>();
		params.put("pageindex", pageindex);
		params.put("pagesize", pagesize);
		JSONObject content = JSONObject.fromObject(params);
		RequestMessage request = new RequestMessage();
		request.setEndpoint(URI.create(LIST_WIFI_STORES_API));
		request.setMethod(HttpMethod.POST);
		request.setContent(content.toString());
		ResponseMessage response = this.client.sendRequest(request, true);
		try {
			return ResponseParsers.listWifiStoreResponseParser.parse(response);
		} catch (ResponseParseException rpe) {
			throw new ClientException(rpe.getMessage(), null, response.getRequestId(), rpe);
		}
	}

	@Override
	public StoreWifiResult getWifiStore(String shop_id) {
		JSONObject poi_json = new JSONObject();
		poi_json.put("shop_id", shop_id);

		RequestMessage request = new RequestMessage();
		request.setEndpoint(URI.create(GET_WIFI_STORE_API));
		request.setMethod(HttpMethod.POST);
		request.setContent(poi_json.toString());
		ResponseMessage response = this.client.sendRequest(request, true);
		try {
			return ResponseParsers.getWifiStoreResponseParser.parse(response);
		} catch (ResponseParseException rpe) {
			throw new ClientException(rpe.getMessage(), null, response.getRequestId(), rpe);
		}
	}

	@Override
	public void updateStoreWifi(String shop_id, String ssid, String password) {
		JSONObject wifi_json = new JSONObject();
		wifi_json.put("shop_id", shop_id);
		wifi_json.put("ssid", ssid);

		RequestMessage request = new RequestMessage();
		request.setEndpoint(URI.create(UPDATE_STORE_WIFI_API));
		request.setMethod(HttpMethod.POST);
		request.setContent(wifi_json.toString());
		this.client.sendRequest(request);
	}

	@Override
	public void cleanStoreAllWifiDrivice(String shop_id) {
		JSONObject wifi_json = new JSONObject();
		wifi_json.put("shop_id", shop_id);

		RequestMessage request = new RequestMessage();
		request.setEndpoint(URI.create(CLEAN_STORE_WIFI_API));
		request.setMethod(HttpMethod.POST);
		request.setContent(wifi_json.toString());
		this.client.sendRequest(request);
	}

}

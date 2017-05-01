package pw.cdmi.wechat.wifi.parser;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import pw.cdmi.core.http.client.ResponseMessage;
import pw.cdmi.core.http.client.parser.ResponseParseException;
import pw.cdmi.core.http.client.parser.ResponseParser;
import pw.cdmi.wechat.wifi.model.ListWifiStoreResult;
import pw.cdmi.wechat.wifi.model.StoreWifiResult;
import pw.cdmi.wechat.wifi.model.WifiStatistics;

public final class ResponseParsers {

	public static final AddPortDriviceResponseParser addPortDriviceResponseParser = new AddPortDriviceResponseParser();
	public static final ListPageWifiResponseParser listPageWifiResponseParser = new ListPageWifiResponseParser();
	public static final GetWifiQRCodeUrlResponseParser getWifiQRCodeUrlResponseParser = new GetWifiQRCodeUrlResponseParser();
	public static final GetPublicConnectUrlResponseParser getPublicConnectUrlResponseParser = new GetPublicConnectUrlResponseParser();
	public static final ListWifiStatisticsResponseParser listWifiStatisticsResponseParser = new ListWifiStatisticsResponseParser();
	public static final ListWifiStoreResponseParser listWifiStoreResponseParser = new ListWifiStoreResponseParser();
	public static final GetWifiStoreResponseParser getWifiStoreResponseParser = new GetWifiStoreResponseParser();
	
	public static final class EmptyResponseParser implements ResponseParser<ResponseMessage> {

		@Override
		public ResponseMessage parse(ResponseMessage response) throws ResponseParseException {
			// Close response and return it directly without parsing.
			try {
				response.close();
			} catch (IOException e) {
			}
			return response;
		}

	}

	public static final class AddPortDriviceResponseParser implements ResponseParser<String> {

		@Override
		public String parse(ResponseMessage response) throws ResponseParseException {
			String result = null;
			JsonReader reader;
			try {
				reader = new JsonReader(new InputStreamReader(response.getContent(), "UTF-8"));
				try {
					reader.beginObject();
					while (reader.hasNext()) {
						String name = reader.nextName();
						if ("data".equals(name) && reader.peek() != JsonToken.NULL) {
							reader.beginObject();
							while (reader.hasNext()) {
								name = reader.nextName();
								if ("secretkey".equals(name)) {
									result = reader.nextString();
								} else {
									reader.skipValue();
								}
								reader.endObject();
							}

						} else {
							reader.skipValue();
						}
					}
					reader.endObject();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						reader.close();
					} catch (IOException e) {
					}
				}
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					response.close();
				} catch (IOException e) {
				}
			}
			return result;
		}
	}
	
	public static final class ListPageWifiResponseParser implements ResponseParser<ListWifiStoreResult> {

		@Override
		public ListWifiStoreResult parse(ResponseMessage response) throws ResponseParseException {
			ListWifiStoreResult result = new ListWifiStoreResult();
			JsonReader reader;
			try {
				reader = new JsonReader(new InputStreamReader(response.getContent(), "UTF-8"));
				try {
					reader.beginObject();
					while (reader.hasNext()) {
						String name = reader.nextName();
						if ("data".equals(name) && reader.peek() != JsonToken.NULL) {
							reader.beginObject();
							while (reader.hasNext()) {
								name = reader.nextName();
								if ("totalcount".equals(name)) {
									result.setTotalcount(reader.nextInt());
								} else if ("pageindex".equals(name)) {
									result.setPageindex(reader.nextInt());
								} else if ("pagecount".equals(name)) {
									result.setPagecount(reader.nextInt());
								} else if ("records".equals(name) && reader.peek() != JsonToken.NULL) {
									reader.beginArray();
									List<StoreWifiResult> records = new ArrayList<StoreWifiResult>();
									while (reader.hasNext()) {
										reader.beginObject();
										StoreWifiResult wifi = new StoreWifiResult();
										while (reader.hasNext()) {
											name = reader.nextName();
											if ("shop_id".equals(name)) {
												wifi.setShop_id(reader.nextString());
											} else if ("ssid".equals(name)) {
												wifi.setSsid(reader.nextString());
											} else if ("protocol_type".equals(name)) {
												wifi.setProtocol_type(reader.nextInt());
											} else if ("bssid".equals(name)) {
												wifi.setBssid(reader.nextString());
											} else {
												reader.skipValue();
											}
										}
										records.add(wifi);
										reader.endArray();
									}
								} else {
									reader.skipValue();
								}
								reader.endObject();
							}

						} else {
							reader.skipValue();
						}
					}
					reader.endObject();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						reader.close();
					} catch (IOException e) {
					}
				}
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					response.close();
				} catch (IOException e) {
				}
			}
			return result;
		}
	}
	
	public static final class GetWifiQRCodeUrlResponseParser implements ResponseParser<String> {

		@Override
		public String parse(ResponseMessage response) throws ResponseParseException {
			String result = null;
			JsonReader reader;
			try {
				reader = new JsonReader(new InputStreamReader(response.getContent(), "UTF-8"));
				try {
					reader.beginObject();
					while (reader.hasNext()) {
						String name = reader.nextName();
						if ("data".equals(name) && reader.peek() != JsonToken.NULL) {
							reader.beginObject();
							while (reader.hasNext()) {
								name = reader.nextName();
								if ("qrcode_url".equals(name)) {
									result = reader.nextString();
								} else {
									reader.skipValue();
								}
								reader.endObject();
							}

						} else {
							reader.skipValue();
						}
					}
					reader.endObject();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						reader.close();
					} catch (IOException e) {
					}
				}
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					response.close();
				} catch (IOException e) {
				}
			}
			return result;
		}
	}
	
	public static final class GetPublicConnectUrlResponseParser implements ResponseParser<String> {

		@Override
		public String parse(ResponseMessage response) throws ResponseParseException {
			String result = null;
			JsonReader reader;
			try {
				reader = new JsonReader(new InputStreamReader(response.getContent(), "UTF-8"));
				try {
					reader.beginObject();
					while (reader.hasNext()) {
						String name = reader.nextName();
						if ("data".equals(name) && reader.peek() != JsonToken.NULL) {
							reader.beginObject();
							while (reader.hasNext()) {
								name = reader.nextName();
								if ("connect_url".equals(name)) {
									result = reader.nextString();
								} else {
									reader.skipValue();
								}
								reader.endObject();
							}

						} else {
							reader.skipValue();
						}
					}
					reader.endObject();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						reader.close();
					} catch (IOException e) {
					}
				}
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					response.close();
				} catch (IOException e) {
				}
			}
			return result;
		}
	}
	
	public static final class ListWifiStatisticsResponseParser implements ResponseParser<List<WifiStatistics>> {

		@Override
		public List<WifiStatistics> parse(ResponseMessage response) throws ResponseParseException {
			List<WifiStatistics> result = null;
			JsonReader reader;
			try {
				reader = new JsonReader(new InputStreamReader(response.getContent(), "UTF-8"));
				try {
					reader.beginObject();
					while (reader.hasNext()) {
						String name = reader.nextName();
						if ("data".equals(name) && reader.peek() != JsonToken.NULL) {
							reader.beginArray();
							result = new ArrayList<WifiStatistics>();
							while (reader.hasNext()) {
								reader.beginObject();
								WifiStatistics statistics = new WifiStatistics();
								while(reader.hasNext()){
									name = reader.nextName();
									if ("shop_id".equals(name)) {
										statistics.setShop_id(reader.nextString());
									} else if("statis_time".equals(name)) {
										statistics.setStatis_time(reader.nextLong());
									} else if("total_user".equals(name)) {
										statistics.setTotal_user(reader.nextInt());
									} else if("homepage_uv".equals(name)) {
										statistics.setHomepage_uv(reader.nextInt());
									} else if("new_fans".equals(name)) {
										statistics.setStatis_time(reader.nextInt());
									} else if("total_fans".equals(name)) {
										statistics.setTotal_fans(reader.nextInt());
									} else if("wxconnect_user".equals(name)) {
										statistics.setWxconnect_user(reader.nextInt());
									} else if("connect_msg_user".equals(name)) {
										statistics.setConnect_msg_user(reader.nextInt());
									} else {
										reader.skipValue();
									}
								}
								reader.endObject();
							}
							reader.endArray();
						} else {
							reader.skipValue();
						}
					}
					reader.endObject();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						reader.close();
					} catch (IOException e) {
					}
				}
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					response.close();
				} catch (IOException e) {
				}
			}
			return result;
		}
	}
	
	public static final class ListWifiStoreResponseParser implements ResponseParser<ListWifiStoreResult> {

		@Override
		public ListWifiStoreResult parse(ResponseMessage response) throws ResponseParseException {
			ListWifiStoreResult result = new ListWifiStoreResult();
			JsonReader reader;
			try {
				reader = new JsonReader(new InputStreamReader(response.getContent(), "UTF-8"));
				try {
					reader.beginObject();
					while (reader.hasNext()) {
						String name = reader.nextName();
						if ("data".equals(name) && reader.peek() != JsonToken.NULL) {
							reader.beginObject();
							while (reader.hasNext()) {
								name = reader.nextName();
								if ("totalcount".equals(name)) {
									result.setTotalcount(reader.nextInt());
								} else if ("pageindex".equals(name)) {
									result.setPageindex(reader.nextInt());
								} else if ("pagecount".equals(name)) {
									result.setPagecount(reader.nextInt());
								} else if ("records".equals(name) && reader.peek() != JsonToken.NULL) {
									reader.beginArray();
									List<StoreWifiResult> records = new ArrayList<StoreWifiResult>();
									while (reader.hasNext()) {
										reader.beginObject();
										StoreWifiResult store = new StoreWifiResult();
										while (reader.hasNext()) {
											name = reader.nextName();
											if ("shop_id".equals(name)) {
												store.setShop_id(reader.nextString());
											} else if ("shop_name".equals(name)) {
												store.setShop_name(reader.nextString());
											} else if ("ssid".equals(name)) {
												store.setSsid(reader.nextString());
											} else if ("protocol_type".equals(name)) {
												store.setProtocol_type(reader.nextInt());
											} else if ("sid".equals(name)) {
												store.setSid(reader.nextString());
											} else {
												reader.skipValue();
											}
										}
										records.add(store);
										reader.endArray();
									}
								} else {
									reader.skipValue();
								}
								reader.endObject();
							}

						} else {
							reader.skipValue();
						}
					}
					reader.endObject();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						reader.close();
					} catch (IOException e) {
					}
				}
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					response.close();
				} catch (IOException e) {
				}
			}
			return result;
		}
	}

	public static final class GetWifiStoreResponseParser implements ResponseParser<StoreWifiResult> {

		@Override
		public StoreWifiResult parse(ResponseMessage response) throws ResponseParseException {
			StoreWifiResult wifi = null;
			JsonReader reader;
			try {
				reader = new JsonReader(new InputStreamReader(response.getContent(), "UTF-8"));
				try {
					reader.beginObject();
					while (reader.hasNext()) {
						String name = reader.nextName();
						if ("data".equals(name) && reader.peek() != JsonToken.NULL) {
							reader.beginObject();
							wifi = new StoreWifiResult();
							while (reader.hasNext()) {
								name = reader.nextName();
								if ("shop_name".equals(name)) {
									wifi.setShop_name(reader.nextString());
								} else if ("ssid".equals(name)) {
									wifi.setSsid(reader.nextString());
								} else if ("password".equals(name)) {
									wifi.setPassword(reader.nextString());
								} else if ("protocol_type".equals(name)) {
									wifi.setProtocol_type(reader.nextInt());
								} else if ("ap_count".equals(name)) {
									wifi.setAp_count(reader.nextInt());
								} else if ("template_id".equals(name)) {
									wifi.setTemplate_id(reader.nextInt());
								} else if ("homepage_url".equals(name)) {
									wifi.setHomepage_url(reader.nextString());
								} else if ("bar_type".equals(name)) {
									wifi.setBar_type(reader.nextInt());
								} else if ("finishpage_url".equals(name)) {
									wifi.setFinishpage_url(reader.nextString());
								} else {
									reader.skipValue();
								}
							}
							reader.endObject();
						} else {
							reader.skipValue();
						}
					}
					reader.endObject();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						reader.close();
					} catch (IOException e) {
					}
				}
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					response.close();
				} catch (IOException e) {
				}
			}
			return wifi;
		}
	}
}

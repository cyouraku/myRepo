package io.github.cyouraku.geoIpServiceClient;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import net.webservicex.GeoIPServiceSoap;

public class GeoIpServiceClient {

	public static void main(String[] args) {

		System.out.println(args.length);

		if (args.length != 1) {
			System.out.println("Please input your ip address!");
		} else {
			String ipAddress = args[0];

			System.out.println(ipAddress);

			GeoIPService geoIPService = new GeoIPService();
			GeoIPServiceSoap geoIPServiceSoap = geoIPService.getGeoIPServiceSoap();
			GeoIP geoIP = geoIPServiceSoap.getGeoIP(ipAddress);

			try {
				System.out.println(geoIP.getCountryName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}

package com.phi.exercise;

public class ShopService {
	//exercise18
	private static ShopService shopService = new ShopService();

	private ShopService() {}

	public static ShopService getInstance() {
		return shopService;
	}
}

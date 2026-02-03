package com.ph2;

import com.google.gson.Gson;

import java.lang.reflect.Type;

public class TransJson2 {
	private final Gson gson;

	public TransJson2() {
		gson = new Gson();
	}

	public String toStringJson(Object obj) {
		return this.gson.toJson(obj);
	}

	public Object toObjectJson(String str, Type type) {
		return this.gson.fromJson(str, type);
	}
}

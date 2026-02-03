package com.phi;

import com.google.gson.Gson;

import java.lang.reflect.Type;

public class TransJson {
	private final Gson gson;

	public TransJson() {
		gson = new Gson();
	}

	public String toStringJson(Object obj) {
		return this.gson.toJson(obj);
	}

	public Object toObjectJson(String str, Type type) {
		return this.gson.fromJson(str, type);
	}
}

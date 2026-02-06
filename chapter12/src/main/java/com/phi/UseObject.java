package com.phi;

public class UseObject {
	private String id = "";
	private String name = "";

	@Override
	public Object clone() {
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof UseObject uobj) {
			if(this.id.equals(uobj.id)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Integer.parseInt(this.id);
	}

	@Override
	public String toString() {
		return "UseObject{" +
				"id:" + this.id +
				", name:" + this.name +
				"}";
	}
}

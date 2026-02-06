package com.phi;

public class UseObject {
	private String id = "";
	private String name = "";

	public String getId() { return this.id; }
	public String getName() { return this.name; }
	public void setId(String id) { this.id = id; }
	public void setName(String name) { this.name = name; }

	public UseObject() {}
	public UseObject(String id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public Object clone() {
//		return this;
		return new UseObject(this.getId(), this.getName());
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof UseObject uobj) {
			if(this.getName().equals(uobj.getName())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Integer.parseInt(this.getId()) + this.getName().hashCode();
	}

	@Override
	public String toString() {
		return "UseObject{" +
				"id:" + this.getId() +
				", name:" + this.getName() +
				"}";
	}
}

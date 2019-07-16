package com.xmut.entity;

public class FocusUser {

	private int id;
	private int main_id;
	private int focus_id;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMain_id() {
		return main_id;
	}
	public void setMain_id(int main_id) {
		this.main_id = main_id;
	}
	public int getFocus_id() {
		return focus_id;
	}
	public void setFocus_id(int focus_id) {
		this.focus_id = focus_id;
	}
	
	@Override
	public String toString() {
		return "FocusUser [id=" + id + ", main_id=" + main_id + ", focus_id=" + focus_id + "]";
	}
}

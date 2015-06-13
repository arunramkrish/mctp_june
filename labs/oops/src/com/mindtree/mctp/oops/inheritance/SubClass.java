package com.mindtree.mctp.oops.inheritance;

import com.mindtree.mctp.oops.BaseClass;

public class SubClass extends BaseClass {
	private String label;
	
	public SubClass(String label, String color, int w, int h) {
		super(color, w, h);
		this.label = label;
	}

	public SubClass() {
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	

}

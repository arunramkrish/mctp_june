package com.mindtree.mctp.oops;

import com.mindtree.mctp.oops.inheritance.SubClass;

public class MainClass {

	public MainClass() {
	}

	public static void main(String[] args) {
		SubClass sc1 = new SubClass();
		sc1.setLabel("Submit");
		System.out.println(sc1);
		
		BaseClass bc1 = new BaseClass("red", 100, 200);
		System.out.println(bc1);
		
		System.out.println(bc1.getColor() + "\nwid" + bc1.getWidth() + "\nht"
				+ bc1.getHeight());

		BaseClass bc2 = new BaseClass("blue", 200, 300);
		System.out.println(bc2);
		
		bc1.setColor("black");
		
		BaseClass.setColor("yellow");
		
		System.out.println(bc1);
		System.out.println(bc2);
		
		
	}

}

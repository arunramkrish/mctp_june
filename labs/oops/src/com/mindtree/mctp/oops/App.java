package com.mindtree.mctp.oops;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		List<BaseClass> bc = new ArrayList<BaseClass>();

		BaseClass b1 = new BaseClass("red", 24, 50);
		BaseClass b2 = new BaseClass("red", 24, 50);

		bc.add(b1);
		bc.add(b2);
		
		System.out.println(b1.equals(b2));
		
		for (BaseClass b : bc) {
			System.out.println(b);
		}
	}

}

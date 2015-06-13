package com.mindtree.mctp.oops;

public class BaseClass {
	private static String color;
	private int width;
	private int height;

	public BaseClass() {
	}

	public BaseClass(String color, int width, int height) {
		super();
		color = color;
		this.width = width;
		this.height = height;
	}

	public static String getColor() {
		return color;
	}

	public static void setColor(String col) {
		color = col;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public String toString() {
		return "BaseClass [color=" + color + ", width=" + width + ", height="
				+ height + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + height;
		result = prime * result + width;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseClass other = (BaseClass) obj;
		if (height != other.height)
			return false;
		if (width != other.width)
			return false;
		return true;
	}

	
}

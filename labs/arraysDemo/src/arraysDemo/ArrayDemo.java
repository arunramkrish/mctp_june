package arraysDemo;

public class ArrayDemo {

	public static void main(String[] args) {
		int[] integerArray = { 1, 2, 3, 5, 8, 13 };
		String[] strArray = { "Arun", "Ram", "Krish" };

		String[] dynamic = new String[integerArray.length];
		for (int i = 0; i < dynamic.length; i++) {
			dynamic[i] = i + "th element in fibonacci " + integerArray[i];
		}

		// print array
		for (String item : dynamic) {
			System.out.println(item);
		}
	}

}

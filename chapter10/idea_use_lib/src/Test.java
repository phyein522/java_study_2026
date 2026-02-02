import com.google.gson.Gson;

public class Test {
	public void runTest() {
		int[] integers = {1, 2, 3, 4, 5, 6};
		Gson gs25 = new Gson();
		String s = gs25.toJson(integers);
		System.out.println(s);

		IntArr intArr = new IntArr();
		intArr.setIntegers(new int[] {6, 5, 4, 3, 2, 1});
		String str = gs25.toJson(intArr);
		System.out.println(str);
	}
}

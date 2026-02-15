package sample;

import java.util.ArrayList;
import java.util.List;

public class Stringfilerletter {
	public static void main(String[] args) throws java.lang.Exception {
		// your code goes here

		String[] str = { "1", "2", "azz", "s", "2c", "3", "5b", "6" };
		// azz,s,Zc,5b
		List<String> output = new ArrayList<>();

		for (String temp : str) {
			boolean hasletter = false;

			for (int i = 0; i < temp.length(); i++) {

				char ch = temp.charAt(i);

				if (Character.isLetter(ch)) {
					hasletter = true;
					break;
				}

			}

			if (hasletter) {

				output.add(temp);

			}

		}

		System.out.println(output);

	}

}

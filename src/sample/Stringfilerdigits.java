package sample;


import java.util.List;
import java.util.Arrays;

public class Stringfilerdigits {
	public static void main(String[] args) {
		
	

	String[] input = { "1", "2", "azz", "s", "2c", "3", "5b", "6" };
	// azz,s,Zc,5b
	List<String> output  = Arrays.stream(input).filter(s->s.chars().allMatch(Character::isDigit)).toList();

     System.out.println(output); // 1,2,3,6
 }
}
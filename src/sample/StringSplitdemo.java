package sample;

public class StringSplitdemo {
	public static void main(String args[]) {
	String s1="My name is Siddhesh";  
	String[] words=s1.split("\\s");//splits the string based on whitespace  
	//using java foreach loop to print elements of string array  
	//for(String w:words){ 
	//for(int i =0;i<words.length ;i++) {	
		
	//System.out.println(words[i]); }
	
	String fname = words[3];
	String is = words[2];
	String my = words[0];
	String name = words[1];
	
	System.out.println(fname+is+my+name);
	
	
	//}  

}
}

package sample;

public class stringcampare {
	public static void main(String[] args) {
		
		String str="siddhesh";
		String str1=new String("siddhesh");
		String str2 =new String("siddhesh");
		String str3="siddhesh";
				
				System.out.println(str.equals(str3)); //true
				System.out.println(str1==str2);       //false
				System.out.println(str==str3);	     //true
				System.out.println(str==str1);		 //false
		
		
	}  

}

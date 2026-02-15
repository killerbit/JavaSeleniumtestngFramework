package sample;

public class RevesreInteger {
	public static void main(String[] args) {
		System.out.println(RevesreInteger.reverseint(3712));
		
	}
	//% modulous ope
	/// devide
	
public static int reverseint(int x) {
	int lastdigit;
	int reve=0;
	
	while(x!=0) {
		
	lastdigit=x%10;
	if(reve>Integer.MAX_VALUE/10  || (reve ==Integer.MAX_VALUE/10 && lastdigit >7)) {
		 return 0;//overflow integer size
		
		
	}
	if(reve<Integer.MIN_VALUE/10  || (reve ==Integer.MIN_VALUE/10 && lastdigit <-8)) {
		 return 0;//overflow negative integer size
		
		
	}
	
	//advance edge case
	
	
	reve=reve*10+lastdigit;
	
	x=x/10;
	

	
	
	}
		
	return reve;
 	
	}

}

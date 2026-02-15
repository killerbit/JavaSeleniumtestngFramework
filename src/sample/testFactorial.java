package sample;

import java.math.BigInteger;

public class testFactorial {
	public static void main(String[] args) {
		
	
		testFactorial.calculatefact(50);
	}

	private static void calculatefact(int n) {
		// TODO Auto-generated method stub
		BigInteger result=BigInteger.ONE;
		for(int i=1;i<=n;i++ ) {
			
			if(n==0) {
				System.out.println(1);
				
			}
			result=result.multiply(BigInteger.valueOf(i));
			
			
			
			
			
		}
		System.out.println(result);
		
	}
	
	 

}

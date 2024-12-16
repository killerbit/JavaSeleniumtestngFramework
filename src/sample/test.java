package sample;

import java.util.HashSet;
import java.util.Set;

public  class test {
	
	public static void main(String args[]) {
		
		//test t = new test();
		
		parent p= new child();
		p.dispaly();
		
		
		child c = new child();
		c.dispaly();
	//int arr[]= {1,2,8,5,1,2,3,2,23};
	
	//Set<Integer> s=new HashSet<Integer>(); 
	//for(int i=0;i<arr.length;i++) {
	//	s.add(arr[i]);
		
	}
	//System.out.println(s);
	
			
		
	
}
	
	
	

  class parent {
	
	
		
		
	public void dispaly() {
		
		int s=10;
	System.out.println(s);
		
		
	}
	
			
		
	
}



  class child extends parent {
	
	

	
	public void dispaly() {
		
		int s=5;
	System.out.println(s);
		
		
	}
	
			
		
	
}


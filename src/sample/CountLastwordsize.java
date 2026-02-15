package sample;

public class CountLastwordsize {
	public static void main(String[] args) {
		
	
	
	
	//CountLastwordsize.countlaststr("I love java Automation");
	CountLastwordsize.printevenstring("I love erfd hfgdjk java Automation");
	
	
	}

	private static void printevenstring(String string) {
		// TODO Auto-generated method stub
		
		String words[]=string.split(" ");
		
		for(String word:words) {
			//int size=;
			if(word.length()%2==0) {
				
				System.out.println(word);
			}
			
			
			
		}
		
		
	}

	private static void countlaststr(String string) {
		// TODO Auto-generated method stub
		
		int count=0;
		string.trim();
		char intarray[]=string.toCharArray();
		
		for(int i=intarray.length-1;i>=0;i--) {
			
			if(intarray[i]!=' ') {
				
				count++;
				
			} 
			else {
				
				if(count>0) {
					System.out.println(count); 
					break;
			
					
				}
			}
			
		}
		
		
		
	}

}

package sample;

public class movezeros {
	public static void main(String[] args) {
		
	
	
	int a[]= {0,1,0,2,5,4,0,3,0,}; //1,2,4,3,0,0,0
	movezeros.moveszerosfromarray(a);
	}

	private static void moveszerosfromarray(int[] arr) {
		
		//2 pinter technique
		
		int current=0;    //loop
		int nonzero=0;
		
		for(current=0;current<arr.length;current++) {
			if(arr[current]!=0) {
				//swap
				int temp=arr[nonzero];
				arr[nonzero]=arr[current];
				arr[current]=temp;
				nonzero++;
				
			}
			
		}
	
		for(int i:arr) {
		System.out.println(i);}
	
	}

	

}

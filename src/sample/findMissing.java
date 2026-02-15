package sample;

public class findMissing {

	public static void main(String[] args) {
		//int a[]={2,3,4,5,6,7,8,9,10};
		int a[]={1,2,3,5};
		
		int n=5;
		System.out.println(findMissing.missing(a));
		System.out.println(findMissing.missing2(a,n));
		System.out.println(findMissing.missingbitwise(a,n));
		
	
	}

	private static int missingbitwise(int[] a,int n) {
		// TODO Auto-generated method stub
		
		int missingnum=0;
		
		for(int i:a) {
			
			missingnum=missingnum^i;
			
			
		}
		for(int i=0;i<=n;i++) {
			
			missingnum=missingnum^i;
		}
		
		return missingnum;
	}

	private static int missing(int[] a) {
		// TODO Auto-generated method stub
		
		int sum=0;
		int expsum=0;
		for(int i=0;i<a.length;i++) {
			
			sum=a[i]+sum;
		}
		//System.out.println(sum);
		
		
		for(int i=a.length+1;i>0;i--) {
			//System.out.println(i);
					
					expsum=i+expsum;
				}
	//	System.out.println(expsum);
		
		
		
		return expsum-sum;
	}
	private static int missing2(int[] a,int n) {
		// TODO Auto-generated method stub
		
		int sum=0;
		int expsum=(n*(n+1))/2;
		for(int i=0;i<a.length;i++) {
			
			sum=a[i]+sum;
		}
	
		return expsum-sum;
	}
	
	

}

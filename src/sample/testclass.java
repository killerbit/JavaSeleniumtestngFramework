package sample;

public class testclass{
    public  int numberOfWorker=10;
   
    public String name;
    
    public void testclassm(String name) {
        this.name = name;
        numberOfWorker++; // increment the static variable every time a new 	
    	System.out.println(numberOfWorker);//Person is created
    }


	public static void main(String[] args) {
		
		testclass d=new testclass();
		d.testclassm("comp");
	
		
		
	
		

	}	

}

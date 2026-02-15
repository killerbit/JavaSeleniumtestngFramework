package sample;
import java.util.*;
import java.lang.*;
import java.io.*;

public class sechigh {
    
   
    	public static void main (String[] args) throws java.lang.Exception
    	{
    	int a[]={3,4,5,6,7,9,2,10};
    	int high,sec;
    	if(a[0]>a[1]){
    	    
    	    high=a[0];
    	    sec=a[1];
    	    
    	}else{
    	    
    	    high=a[1];
    	    sec=a[0];
    	}
    	for(int i=2;i<a.length;i++){
    	    
    	    if(a[i]>high){
    	        
    	        sec=high;
    	        high=a[i];
    	    }
    	    else if(a[i]>sec && a[i]!=high){
    	        
    	        sec=a[i];
    	    }
    	    
    	    
    	}
    	System.out.println(sec);
    	
    	
    	
    
    	
    }
}




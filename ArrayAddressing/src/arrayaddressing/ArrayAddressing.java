package arrayaddressing;

import java.io.*;

public class ArrayAddressing {

   public static void main(String[] args) throws IOException{
       BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        
      
       // a = sA + (i * ub2 * ub3 * ub4 + j * ub3 * ub4 + k * ub4 + l) * esize
       System.out.println((2000 + ((2) * (3) * (3) * (6) + (2) * (3) * (6) + (0) * (6) + (4)) * 4));
       
       
   }
   
   
   
    
}

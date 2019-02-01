package recordsaddressing;

import java.io.*;

public class RecordsAddressing {

    
    public static void main(String[] args)throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        
        int[] arr, index, fieldByte;
        String[][] fields;
        int dimension, i, field, sA, prodUB = 1, eSize=0, byteSize;
        String fieldName;
        
        System.out.print("Enter database dimensions: ");
        dimension = Integer.parseInt(input.readLine());
        
        arr = new int[dimension];
        index = new int[dimension];
        
        for(i = 0 ; i < arr.length ; i++){
            System.out.print("Upper Bound " + (i+1) + ": ");
            arr[i] = Integer.parseInt(input.readLine());
            prodUB*=arr[i];
        }
        
        System.out.println("");
        
        System.out.print("Number of fields in each record: ");
        field = Integer.parseInt(input.readLine());
        
        fields = new String[field][3];
        fieldByte = new int[field];
                
        for(i = 0 ; i < fields.length ; i++){
            for(int j = 0 ; j < fields[i].length ; j++){
                switch (j) {
                    case 0:
                        System.out.print("FIELD " + (i+1) + " NAME: ");
                        fields[i][j] = input.readLine();
                        break;
                    case 1:
                        System.out.print("FIELD " + (i+1) + " LENGTH: ");
                        fields[i][j] = input.readLine();
                        break;
                    case 2:
                        System.out.print("FIELD " + (i+1) + " DATATYPE: ");
                        fields[i][j] = input.readLine();
                        break;
                }
            }
            
            byteSize = computeByteSize(fields[i][2], Integer.parseInt(fields[i][1]));
            fieldByte[i] = byteSize;
            System.out.println("");
            System.out.println("Data Field " + fields[i][0] + " is " + byteSize + " bytes in size.");
            System.out.println("");
            eSize+=byteSize;
        }
        
        System.out.println("");
        
        System.out.print("Enter starting address: ");
        sA = Integer.parseInt(input.readLine());
        
        System.out.println("eSize per record: " + eSize);
        System.out.println("Your database can hold " + prodUB + " records");
        System.out.println("Your database consumes " + (eSize*prodUB) + " bytes of memory space");
        
        System.out.println("");
        
        System.out.println("SEARCH FOR THE ADDRESS OF A FIELD IN A SPECIFIC RECORD FROM THE DATABASE");
        for(i = 0 ; i < index.length ; i++){
            System.out.print("Records search index at dimension 1: ");
            index[i] = Integer.parseInt(input.readLine());
        }
        System.out.print("Input field name to search in the record: ");
        fieldName = input.readLine();
        
        for(i = 0 ; i < fields.length ; i++){
            if(fieldName.equalsIgnoreCase(fields[i][0])){
                System.out.println("The address of this record's " +fieldName+ " is located at: " + computeAddress(arr, index, sA, eSize, fieldByte[i]));
            }
        }
        
        
    }
    
    public static int computeAddress(int[] arr, int[] index, int sA, int eSize, int fieldSize){
        int address = 0, i = 0, j = 0, prodUB = 1;
        
        for(i = 0 ; i < arr.length ; i++){
            for(j = i+1 ; j < arr.length ; j++){
                prodUB*=arr[j];
            }
            
            prodUB*=index[i];
            address+=prodUB;
        }
        
        return (sA + (prodUB * eSize)) - fieldSize;
    }
    
    
    public static int computeByteSize(String type, int length){
        int prod = 0;
        
        switch(type){
            case "byte":
                prod = length * 1;
                break;
            case "short":
                prod = length * 2;
                break;
            case "int":
                prod = length * 2;
                break;
            case "long":
                prod = length * 8;
                break;
            case "float":
                prod = length * 4;
                break;
            case "double":
                prod = length * 8;
                break;
            case "char":
                prod = length * 1;
                break;
            case "string":
                prod = length * 12;
                break;
            case "boolean":
                prod = length * 1;
                break;  
        }
        
        return prod;  
    }
    
    
    
    
    
    
}

package activityuno;

import java.util.*;

public class ActivityUno{

    public static void main(String[] args) {
        /*
        Scanner in = new Scanner(System.in);
        int total, i;
        int[] arr;

        System.out.print("Please enter the number of inputs: ");
        total = in.nextInt();
        arr = new int[total];

        for(i = 0 ; i < arr.length ; i++){
            arr[i] = in.nextInt();
        }
        */
	//pigeonHole(arr);
        pigeonHole();
    }

    public static void pigeonHole(){
        //UNSORTED ARRAY arr[]
        int[] arr = {2,1,46,1,64,68,465,168,46,84,65,646,4,8674};
        
        //Pigeon Hole pgHole[]
        int[] pgHole;
        //Here we assigned a value to the variable min to index 0 and variable max to index 0
        int min = arr[0], max = arr[0],  counter = 0, loop = 0;
        int i;

        //Prints the UNSORTED ARRAY arr[]
        System.out.println("UNSORTED ARRAY");
        for(int y: arr){
            System.out.print(y + "\t");
        }

        //This takes the minimum and maximum elements of the array arr[]
        for(i = 0 ; i < arr.length ; i++){
            //Checks if the element of the nth(i) index is less than the value of min variable
            if(arr[i] < min){
                min = arr[i];
            }
            //Checks if the element of the nth(i) index 
            //is greater than the max value of variable
            else if(arr[i] > max){
                max = arr[i];
            }
        }

        //We declare a new array with a length of the value of the max variable
        pgHole = new int[max];
        //Auto fill the new array with 0's
        Arrays.fill(pgHole, 0);

        //Increments the elements of the new array according to the UNSORTED ARRAY arr[]
        for(i = 0 ; i < arr.length ; i++){
            //where the value of nth index in the UNSORTED ARRAY arr[] 
            //minus to 1 is the paramater of the new array pgHole[]
            pgHole[arr[i] - 1]++;
        }

        //This will sort the UNSORTED ARRAY arr[]
        //loop variable is used for array arr[]
        loop = 0;
        //while the i variable is used for array pgHole[]
        for(i = 0 ; i < pgHole.length ; i++){
            //the counter variable takes the value of the nth(i) index
            counter = pgHole[i];

            //if the value of counter is greater than 0 then 
            //the variable min will take the value of i
            if(counter > 0) min = (i+1);

            //the while loop executes if the counter variable is greater than 0
            while(counter > 0){
                //while counter is greater than 0
                //the nth(loop) index of array arr[] will take the value of variable min
                arr[loop] = min;
                //increments the loop variable (plus 1)
                loop++;
                //decrements the counter variable (minus 1)
                counter--;
            }
        }

        System.out.println();

        //Prints the SORTED ARRAY arr[]
        System.out.println("SORTED ARRAY");
        for(int y: arr){
            System.out.print(y + "\t");
        }
    }
}

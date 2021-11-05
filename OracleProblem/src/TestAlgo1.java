/* IMPORTANT: class must not be public. */

/*
 * uncomment this if you want to read input.
 * */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class TestAlgo1 {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
        */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = Integer.parseInt(line);
        line = br.readLine();
        String [] arr = line.split(" ");
        List<Integer>timeNeeded = new ArrayList<>();
        
        int minIndex = -1 , minVal = Integer.MAX_VALUE;
        Set<Integer>indexesTried = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(arr[i]);
            if(val < minVal){
                minVal = val;
                minIndex = i;
            }
            timeNeeded.add(val);
        }
        
        
        int minTimeTaken = Integer.MAX_VALUE;
        int thisMinIndex = minIndex;
        while(indexesTried.size() != n){
              indexesTried.add(thisMinIndex);
              int timeForThis = minVal;
              int k = thisMinIndex;
             
              while((k+1)%n != thisMinIndex && k+1 < n){
                  timeForThis += timeNeeded.get(k+1);
                  k++;
              }

              if(minTimeTaken < timeForThis){
                 minTimeTaken = timeForThis;
                 minIndex = thisMinIndex;
               }
               
               int res = getMinIndex(indexesTried , timeNeeded) ;
               if(res > -1){
                  thisMinIndex = res;
                  timeForThis = timeNeeded.get(thisMinIndex);
               }

        }
        

       

      
       System.out.println(minIndex+1);
    }

    public static int getMinIndex(Set<Integer>indexesTried , List<Integer>timeNeeded ){
        int n = timeNeeded.size();
        int minIndex = -1;
        int minVal = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
           if(!indexesTried.contains(i)){
            int val = timeNeeded.get(i);
            if(val < minVal){
                minVal = val;
                minIndex = i;
            }
           }
    }

       return minIndex;
    }   
}
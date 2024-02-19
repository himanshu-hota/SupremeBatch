import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main"
class Main {

    public static void sub(int arr[],ArrayList<Integer> ans,int i){
      if(i >= arr.length){
          for(int x : ans) System.out.print(x + ", ");
          System.out.println();

          return;
      }

      // include
      ans.add(arr[i]);
      sub(arr,ans,i+1);
      ans.remove(ans.size()-1);

      // exclude
      sub(arr,ans,i+1);

    }

    public static void main(String[] args) {
        int arr[] = {1,2,3};

        sub(arr,new ArrayList<Integer>(),0);
    }
}

// Method 1

 public int findMinDifference(List<String> timePoints) {
        
        
        int arr[] = new int[timePoints.size()]; // an array to store time in integer
        int k =0; //index counter for time array

        for(String str : timePoints){
            
            // calculate hour of current string
            int hour = Integer.parseInt(str.substring(0,2));
            // calculate minute of current string
            int minute = Integer.parseInt(str.substring(3,5));
            // calculate total minutes 
            int totalMinutes = hour*60 + minute;
            // add this minutes to the array
            arr[k++] = totalMinutes;
        }

        // sort the minutes array to reduce number of comparasion
        Arrays.sort(arr);
        
        // initialize initial min value
        int min = Integer.MAX_VALUE;
        
        // loop till n-1 element to calculate min value
        for(int i =0 ;i < arr.length-1; i++){
            int currDiff = arr[i+1] - arr[i];
            // get minimum of current and min value
            min = Math.min(min, currDiff);
        } 

        // compare last and first element as it also may be the answer because time goes circulary --> 00:00 comes after 23:59 every time 
        int lastDiff1 = (arr[0] + 1440) -  arr[arr.length-1];
        int lastDiff2 = arr[arr.length-1] - arr[0]; // 2nd edge case
        int lastDiff = Math.min(lastDiff1,lastDiff2);
        
        min = Math.min(min,lastDiff);

        // return final answer
        return min;

    }

// Method 2 
 
class Solution {
    // Function to find the minimum time difference among a list of time points.
    public int findMinDifference(List<String> timePoints) {
        // Get the number of time points.
        int n = timePoints.size();
        
        // Array to store the converted time points in minutes.
        int times[] = new int[n];
        
        // Counter variable for array index.
        int k= 0;

        // Convert each time point to minutes and store in the times array.
        for(String time : timePoints){
            // Extract hour and minutes from the time string.
            int hour = Integer.parseInt(time.substring(0,2));
            int minutes = Integer.parseInt(time.substring(3,5));

            // Calculate total minutes.
            int totalMinutes = hour * 60 + minutes;

            // Store the total minutes in the times array.
            times[k++] = totalMinutes;
        }

        // Sort the times array in ascending order.
        Arrays.sort(times);

        // Variable to store the minimum time difference.
        int min = Integer.MAX_VALUE;
        
        // Iterate through the sorted times array to find the minimum difference.
        for(int i = 0; i < n-1; i++){
            min = Math.min(min, times[i+1] - times[i]);
        }

        // Calculate the time difference between the last and first time points considering circular time.
        int lastDiff = (times[0] + 1440) - times[n-1];
        
        // Update the minimum difference if the circular difference is smaller.
        min = Math.min(lastDiff, min);

        // Return the minimum time difference.
        return min;
    }
}


LeetCode : https://leetcode.com/problems/minimum-time-difference/

CodeStudio : 
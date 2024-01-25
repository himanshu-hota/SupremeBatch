public class Solution {

    public static boolean canWePlace(int arr[],int k,double dist){
        int stations = 0;

        // get the count of gas stations it would take to place in equal distance of given dist.
        for(int i = 0; i< arr.length -1; i++){
            stations += ( (arr[i+1] - arr[i])/dist );
        }

        // if we required k or less stations then it is ok, otherwise no possible solution.
        return stations <=k ;
    }
    public static double MinimiseMaxDistance(int []arr, int k){

        double start = 0;
        double end = 0;

        for(int x : arr) end += (double)(x);

        double ans = 0;
        double diff = 1e-6;
        while(end-start > diff){
            double mid = start + (end - start)/(2.0);

            // try placing stations in between of mid distance
            if(canWePlace(arr,k,mid)){
                // if yes then try minimizing the distance further
                end = mid;
                ans = mid;
            }else{
                // if could not plcae k station (required less or more than k stations) then try expanding the distance.
                start = mid;
            }
        }

        return ans;
    }
}

Note : start = mid , end = mid hi karna hai , agar -1 kiya to pura 1.0 ka range chhut jaegea.

Steps : 1. The max distance between any two stations would be the upper bound (the max distance) in which we have to perform operaions.
        2. Get the max distance between any two stations.
        3. Run loop till we have the distance more than 1e-6 (10 to the power -6 or 0.000001).
        4. Get the middle distance and check if we try to place gas station in the given array how many gas stations would it take to divide the distance into equal distances.
        5. If we could place k or less stations in between the given stations(the array), then it is a possible distance in between which we can place k new stations to miinimize the distance between the gas stations, now try to minimize this distance.
        6. If we could not then we need more distance to place k gas stations to minimize the distances between each station.

CodeStudio : https://www.codingninjas.com/studio/problems/minimise-max-distance_7541449?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
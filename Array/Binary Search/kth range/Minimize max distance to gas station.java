public class Solution {

    public static boolean canWePlace(int arr[],int k,double dist){
        int stations = 0;
        for(int i= 0; i <= arr.length-2; i++){
            int distanceBetweenTwoGasStation = arr[i+1] - arr[i];
            // if current distance is >= than allowed distance then only place the gas station otherwise not, because it would be unnecessary.
            if(distanceBetweenTwoGasStation >= dist){
                stations += (distanceBetweenTwoGasStation)/dist;
            }
        }

        return stations <= k;
    }
    public static double MinimiseMaxDistance(int []arr, int k){

        double start = 0;
        double end = arr[arr.length - 1] - arr[0]; // this is optimized

        // for(int x : arr) end += (double)(x); this is also fine but slower 

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

Steps : 1. The max distance is the distance between first and last gas staion.(upper bound).
        2. We have to place k gas station in this array.
        3. We know that we can place gas staion at max the arr[i+1] - arr[i] distance.
        4. Perform binary search and get a mid, this mid is the distance in which we want to place gas stations.
        5. Check if can place at most k gas stations in the distance/gap of mid distance.
        6. How would we do that? ==> Get the distance of any two gas station and check how many stations would you need if you want to put gas station between these two considering that you are allowed to put gas station at mid distance.
        7. Get the count of all gas station by calculating in consecutive stations.
        8. if at max you got k or less gas station then this distance is a possible answer so now try to reduce the distance.
        9. if you need more then k gas stations then you need to increase the distance.

Hindi : 1. First and last gas station ka jo difference hai wahi max distance hoga jisme hum optimally naye gas stations place kar sakte hai.
        2. Binary search lagao aur ek mid pick karo, isi mid distance me agar hum place karna chahe to kitne gas station lagenge check karo.
        3. Kaise check karoge? -> kinhi bhi do gas station k bich ka difference nikalo aur check karo ki kya ye allowed distance se jyada hai (imp jyada hoga tabhi place karoge na agar kam hai to need hi nahi hai place karne ki kyoki distance minimize karna hai).
        4. Agar current distance allowed distance se jyada hai to place karo kyoki distance kam karna hai bhaisab. aur pata karo ki kitne stations lagenge yaha. Aise hi sar paris ka check karo aur total stations nikalo.
        5. Agar nikala hua stations allowed stations k equal ya kamhai to ye ek possible solution hai to ab distance ko minimize karna padega.
        6. Otherwise distance ko badhana padega.
        


CodeStudio : https://www.codingninjas.com/studio/problems/minimise-max-distance_7541449?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
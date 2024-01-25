	public static boolean isPossible(ArrayList<Long> trees , long m , long sol) {
		// initial wood length
		long woodCollected = 0;
		
		for(int i = 0; i < trees.size(); i++) {
            // if height of the tree is greater than sol then only include that tree
			if(trees.get(i) > sol) {
                // add length of wood after chopping
				woodCollected += trees.get(i) - sol;
			}
		}
		
        // check if collected wood is equal or greater than required , if true then it is a possible solution
		return woodCollected >= m;
	}
	
	public static long maxSawBlade(ArrayList<Long> trees,long m) {
		long start = 0; 
		long end = trees.get(trees.size() -1 );
//		long end = Collections.max(trees);
		long ans = -1;
		long mid = start + (end - start) /2;
		

		while(start <= end ){
			// if mid value can be a solution then search for heigher height to reduce length of wood
			if(isPossible(trees,m,mid)) {
				ans =mid;
				start = mid+1;
			}else {
				end = mid -1;
			}
			
			
			mid = start + (end - start)/2;
		}
		
		
		return ans;
	}
	
	public static long ekoSpoj() {
		
		Scanner sc= new Scanner(System.in);  
		System.out.println("Enter number of trees");
		long n = sc.nextLong();
		System.out.println("Enter length of wood");
		long m = sc.nextLong();
		
		ArrayList<Long> trees = new ArrayList<>();
		
        // enter tree heights
		while(n-- >0) {
			long height = sc.nextLong();
			trees.add(height);
		}
		
        //sort trees
		Collections.sort(trees);
		
        // grab answer
		long ans = maxSawBlade(trees,m);
		
		
		return ans;
	}


// Integer


import java.util.*;

class Solution {

    public static boolean isPossible(ArrayList<Integer> trees,int n ,int totalWood, int minHeight){

		// amount of woods collected
        int collectedWoods = 0;

        for(int i = 0; i<n ;i++){
			// only include this tree if its height is higher than minHeight of maxSawBlade
            if(trees.get(i) > minHeight){
                collectedWoods += trees.get(i) - minHeight;
            }
            
        }

		// check if whether if collected required amount of woods or not
        return collectedWoods >= totalWood;
    }


    public static int maxSawBlade(ArrayList<Integer> trees,int wood){

        int n = trees.size();
        int start = 0;
        int end = trees.get(n-1);

        int ans = 0;
        while(start <= end){
            int mid = start + (end - start)/2;

			// check if we can raise the blade to at least mid height, if yes then store the height and try to maximize the height to minimize the cutting of trees.
            if(isPossible(trees,n,wood,mid)){
                start = mid+1;
                ans = mid;
            }else{ else minimize the height of sawblade to cut trees.
                end = mid-1;
            }

        }

        return ans;
    }

    public static void main(String[] args) {
      	
		ArrayList<Integer> trees = new ArrayList<>(Arrays.asList(20,15,10,17));
       
        int n = trees.size();
        int m = 7;
       
		
        //sort trees
		Collections.sort(trees);
		
        // grab answer
		int ans = maxSawBlade(trees,m);
		
		System.out.println("Answer is : " + ans);
		
    }
}

// EKO : https://www.spoj.com/problems/EKO/
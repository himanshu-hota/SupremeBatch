// Method 1

import java.util.*;
import java.io.*;

public class Solution {
    
    // Function to check if a given time 'sol' is a possible solution
    public static boolean isPossibleSolution(ArrayList<Integer> cookRanks, long p, long sol) {
        int totalPratas = 0;

        for (int i = 0; i < cookRanks.size(); i++) {
			// rank of current cook
            int r = cookRanks.get(i);
			// time that cook takes to cook 1 prata.
            int j = 1;
			// total time taken by current cook
            int timeTaken = 0;

            // Keep cooking until the timeTaken exceeds 'sol'
            while (true) {
				// check how many pratas can be cooked by current cook in giveen time.
                if (timeTaken + j * r <= sol) {
                    ++totalPratas;
                    timeTaken += j * r;
                    ++j;
                } else {
                    break;
                }
            }

            // If the required pratas are cooked, return true
            if (totalPratas >= p) {
                return true;
            }
        }

        // If the required pratas are not cooked, return false
        return false;
    }

    // Function to find the minimum cook time for 'm' chefs with given ranks
    public static int minCookTime(ArrayList<Integer> rank, int m) {
        int start = 0;
		// rank of most unefficient cook.
        int r = rank.get(rank.size() - 1);
		// total time taken by most unefficient cook to cook all pratas will be the max time to cook n pratas.
        int end = (r * (m * (m + 1)) / 2);
        int ans = -1;
        int mid = start + (end - start) / 2;

        // Binary search to find the minimum cook time
        while (start <= end) {
			// check if all pratas can be cooked in mid amount of time.
            if (isPossibleSolution(rank, m, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }

            mid = start + (end - start) / 2;
        }

        return ans;
    }
}



// method 2

import java.util.*;
import java.io.*;

public class Solution {
    
    // Function to check if a given time 'sol' is a possible solution
    public static boolean isPossibleSolution(ArrayList<Integer> cookRanks, long p, long sol) {
        int currPratas = 0;

        for (int i = 0; i < cookRanks.size(); i++) {
            int time = cookRanks.get(i); // Time taken by the current chef to cook one prata
            int j = 2;
            int timeTaken = 0;

            // Keep cooking pratas until the total time taken exceeds 'sol'
            while (time <= sol) {
                currPratas++;
                time = time + (cookRanks.get(i) * j); // Increment the time based on chef's rank
                j++;
            }

            // If the required pratas are cooked, return true
            if (currPratas >= p) {
                return true;
            }
        }

        // If the required pratas are not cooked, return false
        return false;
    }

    // Function to find the minimum cook time for 'm' chefs with given ranks
    public static int minCookTime(ArrayList<Integer> rank, int m) {
        int start = 0;
        int r = rank.get(rank.size() - 1); // Rank of the chef with the highest rank
        int end = Integer.MAX_VALUE; // Set an initial upper bound
        int ans = -1;
        int mid = start + (end - start) / 2;

        // Binary search to find the minimum cook time
        while (start <= end) {
            if (isPossibleSolution(rank, m, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }

            mid = start + (end - start) / 2;
        }

        return ans;
    }
}


// Optimal 

import java.util.*;
import java.io.*;

public class Solution {

    // Function to check if a given maxTime 'maxTime' is a possible solution
    public static boolean isPossible(ArrayList<Integer> cooks, int totalPratas, int maxTime) {
        int pratas = 0;

        for (int i = 0; i < cooks.size(); i++) {
			// time taken by current cook to cook 1 prata.
            int time = cooks.get(i);
			// j =2 is VVIMP because = 1 is already handled.
            int j = 2;

            // this while loop gives us how many pratas can current cook can cook in range of maxTime
            while (time <= maxTime) {
                pratas++;
                time += j * cooks.get(i); // Increment the time with each prata cooked by the chef
                j++;
            }

            // If the required pratas are cooked within the given time, return true
            if (pratas >= totalPratas) {
                return true;
            }
        }

        // If the required pratas are not cooked within the given time, return false
        return false;
    }

    // Function to find the minimum cook time for 'p' pratas with given ranks
    public static int minCookTime(ArrayList<Integer> rank, int p) {
        int n = rank.size();
        int r = rank.get(n - 1); // Rank of the chef with the highest rank
        int maxTime = r * (p * (p + 1)) / 2; // The upper bound of cook time

        int start = 0;
        int end = maxTime;
        int ans = 0;

        // Binary search to find the minimum cook time that satisfies the given conditions
        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Check if the current mid-time is a valid solution
			// if yes then try to cook in less time.
            if (isPossible(rank, p, mid)) {
                ans = mid; // Update the answer
                end = mid - 1; // 
            } else { // if not possible to cook in mid time then try adding some more time to cook.
                start = mid + 1; // 
            }
        }

        return ans; // Return the minimum cook time
    }
}


CodeStudio : https://www.codingninjas.com/studio/problems/cooking-ninjas_1164174?leftPanelTab=0




 	public static boolean isPossibleSolution(ArrayList<Long> cookRanks , long p , long sol) {
        
        //initial count of pratas
		long currPratas = 0;
		
		
		for(int i = 0 ; i<cookRanks.size(); i++) {
			long r = cookRanks.get(i); // rank of current cook
			long j = 1; // 1R + 2R + 3R + 4R ..... nR ----> here j is the number 1,2,3,4,.....n
			long timeTaken = 0; // initial time taken
			
			while(true) {
                // if timeTaken to make pratas is less than the solution then
				if(timeTaken + j*r <= sol) {
					++currPratas; // cook a new prata
					timeTaken += j*r; // add this time to to total time taken
					++j; // increase counter 
				}else {
					break;
				}
			}
			
            //check if we could able to make desired number of pratas
			if(currPratas >= p) {
				return true; //if true then it is a possible solution
			}
			
		}
		
        // else it is not a possible solution
		return false;
	}
	
	public static long minTimeToCookPratas(ArrayList<Long> cookRanks, long p) {
		long start = 0;
		long r= cookRanks.get(cookRanks.size() -1); // rank of most unefficient cook
		long end =  ( r * (p * (p+1))/2 ); // total time taken by the most unefficient cook will be maximum time to cook n pratas
		long ans = -1;
		long mid = start + (end - start)/2;
		
		while(start <= end) {
            // if it is a possible solution then search for lower time
			if(isPossibleSolution(cookRanks, p , mid)) {
				ans = mid;
				end = mid -1;
			}else {
				start = mid+1;
			}
			
			mid = start + (end - start) /2;
			
		}
		
		return ans;
		
		
	}
	
	public static long prataSpoj() {
		ArrayList<Long> cookRanks = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number of pratas");
		long p = sc.nextLong();
		System.out.println("Enter number of cooks");
		long c = sc.nextLong();
		
		System.out.println("Enter ranks of cooks");
		while(c-- >0) {
			long rank = sc.nextLong();
			cookRanks.add(rank);
		}
		
        //sort list
		Collections.sort(cookRanks);
		
		long ans = minTimeToCookPratas(cookRanks,p);
		
		return ans;
		
	}
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // Sort the candidates array in ascending order
        List<Integer> currentCombination = new ArrayList<>(); // Track the current combination
        List<List<Integer>> uniqueCombinations = new ArrayList<>(); // Store unique combinations
        backtrack(candidates, target, currentCombination, uniqueCombinations, 0); // Call the backtracking method
        return uniqueCombinations; // Return the unique combinations
    }

    private void backtrack(int[] candidates, int remainingTarget, List<Integer> currentCombination,
                           List<List<Integer>> uniqueCombinations, int startIndex) {

        if (remainingTarget == 0) {
            // If the remaining target is zero, the current combination is a valid solution
            uniqueCombinations.add(new ArrayList<>(currentCombination)); // Add the current combination to the result
            return; // Exit the method
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                // Skip duplicates to avoid duplicate combinations
                continue; // Skip to the next iteration of the loop
            }

            if (candidates[i] > remainingTarget) {
                // Optimization: Stop further exploration as the remaining candidates are larger than the target
                break; // Exit the loop
            }

            currentCombination.add(candidates[i]); // Add the current candidate to the combination
            backtrack(candidates, remainingTarget - candidates[i], currentCombination, uniqueCombinations, i + 1);
            // Recursively explore the remaining candidates with the updated target and combination
            currentCombination.remove(currentCombination.size() - 1); // Remove the last element from the combination
        }
    }
}

Notes : 1. This question is completely different from 'Combination sum 1'.
        2. Instead of applying include/exclude we are filling the index with any particular element with some rules : 
                a. Dont add the same digit again at any particular index if it has already been taken on any of previous combinations.
                b. If the element is greater than the given target then there is no sense to add this element. and elements after this element would also be considered not suitable because array is sorted.
                how ? --> if the given sum is 3 and current element is 4 then we can't include this element, also the elements after this element (5.6.7....) would also be considered not suitable.
        3. Always keep in mind this is not the case of include/exclude, we are filling the index with remaining elements and we never add any element again if we already have any combination with the this element on this index before.
        ex. arr[] = {1,1,2,2,2,8} target = 5 in this array if we try to fill 0th index then we have following choices

        1 -> can be added
        1 -> can't be added becausewe previous had added this element (look above).
        2 -> can be added
        2 -> can't be added becausewe previous had added this element (look above).
        2 -> can't be added becausewe previous had added this element (look above).
        8 -> this element itself is greater than sum(5) so cant add it.


One line : Agar x element kisi index pe rakhna chahte ho to ye ensure karo ki x pahle kabhi is index pe nahi rakha gaya ho , agar pahle kisi combination me rakha ja chuka hai to isko mat rakho is index pe, kyoki ye usi combination ka duplicate de sakta hai.

        What About this 'if block' ?
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                // Skip duplicates to avoid duplicate combinations
                continue; // Skip to the next iteration of the loop
            }

        i > startIndex ---> This condition ensures that we can add same element on next index 
        ex. {1,1,2,2,2,8} target = 5 , in this question [1,2,2] is a valid combination, but how we added 2 and again 2 at the next index ? , because there are two 2's in the array, both are different.
        
        But the question says that avoid duplicates, what about that? , ---> the question says don't use any digit(keep in mind digit) again on the same index if you have taken this element on any combination before on this same index.

        ex. {1,1,2a,2b,2c,8} target = 5

        we might think all of these --> [1,2c,2a]  [1,2a,2b]  [1,2b,2c] are valid combination right ?
        but keep in mind "don't use any digit(keep in mind digit) again on the same index if you have taken this element on any combination before on this same index."

        whats why we have taken only one of these 3 combinations.

        


LeetCode :- https://leetcode.com/problems/combination-sum-ii/description/

CodeStudio : https://www.codingninjas.com/studio/problems/combination-sum-ii_1112622?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=SUBMISSION

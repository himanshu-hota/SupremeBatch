public int[] nodesBetweenCriticalPoints(ListNode head) {
    int ans[] = {-1,-1}; // Initialize the answer array with default values
    ListNode prev = head; // Set the previous node as the head
    if(prev == null) return ans; // If the head is null, return the default answer array
    ListNode curr =head.next; // Set the current node as the next node of the head
    if(curr == null) return ans; // If the current node is null, return the default answer array
    ListNode next = head.next.next; // Set the next node as the next node of the current node
    if(next == null) return ans; // If the next node is null, return the default answer array

    int minDist = Integer.MAX_VALUE; // Initialize the minimum distance with the maximum possible value
    int firstCP = -1; // Initialize the index of the first critical point as -1
    int lastCP = -1; // Initialize the index of the last critical point as -1
    int i = 1; // Initialize the index counter as 1

    while(next != null){
        boolean isCP = ((curr.val < prev.val && curr.val < next.val) || (curr.val > prev.val && curr.val > next.val)) ? true : false;
        // Check if the current node is a critical point (minimum or maximum)

        if(isCP == true && firstCP == -1){
            firstCP = i; // If it is the first critical point, set its index as the first critical point index
            lastCP = i; // Also set its index as the last critical point index
        }else if(isCP == true){
            minDist = Math.min(minDist, i - lastCP); // Calculate the minimum distance between critical points
            lastCP = i; // Update the index of the last critical point
        }
            
        i++; // Increment the index counter
        prev = prev.next; // Move the previous node one step forward
        curr = curr.next; // Move the current node one step forward
        next = next.next; // Move the next node one step forward
    }

    if(lastCP == firstCP){
        return ans; // If there is only one critical point, return the default answer array
    }else{
        ans[0] = minDist; // Set the minimum distance between critical points in the answer array
        ans[1] = lastCP - firstCP; // Set the number of nodes between the first and last critical points in the answer array
    }

   return ans; // Return the answer array
}

Steps : 1. Check if we can get ciritical points or not ( if we have more than 3 nodes then only we can get critical points).
        2. Traverse the LinkedList until the next pointer becomes null (why next ? -- > because next will be the last node if that exists then only ciritical points can be genereated).
        3 If we got any critical point then check if it is the first critical point then update both firstCP and lastCP and keep moving forward without any Calculations.
        4. Now if we got any critical point then we need to Calculate the minDistance and update only the lastCP pointer.
        5. After the loop check if we have only 1 critical point , if yes then no ans is possible.
        6. If we have more than 1 critical points than Calculate the max distance by subtracting the lastCP and firstCP and return ans.

LeetCode :- https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/description/


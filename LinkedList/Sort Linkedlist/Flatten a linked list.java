class GfG {

    // Function to merge two sorted linked lists
    static Node merge(Node list1, Node list2) {
        // If list1 is empty, return list2
        if (list1 == null) return list2;
        // If list2 is empty, return list1
        if (list2 == null) return list1;

        // Pointers for traversing list1 and list2
        Node a = list1;
        Node b = list2;

        // Dummy node for the merged list
        Node ans = new Node(-1);
        // Pointer to the head of the merged list
        Node newHead = ans;

        // Merge the lists
        while (a != null && b != null) {
            if (a.data <= b.data) {
                // Link the current node from list1 to the merged list
                ans.bottom = a;
                // Move to the next node in list1
                a = a.bottom;
            } else {
                // Link the current node from list2 to the merged list
                ans.bottom = b;
                // Move to the next node in list2
                b = b.bottom;
            }

            // Move to the next node in the merged list
            ans = ans.bottom;
        }

        // If there are remaining nodes in list1, add them to the merged list
        while (a != null) {
            ans.bottom = a;
            a = a.bottom;
            ans = ans.bottom;
        }

        // If there are remaining nodes in list2, add them to the merged list
        while (b != null) {
            ans.bottom = b;
            b = b.bottom;
            ans = ans.bottom;
        }

        // Return the head of the merged list (skipping the dummy node)
        return newHead.bottom;
    }

    // Function to flatten a multilevel linked list
    Node flatten(Node root) {
        // If the root is null, return null
        if (root == null) return null;

        // Initialize the answer as null
        Node ans = null;
        // Pointer for traversing the levels of the multilevel linked list
        Node tail = root;

        // Iterate through each level and merge it with the previous levels
        while (tail != null) {
            ans = merge(ans, tail);
            // Move to the next level
            tail = tail.next;
        }

        // Return the flattened linked list
        return ans;
    }
}


 ----------------------------------------------------- Recursive -----------------------------------------------------


class GfG
{
    // Function to merge two sorted linked lists
    static Node merge(Node a, Node b){
        if(a == null) return b; // If first linked list is empty, return the second linked list
        if(b == null) return a; // If second linked list is empty, return the first linked list
        
        Node ans = null;
        
        // Compare the data of the nodes in both linked lists
        if(a.data <= b.data){
            ans = a; // Assign the smaller node to 'ans'
            a.bottom = merge(a.bottom, b); // Recursively merge the remaining nodes of the first linked list with the second linked list
        }else{
            ans = b; // Assign the smaller node to 'ans'
            b.bottom = merge(a, b.bottom); // Recursively merge the first linked list with the remaining nodes of the second linked list
        }
        
        return ans; // Return the merged linked list
    }
    
    // Function to flatten a multilevel linked list
    Node flatten(Node root)
    {
        if(root == null) return root; // If the root is null, return null
        
        // Recursively flatten the next linked list
        Node mergedLL = merge(root, flatten(root.next));
        
        return mergedLL; // Return the flattened linked list
    }
}

GFG :- https://practice.geeksforgeeks.org/problems/da62a798bca208c7a678c133569c3dc7f5b73500/1
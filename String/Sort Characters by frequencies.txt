// Method 1 Using ArrayList

// Custom class Pair to store character and its frequency
class Pair {
    int freq;
    char ch;

    Pair(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}

class Solution {
    // Method to sort characters in a string based on their frequencies
    public String frequencySort(String s) {
        // StringBuilder with an initial capacity equal to the length of the input string
        StringBuilder ans = new StringBuilder(s.length());

        // List to store Pairs containing characters and their frequencies
        List<Pair> pq = new ArrayList<>();

        // HashMap to store character frequencies
        HashMap<Character, Integer> map = new HashMap<>();

        // Count the frequencies of characters in the input string
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        // Populate the list with Pairs containing characters and their frequencies
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            char ch = e.getKey();
            int freq = e.getValue();

            pq.add(new Pair(ch, freq));
        }

        // Sort the list of Pairs based on frequency in ascending order
        Collections.sort(pq, (a, b) -> Integer.compare(a.freq, b.freq));

        // Iterate through the sorted list and append characters to the result string
        int n = pq.size() - 1;
        while (n >= 0) {
            Pair p = pq.get(n);

            int i = 0;
            while (i < p.freq) {
                ans.append(p.ch);
                i++;
            }

            n--;
        }

        // Convert the StringBuilder to a String and return the result
        return ans.toString();
    }
}


// Method 2 Using PriorityQueue

// Custom class Pair to store character and its frequency
class Pair {
    int freq;
    char ch;

    Pair(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}

class Solution {
    // Method to sort characters in a string based on their frequencies
    public String frequencySort(String s) {
        // StringBuilder to store the result
        // StringBuilder ans = new StringBuilder(); 
        // this is also correct but below code avoids the resizing of the string frequent times.
        StringBuilder ans = new StringBuilder(s.length());

        // Priority queue to store Pairs based on frequency in descending order
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.freq, a.freq));

        // HashMap to store character frequencies
        HashMap<Character, Integer> map = new HashMap<>();

        // Count the frequencies of characters in the input string
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        // Populate the priority queue with Pairs containing characters and their frequencies
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            char ch = e.getKey();
            int freq = e.getValue();

            pq.add(new Pair(ch, freq));
        }

        // Build the result string by appending characters based on their frequencies
        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            int i = 0;
            while (i < p.freq) {
                ans.append(p.ch);
                i++;
            }
        }

        // Convert the StringBuilder to a String and return the result
        return ans.toString();
    }
}


Steps : 1. Count the frequency of each character in the given string, and make pair of (character,frequency).
        2. Add them into PriorityQueue(max heap).
        3. Now poll pairs one by one from PriorityQueue and add each character freq. times into to final answer string.


LeetCode : https://leetcode.com/problems/sort-characters-by-frequency/description/

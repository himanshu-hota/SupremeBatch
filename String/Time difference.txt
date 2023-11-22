// User function Template for Java

class Solution {
    // Function to calculate the time gap between two time strings.
    static String timeGap(String st, String et) {
        // Extracting hours, minutes, and seconds from the start time (st).
        int stHour = Integer.parseInt(st.substring(0, 2));
        int stMin = Integer.parseInt(st.substring(3, 5));
        int stSec = Integer.parseInt(st.substring(6, 8));

        // Extracting hours, minutes, and seconds from the end time (et).
        int etHour = Integer.parseInt(et.substring(0, 2));
        int etMin = Integer.parseInt(et.substring(3, 5));
        int etSec = Integer.parseInt(et.substring(6, 8));

        // Calculating the difference in hours, minutes, and seconds.
        int h = etHour - stHour;
        int m = etMin - stMin;
        int s = etSec - stSec;

        // Adjusting seconds if negative and updating minutes.
        if (s < 0) {
            m--;
            s += 60;
        }

        // Adjusting minutes if negative and updating hours.
        if (m < 0) {
            h--;
            m += 60;
        }

        // Formatting hours, minutes, and seconds with leading zeros if needed.
        String hr = h <= 9 ? "0" + h : Integer.toString(h);
        String min = m <= 9 ? "0" + m : Integer.toString(m);
        String sec = s <= 9 ? "0" + s : Integer.toString(s);

        // Returning the formatted time gap as a string.
        return hr + ":" + min + ":" + sec;
    }
}


Steps : 1. Get the values of given strings in integers.
        2. Subtract the values and get the time.
        3. If second is negative then subtract 1 from minutes and add 60 to seconds.
        4. If minute is negative then subtract 1 form hour and add 60 to minutes.
        5. Get Actual hour, min and time.

GFG : https://www.geeksforgeeks.org/problems/time-difference5528/1

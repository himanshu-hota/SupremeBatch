    static int digitSum(int num){
        if(num == 0){
            return 0;
        }

        return num%10 + digitSum(num/10);
    }

    //link to the practice link of gfg

    GFG : https://www.geeksforgeeks.org/problems/sum-of-digits1742/1
	public static void ExtremePrint(int arr[]) {
		
		int start = 0 ; 
		int end = arr.length -1 ; 
		
		while(start<=end) {
			
			if(start == end) {
				System.out.print(arr[start] + " " );	
			}else {
				System.out.print(arr[start] + " " + arr[end] + " ");	
			}
						
			start++;
			end--;
			
		}
	}


GITHUB LINK :- https://github.com/himanshu-hota/SupremeBatch/blob/main/Array/Array/Extreme%20in%20Array.txt

What to do in this question ?

ex. 1. arr => [1,2,3,4,5,6,7];

print the array in following way

1,7,2,6,3,5,4


ex. 2. arr => [103,83,91,98,19,1981,615];

print the aray in following way

103, 615, 83, 1981, 91, 19, 98


Hint : At a time , one element from the start and one element from the end.

Online Java Compiler :- 1. https://labs.thecodehelp.in/quick-compiler
						2. https://www.codingninjas.com/studio/online-compiler/online-java-compiler

package laba4;
import java.util.Arrays;

public class Array {
	public static void main(String[] args) {
		 int []x = {13,12,11,9,8,9,1};
		
		boolean isSorted = false;
		int y;
		while(!isSorted) {
			isSorted = true;
			for (int i = 0; i< x.length-1; i++) {
				if(x[i]>x[i+1]) {
				isSorted = false;
				
				y = x[i];
				x[i] = x[i+1];
				x[i+1]=y;
			}
			}
		}
	System.out.println(Arrays.toString(x));		
	
	}
}

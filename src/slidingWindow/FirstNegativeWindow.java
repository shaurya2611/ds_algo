package slidingWindow;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeWindow {

	/* In each window of size 'k' find the first negative appearing number */
	
	public static void negativeNo(int arr[], int n, int k) {
		
		Queue<Integer> negativeIdx = new LinkedList<>();
		int winStart = 0;
		int winEnd = 0;
		
		while(winEnd < n) {
			
			if(arr[winEnd] < 0)
				negativeIdx.add(winEnd);
			
			if(negativeIdx.size()>0)
				if(winStart > negativeIdx.element())
					negativeIdx.remove();
			
			if(winEnd-winStart+1 < k) {
				winEnd++;
			}else {
				if(negativeIdx.size()>0 && negativeIdx.element() <= winEnd)
						System.out.println(arr[negativeIdx.element()]);
				else
					System.out.println(0);
				winEnd++;
				winStart++;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {12,-1,-7,8,-15,30,13,20};
		int k =3;
		int n = arr.length;
		negativeNo(arr, n, k);

	}

}

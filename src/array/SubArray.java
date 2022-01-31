package array;

public class SubArray {

	public static void main(String[] args) {
		int[] a = {10,20,30,40};
		
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a.length; j++) {
				int flag = i;
				while(flag<=j) {
					System.out.print(a[flag]+"\t");
					flag++;
				}
				System.out.println();
			}
		}

	}

}

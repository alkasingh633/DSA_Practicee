package Sorting;

public class BubbleSort {
	public static void print(int[] arr) {
		for(int ele : arr) {
			System.out.print(ele+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("hello");
		int[] arr = {5, -2,6,7,2,8,7,2};
		int n = arr.length;
		print(arr);
		for(int i=0; i<n-1;i++) {
			if(arr[i]>arr[i+1]) {
				int temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
			}
		}
		
		print(arr);
	}

}

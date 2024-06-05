import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	public static void mergeSort(int[] nums, int l, int r) {
		
		if(l<r) {
			
			var mid = (l + r) / 2;
			mergeSort(nums, 0, mid);
			mergeSort(nums, mid+1, r);
			//
			merge(nums, l, mid, r);
		}
		
	}
	
	
	// 6, 1, 21, 2 | 9, 12, 4, 15
	// 1, 2, 6, -21 | 4, 9, 12 -
	// 6, 1 | 21, 2 | 9, 12 | 4, 15
	
	private static void merge(int[] nums, int l, int mid, int r) {
		
		var n1 = mid - l+1;
		var n2 = r - mid;
		
		int[] lArr = new int[n1];
		int[] rArr = new int[n2];
		
		for(int x = 0; x < n1; x++) {
			lArr[x] = nums[l+x];
		}
		for(int y = 0; y < n2; y++) {
			rArr[y] = nums[mid+1+y];
		}
		
		int i = 0;
		int j = 0;
		int k = l;
		
		while(i < n1 && j < n2) {
			if(lArr[i] <= rArr[j]) {
				nums[k] = lArr[i];
				i++;
			}else {
				nums[k] = rArr[j];
				j++;
			}
			k++;
		}
		
		while(i < n1) {
			nums[k] = lArr[i];
			i++;
			k++;
		}
		
		while(j < n2) {
			nums[k] = rArr[j];
			j++;
			k++;
		}
		
	}

	public static int[] combinator(int[] arr1, int[] arr2) {
		int[] arr3 = new int[arr1.length + arr2.length];
		var i = 0;
		var k = 0;
		while(i + k < arr3.length - 1) {
			arr3[i+k] = Math.min(arr1[i], arr2[k]);
			if(arr1[i] < arr2[k]) i++;
			else k++;
		}
		return arr3;
	}
	
	public static void quickSort(int[] nums, int low, int high) {
		
		if(low >= high) return;
			
		var p = separator(nums, low, high);
		// Less Than
		quickSort(nums, low, p-1);
		
		// Greater Than
		quickSort(nums, p+1, high);
	}
	
	private static int separator(int[] nums, int start, int end) {
		var pivot = nums[end];
		var temp = 0;
		var i = start-1;
		while(start<end) { // O(n)
			if(nums[start] < pivot) {
				i++;
				temp = nums[i];
				nums[i] = nums[start];
				nums[start] = temp;
			}
			start++;
		}
		temp = nums[i+1];
		nums[i+1] = pivot;
		nums[start] = temp;
		return i+1;
	}

	public static void insertionSort(int[] nums) {
		for(int i = 1; i < nums.length; i++) { // O(n)
			var key = nums[i];
			var j = i-1;
			while(j >= 0 && nums[j] > key) { // O(n)
				nums[j+1] = nums[j];
				j--;
			}
			nums[j+1] = key;
		}
		System.out.println("Insertion Sort : " + Arrays.toString(nums));
	}
	
	public static void selectiveSort(int[] nums) {
		var tamanho = nums.length;
		for(int a = 0; a < tamanho; a++) { 
			var menor = nums[a];
			var i_menor = a;
			if(!(a > 0 && (nums[a - 1] + 1 == nums[a] || nums[a - 1] == nums[a]))) {
				for(int b = a+1; b < tamanho; b++) {
					if(menor > nums[b]) {
						menor = nums[b];
						i_menor = b;
					}
				}
				nums[i_menor] = nums[a];
				nums[a] = menor;
			}
		}
		System.out.println("Selective Sort : " + Arrays.toString(nums));
	}
	
	public static void bubbleSort(int[] nums) {
		for(int c = 0; c < nums.length; c++) {
			for(int k = 0; k + 1 < nums.length; k++) {
				if(nums[k] > nums[k+1]) {
					var old = nums[k];
					nums[k] = nums[k+1];
					nums[k+1] = old;
				}
			}
		}
		
		System.out.println("Bubble Sort    : " + Arrays.toString(nums));
    }
	
	public static void main(String[] args) {
		 
		int[] arr = {6, 1, 21, 2, 9, 12, 4, 15};
		mergeSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
}

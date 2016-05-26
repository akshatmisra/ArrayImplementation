import java.util.*;

public class ArrayImp {
	int [] arr;
	
	ArrayImp(int n)
	{
		arr = new int [n];
	}
	
	private void insertElement(int num, int idx)
	{
		arr[idx] = num;
	}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayImp a = new ArrayImp(n);
		
		for(int i = 0; i<n; i++)
			a.insertElement(sc.nextInt(),i);
		
		//a.mergeSort(a.arr,0,n-1);
		a.merge(a.arr, 0, (n-1)/2, n-1);
		
		for(int i : a.arr)
			System.out.println(i);
		
		sc.close();
	}

	private void mergeSort(int []arr, int l, int r)
	{
		if(r>l)
		{
			int m = (l+r)/2;
			
			mergeSort(arr,l,m);
			
			mergeSort(arr,m+1,r);
			
			merge(this.arr, l, m, r);
		}
	}
	private void merge(int []arr,int l,int m,int r)
	{
		int i = 0; // represent the smallest unpicked in left
		int j = 0; // represent the smallest unpicked in right
		int k = l; // represents the array where to insert in original array 
		
		int nleft = m-l+1; // number of elements in Left array
		int nright = r-m; // Number of elements in right array
		
		int [] left = new int [nleft]; // Store the left array
		int [] right = new int [nright]; // Stores the right array
		
		//copy the data to a temp array to perform sort
		for(i = 0; i< nleft; i++)
			left[i] = arr[l+i];
		
		for(j = 0; j< nright; j++)
			right[j] = arr[m+ 1 +j];
		
		i = j = 0;
		
		while(i<nleft && j<nright)
		{
			if(left[i]<right[j])
				arr[k] = left[i++];
			else
				arr[k] = right[j++];
			k++;
		}
		
		//For remaining elements
		while(i<nleft)
			arr[k++]=left[i++];
		while(j<nright)
			arr[k++]=right[j++];
	}
}

class MergeSort{
	void merge(int A[], int p, int q, int r){
		//length of left array
		int n1 = q-p+1;
		//length of right array
		int n2 = r-q;
		//The two arrays with their respective sizes
		int L[] = new int [n1];
		int R[] = new int [n2];
		//Copy subarray into the left array
		for(int i = 0; i<n1; i++){
			L[i] = A[p+i];
		}
		//Copy subarray into the right array
		for(int j = 0; j<n2; j++){
			R[j] = A[q+1 +j];
		}
	
		int i = 0, j = 0, k=p;
		while(i<n1 && j<n2){
			if(L[i]<=R[j]){
				A[k] = L[i];
				i++;
			}
			else{
				A[k] = R[j];
				j++;
			}
			k++;
		}
		
		/*
		for(k = p; k<r; k++){
			//Compare the first element in the Left array to the first element in the right array
			if(L[i]<=R[j]){
				//Add to the sorted array
				A[k] = L[i];
				i=i++;
			}
			else{
				A[k] = R[j];
				j=j++;
			}
		}
		*/
		
		//If any remaining elements are in the L or R arrays, have to add them into the array
		while(i<n1){
			A[k] = L[i];
			i++;
			k++;
		}
		while(j<n2){
			A[k] = R[j];
			j++;
			k++;
		}
	}
	
	void sort(int A[], int p, int r){
		if(p < r){
			//middle pint
			int q = (p+r)/2;
			//Sort the first and second halves
			sort(A, p, q);
			sort(A, q+1, r);
			//merge them
			merge(A, p, q, r);
		}
	}
	
	static void print(int array[]){
		int n = array.length;
		for(int i = 0; i<n; ++i)
		{
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	
	public static void main(String args[]){
		//Random array
		int array[] = {5, 2, 4, 6, 1, 3, 54, 25, 5, 2};
		//Create object
		MergeSort object = new MergeSort();
		//Call Insertion sort method
		object.sort(array,0,array.length-1);
		print(array);
	}

}
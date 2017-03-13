import java.util.Arrays;

public class ST2_ASSIGNMENT_Q1 {

	public static int array_dimensions = 10;
	public static boolean printOutput = true;
	public static int[] array_ascend  = new int[array_dimensions];
	public static int[] array_descend = new int[array_dimensions];
	public static int[] array_random  = new int[array_dimensions];
	public static int[] array_holder  = new int[array_dimensions]; //Algorithms ONLY sort this array, this is to avoid modifying the other 3 arrays
	
	public static void initializeArray(){
		System.out.println(">Array Dimensions: " + array_dimensions);
		System.out.println(">Print array output: " + printOutput + "\n");
		
		//initialize array_ascend
			for (int i = 1; i != array_dimensions+1; i++){
				array_ascend[i-1] = i;
			}
			System.out.println(">array_ascend initialized");
		//initialize array_descend
			int temp = array_dimensions;
			for (int i = 1; i != array_dimensions+1; i++){
				array_descend[i-1] = temp;
				temp--;
			}
			System.out.println(">array_descend initialized");
		//initialize array_random
			for(int i = 0; i < array_random.length; i++){
				array_random[i] = array_ascend[i];
			}
			shuffleArray(array_random);
			System.out.println(">array_random initialized \n");
	}
	
	//SORTING METHODS
	public static void selectionSort(int[] array){
		System.out.println("selectionSort BEGIN");
		int MinimumIndex;
		int pass, j, n = array.length;
		int temp;
		for (pass = 0; pass < n - 1; pass++) {
		    MinimumIndex = pass;
		    for (j = pass + 1; j < n; j++) {
		        if (array[j] < array[MinimumIndex])
		        MinimumIndex = j;
		    }
		    if (MinimumIndex != pass) {
		        temp = array[pass];
		        array[pass] = array[MinimumIndex];
		        array[MinimumIndex] = temp;
		    }
		}
		if (printOutput == true){
			System.out.println("Output: " + (Arrays.toString(array)) + "\n");
		}
	}
	public static void insertionSort(int[] array){
		System.out.println("insertionSort BEGIN");
		int i, j, n = array.length;
		int target;
		for (i = 1; i < n; i++) {
		    j = i;
		    target = array[i];
		    while (j > 0 && target < array[j - 1]) {
		        array[j] = array[j - 1];
		        j--;
		    }
		    array[j] = target;
		}
		if (printOutput == true){
			System.out.println("Output: " + (Arrays.toString(array)) + "\n");
		}
	}
	public static void bubbleSort(int[] array){
		System.out.println("bubbleSort BEGIN");
		int j;
		boolean flag = true;   
		int temp;   
		while (flag) {
		    flag = false;    
		    for(j = 0;  j < array.length - 1;  j++) {
		        if (array[j] > array[j + 1]) {
		            temp = array[j];                
		            array[j] = array[j + 1];
		            array[j + 1] = temp;
		            flag = true; 
		        } 
		    } 
		} 
		if (printOutput == true){
			System.out.println("Output: " + (Arrays.toString(array)) + "\n");
		}
	}
	private static void quickSort (int[] array, int fromIndex, int toIndex) {
	    int i = fromIndex;
	    int j = toIndex;
	    int pivot = array[fromIndex + (toIndex - fromIndex) / 2];
	    while (i <= j) {
	        while (array[i] < pivot) { i++; }
	        while (array[j] > pivot) { j--; }
	        if (i <= j) {
	            int temp = array[i];
	            array[i] = array[j];
	            array[j] = temp;
	            i++;
	            j--;
	        }
	    }
	    if (fromIndex < j)
	    quickSort(array, fromIndex, j);
	    if (i < toIndex)
	    quickSort(array, i, toIndex);
	}
	public static void mergeSort(int[] array, int fromIndex, int toIndex){
		if (fromIndex < toIndex) {
            int middleIndex = fromIndex + (toIndex - fromIndex) / 2;
            // Sort the left side of the array
            mergeSort(array, fromIndex, middleIndex);
            // Sort the right side of the array
            mergeSort(array, middleIndex + 1, toIndex);
            // Merge both sides
            mergeSides(array, fromIndex, middleIndex, toIndex);
        }
	}
	private static void mergeSides (int[] array, int fromIndex, int middleIndex, int toIndex) {
        int[] tmp = new int[array.length];
        for (int i = fromIndex; i <= toIndex; i++) {
            tmp[i] = array[i];
        }
        int i = fromIndex;
        int j = middleIndex + 1;
        int k = fromIndex;
        while (i <= middleIndex && j <= toIndex) {
            if (tmp[i] <= tmp[j]) {
                array[k] = tmp[i];
                i++;
            } else {
                array[k] = tmp[j];
                j++;
            }
            k++;
        }
        while (i <= middleIndex) {
            array[k] = tmp[i];
            k++;
            i++;
        }
    }
	public static void countingSort(int[] array){
		System.out.println("countingSort BEGIN");
		int[] countingArray = new int[array.length];
		int[] sortedArray = new int[array.length];
		for(int arrayIndex = 0; arrayIndex < (array.length); arrayIndex++){
			countingArray[array[arrayIndex]-1]++; //increments counting array index for what the incoming array value is
		}
		for(int pass = 0; pass < (array.length); pass++){
			if (countingArray[pass] != 0){
				sortedArray[pass] = pass+1;
			}
		}
		copyArray(sortedArray, array);
		if (printOutput == true){
			System.out.println("Output: " + (Arrays.toString(array)) + "\n");
		}
	}
	public static void extraSort(int[] array){  //"and another sorting algorithm that you can find on a website or textbook about data structures and algorithms."
		System.out.println("extraSort BEGIN");
		
		if (printOutput == true){
			System.out.println("Output: " + (Arrays.toString(array)) + "\n");
		}
	}
	
	//UTILITIES
	public static boolean searchArray(int[] array, int key){ //Search in array for key
		for (int i = 0; i < array.length; i++){
			if (array[i] == key){
				return true;
			}
		}
		return false;
	}
	public static void shuffleArray(int[] array) { //Shuffle array
        int n = array.length;
        for (int i = 0; i < array.length; i++) {
            // Get a random index of the array past i.
            int random = i + (int) (Math.random() * (n - i));
            // Swap the random element with the present element.
            int randomElement = array[random];
            array[random] = array[i];
            array[i] = randomElement;
        }
    }
	public static void copyArray(int[] masterArray, int[] newArray){
		for (int i = 0; i < masterArray.length && i < newArray.length; i++){
			newArray[i] = masterArray[i];
		}
	}
	public static void quickSortAssist(int[] array, int fromIndex, int toIndex){ //debugging logs were causing issues, so I had to make a assistant method
		System.out.println("quickSort BEGIN");
		quickSort(array, fromIndex, toIndex);
		if (printOutput == true){
			System.out.println("Output: " + (Arrays.toString(array_holder)) + "\n");
		}
	}
	public static void mergeSortAssist(int[] array, int fromIndex, int toIndex){
		System.out.println("mergeSort BEGIN");
		mergeSort(array, fromIndex, toIndex);
		if (printOutput == true){
			System.out.println("Output: " + (Arrays.toString(array)) + "\n");
		}
	}
	
	//SORTING CONTROL
	public static void sortRandomArray(){
		System.out.println(">Sorting array_random\n");
		
		copyArray(array_random, array_holder);
		selectionSort(array_holder);
		
		copyArray(array_random, array_holder);
		insertionSort(array_holder);
		
		copyArray(array_random, array_holder);
		bubbleSort(array_holder);
		
		copyArray(array_random, array_holder);
		quickSortAssist(array_holder, 0, (array_dimensions-1));
		
		copyArray(array_random, array_holder);
		quickSortAssist(array_holder, 0, (array_dimensions-1));
		
		copyArray(array_random, array_holder);
		countingSort(array_holder);
		
		copyArray(array_random, array_holder);
		extraSort(array_holder);
	}
	
	public static void main(String[] args){
		System.out.println("***PROGRAM START*** \n");
		initializeArray();
		
		sortRandomArray();
	}
}

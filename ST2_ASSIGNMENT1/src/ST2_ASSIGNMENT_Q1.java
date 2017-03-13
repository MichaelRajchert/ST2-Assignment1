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
	public static void quickSort(int[] array){
		System.out.println("quickSort BEGIN");
		
		if (printOutput == true){
			System.out.println("Output: " + (Arrays.toString(array)) + "\n");
		}
	}
	public static void mergeSort(int[] array){
		System.out.println("mergeSort BEGIN");
		
		if (printOutput == true){
			System.out.println("Output: " + (Arrays.toString(array)) + "\n");
		}
	}
	public static void countingSort(int[] array){
		System.out.println("countingSort BEGIN");
		
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
		quickSort(array_holder);
		
		copyArray(array_random, array_holder);
		mergeSort(array_holder);
		
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

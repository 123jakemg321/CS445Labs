public class SortLab
{
	public static void main(String args[])
	{
		Integer[][] unsorted = {{7, 1, 4, 11, 10, 3, 6, 8, 9, 5, 2},
			{7, 1, 4, 10, 3, 6, 8, 9, 5, 2}, 
		{20, 3, 26, 17,  6, 23, 50, 35, 14, 22, 16,  4,  7, 46, 27, 19, 38, 21, 11, 25, 40, 24, 42, 33,  8, 18, 37, 43,  5, 36, 31, 13,  9, 39, 49, 30, 10,  2,  1, 12, 47, 15, 44, 48, 45, 34, 32, 41, 28, 29}};
		System.out.println("Unsorted arrays: ");
		for(int i = 0; i < unsorted.length; i++)
			printArray(unsorted[i]);
		System.out.println("Sorted arrays: ");
		for(int i = 0; i < unsorted.length; i++)
			printArray(cocktailShakerSort(unsorted[i]));
	}
	
	//Prints the passed array one element at a time separated by a comma
	public static <T> void printArray(T[] array)
	{
		for(int i = 0; i < array.length-1; i++)
		{
			System.out.print(array[i] + ", ");
		}
		System.out.println(array[array.length-1]);
	}
	
	//The cocktail shaker sort algorithm, which applies the idea of bubble sort in both directions.
	//Note i ranges from 0 to array length divided by 2, since two elements are sorted per iteration
	public static <T extends Comparable<T>> T[] cocktailShakerSort(T[] array)
	{
		T[] sorted = array;
		for(int i = 0; i < sorted.length/2; i++)
		{
			sortForward(sorted, i);
			sortBackward(sorted, i);
		}
		return sorted;
	}
	/**
		Helper method that does one iteration of bubble sort by traversing the array left to right.
		In other words, sortForward compares every pair of neighbor values in the unsorted section
		of the array and swaps them if they are not in ascending order.

		@param array  The array of values to be sorted
		@param i  The number of values already sorted on each side of the array, i.e. the
		iteration of the sort
		
		@return void  The passed array will be the exact same array from the calling method, i.e. changing
			"array" will change "sorted" from the cocktailShakerSort method
	**/
	public static <T extends Comparable<T>> void sortForward(T[] array, int i)
	{
		
	}
	
	/**
		Helper method that does one iteration of bubble sort by traversing the array right to left.
		In other words, sortBackward compares every pair of neighbor values in the unsorted section
		of the array and swaps them if they are not in descending order.
		
		@param array  The array of values to be sorted
		@param i  The number of values already sorted on each side of the array, i.e. the
		iteration of the sort
		
		@return void  The passed array will be the exact same array from the calling method, i.e. changing
			"array" will change "sorted" from the cocktailShakerSort method
	**/
	public static <T extends Comparable<T>> void sortBackward(T[] array, int i)
	{

	}
}
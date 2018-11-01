public class CocktailShakerSort
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
	
	public static <T> void printArray(T[] array)
	{
		for(int i = 0; i < array.length-1; i++)
		{
			System.out.print(array[i] + ", ");
		}
		System.out.println(array[array.length-1]);
	}
	
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
	
	private static <T extends Comparable<T>> void sortForward(T[] array, int i)
	{
		int start = i;
		for(; i < array.length - start - 1; i++)
		{
			if(array[i].compareTo(array[i+1]) > 0)
			{
				T aux = array[i];
				array[i] = array[i+1];
				array[i+1] = aux;
			}
		}
		//printArray(array);
	}
	
	private static <T extends Comparable<T>> void sortBackward(T[] array, int i)
	{
		int j = array.length - i - 2;
		for(; j > i; j--)
		{
			if(array[j].compareTo(array[j-1]) < 0)
			{
				T aux = array[j];
				array[j] = array[j-1];
				array[j-1] = aux;
			}
		}
		//printArray(array);
	}
}
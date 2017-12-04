package SortingChallenges;

public class Team9SortCompetition 
{
	public static void main(String[] args) 
	{
		int[] challenge1Test = new int[10000];
		for(int i = 0; i < challenge1Test.length; i++)
		{
			challenge1Test[i] = (int) (Math.random()*10000);
		}
		
		long startTime = System.nanoTime(); //record the startTime
		System.out.println("ChallengeOne Sort Runtime Test:");
		challengeOne(challenge1Test);
		long endTime = System.nanoTime(); //record stopTime
		long totalTime = endTime - startTime; //calculate totalTime
		System.out.println(totalTime/1000000 + " milliseconds");
	}
	
	public static double challengeOne(int[] dataSet)
	{
		quickSort(dataSet,0,dataSet.length);
		return ((dataSet[dataSet.length/2])+(dataSet[(dataSet.length/2)-1]))/2;
	}
	
	public static int challengeTwo(String[] dataSet)
	{
		return -1;
	}
	
	public static double challengeThree(int[] dataSet)
	{
		return 1;
	}
	
	public static double challengeFour(int[][] dataSet)
	{
		return 1;
	}
	
	public static int challengeFive()
	{
		return -1;
	}
	
	/**
	 * This method uses recursion to sort the array that is passed in. The base case
	 * tests if the index is greater than or equal to the back index. If it is, then 
	 * the array has been sorted and the method stops recursing. If not, it partitions 
	 * the array passed in from index front and back and quick sorts both sides.
	 * 
	 * @param list1 The array to be sorted
	 * @param front	The front index of the range of numbers to be sorted
	 * @param back The last index of the range of numbers to be sorted
	 */
	public static void quickSort(int[] list1, int front, int back)
	{
		if (front >= back)
		{
			return;
		}
		else
		{
			int PIVOTindex = partition(list1, front, back);
			quickSort(list1, front, PIVOTindex);
			quickSort(list1, PIVOTindex + 1, back);
		}
	}
	
	/**
	 * This method takes Array at index front and sets it as the pivot. The
	 * pivot is used to test every element and see whether or not they are less or greater
	 * than the pivot. All elements that are less than the pivot and are within the index 
	 * range of front and back are swapped and moved to the left of the pivot and all 
	 * elements that are greater than the pivot are swapped and moved to the right of the pivot.
	 * It then returns the index of the pivot
	 * 
	 * @param list The array to be partition
	 * @param front The first number in the range of numbers to be partitioned
	 * @param back The last number index in the range of numbers to be partitioned
	 * @return the index of the pivot
	 */
	public static int partition(int[] list, int front, int back)
	{
		int pivot = list[front];
		int i = front;
		for (int j = front + 1; j < back; j++)
		{
			if (list[j] <= pivot)
			{
				i++;
				swap(list, i, j);
			}
		}
		swap(list, i, front);
		return i;
	}
	
	/**
	 * This helper method swaps elements of the integer array at i and j by 
	 * setting a[i] to a temporary so that the value isn't lost. It then sets 
	 * a[i] to a[j] and setting a[j] to the temporary variable
	 * 
	 * @param a the integer array that is passed in where elements need to be swapped
	 * @param i	the first number that needs to be swapped with the second
	 * @param j the second number that needs to be swapped with the first
	 */
	private static void swap(int[] a, int i, int j)
	{
	    int temp = a[i];
	    a[i] = a[j];
	    a[j] = temp;
	}
}
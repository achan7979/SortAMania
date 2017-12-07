package SortingChallenges;
import java.util.Random;

public class Team9SortCompetition 
{
	public static void main(String[] args)
	{
		//CHALLENGE ONE
		int[] challenge1Test = new int[10000];
		for(int i = 0; i < challenge1Test.length; i++)
		{
			challenge1Test[i] = (int) (Math.random()*10000);
		}
		
		long startTime = System.nanoTime(); //record the startTime
		System.out.println("ChallengeOne Sort Runtime Test:");
		int median = challengeOne(challenge1Test);
		long endTime = System.nanoTime(); //record stopTime
		long totalTime = endTime - startTime; //calculate totalTime
		System.out.println(totalTime/1000000 + " milliseconds");
		System.out.println(median + "\n");
		
		
		
		//CHALLENGE TWO
		/*
		String[] challenge2Test = new String[10000];
		String random = new String();
		String random2 = new String();
		final String alphabet2 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		final int N1 = alphabet2.length();
		Random r1 = new Random();
		for(int i = 0; i < challenge2Test.length; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				random2 = random2 + alphabet2.charAt(r1.nextInt(N1));
			}
			challenge2Test[i] = random2;
		}
		for(int x = 0; x < 5; x++)
		{
			random = random + alphabet2.charAt(r1.nextInt(N1));
		}
		
		startTime = System.nanoTime(); //record the startTime
		System.out.println("ChallengeTwo Sort Runtime Test:");
		int index = challengeTwo(challenge2Test, random); 
		endTime = System.nanoTime(); //record stopTime
		totalTime = endTime - startTime; //calculate totalTime
		System.out.println(totalTime/1000000 + " milliseconds");
		System.out.println(index + "\n");
		*/
		
		//CHALLENGE FOUR
		int[][] challenge4Test = new int[1000][1000];
		for(int i = 0; i < challenge4Test.length; i++)
		{
			for(int j = 0; j < challenge4Test[i].length; j++)
			{
				challenge4Test[i][j] = (int) (Math.random()*10000);
			}
		}
		
		
		startTime = System.nanoTime(); //record the startTime
		System.out.println("ChallengeFour Sort Runtime Test:");
		double median2 = challengeFour(challenge4Test); 
		endTime = System.nanoTime(); //record stopTime
		totalTime = endTime - startTime; //calculate totalTime
		System.out.println(totalTime/1000000 + " milliseconds");
		System.out.println(median2);
	}
	
	public static int challengeOne(int[] dataSet)
	{
		countingSort(dataSet,0,dataSet.length); //1 MS
		return median(dataSet);
	}
	
	public static int challengeTwo(String[] dataSet, String item)
	{
		//bubbleSort(dataSet); //1000 MS
		//selectionSort(dataSet); //550 MS
		//insertionSort(dataSet); //500 MS
		quickSort(dataSet,0,dataSet.length);
		for(int i = 0; i< dataSet.length; i++)
		{
			if(item.equals(dataSet[i]))
			{
				return i;
			}
		}
		return -1;
	}
	
	public static double challengeThree(int[] dataSet)
	{
		countingSort(dataSet,0,dataSet.length);
		return median(dataSet);
	}
	
	public static int challengeFour(int[][] dataSet)
	{
		int[] medians = new int[dataSet.length];
		for(int i = 0; i < dataSet.length; i++)
		{
			//insertionSort(dataSet[i]); // 650 MS
			//selectionSort(dataSet[i]); // 1300 MS
			//bubbleSort(dataSet[i]); // 1275 MS
			//quickSort(dataSet[i], 0, dataSet[i].length); //66 MS
			countingSort(dataSet[i],0,dataSet[i].length);
			medians[i] = median(dataSet[i]);
		}
		//insertionSort(medians); // 650 MS
		//selectionSort(medians); // 1300 MS
		//bubbleSort(medians); // 1275 MS
		//quickSort(medians,0,medians.length); //66 MS
		countingSort(medians,0,medians.length);
		return median(medians);
	}
	
	public static int challengeFive()
	{
		return 0;
	}
	
	/**
	 * Bubble sort compares the first pair of elements and swaps them if the element
	 * that comes first is greater than the second. It continues to compare the next pair 
	 * of elements and swaps if needed. This method keeps track of how many swaps occurred in
	 * each iteration until there are no swaps initiated, which then we know the array is sorted
	 * 
	 * @param list1 The list to be sorted
	 */
	public static void bubbleSort(int[] list1)
	{
		int swaps = 0;
		while(swaps == 0)
		{
			for(int i = 0; i < list1.length-1; i++) 
			{
				if(list1[i] > list1[i+1])
				{
					swap(list1,i,i+1);
					swaps++;
				}
			}
			if(swaps == 0)
			{
				break;
			}
			swaps = 0;
		}
	}
	
	public static void bubbleSort(String[] list1)
	{
		int swaps = 0;
		while(swaps == 0)
		{
			for(int i = 0; i < list1.length-1; i++) 
			{
				if(list1[i].compareTo(list1[i+1]) > 0)
				{
					swap(list1,i,i+1);
					swaps++;
				}
			}
			if(swaps == 0)
			{
				break;
			}
			swaps = 0;
		}
	}
	
	/**
	 * Selection sort finds the smallest element in the array and moves it
	 * to the front of the array. Then it searches for the next smallest element
	 * in the array and puts it after the first element and repeats
	 * 
	 * @param list1 The list to be sorted
	 */
	public static void selectionSort(int[] list1)
	{
		for(int i = 0; i < list1.length; i++)
		{
			for(int j = i+1; j < list1.length; j++)
			{
				if(list1[i] > list1[j])
				{
					swap(list1,i,j);
				}
			}
		}
	}
	
	public static void selectionSort(String[] list1)
	{
		for(int i = 0; i < list1.length; i++)
		{
			for(int j = i+1; j < list1.length; j++)
			{
				if(list1[i].compareTo(list1[j]) > 0)
				{
					swap(list1,i,j);
				}
			}
		}
	}
	
	/**
	 * Insertion sort method takes each element from the array and adds it to the 
	 * front of the array in ascending order. It also keeps track of where the 
	 * insertion occurs
	 * 
	 * @param list1 The list to be sorted
	 */
	public static void insertionSort(int[] list1) 
	{
		int j = 0;
		for (int i = 0; i <= list1.length; i++)
		{
			for (int k = j-1; k >= 0; k--)
			{
				if (list1[k] > list1[j])
				{
					swap(list1,k,j);
					j--;
				}
			}
			j = i;
		}
	}
	
	public static void insertionSort(String[] list1) 
	{
		int j = 0;
		for (int i = 0; i <= list1.length; i++)
		{
			for (int k = j-1; k >= 0; k--)
			{
				if (list1[k].compareTo(list1[j]) > 0)
				{
					swap(list1,k,j);
					j--;
				}
			}
			j = i;
		}
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
	
	public static void quickSort(String[] list1, int front, int back)
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
	
	public static void quickSort(Comparable[] objects, int front, int back)
	{
		if (front >= back)
		{
			return;
		}
		else
		{
			int PIVOTindex = partition(objects, front, back);
			quickSort(objects, front, PIVOTindex);
			quickSort(objects, PIVOTindex + 1, back);
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
	
	public static int partition(String[] list, int front, int back)
	{
		String pivot = list[front];
		int i = front;
		for (int j = front + 1; j < back; j++)
		{
			if (list[j].compareTo(pivot) <= 0)
			{
				i++;
				swap(list, i, j);
			}
			
		}
		swap(list, i, front);
		return i;
	}
	
	public static int partition(Comparable[] objects, int front, int back)
	{
		Comparable pivot = objects[front];
		int i = front;
		for (int j = front + 1; j < back; j++)
		{
			if (objects[j].compareTo(pivot) <= 0)
			{
				i++;
				swap(objects, i, j);
			}
			
		}
		swap(objects, i, front);
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
	
	private static void swap(String[] a, int i, int j)
	{
	    String temp = a[i];
	    a[i] = a[j];
	    a[j] = temp;
	}
	
	private static void swap(Comparable[] a, int i, int j)
	{
	    Comparable temp = a[i];
	    a[i] = a[j];
	    a[j] = temp;
	}
	
	/**
	 * This helper method finds the median of the sorted integer array that is passed
	 * in by taking the length of the array, dividing it by 2 and taking the integer
	 * at that index and adding it to the integer at the same index minus 1 and dividing
	 * the sum by 2 to get the average of both.
	 * 
	 * @param list1 the integer array that is passed in
	 * @return the median of the array
	 */
	public static int median(int[] list1)
	{
		if(list1.length % 2 == 1)
		{
			return (list1[(int)(list1.length/2) + 1]);
		}
		return ((list1[list1.length/2])+(list1[(list1.length/2)-1]))/2;
	}

	/**
	 * 
	 * @param list1
	 * @param rangeL
	 * @param rangeH
	 * @return
	 */
	public static int[] countingSort(int[] list1, int rangeL, int rangeH)	
	{
		int[] count = new int[rangeH - rangeL + 1];
		for (int i = 0; i < list1.length; i++)
		{
			count[list1[i] - rangeL]++;
			//System.out.println(list1[i]);
		}
		//int tempSum = 0;
		for (int i = 1; i < count.length; i++)
		{
			count[i] = count[i] + count[i-1];
			//tempSum = count[i];count[i]
			//System.out.println(list1[i]);
		}
		int[] sorted = new int[rangeH - rangeL + 1];
		for (int i = 0; i < list1.length; i++)
		{
			sorted[count[list1[i]]] = list1[i];
			count[list1[i]]--;
		}
		return sorted;
	}
}
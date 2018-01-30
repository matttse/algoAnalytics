package algoAnalytics;

import java.util.ArrayList;
import java.util.Arrays;

// File: Quicksort.java
// A Java application to illustrate the use of a quicksort. Part of this work
// is left as an exercise for students using "Data Structures and Other
// Objects with Java" by Michael Main.
 
/******************************************************************************
* The <CODE>Quicksort</CODE> Java application illustrates a quicksort.
* <B>Part of the implementation (the <CODE>partition</CODE> method) is left
* as a student exercise.</B>
*
* <dt><b>Note:</b><dd>
*   This file contains only blank implementations ("stubs")
*   because this is a Programming Project for my students.
*
* <p><dt><b>Java Source Code for this class (without 
* <CODE>partition</CODE>:</b><dd>
*   <A HREF="../applications/Quicksort.java">
*   http://www.cs.colorado.edu/~main/applications/Quicksort.java
*   </A>
*
* @version
*   Jan 24, 1999
******************************************************************************/
public class Quicksort
{
   /**
   * The main method illustrates the use of a quicksort to sort a 
   * small array.
   * The <CODE>String</CODE> arguments (<CODE>args</CODE>) are not used 
   * in this implementation.
   **/
   public static void main(String[ ] args)
   {
      System.out.println( );
   }
   
   
   /**
   * This method cannot be used until the student implements 
   * <CODE>partition</CODE>.
   * Sort an array of integers from smallest to largest, using a quicksort
   * algorithm.
   * @param <CODE>data</CODE>
   *   the array to be sorted
   * @param <CODE>first</CODE> 
   *   the start index for the portion of the array that will be sorted
   * @param <CODE>n</CODE>
   *   the number of elements to sort
   * <dt><b>Precondition:</b><dd>
   *   <CODE>data[first]</CODE> through <CODE>data[first+n-1]</CODE> are valid
   *   parts of the array.
   * <dt><b>Postcondition:</b><dd>
   *   If <CODE>n</CODE> is zero or negative then no work is done. Otherwise, 
   *   the elements of </CODE>data</CODE> have been rearranged so that 
   *   <CODE>data[first] &lt= data[first+1] &lt= ... &lt= data[first+n-1]</CODE>.
   * @exception ArrayIndexOutOfBoundsException
   *   Indicates that <CODE>first+n-1</CODE> is an index beyond the end of the
   *   array.
   * */
   public static void quicksort(int[ ] data, int first, int n)
   {
      int pivotIndex; // Array index for the pivot element
      int n1;         // Number of elements before the pivot element
      int n2;         // Number of elements after the pivot element
      
      if (n > 1)
      {
         // Partition the array, and set the pivot index.
         pivotIndex = partition(data, first, n);

         // Compute the sizes of the two pieces.
         n1 = pivotIndex - first;
         n2 = n - n1 - 1;
        
         // Recursive calls will now sort the two pieces.
         quicksort(data, first, n1);
         quicksort(data, pivotIndex + 1, n2);
      }
   }
   
   private static int partition(int[ ] data, int first, int n)
   // Precondition: n > 1, and data has at least n elements starting at
   // data[first].
   // Postcondition: The method has selected some "pivot value" that occurs
   // in data[first]. . .data[first+n-1]. The elements of data have then been
   // rearranged and the method returns a pivot index so that
   //   -- data[pivot index] is equal to the pivot;
   //   -- each element before data[pivot index] is <= the pivot;
   //   -- each element after data[pivot index] is > the pivot.
   {
      
	   int pivot = data[first];
	   int tooBigIndex = first + 1;//index of element after pivot
	   int tooSmallIndex = first + n - 1;//index of last element

	   //repeat until the 2 indexes cross each other
		do {
		   //tooBigIndex not beyond final index of the partitioned array and
		   //data at index is less than or equal to pivot
		   while ((tooBigIndex < data.length) 
				   && (data[tooBigIndex] <= pivot)) {
			   tooBigIndex = tooBigIndex + 1;//move to next index
		   }
		   
		   //data at index is greater than pivot
		   while (data[tooSmallIndex] > pivot) {
			   tooSmallIndex = tooSmallIndex - 1;//move to previous index
		   }
		   //swap values
		   if (tooBigIndex < tooSmallIndex) {
			  int tmp1 = data[tooSmallIndex];
			  int tmp2 = data[tooBigIndex];
			  data[tooSmallIndex] = tmp2;
			  data[tooBigIndex] = tmp1;
		   }			
		} while ((tooBigIndex <= tooSmallIndex));
	   //updating pivot position @data[tooSmallIndex]
	   //update data first, should be a value less than or equal to pivot
	   data[first] = data[tooSmallIndex];
	   //set
	   data[tooSmallIndex] = pivot;
	   //index where the pivot is
	   return tooSmallIndex;

   }

}


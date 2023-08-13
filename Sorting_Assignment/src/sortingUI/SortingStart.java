package sortingUI;

import java.io.IOException;

import sortingTest.SortingTest;

public class SortingStart {
	public static void main (String[] args) throws IOException {
		SortingTest test = new SortingTest();
		
		test.fillArray();
		System.out.println("Unsorted");
		test.displayArray(test.getStudentList());
		
		System.out.println();
		System.out.println("Sorted by Insertion");
		test.insertionTest();
		
		System.out.println();
		System.out.println("Sorted by Selection");
		test.selectionTest();
		
		System.out.println();
		System.out.println("Sorted by Merge");
		test.mergeTest();
		
		System.out.println();
		System.out.println("Sorted by Quick");
		test.quickTest();
	}
}

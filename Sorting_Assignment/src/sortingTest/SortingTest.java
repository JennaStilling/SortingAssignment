package sortingTest;

import java.io.IOException;
import java.util.ArrayList;

import sortingPD.SortedList;
import sortingPD.StopWatch;
import studentDM.StudentDM;
import studentPD.Student;

public class SortingTest {
	StudentDM students;
	ArrayList<Student> studentList;
	ArrayList<Student> sortedList;
	SortedList list;
	StopWatch watch;
	long startTime;
	long endTime;
	long elapsed;
	
	
	public SortingTest() {
		studentList = new ArrayList<Student>();
		students = new StudentDM();
		list = new SortedList();
		sortedList = new ArrayList<Student>();
		watch = new StopWatch();
	}
	
	public void insertionTest() throws IOException {
		fillArray();
		startTime = watch.start();
		studentList = list.insertionSort(studentList);
		endTime = watch.stop();
		elapsed = watch.runtime();
		System.out.println("Elapsed time: " + elapsed + " ms\n----");
		displayArray(studentList);
	}
	
	public void selectionTest() throws IOException {
		fillArray();
		startTime = watch.start();
		studentList = list.selectionSort(studentList);
		endTime = watch.stop();
		elapsed = watch.runtime();
		System.out.println("Elapsed time: " + elapsed + " ms\n----");
		displayArray(studentList);
	}
	
	public void mergeTest() throws IOException {
		fillArray();
		startTime = watch.start();
		list.mergeSort(studentList);
		endTime = watch.stop();
		elapsed = watch.runtime();
		System.out.println("Elapsed time: " + elapsed + " ms\n----");
		displayArray(studentList);
	}
	
	public void quickTest() throws IOException {
		fillArray();
		startTime = watch.start();
		studentList = list.quickSort(studentList, 0, studentList.size() -1);
		endTime = watch.stop();
		elapsed = watch.runtime();
		System.out.println("Elapsed time: " + elapsed + " ms\n----");
		displayArray(studentList);
	}

	public void displayArray(ArrayList<Student> l) {
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i));
		}
	}
	
	public void fillArray() throws IOException {
		studentList = new ArrayList<Student>();
		students = new StudentDM();
		students.readStudentData();
		studentList = students.getStudentData();
	}
	
	public ArrayList<Student> getStudentList() {
		return studentList;
	}
}

package sortingPD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import studentPD.Student;

public class SortedList<E> extends ArrayList<E> {
	ArrayList<E> list;
	
	public SortedList() {
		list = new ArrayList<E>();
	}
	
	//by insertion
	public ArrayList<Student> insertionSort(ArrayList<Student> s) {
		for (int i = 1; i < s.size(); i++) {
			Student e = s.get(i);
			
			int j;
			
			for (j = i; j > 0 && s.get(j-1).getId() > e.getId(); j--)
				s.set(j, s.get(j-1));
			
			s.set(j, e);
		}
		return s;
	}
	
	//by selection
	public ArrayList<Student> selectionSort(ArrayList<Student> s) {
		for (int i = s.size() - 1; i > 0; i--) {
			int index = 0;
			
			for (int j = 1; j <= i; j++) {
				if (s.get(j).getId() > s.get(index).getId()) {
					index = j;
				}
			}
			
			Student temp = s.get(index);
			s.set(index, s.get(i));
			s.set(i, temp);
		}
			
		return s;
	}
	
	public void mergeSort(ArrayList<Student> s) {
		int n = s.size();
		
		if (n < 2)
			return;
		
		int mid = n/2;
		
		List<Student> temp1 = s.subList(0, mid);
		ArrayList<Student> s1 = new ArrayList<Student>();
		for (int i = 0; i < temp1.size(); i++) {
			s1.add(temp1.get(i));
		}

		
		List<Student> temp2 = s.subList(mid, n);
		ArrayList<Student> s2 = new ArrayList<Student>();
		for (int i = 0; i < temp2.size(); i++) {
			s2.add(temp2.get(i));
		}

		
		mergeSort(s1);
		mergeSort(s2);
		
		merge(s, s1, s2);

		//return s;
	}
	
	public void merge(ArrayList<Student> s, ArrayList<Student> s1, ArrayList<Student> s2) {
		Comparator<Integer> comp;
		comp = new Comparator<Integer>() {
		    @Override
		    public int compare(Integer a, Integer b) {
		    	return a.compareTo(b);
		    }
		};
		
		int i = 0;
		int j = 0;
		
		while (i + j < s.size()) {
			if (j == s2.size() || (i < s1.size() && comp.compare(Integer.valueOf(s1.get(i).getId()), Integer.valueOf(s2.get(j).getId())) < 0))
				s.set(i+j, s1.get(i++));
			else
				s.set(i+j, s2.get(j++));
		}
		
		//return s;
	}
	
	public ArrayList<Student> quickSort(ArrayList<Student> s, int min, int max) {
		if (min < max) {
			int mid = split(s, min, max);
					
			quickSort(s, min, mid-1);
			quickSort(s, mid+1, max);
		}
		return s;
	}
	
	int split (ArrayList<Student> s, int min, int max) {
		Student mid = s.get(max);
		int i = min-1;
		
		for (int j = min; j < max; j++) {
			if (s.get(j).getId() <= mid.getId()) {
				i++;
				
				Student temp = s.get(i);
				s.set(i, s.get(j));
				s.set(j, temp);
			}
		}
		
		Student temp = s.get(i+1);
		s.set(i+1, s.get(max));
		s.set(max, temp);
		
		return i+1;
	}
	 

}



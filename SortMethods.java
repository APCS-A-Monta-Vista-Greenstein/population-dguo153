/**
 * SortMethods - Sorts a List of City objects in ascending order by population
 *
 * @author Daphne Guo
 * @since December 5, 2022
 */

import java.util.List;
import java.util.ArrayList;

public class SortMethods {
	
	/**
	 * Bubble sort algorithm - in ascending order
	 * @param sortList			List of City objects to sort
	 */
	public void bubbleSort(List<City> sortList) {
		for(int outer = sortList.size() - 1; outer > 0; outer--) {
			for(int inner = 0; inner < outer; inner++) {
				if(sortList.get(inner).compareTo(sortList.get(inner + 1)) > 0) {
					swap(sortList, inner, inner + 1);
				}
			}
		}
	}
	
	/**
	 * Swaps two City objects in List sortList
	 * @param sortList			List of City objects
	 * @param x							index of first object to swap
	 * @param y							index of second object to swap
	 */
	private void swap(List<City> sortList, int x, int y) {
		City temp = sortList.get(x);
		sortList.set(x, sortList.get(y));
		sortList.set(y, temp);
	}
	
	/**
	 * Selection sort algorithm - in ascending order
	 * @param sortList			List of City objects to sort
	 */
	public void selectionSort(List<City> sortList) {
		for(int outer = 0; outer < sortList.size() - 1; outer++) {
			int minIndex = outer;
			for(int inner = outer; inner < sortList.size() - 1; inner++) {
				if(sortList.get(minIndex).compareTo(sortList.get(inner)) > 0) {
					minIndex = inner;
				}
			}
			swap(sortList, outer, minIndex);
		}
	}
	
	/**
	 * Insertion sort algorithm - in ascending order
	 * @param sortList			List of City objects to sort
	 */
	public void insertionSort(List<City> sortList) {
		List<City> sorted = new ArrayList<City>(sortList.size());
		sorted.add(sortList.get(0));
		for(int outer = 1; outer < sortList.size(); outer++) {
			int inner = sorted.size() - 1;
			while(inner > 0 && sorted.get(inner - 1). compareTo(sortList.get(outer)) > 0) {
				inner--;
			}
			if(sorted.get(sorted.size() - 1).compareTo(sortList.get(outer)) < 0) {
				sorted.add(sortList.get(outer));
			}
			else {
				sorted.add(inner, sortList.get(outer));
			}
		}
		for(int i = 0; i < sortList.size(); i++) {
			sortList.set(i, sorted.get(i));
		}
	}
	
	/**
	 * Merge sort algorithm - in ascending order
	 * @param sortList			List of City objects to sort
	 */
	public void mergeSort(List<City> sortList) {
		List<City> left = new ArrayList<City>(sortList.size() / 2);
		List<City> right = new ArrayList<City>(sortList.size() - sortList.size() / 2);
		for(int i = 0; i < sortList.size(); i++) {
			if(i < sortList.size() / 2) {
				left.add(sortList.get(i));
			}
			else {
				right.add(sortList.get(i));
			}
		}
		
		if(left.size() > 2) {
			mergeSort(left);
		}
		else {
			bubbleSort(left);
		}
		if(right.size() > 2) {
			mergeSort(right);
		}
		else {
			bubbleSort(right);
		}
		
		int l = 0, r = 0, counter = 0;
		while(l < left.size() && r < right.size()) {
			if(left.get(l).compareTo(right.get(r)) <= 0) {
				sortList.set(counter, left.get(l));
				l++;
				counter++;
			}
			else if(right.get(r).compareTo(left.get(l)) < 0) {
				sortList.set(counter, right.get(r));
				r++;
				counter++;
			}
		}
		if(l == left.size()) {
			for(int i = r; i < right.size(); i++) {
				sortList.set(counter, right.get(i));
				counter++;
			}
		}
		if(r == right.size()) {
			for(int i = l; i < left.size(); i++) {
				sortList.set(counter, left.get(i));
				counter++;
			}
		}
	}
}

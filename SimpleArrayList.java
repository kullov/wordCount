package wordCount;
import java.util.Arrays;
import java.util.Iterator;

public class SimpleArrayList<T> implements ListInterface<T> {

	private T[] array;
	private int n = 0;
	private int defaultSize = 100;

	public SimpleArrayList() {
		array = (T[]) new Object[defaultSize];
	}

	public SimpleArrayList(int capacity) {
		// Hàm dựng với kích thước mảng là capacity
		array = (T[]) new Object[capacity];
	}

	public void add(T data) {
		T[] array1 = (T[]) new Object[n+1];
		for (int i = 1; i < n; i++) {
			array1[0] = data;
			array1[i] = array[i+1];
		}
		array = array1;
	}

	public T get(int i) {
		if (i < n && i >= 0) {
			return array[i];
		}
		return null;
		
	}

	public void set(int i, T data)
	{
	    for (int j = 0; j < n; j++) {
			if (j == i) {
				array[j] = data;
			}
		}
	}
	public void remove(int i) {
		T[] array1 = (T[]) new Object[defaultSize];
		for (int j = 0; j < n; j++) {
			if (j == i) {
				array[j] = array[j+1];
				n--;
			}
		}
		array = array1;
	}

	public boolean isContain(T data) {
		for (int i = 0; i < n; i++) {
			if (array[i] == data) {
				return true;
			}
		}
		
		return false;
	}
	
	public int indexOf(T data)
	{
		return -1;
	}

	public int size() {
		return n;
	}

	public boolean isEmpty() {
		return n==0;
	}

	public Iterator<T> iterator() {
		return new ArrayListIterator();
	}
	
	class ArrayListIterator implements Iterator<T>
	{
		private int current = 0;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current  < n;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			T data = array[current];
			current++;
			return data;
		}
		
	}

}

package org.CSC161.ArrayAndLinkedList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author downey
 * @param <T>
 *
 */
public class MyArrayList<T> implements List<T> {
	int size;                    // keeps track of the number of elements
	private T[] array;           // stores the elements

	/**
	 *
	 */
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		// You can't instantiate an array of T[], but you can instantiate an
		// array of Object and then typecast it.  Details at
		// http://www.ibm.com/developerworks/java/library/j-jtp01255/index.html
		array = (T[]) new Object[10];
		size = 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// run a few simple tests
		MyArrayList<Integer> mal = new MyArrayList<Integer>();
		mal.add(1);
		mal.add(2);
		mal.add(3);
		System.out.println(Arrays.toString(mal.toArray()) + " size = " + mal.size);
		mal.remove(Integer.valueOf(2));
		System.out.println(Arrays.toString(mal.toArray()) + " size = " + mal.size);
		System.out.println("3 is located at index: " + mal.indexOf(3));
		mal.set(3, 5);
		System.out.println(Arrays.toString(mal.toArray()) + " size = " + mal.size);
		System.out.println("5 is located at index: " + mal.indexOf(5));
	}

	/**Appends the element to the end of the list
	 * @author youngren
	 * @param: element - the element to be added to the list
	 * @return: True - is the array was changed
	 * @return: False - if element already exists in the collection
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean add(T element) {
		 T[] tempArray;
		 for(int i = 0; i < array.length; i++)
		 {
			 if(equals(array[i], element))
			 {
				 return false;
			 }
		 }
		 if( size >= array.length)
		 {
			 tempArray = array;
			 array = (T[]) new Object[(tempArray.length * 2)];
			 for(int i = 0; i < tempArray.length; i++)
			 {
				 array[i] = tempArray[i];
			 }
			 array[size] = element;
			 size++;
			 return true;
		 }
		 else
		 {
			 array[size] = element;
			 size++;
			 return true;
		 }	
	}

	@Override
	public void add(int index, T element) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		// add the element to get the resizing
		add(element);

		// shift the elements
		for (int i=size-1; i>index; i--) {
			array[i] = array[i-1];
		}
		// put the new one in the right place
		array[index] = element;
	}

	@Override
	public boolean addAll(Collection<? extends T> collection) {
		boolean flag = true;
		for (T element: collection) {
			flag &= add(element);
		}
		return flag;
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> collection) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear() {
		// note: this version does not actually null out the references
		// in the array, so it might delay garbage collection.
		size = 0;
	}

	@Override
	public boolean contains(Object obj) {
		return indexOf(obj) != -1;
	}

	@Override
	public boolean containsAll(Collection<?> collection) {
		for (Object element: collection) {
			if (!contains(element)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		return array[index];
	}

	/**Retrieves the index of the first occurrence of specified object within the array
	 * @author youngren
	 * @param: target - the object of wanted index
	 * @return i - the index number of target object
	 * @return -1 - no instance of specified object exists within the array
	 */
	@Override
	public int indexOf(Object target) {
		for(int i = 0; i < array.length; i++)
		{
			if(array[i] == target)
			{
				return i;
			}
		}
		return -1;
	}

	/** Checks whether an element of the array is the target.
	 *
	 * Handles the special case that the target is null.
	 *
	 * @param target
	 * @param object
	 */
	private boolean equals(Object target, Object element) {
		if (target == null) {
			return element == null;
		} else {
			return target.equals(element);
		}
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Iterator<T> iterator() {
		// make a copy of the array
		T[] copy = Arrays.copyOf(array, size);
		// make a list and return an iterator
		return Arrays.asList(copy).iterator();
	}

	@Override
	public int lastIndexOf(Object target) {
		// see notes on indexOf
		for (int i = size-1; i>=0; i--) {
			if (equals(target, array[i])) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public ListIterator<T> listIterator() {
		// make a copy of the array
		T[] copy = Arrays.copyOf(array, size);
		// make a list and return an iterator
		return Arrays.asList(copy).listIterator();
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		// make a copy of the array
		T[] copy = Arrays.copyOf(array, size);
		// make a list and return an iterator
		return Arrays.asList(copy).listIterator(index);
	}

	@Override
	public boolean remove(Object obj) {
		int index = indexOf(obj);
		if (index == -1) {
			return false;
		}
		remove(index);
		return true;
	}

	/**Removes an element at specified index within the array
	 * @author youngren
	 * @param: index - index of the element to be removed
	 * @return: tempVar - the element that was removed
	 */
	@Override
	public T remove(int index) {
		T tempVar = array[index];
		for(int i = index; i < array.length - 1; i++)
		{
			array[i] = array[i + 1];
		}
		size--;
		return tempVar;
	}

	@Override
	public boolean removeAll(Collection<?> collection) {
		boolean flag = true;
		for (Object obj: collection) {
			flag &= remove(obj);
		}
		return flag;
	}

	@Override
	public boolean retainAll(Collection<?> collection) {
		throw new UnsupportedOperationException();
	}

	/**Sets specified element into the specified index
	 * @author youngren
	 * @param: index - the index of the array that element will be placed
	 * @param: element - The element being placed within the array
	 * @return: tempVar - The element that was replaced by parameter element
	 */
	@Override
	public T set(int index, T element) {
		T tempVar1;
//		T tempVar2; //Left here for note purposes
		tempVar1 = array[index];
		array[index] = element;
//		for(int i = (index + 1); i < array.length; i++) //Left here for note purposes
//		{
//			tempVar2 = array[i];
//			array[i] = tempVar1;
//			tempVar1 = tempVar2;
//		}
		return tempVar1;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		if (fromIndex < 0 || toIndex >= size || fromIndex > toIndex) {
			throw new IndexOutOfBoundsException();
		}
		T[] copy = Arrays.copyOfRange(array, fromIndex, toIndex);
		return Arrays.asList(copy);
	}

	@Override
	public Object[] toArray() {
		return Arrays.copyOf(array, size);
	}

	@Override
	public <U> U[] toArray(U[] array) {
		throw new UnsupportedOperationException();
	}
}

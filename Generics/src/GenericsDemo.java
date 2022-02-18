import java.util.ArrayList;
import java.util.List;

public class GenericsDemo {

	public static void main(String[] args) {

		ArrayList<String> colors = new ArrayList<String>();
		
		// Can only assign Strings to the elements of the above ArrayList
		colors.add("Red");
		colors.add("Apple");    // Apple is not a color but it is string
		
		/* This is illegal */
		// colors.add(5);         

		// Using Object is similar to having no restrictions on the class of objects (useless?)
		ArrayList<Object> anyObject = new ArrayList<>();
		anyObject.add("Red");
		anyObject.add("Apple");  
		anyObject.add(Integer.valueOf(5));    // ArrayLists only store objects
		anyObject.add(8);					  // However, this works because of autoboxing
		
		
//		ReverseList<Integer> myList = new ReverseList<>();
//
//		myList.add(3);
//		myList.add(1);
//		myList.add(4);
		/* myList.addToList("Red");          // No worky!    */
//		
//		for (int i : myList.getList()) {
//			System.out.println(i);
//		}
				

		/* To demo generic methods */
//		ArrayList<NoCompare> cmpList = new ArrayList<>();
//
//		cmpList.add(new NoCompare(8));
//		cmpList.add(new NoCompare(9));
//		cmpList.add(new NoCompare(4));
//		
//		for (NoCompare noc : cmpList) {
//			System.out.println(noc.getValue());
//		}
//				
//		sort(cmpList);
//		
//		for (NoCompare noc : cmpList) {
//			System.out.println(noc.getValue());
//		}
		
	}

	
	public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
		E currentMin;
		int currentMinIndex;
		
		// ArrayList<E> list = rList.list;
		
		for (int i = 0; i < list.size() - 1; i++) {
			// Find the minimum in the list[i+1..list.length-2]
			currentMin = list.get(i);
			currentMinIndex = i;
	
			for (int j = i + 1; j < list.size(); j++) {
				if (currentMin.compareTo(list.get(j)) > 0) {
					currentMin = list.get(j);
					currentMinIndex = j;
				}
			}
	
			// Swap list[i] with list[currentMinIndex] if necessary;
			if (currentMinIndex != i) {
				list.set(currentMinIndex, list.get(i));
				list.set(i, currentMin);
			}
		}	
	}
}

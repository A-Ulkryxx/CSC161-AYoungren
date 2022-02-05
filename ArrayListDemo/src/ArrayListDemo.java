import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class ArrayListDemo {
	public static void main(String[] args) {

		String[] dogNames;
		
		dogNames = new String[3];
		
		dogNames[0] = "Roscoe";
		dogNames[1] = "Fido";
		dogNames[2] = "Ranger";
		
		System.out.println(Arrays.toString(dogNames));
		
		for(String dogName: dogNames) {
			System.out.println(dogName);
		}
		
		ArrayList<String> animals = new ArrayList<String>();
		// ArrayList<String> animals = new ArrayList<>();
		
		animals.add("Giraffe");
		animals.add("Lion");
		animals.add("Tiger");
		
		for(String animal: animals) {
			System.out.println(animal);
		}
		
		animals.remove(1);
		for(String animal: animals) {
			System.out.println(animal);
		}		
		
		animals.remove("Tiger");
		for(String animal: animals) {
			System.out.println(animal);
		}	
		
		LinkedList<String> shapes = new LinkedList<String>();
		// LinkedList<String> shapes = new LinkedList<>();
		
		shapes.add("Rectangle");
		shapes.add("Circle");
		shapes.add("Triangle");
		
		for(String kindOfShape: shapes) {
			System.out.println(kindOfShape);
		}
		
	}
}
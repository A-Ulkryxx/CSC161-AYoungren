import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Exercise1 {

	public class ListClientExample 
	{
		private ArrayList list;
		
		public ListClientExample() 
		{
			list = new ArrayList();
		}
		private List getList() {
			return list;
		}
		
		public static void main(String[] args) 
		{
			ListClientExample lce = new ListClientExample();
			List list = lce.getList();
			System.out.println(list);
		}
	}

}

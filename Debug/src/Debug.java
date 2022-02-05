
public class Debug {

	public static void main(String[] args) {
		//initialize a two-dimensional array
		int[][] arr = {{1, 2},{3,4},{5,6},{7,8}, {9,10}};//five rows, two columns
		
		int theNumChange = 0;
		for (int i = 0; i < arr.length; i++)
		{
			for(int j = 0; i < arr[0].length; j++)
			{
				add10(arr, i, j);
				if(i == 3 && j == 1)
				{
					theNumChange = arr[i][j];
				}
				System.out.println("Value is: " + arr[i][j]);
			}
		}
	}
	
	public static void add10(int[][] array, int x, int y)
	{
		array[x][y] += 10;
		return;
	}
}

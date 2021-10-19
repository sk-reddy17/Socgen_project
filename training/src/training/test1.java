package training;

public class test1 {
	
	public static void fun(int arr[])
	{
		int index = -1;
		int var ;
		for(int i = 0; i <arr.length;i++)
		{
			if(arr[i] % 2 == 0)
			{
				index += 1;
				var = arr[i];
				arr[i] = arr[index];
				arr[index] = var;
			}
		}
	}
	public static void main(String[] args)
	{
		int arr[] = {1,2,9,8,10,5};
		fun(arr);
		
		for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");

}
}

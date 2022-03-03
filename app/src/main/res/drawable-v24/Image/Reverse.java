package Experiments;
import java.util.Scanner;
public class Reverse 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a String");
		String str=sc.next();
		char ch[]=str.toCharArray();
		System.out.print("Reversed String is ");
		for(int i=ch.length-1;i>=0;i--)
		{
			System.out.print(ch[i]);
		}
	}
}

package Quiz;
import java.io.*;
import java.util.*;
public class Quiz 
{//��������� �����(������� �������)
	public static void main(String[] args) throws IOException
	{
		System.out.println("����������� ��� � ����� ���������!\n������� ���� ���:");		
		Scanner enter = new Scanner(System.in);
		String name = enter.next();
		System.out.println("������� �������������, " + name + "!\n����� �������� � ������������ ������� � ��? ��� � ���� ��� �������� �������?");
		System.out.println("��� ������ �� ������� ����������� ������� �� 1 �� 4. ������� ���������� �� ������� ������� 0");	
		Event s = new Event(name);	
	}

}
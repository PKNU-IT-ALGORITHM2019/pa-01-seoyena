

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Samlpe1 { 
	public static int middle;
	public static int search(ArrayList<String> a,int n,String word) {
			int low,high;
		
			low=0;
			high=n-1;
			while(low<=high) {
				middle=(low+high)/2;
				String t=a.get(middle);
				String ttt=a.get(middle-1);
				String tt=t.substring(0,word.length());
				
				String t3=ttt.substring(0,word.length());
		
			
				if(word.equalsIgnoreCase(tt)) {
		
					if(word.equalsIgnoreCase(t3)) {
						high=middle-1;
						System.out.println(tt);
					}
					else {
						return middle;
					}
				}
				else if(word.compareToIgnoreCase(tt)>0) {
					low=middle+1;
				}
				else
					high=middle-1;
			}
			return -1;
	 }
public static void main(String[] args) throws IOException {
Scanner in=new Scanner(System.in);
	
//	File src = new File("C:\\Users\\suuuk\\Desktop\\dict.txt");
	File dst = new File("sample.txt");
	
//	FileInputStream fis = new FileInputStream(src);
//	FileOutputStream fos = new FileOutputStream(dst);
//	
//	
//	OutputStreamWriter osw=new OutputStreamWriter(fos);
//	
//	
//	BufferedWriter bw=new BufferedWriter(osw);
//	
//	int a=0;
//	
//	while(true) {
//		
//		a=fis.read();
//		if(a == -1) {
//			break;
//		}
//		
//		
//		bw.write(a);
//	}
//	System.out.println("복사완료");
//	
//	bw.flush();
//	
	FileInputStream fis1=new FileInputStream(dst);
	InputStreamReader isr=new InputStreamReader(fis1);
	BufferedReader br=new BufferedReader(isr);
ArrayList<String> a1=new ArrayList<String>();
	String ss=null;
	while(true) {
		ss=br.readLine();
		
		if(ss==null)
			break;
		a1.add(ss);
		ss=br.readLine();
		
	}
	while(true) {
	

	System.out.print("입력 : ");
	String word1=in.nextLine();
	if(word1.equalsIgnoreCase("size")) {
		System.out.println("size="+a1.size());
		continue;
	}
	if(word1.equalsIgnoreCase("exit")) {
		System.out.println("종료합니다");
		break;
	}
	String word2=new String(word1+" ");
	String word=word2.substring(5,word2.length());
	System.out.println(word);
//	int count=0;
//	for(int i=0;i<a1.size();i++) {
//		String t=a1.get(i);
//		String tt=t.substring(0,word.length());
//		if(word.equals(tt))
//		{
//			count++;
//
//			
//		}
//	}
//	System.out.println("fount"+count+"items.\n");
//	count=0;
//	for(int i=0;i<a1.size();i++) {
//		String t=a1.get(i);
//		String tt=t.substring(0,word.length());
//		if(word.equals(tt))
//		{
//			
//			System.out.println(t);
//			System.out.print("\n");
//		}
//	}
	
	//이진검색
	int j;
	if(word.equalsIgnoreCase("A ")) {
		j=0;
	}
	else
		j=search(a1,a1.size(),word);
	
	if(j==-1) {
		System.out.println("Not Fount");
		
		String t=a1.get(middle);
//		String z=t.substring(0,6);
//	
//		if(z.equalsIgnoreCase("Zythum ")) {
//			System.out.println("여기");
//		}
		int wi=t.indexOf(")");
		String tt=t.substring(0, wi+1);
		String wi2=t.substring(0,word.length());
		
		if(word.compareToIgnoreCase(wi2)>0) {
			System.out.println(tt);
			System.out.println("---------");
			if(a1.get(middle).substring(0,7).equalsIgnoreCase("Zythum ")) {
				System.out.println("없습니다.");
			
			}
			else {
			String t1=a1.get(middle+1);
			int wi1=t1.indexOf(")");
			String tt1=t1.substring(0, wi1+1);
			System.out.println(tt1);}
		}
		else {
			String t1=a1.get(middle-1);
			int wi1=t1.indexOf(")");
			String tt1=t1.substring(0, wi1+1);
			System.out.println(tt1);
			System.out.println("---------");
			System.out.println(tt);
		}
		
		
	
	}
	else {
		int count=0;
		for(int i=j;i<a1.size();i++) {
			String t=a1.get(i);
			String tt=t.substring(0,word.length());
			if(word.equalsIgnoreCase(tt))
			{
				count++;

				
			}
			else
				break;
		}
		System.out.println("fount"+count+"items.\n");
		count=0;
		for(int i=j;i<a1.size();i++) {
			String t=a1.get(i);
			String tt=t.substring(0,word.length());
			if(word.equalsIgnoreCase(tt))
			{
				
				System.out.println(t);
				System.out.print("\n");
			}
			else
				break;
		}
	}
	
	}
	br.close();
//	bw.close();
}
private static void exit(int i) {
	// TODO Auto-generated method stub
	
}
}

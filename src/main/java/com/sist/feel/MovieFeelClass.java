package com.sist.feel;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern; //pattern ���Խ��� ����
public class MovieFeelClass {
	/*public static void main(String[] args) {
		MovieFeelClass mf=new MovieFeelClass();
		mf.MovieFeelData();
	}*/

	public void MovieFeelData(String type){
		//���ִ�, ���ְ�, ���ְ�.. ����[��-�R]+ (���Խ�)
		String[] feel =
			{
				"���","�θǽ�","�ŷ�","��ſ�","����",
				"�Ҹ�","����","����","����","����","����",
				"�ູ","����","����","���","����","�ź�",
				"����","���","���","����","����","�޸Ӵ���",
				"�ڱ�","���","�׼�","����","���","�̽��׸�",
				"��Ÿ��","��","������","���","ǳ��","�ϻ�",
				"����","����","����","�׸���","ȣ��","���","��Ȥ",
				"���","���","����",
				"����","���͸�","��ť���͸�",
				"�ڹ̵�","����","SF","�ִϸ��̼�"	
		};
		Pattern[] p=new Pattern[feel.length];
		for(int i=0; i<p.length; i++){
			p[i]=Pattern.compile(feel[i]);
		}
		int[] count=new int[feel.length];
 		try{
			FileReader fr=new FileReader("c:\\review_data\\"+type+".txt");
			int i=0;
			String data="";
			while((i=fr.read())!=-1){
				data+=String.valueOf((char)i);
			}
			fr.close();
			String[] feelArray=data.split("\n");
			Matcher[] m=new Matcher[feel.length];
			for(String s:feelArray){
				for(int j=0; j<m.length; j++){
					m[i]=p[i].matcher(s);
					if(m[i].find()){
						count[i]++;
					}
				}
			}
			String feel_data="";
			for(i=0; i<feel.length; i++){
				if(count[i]>0){
						feel_data+=feel[i]+"   "+count[i]+"\n";
				}
			}
			
			FileWriter fw=new FileWriter("c:\\review_data\\"+type+"_feel.txt");
			fw.write(feel_data);
			fw.close();
 		}catch(Exception ex){
			
		}
	}
}

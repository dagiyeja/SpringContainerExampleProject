package com.sist.feel;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern; //pattern Á¤±Ô½ÄÀ» ¸¸µê
public class MovieFeelClass {
	/*public static void main(String[] args) {
		MovieFeelClass mf=new MovieFeelClass();
		mf.MovieFeelData();
	}*/

	public void MovieFeelData(String type){
		//¸ÀÀÖ´Â, ¸ÀÀÖ°Ô, ¸ÀÀÖ°í.. ¸ÀÀÖ[°¡-ÆR]+ (Á¤±Ô½Ä)
		String[] feel =
			{
				"»ç¶û","·Î¸Ç½º","¸Å·Â","Áñ°Å¿ò","½º¸±",
				"¼Ò¸§","±äÀå","°øÆ÷","À¯¸Ó","¿ôÀ½","°³±×",
				"Çàº¹","ÀüÀ²","°æÀÌ","¿ì¿ï","Àı¸Á","½Åºñ",
				"¿©¿î","Èñ¸Á","±ä¹Ú","°¨µ¿","°¨¼º","ÈŞ¸Ó´ÏÁò",
				"ÀÚ±Ø","Àç¹Ì","¾×¼Ç","¹İÀü","ºñ±Ø","¹Ì½ºÅ×¸®",
				"ÆÇÅ¸Áö","²Ş","¼³·¹ÀÓ","Èï¹Ì","Ç³°æ","ÀÏ»ó",
				"¼ø¼ö","Èú¸µ","´«¹°","±×¸®¿ò","È£·¯","Ãæ°İ","ÀÜÈ¤",
				"µå¶ó¸¶","¸á·Î","¾ÖÁ¤",
				"¸ğÇè","´À¿Í¸£","´ÙÅ¥¸àÅÍ¸®",
				"ÄÚ¹Ìµğ","¹üÁË","SF","¾Ö´Ï¸ŞÀÌ¼Ç"	
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

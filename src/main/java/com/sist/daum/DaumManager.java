package com.sist.daum;
/*
 * 	��ȭ ==> ��α� �˻�(XML, JSON)
 * 	==================== JAXP(DOM,SAX)
 * 													 JAXB(O)
 * 													=>(XML=>class)�𸶼�
 * 													=>(class=>XML) ����
 * 	<channel>  ->�±�
 * 		<item>	  ->�±�
 * 			<description>��ȭ���</description>    ->������ ����
 * 		</item>
 * 		<item>
 * 			<description>��ȭ���</description>
 * 		</item>
 * 	</channel>
 * 
 * 	==>
 * 
 * 	String[] feel = {"���","�θǽ�","�ŷ�","��ſ�","����",
				"�Ҹ�","����","����","����","����","����",
				"�ູ","����","����","���","����","�ź�",
				"����","���","���","����","����","�޸Ӵ���",
				"�ڱ�","���","�׼�","����","���","�̽��׸�",
				"��Ÿ��","��","������","���","ǳ��","�ϻ�",
				"����","����","����","�׸���","ȣ��","���","��Ȥ"};
		String[] genre = {
				"���","��Ÿ��","����","���","����",
				"�θǽ�","����","������","���͸�","��ť���͸�",
				"�ڹ̵�","�̽��͸�","����","SF","�׼�","�ִϸ��̼�"	
		};
 * 
 * */
import java.io.*;
import java.net.*;
import java.util.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
public class DaumManager {
	private String key;
	
	
	public void setKey(String key) {
		this.key = key;
	}


	public void daumReviewSave(String title) {
		
		String total="";
		
		for(int i=1; i<=3; i++){
			String review=daumReviewData(i, title);
			total+=review; //total�� 60���� �������
		}
		try{
			FileWriter fw=new FileWriter("c:\\review_data\\daum.txt");
			fw.write(total);
			fw.close();
		}catch(Exception ex){
			
		}
	}
	
	
	public String daumReviewData(int page, String title){
		String review="";
		
		try{
				
				URL url=new URL("https://apis.daum.net/search/blog?apikey="+key+"&result=20&output=xml&pageno="+page+"&q="
				+URLEncoder.encode(title, "utf-8"));
				JAXBContext jc=JAXBContext.newInstance(Channel.class);
				// xml -> class(���� �� Ŭ�������� �ϴ�) Unmarshaller, class-> xml
				Unmarshaller un=jc.createUnmarshaller();
				Channel channel=(Channel)un.unmarshal(url);
				List<Item> temp=channel.getItem();
				
				for(Item i:temp){
					review+=i.getDescription()+"\n"; //���������� 20���� �޾ƿ�
				}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return review;
	}
	
}

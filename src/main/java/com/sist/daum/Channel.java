package com.sist.daum;
//item => 20 => List
import java.util.*;

import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.txw2.annotation.XmlElement;
/*������ �������
 * 
 * ���� ==> �迭 ==> Ŭ���� ==> ���� ==>����Ŭ  ==>XML, JSON 
 * 															===
 * ������(JSON)
 * 
 * XML => <a>aaaa</a>  <a href="aaa">
 *   
 *    @XmlElement(name="media:thumnail")
 *    String media_thumnail 
 *    
 *    
 *    */


@XmlRootElement //�±� ������ �� �������� XmlRootAttribute->�Ӽ��� ��������

 //���� ���⼭���� ä���ֱ�(�����±�)
public class Channel {
	private List<Item> item=new ArrayList<Item>(); //���� �±װ� ������ ���� ��� ����Ʈ�� ����

	public List<Item> getItem() {
		return item;
	}

	@XmlElement
	public void setItem(List<Item> item) {
		this.item = item;
	}
	
	
}

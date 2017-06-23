package com.sist.daum;
//item => 20 => List
import java.util.*;

import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.txw2.annotation.XmlElement;
/*데이터 저장장소
 * 
 * 변수 ==> 배열 ==> 클래스 ==> 파일 ==>오라클  ==>XML, JSON 
 * 															===
 * 몽고디비(JSON)
 * 
 * XML => <a>aaaa</a>  <a href="aaa">
 *   
 *    @XmlElement(name="media:thumnail")
 *    String media_thumnail 
 *    
 *    
 *    */


@XmlRootElement //태그 사이의 값 가져오기 XmlRootAttribute->속성값 가져오기

 //값을 여기서부터 채워주기(시작태그)
public class Channel {
	private List<Item> item=new ArrayList<Item>(); //같은 태그가 여러개 있을 경우 리스트로 받음

	public List<Item> getItem() {
		return item;
	}

	@XmlElement
	public void setItem(List<Item> item) {
		this.item = item;
	}
	
	
}

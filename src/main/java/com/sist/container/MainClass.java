package com.sist.container;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.daum.DaumManager;
import com.sist.feel.MovieFeelClass;
import com.sist.r.RManager;

public class MainClass {
		private DaumManager dm; 
		private MovieFeelClass mfc;
		private RManager rm;

		
		public void setRm(RManager rm) {
			this.rm = rm;
		}

		public void setMfc(MovieFeelClass mfc) {
			this.mfc = mfc;
		}

		public void setDm(DaumManager dm) {
			this.dm = dm;
		}
		
	public static void main(String[] args) {
		//XML 파싱
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml"); //등록한 클래스를 app가 갖고온다
		MainClass mc=(MainClass)app.getBean("mc");
		Scanner scan=new Scanner(System.in);
		System.out.println("MovieName:");
		String title=scan.next();
		mc.dm.daumReviewSave(title);
		System.out.println("Save End..");
		mc.mfc.MovieFeelData("daum");
		System.out.println("Feel Save End...");
		mc.rm.rGraph();
		System.out.println("Image Save..");
	}

}

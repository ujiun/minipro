package com.javaex.phonebook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		List<Person> personList = new ArrayList<Person>(); 
		
		//읽기 스트림
		Reader fr = new FileReader("./PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);
		
		
		while (true) {
				String str = br.readLine();
				
				if(str==null) {
					break;
				}
				
				String[] personInfo =  str.split(",");
				
				String name = personInfo[0];
				String hp = personInfo[1];
				String company = personInfo[2];
	
				Person pb = new Person(name, hp, company);
				
				personList.add(pb);
			}
		
		
		System.out.println("*******************************");
		System.out.println("*      전화번호 관리 프로그램      *");
		System.out.println("*******************************" + "\n");
		
		
		
		while(true) {
			
			System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
			System.out.println("--------------------------------");
			System.out.print(">메뉴번호:");
			int num = sc.nextInt();	
			
			if(num==5) {	
				
				System.out.println("*******************************");
				System.out.println("*                감사합니다      *");
				System.out.println("*******************************");
				
				break;
				
			}//무한루프 탈출조건
			
			switch(num) {
				
				case 1:
					
					System.out.println("<1.리스트>");
					for(int i=0; i<personList.size(); i++) {
						System.out.println(i+1 + " " + personList.get(i).getName() + "\t" + personList.get(i).getHp() + "\t" + personList.get(i).getCompany());
						System.out.println("");
					}
					
					break;
					
				case 2:
					
					System.out.println("<2.등록>");
					System.out.print(">이름: ");
					String name = sc.next();
					
					System.out.print(">휴대전화: ");
					String hp = sc.next();
					
					System.out.print(">회사전화: ");
					String company = sc.next();
					//데이터 추가
					Person pb = new Person(name, hp, company);
					personList.add(pb);
					
					//쓰기스트림
					Writer fw = new FileWriter("./PhoneDB.txt");
					BufferedWriter bw = new BufferedWriter(fw);
					
					for (Person p: personList) {
						String saveStr = p.getName() + "," + p.getHp() + "," + p.getCompany();
						bw.write(saveStr);
						bw.newLine();
					}
					
					bw.close();
					System.out.println("[등록되었습니다.]");
					
					break;
					
				case 3:
					
					System.out.println("</삭제>");
					System.out.print(">번호 : ");
					personList.remove(sc.nextInt()-1);	//배열 0부터 시작인데 리스트번호는 1부터 시작이라서 -1해줘야함
					System.out.println("[삭제되었습니다.]");
					break;
					
				case 4://검색 
					
					System.out.println("<4.검색>");
					System.out.print(">이름: ");
					
					
					break;
					
				default:
					
					System.out.println("[다시 입력해 주세요.]");
					
					break;
					
			}//switch
			
			
			
		}//while	
	
		
		
		br.close();
		sc.close();
	}
}

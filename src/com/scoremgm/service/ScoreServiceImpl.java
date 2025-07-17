package com.scoremgm.service;

import java.util.ArrayList;
import com.scoremgm.app.ScoreMgmSystem;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.scoremgm.model.Member;
import com.scoremgm.repository.ScoreRepository;
import com.scoremgm.repository.ScoreRepositoryImpl;

public class ScoreServiceImpl implements ScoreService{
	Scanner scan;
	ScoreMgmSystem sms;
	ScoreRepository repository = new ScoreRepositoryImpl();
	
	public ScoreServiceImpl() {}
	public ScoreServiceImpl(ScoreMgmSystem sms) {
		this.sms = sms;
		this.scan = scan;
	}
	
	/**
	 * 학번 정보 임시 저장 객체 생성
	 * @return List
	 */
	public List createMemberInfo() {
		String[] labels = {"학생명","전공","국어","영어","수학"};
		List memberInfo = new ArrayList();
		Random rd = new Random();			        
		String no = "2025-" + rd.nextInt(1000,9999);	//학번 생성
		memberInfo.add(no);	
		for(int i =0; i<labels.length;i++) {
			if(i>=2) {
				System.out.print(labels[i] + "> ");
				memberInfo.add(scan.nextInt());
			} else {
				System.out.print(labels[i] + "> ");
				memberInfo.add(scan.next());
			}
		}		
		 return memberInfo;
		
	}
	
	/**
	 * 학생정보 저장소(storage)의 갯수 가져오기
	 * 
	 */
	@Override
	public int getCount( ) {
		return repository.getCount();
	}
	
	/**
	 * 등록
	 */
	public void register() {
		List memberInfo = createMemberInfo();

		Member member = new Member();
		member.setNo((String)memberInfo.get(0));
		member.setName((String)memberInfo.get(1));
		member.setDepartment((String)memberInfo.get(2));
		member.setKor((int)memberInfo.get(3));
		member.setEng((int)memberInfo.get(4));
		member.setMath((int)memberInfo.get(5));
		
		//저장소 등록을 위한 Repository 호출
		if(repository.insert(member)) {
			//성공
			System.out.println("=> 등록 완료!! 전체학생 : " + getCount());
		} else {
			System.out.println("=> 등록 실패!!");
		}
		
		//메뉴호출!!
		sms.showMenu();
		sms.selectMenu();
	}		
		
	
	public void list() {
		
	}
	public void search() {
		
	}
	public void update() {
		
	}
	public void delete() {
		
	}
	public void exit() {
		
	}
	
	
}

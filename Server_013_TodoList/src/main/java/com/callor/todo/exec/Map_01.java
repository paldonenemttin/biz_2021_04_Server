package com.callor.todo.exec;

import java.util.HashMap;
import java.util.Map;

public class Map_01 {
	
	/*
	 * Map<k,v>
	 * List데이터와 함께
	 * java에서 매우 많이 사용되는 자료구조
	 * 
	 * Key, Value 형식으로 데이터를 저장하고
	 * 읽을 수 있는 자료 구조
	 * 
	 * List Type
	 * map.put(key, 값) : Map에 데이터 저장
	 * map.get(key) : Map에서 값 읽을때
	 */
	public static void main(String[] args) {
		
		// Map interface로 선언하고
		// MapHash로 생성하기
		Map<String, String> maps = new HashMap<String, String>();
		
		maps.put("이름", "사쿠마 리츠");
		maps.put("나이", "18");
		maps.put("직업", "아이돌");
		
		System.out.println(maps.get("이름"));
		System.out.println(maps.get("나이"));
		System.out.println(maps.get("직업"));
		
	}

}

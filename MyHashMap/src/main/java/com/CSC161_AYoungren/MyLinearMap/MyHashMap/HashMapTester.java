package com.CSC161_AYoungren.MyLinearMap.MyHashMap;

public class HashMapTester {

	public static void main(String[] args) {
		
		MyHashMapSA<String, String> cities = new MyHashMapSA<String, String>(); 
		
	
		cities.put("United States", "Washington DC");
		System.out.println(cities.get("United States"));
		cities.put("Canada", "Toronto");
		System.out.println(cities.get("Canada"));
		cities.put("United Kindom", "London");
		System.out.println(cities.get("United Kindom"));
		cities.put("Ireland", "Dublin");
		System.out.println(cities.get("Ireland"));
		cities.put("France", "Paris");
		System.out.println(cities.get("France"));
		cities.put("Sweden", "Stockholm");
		System.out.println(cities.get("Sweden"));
		
		System.out.println(cities.entrySet());
	}

}

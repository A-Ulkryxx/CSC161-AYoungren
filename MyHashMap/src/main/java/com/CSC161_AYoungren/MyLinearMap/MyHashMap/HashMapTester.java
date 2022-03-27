package com.CSC161_AYoungren.MyLinearMap.MyHashMap;

public class HashMapTester {

	public static void main(String[] args) {
		
		MyHashMapSA<String, String> cities = new MyHashMapSA<String, String>(); 
		
		cities.put("United States", "Denver");
		cities.put("United States", "Washington DC");
		cities.put("Canada", "Toronto");
		cities.put("United Kindom", "London");
		cities.put("Ireland", "Dublin");
		cities.put("France", "Paris");
		cities.put("Sweden", "Stockholm");
		
		System.out.println(cities.entrySet());

	}

}

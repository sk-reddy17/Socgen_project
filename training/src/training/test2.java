//package training;
//
//
//import java.util.*;
//import java.util.Map.Entry;
//import java.util.stream.Collectors;
//
//public class test2 {
//	public static void main(String[] args)
//	{
////		User U1 = new User("u1","aai",100000);
////		User U2 = new User("u2","bhashi",98765);
////		User U3 = new User("u3","aeddy",12345);
//		
//		HashMap <String,User> map = new HashMap<>();
//		
//		
//		map.put("user1",U1);
//		map.put("user2",U2);
//		map.put("user3",U3);
//		
//		System.out.println("-----------Sorting By Name-----------");
//		Map<String, User> sortedMap = map.entrySet()
//                .stream()
//                .sorted(Entry.comparingByValue(
//                        Comparator.comparing(User::getName)))
//                .collect(Collectors.toMap(Entry::getKey, Entry::getValue,
//                        (e1, e2) -> e1, LinkedHashMap::new));
//
//
//		List listValues
//        = new ArrayList<>(map.values());
//		listValues.stream().forEach(l->System.out.println(l));		
//		sortedMap.entrySet().forEach(entry -> {
//		    System.out.println(entry.getValue().getId() + " " +  entry.getValue().getName() + " "  + entry.getValue().getSalary());
//		}
//		);
//		
//		System.out.println("--------------Sorting By Salary--------------");
//		Map<String, User> sortedMap1 = map.entrySet()
//                .stream()
//                .sorted(Entry.comparingByValue(
//                        Comparator.comparing(User::getSalary)))
//                .collect(Collectors.toMap(Entry::getKey, Entry::getValue,
//                        (e1, e2) -> e1, LinkedHashMap::new));
//		
//		sortedMap1.entrySet().forEach(entry -> {
//		    System.out.println(entry.getKey() + " " + entry.getValue());
//		}
//		);
//		
//		
//		 
//	}
//
//
//}

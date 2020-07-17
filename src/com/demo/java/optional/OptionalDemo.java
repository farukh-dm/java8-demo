package com.demo.java.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {
	
	static List<User> userList;
	
	public static void main(String[] args) {
		
		userList = Arrays.asList(
				   new User("A", "Address1"),
				   new User("B", "Address2")
				   );
		
		Optional<User> user0 = getUser(0);
		if(user0.isPresent()) {
			System.out.println("user0 = " + user0.get());
		}
		
		Optional<User> user1 = getUser(1);
		user1.ifPresent((u1) -> System.out.println("u1 = "+ u1));
		
		Optional<User> user2 = getUser(2);
		user2.ifPresent((u2) -> System.out.println("u2 = "+ u2));
		user2.ifPresentOrElse(
				(u2) -> System.out.println("u2 = "+ u2),
				() -> System.out.println("u2 is not present ")
				);
	
	}
	
	public static Optional<User> getUser(Integer index) {

		User user = null;
		
		try {
			
			user = userList.get(index);
			
			if(user == null)
				return Optional.empty();
			else 
				return Optional.of(user);
			
		} catch (ArrayIndexOutOfBoundsException ex) {
			
			return Optional.empty();
		
		}
		
	}

}

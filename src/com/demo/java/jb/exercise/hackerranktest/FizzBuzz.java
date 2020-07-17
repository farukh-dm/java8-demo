package com.demo.java.jb.exercise.hackerranktest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FizzBuzz {
	
	 public static void main(String[] args) throws IOException {
		 
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //int n = Integer.parseInt(bufferedReader.readLine().trim());

        fizzBuzz(65);

        //bufferedReader.close();
    }


    public static void fizzBuzz(int n) {
      // Write your code here

      Consumer<String> printStringConsumer = (str) -> {
          System.out.println(str);
      };
      
      Predicate<Integer> predicateMultipleof3And5 = (i) -> i%3==0 && i%5==0;
      Predicate<Integer> predicateMultipleof3ButNot5 = (i) -> i%3==0 && i%5!=0;
      Predicate<Integer> predicateMultipleof5ButNot3 = (i) -> i%3!=0 && i%5==0;
      
      BiPredicate<Integer, Integer> test = (i, j) -> i%3==0 && j%5==0;
      
      BiFunction<Integer, Integer, String> test2 = (i, j) -> "teset";
      
      for(int i = 1; i<=n; i++) {

          if(predicateMultipleof3And5.test(i)) {

              // Check for multiple of 3 and 5    
              printStringConsumer.accept("FizzBuzz");              

          } else if(predicateMultipleof3ButNot5.test(i)) {

              // Check for multiple of 3 but not 5
              printStringConsumer.accept("Fizz");              
          
          } else if(predicateMultipleof5ButNot3.test(i)) {

              // Check for multiple of 3 but not 5
              printStringConsumer.accept("Buzz");              
          
          } else {
            printStringConsumer.accept(i+"");  
          }
      

      } //for

    }
    
    

}

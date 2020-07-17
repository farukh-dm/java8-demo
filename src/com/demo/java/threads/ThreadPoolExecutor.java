package com.demo.java.threads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiFunction;

public class ThreadPoolExecutor {
	
	public static Map<Character, Integer> mapDiffcultyToPoints = 
	        new HashMap<Character, Integer>(3) {{
	            put('E', 1);
	            put('M', 3);
	            put('H', 5);
	        }};
	
    public static Integer getScore(String message) {

        Integer score = 0;
        Integer currentVal = null;

        if(message.length() > 0) {

            for(int i=0; i < message.length()-1; i++) {
                currentVal = mapDiffcultyToPoints.get(message.charAt(i));
                //if(currentVal != null) {
                    score = score + currentVal;
                //}
            }

        }
        
        System.out.println("score = " + score);

        return score;
    }
    
    public static BiFunction<Integer, Integer, String> checkResult() {
        BiFunction<Integer, Integer, String> checkResultFunction = (score1, score2) ->  {
            
            String result = null;

            if(score1 > score2) {
                result = "Erica";
            } else if(score2 > score1) {
                result = "Bob";
            } else if(score1 == score2) {
                result = "Tie";
            }
            
            return result;
        };
        
        return  checkResultFunction;
    } 
	
	public static void main(String args[]) throws InterruptedException {
		
		System.out.println("Main started >>>>>>>>");
		
		System.out.println(mapDiffcultyToPoints.get('E'));
		System.out.println(mapDiffcultyToPoints.get('A'));
		
		/*
		 * System.out.println("Score : " + getScore("EEMH"));
		 * 
		 * BiFunction<Integer, Integer, String> test2 = (i, j) -> { return "test"; };
		 */
		
		System.out.println(checkResult().apply(getScore("EMEMHH"), getScore("MMMMMM")));
		
		
		///
		
		float f1 = 1.1f;
		float f2 = 3.05f;
		float f = f1+f2;
		int i = (int)f;
		int d = (int)(f - (float)i);
		
		double du = Math.floor((double)f);
		int dui = (int) du;
		
		System.out.println(i);
		System.out.println(d);
		
		System.out.println(f);
		System.out.println(du);
		System.out.println(dui);
		
		
		
		
		
		MyTask  task1 = new MyTask("Task-1"),
				task2 = new MyTask("Task-2"),
				task3 = new MyTask("Task-3"),
				task4 = new MyTask("Task-4");
		
		ExecutorService executor = Executors.newFixedThreadPool(1);
		//ExecutorService executor2 = Executors.newFixedThreadPool(2);
		//ExecutorService executor3 = Executors.newCachedThreadPool();
		
		executor.submit(task1);
		executor.submit(task2);
		executor.submit(task3);
		executor.submit(task4);
		
		executor.shutdown();
		
		System.out.println("Main completed >>>>>>>");

	}

}

class MyTask implements Runnable {
	
	private String taskName;
	private long createdAt = System.currentTimeMillis();
	
	MyTask(String taskName) {
		super();
		this.taskName = taskName; 
	}
	
	@Override
	public void run() {
		
		System.out.println("Executing task: "+ taskName +" by  thread : " + Thread.currentThread().getName());
		System.out.println("Started after: " + (System.currentTimeMillis() - createdAt )/1000 + " seconds.");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Completed task: " + taskName);
	}
		
}

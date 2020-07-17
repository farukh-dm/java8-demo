package com.demo.java.jb.exercise.hackerranktest;

public class test {
	
		public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class Point2D {
	
	Integer x, y;
	
	Point2D(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}
	
}

class Point3D extends Point2D {
	 
    Integer z;
    
    Point3D(Integer x, Integer y, Integer z) {
        super(x, y);
        this.z = z;
    }

}
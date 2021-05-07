package edu.smg;

public class Circle {
	int radius;

	public Circle() {
	}

	public Circle(int radius) {
		this.radius = radius;
	}
	
	public String toString() {
		return "Radius: " + radius;
	}
}

//public class Circle implements Comparable<Circle> {
//	int radius;
//
//	public Circle() {
//	}
//
//	public Circle(int radius) {
//		this.radius = radius;
//	}
//
//	public int compareTo(Circle o) {
//		return this.radius - o.radius;
//	}
//	
//	public String toString() {
//		return "Radius: " + radius;
//	}
//}
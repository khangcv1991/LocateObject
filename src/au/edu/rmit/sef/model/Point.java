package au.edu.rmit.sef.model;

import java.util.Arrays;

public class Point {
	private int x;
	private int y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		  return Arrays.hashCode(new Object[] {
		           this.x,    //auto-boxed
		           this.y, //auto-boxed
		           
		    });
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Point tmp = (Point) obj;
		if (this.getX() == tmp.getX() && this.getY() == tmp.getY())
			return true;
		else
			return false;
		//return super.equals(obj);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[" + x + "," + y + "]";
	}

}

package au.edu.rmit.sef.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import au.edu.rmit.sef.ulti.SEFConstant;

public class Shape implements Serializable{
	
	private List<Point> list = new ArrayList<Point>();
	private String name;
	private char shapeType = SEFConstant.ShapeType.L_TYPE;
	
	public Shape() {
		super();
	}

	public Shape(char shapeType) {
		super();
		this.shapeType = shapeType;
	}

	public List<Point> getList() {
		return list;
	}

	public void setList(List<Point> list) {
		this.list = list;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getShapeType() {
		return shapeType;
	}

	public void setShapeType(char shapeType) {
		this.shapeType = shapeType;
	}
	
	

}

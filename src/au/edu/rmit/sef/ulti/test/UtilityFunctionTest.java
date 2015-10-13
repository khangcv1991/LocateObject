package au.edu.rmit.sef.ulti.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.corba.se.impl.javax.rmi.CORBA.Util;

import au.edu.rmit.sef.model.Player;
import au.edu.rmit.sef.model.Point;
import au.edu.rmit.sef.ulti.SEFConstant;
import au.edu.rmit.sef.ulti.UtilityFunction;

public class UtilityFunctionTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		
	}
	/**
	 * This  test case test for return shape point collection
	 * if any point in the collection is out side 3x3 grid
	 */
	@Test
	public void testGetShapePointCollection() {
		// fail("Not yet implemented");
		int maxX = 0;
		int maxY = 0;
		List points = UtilityFunction.getShapePointCollection();
		for (Object object : points) {
			Point tmp = (Point) object;
			if (maxX < Math.abs((tmp.getX() - ((Point) points.get(0)).getX())))
				maxX = Math.abs((tmp.getX() - ((Point) points.get(0)).getX()));
			if (maxY < Math.abs((tmp.getY() - ((Point) points.get(0)).getY())))
				maxY = Math.abs((tmp.getY() - ((Point) points.get(0)).getY()));
		}
		if (maxX > 2)
			fail("the generated shape is out of 3x3 grid");
		if (maxY > 2)
			fail("the generated shape is out of 3x3 grid");

		points = UtilityFunction.getShapePointCollection();
		for (Object object : points) {
			Point tmp = (Point) object;
			if (maxX < Math.abs((tmp.getX() - ((Point) points.get(0)).getX())))
				maxX = Math.abs((tmp.getX() - ((Point) points.get(0)).getX()));
			if (maxY < Math.abs((tmp.getY() - ((Point) points.get(0)).getY())))
				maxY = Math.abs((tmp.getY() - ((Point) points.get(0)).getY()));
		}
		if (maxX > 2)
			fail("the generated shape is out of 3x3 grid");
		if (maxY > 2)
			fail("the generated shape is out of 3x3 grid");
	}
	/**
	 * This test case test for rotating a point by 90, 180, 270 degrees
	 */
	@Test
	public void testGetRotatedPoint() {
		// fail("Not yet implemented");
		Point point = new Point(0, 0);
		// rotate 90 degrees
		Point roPoint = UtilityFunction.getRotatedPoint(point, 1);
		if (!roPoint.equals(new Point(2, 0)))
			fail("rotate 90 returns wrong point value");
		roPoint = UtilityFunction.getRotatedPoint(point, 2);
		if (!roPoint.equals(new Point(2, 2)))
			fail("rotate 180 returns wrong point value");
		roPoint = UtilityFunction.getRotatedPoint(point, 3);
		if (!roPoint.equals(new Point(0, 2)))
			fail("rotate 270 returns wrong point value");

		// second test
		point = new Point(0, 1);
		// rotate 90 degrees
		roPoint = UtilityFunction.getRotatedPoint(point, 1);
		if (!roPoint.equals(new Point(1, 0)))
			fail("rotate 90 returns wrong point value");
		roPoint = UtilityFunction.getRotatedPoint(point, 2);
		if (!roPoint.equals(new Point(2, 1)))
			fail("rotate 180 returns wrong point value");
		roPoint = UtilityFunction.getRotatedPoint(point, 3);
		if (!roPoint.equals(new Point(1, 2)))
			fail("rotate 270 returns wrong point value");
	}
	/**
	 * this test case test for getRanNum function if it return 
	 * value in the given range
	 */
	@Test
	public void testGetRanNum() {
		//fail("Not yet implemented");
		for(int i = 0; i < 100000; i++){
			int ran = UtilityFunction.getRanNum(0, 2);
			if(ran > 2 || ran <0){
				fail("random number is out of range");
			}
		}
		for(int i = 0; i < 100000; i++){
			int ran = UtilityFunction.getRanNum(0, SEFConstant.NUM_COL);
			if(ran > SEFConstant.NUM_COL || ran <0){
				fail("random number is out of range");
			}
		}
		
		for(int i = 0; i < 100000; i++){
			int ran = UtilityFunction.getRanNum(0, SEFConstant.NUM_ROW);
			if(ran > SEFConstant.NUM_ROW || ran <0){
				fail("random number is out of range");
			}
		}
	}

	/**
	 * This test case tests the result return by GetDistanceBetweenTwoPoints function
	 * Distance = |point1.X - point2.X| + |point1.Y - point2.Y|
	 */
	@Test
	public void testGetDistanceBetweenTwoPoints() {
		//fail("Not yet implemented");
		Point point1 = new Point(1,5);
		Point point2 = new Point(3,8);
		if(UtilityFunction.getDistanceBetweenTwoPoints(point1, point2) != 5){
			fail("the distance value is not correct");
		}
		
	}

	@Test
	public void testHasTheSameLocation() {
		//fail("Not yet implemented");
		Point point1 = new Point(1,5);
		Point point2 = new Point(3,8);
		if(point1.equals(point2)){
			fail("2 points are not the same location");
		}
		if(!point1.equals(new Point(point1.getX(), point1.getY()))){
			fail("2 points are not the same location");
		}
	}
	@Test
	public void addPlayerTest() throws FileNotFoundException {
		UtilityFunction.createFile(SEFConstant.FileLink.LIST_PLAYER);
		
		List<Player> players = UtilityFunction.getPlayerList();
		Player p  = new Player();
		int size1, size2;
		
		if (players == null)
			size1 = 0;
		else
			size1 = players.size();
		p.setName("a1");
		UtilityFunction.addPlayerToList(p);
		p = new Player();
		p.setName("a2");
		UtilityFunction.addPlayerToList(p);
		p = new Player();
		p.setName("a3");
		UtilityFunction.addPlayerToList(p);
		
		players = UtilityFunction.getPlayerList();
		size2 = players.size();
		
		if(size2 - size1 != 3)
			fail("add un success");
	}
	

}

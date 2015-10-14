package au.edu.rmit.sef.ulti;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import au.edu.rmit.sef.model.Player;
import au.edu.rmit.sef.model.Point;
import au.edu.rmit.sef.model.Shape;
import au.edu.rmit.sef.view.Board;
import au.edu.rmit.sef.view.CellLabel;
import au.edu.rmit.sef.view.MFrame;

public class UtilityFunction {

	private static List<Point> orginalPoints = new ArrayList<Point>();
	private static HashMap<Point, Point> oneTime90 = new HashMap<Point, Point>();
	private static HashMap<Point, Point> twoTimes90 = new HashMap<Point, Point>();
	private static HashMap<Point, Point> threeTimes90 = new HashMap<Point, Point>();

	private static List<Shape> shapeCollection = new ArrayList<Shape>();
	public static List<Player> playerfileList = new ArrayList<Player>();

	private static void initateData() {
		orginalPoints.add(new Point(0, 0));
		orginalPoints.add(new Point(0, 1));
		orginalPoints.add(new Point(0, 2));

		orginalPoints.add(new Point(1, 0));
		orginalPoints.add(new Point(1, 1));
		orginalPoints.add(new Point(1, 2));

		orginalPoints.add(new Point(2, 0));
		orginalPoints.add(new Point(2, 1));
		orginalPoints.add(new Point(2, 2));

		// rotate 90
		oneTime90.put(orginalPoints.get(0), new Point(2, 0));
		oneTime90.put(orginalPoints.get(1), new Point(1, 0));
		oneTime90.put(orginalPoints.get(2), new Point(0, 0));

		oneTime90.put(orginalPoints.get(3), new Point(2, 1));
		oneTime90.put(orginalPoints.get(4), new Point(1, 1));
		oneTime90.put(orginalPoints.get(5), new Point(0, 1));

		oneTime90.put(orginalPoints.get(6), new Point(2, 2));
		oneTime90.put(orginalPoints.get(7), new Point(1, 2));
		oneTime90.put(orginalPoints.get(8), new Point(0, 2));

		// rotate 180
		twoTimes90.put(orginalPoints.get(0), new Point(2, 2));
		twoTimes90.put(orginalPoints.get(1), new Point(2, 1));
		twoTimes90.put(orginalPoints.get(2), new Point(2, 0));

		twoTimes90.put(orginalPoints.get(3), new Point(1, 2));
		twoTimes90.put(orginalPoints.get(4), new Point(1, 1));
		twoTimes90.put(orginalPoints.get(5), new Point(1, 0));

		twoTimes90.put(orginalPoints.get(6), new Point(0, 2));
		twoTimes90.put(orginalPoints.get(7), new Point(0, 1));
		twoTimes90.put(orginalPoints.get(8), new Point(0, 0));

		// rotate 270
		threeTimes90.put(orginalPoints.get(0), new Point(0, 2));
		threeTimes90.put(orginalPoints.get(1), new Point(1, 2));
		threeTimes90.put(orginalPoints.get(2), new Point(2, 2));

		threeTimes90.put(orginalPoints.get(3), new Point(0, 1));
		threeTimes90.put(orginalPoints.get(4), new Point(1, 1));
		threeTimes90.put(orginalPoints.get(5), new Point(2, 1));

		threeTimes90.put(orginalPoints.get(6), new Point(0, 0));
		threeTimes90.put(orginalPoints.get(7), new Point(1, 0));
		threeTimes90.put(orginalPoints.get(8), new Point(2, 0));

		// add L shape
		Shape lShape = new Shape();
		lShape.setName("L Type");
		lShape.getList().add(new Point(0, 0));
		lShape.getList().add(new Point(1, 0));
		lShape.getList().add(new Point(2, 0));
		lShape.getList().add(new Point(2, 1));
		lShape.getList().add(new Point(2, 2));
		shapeCollection.add(lShape);

		// add U shape
		Shape uShape = new Shape();
		uShape.setName("U Type");
		uShape.getList().add(new Point(0, 0));
		uShape.getList().add(new Point(1, 0));
		uShape.getList().add(new Point(2, 0));
		uShape.getList().add(new Point(2, 1));
		uShape.getList().add(new Point(2, 2));
		uShape.getList().add(new Point(1, 2));
		uShape.getList().add(new Point(0, 2));
		shapeCollection.add(uShape);
	}

	public static Point getRotatedPoint(Point sourcPoint, int rotatedTimes) {
		if (orginalPoints.size() == 0)
			initateData();
		switch (rotatedTimes) {
		case 1:
			return oneTime90.get(sourcPoint);

		case 2:

			return twoTimes90.get(sourcPoint);
		case 3:

			return threeTimes90.get(sourcPoint);

		}
		return null;
	}

	private static Point getRandomRootPointOfShap() {

		return new Point(getRanNum(1, SEFConstant.NUM_ROW - 2), getRanNum(1,
				SEFConstant.NUM_COL - 2));
	}

	// 20151013 khangcv change
	// public static List getShapePointCollection(String nameShape) {
	public static List getShapePointCollection() {
		if (orginalPoints.size() == 0)
			initateData();
		List tmpList = new ArrayList<Point>();
		Shape tmpShape = null;
		Point newRoot = getRandomRootPointOfShap();
		int ranAngle = 0;
		int i = getRanNum(0, shapeCollection.size() - 1);
		// for (Shape s : shapeCollection) {
		// if (s.getName().equals(nameShape)) {
		// tmpShape = s;
		// break;
		// }
		// }
		tmpShape = shapeCollection.get(i);
		if (tmpShape == null)
			return null;
		// get random rotated angle
		ranAngle = getRanNum(1, 3);
		for (Point p : tmpShape.getList()) {
			tmpList.add(getNewPointFromRootPoint(getRotatedPoint(p, ranAngle),
					newRoot));
		}

		return tmpList;
	}

	public static List<Shape> getShapeCollection() {
		if (orginalPoints.size() == 0)
			initateData();
		return shapeCollection;
	}

	/**
	 * return a point when corresponding to new root
	 * 
	 * @param oldPoint
	 *            in orginalPoints list
	 * @param root
	 *            is new point generated from getRandomRootPointOfShap function
	 * @return
	 */
	public static Point getNewPointFromRootPoint(Point oldPoint, Point root) {
		// old root has (1,1)
		int x = root.getX() - 1;
		int y = root.getY() - 1;
		return new Point(oldPoint.getX() + x, oldPoint.getY() + y);
	}

	/**
	 * 
	 * @param from
	 * @param to
	 * @return an Integer number belong to [from, to)
	 */
	public static int getRanNum(int from, int to) {
		Random rand = new Random();
		int n = rand.nextInt(to - from + 1) + from;
		return n;
	}

	

	public static void setColorForCell(Board board,Point point, int color) {
		CellLabel tmpCell = board.getCellSquares()[point
				.getX()][point.getY()];
		switch (color) {
		case SEFConstant.CellColorInt.WHITE_BG:
			tmpCell.setIcon(new ImageIcon(SEFConstant.CellColor.WHITE_BG));
			break;
		case SEFConstant.CellColorInt.RED_BG:
			tmpCell.setIcon(new ImageIcon(SEFConstant.CellColor.RED_BG));
			break;
		case SEFConstant.CellColorInt.GRAY_BG:
			tmpCell.setIcon(new ImageIcon(SEFConstant.CellColor.GRAY_BG));
			break;
		default:
			break;
		}

	}

	
	public static Point convertIdToPoint(String id) {
		Point point;
		point = new Point(Integer.parseInt(id.split("-")[0].trim()),
				Integer.parseInt(id.split("-")[1].trim()));
		return point;
	}

	public static int getDistanceBetweenTwoPoints(Point a, Point b) {
		return Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY());
	}

	public static boolean hasTheSameLocation(Point a, Point b) {
		if (a.getX() == b.getX() && a.getY() == b.getY())
			return true;
		return false;
	}

	public static List getTwoPointCollectionIntersection(List list1, List list2) {
		List mList = new ArrayList<Point>();
		if (list1 == null || list2 == null)
			return mList;
		for (Object point1 : list1) {
			for (Object point2 : list2) {
				if (hasTheSameLocation((Point) point1, (Point) point2)) {
					mList.add(point1);
				}
			}
		}
		return mList;
	}

	public static void displayShapeOnBoard(MFrame parentView) {
		List tmp = parentView.getScreen5().getSquareBoard().getShapePoints();
		if (tmp == null)
			return;
		for (Object object : tmp) {
			Point point = (Point) object;
			parentView.getScreen5().getSquareBoard().getCellSquares()[point
					.getX()][point.getY()]
					.setStatus(SEFConstant.CellStatus.UC_KEY);
		}
	}

	public static void setStatusCell(Point point, int status, MFrame parentView) {
		switch (status) {
		case SEFConstant.CellStatus.BLANK:
			parentView.getScreen5().getSquareBoard().getCellSquares()[point
					.getX()][point.getY()]
					.setStatus(SEFConstant.CellStatus.BLANK);
			break;
		case SEFConstant.CellStatus.C_KEY:
			parentView.getScreen5().getSquareBoard().getCellSquares()[point
					.getX()][point.getY()]
					.setStatus(SEFConstant.CellStatus.C_KEY);
			break;
		case SEFConstant.CellStatus.UC_KEY:
			parentView.getScreen5().getSquareBoard().getCellSquares()[point
					.getX()][point.getY()]
					.setStatus(SEFConstant.CellStatus.UC_KEY);
			break;
		case SEFConstant.CellStatus.ON_CLICK:
			parentView.getScreen5().getSquareBoard().getCellSquares()[point
					.getX()][point.getY()]
					.setStatus(SEFConstant.CellStatus.ON_CLICK);
			break;
		}
	}

	public static void setStatusCellCollection(List points, int status,
			MFrame parentView) {
		for (Object object : points) {
			Point tmpPoint = (Point) object;
			setStatusCell(tmpPoint, status, parentView);
		}

	}

	/*
	 * 20151011 khangcv add
	 */
	public static List<Player> getPlayerList() {
		try {
			FileInputStream streamIn = new FileInputStream(
					SEFConstant.FileLink.LIST_PLAYER);
			ObjectInputStream objectinputstream = new ObjectInputStream(
					streamIn);
			@SuppressWarnings("unchecked")
			List<Player> readCase = (List<Player>) objectinputstream
					.readObject();
			objectinputstream.close();
			streamIn.close();
			return readCase;

		} catch (EOFException e) {

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "player file does not exist "
					+ e, "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
		}
		return null;
	}

	public static void addPlayerToList(Player player) {
		FileOutputStream fout;
		try {
			fout = new FileOutputStream(SEFConstant.FileLink.LIST_PLAYER, true);

			ObjectOutputStream oos = new ObjectOutputStream(fout);
			List<Player> players = getPlayerList();
			if (players == null)
				players = new ArrayList<Player>();
			players.add(player);
			oos.writeObject(players);
			oos.close();
			fout.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "can not add player to file "
					+ e, "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
		} finally {
			deleteFile(SEFConstant.FileLink.LIST_PLAYER);
			createFile(SEFConstant.FileLink.LIST_PLAYER);
		}
	}

	public static boolean isPlayerExist(Player player) {
		List<Player> players = getPlayerList();
		if (players == null)
			return false;
		for (Player player2 : players) {
			if (player.getName().equals(player2.getName()))
				return true;
		}
		return false;
	}

	public static List<Shape> getShapeList() {
		try {
			FileInputStream streamIn = new FileInputStream(
					SEFConstant.FileLink.LIST_SHAPE);
			ObjectInputStream objectinputstream = new ObjectInputStream(
					streamIn);
			List<Shape> readCase = (List<Shape>) objectinputstream.readObject();
			streamIn.close();
			return readCase;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "shape file does not exist",
					"InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
		}
		return null;
	}

	public static void addShapeToList(Shape shape) {
		FileOutputStream fout;
		try {
			fout = new FileOutputStream(SEFConstant.FileLink.LIST_SHAPE, true);

			ObjectOutputStream oos = new ObjectOutputStream(fout);
			List<Shape> shapes = getShapeList();
			if (shapes == null)
				shapes = new ArrayList<Shape>();
			shapes.add(shape);
			oos.writeObject(shapes);
			oos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "can not add shape to file "
					+ e, "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static boolean isShapeExist(Shape shape) {
		List<Shape> shapes = getShapeList();

		for (Shape shape2 : shapes) {
			if (shape.getList().size() == shape2.getList().size()
					&& shape.getList().containsAll(shape2.getList()))
				return true;
		}
		return false;
	}

	public static void deleteFile(String name) {
		try {

			File file = new File(name);
			file.setWritable(true);
			if (file.delete()) {
				System.out.println(file.getName() + " is deleted!");
			} else {
				System.out.println("Delete operation is failed.");
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	public static void createFile(String name) {
		try {

			File file = new File(name);
			file.setWritable(true);
			if (file.createNewFile()) {
				System.out.println("File is created!");
			} else {
				System.out.println("File already exists.");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static List<Point> getUncoveredKeyList(Board board) {
		List<Point> mList = new ArrayList<Point>();
		for (int i = 0; i < board.getNumRow() - 1; i++) {
			for (int j = 0; j < board.getNumCol() - 1; j++) {
				if (board.getCellSquares()[i][j].getStatus() == SEFConstant.CellStatus.UC_KEY) {
					mList.add(new Point(i, j));
				}
			}
		}
		return mList;
	}
}

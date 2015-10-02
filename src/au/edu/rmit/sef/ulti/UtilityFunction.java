package au.edu.rmit.sef.ulti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;

import au.edu.rmit.sef.model.CellLabel;
import au.edu.rmit.sef.model.Point;
import au.edu.rmit.sef.model.Shape;
import au.edu.rmit.sef.view.MFrame;

public class UtilityFunction {

	private static List<Point> orginalPoints = new ArrayList<Point>();
	private static HashMap<Point, Point> oneTime90 = new HashMap<Point, Point>();
	private static HashMap<Point, Point> twoTimes90 = new HashMap<Point, Point>();
	private static HashMap<Point, Point> threeTimes90 = new HashMap<Point, Point>();

	private static List<Shape> shapeCollection = new ArrayList<Shape>();

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

	public static List getShapePointCollection(String nameShape) {
		if (orginalPoints.size() == 0)
			initateData();
		List tmpList = new ArrayList<Point>();
		Shape tmpShape = null;
		Point newRoot = getRandomRootPointOfShap();
		int ranAngle = 0;
		for (Shape s : shapeCollection) {
			if (s.getName().equals(nameShape)) {
				tmpShape = s;
				break;
			}
		}
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

	

	public static void setColorForPoint(Point point, int color,
			MFrame parentView) {
		CellLabel tmpCell = parentView.getSquareBoard().getCellSquares()[point
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

	public static void setColorForPointCollection(List pointList, int color,
			MFrame parentView) {
		switch (color) {
		case SEFConstant.CellColorInt.WHITE_BG:
			for (Object point : pointList) {
				Point tmp = (Point) point;
				setColorForPoint(tmp, SEFConstant.CellColorInt.WHITE_BG,
						parentView);
			}
			break;
		case SEFConstant.CellColorInt.RED_BG:
			for (Object point : pointList) {
				Point tmp = (Point) point;
				setColorForPoint(tmp, SEFConstant.CellColorInt.RED_BG,
						parentView);
			}
			break;
		case SEFConstant.CellColorInt.GRAY_BG:
			for (Object point : pointList) {
				Point tmp = (Point) point;
				setColorForPoint(tmp, SEFConstant.CellColorInt.GRAY_BG,
						parentView);
			}
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
		List tmp = parentView.getSquareBoard().getShapePoints();
		if (tmp == null)
			return;
		for (Object object : tmp) {
			Point point = (Point) object;
			parentView.getSquareBoard().getCellSquares()[point.getX()][point
					.getY()].setStatus(SEFConstant.CellStatus.UC_KEY);
		}
	}

	public static void setStatusCell(Point point, int status, MFrame parentView) {
		switch (status) {
		case SEFConstant.CellStatus.BLANK:
			parentView.getSquareBoard().getCellSquares()[point.getX()][point
					.getY()].setStatus(SEFConstant.CellStatus.BLANK);
			break;
		case SEFConstant.CellStatus.C_KEY:
			parentView.getSquareBoard().getCellSquares()[point.getX()][point
					.getY()].setStatus(SEFConstant.CellStatus.C_KEY);
			break;
		case SEFConstant.CellStatus.UC_KEY:
			parentView.getSquareBoard().getCellSquares()[point.getX()][point
					.getY()].setStatus(SEFConstant.CellStatus.UC_KEY);
			break;
		case SEFConstant.CellStatus.ON_CLICK:
			parentView.getSquareBoard().getCellSquares()[point.getX()][point
					.getY()].setStatus(SEFConstant.CellStatus.ON_CLICK);
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
}

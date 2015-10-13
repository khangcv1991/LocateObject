package au.edu.rmit.sef.ulti;

public class SEFConstant {

	public static int NUM_ROW = 10;
	public static int NUM_COL = 16;
	public final static int CELL_SIZE = 40;
	public final static int TURN_NUM = 10;

	public static interface FileLink {
		public final static String LIST_PLAYER = "d:\\player.ser";
		public final static String LIST_SHAPE = "c:\\shape.ser";
	}

	public static interface CellColor {
		public final static String WHITE_BG = "C:\\Users\\Khang\\Pictures\\white.png";
		public final static String RED_BG = "C:\\Users\\Khang\\Pictures\\Red.png";
		public final static String GRAY_BG = "C:\\Users\\Khang\\Pictures\\Gray.jpg";

	}

	public static interface GameState {
		public final static int SCREEN1 = 1;
		public final static int SCREEN2 = 2;
		public final static int SCREEN3 = 3;
		public final static int SCREEN4 = 4;
		public final static int SCREEN5 = 5;
	}

	public static interface CellColorInt {
		public final static int WHITE_BG = 0;
		public final static int RED_BG = 1;
		public final static int GRAY_BG = 2;
	}

	public static interface ShapeType {
		public final static int L_TYPE = 0;
		public final static int V_TYPE = 1;
	}

	public static interface ShapeDirection {
		public static final int UP = 0;
		public static final int DOWN = 1;
		public static final int LEFT = 2;
		public static final int RIGHT = 3;
	}

	public static interface ModePlay {
		public final static int POINT_OPT = 0;
		public final static int LINE_OPT = 1;
		public final static int GRID_OPT = 2;
	}

	public static interface CellStatus {
		public final static int BLANK = 0;
		public final static int C_KEY = 1;
		public final static int UC_KEY = 2;
		public final static int ON_CLICK = 4;
	}

	public static interface StatusLabel {
		public final static String MSG_GOT_IT = "You got it!";
		public final static String MSG_AGAIN = "try again!";
		public final static String MSG_FAR_TO = "it is not far to you: ";
	}

	public static interface PlayerNumber {
		public final static int TWO_PLAYERS = 2;
		public final static int THREE_PLAYERS = 3;
	}
}

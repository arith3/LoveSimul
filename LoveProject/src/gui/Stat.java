package gui;

public class Stat {
	private static final int FrameWidth = 1280;
	private static final int FrameHeight = 720;

	private static int pronum = 1;
	private static double score = 10.0;

	public static int getPronum() {
		return pronum;
	}

	public static void setPronum(int pronum) {
		Stat.pronum = pronum;
	}
	
	protected static void minusScore()
	{
		score = score - 0.2;
	} //when player select wrong answer, score -0.2
	
	protected static double getScore()
	{
		return score;
	}

	public static int getFramewidth() {
		return FrameWidth;
	}

	public static int getFrameheight() {
		return FrameHeight;
	}
}

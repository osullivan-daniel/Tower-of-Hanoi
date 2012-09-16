package sqlLite;

public class AddHighScore
{
	public static void addHighScore(String name, int moves, String time) 
	{
        LeaderBoardJDBCDAO leaderBoard = new LeaderBoardJDBCDAO();
        HighScore highScore = new HighScore();
        highScore.setName(name);
        highScore.setMoves(moves);
        highScore.setTime(time);
       
        leaderBoard.add(highScore);
	}
}
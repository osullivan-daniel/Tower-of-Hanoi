package sqlLite;

public class HighScore 
{
	String name;
	int moves;
	String time;
		
	public HighScore(){}
	
	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public int getMoves() 
	{
		return moves;
	}

	public void setMoves(int moves) 
	{
		this.moves = moves;
	}

	public String getTime() 
	{
		return time;
	}

	public void setTime(String time) 
	{
		this.time = time;
	}
}
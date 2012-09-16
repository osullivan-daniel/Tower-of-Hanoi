package leaderBoard;

public class LeaderBoardData 
{
	public Integer rank;
	public String name;
	public String movesTaken;
	public String time;

	public LeaderBoardData(Integer rank, String name, String movesTaken, String time) 
	{
		this.rank = rank;
	    this.name = name;
		this.movesTaken = movesTaken;
		this.time = time;
	}
}

class ColumnData 
{
	  public String m_title;
	  public int m_width;
	  public int m_alignment;

	  public ColumnData(String title, int width, int alignment) 
	  {
		  m_title = title;
		  m_width = width;
		  m_alignment = alignment;
	  }
}
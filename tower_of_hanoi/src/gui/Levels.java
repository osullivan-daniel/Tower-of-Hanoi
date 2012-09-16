package gui;

//level enum number of tiles & save db
public enum Levels 
{
	//number of tiles, leader table for level played
	EASY(4, "easy_level"),
	MEDIUM(6, "medium_level"),
	HARD(8, "hard_level");
	
	private final int numTiles;
	private final String levelTable;
	
	//constructor
	Levels(int i, String s)
	{
		numTiles = i;
		levelTable = s;
	}
	
	//number of tiles
	public int getNumTiles()
	{
		return numTiles;
	}
	
	//leader table level
	public String getlevelTabel()
	{
		return levelTable;
	}
}

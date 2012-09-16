package leaderBoard;

import java.util.Vector;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.table.AbstractTableModel;

import sqlLite.LeaderBoardJDBCDAO;


public class LeaderBoardModel extends AbstractTableModel 
{
	//set the coloums
	static final public ColumnData m_columns[] = { new ColumnData("", 30, JLabel.CENTER),
												   new ColumnData("Name", 80, JLabel.CENTER),
												   new ColumnData("Moves", 130, JLabel.CENTER),
												   new ColumnData("Time", 113, JLabel.CENTER) };
	protected Vector vector;

	
	public LeaderBoardModel() 
	{
		vector = new Vector();
		setDefaultData();
	}

	//this method the table with the stored records from 1 -10 in the DB and fills in dashs
	//for records that dont exist.
	public void setDefaultData() 
	{
		vector.removeAllElements();

		LeaderBoardJDBCDAO lb = new LeaderBoardJDBCDAO();

		ArrayList<String> name = lb.getName();
		ArrayList<String> moves = lb.getMoves();
		ArrayList<String> time = lb.getTime();
		
	    for(int i = 0; i<name.size(); i++)
	    {
	    	vector.addElement(new LeaderBoardData(i+1 , name.get(i), moves.get(i), time.get(i)));	
	    }
	    
	    for(int i = name.size(); i<10; i++)
	    {
	    	vector.addElement(new LeaderBoardData(i+1 , "-------", "--", "--:--:---"));
	    }
	}
	
	public int getRowCount() 
	{
	    return vector == null ? 0 : vector.size();
	}

	public int getColumnCount() 
	{
		return m_columns.length;
	}

	public String getColumnName(int column) 
	{
		return m_columns[column].m_title;
	}

	public boolean isCellEditable(int nRow, int nCol) 
	{
		return false;
	}

	public Object getValueAt(int nRow, int nCol) 
	{
		if (nRow < 0 || nRow >= getRowCount())
		{
			return "";
		}
	
		LeaderBoardData row = (LeaderBoardData) vector.elementAt(nRow);
	
		switch (nCol) 
		{
			case 0:
			{
				return row.rank;
			}
		
			case 1:
			{
				return row.name;
			}
			
			case 2:
			{
				return row.movesTaken;
			}
			case 3:
			{
				return row.time;
			}
		}
		return "";
	}
}
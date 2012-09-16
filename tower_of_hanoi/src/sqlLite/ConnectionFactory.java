package sqlLite;

import java.sql.Connection;
import java.sql.SQLException;

import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteDataSource;


public class ConnectionFactory 
{
	private static ConnectionFactory connectionFactory = null;
	private static final String driverClassName = "org.sqlite.JDBC";
	
	private ConnectionFactory() 
	{
		try 
        {
			Class.forName(driverClassName);
        } 
        catch (ClassNotFoundException e) 
        {
        	e.printStackTrace();
        }
	}
	 
	public Connection getConnection() throws SQLException 
	{
		Connection conn = null;
		SQLiteConfig config =  new SQLiteConfig();
		SQLiteDataSource ds = new  SQLiteDataSource(config);
		
		//Will get the location of the Program Files folder in the same folder as jar when exported.
		java.io.File currentDir = new java.io.File("");
		ds.setUrl("jdbc:sqlite:" + currentDir.getAbsolutePath() + ("/Program Files/hanoi.toh").toString());
		
		conn = ds.getConnection();
		
		return conn;
	}

	public static ConnectionFactory getInstance() 
	{
		if (connectionFactory == null) 
		{
			connectionFactory = new ConnectionFactory();
        }
		 
        return connectionFactory;
	}
}
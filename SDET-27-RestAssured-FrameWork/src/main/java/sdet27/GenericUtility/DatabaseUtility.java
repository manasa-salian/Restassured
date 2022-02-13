package sdet27.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * this class connects generic methods to connect database
 * @author DELL
 *
 */

public class DatabaseUtility {
	Connection con=null;
//Step 1:register the database
//Step 2:get connection with DB
	//Step 3:issue create stmt
	//Step 4:execute Query 
	//Step 5: closing connection
	public void connectToDB() throws Throwable {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(IConstants.dbURL,IConstants.dbUserName,IConstants.dbPassword);
	}
	/**
	 * this method will execute query and return the data present in database
	 * @param query
	 * @param columnIndex
	 * @param expData
	 * @return
	 * @throws Throwable
	 */
	public String executeQueryAndGetData(String query, int columnIndex, String expData) throws Throwable {
		boolean flag=false;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next()) {
			String value = result.getString(columnIndex);
			if(value.equalsIgnoreCase(expData)) {
				
				 flag = true;//rising the flag
				 break;
				
			}
		}
		if(flag) {
			System.out.println(expData+" Data Verified");
			return expData;
		} 
		else
		{
			System.out.println("data not present");
			return "";
		}
	}
	/**
	 * this method will close the database connection
	 * @throws  Throwable
	 */
	public void closeDB() throws Throwable {
		con.close();
	}
	
}

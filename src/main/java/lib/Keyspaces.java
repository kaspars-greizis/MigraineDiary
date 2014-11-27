package lib;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.SimpleStatement;

public final class Keyspaces
{
	public Keyspaces()
	{
		
	}
	
	public static void SetUpKeySpaces(Cluster c)
	{
		try
		{
			String createKeyspace = "create keyspace if not exists migrainediary  WITH replication = {'class':'SimpleStrategy', 'replication_factor':1}";
			String createUserTable = "CREATE TABLE if not exists migrainediary.users ("
				+ " username varchar, "
				+ " password text, "
				+ " first_name text, "
				+ " last_name text, "
				+ " dob timestamp, "
				+ " gender text, "
				+ " employment text, "
				+ " everyday_meds varchar, "
				+ " known_triggers text, "
				+ " PRIMARY KEY (username)"
				+ " )";
			String createDiaryTable = "CREATE TABLE if not exists migrainediary.diary ("
				+ "diaryid int, "
				+ "start text, "
				+ "end text, "
                                + "severity int"
				+ "triggers text, "
				+ "medication text, "
				+ "description text, "
                                + "username varchar"
				+ " PRIMARY KEY (diaryid)"
				+ " )";
			String createMedicationTable = "CREATE TABLE if not exists migrainediary.medication ("
				+ " medicationid uuid, "
				+ " name varchar, "
				+ " type text, "
				+ " PRIMARY KEY (medicationid)"
				+ " )";
			String createCauseTable = "CREATE TABLE if not exists migrainediary.cause ("
				+ "triggerid uuid, "
				+ "name text, "
				+ "categories text, "
				+ " PRIMARY KEY (triggerid)"
				+ " )";
			Session session = c.connect();
			try
			{
				PreparedStatement statement = session.prepare(createKeyspace);
				BoundStatement boundStatement = new BoundStatement(statement);
				System.out.println ("Created Migraine Diary");
			} 
			catch (Exception et) 
			{
				System.out.println("Can't create Migraine Diary " + et);
			}
			
			System.out.println("" + createUserTable);
			try
			{
				SimpleStatement cqlQuery = new SimpleStatement(createUserTable);
				session.execute(cqlQuery);
			}
			catch (Exception et)
			{
				System.out.println("Can't create user table" + et);
			}
			
			System.out.println("" + createDiaryTable);
			try
			{
				SimpleStatement cqlQuery = new SimpleStatement(createDiaryTable);
				session.execute(cqlQuery);
			}
			catch (Exception et)
			{
				System.out.println("Can't create diary table" + et);
			}
			
			System.out.println("" + createMedicationTable);
			try
			{
				SimpleStatement cqlQuery = new SimpleStatement(createMedicationTable);
				session.execute(cqlQuery);
			}
			catch (Exception et)
			{
				System.out.println("Can't create medication table" + et);
			}
			
			System.out.println("" + createCauseTable);
			try
			{
				SimpleStatement cqlQuery = new SimpleStatement(createCauseTable);
				session.execute(cqlQuery);
			}
			catch (Exception et)
			{
				System.out.println("Can't create cause table" + et);
			}
		}
		catch (Exception et)
		{
			System.out.println("Other keyspace or column definition error " + et);
		}
	}
}
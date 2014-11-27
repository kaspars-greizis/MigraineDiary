package models;

import java.util.Date;
import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import lib.AeSimpleSHA1;

public class User
{
	Cluster cluster;
	public User()
	{
		
	}
	
	public boolean RegisterUser(String username, String password, String first_name, String last_name, String dob, String gender, String employment, String everyday_meds, String known_triggers, boolean register)
	{
            String EncodedPassword = null;
            try
            {
                    EncodedPassword = AeSimpleSHA1.SHA1(password);
            }
            catch (UnsupportedEncodingException | NoSuchAlgorithmException et)
            {
                    System.out.println("Can't check your password");
                    return false;
            }
            if (register){
            Session session = cluster.connect("migrainediary");
            PreparedStatement ps = session.prepare("insert into migrainediary.users (username, password, first_name, last_name, dob, gender, employment, everyday_meds, known_triggers) values(?,?,?,?,?,?,?,?,?)");
            BoundStatement boundStatement = new BoundStatement(ps);
            session.execute(boundStatement.bind(username, EncodedPassword, first_name, last_name, dob, gender, employment, everyday_meds, known_triggers));
            return true;
            }else if(!register){
                Session session = cluster.connect("migrainediary");
            PreparedStatement ps = session.prepare("UPDATE migrainediary.users SET password=?, first_name=?, last_name=?, dob=?, gender=?, employment=?, everyday_meds=?, known_triggers=? WHERE username='"+username+"'");
            BoundStatement boundStatement = new BoundStatement(ps);
            session.execute(boundStatement.bind(EncodedPassword, first_name, last_name, dob, gender, employment, everyday_meds, known_triggers));
            return true;
            }else return false;
	}
        public boolean IsValidUser(String username, String Password){
            AeSimpleSHA1 sha1handler=  new AeSimpleSHA1();
            String EncodedPassword=null;
            try {
                EncodedPassword= sha1handler.SHA1(Password);
            }catch (UnsupportedEncodingException | NoSuchAlgorithmException et){
                System.out.println("Can't check your password");
                return false;
            }
            Session session = cluster.connect("migrainediary");
            PreparedStatement ps = session.prepare("select password from migrainediary.users where username =?");
            ResultSet rs = null;
            BoundStatement boundStatement = new BoundStatement(ps);
            rs = session.execute( // this is where the query is executed
                    boundStatement.bind( // here you are binding the 'boundStatement'
                            username));
            if (rs.isExhausted()) {
                System.out.println("No x returned");
                return false;
            } else {
                for (Row row : rs) {

                    String StoredPass = row.getString("password");
                    if (StoredPass.compareTo(EncodedPassword) == 0)
                        return true;
                }
            }
            return false;  
        }
        
        public void setCluster(Cluster cluster) {
            this.cluster = cluster;
        }
}
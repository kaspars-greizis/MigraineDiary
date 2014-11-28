/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Session;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author garethlloyd
 */
@WebServlet(name = "DiaryModel", urlPatterns = {"/DiaryModel/*"})

public class DiaryModel
{
	Cluster cluster;
	public DiaryModel()
	{
		
	}
	
	public boolean addDiary(String username, String start, String end, String description, String medication, String triggers, int severity)
	{
               int diaryId=6;
            Session session = cluster.connect("migrainediary");
            PreparedStatement ps = session.prepare("insert into migrainediary.diary (diaryid, username, start, end, description, medication, triggers, severity) values(?,?,?,?,?,?,?,?)");
            BoundStatement boundStatement = new BoundStatement(ps);
            session.execute(boundStatement.bind(diaryId,username, start, end, description, medication, triggers, severity));
            return true;
	}
 
        public void setCluster(Cluster cluster) {
            this.cluster = cluster;
        }
}
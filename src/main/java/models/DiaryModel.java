/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.*;
import lib.AeSimpleSHA1;

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
            int diaryId=0;
            Session csession = cluster.connect("migrainediary");
             PreparedStatement ps1 = csession.prepare("SELECT COUNT(*) FROM diary");
            BoundStatement boundStatement = new BoundStatement(ps1);
            ResultSet rs1 = csession.execute(
                    boundStatement.bind() );
            if (rs1.isExhausted()){
                
                
            }else{
                
                
                for (Row row : rs1){
                      long diaryId1 = row.getLong("count");
                      diaryId = (int) (long) diaryId1;
                      
                        
                }
                
                diaryId++;
                }
            
            Session session = cluster.connect("migrainediary");
            PreparedStatement ps = session.prepare("insert into migrainediary.diary (diaryid, username, start, end, description, medication, triggers, severity) values(?,?,?,?,?,?,?,?)");
            BoundStatement boundStatement1 = new BoundStatement(ps);
            session.execute(boundStatement1.bind(diaryId,username, start, end, description, medication, triggers, severity));
            return true;
	}
 
        public void setCluster(Cluster cluster) {
            this.cluster = cluster;
        }
}
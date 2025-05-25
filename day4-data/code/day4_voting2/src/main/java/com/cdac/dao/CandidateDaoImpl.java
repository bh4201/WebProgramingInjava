package com.cdac.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.cdac.pojos.Candidate;
import static com.cdac.utils.DBUtils.*;

public class CandidateDaoImpl implements CandidateDao {
	private Connection cn;
	private PreparedStatement pst1,pst2,pst3,pst4;

	public CandidateDaoImpl() throws SQLException {
		cn = getConnection();
		// pst1- select
		pst1 = cn.prepareStatement("select * from candidates");
		pst2=cn.prepareStatement("update candidates set votes=votes+1 where id=?");
		pst3=cn.prepareStatement("select * from candidates order by votes desc limit 2 ");

		pst4=cn.prepareStatement("select party, sum(votes) from candidates group by party");
		System.out.println("candidate dao created !");
	}

	@Override
	public List<Candidate> getAllCandidates() throws SQLException {
		// create empty list
		List<Candidate> candidates = new ArrayList<>();
		// exec select query to get ResultSet
		/*
		 * int candidateId, String name, String partyName, int votes
		 */
		try (ResultSet rst = pst1.executeQuery()) {
			while (rst.next())
				candidates.add(new Candidate(rst.getInt(1), 
						rst.getString(2), rst.getString(3), rst.getInt(4)));
		}
		return candidates;
	}
	
	

	@Override
	public String incrementCandidateVotes(int candidateId) throws SQLException {
		//set IN param - candidate id
		pst2.setInt(1, candidateId);
		int updateCount = pst2.executeUpdate();
		if (updateCount == 1)
			return "Candodate votes incremented ....";
		return "incrementing votes failed !!!!";
		
	}
	//top 2 caandidates
	@Override
	public List<Candidate> getTop2Candidates() throws SQLException {
		
		// create empty list
				List<Candidate> candidates = new ArrayList<>();
				try(ResultSet rs =pst3.executeQuery()){
					while(rs.next()) {
						candidates.add(new Candidate(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
					}
					return candidates;
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				return null;
	}

	@Override
	public Map<String, Integer> getPartyVotes() throws SQLException {
		
		Map<String,Integer> pv = new LinkedHashMap<>();
		try(ResultSet rs =pst4.executeQuery()){
			while(rs.next()) {
				pv.put(rs.getString(1),rs.getInt(2));
				
			}
			return pv;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public void cleanUp() throws SQLException {
		if (pst1 != null) {
			pst1.close();
			pst1=null;
		}
		if (pst2 != null) {
			pst2.close();
			pst2=null;
		}
		if (pst3 != null) {
			pst3.close();
			pst3=null;
		}
		if (pst4 != null) {
			pst4.close();
			pst4=null;
		}
		System.out.println("candidate dao cleaned up !");
	}




}

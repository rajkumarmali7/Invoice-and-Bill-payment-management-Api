//package com.bord.bill.demo.CustomIdGenerator;
//
//import java.io.Serializable;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import org.hibernate.HibernateException;
//import org.hibernate.engine.spi.SharedSessionContractImplementor;
//import org.hibernate.id.IdentifierGenerator;
//
//public class BoardIdGenerator implements IdentifierGenerator{
//
//	@Override
//	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
//		 String prefix = "bid";
//		    Connection connection = session.connection();
//
//		    try {
//		        Statement statement=connection.createStatement();
//
//		        ResultSet rs=statement.executeQuery("select count(boardID) as Id from Boards");
//
//		        if(rs.next())
//		        {
//		            int id=rs.getInt(1)+1;
//		            String generatedId = prefix + Integer.valueOf(id).toString();
//		            return generatedId;
//		        }
//		    } catch (SQLException e) {
//		        // TODO Auto-generated catch block
//		        e.printStackTrace();
//		    }
//
//		    return null;
//	}
//
//}

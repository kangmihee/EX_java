package com.mysqlsungjuk;
import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DbcpMyBean {
   private Connection conn;
   public DbcpMyBean() {
      try {
         Context initContext = new InitialContext();
         Context envContext =
               (Context)initContext.lookup("java:/comp/env");
         DataSource ds = (DataSource)envContext.lookup("jdbc/myconn");
         conn = ds.getConnection();
         System.out.println("DbcpBean 작업 성공!");
      }catch(Exception e) {
         
      }
   }
   public Connection getConn() {return conn;}
}
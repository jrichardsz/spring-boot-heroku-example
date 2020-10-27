package org.jrichardsz.templates.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.HashMap;

import java.sql.*;

@RestController
@SpringBootApplication
public class DemoApplication {

  @RequestMapping(value="/database/test", method=RequestMethod.GET)
  public Object databaseTest(@RequestParam String jdbcUrl,@RequestParam String jdbcDriver, @RequestParam String user, @RequestParam String password, @RequestParam String sqlTest){

    HashMap<String, Object> response = new HashMap<String, Object>();
    response.put("status", testConnection(jdbcUrl,jdbcDriver, user, password, sqlTest));
    return response;
  }

  public String testConnection(String jdbcUrl, String jdbcDriver, String user, String password, String sqlTest){
    Connection conn = null;
    Statement stmt = null;
    String response = "";
    try{
          //STEP 2: Register JDBC driver
          Class.forName(jdbcDriver);

          //STEP 3: Open a connection
          System.out.println("Connecting to a selected database...");
          conn = DriverManager.getConnection(jdbcUrl, user, password);
          System.out.println("Connected database successfully...");

          //STEP 4: Execute a query
          System.out.println("Creating statement...");
          stmt = conn.createStatement();

          ResultSet rs = stmt.executeQuery(sqlTest);
          //STEP 5: Extract data from result set

          if(rs.next()){
            System.out.println("success connection");
            response = "success connection";
          }
          rs.close();
       }catch(SQLException se){
          System.out.println(se.toString());
          response = se.toString();
       }catch(Exception e){
          System.out.println(e.toString());
          response = e.toString();
       }finally{
          //finally block used to close resources
          try{
             if(stmt!=null)
                conn.close();
          }catch(SQLException se){
            System.out.println(se.toString());
            response = se.toString();
          }// do nothing
          try{
             if(conn!=null)
                conn.close();
          }catch(SQLException se){
            System.out.println(se.toString());
            response = se.toString();
          }//end finally try
       }//end try

       return response;

  }

  public static void main(String[] args) {
      SpringApplication.run(DemoApplication.class, args);
  }
}

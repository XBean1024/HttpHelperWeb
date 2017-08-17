package com.http.dao.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.http.constant.Constant.driverName;
import static com.http.constant.Constant.url;

public class DBConnection {
  private static Connection con = null;
  public static Connection getConnection() { 
    try { 
      // 1.驱动 
      Class.forName(driverName); 
      // 2. 连接数据库 保持连接 
      con = DriverManager.getConnection(url);
      System.out.println("连接成功！");
    } catch (ClassNotFoundException e) { 
      // TODO Auto-generated catch block 
      e.printStackTrace(); 
    } catch (SQLException e) {
      // TODO Auto-generated catch block 
      e.printStackTrace(); 
    } 
    return con; 
  } 
  public static void closeConnection() { 
    if (con != null) { 
      try { 
        con.close(); 
      } catch (SQLException e) { 
        // TODO Auto-generated catch block 
        e.printStackTrace(); 
      } 
    } 
  } 
}

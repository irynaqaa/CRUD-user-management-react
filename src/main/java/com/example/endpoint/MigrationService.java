package com.example.endpoint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MigrationService {
  public String migrate(MigrationRequest request) {
    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password")) {
      try (Statement stmt = conn.createStatement()) {
        stmt.execute(request.getScript());
        if (stmt.getErrorCode() != 0) {
          throw new RuntimeException("Error executing migration script: " + stmt.getErrorMessage());
        }
        return "Migration successful";
      } catch (SQLException e) {
        throw new RuntimeException("Error executing migration script", e);
      }
    } catch (SQLException e) {
      throw new RuntimeException("Error connecting to database", e);
    }
  }
}
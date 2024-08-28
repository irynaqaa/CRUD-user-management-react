package com.example.endpoint;

import java.sql.Connection;
import java.sql.Statement;
import javax.sql.DataSource;

public class MigrationService {
    public String migrate(MigrationRequest request) throws MigrationException {
        DataSource dataSource = new DataSource();
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute(request.getScript());
            if (statement.getErrorCode() != 0) {
                throw new MigrationException("Error executing migration script");
            }
            return "Migration successful";
        } catch (java.sql.SQLException e) {
            throw new MigrationException("Error executing migration script", e);
        }
    }
}

class MigrationRequest {
    private String script;

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }
}

class MigrationException extends Exception {
    public MigrationException(String message) {
        super(message);
    }

    public MigrationException(String message, Throwable cause) {
        super(message, cause);
    }
}
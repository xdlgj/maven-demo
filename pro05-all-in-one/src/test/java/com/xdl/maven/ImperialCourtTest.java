package com.xdl.maven;

import com.xdl.maven.imperial.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;

public class ImperialCourtTest {
    @Test
    public void testGetConnection() {
        Connection connection = JDBCUtils.getConnection();
        System.out.println("connection = " + connection);
        JDBCUtils.releaseConnection(connection);
    }
}

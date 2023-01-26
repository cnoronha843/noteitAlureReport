package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SpannerDB {
    /// id IOS = n1mpYwtxNjNlddO5xmbEEKb18u33
    /// id IOS PROD = rq382qFDiRhKe6367rnIsE7nu7r1
    //select * from user_transactions where user_id = SHA1('n1mpYwtxNjNlddO5xmbEEKb18u33') order by inserted_at desc limit 20 ;
    private static String projectId = "noteit---development";
    private static String instanceId = "dev2";
    private static String databaseId = "noteit-dev";



    public static void query(String sql)
            throws SQLException {
        String connectionUrl =
                String.format(
                        "jdbc:cloudspanner:/projects/%s/instances/%s/databases/%s",
                        projectId, instanceId, databaseId);
        try (Connection connection = DriverManager.getConnection(connectionUrl)) {
            try (Statement statement = connection.createStatement()) {
                statement.execute(sql);
            }
        }

        System.out.println("Your query has been executed");
    }




}

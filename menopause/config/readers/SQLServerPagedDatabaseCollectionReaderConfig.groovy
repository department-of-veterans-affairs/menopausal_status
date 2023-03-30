import gov.va.vinci.leo.cr.SQLServerPagedDatabaseCollectionReader

String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"
String url = "jdbc:sqlserver://your_connection_string"
String query ='''select docid, text
from your_table
order by docid'''

offset = [0,1000000]
pagesize = 30000

// String driver, String url, String username, String password, String query, String idColumn, String noteColumn,int pageSize
reader = new SQLServerPagedDatabaseCollectionReader( driver,url,"","", query,
        "docid", "text", // Make sure that these fields are low case.
        pagesize,
        offset[0], offset[1]);

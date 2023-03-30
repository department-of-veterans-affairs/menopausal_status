import gov.va.vinci.leo.cr.BatchDatabaseCollectionReader;


String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"
String url = "jdbc:sqlserver://your_connection_string"
String query = '''SELECT docid, text, rowid
  FROM your_table 
  where rowid > {min} and rowid <= {max}
  '''

rowno = [0,1000000]
batch_size = 30000




reader = new BatchDatabaseCollectionReader(driver, url,
        "", "", query, "tiudocumentsid", "reporttext", rowno[0],
        rowno[1], batch_size);


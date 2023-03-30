import gov.va.vinci.leo.cr.DatabaseCollectionReader;

String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"
String url = "jdbc:sqlserver://your_connection_string"
String query = '''SELECT docid, text
  FROM your_table 

  '''

reader = new DatabaseCollectionReader(driver, url,
        "", "", query, "docid", "text");
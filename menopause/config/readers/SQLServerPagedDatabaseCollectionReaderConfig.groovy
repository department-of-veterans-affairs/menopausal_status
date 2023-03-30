import gov.va.vinci.leo.cr.SQLServerPagedDatabaseCollectionReader

String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"
String url = "jdbc:sqlserver://vhacdwrb03:1433;databasename=VINCI_COVIDNLP;integratedSecurity=true"
String query ='''SELECT a.[TIUDocumentSID], ReportText   
FROM [VINCI_COVIDNLP].[menopause].[menopause_cohort_TIU] a 
join [CDWwork].[STIUNotes].[TIUDocument_8925_02] b with(nolock) 
on a.tiudocumentsid=b.tiudocumentsid 
where processed=0 and reporttext is not null
order by tiudocumentsid'''

offset = [20000000,25000000]
pagesize = 30000

// String driver, String url, String username, String password, String query, String idColumn, String noteColumn,int pageSize
reader = new SQLServerPagedDatabaseCollectionReader( driver,url,"","", query,
        "tiudocumentsid", "reporttext", // Make sure that these fields are low case.
        pagesize,
        offset[0], offset[1]);

import gov.va.vinci.menopause.listeners.BasicDatabaseListener
import gov.va.vinci.leo.tools.LeoUtils
import gov.va.vinci.menopause.types.BirthControlStatement
import gov.va.vinci.menopause.types.LastMenstrualDate
import gov.va.vinci.menopause.types.Menopause
import gov.va.vinci.menopause.types.MenopauseDiagnosisDate
import gov.va.vinci.menopause.types.MenstrualInterruption
import gov.va.vinci.menopause.types.SurgicalMenopauseDate
import gov.va.vinci.menopause.types.TermContext

int batchSize = 1000
String url = "jdbc:sqlserver://your_connection_string"
String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"
String dbUser = ""
String dbPwd = ""

String dbsName = "your_db"
String timeStamp = LeoUtils.getTimestampDateDotTime().replaceAll("[.]", "").substring(0,8)
String tableName = "your_output_table" + timeStamp

fieldList = [
        ["DocID", "0", "varchar(50)"],
        ["Snippets", "-1", "varchar(500)"],
        ["SpanStart", "-1", "int"],
        ["SpanEnd", "-1", "int"],
        ["Type", "-1", "varchar(500)"],
        ["Concept", "-1", "varchar(500)"],
        ["Date", "-1", "varchar(500)"],
        ["RelativeQty", "-1", "varchar(20)"],
        ["RelativeUnit", "-1", "varchar(20)"]
]
listener = BasicDatabaseListener.createNewListener(
        driver,
        url,
        dbUser,
        dbPwd,
        dbsName,
        tableName,
        batchSize,
        fieldList,
        MenopauseDiagnosisDate.getCanonicalName()
        ,LastMenstrualDate.getCanonicalName()
        ,SurgicalMenopauseDate.getCanonicalName()
        , MenstrualInterruption.getCanonicalName()
        , BirthControlStatement.getCanonicalName()
)

boolean dropExisting = false;
// Comment out the statement below if you want to add to the existing table
listener.createTable(dropExisting);

println(listener.preparedStatementSQL)


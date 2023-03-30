import gov.va.vinci.menopause.types.BirthControlStatement
import gov.va.vinci.menopause.types.LastMenstrualDate
import gov.va.vinci.menopause.types.MenopauseDiagnosisDate
import gov.va.vinci.menopause.types.MenstrualInterruption
import gov.va.vinci.menopause.types.SurgicalMenopauseDate

String filePath = "output" + File.separator + "output.csv";  // output table
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
String[] incomingTypes = [MenopauseDiagnosisDate.getCanonicalName()
						  , LastMenstrualDate.getCanonicalName()
						  , SurgicalMenopauseDate.getCanonicalName()
						  , MenstrualInterruption.getCanonicalName()
						  , BirthControlStatement.getCanonicalName()]

listener =  gov.va.vinci.menopause.listeners.CSVListener.createNewListener(filePath, fieldList,incomingTypes)
listener.writeHeaders()

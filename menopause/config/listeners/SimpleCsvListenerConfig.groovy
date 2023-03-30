String timeStamp = gov.va.vinci.leo.tools.LeoUtils.getTimestampDateUnderscoreTime()
String csvDir =   "output/AllDocuments.csv"
if(!(new File(csvDir)).exists()) (new File(csvDir).getParentFile()).mkdirs()

listener = new gov.va.vinci.leo.listener.SimpleCsvListener(new File(csvDir))
listener.setInputType("gov.va.vinci.menopause.types.TermContext", "gov.va.vinci.menopause.types.TermPattern")
listener.setIncludeFeatures(true)
String timeStamp = gov.va.vinci.leo.tools.LeoUtils.getTimestampDateUnderscoreTime()
String xmiDir =  "xmi/"

if(!(new File(xmiDir)).exists()) (new File(xmiDir)).mkdirs()

listener = new gov.va.vinci.leo.listener.SimpleXmiListener(new File(xmiDir))
        .setTypeSystemDescriptor(new File ("config/TypeSystem.xml"))
listener.setLaunchAnnotationViewer(true)


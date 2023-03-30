import gov.va.vinci.leo.cr.FileCollectionReader;
String pathToFiles = "test_docs/"
if(new File(pathToFiles).exists()) {
    boolean recurse = false

    reader = new FileCollectionReader(new File(pathToFiles), recurse);
} else{
    print("Please correct the path. Directory does not exist at "+ new File(pathToFiles).getAbsoluteFile())
}


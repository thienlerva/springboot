package Directory;

import java.io.File;

public class CreateDirectoryExample {

    private static final String FOLDER = "F:\\thien\\newFolder";

    public static void main(String[] arg) {

//        File file = new File(FOLDER);
//
//        boolean created = file.mkdir();
//
//        System.out.println(created ? "Folder was created" : "Folder not created");

        //makeDir();
        lisDir();
    }

    static void makeDir() {
        String dirname = "/tmp/user/java/bin";
        File d = new File(dirname);

        boolean created = d.mkdirs();
        System.out.println(created ? "Folder created" : "Folder not created");
    }

    static void lisDir() {
        File file = null;
        String[] paths;

        try {
            file = new File("/tmp");

            paths = file.list();

            for (String path : paths) {
                System.out.println(path);
            }
            } catch (Exception ie) {
               ie.printStackTrace();
            }

    }

}

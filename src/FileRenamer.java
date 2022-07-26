import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Scanner;

public class FileRenamer {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Please input the full directory of the folder containing the files (ex: C:\\Users\\Smaltin\\Downloads)");
        Path dir = Paths.get(s.nextLine());
        System.out.println("Input the string you wish to replace");
        String del = s.nextLine();
        System.out.println("Input the string you wish to set it to");
        String set = s.nextLine();
        if (dir.isAbsolute()) {
            for (File f : Objects.requireNonNull(dir.toFile().listFiles())) {
                String setted = dir.toAbsolutePath() + "\\" + f.getName().replace(del, set);
                if (!f.getAbsolutePath().equals(setted)) {
                    System.out.println("Replacing `" + f.getAbsolutePath() + "` to `" + setted + "`");
                    f.renameTo(new File(setted));
                }
            }
        }
        System.out.println("All done!");
    }
}
package classes;

public class FileException extends Exception {
    public FileException(String path) {
        System.out.println("\033[91mFileException error : File does'nt exist/not enough permissions : \"" + path + "\".\033[0m");
    }
}

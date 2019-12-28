package system;

public class FileSystemStub {
    public FileSystemStub(int n) {
        FileSystem.fileStorage = new Space(n);
    }
}
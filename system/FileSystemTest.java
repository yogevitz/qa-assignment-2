package system;

import org.junit.Test;

import static org.junit.Assert.*;

public class FileSystemTest {

    FileSystem fs;
    @Before
    public void initialize() {
        fs = new FileSystem(1000000);
    }

    @Test
    public void createFileSystem(){
        assertNotNull(fs);
    }

    @Test
    public void updateFileStorage(){
        assertNotNull(fs.fileStorage);
    }

    @Test
    public void updateFileSystemTree(){
        String [] root = {"root"};
        assertNotNull(fs.DirExists(root));
    }

    @Test
    public void dir() {

    }

    @Test
    public void disk() {
    }

    @Test
    public void file() {
    }

    @Test
    public void lsdir() {
    }

    @Test
    public void rmfile() {
    }

    @Test
    public void rmdir() {
    }

    @Test
    public void fileExists() {
    }

    @Test
    public void dirExists() {
    }
}
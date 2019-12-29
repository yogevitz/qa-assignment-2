package system;

import org.junit.Before;
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
        String [] path = {"root","aliad","byogev","chadar","drom","yarin"};
        try {
            fs.dir(path);
        } catch (BadFileNameException e) {
        }
        assertNotNull(fs.DirExists(path));
    }


    @Test(expected = BadFileNameException.class)
    public void createDirExceptionIfNotRoot() throws Exception {
        String [] wrngPath = {"ofer"};
        fs.dir(wrngPath);
    }


    @Test(expected = BadFileNameException.class)
    public void createDirExceptionIfFileExists() throws BadFileNameException {
        String [] path = {"root","ofer"};
            fs.dir(path);
            fs.dir(path);
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
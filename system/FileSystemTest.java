package system;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FileSystemTest {

    FileSystem fs;

    @Before
    public void initialize() {
        fs = new FileSystem(1000000);
    }

    @After
    public void clear(){
        fs = null;
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
        String [] path = {"root","chen"};
        String [] path2 = {"root","yael"};
        String [] path3 = {"root","sara"};
        String[][]disk = {path,path2,path3};
        try {
            fs.dir(path);
            fs.dir(path2);
            fs.dir(path3);
        } catch (BadFileNameException e) {
        }
        assertEquals(disk,fs.disk());
    }

    @Test
    public void file() {
        String [] path = {"root","aliad","byogev","chadar","drom","yuval"};
        try {
            fs.file(path,10);
        } catch (OutOfSpaceException e) {
        } catch (BadFileNameException e) {
        }
        assertNotNull(fs.FileExists(path));
    }

    @Test (expected = BadFileNameException.class)
    public void createBadFileNameException() throws OutOfSpaceException, BadFileNameException {
        String [] wrngPath = {"ofer"};
        fs.file(wrngPath,10);
    }

    @Test
    public void lsdir(){
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
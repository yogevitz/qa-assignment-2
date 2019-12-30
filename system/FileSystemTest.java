package system;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

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
    public void createFileExceptionIfNotRoot() throws OutOfSpaceException, BadFileNameException {
        String [] wrngPath = {"ofer"};
        fs.file(wrngPath,10);
    }

    @Test(expected = BadFileNameException.class)
    public void createFileExceptionIfFileExists() throws BadFileNameException, OutOfSpaceException {
        String [] path = {"root","ofer"};
        fs.file(path,10);
        fs.file(path,10);
    }
    @Test
    public void lsdir(){

        String [] path = {"root","yuv"};
        try {
            Tree file = fs.DirExists(path);
            if (file==null){
                assertNull(fs.lsdir(path));
            }
            fs.dir(path);
            file = fs.DirExists(path);
            String[] fileList;
            fileList = new String[file.children.size()];
            fileList = file.children.keySet().toArray(fileList);
            //sort array - not essential, but nice!
            Arrays.sort(fileList);
            String[] fileListLSDIR= fs.lsdir(path);
            for (int i = 0; i < fileListLSDIR.length ; i++) {
                assertEquals(fileList[i], fileListLSDIR[i]);
            }
        } catch (BadFileNameException e) {
        }

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
package system;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.DirectoryNotEmptyException;
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
        String [] path1 = {"root","chen"};
        String [] path2 = {"root","yael"};
        String [] path3 = {"root","sara"};
        String[] expectedDisk = {path1[0],path1[1],path2[0],path2[1],path3[0],path3[1]};
        try {
            fs.file(path1,1);
            fs.file(path2,1);
            fs.file(path3,1);
            String[][] actualDisk = fs.disk();
            int i=0;
            for (String[] path : actualDisk) {
                if(path!=null) {
                    for (String node : path) {
                        if (node != null) {
                            assertEquals(expectedDisk[i], node);
                            i++;
                        }
                    }
                }
            }
        } catch (BadFileNameException e) {
        } catch (OutOfSpaceException e) {
        }
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
        String [] path = {"root","romber"};
        try {
            fs.file(path,10);
            fs.rmfile(path);
            assertNull(fs.FileExists(path));

        } catch (BadFileNameException e) {

        } catch (OutOfSpaceException e) {

        }

    }


        @Test
    public void rmdir() {
        String [] path = {"root","shlomyar"};
        try {
            fs.dir(path);
            fs.rmdir(path);
            assertNull(fs.DirExists(path));

        } catch (BadFileNameException e) {

        } catch (DirectoryNotEmptyException e) {

        }
    }

    @Test(expected = DirectoryNotEmptyException.class)
    public void rmdirException() throws Exception {
        String[] path = {"root","galber"};
        String[] pathfile = {"root","galber","liad"};
        fs.dir(path);
        fs.file(pathfile,10);
        fs.rmdir(path);
    }

    @Test
    public void fileExists() {
        String[] path = {"root","shlomyuv"};
        try {
            assertNull(fs.FileExists(path));
            fs.file(path,10);
            assertNotNull(fs.FileExists(path));
        } catch (BadFileNameException e) {
        } catch (OutOfSpaceException e) {
        }
    }

    @Test
    public void dirExists() {
        String[] path = {"root","shlomyar"};
        try {
            assertNull(fs.DirExists(path));
            fs.dir(path);
            assertNotNull(fs.DirExists(path));
        } catch (BadFileNameException e) {
        }
    }
}
package system;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TreeTest {

    FileSystemStub fileSystemStub;

    @Before
    public void initialize() {
        fileSystemStub = new FileSystemStub(1000);
    }

    @After
    public void erase() {
        fileSystemStub = null;
    }

    @Test
    public void getPath() {
    }

    @Test
    public void getChildByName() {
    }
}
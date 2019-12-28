package system;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeafTest {

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
    public void createLeaf() {
        Leaf leaf = null;
        try {
            leaf = new Leaf("yogev", 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(leaf);
    }

    @Test(expected = OutOfSpaceException.class)
    public void createLeafException() throws OutOfSpaceException {
        Leaf leaf = new Leaf("yogev", 100000);
    }

    @Test
    public void name() {
        try {
            Leaf leaf = new Leaf("yogev", 1);
            assertEquals(leaf.name, "yogev");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void size() {
        Leaf leaf;
        int leafSize = 1;
        try {
            leaf = new Leaf("yogev", leafSize);
            assertEquals(leaf.size, leafSize);
        } catch (OutOfSpaceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getPath() {
        Leaf leaf;
        String[] path = null;
        String[] expectedPath = {};
        try {
            leaf = new Leaf("yogev", 10);
            path = leaf.getPath();

        } catch (Exception e) {
            e.printStackTrace();
        }
        assertArrayEquals(path, expectedPath);
    }
}
package system;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeafTest {

    FileSystem fileSystem;

    @Before
    public void initialize() {
        fileSystem = new FileSystem(1000);
    }

    @After
    public void erase() {
        fileSystem = null;
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

    @Test
    public void name() {
        try {
            Leaf leaf = new Leaf("yogev",1);
            assertEquals(leaf.name, "yogev");
        } catch (Exception e) {
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
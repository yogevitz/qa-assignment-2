package system;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeafTest {

    FileSystem fileSystem = new FileSystem(100);

    @Before
    public void initialize() {
        fileSystem = new FileSystem(1000);
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
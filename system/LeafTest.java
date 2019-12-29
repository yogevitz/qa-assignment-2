package system;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
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

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"yogev", 10}, {"liad", -1}, {"hadar", 0}, {null, 10}, {"", 10}
        });
    }

    private String name;
    private int size;

    public LeafTest(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Test
    public void createLeaf() {
        String testName = name;
        int testSize = size;
        Leaf leaf = null;
        try {
            leaf = new Leaf(testName, testSize);
        } catch (Exception e) {
        }
        if (testSize >= 1 && testName != null && !(testName.equals(""))) {
            assertNotNull(leaf);
        } else {
            assertNull(leaf);
        }
    }

    @Test(expected = OutOfSpaceException.class)
    public void createLeafException() throws OutOfSpaceException {
        try {
            Leaf leaf = new Leaf("createLeafException", 100000);
        } catch (Exception e) {}
    }

    @Test
    public void updateName() {
        try {
            Leaf leaf = new Leaf("updateName", 1);
            assertEquals(leaf.name, "updateName");
        } catch (Exception e) {}
    }

    @Test
    public void updateSize() {
        Leaf leaf;
        int leafSize = 1;
        try {
            leaf = new Leaf("updateSize", leafSize);
            assertEquals(leaf.size, leafSize);
        } catch (OutOfSpaceException e) {
        } catch (Exception e) {
        }
    }

    @Test
    public void allocationsSize() {
        Leaf leaf = null;
        int leafSize = 1;
        try {
            leaf = new Leaf("allocationsSize", leafSize);
        } catch (OutOfSpaceException e) {
        } catch (Exception e) {
        }
        assertEquals(leaf.allocations.length, leafSize);
    }

    @Test
    public void memorySize() {
        Leaf leaf = null;
        int leafSize = 1;
        int memory;
        try {
            leaf = new Leaf("memorySize", leafSize);
        } catch (Exception e) {
        }
        for (int i = 0; i < leafSize; i++) {
            memory = leaf.allocations[i];
            assertEquals(leaf, fileSystem.fileStorage.getAlloc()[memory]);
        }
    }

    @Test
    public void getPath() {
        Leaf leaf;
        String[] path = null;
        String[] expectedPath = {};
        try {
            leaf = new Leaf("getPath", 10);
            path = leaf.getPath();

        } catch (Exception e) {
        }
        assertArrayEquals(path, expectedPath);
    }
}
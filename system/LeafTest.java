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

    FileSystemStub fileSystemStub;

    @Before
    public void initialize() {
        fileSystemStub = new FileSystemStub(1000);
    }

    @After
    public void erase() {
        fileSystemStub = null;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"yogev", 10}, {"liad", -1}, {"hadar", 0}, {"mor", 0.5}, {"amit", null}, {null, 10}
        });
    }
    private  String name;
    private  int size;
    public LeafTest(String name,int size){
        this.name=name;
        this.size=size;
    }
    @Test
    public void createLeaf() {
        Leaf leaf = null;
        try {
            leaf = new Leaf(name, size);
        } catch (Exception e) {
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
        }
    }

    @Test
    public void allocationsSize() {
        Leaf leaf = null;
        int leafSize = 1;
        try {
            leaf = new Leaf("yogev", leafSize);
        } catch (OutOfSpaceException e) {
        }
        assertEquals(leaf.allocations.length, leafSize);
    }

    @Test
    public void memorySize() {
        Leaf leaf;
        int leafSize = 1;
        int memory;
        try {
            leaf = new Leaf("yogev", leafSize);
            for (int i = 0; i < leafSize; i++) {
                memory = leaf.allocations[i];
                assertEquals(leaf, FileSystem.fileStorage.getAlloc()[memory]);
            }
        } catch (OutOfSpaceException e) {
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
        }
        assertArrayEquals(path, expectedPath);
    }
}
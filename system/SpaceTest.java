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
public class SpaceTest {

    FileSystem fileSystem;
    int fileSystemSpaceSize = 1000;

    @Before
    public void initialize() {
        fileSystem = new FileSystem(fileSystemSpaceSize);
    }

    @After
    public void erase() {
        fileSystem = null;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {5},{0},{-5}
        });
    }

    private int size;

    public SpaceTest(int size) {
        this.size = size;
    }

    @Test
    public void createSpace() {
        Space space = null;
        try {
            space = new Space(size);
        } catch (Exception e) {}
        if (size > 0) {
            assertNotNull(space);
        } else {
            assertNull("Size should be greater than 0", space);
        }
    }

    @Test
    public void alloc() {
        Space space;
        Leaf leaf;
        Leaf[] blocks;
        String name = "yogev";
        int size = 10;

        try {
            leaf = new Leaf(name, size);
            space = new Space(size);
            space.Alloc(size, leaf);
            blocks = space.getAlloc();
            for (int i = 0; i < leaf.allocations.length; i++) {
                assertEquals(blocks[leaf.allocations[i]], leaf);
            }
        } catch (Exception e) {}
    }

    @Test
    public void allocException() {
    }

    @Test
    public void dealloc() {
        Space space;
        Leaf leaf;
        String leafName = "leaf";
        try {
            space = new Space(100);
            leaf = new Leaf(leafName, 10);
            space.Dealloc(leaf);
            assertNull(space.getAlloc());
        } catch (Exception e) {}
    }

    @Test
    public void countFreeSpace() {
    }

    @Test
    public void getAlloc() {
    }
}
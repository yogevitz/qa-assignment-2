package system;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpaceTest {

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
    }

    @Test
    public void countFreeSpace() {
    }

    @Test
    public void getAlloc() {
    }
}
package system;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

public class TreeTest {

    FileSystem fileSystem;
    Tree trial;

    @Before
    public void initialize() {
        fileSystem = new FileSystem(1000);
    }

    @After
    public void erase() {
        fileSystem = null;
    }

    @Test
    public void createTree() {
        Tree tree = new Tree("createTree");
        assertNotNull(tree);
    }

    @Test
    public void updateName() {
        String name = "updateName";
        Tree tree = new Tree(name);
        assertEquals(tree.name, name);
    }

    @Test
    public void getPath() {
        String [] excepted= {"root", "liad", "yogev", "hadar", "rom"};
        String [] actual = {};
        try {
            fileSystem.dir(excepted);
            actual= fileSystem.DirExists(excepted).getPath();
        } catch (Exception e) {
        }
        assertEquals(excepted,actual);
    }

    @Test
    public void getChildByName() {
    }
}
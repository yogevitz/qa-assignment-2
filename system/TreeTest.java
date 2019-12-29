package system;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TreeTest {

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
    public void createTree() {
        Tree tree = new Tree("yogev");
        assertNotNull(tree);
    }

    @Test
    public void updateName() {
        String name = "yogev";
        Tree tree = new Tree(name);
        assertEquals(tree.name, name);
    }

    @Test
    public void getPath() {
    }

    @Test
    public void getChildByName() {
    }

    /*Test for Node*/
    public void updateParent(){

    }


    public void updateDepth(){

    }
}
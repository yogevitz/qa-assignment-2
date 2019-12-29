package system;

/**
 * system.Leaf - cannot have children.
 *
 * @author iain
 *
 */
public class Leaf extends Node {

    /** Size (in KB) of system.Leaf */
    public int size;
    /** Array of blocks containing system.Leaf data */
    public int[] allocations;

    /**
     * Ctor - create leaf.
     *
     * @param name Name of the leaf.
     * @param size Size, in KB, of the leaf.
     * @throws OutOfSpaceException Allocating space failed.
     */
    public Leaf(String name, int size) throws Exception {
        if (size >= 1 && name != null && !(name.equals(""))) {
            this.name = name;

            try {
                allocateSpace(size);
                this.size = size;
            } catch (Exception e) {
                throw new OutOfSpaceException();
            }
        }
        else{
            throw new Exception();
        }

    }

    private void allocateSpace(int size) throws OutOfSpaceException {

        FileSystem.fileStorage.Alloc(size, this);

    }

}
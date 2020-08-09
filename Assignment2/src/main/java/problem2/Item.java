package problem2;

/**
 * Item is a object that contains maximum width, maximum height, maximum depth of the item.
 */
public class Item {
    protected int maximumWidth;
    protected int maximumHeight;
    protected int maximumDepth;

    /**
     * Construct a item object with  maximum width, maximum height, maximum depth of the item.
     * @param maximumWidth - the  maximum width of a specific item.
     * @param maximumHeight- the  maximum height of a specific item.
     * @param maximumDepth- the  maximum depth of a specific item.
     * @throws Exception when the width/height/depth are invalid.
     */
    public Item(int maximumWidth, int maximumHeight, int maximumDepth) throws Exception{
        if (maximumWidth >= 1 && maximumHeight >= 1 && maximumDepth >= 1) {
            this.maximumWidth = maximumWidth;
            this.maximumHeight = maximumHeight;
            this.maximumDepth = maximumDepth;
        } else {
            throw new Exception("Invalid width/height/depth.");
        }
    }

    /**
     * Returns the maximum width of a specific item.
     * @return the maximum width of a specific item.
     */
    public int getMaximumWidth() {
        return this.maximumWidth;
    }

    /**
     * Returns the maximum height of a specific item.
     * @return the maximum height of a specific item.
     */
    public int getMaximumHeight() {
        return this.maximumHeight;
    }

    /**
     * Returns the maximum depth of a specific item.
     * @return the maximum depth of a specific item.
     */
    public int getMaximumDepth() {
        return this.maximumDepth;
    }
}

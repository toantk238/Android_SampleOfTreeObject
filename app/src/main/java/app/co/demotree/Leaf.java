package app.co.demotree;

/**
 * Created by FreeSky1102 on 9/17/2016.
 */
public class Leaf implements ILeaf {

    INode parentNode;

    @Override
    public INode getParent() {
        return parentNode;
    }

    @Override
    public void setParent(INode node) {
        this.parentNode = node;
    }
}

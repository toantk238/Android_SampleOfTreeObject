package app.co.demotree;

import com.google.gson.annotations.SerializedName;

/**
 * Created by FreeSky1102 on 9/17/2016.
 */
public class RootNode implements INode {

    @SerializedName("items")
    private ITreeItem[] items;

    @Override
    public ITreeItem[] getItems() {
        return items;
    }

    @Override
    public INode getParent() {
        // Root node does not have parent.
        return null;
    }

    @Override
    public void setParent(INode node) {
        // DO NOTHING
    }
}

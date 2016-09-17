package app.co.demotree;

import com.google.gson.annotations.SerializedName;

/**
 * Created by FreeSky1102 on 9/17/2016.
 */
public class Node implements INode {

    private INode parentNode;

    @SerializedName("child")
    private ITreeItem[] items;

    @Override
    public ITreeItem[] getItems() {
        return items;
    }

    @Override
    public INode getParent() {
        return parentNode;
    }

    @Override
    public void setParent(INode node) {
        this.parentNode = node;
    }
}

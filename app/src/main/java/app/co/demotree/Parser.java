package app.co.demotree;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;


public class Parser {

    private static final Gson GSON_PARSER;

    private Parser() {

    }

    static {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(ITreeItem.class, new TreeDeserializer());
        GSON_PARSER = builder.create();
    }

    public static RootNode parseIntoRootNode(String jsonString) {
        RootNode rootNode = GSON_PARSER.fromJson(jsonString, RootNode.class);
        setParentNodeForChildren(rootNode);
        return rootNode;
    }

    public static class TreeDeserializer implements JsonDeserializer<ITreeItem> {

        @Override
        public ITreeItem deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

            if (json == null) return null;

            String jsonString = json.toString();
            JsonObject jsonObject = json.getAsJsonObject();

            JsonElement typeElement = jsonObject.get("type");

            if (typeElement != null) {
                String type = typeElement.getAsString();

                if ("leaf".equals(type)) {
                    return GSON_PARSER.fromJson(jsonString, Leaf.class);
                } else if ("node".equals(type)) {
                    Node node = GSON_PARSER.fromJson(jsonString, Node.class);

                    setParentNodeForChildren(node);
                    return node;
                }
            }

            //Shouldn't reach here
            return null;
        }
    }

    private static void setParentNodeForChildren(INode node) {
        if (node == null) return;
        ITreeItem[] children = node.getItems();
        if (children == null || children.length < 1) return;
        for (ITreeItem child : children) {
            if (child != null)
                child.setParent(node);
        }
    }
}


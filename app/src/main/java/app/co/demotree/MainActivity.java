package app.co.demotree;

import android.os.Bundle;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(mParseRunnable).start();
    }

    private Runnable mParseRunnable = new Runnable() {
        @Override
        public void run() {
            Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);

            String data = "{\n" +
                    "  \"items\": [\n" +
                    "    {\n" +
                    "      \"id\": 1,\n" +
                    "      \"name\": \"Node 1\",\n" +
                    "      \"type\": \"node\",\n" +
                    "      \"child\": [\n" +
                    "        {\n" +
                    "          \"id\": 2,\n" +
                    "          \"name\": \"Leaf 1\",\n" +
                    "          \"type\": \"leaf\"\n" +
                    "        }\n" +
                    "      ]\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"id\": 3,\n" +
                    "      \"name\": \"Leaf 2\",\n" +
                    "      \"type\": \"leaf\"\n" +
                    "    }\n" +
                    "  ]\n" +
                    "}";

            RootNode rootNode = Parser.parseIntoRootNode(data);

            Log.d("App", "");
        }
    };
}

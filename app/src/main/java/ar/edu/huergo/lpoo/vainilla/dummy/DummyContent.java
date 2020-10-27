package ar.edu.huergo.lpoo.vainilla.dummy;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = 50;

    static {
        ITEMS.clear();

        String datos = "{  \"gustos\": [ "
                + " { \"nombre\": \"Menta Granizada\", \"estrellas\": 5.0  },"
                + " { \"nombre\": \"Menta Granizada\", \"estrellas\": 5.0  },"
                + " { \"nombre\": \"Menta Granizada\", \"estrellas\": 5.0  },"
                + " { \"nombre\": \"Menta Granizada\", \"estrellas\": 5.0  },"
                + " { \"nombre\": \"Menta Granizada\", \"estrellas\": 5.0  },"
                + " { \"nombre\": \"Menta Granizada\", \"estrellas\": 5.0  },"
                + " { \"nombre\": \"Menta Granizada\", \"estrellas\": 5.0  },"
                + " { \"nombre\": \"Menta Granizada\", \"estrellas\": 5.0  },"
                + " { \"nombre\": \"Menta Granizada\", \"estrellas\": 5.0  },"
                + " { \"nombre\": \"Menta Granizada\", \"estrellas\": 5.0  },"
                + " { \"nombre\": \"Dulce de Leche Granizado\", \"estrellas\": 4.5 }"
                + " ] }";

        JSONArray gustos;
        try {
            JSONObject obj = new JSONObject(datos);
            gustos = obj.getJSONArray("gustos");

            // Add some sample items.
            for (int i = 0; i < gustos.length(); i++) {
                //addItem(createDummyItem(i));
                JSONObject gusto = gustos.getJSONObject(i);
                Double estrellas = gusto.getDouble("estrellas");
                String nombre = gusto.getString("nombre");
                addItem(new DummyItem(
                        String.valueOf(estrellas),
                        nombre,
                        "sin detalles"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static DummyItem createDummyItem(int position) {
        return new DummyItem(
                String.valueOf(position),
                "Gusto de Helado #" + position,
                makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String id;
        public final String content;
        public final String details;

        public DummyItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
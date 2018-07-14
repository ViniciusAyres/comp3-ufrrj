package utils;

import java.sql.Timestamp;
import java.util.HashMap;

public class Row extends HashMap<String, Object> {
    private static final long serialVersionUID = 884220558870106730L;

    public int getInt(String column) {
        return (Integer) this.get(column);
    }

    public float getFloat(String column) {
        return (Float) this.get(column);
    }

    public boolean getBoolean(String column) {
        return (Boolean) this.get(column);
    }

    public String getString(String column) {
        return (String) this.get(column);
    }

    public Timestamp getTimestamp(String column) {
        return (Timestamp) this.get(column);
    }
}

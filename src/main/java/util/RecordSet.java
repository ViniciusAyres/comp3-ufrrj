package util;

import java.util.ArrayList;

public class RecordSet extends ArrayList<Row> {
    private static final long serialVersionUID = -5358156452541746165L;

    public int find(String column, Object value) {
        for (int i = 0; i < this.size(); ++i) {
            Object found = this.get(i).get(column);

            if (found == null) continue;

            if (found.equals(value)) {
                return i;
            }
        }

        return -1;
    }

    public RecordSet getWhere(String column, Object value) {
        RecordSet result = new RecordSet();

        for (int i = 0; i < this.size(); ++i) {
            Object found = this.get(i).get(column);

            if (found == null) continue;

            if (found.equals(value)) {
                result.add(this.get(i));
            }
        }

        return result;
    }

    public boolean contains(String column, Object value) {
        return this.find(column, value) != -1;
    }
}
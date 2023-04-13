package org.sheetstosql.models;

import java.util.ArrayList;
import java.util.List;

public class SheetData {
    private ArrayList<String> headers;
    private List<List<String>> data;

    public ArrayList<String> getHeaders() {
        return headers;
    }

    public void setHeaders(ArrayList<String> headers) {
        this.headers = headers;
    }

    public List<List<String>> getData() {
        return data;
    }

    public void setData(List<List<String>> data) {
        this.data = data;
    }
}

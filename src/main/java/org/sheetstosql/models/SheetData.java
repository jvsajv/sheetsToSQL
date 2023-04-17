package org.sheetstosql.models;

import java.util.ArrayList;
import java.util.List;

public class SheetData {
    private List<String> headers;
    private List<List<String>> data;

    public List<String> getHeaders() {
        return headers;
    }

    public void setHeaders(List<String> headers) {
        this.headers = headers;
    }

    public List<List<String>> getData() {
        return data;
    }

    public void setData(List<List<String>> data) {
        this.data = data;
    }
}

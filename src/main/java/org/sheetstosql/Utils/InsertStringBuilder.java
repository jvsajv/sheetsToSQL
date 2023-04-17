package org.sheetstosql.Utils;

import org.sheetstosql.models.SheetData;

import java.util.List;

public class InsertStringBuilder {
    public String singleLineInsert(String tableName, SheetData sheetData){
        java.lang.StringBuilder inputString = new java.lang.StringBuilder("INSERT INTO " + tableName + '(');

        List<String> headers = sheetData.getHeaders();
        List<List<String>> data = sheetData.getData();

        for(String column : headers){
            inputString.append("'").append(column).append("'");
            if(!column.equals(headers.get(headers.size()-1))){
                inputString.append(",");
            }
        }

        inputString.append(")\nVALUES\n\t");
        for(List<String> row : data){
            inputString.append("(");
            for(String value : row) {
                inputString.append("'").append(value).append("'");
                if(!value.equals(row.get(row.size()-1))){
                    inputString.append(",");
                }
            }
            inputString.append(")");
            if(!row.equals(data.get(data.size()-1))){
                inputString.append(",\n\t");
            } else {
                inputString.append(";");
            }
        }
        return inputString.toString();
    }

    public String multipleLinesInsert(String tableName, SheetData sheetData){
        StringBuilder initialtring = new StringBuilder("INSERT INTO " + tableName + '(');

        List<String> headers = sheetData.getHeaders();
        List<List<String>> data = sheetData.getData();

        for(String column : headers){
            initialtring.append("'").append(column).append("'");
            if(!column.equals(headers.get(headers.size()-1))){
                initialtring.append(",");
            }
        }

        initialtring.append(") VALUES ");
        StringBuilder fullString = new StringBuilder();
        for(List<String> row : data){
            fullString.append(initialtring);
            fullString.append("(");
            for(String value : row) {
                fullString.append("'").append(value).append("'");
                if(!value.equals(row.get(row.size()-1))){
                    fullString.append(",");
                }
            }
            fullString.append(")");
            if(!row.equals(data.get(data.size()-1))){
                fullString.append(";\n");
            } else {
                fullString.append(";\n");
            }
        }
        return fullString.toString();
    }
}

package org.sheetstosql.Utils;

import org.apache.poi.ss.usermodel.*;
import org.sheetstosql.models.SheetData;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SheetProcessor {

    public SheetData processSheetIntoData(File file) throws Exception {
        SheetData sheetData = new SheetData();

        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheetAt(0);

        sheetData.setHeaders(processHeaders(sheet));
        sheetData.setData(processData(sheet));

        return sheetData;
    }

    public List<String> processHeaders(Sheet sheet){
        List<String> headers = new ArrayList<>();

        for(Cell cell : sheet.getRow(0)){
            if (cell.getCellType() != CellType.BLANK) {
                headers.add(cell.toString());
            }
        }

        return headers;
    }

    public List<List<String>> processData(Sheet sheet){
        List<List<String>> data = new ArrayList<>();

        sheet.removeRow(sheet.getRow(0));

        for(Row row : sheet){
            List<String> stringList = new ArrayList<>();
            for(Cell cell : row){
                if (cell.getCellType() != CellType.BLANK) {
                    stringList.add(cell.toString());
                }
            }
            data.add(stringList);
        }
        return data;
    }
}

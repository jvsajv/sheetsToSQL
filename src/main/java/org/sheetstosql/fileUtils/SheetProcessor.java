package org.sheetstosql.fileUtils;

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

        ArrayList<String> headers = new ArrayList<>();

        for(Cell cell : sheet.getRow(0)){
            if (cell.getCellType() != CellType.BLANK) {
                headers.add(cell.toString());
            }
        }

        sheet.removeRow(sheet.getRow(0));

        List<List<String>> data = new ArrayList<>();

        for(Row row : sheet){
            List<String> stringList = new ArrayList<>();
            for(Cell cell : row){
                if (cell.getCellType() != CellType.BLANK) {
                    stringList.add(cell.toString());
                }
            }
            data.add(stringList);
        }

        sheetData.setHeaders(headers);
        sheetData.setData(data);

        return sheetData;
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pago_boletos;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.IOException;
/**
 *
 * @author luis
 */
public class cvs_Import {  

public void importar_Archivo(String path) throws IOException, InvalidFormatException {

        // Creating a Workbook from an Excel file (.xls or .xlsx)
        Workbook workbook = WorkbookFactory.create(new File(path));

        // Getting the Sheet at index zero
        Sheet sheet = workbook.getSheetAt(0);

        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();
        int x = sheet.getLastRowNum();
        for(int e = 0; e <= x; e++){
            for(int i = 0; i < 5; i++){
                String cellValue = dataFormatter.formatCellValue(sheet.getRow(e).getCell(i));
                sheet.getColumnBreaks();
                if(i != 2){
                    System.out.print(cellValue + "\t");
                }
            }
            System.out.println();
        }
        workbook.close();
    }
    
}

package Utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Excel_read_data
    {
        public static List<Map<String, String>> getTestData(String filePath, String sheetName) throws IOException
        {
            List<Map<String, String>> data = new ArrayList<>();
            FileInputStream fis = null;
            Workbook workbook = null;

            try {
                File file = new File(filePath);
                if (!file.exists()) {
                    System.out.println("Excel file not found at: " + filePath);
                    return data;
                }
                fis = new FileInputStream(file);
                workbook = new XSSFWorkbook(fis);
                Sheet sheet = workbook.getSheet(sheetName);

                if (sheet == null) {
                    System.out.println("Sheet '" + sheetName + "' not found in the Excel file.");
                    return data;            // Return empty list if sheet doesn't exist
                }

                Row headerRow = sheet.getRow(0);            // Get header row
                if (headerRow == null) {
                    System.err.println("Header row not found in sheet '" + sheetName + "'.");
                    return data;
                }

                List<String> headers = new ArrayList<>();
                for (Cell cell : headerRow) {
                    headers.add(getCellValueAsString(cell));
                }

                for (int i = 1; i <= sheet.getLastRowNum(); i++)      // Iterate over rows starting from the second row (data rows)
                {
                    Row currentRow = sheet.getRow(i);
                    if (currentRow == null) {
                        continue; // Skip empty rows
                    }

                    Map<String, String> rowData = new LinkedHashMap<>();
                    for (int j = 0; j < headers.size(); j++) {
                        Cell cell = currentRow.getCell(j);
                        rowData.put(headers.get(j), getCellValueAsString(cell));        // Key: Value
                    }
                    data.add(rowData);
                }
            }
            finally {
                if (workbook != null) {
                    workbook.close();
                }
                if (fis != null) {
                    fis.close();
                }
            }
            return data;
        }


        private static String getCellValueAsString(Cell cell) {
            if (cell == null) {
                return "";
            }
            switch (cell.getCellType()) {
                case STRING:
                    return cell.getStringCellValue();
                case NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        return cell.getDateCellValue().toString(); // Or format as needed
                    } else {
                        // For numeric values, convert to String without trailing .0 if it's an integer
                        double numericValue = cell.getNumericCellValue();
                        if (numericValue == (long) numericValue) {
                            return String.valueOf((long) numericValue);
                        } else {
                            return String.valueOf(numericValue);
                        }
                    }
                case BOOLEAN:
                    return String.valueOf(cell.getBooleanCellValue());
                case FORMULA:
                    return cell.getCellFormula(); // Or evaluate formula if needed
                case BLANK:
                    return "";
                default:
                    return "";
            }
        }
    }



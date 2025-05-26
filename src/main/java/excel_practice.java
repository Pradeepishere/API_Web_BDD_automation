import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class excel_practice
{
    public static void main(String[] args)
    {
         //    The first row is considered as headers.
         //    A List of Maps, where each Map represents a row and contains column headers as keys and cell values as values.

        String filepath = "src/test/java/resources/Test_Data/excel_data.xlsx";
        String sheet_Name = "RegisterUser";

        List<Map<String, String>> testData = null;
        try {
            testData = getTestData(filepath,sheet_Name);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (testData.isEmpty()) {
                throw new RuntimeException("No test data found in Excel file: " + filepath + " sheet: " + sheet_Name);
            }

        Map<String, String> currentRowData = testData.get(0);

        String name = currentRowData.get("Name");
        String email = currentRowData.get("Email");

        System.out.println(name);
        System.out.println(email);

    }
    public static List<Map<String, String>> getTestData(String filePath, String sheetName) throws IOException {
        List<Map<String, String>> data = new ArrayList<>();
        FileInputStream fis = null;
        Workbook workbook = null;

        try {
            File file = new File(filePath);
            if (!file.exists()) {
                System.err.println("Excel file not found at: " + filePath);
                return data;
            }

            fis = new FileInputStream(file);
            workbook = new XSSFWorkbook(fis); // For .xlsx files
            Sheet sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                System.err.println("Sheet '" + sheetName + "' not found in the Excel file.");
                return data; // Return empty list if sheet doesn't exist
            }

            // Get header row
            Row headerRow = sheet.getRow(0);
            if (headerRow == null) {
                System.err.println("Header row not found in sheet '" + sheetName + "'.");
                return data;
            }

            List<String> headers = new ArrayList<>();
            for (Cell cell : headerRow) {
                headers.add(getCellValueAsString(cell));
            }

            // Iterate over rows starting from the second row (data rows)
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row currentRow = sheet.getRow(i);
                if (currentRow == null) {
                    continue; // Skip empty rows
                }

                Map<String, String> rowData = new LinkedHashMap<>();
                for (int j = 0; j < headers.size(); j++) {
                    Cell cell = currentRow.getCell(j);
                    rowData.put(headers.get(j), getCellValueAsString(cell));
                }
                data.add(rowData);
            }
        } finally {
            if (workbook != null) {
                workbook.close();
            }
            if (fis != null) {
                fis.close();
            }
        }
        return data;
    }

    /**
     * Helper method to get cell value as String, handling different cell types.
     *
     * @param cell The cell to get the value from.
     * @return The cell value as a String, or an empty string if the cell is null or blank.
     */
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

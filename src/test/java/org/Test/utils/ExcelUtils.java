package org.Test.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ExcelUtils {

    public static final String FILE_PATH_EXCEL_SHEET = "src/test/resources/APILIST.xlsx";

    // Path to the Excel file containing data
    public static final String FILE_PATH_EXCEL_SHEET_TEST = "src/test/resources/brandsData.xlsx";

    // Domain URL and GraphQL Path used to generate URLs
    public static final String DOMAIN_NAME_AND_GRAPHQL_PATH = "https://breadmobileapp.breadfinancial.com/graphql/execute.json/breadmobile/subCapabilityByPath;path=/content/dam/breadmobile/us/en/";

    private static Workbook workbook;

    /**
     * Reads data from a specified column in an Excel sheet starting from row 2.
     *
     * @param filePath   The path to the Excel file.
     * @param sheetName  The name of the sheet to read from.
     * @param columnName The name of the column to extract data from.
     * @return A list of cell values from the specified column.
     * @throws IOException if the file cannot be read.
     */
    public static List<String> readDataFromColumn(String filePath, String sheetName, String columnName) throws IOException {
        List<String> columnData = new ArrayList<>();

        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new IllegalArgumentException("Sheet " + sheetName + " does not exist in the Excel file.");
            }

            // Get the header row (assumed to be the first row)
            Row headerRow = sheet.getRow(0);
            if (headerRow == null) {
                throw new IllegalArgumentException("The sheet " + sheetName + " does not have a header row.");
            }

            // Find the index of the specified column
            Integer columnIndex = null;
            for (Cell cell : headerRow) {
                if (columnName.equals(getCellValueAsString(cell))) {
                    columnIndex = cell.getColumnIndex();
                    break;
                }
            }

            if (columnIndex == null) {
                throw new IllegalArgumentException("Column " + columnName + " does not exist in the Excel sheet.");
            }

            // Start reading from row 2 (index 1)
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    Cell cell = row.getCell(columnIndex);
                    columnData.add(getCellValueAsString(cell));
                }
            }
        }

        return columnData;
    }

    /**
     * Converts a cell value to a string.
     *
     * @param cell The cell to convert.
     * @return The cell value as a string.
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
                    return cell.getDateCellValue().toString();
                } else {
                    return String.valueOf(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return "";
            default:
                return "Unknown Type";
        }
    }

    public static List<String>  FetchtheListfromExcelsheetByColumnName(String sheetName, String columnName){
        List<String> columnData = null;
        try {
            columnData = ExcelUtils.readDataFromColumn(FILE_PATH_EXCEL_SHEET, sheetName, columnName);
//            Print the data from the specified column
//            for (String cellValue : columnData) {
//                System.out.println(cellValue);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  columnData;
    }

    public static Map<String, String> fetchSubCapability(String sheetName) throws IOException {
        // Open Excel file
        FileInputStream fileInputStream = new FileInputStream(FILE_PATH_EXCEL_SHEET_TEST);
        workbook = new XSSFWorkbook(fileInputStream);

        // Get the specified sheet
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            throw new IllegalArgumentException("Sheet not found: " + sheetName);
        }

        // Fetch the header row (first row) with column names
        Row headerRow = sheet.getRow(0);
        if (headerRow == null) {
            throw new IllegalArgumentException("Header row missing in the sheet.");
        }

        // Fetch the second row which contains the actual sub-capability data
        Row dataRow = sheet.getRow(1);
        if (dataRow == null) {
            throw new IllegalArgumentException("Data row missing in the sheet.");
        }

        // Prepare a map to store sub-cap-name and sub-cap-path
        Map<String, String> subCapabilities = new HashMap<>();

        for (int rowIndex = 0; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
            Row row = sheet.getRow(rowIndex);

            if (row != null) {
                // Assuming column A is sub-cap-name and column B is sub-cap-path
                Cell subCapNameCell = row.getCell(0); // Column A
                Cell subCapPathCell = row.getCell(1); // Column B

                if (subCapNameCell != null && subCapPathCell != null) {
                    String subCapName = subCapNameCell.getStringCellValue().trim();
                    String subCapPath = subCapPathCell.getStringCellValue().trim();

                    // Store the sub-cap-name and sub-cap-path in the map
                    subCapabilities.put(subCapName, subCapPath);
                }
            }
        }


        return subCapabilities;  // Returns a map with sub-cap-name and sub-cap-path
    }

    /**
     * This method fetches dynamic brand names from a specified sheet.
     * It reads from the second row onward, assuming that the first row is a header.
     * Each row is expected to have a brand name in the first column.
     *
     * @param sheetName the name of the sheet to read from (e.g., "Sheet1").
     * @return a list of brand names as Strings.
     */
    public static List<String> fetchBrandNames(String sheetName) {
        List<String> brandNames = new ArrayList<>();

        // Get the specified sheet by name
        Sheet sheet = workbook.getSheet(sheetName);

        if (sheet != null) {
            // Iterate over rows starting from index 1 (second row)
            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                if (row != null) {
                    Cell brandCell = row.getCell(0); // Assuming first column contains brand names

                    // Ensure the cell is a string and non-empty
                    if (brandCell != null && brandCell.getCellType() == CellType.STRING) {
                        String brandName = brandCell.getStringCellValue().trim();
                        if (!brandName.isEmpty()) {
                            brandNames.add(brandName);
                        }
                    }
                }
            }
        }

        return brandNames;
    }

    /**
     * This method generates URLs for each brand based on the sub-capability and brand names.
     * It calls fetchSubCapability() to get the specific sub-capability from "Sheet2".
     * It then calls fetchBrandNames() to get the dynamic brand names from "Sheet1".
     * Finally, it combines these into complete URLs.
     *
     * @param subCapabilityColumnName the column name to retrieve the sub-capability from.
     * @return a list of generated URLs.
     */
    public static List<String> getSubCapabilityFromExcelAndGeneratesURLS(String subCapabilityColumnName) {
        // Step 1: Fetch sub-capability map containing sub-cap-name and sub-cap-path
        Map<String, String> subCapabilities = null;
        try {
            subCapabilities = fetchSubCapability("Sheet3");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // If the sub-capability map doesn't contain the expected column, throw an exception
        if (!subCapabilities.containsKey(subCapabilityColumnName)) {
            throw new IllegalArgumentException("Sub-capability column not found: " + subCapabilityColumnName);
        }

        // Retrieve the specific sub-capability path
        String subCapabilityPath = subCapabilities.get(subCapabilityColumnName);

        // Step 2: Fetch brand names from Sheet1
        List<String> brandNames = fetchBrandNames("Sheet1");

        // Step 3: Generate URLs
        List<String> urls = new ArrayList<>();
        for (String brandName : brandNames) {
            // Create URL by combining the domain, brand, and sub-capability
            String url = DOMAIN_NAME_AND_GRAPHQL_PATH + brandName + subCapabilityPath;
            urls.add(url);
        }
        TestCaseUtils.writeListToFile(urls);
        return urls;
    }

    /**
     * Closes the workbook to release resources.
     *
     * @throws IOException if an error occurs while closing the workbook.
     */
    public void close() throws IOException {
        if (workbook != null) {
            workbook.close();
        }
    }


    public static List<String> getSubCapabilityFromExcelAndGeneratesURLSOn(String brandName) {
        // Step 1: Fetch sub-capability map containing sub-cap-name and sub-cap-path
        Map<String, String> subCapabilities = null;
        try {
            subCapabilities = fetchSubCapability("Sheet3");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Step 3: Generate URLs
        List<String> urls = new ArrayList<>();
        for (HashMap.Entry<String, String> entry : subCapabilities.entrySet()) {

        String url = "";
            // Check if the brandName is "brand_copy"
            if ("brand_copy".equals(brandName)) {
                // Special URL format for brand_copy
                url = "https://breadmobileapp.breadfinancial.com/graphql/execute.json/breadmobile/subCapabilityByPath;path=/content/dam/breadmobile/language-masters/en/" + brandName + entry.getValue();
            } else {
                // Default URL format for other brand names
                url = DOMAIN_NAME_AND_GRAPHQL_PATH + brandName + entry.getValue();
            }
            urls.add(url);
        }
        TestCaseUtils.writeListToFile(urls);
        return urls;
    }
}

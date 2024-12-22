package org.Test.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtilsImprove {

    // Domain URL and GraphQL Path used to generate URLs
    public static final String DOMAIN_NAME_AND_GRAPHQL_PATH = "https://breadmobileapp.breadfinancial.com/graphql/execute.json/breadmobile/subCapabilityByPath;path=/content/dam/breadmobile/us/en/";

    // Path to the Excel file containing data
    public static final String FILE_PATH_EXCEL_SHEET = "src/test/resources/brandsData.xlsx";

    private static Workbook workbook;

    /**
     * This method fetches sub-capability data from "Sheet2" which contains
     * two rows: the first row holds the column names, and the second row holds the actual data.
     * The data is returned as a map where the keys are the column names (e.g., "sub-cap-name")
     * and the values are the corresponding values from the second row (e.g., "/path/to/sub-capability").
     *
     * @param sheetName the name of the sheet to read from (e.g., "Sheet2").
     * @return a map containing sub-cap-name and sub-cap-path.
     * @throws IOException if the file is not found or an error occurs while reading.
     */
    public static Map<String, String> fetchSubCapability(String sheetName) throws IOException {
        // Open Excel file
        FileInputStream fileInputStream = new FileInputStream(FILE_PATH_EXCEL_SHEET);
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
    public static List<String> generateUrls(String subCapabilityColumnName) {
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
}

package core.basesyntax;

public class SalaryInfo {
    public String getSalaryInfo(String[] names, String[] data, String dateFrom, String dateTo) {

        String[] fromParts = dateFrom.split("\\.");
        int fromDate = Integer.parseInt(fromParts[2] + fromParts[1] + fromParts[0]);

        String[] toParts = dateTo.split("\\.");
        int toDate = Integer.parseInt(toParts[2] + toParts[1] + toParts[0]);

        int[] salary = new int [names.length];

        StringBuilder report = new StringBuilder("Report for period " + dateFrom + " - " + dateTo);

        for (String name : names) {
            int salaryInt = 0;

            for (String record : data) {
                String[] parts = record.split("\\s+");

                String[] recordDateParts = parts[0].split("\\.");
                int recordDate = Integer.parseInt(recordDateParts[2]
                        + recordDateParts[1] + recordDateParts[0]);

                String recordName = parts[1];
                int hours = Integer.parseInt(parts[2]);
                int rate = Integer.parseInt(parts[3]);

                if (recordName.equals(name) && recordDate >= fromDate && recordDate <= toDate) {
                    salaryInt += hours * rate;
                }
            }
            report.append(System.lineSeparator()).append(name).append(" - ").append(salaryInt);
        }
        return report.toString();
    }
}

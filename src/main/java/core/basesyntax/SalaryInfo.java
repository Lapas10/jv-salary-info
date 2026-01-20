package core.basesyntax;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SalaryInfo {
    public String getSalaryInfo(String[] names, String[] data, String dateFrom, String dateTo) {
        final int dateIdx = 0;
        final int nameIdx = 1;
        final int hoursIdx = 2;
        final int rateIdx = 3;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate fromDate = LocalDate.parse(dateFrom, formatter);
        LocalDate toDate = LocalDate.parse(dateTo, formatter);

        StringBuilder report = new StringBuilder("Report for period " + dateFrom + " - " + dateTo);

        for (String name : names) {
            int salaryInt = 0;

            for (String record : data) {
                String[] parts = record.split("\\s+");
                LocalDate recordDate = LocalDate.parse(parts[dateIdx], formatter);

                int hours = Integer.parseInt(parts[hoursIdx]);
                int rate = Integer.parseInt(parts[rateIdx]);

                if (parts[nameIdx].equals(name)
                        && !recordDate.isBefore(fromDate)
                        && !recordDate.isAfter(toDate)) {
                    salaryInt += hours * rate;
                }
            }
            report.append(System.lineSeparator()).append(name).append(" - ").append(salaryInt);
        }
        return report.toString();
    }
}

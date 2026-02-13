package core.basesyntax;

import java.time.LocalDate;

public class SalaryInfo {
    private static final DateUtils util = new DateUtils();

    public String getSalaryInfo(String[] names, String[] data, String dateFrom, String dateTo) {
        StringBuilder builder = new StringBuilder();
        LocalDate from = util.convertString(dateFrom);
        LocalDate to = util.convertString(dateTo);
        int[] salaries = new int[names.length];

        builder.append("Report for period ")
                .append(from.format(util.getFormatter()))
                .append(" - ")
                .append(to.format(util.getFormatter()))
                .append(System.lineSeparator());

        for (String filteredEntry : data) {
            Entry entry = new Entry(filteredEntry);
            if (!entry.getDate().isBefore(from) && !entry.getDate().isAfter(to)) {
                for (int j = 0; j < names.length; j++) {
                    if (entry.getName().equals(names[j])) {
                        salaries[j] += entry.getSalary() * entry.getHours();
                    }
                }
            }
        }

        for (int i = 0; i < names.length; i++) {
            if (i < names.length - 1) {
                builder.append(names[i])
                        .append(" - ")
                        .append(salaries[i])
                        .append(System.lineSeparator());
            } else {
                builder.append(names[i])
                        .append(" - ")
                        .append(salaries[i]);
            }
        }
        return builder.toString();
    }
}

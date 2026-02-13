package core.basesyntax;

import java.time.LocalDate;

public class Entry {
    private static final DateUtils utils = new DateUtils();

    private final LocalDate date;
    private final String name;
    private final int hours;
    private final int salary;

    public Entry(String line) {
        String[] parts = line.split(" ");
        this.date = utils.convertString(parts[0]);
        this.name = parts[1];
        this.hours = Integer.parseInt(parts[2]);
        this.salary = Integer.parseInt(parts[3]);
    }

    public LocalDate getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public int getHours() {
        return hours;
    }

    public int getSalary() {
        return salary;
    }
}

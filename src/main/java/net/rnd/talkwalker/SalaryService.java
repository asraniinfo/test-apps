package net.rnd.talkwalker;

import java.util.Date;

public class SalaryService {
    public enum Type { STUDENT, ENGINEER }

    public Double calculateSalary(Type t, Double rate) {
        if (t.equals(Type.STUDENT)) {
            return 0.5 * rate;
        } else if (t.equals(Type.ENGINEER)) {
            return 1.1 * rate;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int calculateWorkingTime(Type t) {
        if (t.equals(Type.STUDENT)) {
            return 4;
        } else if (t.equals(Type.ENGINEER)) {
            return 8;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Double calculateBonuses(Type t) {
        if (t.equals(Type.STUDENT)) {
            return 100.0;
        } else if (t.equals(Type.ENGINEER)) {
            return 1000.0;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean isValid(int cage, int type, Integer pi, int room, Date executionDate, Integer roomAssistant,
                           boolean isExecuted) {
        return cage > 0 && type >= 10 && pi != null && room > 0 && executionDate != null && roomAssistant != null
                && !isExecuted;
    }

}

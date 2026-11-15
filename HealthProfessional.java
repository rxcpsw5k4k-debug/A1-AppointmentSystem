import java.util.ArrayList;
import java.util.List;

public abstract class HealthProfessional {
    private int professionalId;
    private String fullName;
    private List<String> workDays;

    public HealthProfessional(int id, String name, List<String> days) {
        this.professionalId = id;
        this.fullName = name;
        this.workDays = new ArrayList<>(days);
    }

    public int getProfessionalId() {
        return professionalId;
    }

    public String getFullName() {
        return fullName;
    }

    public List<String> getWorkDays() {
        return new ArrayList<>(workDays);
    }

    public abstract String getRoleDescription();

    @Override
    public String toString() {
        return "ID: " + professionalId + " | Name: " + fullName + " | Job Type: " + getRoleDescription()
                + " | Working days: " + workDays;
    }
}

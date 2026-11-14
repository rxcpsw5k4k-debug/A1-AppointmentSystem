import java.util.ArrayList;
import java.util.List;

/**
 * Abstract base class for all health professionals
 * Part 1 assessment brief
 * Shared attributes for every health worker
 */
public abstract class HealthProfessional {
    private int professionalId; // only numbers as required
    private String fullName;
    private List<String> availableWeekDays; // e.g. "Monday","Wednesday"

    /**
     * Full constructor
     * @param id numeric id
     * @param name full name
     * @param days list of working weekdays
     */
    public HealthProfessional(int id, String name, List<String> days){
        this.professionalId = id;
        this.fullName = name;
        // create new list so we don't share reference with outside code
        this.availableWeekDays = new ArrayList<>(days);
    }

    // getters only, NO setters, avoid object become invalid state (encapsulation)
    public int getProfessionalId() {
        return professionalId;
    }

    public String getFullName() {
        return fullName;
    }

    public List<String> getAvailableWeekDays() {
        // return copy, prevent external modify original list
        return new ArrayList<>(availableWeekDays);
    }

    // abstract method: every subclass must implement to show their own details
    public abstract String getRoleDescription();

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(professionalId);
        sb.append(" | Name: ").append(fullName);
        sb.append(" | Role: ").append(getRoleDescription());
        sb.append(" | Working days: ").append(availableWeekDays);
        return sb.toString();
    }
}

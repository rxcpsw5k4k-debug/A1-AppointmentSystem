import java.util.List;

/**
 * Specialist doctor Part 2
 * has specific medical specialty field
 */
public class Specialist extends HealthProfessional{
    private String specialtyField;

    public Specialist(int id, String name, List<String> workDays, String specialty){
        super(id,name,workDays);
        this.specialtyField = specialty;
    }

    public String getSpecialtyField(){
        return specialtyField;
    }

    @Override
    public String getRoleDescription() {
        return "Specialist Doctor";
    }

    @Override
    public String toString(){
        String base = super.toString();
        return base + " | Speciality area: " + specialtyField;
    }
}

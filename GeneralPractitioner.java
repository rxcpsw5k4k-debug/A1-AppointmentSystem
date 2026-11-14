import java.util.List;

/**
 * General Practitioner subclass, Part 2
 * GP can do general consultations, can write prescriptions
 */
public class GeneralPractitioner extends HealthProfessional{
    private boolean canPrescribeMedicine;

    public GeneralPractitioner(int id, String name, List<String> workDays, boolean prescribeRights){
        super(id, name, workDays); // call parent abstract class constructor
        this.canPrescribeMedicine = prescribeRights;
    }

    // overload constructor: default can prescribe true
    public GeneralPractitioner(int id, String name, List<String> workDays){
        super(id,name,workDays);
        this.canPrescribeMedicine = true;
    }

    public boolean getCanPrescribeMedicine(){
        return canPrescribeMedicine;
    }

    @Override
    public String getRoleDescription() {
        return "General Practitioner (GP)";
    }

    @Override
    public String toString(){
        String parentText = super.toString();
        String extraInfo = " | Can prescribe medicine: " + canPrescribeMedicine;
        return parentText + extraInfo;
    }
}

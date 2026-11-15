import java.util.List;

public class GeneralPractitioner extends HealthProfessional{
    private boolean canPrescribeMedicine;

    public GeneralPractitioner(int id, String name, List<String> workDays, boolean prescribeRights){
        super(id, name, workDays);
        this.canPrescribeMedicine = prescribeRights;
    }

    public GeneralPractitioner(int id, String name, List<String> workDays){
        super(id, name, workDays);
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
        return super.toString() + " | Can prescribe medicine: " + canPrescribeMedicine;
    }
}

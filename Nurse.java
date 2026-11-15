import java.util.List;

public class Nurse extends HealthProfessional{
    private boolean canTakeBloodSample;

    public Nurse(int id, String name, List<String> workDays, boolean bloodWork){
        super(id, name, workDays);
        this.canTakeBloodSample = bloodWork;
    }

    public Nurse(int id, String name, List<String> workDays){
        super(id, name, workDays);
        this.canTakeBloodSample = true;
    }

    public boolean isCanTakeBloodSample(){
        return canTakeBloodSample;
    }

    @Override
    public String getRoleDescription() {
        return "Registered Nurse";
    }

    @Override
    public String toString(){
        return super.toString() + " | Able to take blood sample: " + canTakeBloodSample;
    }
}

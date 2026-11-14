import java.util.List;

/**
 * Nurse health professional Part2
 * can take blood sample as unique behaviour
 */
public class Nurse extends HealthProfessional{
    private boolean canTakeBloodSample;

    public Nurse(int id, String name, List<String> days, boolean bloodWork){
        super(id,name,days);
        this.canTakeBloodSample = bloodWork;
    }

    // overload default constructor
    public Nurse(int id, String name, List<String> days){
        super(id,name,days);
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
        String s = super.toString();
        return s + " | Able to take blood sample: " + canTakeBloodSample;
    }
}

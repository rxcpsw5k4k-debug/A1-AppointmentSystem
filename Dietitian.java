import java.util.List;

public class Dietitian extends HealthProfessional{
    private String focusArea;

    public Dietitian(int id, String name, List<String> workDays, String focus){
        super(id, name, workDays);
        this.focusArea = focus;
    }

    public String getFocusArea(){
        return focusArea;
    }

    @Override
    public String getRoleDescription() {
        return "Dietitian Nutritionist";
    }

    @Override
    public String toString(){
        return super.toString() + " | Nutrition focus: " + focusArea;
    }
}

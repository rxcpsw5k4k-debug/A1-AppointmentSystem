import java.util.List;

/**
 * Dietitian Part 2, fourth distinct health professional type
 */
public class Dietitian extends HealthProfessional{
    private String focusArea; // e.g. weight management, diabetes nutrition

    public Dietitian(int id, String name, List<String> days, String focus){
        super(id,name,days);
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

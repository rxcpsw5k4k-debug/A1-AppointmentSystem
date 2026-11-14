/**
 * Appointment class Part4
 * Holds patient info, linked health professional, time for today only
 * implements Comparable for sorting appointments by time
 */
public class Appointment implements Comparable<Appointment>{
    private String patientName;
    private String patientMobile;
    private HealthProfessional assignedProfessional;
    private String timeSlot; // format "HH:mm", clinic slots 08:00‑16:00 every 30min

    /**
     * Appointment constructor
     * @param pName patient full name
     * @param pMobile patient contact number
     * @param hp linked health professional object
     * @param slot time like "09:30"
     */
    public Appointment(String pName, String pMobile, HealthProfessional hp, String slot){
        // simple validation: cannot create incomplete appointment
        if(pName == null || pName.isBlank()){
            throw new IllegalArgumentException("Patient name can not be empty");
        }
        if(pMobile == null || pMobile.isBlank()){
            throw new IllegalArgumentException("Patient mobile required");
        }
        if(hp == null){
            throw new IllegalArgumentException("Must select a health professional");
        }
        if(slot == null || slot.isBlank()){
            throw new IllegalArgumentException("Time slot cannot be blank");
        }
        this.patientName = pName;
        this.patientMobile = pMobile;
        this.assignedProfessional = hp;
        this.timeSlot = slot;
    }

    // getters
    public String getPatientName() {
        return patientName;
    }
    public String getPatientMobile() {
        return patientMobile;
    }
    public HealthProfessional getAssignedProfessional() {
        return assignedProfessional;
    }
    public String getTimeSlot() {
        return timeSlot;
    }

    /**
     * compareTo for sorting by time slot (Comparable interface requirement)
     */
    @Override
    public int compareTo(Appointment otherAppointment) {
        return this.timeSlot.compareTo(otherAppointment.timeSlot);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("==== Appointment ====\n");
        sb.append("Patient Name: ").append(patientName).append("\n");
        sb.append("Patient Mobile: ").append(patientMobile).append("\n");
        sb.append("Appointment Time (today): ").append(timeSlot).append("\n");
        sb.append("Assigned Health Worker -> ").append(assignedProfessional.toString()).append("\n");
        return sb.toString();
    }
}

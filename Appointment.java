public class Appointment implements Comparable<Appointment>{
    private String patientName;
    private String patientPhone;
    private HealthProfessional selectedWorker;
    private String timeSlot; 

    
    public Appointment(String pName, String pPhone, HealthProfessional worker, String slot){
        if(pName == null || pName.isBlank()){
            throw new IllegalArgumentException("Patient name cannot be empty");
        }
        if(pPhone == null || pPhone.isBlank()){
            throw new IllegalArgumentException("Patient phone number is required");
        }
        if(worker == null){
            throw new IllegalArgumentException("You need to pick a health worker");
        }
        if(slot == null || slot.isBlank()){
            throw new IllegalArgumentException("Time slot cannot be empty");
        }
        this.patientName = pName;
        this.patientPhone = pPhone;
        this.selectedWorker = worker;
        this.timeSlot = slot;
    }

    // getters
    public String getPatientName() {
        return patientName;
    }
    public String getPatientPhone() {
        return patientPhone;
    }
    public HealthProfessional getSelectedWorker() {
        return selectedWorker;
    }
    public String getTimeSlot() {
        return timeSlot;
    }


    @Override
    public int compareTo(Appointment otherAppointment) {
        return this.timeSlot.compareTo(otherAppointment.timeSlot);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("==== Booking Info ====\n");
        sb.append("Patient Name: ").append(patientName).append("\n");
        sb.append("Patient Phone: ").append(patientPhone).append("\n");
        sb.append("Booking Time: ").append(timeSlot).append("\n");
        sb.append("Assigned Staff -> ").append(selectedWorker.toString()).append("\n");
        return sb.toString();
    }
}

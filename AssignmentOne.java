import java.util.List;

/**
 * AssignmentOne main class for PROG2004 A1
 * Contains main() to run simulation, demonstrate parts3 and part6
 */
public class AssignmentOne {
    public static void main(String[] args) {
        System.out.println("==== PROG2004 A1 Health Service Appointment Simulation ====\n");

        // ---------------- Part 3 Demo: create different health professional objects
        List<String> gpWorkingDays1 = List.of("Monday","Wednesday","Friday");
        List<String> gpWorkingDays2 = List.of("Tuesday","Thursday");
        List<String> specDays = List.of("Monday","Tuesday");
        List<String> nurseDays = List.of("Wednesday","Thursday","Friday");
        List<String> dietDays = List.of("Tuesday","Wednesday");

        // create multiple instances of four types
        GeneralPractitioner gp1 = new GeneralPractitioner(101, "Dr Alice Smith", gpWorkingDays1);
        GeneralPractitioner gp2 = new GeneralPractitioner(102, "Dr Bob Taylor", gpWorkingDays2, false);

        Specialist cardiologist = new Specialist(201,"Dr Chris Lee", specDays,"Cardiology Heart");
        Nurse wardNurse = new Nurse(301,"Ms Emma Brown", nurseDays);
        Dietitian communityDiet = new Dietitian(401,"Ms Fiona Clark", dietDays,"Diabetes management");

        // store them inside list using parent abstract type (polymorphism demo)
        List<HealthProfessional> allWorkers = List.of(gp1,gp2,cardiologist,wardNurse,communityDiet);

        System.out.println("-------- Part 3: All Health Professional Details --------");
        for(HealthProfessional worker : allWorkers){
            System.out.println(worker); // calls each subclass overridden toString()
            System.out.println();
        }

        // ---------------- Part 6 Appointment System demonstration
        AppointmentManager clinicManager = new AppointmentManager();

        try{
            // create valid appointments
            Appointment app1 = new Appointment("Tom Wilson","0411111111", gp1, "09:00");
            Appointment app2 = new Appointment("Sara Green","0422222222", cardiologist, "10:30");
            Appointment app3 = new Appointment("Mike Hall","0433333333", wardNurse, "14:00");
            Appointment app4 = new Appointment("Lucy Young","0444444444", communityDiet, "08:30");

            System.out.println("\n----- Adding several valid appointments -----");
            clinicManager.addAppointment(app1);
            clinicManager.addAppointment(app2);
            clinicManager.addAppointment(app3);
            clinicManager.addAppointment(app4);

            // Test double‑booking error scenario: try book gp1 again at 09:00
            System.out.println("\n----- TEST: Try double‑book same professional same time (should warn) -----");
            Appointment duplicateTest = new Appointment("Bad Patient","0499999999", gp1, "09:00");
            clinicManager.addAppointment(duplicateTest);

            // show sorted appointments by time
            System.out.println("\n----- Show all appointments sorted by time slot -----");
            for(Appointment sortedApp : clinicManager.getAllSortedAppointments()){
                System.out.println(sortedApp);
            }

            // filter example: find appointments for professional id=201 (cardiologist)
            System.out.println("----- Filter: appointments for professional id=201 -----");
            for(Appointment fApp : clinicManager.filterByProfessionalId(201)){
                System.out.println(fApp);
            }

            // filter by patient mobile
            System.out.println("----- Filter: find patient mobile 0433333333 -----");
            for(Appointment mobApp : clinicManager.filterByPatientMobile("0433333333")){
                System.out.println(mobApp);
            }

            // cancel appointment by hp id and timeslot
            System.out.println("\n----- Cancel appointment: hp id 301 at 14:00 -----");
            clinicManager.cancelByProfessionalAndTime(301,"14:00");

            // try cancel something that does NOT exist (error case)
            System.out.println("\n----- TEST cancel non‑existing booking, expect warning -----");
            clinicManager.cancelByProfessionalAndTime(999,"11:00");

            // show after cancellation
            System.out.println("\n===== Appointment list AFTER cancellation =====");
            for(Appointment remainApp : clinicManager.getAllAppointments()){
                System.out.println(remainApp);
            }

            // test cancel all appointments for one patient by mobile
            System.out.println("\n----- Cancel all for patient mobile 0422222222 -----");
            clinicManager.cancelAllByPatientMobile("0422222222");

            System.out.println("\n==== Final state of appointment collection ====");
            for(Appointment finalApp : clinicManager.getAllSortedAppointments()){
                System.out.println(finalApp);
            }

        }catch(IllegalArgumentException e){
            System.out.println("Appointment creation error: "+e.getMessage());
        }

        System.out.println("\nSimulation program finished.");
    }
}

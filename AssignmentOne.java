import java.util.List;

public class AssignmentOne {
    public static void main(String[] args) {
        System.out.println("==== PROG2004 A1 Clinic Booking Demo ====\n");

        
        List<String> gpDays1 = List.of("Monday","Wednesday","Friday");
        List<String> gpDays2 = List.of("Tuesday","Thursday");
        List<String> specDays = List.of("Monday","Tuesday");
        List<String> nurseDays = List.of("Wednesday","Thursday","Friday");
        List<String> dietDays = List.of("Tuesday","Wednesday");

        
        GeneralPractitioner gp1 = new GeneralPractitioner(101, "Dr Ava Moore", gpDays1);
        GeneralPractitioner gp2 = new GeneralPractitioner(102, "Dr Ryan Scott", gpDays2, false);

        Specialist orthoDoc = new Specialist(201,"Dr Hugo Reed", specDays,"Orthopedics");
        Nurse clinicNurse = new Nurse(301,"Ms Zoe Bennett", nurseDays);
        Dietitian sportDiet = new Dietitian(401,"Ms Ruby Hayes", dietDays,"Sports nutrition");

        
        List<HealthProfessional> allStaff = List.of(gp1,gp2,orthoDoc,clinicNurse,sportDiet);

        System.out.println("-------- All Clinic Staff Information --------");
        for(HealthProfessional worker : allStaff){
            System.out.println(worker);
            System.out.println();
        }

        
        AppointmentManager clinic = new AppointmentManager();

        try{
            
            Appointment booking1 = new Appointment("Liam Jones","0401222222", gp1, "09:00");
            Appointment booking2 = new Appointment("Mia Carter","0402333333", orthoDoc, "10:30");
            Appointment booking3 = new Appointment("Noah Evans","0403444444", clinicNurse, "14:00");
            Appointment booking4 = new Appointment("Chloe Bell","0404555555", sportDiet, "08:30");

            System.out.println("\n----- Adding new bookings -----");
            clinic.addAppointment(booking1);
            clinic.addAppointment(booking2);
            clinic.addAppointment(booking3);
            clinic.addAppointment(booking4);

            
            System.out.println("\n----- Test: Try double booking same staff same time -----");
            Appointment duplicateBooking = new Appointment("Jake Owen","0409999999", gp1, "09:00");
            clinic.addAppointment(duplicateBooking);

            
            System.out.println("\n----- Bookings sorted by time -----");
            for(Appointment sortedBook : clinic.getAllSortedBookings()){
                System.out.println(sortedBook);
            }

            
            System.out.println("----- Filter bookings for staff id=201 -----");
            for(Appointment fBook : clinic.filterByStaffId(201)){
                System.out.println(fBook);
            }

            
            System.out.println("----- Filter bookings for phone 0403444444 -----");
            for(Appointment mobBook : clinic.filterByPatientPhone("0403444444")){
                System.out.println(mobBook);
            }

            
            System.out.println("\n----- Cancel booking: staff id 301 at 14:00 -----");
            clinic.cancelByStaffAndTime(301,"14:00");

            
            System.out.println("\n----- Test cancel a non-existing booking -----");
            clinic.cancelByStaffAndTime(999,"11:00");

            System.out.println("\n===== Booking list after cancellation =====");
            for(Appointment remainBook : clinic.getAllAppointments()){
                System.out.println(remainBook);
            }

            
            System.out.println("\n----- Cancel all bookings for phone 0402333333 -----");
            clinic.cancelAllByPatientPhone("0402333333");

            System.out.println("\n==== Final booking list ====");
            for(Appointment finalBook : clinic.getAllSortedBookings()){
                System.out.println(finalBook);
            }

        }catch(IllegalArgumentException e){
            System.out.println("Error when creating booking: "+e.getMessage());
        }

        System.out.println("\nProgram finished.");
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppointmentManager {
    private ArrayList<Appointment> bookingList;

    public static final List<String> CLINIC_TIME_SLOTS = List.of(
            "08:00","08:30","09:00","09:30","10:00","10:30",
            "11:00","11:30","12:00","12:30","13:00","13:30",
            "14:00","14:30","15:00","15:30","16:00"
    );

    public AppointmentManager(){
        bookingList = new ArrayList<>();
    }

    public boolean addAppointment(Appointment newBooking){
        
        if(!CLINIC_TIME_SLOTS.contains(newBooking.getTimeSlot())){
            System.out.println("Warning: This time is not a valid clinic slot.");
            return false;
        }

       
        for(Appointment existBooking : bookingList){
            int existStaffId = existBooking.getSelectedWorker().getProfessionalId();
            int newStaffId = newBooking.getSelectedWorker().getProfessionalId();
            String existTime = existBooking.getTimeSlot();
            String newTime = newBooking.getTimeSlot();

            if(existStaffId == newStaffId && existTime.equals(newTime)){
                System.out.println("Warning: This staff already has a booking at this time!");
                return false;
            }
        }

        bookingList.add(newBooking);
        System.out.println("Success, new booking saved.");
        return true;
    }

    
    public List<Appointment> filterByStaffId(int targetId){
        List<Appointment> result = new ArrayList<>();
        for(Appointment booking : bookingList){
            if(booking.getSelectedWorker().getProfessionalId() == targetId){
                result.add(booking);
            }
        }
        return result;
    }

    
    public List<Appointment> filterByPatientPhone(String phone){
        List<Appointment> out = new ArrayList<>();
        for(Appointment b : bookingList){
            if(b.getPatientPhone().equals(phone)){
                out.add(b);
            }
        }
        return out;
    }

    
    public List<Appointment> getAllSortedBookings(){
        ArrayList<Appointment> copyList = new ArrayList<>(bookingList);
        Collections.sort(copyList);
        return copyList;
    }

   
    public boolean cancelByStaffAndTime(int staffId, String slot){
        for(int i=0; i<bookingList.size(); i++){
            Appointment ap = bookingList.get(i);
            int currentId = ap.getSelectedWorker().getProfessionalId();
            String currentSlot = ap.getTimeSlot();
            if(currentId == staffId && currentSlot.equals(slot)){
                bookingList.remove(i);
                System.out.println("Cancel done: removed booking for id "+staffId+" @ "+slot);
                return true;
            }
        }
        System.out.println("Warning: Cannot find this booking to cancel.");
        return false;
    }

    
    public boolean cancelAllByPatientPhone(String phoneNumber){
        int removeCount =0;
        for(int i = bookingList.size()-1; i >=0; i--){
            Appointment temp = bookingList.get(i);
            if(temp.getPatientPhone().equals(phoneNumber)){
                bookingList.remove(i);
                removeCount++;
            }
        }
        if(removeCount>0){
            System.out.println("Cancel done, removed "+removeCount+" booking(s) for phone "+phoneNumber);
            return true;
        }else{
            System.out.println("Warning: No bookings found for this phone number.");
            return false;
        }
    }

    
    public List<Appointment> getAllAppointments(){
        return new ArrayList<>(bookingList);
    }
}

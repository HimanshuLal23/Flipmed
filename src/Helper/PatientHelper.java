package Helper;

import Controller.DoctorController;
import Controller.PatientController;
import Model.Doctor;
import Model.Patient;
import Exception.*;
import Model.Specialization;
import javafx.util.Pair;

import java.util.List;
import java.util.Map;

public class PatientHelper {
    private PatientHelper() {

    }
    public static String bookSlots(Patient patient, Specialization specialization,int time) throws UnregisteredException,IndexOutOfBoundsException,InvalidSpecializationExcpetion,NoAvailableSlotsException {
        var patientController = PatientController.getInstance();
        if(!patientController.containsKey(patient)) {
            throw new UnregisteredException(patient.getName() +" is not registered");
        }
        boolean[] bookedSlots = patientController.get(patient);
        if(time > bookedSlots.length) {
            throw new IndexOutOfBoundsException();
        }
        if(bookedSlots[time] != false) {
            throw new BookedException("This slot is already confirmed with other doctor, please "+ patient.getName() +" re-try booking in someother slot");
        }
        var doctorSpecializationAvailabilityMap = DoctorController.getDoctorControllerInstance();
        if(!bookSlotsWithSpecializedDoctor(doctorSpecializationAvailabilityMap,specialization,time)){
            throw new NoAvailableSlotsException("No slots available, please try in sometime "+ patient.getName());
        }
        bookedSlots[time] = true;
        patientController.put(patient,bookedSlots);
        return "Slot booked successfully, please show up on time "+ patient.getName();
    }

    private static boolean bookSlotsWithSpecializedDoctor(Map<Specialization,  List<Map<Doctor,boolean[]>>> doctorSpecializationAvailabilityMap,Specialization specialization,int time) throws InvalidSpecializationExcpetion{
        if(doctorSpecializationAvailabilityMap.containsKey(specialization)==false) {
            throw new InvalidSpecializationExcpetion("Invalid specialization, please enter a valid specialization ");
        }
        List<Map<Doctor,boolean[]>> doctorAvailability = doctorSpecializationAvailabilityMap.get(specialization);
        return checkForAvailableSlots(doctorAvailability,time);
    }

    private static boolean checkForAvailableSlots(List<Map<Doctor,boolean[]>> doctorAvailability,int time) {
        for(var slotsOfDoctor:doctorAvailability) {
            for(var doctors:slotsOfDoctor.entrySet()) {
                if(doctors.getValue()[time] == false) {
                    doctors.getValue()[time] = true;
                    return true;
                }
            }
        }
        return false;
    }
}

package Controller;

import Model.Doctor;
import Model.Specialization;
import javafx.util.Pair;

import java.util.*;

public class DoctorController {

    private DoctorController() {

    }

    private static class Holder {
        private static final Map<Specialization, List<Map<Doctor,boolean[]>>> instance = new HashMap<>();
    }

    public static Map<Specialization,  List<Map<Doctor,boolean[]>>> getDoctorControllerInstance() {
        return Holder.instance;
    }

    public static void registerDoctor(String doctorName,Specialization specialization) {
        Doctor doctor = new Doctor(doctorName, UUID.randomUUID());
        Map<Specialization,  List<Map<Doctor,boolean[]>>> instance = Holder.instance;
        List<Map<Doctor,boolean[]>> listOfDoctorsAndTheirAvailableSlots;
        if(instance.containsKey(specialization)) {
            listOfDoctorsAndTheirAvailableSlots = instance.get(specialization);
        }else {
            listOfDoctorsAndTheirAvailableSlots = new ArrayList<>();
        }
        Map<Doctor,boolean[]> map = new HashMap<>();
        map.put(doctor,new boolean[24]);
        listOfDoctorsAndTheirAvailableSlots.add(map);
        instance.put(specialization,listOfDoctorsAndTheirAvailableSlots);
    }


}

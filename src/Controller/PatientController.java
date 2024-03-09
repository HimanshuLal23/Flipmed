package Controller;

import Helper.PatientHelper;
import Model.Patient;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PatientController {
    private PatientController() {

    }
    private static class Holder {
        private final static Map<Patient,boolean[]> instance = new HashMap<>();
    }

    public static Map<Patient,boolean[]> getInstance() {
        return Holder.instance;
    }
    public static Patient registerPatient(String patientName) {
        Patient patient = new Patient(patientName, UUID.randomUUID());
        Holder.instance.put(patient,new boolean[24]);
        return patient;
    }
}

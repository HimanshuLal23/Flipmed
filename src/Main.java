import Controller.DoctorController;
import Controller.PatientController;
import Helper.PatientHelper;
import Model.Patient;
import Model.Specialization;
import javafx.util.Pair;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Register Doctors
        DoctorController.registerDoctor("Champak Lal", Specialization.ORTHOPEDIC);
        DoctorController.registerDoctor("Jetha Lal",Specialization.CARDIOLOGIST);
        DoctorController.registerDoctor("Daya Ben",Specialization.DERMATOLOGIST);
        DoctorController.registerDoctor("Tarak Mehta",Specialization.GENERAL_PHYSICIAN);

        //Register Patients
        Patient babitaJi = PatientController.registerPatient("Babita Ji");
        Patient iyer = PatientController.registerPatient("Iyer");
        Patient bhide = PatientController.registerPatient("Bhide");
        Patient madhavi = PatientController.registerPatient("Madhavi");
        bookSlot(babitaJi,Specialization.CARDIOLOGIST);
        bookSlot(iyer,Specialization.CARDIOLOGIST);
        bookSlot(bhide,Specialization.DERMATOLOGIST);
        bookSlot(madhavi,Specialization.ORTHOPEDIC);
    }

    private static void bookSlot(Patient patient,Specialization specialization) {
        Pair<String,Boolean> slotBooker;
        int time = 0;
        do {
            slotBooker = FlipmedAppilcation.bookSlots(patient,specialization,time);
            System.out.println(slotBooker.getKey());
            time++;
        }while(!slotBooker.getValue() && time<24);
    }
}
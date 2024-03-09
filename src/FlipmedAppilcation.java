import Helper.PatientHelper;
import Model.Patient;
import Model.Specialization;
import Exception.*;
import javafx.util.Pair;

public class FlipmedAppilcation {

    private FlipmedAppilcation() {

    }

    public static Pair<String,Boolean> bookSlots(Patient patient, Specialization specialization,int time) {
        String message;
        try {
            message = PatientHelper.bookSlots(patient,specialization,time);
        }catch(IndexOutOfBoundsException indexOutOfBoundsException) {
            message = "Incorrect time choosen, please try again";
            return new Pair<>(message,false);
        }catch(BookedException bookedException) {
            return new Pair<>(bookedException.getMessage(),false);
        }catch (NoAvailableSlotsException noAvailableSlotsException) {
            return new Pair<>(noAvailableSlotsException.getMessage(),false);
        }catch(InvalidSpecializationExcpetion invalidSpecializationExcpetion) {
            return new Pair<>(invalidSpecializationExcpetion.getMessage(),false);
        }
        return new Pair<>(message,true);
    }
}

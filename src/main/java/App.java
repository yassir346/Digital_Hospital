import org.example.digital_hospital.models.*;
import org.example.digital_hospital.repository.IDepartementRepository;
import org.example.digital_hospital.repository.Impl.DepartementRepositoryImpl;

public class App {
    public static void main(String[] args) {
        IDepartementRepository departementRepository = new DepartementRepositoryImpl();
        Docteur docteur = new Docteur();
        docteur.setNom("a");
        Patient patient = new Patient();
        Salle salle = new Salle();
        Consultation consultation = new Consultation();
    }
}

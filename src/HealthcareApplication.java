import javax.swing.SwingUtilities;

public class HealthcareApplication {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HealthcareModel model = new HealthcareModel();
            HealthcareView view = new HealthcareView();
            HealthcareController controller = new HealthcareController(model, view);
            view.setController(controller);
            view.setVisible(true);
        });
    }


}

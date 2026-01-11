import javax.swing.SwingUtilities;

public class HealthcareApplication {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HealthcareModel model = new HealthcareModel();
            HealthcareView view = new HealthcareView(model);
            view.setVisible(true);
        });
    }


}

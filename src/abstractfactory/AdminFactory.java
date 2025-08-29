package abstractfactory;

 public class AdminFactory implements InterfazUI {
    public Render crearInterfaz() {
        return new AdminUI();
    }
}

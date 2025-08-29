package abstractfactory;

public class UsuarioFactory implements InterfazUI {
    @Override
    public Render crearInterfaz() {
        return new UsuarioUI();
    }
}

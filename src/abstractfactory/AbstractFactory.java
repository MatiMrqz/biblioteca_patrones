package abstractfactory;

public class AbstractFactory {

    public static InterfazUI obtenerInterfaz(String tipo) {
        if(tipo == "Usuario"){
            return new UsuarioFactory();
        }else {
            return new AdminFactory();
        }
    }
}

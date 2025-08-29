package abstractfactory;

public interface  MetodoEnvio {
    public TipoEnvio getTipoEnvio();
}

interface TipoEnvio {
    public void tipo();
}

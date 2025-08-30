package builder;

public class Usuario {
    private String nombre = "";
    private String email = "";
    private String direccion = "";
    private String telefono = "";
    private String fechaNacimiento = "";

    Usuario(Builder builder) {
        this.nombre = builder.nombre;
        this.email = builder.email;
        this.direccion = builder.direccion;
        this.telefono = builder.telefono;
        this.fechaNacimiento = builder.fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Usuario:" + this.nombre + " | F.Nacimiento: " + this.fechaNacimiento + " | email:" + this.email + " | direccion:" + this.direccion + " | telefono:" + this.telefono;
    }

    public static class Builder {
        private String nombre;
        private String email;
        private String direccion;
        private String telefono;
        private String fechaNacimiento;

        public Builder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setDireccion(String direccion) {
            this.direccion = direccion;
            return this;
        }

        public Builder setTelefono(String telefono) {
            this.telefono = telefono;
            return this;
        }

        public Builder setFechaNacimiento(String fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
            return this;
        }

        public Usuario build() {
            return new Usuario(this);
        }
    }
}


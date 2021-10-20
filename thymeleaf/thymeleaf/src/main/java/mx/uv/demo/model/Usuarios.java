package mx.uv.demo.model;
public class Usuarios {
    private Long id;
    private String Nombre;
    private String pass;
    
    public Usuarios(){}

    public Usuarios(Long ID, String Name, String pass ){
        super();
        this.id = ID;
        this.Nombre = Name;
        this.pass = pass;
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Usuarios [Nombre=" + Nombre + ", id=" + id + ", pass=" + pass + "]";
    }

    
}

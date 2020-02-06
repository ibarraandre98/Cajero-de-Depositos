package edcajerodedepositos;
public class Historial {
    String nombre,accion;
    int cantidad,numero,nip;
    public Historial(String nombre,int numero, int nip,String accion,int cantidad){
        setNombre(nombre);
        setAccion(accion);
        setCantidad(cantidad);
        setNumero(numero);
        setNip(nip);
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNip() {
        return nip;
    }

    public void setNip(int nip) {
        this.nip = nip;
    }
    
}

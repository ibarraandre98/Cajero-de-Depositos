package edcajerodedepositos;
public class ClientesBanco {
    String nombre;
    int numero,nip,cant;
    public ClientesBanco(String nombre,int numero,int nip,int cant){
        setNombre(nombre);
        setNumero(numero);
        setNip(nip);
        setCant(cant);
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getNombre(){
        return nombre;
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

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }
    
}

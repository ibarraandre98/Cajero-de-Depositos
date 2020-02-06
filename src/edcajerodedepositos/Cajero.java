package edcajerodedepositos;
public class Cajero {
    int billete,cantidad;
    public Cajero(int billete,int cantidad){
        setBillete(billete);
        setCantidad(cantidad);
    }
    public void setBillete(int billete){
        this.billete=billete;
    }
    public int getBillete(){
        return billete;
    }
    public void setCantidad(int cantidad){
        this.cantidad=cantidad;
    }
    public int getCantidad(){
        return cantidad;
    }
}

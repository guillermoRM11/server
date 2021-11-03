
package examen_renfe;

public class Train {
    private String origen;
    private String destino;
    private String promotion;
    private String hora;
    private String precio;
    
    public Train(){
    }
    
    public Train(String origen, String destino, String promotion, String hora, String precio) {
        this.origen = origen;
        this.destino = destino;
        this.promotion = promotion;
        this.hora = hora;
        this.precio = precio;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Train{" + "origen=" + origen + ", destino=" + destino + ", promotion=" + promotion + ",hora=" + hora + ",precio=" + precio + '}';
    }
    
}

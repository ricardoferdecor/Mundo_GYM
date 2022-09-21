package Modelos;

/**
 * Fecha:21/09/2022
 * Versión: 1.0
 * @author ricardo
 */
public class Ingredientes {
    private int idIngrediente;
    private String nombreIngrediente;
    private String unidadMedida;
    private Double cantidad;
    private int idDieta;
    private String NombreDieta;

    public Ingredientes() {
    }

    public Ingredientes(int idIngrediente, String nombreIngrediente, String unidadMedida, Double cantidad, int idDieta, String NombreDieta) {
        this.idIngrediente = idIngrediente;
        this.nombreIngrediente = nombreIngrediente;
        this.unidadMedida = unidadMedida;
        this.cantidad = cantidad;
        this.idDieta = idDieta;
        this.NombreDieta = NombreDieta;
    }

    public int getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(int idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public String getNombreIngrediente() {
        return nombreIngrediente;
    }

    public void setNombreIngrediente(String nombreIngrediente) {
        this.nombreIngrediente = nombreIngrediente;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(int idDieta) {
        this.idDieta = idDieta;
    }

    public String getNombreDieta() {
        return NombreDieta;
    }

    public void setNombreDieta(String NombreDieta) {
        this.NombreDieta = NombreDieta;
    }
    
    
}

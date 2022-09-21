package Modelos;

/**
 * Fecha:21/09/2022 
 * Versión: 1.0
 * @author ricardo
 */

public class DietaPersonal {
    private String TipoDieta;
    private String Dieta;
    private String Preparacion;
    private int IdDieta;
    private String Fecha_inicial;
    private String Fecha_final;

    public DietaPersonal() {
    }

    public DietaPersonal(String TipoDieta, String Dieta, String Preparacion, int IdDieta, String Fecha_inicial, String Fecha_final) {
        this.TipoDieta = TipoDieta;
        this.Dieta = Dieta;
        this.Preparacion = Preparacion;
        this.IdDieta = IdDieta;
        this.Fecha_inicial = Fecha_inicial;
        this.Fecha_final = Fecha_final;
    }

    public String getTipoDieta() {
        return TipoDieta;
    }

    public void setTipoDieta(String TipoDieta) {
        this.TipoDieta = TipoDieta;
    }

    public String getDieta() {
        return Dieta;
    }

    public void setDieta(String Dieta) {
        this.Dieta = Dieta;
    }

    public String getPreparacion() {
        return Preparacion;
    }

    public void setPreparacion(String Preparacion) {
        this.Preparacion = Preparacion;
    }

    public int getIdDieta() {
        return IdDieta;
    }

    public void setIdDieta(int IdDieta) {
        this.IdDieta = IdDieta;
    }

    public String getFecha_inicial() {
        return Fecha_inicial;
    }

    public void setFecha_inicial(String Fecha_inicial) {
        this.Fecha_inicial = Fecha_inicial;
    }

    public String getFecha_final() {
        return Fecha_final;
    }

    public void setFecha_final(String Fecha_final) {
        this.Fecha_final = Fecha_final;
    }
    
    
}

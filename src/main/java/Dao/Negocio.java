package Dao;

/**
 * Fecha:18/09/2022 
 * Versión: 1.0
 * @author ricardo
 */
import Conexion.MySQLConexion;
import java.sql.*;
import java.util.*;
import Modelos.*;

public class Negocio extends MySQLConexion {

    //LOGEO
    public Usuario Login(Usuario usu) {
        Usuario usuario = new Usuario();
        ResultSet rs;
        try {
            this.getConnection();
            String sql = "SELECT ID_USUARIO,NOMBRE_USUARIO, CLAVE_USUARIO, "
                    + "PERFIL_USUARIO FROM MG_USUARIO WHERE NOMBRE_USUARIO=? "
                    + "AND CLAVE_USUARIO=?";
            PreparedStatement st = this.getConnection().prepareStatement(sql);
            st.setString(1, usu.getNombreUsuario());
            st.setString(2, usu.getClaveusuario());
            rs = st.executeQuery();
            while (rs.next()) {
                usuario.setPerfilUsuario(rs.getInt("PERFIL_USUARIO"));
                usuario.setIdUsuario(rs.getInt("ID_USUARIO"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (this.getConnection() != null) {
                    this.getConnection().close();
                }
            } catch (Exception e2) {
            }
        }
        return usuario;
    }

    //CORRELATIVO
    public String CorrelativoUsuario() {
        String id = "";
        ResultSet rs;
        Connection cnx = MySQLConexion.getConnection();
        try {

            String sql = "SELECT CASE WHEN COUNT(*) = 0 THEN 1 ELSE MAX(ID_USUARIO)+1"
                    + " END AS ID_CORRELATIVO_USUARIO FROM MG_USUARIO";
            PreparedStatement st = cnx.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                id = rs.getObject("ID_CORRELATIVO_USUARIO").toString();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return id;
    }

    //REGISTRAR USUARIO
    public void RegistrarUsuario(Usuario usuario) {
        Connection cnx = MySQLConexion.getConnection();
        try {
            String sql = "INSERT INTO MG_USUARIO VALUES (?,?,?,?)";
            PreparedStatement st = cnx.prepareStatement(sql);
            st.setInt(1, usuario.getIdUsuario());
            st.setString(2, usuario.getNombreUsuario());
            st.setString(3, usuario.getClaveusuario());
            st.setInt(4, usuario.getPerfilUsuario());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

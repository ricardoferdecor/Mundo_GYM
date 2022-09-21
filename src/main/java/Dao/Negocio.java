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

    //LOGEO SANDUNGEO
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

    //CORRELATIVO USUARIO
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
            st.executeQuery();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    //REGISTRAR CLIENTE
    public void RegistrarCliente(Cliente cliente) {
        Connection cnx = MySQLConexion.getConnection();
        try {
            String sql = "INSERT INTO MG_CLIENTE (ID_CLIENTE,NOMBRE_CLIENTE,"
                    + "APELLIDOS_CLIENTE,DNI,DIRECCION,CELULAR,TALLA,PESO_INICIAL,"
                    + "PESO_ACTUAL,IMC,ID_USUARIO)"
                + "Values(" + cliente.getIdCliente() + ""
                + "," + "'" + cliente.getNombreCliente() + "'"
                + "," + "'" + cliente.getApellidoCliente() + "'"
                + "," + "'" + cliente.getDNI() + "'"
                + "," + "'" + cliente.getDireccion() + "'"
                + "," + "'" + cliente.getCelular() + "',"
                + cliente.getTalla() + ", "
                + cliente.getPeso_inicial() + ", "
                + 0.00 + ", "
                + cliente.getIMC() + ", "
                + null + ")";
            PreparedStatement st=cnx.prepareStatement(sql);
            st.executeQuery();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    //CORRELATIVO CLIENTE
    public String CorrelativoCliente() {
        String id = "";
        ResultSet rs;
        Connection cnx = MySQLConexion.getConnection();
        try {
            String sql = "SELECT CASE WHEN COUNT(*) = 0 THEN 1 ELSE MAX(ID_CLIENTE)+1"
                    + " END AS ID_CORRELATIVO_CLIENTE FROM MG_CLIENTE";
            PreparedStatement st = cnx.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                id = rs.getObject("ID_CORRELATIVO_CLIENTE").toString();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return id;
    }
    
    //CORRELATIVO PROGRAMACION
    public String CorrelativoProgramacion() {
        String id = "";
        ResultSet rs;
        Connection cnx = MySQLConexion.getConnection();
        try {
            String sql = "SELECT CASE WHEN COUNT(*) = 0 THEN 1 ELSE "
                    + "MAX(ID_CONSOLIDACION_PROGRAMACION)+1 END AS "
                    + "ID_CORRELATIVO_PROGRAMACION FROM MG_PROGRAMACION";
            PreparedStatement st = cnx.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                id = rs.getObject("ID_CORRELATIVO_PROGRAMACION").toString();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return id;
    }
    
    //REGISTRAR PROGRAMACION
    public void RegistrarPogramacion(Cliente programacion) {
        Connection cnx = MySQLConexion.getConnection();
        try {
            String sql = "INSERT INTO MG_PROGRAMACION (ID_CONSOLIDACION_PROGRAMACION,"
                    + "FECHA_INICIAL,FECHA_FINAL,ID_DIETA,ID_RUTINA,ID_CLIENTE)"
                + "Values(" + programacion.getId_consolidacion() + ""
                + "," + "'" + programacion.getFecha_ini_programacion() + "'"
                + "," + "'" + programacion.getFecha_fin_programacion() + "'"
                + "," + "" + programacion.getId_dieta() + ""
                + "," + "" + programacion.getId_rutina() + ""
                + "," + "" + programacion.getIdCliente() + ""
                + ")";
            PreparedStatement st=cnx.prepareStatement(sql);
            st.executeQuery();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    //LISTA DE CLIENTES
    public List<Cliente> ListaCliente(){
        Connection cnx=MySQLConexion.getConnection();
        List<Cliente> lc =new ArrayList();
        try {
            String sql="SELECT * FROM MG_CLIENTE ORDER BY NOMBRE_CLIENTE ASC";
            PreparedStatement st=cnx.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while (rs.next()) {
                Cliente Cliente = new Cliente();
                Cliente.setIdCliente(rs.getInt("ID_CLIENTE"));
                Cliente.setNombreCliente(rs.getString("NOMBRE_CLIENTE"));
                Cliente.setApellidoCliente(rs.getString("APELLIDOS_CLIENTE"));
                Cliente.setDNI(rs.getString("DNI"));
                Cliente.setTalla(rs.getDouble("TALLA"));
                Cliente.setPeso_inicial(rs.getDouble("PESO_INICIAL"));
                Cliente.setPeso_actual(rs.getDouble("PESO_ACTUAL"));
                Cliente.setIMC(rs.getDouble("IMC"));
                lc.add(Cliente);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lc;
    }
    
    //LISTA DE CLIENTES IMC
    public List<Cliente> ListaClienteImc(){
        Connection cnx=MySQLConexion.getConnection();
        List<Cliente> lc =new ArrayList();
        try {
            String sql="SELECT ID_CLIENTE,NOMBRE_CLIENTE,APELLIDOS_CLIENTE,DNI,TALLA,PESO_INICIAL,PESO_ACTUAL,IMC,\n"
                    + "CASE WHEN IMC BETWEEN (select RANGO_INICIAL from MG_TABLA_IMC where ID_TABLA_IMC = 1) AND (select RANGO_FINAL from MG_TABLA_IMC where ID_TABLA_IMC = 1) THEN (select DESCIPCION_IMC from MG_TABLA_IMC where ID_TABLA_IMC = 1)\n"
                    + "     WHEN IMC BETWEEN (select RANGO_INICIAL from MG_TABLA_IMC where ID_TABLA_IMC = 2) AND (select RANGO_FINAL from MG_TABLA_IMC where ID_TABLA_IMC = 2) THEN (select DESCIPCION_IMC from MG_TABLA_IMC where ID_TABLA_IMC = 2) \n"
                    + "	 WHEN IMC BETWEEN (select RANGO_INICIAL from MG_TABLA_IMC where ID_TABLA_IMC = 3) AND (select RANGO_FINAL from MG_TABLA_IMC where ID_TABLA_IMC = 3) THEN (select DESCIPCION_IMC from MG_TABLA_IMC where ID_TABLA_IMC = 3) \n"
                    + "	 WHEN IMC BETWEEN (select RANGO_INICIAL from MG_TABLA_IMC where ID_TABLA_IMC = 4) AND (select RANGO_FINAL from MG_TABLA_IMC where ID_TABLA_IMC = 4) THEN (select DESCIPCION_IMC from MG_TABLA_IMC where ID_TABLA_IMC = 4) \n"
                    + "	 WHEN IMC BETWEEN (select RANGO_INICIAL from MG_TABLA_IMC where ID_TABLA_IMC = 5) AND (select RANGO_FINAL from MG_TABLA_IMC where ID_TABLA_IMC = 5) THEN (select DESCIPCION_IMC from MG_TABLA_IMC where ID_TABLA_IMC = 5) \n"
                    + "     WHEN IMC BETWEEN (select RANGO_INICIAL from MG_TABLA_IMC where ID_TABLA_IMC = 6) AND (select RANGO_FINAL from MG_TABLA_IMC where ID_TABLA_IMC = 6) THEN (select DESCIPCION_IMC from MG_TABLA_IMC where ID_TABLA_IMC = 6) 	 \n"
                    + "	 END AS Observacion,\n"
                    + "	 ISNULL(b.ID_USUARIO,0) AS ID_USUARIO\n"
                    + "FROM MG_CLIENTE a LEFT JOIN MG_USUARIO b\n"
                    + "ON a.ID_USUARIO = b.ID_USUARIO\n"
                    + "ORDER BY IMC DESC";
            PreparedStatement st=cnx.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while (rs.next()) {
                Cliente Cliente = new Cliente();
                Cliente.setIdCliente(rs.getInt("ID_CLIENTE"));
                Cliente.setNombreCliente(rs.getString("NOMBRE_CLIENTE"));
                Cliente.setApellidoCliente(rs.getString("APELLIDOS_CLIENTE"));
                Cliente.setDNI(rs.getString("DNI"));
                Cliente.setTalla(rs.getDouble("TALLA"));
                Cliente.setPeso_inicial(rs.getDouble("PESO_INICIAL"));
                Cliente.setPeso_actual(rs.getDouble("PESO_ACTUAL"));
                Cliente.setIMC(rs.getDouble("IMC"));
                Cliente.setObservacion(rs.getString("OBSERVACION"));
                Cliente.setIdUsuario(rs.getInt("ID_USUARIO"));
                lc.add(Cliente);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lc;
    }
    
    //LISTA DE DIETA POR CLIENTE
    public List<Dieta> ListaTipoDietaCliente(){
        Connection cnx=MySQLConexion.getConnection();
        List<Dieta> lc =new ArrayList();
        try {
            String sql="SELECT * FROM MG_TIPO_DIETA";
            PreparedStatement st=cnx.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while (rs.next()) {
                Dieta tipoDieta = new Dieta();
                tipoDieta.setIdTipoDieta(rs.getInt("ID_TIPO_DIETA"));
                tipoDieta.setNombreTipoDieta(rs.getString("NOMBRE_TIPO_DIETA"));
                lc.add(tipoDieta);;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lc;
    }
    
    //LISTA DE CLIENTES ID
    public List<Cliente> ListaClienteId(Cliente cliente){
        Connection cnx=MySQLConexion.getConnection();
        List<Cliente> lc =new ArrayList();
        try {
            String sql="SELECT ID_CLIENTE, \n"
                    + "	 case when CHARINDEX(' ', APELLIDOS_CLIENTE) > 0 then left(NOMBRE_CLIENTE,1)+LEFT(APELLIDOS_CLIENTE,CHARINDEX(' ',APELLIDOS_CLIENTE)-1) \n"
                    + "	 else left(NOMBRE_CLIENTE,1)+APELLIDOS_CLIENTE end as USUARIO\n"
                    + "from MG_CLIENTE where ID_CLIENTE =?";
            PreparedStatement st=cnx.prepareStatement(sql);
            st.setInt(1, cliente.getIdCliente());
            ResultSet rs=st.executeQuery();
            while (rs.next()) {
                Cliente Cliente = new Cliente();
                Cliente.setIdCliente(rs.getInt("ID_CLIENTE"));
                Cliente.setNombreCliente(rs.getString("USUARIO"));
                lc.add(Cliente);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lc;
    }
    
    //ACTUALIZAR ID USUARIO DEL CLIENTE
    public void ActualizarUsuarioCliente (Cliente cliente){
        Connection cnx=MySQLConexion.getConnection();
        try {
            String sql="UPDATE GYM_CLIENTE SET ID_USUARIO ="
                    + cliente.getIdUsuario() + " WHERE ID_CLIENTE =" 
                    + cliente.getIdCliente();
            PreparedStatement st=cnx.prepareStatement(sql);
            st.executeQuery();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    //LISTA DE CLIENTES ID
    public List<Cliente> ListaClienteDatos(Cliente cliente){
        Connection cnx=MySQLConexion.getConnection();
        List<Cliente> lc =new ArrayList();
        try {
            String sql = "select NOMBRE_CLIENTE +','+APELLIDOS_CLIENTE as NOMBRE_CLIENTE,DNI,PESO_INICIAL,TALLA,PESO_ACTUAL,IMC,\n"
                    + "CASE WHEN IMC BETWEEN (select RANGO_INICIAL from MG_TABLA_IMC where ID_TABLA_IMC = 1) AND (select RANGO_FINAL from MG_TABLA_IMC where ID_TABLA_IMC = 1) THEN (select DESCIPCION_IMC from MG_TABLA_IMC where ID_TABLA_IMC = 1)\n"
                    + "     WHEN IMC BETWEEN (select RANGO_INICIAL from MG_TABLA_IMC where ID_TABLA_IMC = 2) AND (select RANGO_FINAL from MG_TABLA_IMC where ID_TABLA_IMC = 2) THEN (select DESCIPCION_IMC from MG_TABLA_IMC where ID_TABLA_IMC = 2) \n"
                    + "	 WHEN IMC BETWEEN (select RANGO_INICIAL from MG_TABLA_IMC where ID_TABLA_IMC = 3) AND (select RANGO_FINAL from MG_TABLA_IMC where ID_TABLA_IMC = 3) THEN (select DESCIPCION_IMC from MG_TABLA_IMC where ID_TABLA_IMC = 3) \n"
                    + "	 WHEN IMC BETWEEN (select RANGO_INICIAL from MG_TABLA_IMC where ID_TABLA_IMC = 4) AND (select RANGO_FINAL from MG_TABLA_IMC where ID_TABLA_IMC = 4) THEN (select DESCIPCION_IMC from MG_TABLA_IMC where ID_TABLA_IMC = 4) \n"
                    + "	 WHEN IMC BETWEEN (select RANGO_INICIAL from MG_TABLA_IMC where ID_TABLA_IMC = 5) AND (select RANGO_FINAL from MG_TABLA_IMC where ID_TABLA_IMC = 5) THEN (select DESCIPCION_IMC from MG_TABLA_IMC where ID_TABLA_IMC = 5) \n"
                    + "     WHEN IMC BETWEEN (select RANGO_INICIAL from MG_TABLA_IMC where ID_TABLA_IMC = 6) AND (select RANGO_FINAL from MG_TABLA_IMC where ID_TABLA_IMC = 6) THEN (select DESCIPCION_IMC from MG_TABLA_IMC where ID_TABLA_IMC = 6) 	 \n"
                    + "	 END AS ESTADO\n"
                    + "from MG_CLIENTE a inner join GYM_USUARIO b\n"
                    + "                    on a.ID_USUARIO = b.ID_USUARIO\n"
                    + "                    WHERE a.ID_USUARIO = ?";
            PreparedStatement st=cnx.prepareStatement(sql);
            st.setInt(1, cliente.getIdUsuario());
            ResultSet rs=st.executeQuery();
            while (rs.next()) {
                Cliente Cliente = new Cliente();
                Cliente.setNombreCliente(rs.getString("NOMBRE_CLIENTE"));
                Cliente.setDNI(rs.getString("DNI"));
                Cliente.setPeso_inicial(rs.getDouble("PESO_INICIAL"));
                Cliente.setTalla(rs.getDouble("TALLA"));
                Cliente.setPeso_actual(rs.getDouble("PESO_ACTUAL"));
                Cliente.setIMC(rs.getDouble("IMC"));
                Cliente.setObservacion(rs.getString("ESTADO"));
                lc.add(Cliente);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lc;
    }
}

package Controlador;

import Dao.Negocio;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Fecha:21/09/2022 
 * Versión: 1.0
 * @author ricardo
 */

import Modelos.*;
import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //GRABADO DE SESION EN LA PÁGINA
        HttpSession sesion=request.getSession();
        String id_pagina=request.getParameter("id");
        String idCliente_1=request.getParameter("idCliente_1");
        Object IdUsuario_Login=sesion.getAttribute("idUsuario_Login");
        
        if (id_pagina != null) {
            sesion.setAttribute("id_pagina", id_pagina);
        }
        
        if (idCliente_1 != null) {
            try {
                sesion.setAttribute("id_usuario_sel", idCliente_1);
                Cliente cliente = new Cliente();
                cliente.setIdCliente(Integer.parseInt(idCliente_1));
                Negocio listaCliente = new Negocio();
                List<Cliente> listaCliente2 = listaCliente.ListaClienteId(cliente);
                request.setAttribute("idCliente_1", listaCliente2);
                request.getRequestDispatcher("UsuarioCliente.jsp").forward(request, response);
            } catch (Exception ex) {
                   ex.printStackTrace();
            }
        }
        
        //PAGINAS DEL CLIENTE
        if ("DatosPersonal".equals(id_pagina)) {
            String IdUsuario_Login_s = IdUsuario_Login.toString();
            Cliente cliente = new Cliente();
            cliente.setIdUsuario(Integer.parseInt(IdUsuario_Login_s));
            try {
                Negocio objeto = new Negocio();
                List<Cliente> listaClientedatos2 = objeto.ListaClienteDatos(cliente);
                request.setAttribute("DatosCliente", listaClientedatos2);
                request.getRequestDispatcher("DatosPersonal.jsp").forward(request, response);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        if ("DietaPersonal".equals(id_pagina)) {
            String IdUsuario_Login_s = IdUsuario_Login.toString();
            Cliente cliente = new Cliente();
            cliente.setIdUsuario(Integer.parseInt(IdUsuario_Login_s));
            try {
                Negocio listaDieta_personal = new Negocio();
                List<DietaPersonal> listaDieta_personal2 = listaDieta_personal.ListaDietaPersonal(cliente);
                int IdDieta = listaDieta_personal2.get(0).getIdDieta();
                request.setAttribute("DatosDietaPersonal", listaDieta_personal2);
                Negocio listaIngredientes = new Negocio();
                List<Ingredientes> listaIngredientes2 = listaIngredientes.ListaIngredientesIdDieta(IdDieta);
                request.setAttribute("TablaIngredientes", listaIngredientes2);
                request.getRequestDispatcher(id_pagina + ".jsp").forward(request, response);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

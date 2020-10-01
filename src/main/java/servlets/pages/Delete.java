package servlets.pages;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import DAO.Acompte;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Benjamin
 */
@WebServlet(name = "Delete", urlPatterns = {"/Delete"})
public class Delete extends HttpServlet {


    EntityManager em;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           // out.println( em.getProperties().toString());
           EntityManagerFactory emf = Persistence.createEntityManagerFactory("TEST");
            em = emf.createEntityManager();
            List rs = em.createNamedQuery("Acompte.findAll", Acompte.class).setMaxResults(30).getResultList();
            em.close();
            System.out.println(rs.isEmpty());
            request.setAttribute("acomptes", rs);
           request.getRequestDispatcher("Delete.jsp").forward(request, response);

            }catch(Throwable e){
             throw  e;
        }
    }

    protected void processJsf(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("TEST");
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Acompte a = em.find(Acompte.class, Long.parseLong(request.getParameter("acompte_choice")));
            em.remove(a);

            List rs = em.createNamedQuery("Acompte.findAll", Acompte.class).setMaxResults(30).getResultList();
            em.getTransaction().commit();
            em.close();
            System.out.println(rs.isEmpty());
            request.setAttribute("acomptes", rs);
            request.setAttribute("message", "The account " + a.getId() + " as been deleted !");
           request.getRequestDispatcher("Delete.jsp").forward(request, response);
          
    
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
        processJsf(request, response);
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

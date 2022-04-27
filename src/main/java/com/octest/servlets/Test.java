package com.octest.servlets;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.octest.bdd.Noms;
import com.octest.beans.Auteur;
import com.octest.beans.Utilisateur;
import com.octest.dao.DaoFactory;
import com.octest.dao.UtilisateurDao;
import com.octest.forms.ConnectionForm;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public static final int TAILLE_TAMPON = 10240;
    public static final String CHEMIN_FICHIERS = "/home/thierno/Bureau/HOO/JAVA/fichier/"; 
    private UtilisateurDao utilisateurDao; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.utilisateurDao = daoFactory.getUtilisateurDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//        String name = request.getParameter("name");
//        request.setAttribute("name", name);
//        String[] noms = {"Thierno", "Omar", "Rokhaya"}; 
//        request.setAttribute("noms", noms);
		
//		String [] titres = {"C'est le début de la formation", "JEE est utilisé par "};
//		request.setAttribute("titres", titres);
//		
//        Auteur auteur = new Auteur();
//        auteur.setPrenom("Thierno omar ");      
//        auteur.setNom("Diouf");
//        auteur.setActif(true);   
//        
//        request.setAttribute("auteur", auteur);
		
//		  Noms tableNoms = new Noms();
//	      request.setAttribute("utilisateurs", tableNoms.recupererUtilisateurs());
	      
	      request.setAttribute("utilisateurs", utilisateurDao.lister());
        
        
		this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
       // String nom = request.getParameter("nom");
        
	   // ConnectionForm form = new ConnectionForm();
	   // form.verifierIdentifiants(request);
	  // request.setAttribute("form", form);
		
       // request.setAttribute("nom", nom);
		
	    // On récupère le champ description comme d'habitude
//        String description = request.getParameter("description");
//        request.setAttribute("description", description );
//
//        // On récupère le champ du fichier
//        Part part = request.getPart("fichier");
//            
//        // On vérifie qu'on a bien reçu un fichier
//        String nomFichier = getNomFichier(part);
//
//        // Si on a bien un fichier
//        if (nomFichier != null && !nomFichier.isEmpty()) {
//            String nomChamp = part.getName();
//            // Corrige un bug du fonctionnement d'Internet Explorer
//             nomFichier = nomFichier.substring(nomFichier.lastIndexOf('/') + 1)
//                    .substring(nomFichier.lastIndexOf('\\') + 1);
//
//            // On écrit définitivement le fichier sur le disque
//            ecrireFichier(part, nomFichier, CHEMIN_FICHIERS);
//
//            request.setAttribute(nomChamp, nomFichier);
//        }
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(request.getParameter("nom"));
        utilisateur.setPrenom(request.getParameter("prenom"));
        
       // Noms tableNoms = new Noms();
       //   tableNoms.ajouterUtilisateur(utilisateur);
        
  //      request.setAttribute("utilisateurs", tableNoms.recupererUtilisateurs());
        
        utilisateurDao.ajouter(utilisateur);
        
        request.setAttribute("utilisateurs", utilisateurDao.lister());
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
		doGet(request, response);
	}
	
//    private void ecrireFichier( Part part, String nomFichier, String chemin ) throws IOException {
//        BufferedInputStream entree = null;
//        BufferedOutputStream sortie = null;
//        try {
//            entree = new BufferedInputStream(part.getInputStream(), TAILLE_TAMPON);
//            sortie = new BufferedOutputStream(new FileOutputStream(new File(chemin + nomFichier)), TAILLE_TAMPON);
//
//            byte[] tampon = new byte[TAILLE_TAMPON];
//            int longueur;
//            while ((longueur = entree.read(tampon)) > 0) {
//                sortie.write(tampon, 0, longueur);
//            }
//        } finally {
//            try {
//                sortie.close();
//            } catch (IOException ignore) {
//            }
//            try {
//                entree.close();
//            } catch (IOException ignore) {
//            }
//        }
//    }
//    
//    private static String getNomFichier( Part part ) {
//        for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
//            if ( contentDisposition.trim().startsWith( "filename" ) ) {
//                return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
//            }
//        }
//        return null;
//    }   

}

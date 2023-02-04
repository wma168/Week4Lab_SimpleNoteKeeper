package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author xbali
 */
public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Display the edit form
            String edit = request.getParameter("edit");
            if(edit != null){
                 getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
            }
        
        try{
             // Setting the file path
            String path = getServletContext().getRealPath("/WEB-INF/note.txt");
            
            // Reading the text file
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));
            
            // Reading the values into variables
            String title = br.readLine();
            String contents = br.readLine();
            
            // Creating a new instance of note 
            Note note = new Note(title, contents);
            
            // Setting the attribute for the jsp
            request.setAttribute("note", note);
            br.close();
            
        } catch (IOException e){
            
        }              
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Requesting the parameters to be written
        String title = request.getParameter("title");
        String contents = request.getParameter("contents");
        
        // Setting the file path
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        // Reading the text file
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));  
        
        // Reading in the values into variables
        pw.println(title);
        pw.print(contents);
        
        // Creating a new instance of note 
        Note note = new Note(title, contents);
        
        // Setting the attribute for the jsp
        request.setAttribute("note", note);
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        pw.close();   
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.usach.pingeso.taa.managedbeans.student;

import cl.usach.pingeso.taa.utils.General;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.io.File;
import java.io.IOException;
import org.primefaces.event.CaptureEvent;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.ServletContext;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.highgui.Highgui;

import org.opencv.objdetect.CascadeClassifier;
/**
 *
 * @author José Orellana
 */
@Named(value = "autenticationStudents")
@RequestScoped
public class AutenticationStudents {

    /**
     * Creates a new instance of AutenticationStudents
     */
    String photo;
    public AutenticationStudents() {
    }
    public void oncapture(CaptureEvent captureEvent) {
 
        // obtenemos los datos de la foto como array de bytes
        final byte[] datos = captureEvent.getData();
 
        final ServletContext servletContext = (ServletContext)FacesContext.getCurrentInstance().getExternalContext()
                .getContext();
        // le asignamos el nombre que sea a la imagen (en este caso siempre el mismo)
        this.photo = "p.png";
        // ruta destino de la imagen /photocam/foto.png
        final String fileFoto = servletContext.getRealPath("")+File.separator+"resources"+File.separator+"img"+File.separator+photo;
        System.out.println(servletContext.getRealPath(photo) + File.separator + "resources" + File.separator + "img" + File.separator + photo);
        FileImageOutputStream outputStream = null;
        try {
            outputStream = new FileImageOutputStream(new File(fileFoto));
            // guardamos la imagen
            outputStream.write(datos, 0, datos.length);
            
        } catch (IOException e) {
            throw new FacesException("Error guardando la foto.", e);
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
            }
        }
        
    }
 
    public void confirmStudents() {
        if(!this.FaceInPicture()){
            General.viewMessage(FacesMessage.SEVERITY_ERROR,
                    "No se detecta una cara en la imagen",
                    "No se detecta una cara en la imagen");
        }
        System.out.println("PASE");
    }
   private boolean FaceInPicture(){
        System.out.println("PASE");
        String path=System.getenv("CLASSPATH");  
        
        System.load("C:\\glassfish3\\jdk7\\lib\\opencv_java247.dll");
        System.out.println("C:\\glassfish3\\jdk7\\lib\\"+Core.NATIVE_LIBRARY_NAME+".dll");
        System.out.println("PASE2");
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        CascadeClassifier faceDetector = new CascadeClassifier("C:\\glassfish3\\jdk7\\lib\\"+"lbpcascade_frontalface.xml");
        
        
        System.out.println("PASE3");
        MatOfRect faceDetections = new MatOfRect();
        
        Mat imagen=new Mat();
        final ServletContext servletContext = (ServletContext)FacesContext.getCurrentInstance().getExternalContext()
                .getContext();
        
        
        String fileFoto = servletContext.getRealPath("")+File.separator+"resources"+File.separator+"img"+File.separator+photo;
         imagen = Highgui.imread(fileFoto,Highgui.CV_LOAD_IMAGE_COLOR);
       faceDetector.detectMultiScale(imagen, faceDetections); 
         int i=0;
         if ( !(faceDetections.empty())) {
            for (Rect rect : faceDetections.toArray()) {
                   //Core.rectangle(imagen, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 255, 0));
                   Highgui.imwrite(fileFoto+i+".png", imagen.submat(rect.y, rect.y + rect.width, rect.x, rect.x + rect.height));
                   i++;
            }
            return true;
          }

        return false;
    }
  
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
public boolean isVerFoto() {
        return photo != null;
    }
 
  
 
  
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package medicalimaging;

import javax.swing.ImageIcon;


/**
 * @author ericlee
 */
public abstract class MedicalImage extends StudyElement{
    public String imagePath;
    
    public abstract ImageIcon loadImage();
    
    public String toString() {
        return this.imagePath.substring(this.imagePath.lastIndexOf("/") + 1);
    }
}

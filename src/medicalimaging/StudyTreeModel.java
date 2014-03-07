/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package medicalimaging;

import java.util.ArrayList;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author ericlee
 */
public class StudyTreeModel implements TreeModel{
    private Study rootStudy;
    private ArrayList<TreeModelListener> listeners;
    
    public StudyTreeModel(Study root) {
        this.rootStudy = root;
        listeners = new ArrayList<TreeModelListener>();
    }

    @Override
    public Object getRoot() {
        return this.rootStudy;
    }

    @Override
    public Object getChild(Object parent, int index) {
        return rootStudy.getImage(index);
    }

    @Override
    public int getChildCount(Object parent) {
        return rootStudy.getImageCount();
    }

    @Override
    public boolean isLeaf(Object node) {
        return node instanceof MedicalImage;
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {
        TreeModelEvent event = new TreeModelEvent(newValue, path);
        for (TreeModelListener listener : listeners) {
            listener.treeStructureChanged(event);
        }
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        for(int i = 0; i < rootStudy.getImageCount(); i++) {
            if(child == rootStudy.getImage(i))
                return i;
        }
        return -1;
    }

    @Override
    public void addTreeModelListener(TreeModelListener l) {
        if (l != null && !listeners.contains(l)) {
            listeners.add(l);
        }
    }

    @Override
    public void removeTreeModelListener(TreeModelListener l) {
        if (l != null) {
            listeners.remove(l);
        }
    }
    
    public void setRootStudy(Study study) {
        this.rootStudy = study;
        this.valueForPathChanged(new TreePath(this.rootStudy), this.rootStudy);
    }
}
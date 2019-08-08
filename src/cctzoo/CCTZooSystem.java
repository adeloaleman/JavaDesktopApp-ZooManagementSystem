/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctzoo;

import cctzoo.controller.TheController;
import cctzoo.model.TheModel;
import cctzoo.view.TheView;

/**
 *
 * @author guerr
 */
public class CCTZooSystem {
    
    TheModel model;
    TheView view;
    TheController control;

    public CCTZooSystem() {
        
        model = new TheModel();
        view = new TheView(model);
        control = new TheController(model, view);
        
    }
    
}

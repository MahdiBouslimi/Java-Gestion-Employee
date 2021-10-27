/*
* dibuat oleh Ucup Timposu
* Blog: www.timposu.com
* Email : ucup.timposu@gmail.com
* Silahkan kode ini dipelajari dan dikembangkan..
*
**/


package Controller;

import model.Employerr;
import Interface_Controlle.Interface;
import Interface_Controlle.UI;
import table_model.TabelModelemployer;
import View.PanelForm;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class Controller {

    private final PanelForm panel;
    private List<Employerr> list;
    private final Interface implementemployer;
    
    public Controller(PanelForm panel) {
        this.panel = panel;
        implementemployer = new UI();
        list = implementemployer.getAllemployer();
    }
    
    public void reset(){
        panel.getTxtRef().setText("");
        panel.getTxtnom().setText("");
        panel.getTxtmobile().setText("");
        panel.getTxttel().setText("");
        panel.getTxtresp().setText("");
        panel.getTxtservice().setText("");
        panel.getTxtsos().setText("");
        panel.getTableemployer().clearSelection();
    }
    
    public void TabelAllemployer(){
        list = implementemployer.getAllemployer();
        panel.getTableemployer().setModel(new TabelModelemployer(list));
        
    }
    
    public  void getDataField(){
        
        int row = panel.getTableemployer().getSelectedRow();
        
        if (row != -1){
            
            panel.getTxtRef().setText(String.valueOf(list.get(row).getRefernce()));
            panel.getTxtnom().setText(list.get(row).getNom());
            panel.getTxtmobile().setText(String.valueOf(list.get(row).getNmobile()));

            panel.getTxttel().setText(String.valueOf(list.get(row).getTel_fix()));
            panel.getTxtresp().setText(list.get(row).getResp_hirar());
            panel.getTxtservice().setText(list.get(row).getService());
            panel.getTxtsos().setText(String.valueOf(list.get(row).getSos_pal()));
            
            
        }
       
    }
    
    public void insert(){
         if (panel.getTxtRef().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Remplissez les données ....? ", null, JOptionPane.WARNING_MESSAGE);
           
        }
         else{
        
        Employerr user = new Employerr();
        user.setRefernce(panel.getTxtRef().getText());
        user.setNom(panel.getTxtnom().getText());
        user.setNmobile(panel.getTxtmobile().getText());
        user.setTel_fix(panel.getTxttel().getText());
        user.setResp_hirar(panel.getTxtresp().getText());
        user.setService(panel.getTxtservice().getText());
        user.setSos_pal(panel.getTxtsos().getText());
        
        implementemployer.input(user);
         }
    }

    public void update(){
        
            int row = panel.getTableemployer().getSelectedRow();
        
        if (row == -1){
            
            JOptionPane.showMessageDialog(panel, "Selectionnez un champ ....? ", null, JOptionPane.WARNING_MESSAGE);
            
        }
        else{
        
        Employerr user = new Employerr();
        user.setRefernce(panel.getTxtRef().getText());
        user.setNom(panel.getTxtnom().getText());
        user.setNmobile(panel.getTxtmobile().getText());
        user.setTel_fix((panel.getTxttel().getText()));
        user.setResp_hirar(panel.getTxtresp().getText());
        user.setService(panel.getTxtservice().getText());
        user.setSos_pal(panel.getTxtsos().getText());
        
        implementemployer.update(user);
        }
    }
    
    public void delete(){
        
        if (panel.getTxtRef().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Aucune donnée supprimée....? ",null, JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String row = panel.getTxtRef().getText();
        
        implementemployer.delete(row);
        
    }
    
    
    public void getData(){
        
        if (panel.getTxtnom().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Remplissez les données de nom que vous souhaitez rechercher....? ", null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String name = panel.getTxtnom().getText();
        
        implementemployer.getemployer(name);
        tableRecherche(name);
    }

   public void tableRecherche(String name){
        
        list = implementemployer.getemployer(name);
        panel.getTableemployer().setModel(new TabelModelemployer(list));
    }
}
    


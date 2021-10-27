/*
* dibuat oleh Ucup Timposu
* Blog: www.timposu.com
* Email : ucup.timposu@gmail.com
* Silahkan kode ini dipelajari dan dikembangkan..
*
**/


package Interface_Controlle;

import model.Employerr;
import ConnectionDb.ConnectionDatabase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class UI implements Interface{
    
    private List<Employerr> list;
            
    @Override
    public void input(Employerr user) {
        
        try {
            PreparedStatement statement = ConnectionDatabase.getConnection().prepareStatement(""
                    + "INSERT INTO employerr (reference, nom, tel_fixe, nmobile, resp_hirar, service, sos_pal) VALUES (?, ?, ?, ?, ?, ?, ?)");
            
            statement.setString(1, user.getRefernce());
            statement.setString(2, user.getNom());
            statement.setString(3, user.getTel_fix());
            statement.setString(4, user.getNmobile());
            statement.setString(5, user.getResp_hirar());
            statement.setString(6, user.getService());
            statement.setString(7, user.getSos_pal());
            
            statement.executeUpdate();
          
          
            statement.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void update(Employerr user) {
          try {
            PreparedStatement statement = ConnectionDatabase.getConnection().prepareStatement("UPDATE employerr SET  nom=?,tel_fixe=?,nmobile=?,resp_hirar=?,service=?,sos_pal=? WHERE reference=?");
            
            statement.setString(1, user.getNom());
            statement.setString(2, user.getTel_fix());
            statement.setString(3, user.getNmobile());
            statement.setString(4, user.getResp_hirar());
            statement.setString(5, user.getService());
            statement.setString(6, user.getSos_pal());
            statement.setString(7, user.getRefernce());
            
          
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
        }
           
          
    }

    @Override
    public void delete(String id) {
   
          try {
            PreparedStatement statement = ConnectionDatabase.getConnection().prepareStatement(""
                    + "DELETE FROM employerr WHERE reference=?");
            
            statement.setString(1, id);
            
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }

    @Override
    public List<Employerr> getemployer(String name) {
        list = new ArrayList<Employerr>();
        
        try {
            
            Statement statement = ConnectionDatabase.getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM employerr WHERE nom LIKE '%" + name + "%'");
            
            while (result.next()) { 
                Employerr user = new Employerr();
                user.setRefernce(result.getString("reference"));
                user.setNom(result.getString("nom"));
                user.setTel_fix(result.getString("tel_fixe"));
                user.setNmobile(result.getString("nmobile"));
                user.setResp_hirar(result.getString("resp_hirar"));
                user.setService(result.getString("service"));
                user.setSos_pal(result.getString("sos_pal"));
                
                list.add(user);
            }
            
            statement.close();
            result.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

    @Override
    public List<Employerr> getAllemployer() {
    list = new ArrayList<Employerr>();
        
        try {
            
            Statement statement = ConnectionDatabase.getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM employerr");
            
            while (result.next()) { 
                Employerr user = new Employerr();
                user.setRefernce(result.getString("reference"));
                user.setNom(result.getString("nom"));
                user.setTel_fix(result.getString("tel_fixe"));
                user.setNmobile(result.getString("nmobile"));
                user.setResp_hirar(result.getString("resp_hirar"));
                user.setService(result.getString("service"));
                user.setSos_pal(result.getString("sos_pal"));
                list.add(user);
            }
            
            
            statement.close();
            result.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}

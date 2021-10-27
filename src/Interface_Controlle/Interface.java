/*
* dibuat oleh Ucup Timposu
* Blog: www.timposu.com
* Email : ucup.timposu@gmail.com
* Silahkan kode ini dipelajari dan dikembangkan..
*
**/

package Interface_Controlle;

import model.Employerr;
import java.util.List;

/**
 *
 * @author HP
 */
public interface Interface {
    
    public void input(Employerr user);
    
    public void update(Employerr user);
    
    public void delete(String id);
    
    public List<Employerr> getemployer(String name);
    
    public List<Employerr> getAllemployer();

}

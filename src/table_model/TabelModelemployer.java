/*
* dibuat oleh Ucup Timposu
* Blog: www.timposu.com
* Email : ucup.timposu@gmail.com
* Silahkan kode ini dipelajari dan dikembangkan..
*
**/


package table_model;

import model.Employerr;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ucup
 */
public class TabelModelemployer extends AbstractTableModel{
    private static final long serialVersionUID = 1L;

    List<Employerr> list ;

    public TabelModelemployer(List<Employerr> list) {
        this.list = list;
    }
       
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 : return list.get(rowIndex).getRefernce();
            case 1 : return list.get(rowIndex).getNom();
            case 2 : return list.get(rowIndex).getTel_fix();
            case 3 : return list.get(rowIndex).getNmobile();
            case 4 : return list.get(rowIndex).getResp_hirar();
            case 5 : return list.get(rowIndex).getService();
            case 6 : return list.get(rowIndex).getSos_pal();
            
                default:return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0 : return "reference";
            case 1 : return "nom";
            case 2 : return "tel_fix";
            case 3 : return "nmobile";
            case 4 : return "resp_hirar";
            case 5 : return "service";
            case 6 : return "sos_pal";    
                default:return null;
        }
    }
    
    

}

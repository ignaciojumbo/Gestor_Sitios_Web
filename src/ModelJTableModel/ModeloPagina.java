package ModelJTableModel;

import Modelo.Pagina;
import Vista.GestorSitiosWeb_IG;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeloPagina extends AbstractTableModel {

    public String[] n_colNames = {"FECHA DE REGISTRO", "NOMBRE DE LA PAGINA", "LINK DE PAGINA","TIPO DE PÁGINA","USUARIO","CONTRASEÑA"};
    public List<Pagina> listpagina;
    private GestorSitiosWeb_IG gContable;

    public ModeloPagina(List<Pagina> listpagina, GestorSitiosWeb_IG gContable) {
        this.listpagina = listpagina;
        this.gContable = gContable;
    }

    @Override
    public int getRowCount() {
        //determina el numero de fila que tengo en mi tabla
        return listpagina.size();
    }

    @Override
    public int getColumnCount() {
        return n_colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pagina p = this.listpagina.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return p.getFechaRegistro();
            case 1:
                return p.getNombrePagina();
            case 2:
                return p.getLinkPagina();
            case 3:
                return p.getTipoPagina();
            case 4: 
                return p.getUsuario();
            case 5:
               return p.getClave();
        }
        return new String();
    }

    public String getColumnName(int column) {
        return n_colNames[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        gContable.clickPagina(listpagina.get(rowIndex));
        return super.isCellEditable(rowIndex, columnIndex);

    }
    

    public List<Pagina> getPagina() {
        return listpagina;
    }

    public void setListaPagina(List<Pagina> pagina) {
        this.listpagina = pagina;
    }

}

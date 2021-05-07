package Controlador;

import Conexion.conexion;
import Modelo.Pagina;
import Utilidad.Utilidad;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetImpl;
import com.mysql.jdbc.Statement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Controladorbd {

    Statement stm = null;
    Connection con = null;
    conexion conexion = new conexion();
    Utilidad util;

    public Controladorbd() {
        util = new Utilidad();
    }

    public boolean registrarLink(Pagina pagina) {
        boolean registar = false;
        String sql;
        if (pagina.getUsuario() == null && pagina.getClave() == null) {
            sql = "INSERT INTO `gestorpagina`.`linkpagina` "
                    + "(`fechaRegistro`, "
                    + "`nombrePagina`, "
                    + "`linkPagina`, "
                    + "`tipoPagina`"
                    + "`descripcion`"
                    + ") VALUES ("
                    + "'" + pagina.getFechaRegistro() + "', "
                    + "'" + pagina.getNombrePagina() + "', "
                    + "'" + pagina.getLinkPagina() + "', "
                    + "'" + pagina.getTipoPagina()+ "', "
                    + "'" + pagina.getDescripcion()+ "');";

        } else {
            sql = "INSERT INTO `gestorpagina`.`linkpagina` ("
                    + "`fechaRegistro`, "
                    + "`nombrePagina`, "
                    + "`linkPagina`, "
                    + "`tipoPagina`, "
                    + "`descripcion`, "
                    + "`usuario`, "
                    + "`contraseña`) "
                    + "VALUES ("
                    + "'"+pagina.getFechaRegistro()+"', "
                    + "'"+pagina.getNombrePagina()+"', "
                    + "'"+pagina.getLinkPagina()+"', "
                    + "'"+pagina.getTipoPagina()+"', "
                    + "'"+pagina.getDescripcion()+"', "
                    + "'"+pagina.getUsuario()+"', "
                    + "'"+util.encriptadorclave(pagina.getClave())+"');";
        }

        try {
            con = conexion.getConexion();
            stm = (Statement) con.createStatement();
            stm.execute(sql);
            registar = true;
            stm.close();
//            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return registar;
    }

    public boolean editar(Pagina pagina) {
        boolean editar = false;

        String sql;
        if (pagina.getUsuario() == null && pagina.getClave() == null) {
            sql = "UPDATE `gestorpagina`.`linkpagina` SET "
                    + "`fechaRegistro` = '" + pagina.getFechaRegistro() + "', "
                    + "`nombrePagina` = '" + pagina.getNombrePagina() + "', "
                    + "`linkPagina` = '" + pagina.getLinkPagina() + "' "
                    + "`descripcion` = '" + pagina.getDescripcion()+ "' "
                    + "WHERE ("
                    + "`idlinkPagina` = '" + pagina.getIdPagina() + "');";
        } else {
            sql = "UPDATE `gestorpagina`.`linkpagina` SET "
                    + "`nombrePagina` = '"+pagina.getNombrePagina()+"', "
                    + "`linkPagina` = '"+pagina.getLinkPagina()+"', "
                    + "`tipoPagina` = '"+pagina.getTipoPagina()+"', "
                    + "`descripcion` = '"+pagina.getDescripcion()+"', "
                    + "`usuario` = '"+pagina.getUsuario()+"', "
                    + "`contraseña` = '"+util.encriptadorclave(pagina.getClave())+"'"
                    + " WHERE (`idlinkPagina` = '"+pagina.getIdPagina()+"');";
        }

        try {
            con = conexion.getConexion();
            stm = (Statement) con.createStatement();
            stm.execute(sql);
            editar = true;
            stm.close();
//            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return editar;

    }

    public boolean eliminar(Pagina pagina) {
        boolean eliminar = false;
        String sql = "DELETE FROM `gestorpagina`.`linkpagina` WHERE ("
                + "`idlinkPagina` = '" + pagina.getIdPagina() + "');";

        try {
            con = conexion.getConexion();
            stm = (Statement) con.createStatement();
            stm.execute(sql);
            eliminar = true;
            stm.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return eliminar;

    }

    public List<Pagina> obtenerlinkspaginas() {
        Connection co = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSetImpl rs;
        String sql = "SELECT * FROM gestorpagina.linkpagina";

        List<Pagina> listaPaginas = new ArrayList<>();
        try {
            con = new conexion().getConexion();
            stm = (Statement) con.createStatement();
            rs = (ResultSetImpl) stm.executeQuery(sql);
            while (rs.next()) {
                Pagina in = new Pagina();
                in.setIdPagina(rs.getInt(1));
                in.setFechaRegistro(rs.getString(2));
                in.setNombrePagina(rs.getString(3));
                in.setLinkPagina(rs.getString(4));
                in.setTipoPagina(rs.getString(5));
                in.setDescripcion(rs.getString(6));
                in.setUsuario(rs.getString(7));
                in.setClave(rs.getString(8));
                listaPaginas.add(in);
            }
            stm.close();
            rs.close();
//            con.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }

        return listaPaginas;
    }

    public List<Pagina> buscarPaginasnombre(String nombrePagina) {
        Connection co = null;
        ResultSetImpl rs;
        Pagina in = null;
        String sql = "SELECT * FROM gestorpagina.linkpagina where nombrePagina like \"%" + nombrePagina + "%\"";
        List<Pagina> listaPaginas = new ArrayList<>();
        try {
            con = new conexion().getConexion();
            stm = (Statement) con.createStatement();
            rs = (ResultSetImpl) stm.executeQuery(sql);
            while (rs.next()) {
                in = new Pagina();
                in.setIdPagina(rs.getInt(1));
                in.setFechaRegistro(rs.getString(2));
                in.setNombrePagina(rs.getString(3));
                in.setLinkPagina(rs.getString(4));
                in.setTipoPagina(rs.getString(5));
                in.setDescripcion(rs.getString(6));
                in.setUsuario(rs.getString(7));
                in.setClave(util.Desencriptadoclave(rs.getString(8)));
                listaPaginas.add(in);

            }
            stm.close();
            rs.close();
//            con.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }

        return listaPaginas;
    }
    
     public List<Pagina> buscarPaginasCategoria(String categoria) {
        Connection co = null;
        ResultSetImpl rs;
        Pagina in = null;
        String sql = "SELECT * FROM gestorpagina.linkpagina where tipoPagina like \"%" + categoria + "%\"";
        List<Pagina> listaPaginas = new ArrayList<>();
        try {
            con = new conexion().getConexion();
            stm = (Statement) con.createStatement();
            rs = (ResultSetImpl) stm.executeQuery(sql);
            while (rs.next()) {
                in = new Pagina();
                in.setIdPagina(rs.getInt(1));
                in.setFechaRegistro(rs.getString(2));
                in.setNombrePagina(rs.getString(3));
                in.setLinkPagina(rs.getString(4));
                in.setTipoPagina(rs.getString(5));
                in.setDescripcion(rs.getString(6));
                in.setUsuario(rs.getString(7));
                in.setClave(util.encriptadorclave(rs.getString(8)));
                listaPaginas.add(in);

            }
            stm.close();
            rs.close();
//            con.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }

        return listaPaginas;
    }
}

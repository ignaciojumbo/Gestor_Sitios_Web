/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Pagina;
import Utilidad.Utilidad;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class gestionPagina {

    private JTextField txtfehcaregistro;
    private JTextField txtnombre;
    private JTextField link;
    private JComboBox cbxtipoPagina;
    private JTextField txtusuario;
    private JPasswordField txtclave;
    private Utilidad util;
    private JFrame frame;

    public gestionPagina(JTextField txtfehcaregistro, JTextField txtnombre, JTextField link, JComboBox cbxtipoPagina, JTextField txtusuario, JPasswordField txtclave, Utilidad util, JFrame frame) {
        this.txtfehcaregistro = txtfehcaregistro;
        this.txtnombre = txtnombre;
        this.link = link;
        this.cbxtipoPagina = cbxtipoPagina;
        this.txtusuario = txtusuario;
        this.txtclave = txtclave;
        this.util = util;
        this.frame = frame;
    }

    public JComboBox getCbxtipoPagina() {
        return cbxtipoPagina;
    }

    public void setCbxtipoPagina(JComboBox cbxtipoPagina) {
        this.cbxtipoPagina = cbxtipoPagina;
    }

    public JTextField getTxtusuario() {
        return txtusuario;
    }

    public void setTxtusuario(JTextField txtusuario) {
        this.txtusuario = txtusuario;
    }

    public JPasswordField getTxtclave() {
        return txtclave;
    }

    public void setTxtclave(JPasswordField txtclave) {
        this.txtclave = txtclave;
    }

    public Utilidad getUtil() {
        return util;
    }

    public void setUtil(Utilidad util) {
        this.util = util;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JTextField getTxtnombre() {
        return txtnombre;
    }

    public void setTxtnombre(JTextField txtnombre) {
        this.txtnombre = txtnombre;
    }

    public JTextField getTxtfehcaregistro() {
        return txtfehcaregistro;
    }

    public void setTxtfehcaregistro(JTextField txtfehcaregistro) {
        this.txtfehcaregistro = txtfehcaregistro;
    }

    public JTextField getLink() {
        return link;
    }

    public void setLink(JTextField link) {
        this.link = link;
    }

    public void limpiar() {
        txtnombre.setText("");
        cbxtipoPagina.setSelectedIndex(0);
        link.setText("");
        txtclave.setText("");
        txtusuario.setText("");
    }

    public Pagina guardar() {

        if (txtnombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Llene el campo de nombre de la pagina", "Error", JOptionPane.ERROR_MESSAGE);
            txtnombre.requestFocus();
            return null;
        }
        if (link.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Llene el campo del link de la pagina", "Error", JOptionPane.ERROR_MESSAGE);
            link.requestFocus();
            return null;
        }
        if (!util.urlValidator(link.getText())) {
            JOptionPane.showMessageDialog(frame, "Error de url", "Error", JOptionPane.ERROR_MESSAGE);
            link.requestFocus();
            return null;
        }

        Pagina p = new Pagina();
        p.setNombrePagina(txtnombre.getText());
        p.setFechaRegistro(txtfehcaregistro.getText());
        p.setLinkPagina(link.getText());
        p.setTipoPagina(cbxtipoPagina.getSelectedItem().toString());
        p.setUsuario(txtusuario.getText());
        p.setClave(txtclave.getText());
        return p;

    }
}

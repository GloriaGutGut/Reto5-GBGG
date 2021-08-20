package modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import modelo.vo.Requerimiento_2Vo;
import util.JDBCUtilities;

public class Requerimiento_2Dao {
    public ArrayList<Requerimiento_2Vo> requerimiento2() throws SQLException {
        ArrayList<Requerimiento_2Vo> listadoRegistros_rq2 = new ArrayList<Requerimiento_2Vo>();
        Connection connex = JDBCUtilities.getConnection();
        String sql = "SELECT p.id_Proyecto, c.proveedor FROM Proyecto p JOIN compra c ON (p.id_Proyecto = c.id_Proyecto) WHERE p.ciudad = 'Neiva' ORDER BY p.id_Proyecto;";
            try (Statement stmt = connex.createStatement(); ResultSet rs = stmt.executeQuery(sql)){
                while (rs.next()) {
                    Requerimiento_2Vo requerimiento2 = new Requerimiento_2Vo();
                    requerimiento2.setIdProyecto(rs.getInt("Id_Proyecto"));
                    requerimiento2.setProveedor(rs.getString("Proveedor"));
                    listadoRegistros_rq2.add(requerimiento2);
                    }
                rs.close();
                connex.close();
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error de conexión a la BD:"+e);
            }
            return listadoRegistros_rq2;
    }
}
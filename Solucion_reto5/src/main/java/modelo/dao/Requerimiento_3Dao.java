package modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import modelo.vo.Requerimiento_3Vo;
import util.JDBCUtilities;

public class Requerimiento_3Dao {
    public ArrayList<Requerimiento_3Vo> requerimiento3() throws SQLException {
        ArrayList<Requerimiento_3Vo> listadoRegistros_rq3 = new ArrayList<Requerimiento_3Vo>();
        Connection connex = JDBCUtilities.getConnection();
        String sql = "SELECT p.id_Proyecto, mc.nombre_Material FROM Proyecto p JOIN compra c ON (p.id_Proyecto = c.id_Proyecto) JOIN MaterialConstruccion mc ON (c.id_MaterialConstruccion = mc.id_MaterialConstruccion) WHERE p.id_Proyecto between 40 and 55 ORDER BY p.id_Proyecto ASC;";
            try (Statement stmt = connex.createStatement(); ResultSet rs = stmt.executeQuery(sql)){
                while (rs.next()) {
                    Requerimiento_3Vo requerimiento3 = new Requerimiento_3Vo();
                    requerimiento3.setIdProyecto(rs.getInt("id_Proyecto"));
                    requerimiento3.setNombreMaterial(rs.getString("nombre_Material"));
                    listadoRegistros_rq3.add(requerimiento3);
                    }
                rs.close();
                connex.close();
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error de conexión a la BD:"+e);
            }
            return listadoRegistros_rq3;
    }
}

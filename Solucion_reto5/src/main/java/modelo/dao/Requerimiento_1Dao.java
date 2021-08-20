package modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.vo.Requerimiento_1Vo;
import util.JDBCUtilities;

public class Requerimiento_1Dao {
    public ArrayList<Requerimiento_1Vo> requerimiento1() throws SQLException {
        ArrayList<Requerimiento_1Vo> listadoRegistros_rq1 = new ArrayList<Requerimiento_1Vo>();
        Connection connex = JDBCUtilities.getConnection();
        String sql = "SELECT ciudad_Residencia, ROUND(AVG(Salario)) as promedio FROM Lider GROUP BY ciudad_Residencia HAVING AVG(Salario)<400000 ORDER BY promedio DESC;";
        try (Statement stmt = connex.createStatement(); ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()) {
                Requerimiento_1Vo requerimiento1 = new Requerimiento_1Vo();
                requerimiento1.setCiudadResidencia(rs.getString("Ciudad_Residencia"));
                requerimiento1.setPromedio(rs.getInt("Promedio"));
                listadoRegistros_rq1.add(requerimiento1);
                }
            rs.close();
            connex.close();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error de conexión a la BD: "+e);
        }
        return listadoRegistros_rq1;
    }
}
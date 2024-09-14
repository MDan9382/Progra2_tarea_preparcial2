package uni.prog2.Dao;

import uni.prog2.Model.ModelDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static uni.prog2.Manager.ConnectionManager.getConnection;

public class DaoDatos {



    public void insert(ModelDatos datos) throws SQLException {
        String query = "INSERT INTO tb_datos (nombre, apellido, departamento, fecha_nacimiento) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, datos.getNombre());
            pstmt.setString(2, datos.getApellido());
            pstmt.setString(3, datos.getDepartamento());
            pstmt.setTimestamp(4, datos.getFechaNacimiento());
            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    datos.setCodigo(generatedKeys.getInt(1));
                }
            }
        }
    }

    public ModelDatos getById(int codigo) throws SQLException {
        String query = "SELECT * FROM tb_datos WHERE codigo = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, codigo);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new ModelDatos(
                            rs.getInt("codigo"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getString("departamento"),
                            rs.getTimestamp("fecha_nacimiento")
                    );
                } else {
                    return null;
                }
            }
        }
    }

    public List<ModelDatos> getAll() throws SQLException {
        List<ModelDatos> list = new ArrayList<>();
        String query = "SELECT * FROM tb_datos";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query); ResultSet rs = pstmt.executeQuery(query)) {
            while (rs.next()) {
                list.add(new ModelDatos(

                        rs.getInt("codigo"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("departamento"),
                        rs.getTimestamp("fecha_nacimiento")
                ));
            }
        }
        return list;
    }

    public void update(ModelDatos datos) throws SQLException {
        String query = "UPDATE tb_datos SET nombre = ?, apellido = ?, departamento = ?, fecha_nacimiento = ? WHERE codigo = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, datos.getNombre());
            pstmt.setString(2, datos.getApellido());
            pstmt.setString(3, datos.getDepartamento());
            pstmt.setTimestamp(4, datos.getFechaNacimiento());
            pstmt.setInt(5, datos.getCodigo());
            pstmt.executeUpdate();
        }
    }

    public void delete(int codigo) throws SQLException {
        String query = "DELETE FROM tb_datos WHERE codigo = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, codigo);
            pstmt.executeUpdate();
        }
    }

}

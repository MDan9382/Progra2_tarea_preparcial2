package uni.prog2.Dao;

import uni.prog2.Model.ModelEquipo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static uni.prog2.Manager.ConnectionManager.getConnection;

public class DaoEquipo {


    public void addEquipo(ModelEquipo equipo) throws SQLException {
        String query = "INSERT INTO equipos_champions (nombre, pais, ciudad, estadio, fundacion, entrenador, web_oficial, facebook, twitter, instagram, patrocinador_principal) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, equipo.getNombre());
            pstmt.setString(2, equipo.getPais());
            pstmt.setString(3, equipo.getCiudad());
            pstmt.setString(4, equipo.getEstadio());
            pstmt.setInt(5, equipo.getFundacion());
            pstmt.setString(6, equipo.getEntrenador());
            pstmt.setString(7, equipo.getWebOficial());
            pstmt.setString(8, equipo.getFacebook());
            pstmt.setString(9, equipo.getTwitter());
            pstmt.setString(10, equipo.getInstagram());
            pstmt.setString(11, equipo.getPatrocinadorPrincipal());
            pstmt.executeUpdate();
        }
    }

    public ModelEquipo getEquipo(int id) throws SQLException {
        String query = "SELECT * FROM equipos_champions WHERE id_equipo = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                ModelEquipo equipo = new ModelEquipo();
                equipo.setIdEquipo(rs.getInt("id_equipo"));
                equipo.setNombre(rs.getString("nombre"));
                equipo.setPais(rs.getString("pais"));
                equipo.setCiudad(rs.getString("ciudad"));
                equipo.setEstadio(rs.getString("estadio"));
                equipo.setFundacion(rs.getInt("fundacion"));
                equipo.setEntrenador(rs.getString("entrenador"));
                equipo.setWebOficial(rs.getString("web_oficial"));
                equipo.setFacebook(rs.getString("facebook"));
                equipo.setTwitter(rs.getString("twitter"));
                equipo.setInstagram(rs.getString("instagram"));
                equipo.setPatrocinadorPrincipal(rs.getString("patrocinador_principal"));
                equipo.setCreadoEn(rs.getTimestamp("creado_en"));
                return equipo;
            }
        }
        return null;
    }

    public List<ModelEquipo> getAllEquipos() throws SQLException {
        List<ModelEquipo> equipos = new ArrayList<>();
        String query = "SELECT * FROM equipos_champions";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery(query)) {
            while (rs.next()) {
                ModelEquipo equipo = new ModelEquipo();
                equipo.setIdEquipo(rs.getInt("id_equipo"));
                equipo.setNombre(rs.getString("nombre"));
                equipo.setPais(rs.getString("pais"));
                equipo.setCiudad(rs.getString("ciudad"));
                equipo.setEstadio(rs.getString("estadio"));
                equipo.setFundacion(rs.getInt("fundacion"));
                equipo.setEntrenador(rs.getString("entrenador"));
                equipo.setWebOficial(rs.getString("web_oficial"));
                equipo.setFacebook(rs.getString("facebook"));
                equipo.setTwitter(rs.getString("twitter"));
                equipo.setInstagram(rs.getString("instagram"));
                equipo.setPatrocinadorPrincipal(rs.getString("patrocinador_principal"));
                equipo.setCreadoEn(rs.getTimestamp("creado_en"));
                equipos.add(equipo);
            }
        }
        return equipos;
    }

    public void updateEquipo(ModelEquipo equipo) throws SQLException {
        String query = "UPDATE equipos_champions SET nombre = ?, pais = ?, ciudad = ?, estadio = ?, fundacion = ?, entrenador = ?, web_oficial = ?, facebook = ?, twitter = ?, instagram = ?, patrocinador_principal = ? WHERE id_equipo = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, equipo.getNombre());
            pstmt.setString(2, equipo.getPais());
            pstmt.setString(3, equipo.getCiudad());
            pstmt.setString(4, equipo.getEstadio());
            pstmt.setInt(5, equipo.getFundacion());
            pstmt.setString(6, equipo.getEntrenador());
            pstmt.setString(7, equipo.getWebOficial());
            pstmt.setString(8, equipo.getFacebook());
            pstmt.setString(9, equipo.getTwitter());
            pstmt.setString(10, equipo.getInstagram());
            pstmt.setString(11, equipo.getPatrocinadorPrincipal());
            pstmt.setInt(12, equipo.getIdEquipo());
            pstmt.executeUpdate();
        }
    }

    public void deleteEquipo(int id) throws SQLException {
        String query = "DELETE FROM equipos_champions WHERE id_equipo = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

}

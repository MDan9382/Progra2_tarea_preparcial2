package uni.prog2.Service;

import uni.prog2.Dao.DaoEquipo;
import uni.prog2.Model.ModelEquipo;

import java.sql.SQLException;
import java.util.List;

public class ServiceEquipo {

    private DaoEquipo equipoDAO;

    public ServiceEquipo() {
        this.equipoDAO = new DaoEquipo();
    }

    public void addEquipo(ModelEquipo equipo) throws SQLException {
        equipoDAO.addEquipo(equipo);
    }

    public ModelEquipo getEquipo(int id) throws SQLException {
        return equipoDAO.getEquipo(id);
    }

    public List<ModelEquipo> getAllEquipos() throws SQLException {
        return equipoDAO.getAllEquipos();
    }

    public void updateEquipo(ModelEquipo equipo) throws SQLException {
        equipoDAO.updateEquipo(equipo);
    }

    public void deleteEquipo(int id) throws SQLException {
        equipoDAO.deleteEquipo(id);
    }

}

package uni.prog2.Service;

import uni.prog2.Dao.DaoDatos;
import uni.prog2.Model.ModelDatos;

import java.sql.SQLException;
import java.util.List;

public class SeriviceDatos {

    private DaoDatos datosDAO;

    public void DatosService() {
        this.datosDAO = new DaoDatos();
    }

    public void addDatos(ModelDatos datos) throws SQLException {
        datosDAO.insert(datos);
    }

    public ModelDatos getDatosById(int codigo) throws SQLException {
        return datosDAO.getById(codigo);
    }

    public List<ModelDatos> getAllDatos() throws SQLException {
        return datosDAO.getAll();
    }

    public void updateDatos(ModelDatos datos) throws SQLException {
        datosDAO.update(datos);
    }

    public void deleteDatos(int codigo) throws SQLException {
        datosDAO.delete(codigo);
    }

}

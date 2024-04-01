package core.repositories;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface Repository<DataClass> {
    void save(DataClass data) throws SQLException;
    List<DataClass> findAll() throws SQLException;
    void update(String code, DataClass newDataObject) throws SQLException;
    void delete(String code) throws SQLException;
}

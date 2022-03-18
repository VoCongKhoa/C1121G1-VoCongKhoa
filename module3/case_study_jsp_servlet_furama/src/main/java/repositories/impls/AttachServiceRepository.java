package repositories.impls;

import models.AttachService;
import repositories.BaseRepository;
import repositories.IAttachServiceRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AttachServiceRepository implements IAttachServiceRepository {
    BaseRepository baseRepository = new BaseRepository();

    @Override
    public AttachService getAttachService(int attachServiceId) {
        AttachService attachService = null;
        Connection connection = null;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT attach_service_id, " +
                    "attach_service_name, attach_service_cost, attach_service_unit, attach_service_status " +
                    "FROM attach_service WHERE attach_service_id = ?;");
            preparedStatement.setInt(1, attachServiceId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int attachServiceIdGetOne = resultSet.getInt("attach_service_id");
                String attachServiceName = resultSet.getString("attach_service_name");
                double attachServiceCost = resultSet.getDouble("attach_service_cost");
                int attachServiceUnit = resultSet.getInt("attach_service_unit");
                String attachServiceStatus = resultSet.getString("attach_service_status");
                attachService = new AttachService(attachServiceIdGetOne, attachServiceName, attachServiceCost,
                        attachServiceUnit, attachServiceStatus);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return attachService;
    }
}

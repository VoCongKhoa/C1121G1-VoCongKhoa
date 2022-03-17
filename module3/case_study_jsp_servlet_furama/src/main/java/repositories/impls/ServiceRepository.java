package repositories.impls;

import models.RentType;
import models.Service;
import models.ServiceType;
import repositories.BaseRepository;
import repositories.IServiceRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository implements IServiceRepository {
    BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Service> getAllService() {
        List<Service> serviceList = new ArrayList<>();
        //Chu y: phai khoi tao new ArrayList<>() cho List<>, neu khong se sinh ra NullPointException;
        Connection connection;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT service_id, service_code, " +
                    "service_name, service_area, service_cost, service_max_people, standard_room, " +
                    "description_other_convenience, pool_area, number_of_floors, rent_type.rent_type_id, " +
                    "rent_type.rent_type_name, rent_type.rent_type_cost, service_type.service_type_id, " +
                    "service_type.service_type_name " +
                    "FROM service\n" +
                    "INNER JOIN rent_type ON service.rent_type_id = rent_type.rent_type_id\n" +
                    "INNER JOIN service_type ON service.service_type_id = service_type.service_type_id\n" +
                    "ORDER BY service_id;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int serviceId = resultSet.getInt("service_id");
                String serviceCode = resultSet.getString("service_code");
                String serviceName = resultSet.getString("service_name");
                int serviceArea = resultSet.getInt("service_area");
                double serviceCost = resultSet.getDouble("service_cost");
                int serviceMaxPeople = resultSet.getInt("service_max_people");
                String standardRoom = resultSet.getString("standard_room");
                String descriptionOtherConvenience = resultSet.getString("description_other_convenience");
                double poolArea = resultSet.getDouble("pool_area");
                int numberOfFloors = resultSet.getInt("number_of_floors");
                int rentTypeId = resultSet.getInt("rent_type_id");
                String rentTypeName = resultSet.getString("rent_type_name");
                double rentTypeCost = resultSet.getDouble("rent_type_cost");
                int serviceTypeId = resultSet.getInt("service_type_id");
                String serviceTypeName = resultSet.getString("service_type_name");
                serviceList.add(new Service(serviceId, serviceCode, serviceName, serviceArea, serviceCost, serviceMaxPeople,
                        standardRoom, descriptionOtherConvenience, poolArea, numberOfFloors, rentTypeId,rentTypeName,
                        rentTypeCost,serviceTypeId,serviceTypeName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceList;
    }

    @Override
    public List<RentType> getAllRentType() {
        List<RentType> rentTypeList = new ArrayList<>();
        //Chu y: phai khoi tao new ArrayList<>() cho List<>, neu khong se sinh ra NullPointException;
        Connection connection;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT rent_type_id, rent_type_name, " +
                    "rent_type_cost FROM rent_type;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int rentTypeId = resultSet.getInt("rent_type_id");
                String rentTypeName = resultSet.getString("rent_type_name");
                double rentTypeCost = resultSet.getDouble("rent_type_cost");
                rentTypeList.add(new RentType(rentTypeId, rentTypeName, rentTypeCost));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentTypeList;
    }

    @Override
    public List<ServiceType> getAllServiceType() {
        List<ServiceType> serviceTypeList = new ArrayList<>();
        //Chu y: phai khoi tao new ArrayList<>() cho List<>, neu khong se sinh ra NullPointException;
        Connection connection;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT service_type_id, " +
                    "service_type_name FROM service_type;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int serviceTypeId = resultSet.getInt("service_type_id");
                String serviceTypeName = resultSet.getString("service_type_name");
                serviceTypeList.add(new ServiceType(serviceTypeId, serviceTypeName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceTypeList;
    }

    @Override
    public void createService(Service serviceCreate) {
        Connection connection = null;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO service(service_code, " +
                    "service_name, service_area, service_cost, service_max_people, standard_room, " +
                    "description_other_convenience, pool_area, number_of_floors, rent_type_id, service_type_id)\n" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            preparedStatement.setString(1, serviceCreate.getServiceCode());
            preparedStatement.setString(2, serviceCreate.getServiceName());
            preparedStatement.setInt(3, serviceCreate.getServiceArea());
            preparedStatement.setDouble(4, serviceCreate.getServiceCost());
            preparedStatement.setDouble(5, serviceCreate.getServiceMaxPeople());
            preparedStatement.setString(6,serviceCreate.getStandardRoom());
            preparedStatement.setString(7, serviceCreate.getDescriptionOtherConvenience());
            preparedStatement.setDouble(8, serviceCreate.getPoolArea());
            preparedStatement.setInt(9, serviceCreate.getNumberOfFloors());
            preparedStatement.setInt(10, serviceCreate.getRentTypeId());
            preparedStatement.setInt(11, serviceCreate.getServiceTypeId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Service getService(int serviceId) {
        Service service = null;
        //Chu y: phai khoi tao new ArrayList<>() cho List<>, neu khong se sinh ra NullPointException;
        Connection connection;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT service_id, service_code, " +
                    "service_name, service_area, service_cost, service_max_people, standard_room, " +
                    "description_other_convenience, pool_area, number_of_floors, rent_type.rent_type_id, " +
                    "rent_type.rent_type_name, rent_type.rent_type_cost, service_type.service_type_id, " +
                    "service_type.service_type_name " +
                    "FROM service\n" +
                    "INNER JOIN rent_type ON service.rent_type_id = rent_type.rent_type_id\n" +
                    "INNER JOIN service_type ON service.service_type_id = service_type.service_type_id\n" +
                    "ORDER BY service_id;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int serviceIdGetOne = resultSet.getInt("service_id");
                String serviceCode = resultSet.getString("service_code");
                String serviceName = resultSet.getString("service_name");
                int serviceArea = resultSet.getInt("service_area");
                double serviceCost = resultSet.getDouble("service_cost");
                int serviceMaxPeople = resultSet.getInt("service_max_people");
                String standardRoom = resultSet.getString("standard_room");
                String descriptionOtherConvenience = resultSet.getString("description_other_convenience");
                double poolArea = resultSet.getDouble("pool_area");
                int numberOfFloors = resultSet.getInt("number_of_floors");
                int rentTypeId = resultSet.getInt("rent_type_id");
                String rentTypeName = resultSet.getString("rent_type_name");
                double rentTypeCost = resultSet.getDouble("rent_type_cost");
                int serviceTypeId = resultSet.getInt("service_type_id");
                String serviceTypeName = resultSet.getString("service_type_name");
                service = new Service(serviceIdGetOne, serviceCode, serviceName, serviceArea, serviceCost, serviceMaxPeople,
                        standardRoom, descriptionOtherConvenience, poolArea, numberOfFloors, rentTypeId,rentTypeName,
                        rentTypeCost,serviceTypeId,serviceTypeName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return service;
    }

}

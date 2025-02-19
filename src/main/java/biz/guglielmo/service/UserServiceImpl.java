package biz.guglielmo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.typesafe.config.Config;

import biz.guglielmo.db.model.UserDto;
import biz.guglielmo.service.model.user.UserResponse;
import io.jooby.Environment;
import io.jooby.EnvironmentOptions;

public class UserServiceImpl implements UserService {

    @Override
    public UserResponse getUserByEmailAndPwd(String userEmail, String userPassword) {
        Environment env = Environment.loadEnvironment(new EnvironmentOptions());
        Config conf = env.getConfig();
        final String dbUrl = conf.getString("db.url");
        final String dbUser = conf.getString("db.user");
        final String dbPassword = conf.getString("db.password");

        List<UserDto> userList = new ArrayList<>();

        String query = String.format("select * from USER where EMAIL = '%s' and PWD = '%s'", userEmail,
                userPassword);

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
                PreparedStatement statement = connection.prepareStatement(query);
                ResultSet rs = statement.executeQuery();) {

            while (rs.next()) {
                UserDto dto = new UserDto();

                long userId = rs.getLong("id");
                int tenantId = rs.getInt("tenant_id");
                String email = rs.getString("email");
                Integer roleId = rs.getInt("role_id");

                dto.setId(userId);
                dto.setTenantId(tenantId);
                dto.setEmail(email);
                dto.setRoleId(roleId);

                userList.add(dto);
            }
        } catch (SQLException exception) {
            // TODO: loggare eccezione
            // TODO: rilanciare eccezione custom
            System.out.println("Eccezione SQL in UserService.getUserByEmailAndPwd(...)");
            throw new RuntimeException(exception);
        }

        if (userList.isEmpty()) {
            // TODO: loggare errore
            // TODO: lanciare un HTTP 400
            System.out.println("Utente non trovato!");
            return null;
        }

        if (userList.size() > 1) { // Se più di un utente con la stessa mail qualcosa è andato storto => errore
                                   // lato server
            // TODO: loggare errore
            // TODO: lanciare un HTTP 500
            System.out.println("Più di un utente con la stessa email");
            return null;
        }

        UserDto dto = userList.get(0);
        UserResponse response = fromDto(dto);

        return response;
    }

    private UserResponse fromDto(UserDto dto) {
        final long id = dto.getId();
        final int tenantId = dto.getTenantId();
        final String email = dto.getEmail();
        final Integer roleId = dto.getRoleId();
        return new UserResponse(id, tenantId, email, roleId);
    }

}

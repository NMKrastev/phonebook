package phonebook.database;

import phonebook.entity.Contact;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DBEntry {

    public static boolean addContact(Contact contact) {
        boolean isAdded = false;
        try {
            Connection connection = DBConnection.createConnection();
            String query = "INSERT INTO contacts(firstName,lastName,company,phoneNumber,email,age) VALUE(?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, contact.getFirstName());
            preparedStatement.setString(2, contact.getLastName());
            preparedStatement.setString(3, contact.getCompany());
            preparedStatement.setString(4, contact.getNumber());
            preparedStatement.setString(5, contact.getEmail());
            preparedStatement.setInt(6, Integer.parseInt(contact.getAge()));
            preparedStatement.executeUpdate();
            isAdded = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isAdded;
    }
}
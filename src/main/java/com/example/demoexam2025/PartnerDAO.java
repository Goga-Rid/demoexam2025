package com.example.demoexam2025;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PartnerDAO {
    private DBConnection dbConnection = new DBConnection();

    //  Создание партнера
    public void create (Partner newPartner) throws SQLException {

        String sql = "INSERT INTO partners (partner_id, partner_type, partner_name, director, email, phone, legal_address, inn, rating) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = dbConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newPartner.getPartner_type());
            stmt.setString(2, newPartner.getPartner_name());
            stmt.setString(3, newPartner.getDirector());
            stmt.setString(4, newPartner.getEmail());
            stmt.setString(5, newPartner.getPhone());
            stmt.setString(6, newPartner.getLegal_address());
            stmt.setString(7, newPartner.getInn());
            stmt.setInt(8, newPartner.getRating());
            stmt.executeUpdate();
            System.out.println("Новый партнер успешно добавлен!");
        }catch (SQLException e) {
            throw new SQLException(" !!! При создании партнера произошла ошибка: " + e.getMessage() + " !!! ");
        }
    }

    //    Изменение полей партнера
    public void update (int partnerId, String partner_type, String partner_name, String director, String email, String phone, String legal_address, String inn) throws SQLException {

        String sql = "UPDATE partners SET partner_type = ?, partner_name = ?, director = ?, email = ?, phone = ?, legal_address = ?, inn = ? WHERE partner_id = ?";

        try (Connection conn = dbConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, partner_type);
            stmt.setString(2, partner_name);
            stmt.setString(3, director);
            stmt.setString(4, email);
            stmt.setString(5, phone);
            stmt.setString(6, legal_address);
            stmt.setString(7, inn);
            stmt.executeUpdate();
            System.out.println("Изменения полей партнера было успешным!");
        }catch (SQLException e) {
            throw new SQLException(" !!! При изменении полей партнера произошла ошибка: " + e.getMessage() + " !!! ");
        }
    }

    //    Получение списка всех партнеров
    public List<Partner> getAllPartners () throws SQLException {
        List<Partner> partners = new ArrayList<>();
        String sql = "SELECT * FROM partners";
        try (Connection conn = dbConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Partner partner = new Partner(
                        rs.getInt("partnerId"),
                        rs.getString("partner_type"),
                        rs.getString("partner_name"),
                        rs.getString("director"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("legal_address"),
                        rs.getString("inn"),
                        rs.getInt("rating")
                );
                partners.add(partner);
            }
        } catch (SQLException e) {
            throw new SQLException(" !!! При получении списка партнеров произошла ошибка: " + e.getMessage() + " !!! ");
        }

        return partners;
    }

    //     Поиск партнера по id
    public Partner getPartner (int partnerId) throws SQLException {
        String sql = "SELECT * FROM partners WHERE partner_id = ?";
        Partner partner = null;
        Connection conn = dbConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, partnerId);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            partner = new Partner();
            partner.setPartnerId(partnerId);
        }
        return partner;
    }

    //     Метод, считающий общую сумму продаж партнера, чтобы потом можно было рассчитать скидку для партнера
    public List<Integer> getSalesByPartner(List<String> partnerNames) throws SQLException {

        List<Integer> salesByPartner = new ArrayList<>();

        String sql = "SELECT partner_products.partner_name, SUM(partner_products.quantity) AS total_sales FROM partner_products WHERE partner_products.partner_name IN (?) GROUP BY partner_products.partner_name";

        try (Connection conn = dbConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            stmt.setObject(1, partnerNames.toArray());
            while (rs.next()) {
                String partnerName = rs.getString("partner_name");
                int totalSales = rs.getInt("total_sales");
                salesByPartner.add(totalSales);
            }
        } catch (SQLException e) {
            throw new SQLException("Ошибка при получении данных о продажах партнеров: " + e.getMessage());
        }

        return salesByPartner;
    }

}

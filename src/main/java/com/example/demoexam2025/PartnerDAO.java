package com.example.demoexam2025;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PartnerDAO {
    private DBConnection dbConnection = new DBConnection();

    //  Создание партнера
    public void create (Partner newPartner) throws SQLException {
        String sql = "INSERT INTO partners (partnerId, partner_type, partner_name, director, email, phone, legal_address, inn, rating) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?";
    }

    //    Изменение полей партнера
    public void update (int partnerId, String partner_type, String partner_name, String director, String email, String phone, String legal_address, String inn) throws SQLException {
        String sql = "UPDATE partners SET partner_type = ?, partner_name = ?, director = ?, email = ?, phone = ?, legal_address = ?, inn = ? WHERE partnerId = ?";
    }

    //    Получение списка всех партнеров
    public List<Partner> getAllPartners () throws SQLException {
        List<Partner> partners = new ArrayList<>();
        String sql = "SELECT * FROM partners";

        return partners;
    }

    //     Поиск партнера по id
    public Partner getPartner (int partnerId) throws SQLException {
        String sql = "SELECT * FROM partners WHERE partnerId = ?";
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
    public List<Integer> getSalesByPartner (List<String> partner_names) throws SQLException {
        String sql = "SELECT SUM() ";
    }

}

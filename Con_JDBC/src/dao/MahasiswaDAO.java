/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connect.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Mahasiswa;


public class MahasiswaDAO {
    private Connection con = null;
    
    public MahasiswaDAO(){
        this.con = new DBConnection().getConnection();
    }
    
    public String AddMahasiswa(Mahasiswa mhs){
        String status = "gagal";
        try {
            String sql = "INSERT INTO tbmhs VALUES ('" + mhs.getNim() + "', '" + mhs.getNama() + "', '" + mhs.getFakultas() + "');";
            Statement st = (Statement) con.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "data Berhasil Ditambahkan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    
    
    public List<Mahasiswa> getAll(){
        List<Mahasiswa> LMhs = new ArrayList<Mahasiswa>();
        try{
            PreparedStatement stm = con.prepareStatement("SELECT * FROM tbmhs");
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Mahasiswa mhs = new Mahasiswa();
                mhs.setNim(rs.getString("nim"));
                mhs.setNama(rs.getString("nama"));
                mhs.setFakultas(rs.getString("fakultas"));
                LMhs.add(mhs);
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Data gagal ditampilkan", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        return LMhs;
    }
    
    
     public String deleteMahasiswa(String nim){
        String status = "Gagal";
        try {
            PreparedStatement ps = con.prepareStatement("" + "DELETE FROM tbmhs WHERE NIM=?");
            ps.setString(1, nim);
            ps.executeUpdate();
            status = "Data Berhasil Dihapus";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public String updateMahasiswa(String nim, Mahasiswa m){
        String status = "Gagal";
        try {
            PreparedStatement ps = con.prepareStatement("" + "UPDATE tbmhs set nama=?," + "fakultas=? WHERE nim=?");
            ps.setString(1, m.getNama());
            ps.setString(2, m.getFakultas());
            ps.setString(3, m.getNim());
            ps.executeUpdate();
            status = "Data Berhasil Diupdate";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
    
}
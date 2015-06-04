import connect.DBConnection;
import dao.MahasiswaDAO;
import java.util.ArrayList;
import java.util.List;
import model.Mahasiswa;


public class tester {
    public static void main(String[] args){
        //test koneksii
        System.out.println(new DBConnection().getConnection());
        //test tambah
        MahasiswaDAO md = new MahasiswaDAO();
        Mahasiswa m = new Mahasiswa();
        List<Mahasiswa> LMhs = new ArrayList<Mahasiswa>();
        m.setNim("672012060");
        m.setNama("Rheza Winahyu");
        m.setFakultas("FTI");
        md.AddMahasiswa(m);
        
        //test getAll
        LMhs = md.getAll();
        for(Mahasiswa mhs : LMhs){
            System.out.print(mhs.getNim());
            System.out.print("\t" + mhs.getNama());
            System.out.print("\t" + mhs.getFakultas());
            System.out.println("");
        }
        
    }
}

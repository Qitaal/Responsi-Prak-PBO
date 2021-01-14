package resposiprakpbo.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class PelamarTableModel extends AbstractTableModel{

    public final String[] HEADER = {"Nama Lengkap", "Jenis Kelamin", "Pendidikan Terakhir", "Posisi", "Pengalaman", "Status"};
    List<Lamaran> listLamaran;

    public PelamarTableModel() {
        this.listLamaran = new ArrayList<>();
    }
    
    public void resetData(List<Lamaran> listLamaran){
        this.listLamaran = listLamaran;
        fireTableDataChanged();
    }
    
    public Lamaran getLamaran(int index){
        return listLamaran.get(index);
    }
    
    @Override
    public int getRowCount() {
        return listLamaran.size();
    }

    @Override
    public int getColumnCount() {
        return HEADER.length;
    }
    
    @Override
    public String getColumnName(int i) {
        return HEADER[i];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Lamaran lamaran = listLamaran.get(rowIndex);
        
        switch(columnIndex){
            case 0: return lamaran.getNamaLengkap();
            case 1: return lamaran.getJenisKelamin();
            case 2: return lamaran.getPendidikan();
            case 3: return lamaran.getPosisi();
            case 4: return lamaran.getPengalaman();
            case 5: return lamaran.getStatus();
            default: return null;
        }
    }
}

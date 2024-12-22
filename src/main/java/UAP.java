import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.*;
import org.apache.poi.xwpf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;

public class UAP {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Kalkulator Hitung Luas");
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel("Selamat datang di Kalkulator hitung luas", JLabel.CENTER);
        panel.add(label, BorderLayout.NORTH);

        String[] columnNames = {"Jenis Bangun", "Parameter", "Luas", "Bangun Ruas"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);

        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(100);

        table.getColumn("Bangun Ruas").setCellRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = new JLabel();
                if (value instanceof JLabel) {
                    label = (JLabel) value;
                } else {
                    label.setText(value == null ? "" : value.toString());
                }
                label.setPreferredSize(new Dimension(100, 100));
                return label;
            }
        });

        JScrollPane tableScrollPane = new JScrollPane(table);
        panel.add(tableScrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 6));

        JButton persegiButton = new JButton("Hitung Luas Persegi");
        JButton persegipanjangButton = new JButton("Hitung Luas Persegi Panjang");
        JButton segitigaButton = new JButton("Hitung Luas Segitiga");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");
        JButton keluarButton = new JButton("Keluar");

        buttonPanel.add(persegiButton);
        buttonPanel.add(persegipanjangButton);
        buttonPanel.add(segitigaButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(keluarButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);
        frame.add(panel);
        frame.setVisible(true);

        persegiButton.addActionListener(e -> {
            String sisiStr = JOptionPane.showInputDialog(frame, "Masukkan panjang sisi persegi:");
            if (sisiStr == null) { return; }
            if (sisiStr.trim().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Panjang sisi tidak boleh kosong!");
                return;
            }
            try {
                double sisi = Double.parseDouble(sisiStr);
                double luasPersegi = sisi * sisi;
                ImageIcon persegiIcon = new ImageIcon("C:\\Users\\Firman Maulana B\\Videos\\UAP\\Persegi.jpg");

                Image img = persegiIcon.getImage();
                int width = 100;
                int height = 100;
                int newWidth = width;
                int newHeight = height;

                double aspectRatio = (double) img.getWidth(null) / img.getHeight(null);
                if (aspectRatio > 1) {
                    newWidth = width;
                    newHeight = (int) (width / aspectRatio);
                } else {
                    newHeight = height;
                    newWidth = (int) (height * aspectRatio);
                }

                Image scaledImg = img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
                JLabel persegiLabel = new JLabel(new ImageIcon(scaledImg));

                tableModel.addRow(new Object[]{"Persegi", "Sisi = " + sisi, luasPersegi + " cm²", persegiLabel});
                saveToWord("Persegi", "Sisi = " + sisi, luasPersegi + " cm²");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Input tidak valid! Masukkan angka yang benar.");
            }
        });

        persegipanjangButton.addActionListener(e -> {
            String panjangStr = JOptionPane.showInputDialog(frame, "Masukkan panjang persegi panjang:");
            String lebarStr = JOptionPane.showInputDialog(frame, "Masukkan lebar persegi panjang:");
            if (panjangStr == null || lebarStr == null) { return; }
            if (panjangStr.trim().isEmpty() || lebarStr.trim().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Panjang dan lebar tidak boleh kosong!");
                return;
            }
            try {
                double panjang = Double.parseDouble(panjangStr);
                double lebar = Double.parseDouble(lebarStr);
                double luasPersegiPanjang = panjang * lebar;
                ImageIcon persegipanjangIcon = new ImageIcon("C:\\Users\\Firman Maulana B\\Videos\\UAP\\PersegiPanjang.jpg");

                Image img = persegipanjangIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                JLabel persegipanjangLabel = new JLabel(new ImageIcon(img));

                tableModel.addRow(new Object[]{"Persegi Panjang", "Panjang = " + panjang + ", Lebar = " + lebar, luasPersegiPanjang + " cm²", persegipanjangLabel});
                saveToWord("Persegi Panjang", "Panjang = " + panjang + ", Lebar = " + lebar, luasPersegiPanjang + " cm²");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Input tidak valid! Masukkan angka yang benar.");
            }
        });

        segitigaButton.addActionListener(e -> {
            String alasStr = JOptionPane.showInputDialog(frame, "Masukkan alas segitiga:");
            String tinggiStr = JOptionPane.showInputDialog(frame, "Masukkan tinggi segitiga:");
            if (alasStr == null || tinggiStr == null) { return; }
            if (alasStr.trim().isEmpty() || tinggiStr.trim().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Alas dan tinggi tidak boleh kosong!");
                return;
            }
            try {
                double alas = Double.parseDouble(alasStr);
                double tinggi = Double.parseDouble(tinggiStr);
                double luasSegitiga = 0.5 * alas * tinggi;
                ImageIcon segitigaIcon = new ImageIcon("C:\\Users\\Firman Maulana B\\Videos\\UAP\\Segitiga.jpg");

                Image img = segitigaIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                JLabel segitigaLabel = new JLabel(new ImageIcon(img));

                tableModel.addRow(new Object[]{"Segitiga", "Alas = " + alas + ", Tinggi = " + tinggi, luasSegitiga + " cm²", segitigaLabel});
                saveToWord("Segitiga", "Alas = " + alas + ", Tinggi = " + tinggi, luasSegitiga + " cm²");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Input tidak valid! Masukkan angka yang benar.");
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(frame, "Pilih baris yang ingin diupdate terlebih dahulu.");
                    return;
                }

                String jenisBangun = (String) tableModel.getValueAt(selectedRow, 0);

                switch (jenisBangun) {
                    case "Persegi":
                        String sisiStr = JOptionPane.showInputDialog(frame, "Masukkan panjang sisi persegi:");
                        if (sisiStr == null) { return; }
                        if (sisiStr.trim().isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "Panjang sisi tidak boleh kosong!");
                            return;
                        }
                        try {
                            double sisi = Double.parseDouble(sisiStr);
                            double luasPersegi = sisi * sisi;
                            ImageIcon persegiIcon = new ImageIcon("C:\\Users\\Firman Maulana B\\Videos\\UAP\\Persegi.jpg");

                            Image img = persegiIcon.getImage();
                            int width = 100;
                            int height = 100;
                            int newWidth = width;
                            int newHeight = height;

                            double aspectRatio = (double) img.getWidth(null) / img.getHeight(null);
                            if (aspectRatio > 1) {
                                newWidth = width;
                                newHeight = (int) (width / aspectRatio);
                            } else {
                                newHeight = height;
                                newWidth = (int) (height * aspectRatio);
                            }

                            Image scaledImg = img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
                            JLabel persegiLabel = new JLabel(new ImageIcon(scaledImg));

                            tableModel.setValueAt("Persegi", selectedRow, 0);
                            tableModel.setValueAt("Sisi = " + sisi, selectedRow, 1);
                            tableModel.setValueAt(luasPersegi + " cm²", selectedRow, 2);
                            tableModel.setValueAt(persegiLabel, selectedRow, 3);

                            saveToWord("Persegi", "Sisi = " + sisi, luasPersegi + " cm²");

                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "Input tidak valid! Masukkan angka yang benar.");
                        }
                        break;

                    case "Persegi Panjang":
                        String panjangStr = JOptionPane.showInputDialog(frame, "Masukkan panjang persegi panjang:");
                        String lebarStr = JOptionPane.showInputDialog(frame, "Masukkan lebar persegi panjang:");
                        if (panjangStr == null || lebarStr == null) { return; }
                        if (panjangStr.trim().isEmpty() || lebarStr.trim().isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "Panjang dan lebar tidak boleh kosong!");
                            return;
                        }
                        try {
                            double panjang = Double.parseDouble(panjangStr);
                            double lebar = Double.parseDouble(lebarStr);
                            double luasPersegiPanjang = panjang * lebar;
                            ImageIcon persegipanjangIcon = new ImageIcon("C:\\Users\\Firman Maulana B\\Videos\\UAP\\PersegiPanjang.jpg");

                            Image img = persegipanjangIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                            JLabel persegipanjangLabel = new JLabel(new ImageIcon(img));

                            tableModel.setValueAt("Persegi Panjang", selectedRow, 0);
                            tableModel.setValueAt("Panjang = " + panjang + ", Lebar = " + lebar, selectedRow, 1);
                            tableModel.setValueAt(luasPersegiPanjang + " cm²", selectedRow, 2);
                            tableModel.setValueAt(persegipanjangLabel, selectedRow, 3);

                            saveToWord("Persegi Panjang", "Panjang = " + panjang + ", Lebar = " + lebar, luasPersegiPanjang + " cm²");

                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "Input tidak valid! Masukkan angka yang benar.");
                        }
                        break;

                    case "Segitiga":
                        String alasStr = JOptionPane.showInputDialog(frame, "Masukkan alas segitiga:");
                        String tinggiStr = JOptionPane.showInputDialog(frame, "Masukkan tinggi segitiga:");
                        if (alasStr == null || tinggiStr == null) { return; }
                        if (alasStr.trim().isEmpty() || tinggiStr.trim().isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "Alas dan tinggi tidak boleh kosong!");
                            return;
                        }
                        try {
                            double alas = Double.parseDouble(alasStr);
                            double tinggi = Double.parseDouble(tinggiStr);
                            double luasSegitiga = 0.5 * alas * tinggi;
                            ImageIcon segitigaIcon = new ImageIcon("C:\\Users\\Firman Maulana B\\Videos\\UAP\\Segitiga.jpg");

                            Image img = segitigaIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                            JLabel segitigaLabel = new JLabel(new ImageIcon(img));

                            tableModel.setValueAt("Segitiga", selectedRow, 0);
                            tableModel.setValueAt("Alas = " + alas + ", Tinggi = " + tinggi, selectedRow, 1);
                            tableModel.setValueAt(luasSegitiga + " cm²", selectedRow, 2);
                            tableModel.setValueAt(segitigaLabel, selectedRow, 3);

                            saveToWord("Segitiga", "Alas = " + alas + ", Tinggi = " + tinggi, luasSegitiga + " cm²");

                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "Input tidak valid! Masukkan angka yang benar.");
                        }
                        break;

                    default:
                        JOptionPane.showMessageDialog(frame, "Jenis bangun tidak dikenal.");
                        break;
                }
            }
        });

        deleteButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                tableModel.removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(frame, "Pilih baris yang ingin dihapus.");
            }
        });

        keluarButton.addActionListener(e -> {
            int option = JOptionPane.showConfirmDialog(frame, "Apakah Anda yakin ingin keluar?", "Konfirmasi Keluar", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
    }

    // Fungsi untuk menyimpan input/output ke dalam file Word
    private static void saveToWord(String jenisBangun, String parameter, String luas) {
        XWPFDocument document = new XWPFDocument();

        XWPFParagraph title = document.createParagraph();
        title.setAlignment(ParagraphAlignment.CENTER);
        title.createRun().setText("Kalkulator Hitung Luas");

        XWPFTable table = document.createTable();

        XWPFTableRow headerRow = table.getRow(0);
        headerRow.getCell(0).setText("Jenis Bangun");
        headerRow.addNewTableCell().setText("Parameter");
        headerRow.addNewTableCell().setText("Luas");

        XWPFTableRow row = table.createRow();
        row.getCell(0).setText(jenisBangun);
        row.getCell(1).setText(parameter);
        row.getCell(2).setText(luas);

        try (FileOutputStream out = new FileOutputStream("hasil_perhitungan.docx")) {
            document.write(out);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error saat menyimpan file Word: " + ex.getMessage());
        }
    }
}



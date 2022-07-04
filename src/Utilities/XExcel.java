
package Utilities;


import DAO.ThongKeDAO;
import com.GUI.swing.Table;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XExcel {
    public static XSSFWorkbook workbook;
    public static ThongKeDAO tkdao = new ThongKeDAO();
    
    public static void exportTable(Table table){
        
        List<List> data_List = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        
        for (int i = 0; i < model.getRowCount(); i++) {
            List<String> data_Row = new ArrayList<>();
            for (int j = 0; j < model.getColumnCount(); j++) {
                String row_data = "";
                try {
                    row_data = (String) table.getValueAt(i, j);
                } catch (Exception e) {
                    row_data = String.valueOf(table.getValueAt(i, j));
                }
                data_Row.add(row_data.trim());
            }
            data_List.add(data_Row);
        }
        
        
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Save as");
        FileNameExtensionFilter f = new FileNameExtensionFilter("xls", "xlsx");
        FileOutputStream out = null;
        chooser.setFileFilter(f);
        
        int excel = chooser.showSaveDialog(null);
        
        if (excel == JFileChooser.APPROVE_OPTION) {
            
            try {
                workbook = new XSSFWorkbook();
                XSSFSheet spreadsheet = workbook.createSheet(table.getToolTipText());
                
                XSSFRow rows = null;
                Cell cells = null;
                CellStyle cs = headerCellStyle();
                CellStyle csc = coCellStyle();
                
                rows = spreadsheet.createRow((short) 3);
                rows.setHeight((short) 700);
                
                for (int i = 0; i < model.getColumnCount(); i++) {
                    cells = rows.createCell(i, CellType.STRING);
                    cells.setCellValue(model.getColumnName(i));
                    cells.setCellStyle(cs);
                }
                
                
                for (int i = 0; i < data_List.size(); i++) {
                    List<String> data_Row = data_List.get(i);
                    rows = spreadsheet.createRow((short) 4 + i);
                    rows.setHeight((short) 500);
                    
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        cells = rows.createCell(j);
                        cells.setCellValue(data_Row.get(j));
                        cells.setCellStyle(csc);
                    }
                }

                for (int i = 0; i < data_List.size(); i++) {
                    spreadsheet.autoSizeColumn(i);
                }

                out = new FileOutputStream(chooser.getSelectedFile() + ".xlsx");
                workbook.write(out);
                out.close();
                JOptionPane.showMessageDialog(null, "Export file excel thành công");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Export file excel thất bại");
                throw new RuntimeException(e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn ổ đĩa.");
            JOptionPane.showMessageDialog(null, f);
        }
    }
    
    public static void exportDTTungNam() throws SQLException{
        List<Object[]> List = tkdao.getDTTungNam();
        
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Save as");
        FileNameExtensionFilter f = new FileNameExtensionFilter("xls", "xlsx");
        FileOutputStream out = null;
        chooser.setFileFilter(f);
        
        int excel = chooser.showSaveDialog(null);
        
        if (excel == JFileChooser.APPROVE_OPTION) {
            
            try {
                workbook = new XSSFWorkbook();
                XSSFSheet spreadsheet = workbook.createSheet("Doanh thu theo từng năm");
                
                XSSFRow rows = null;
                Cell cells = null;
                CellStyle cs = headerCellStyle();
                CellStyle csc = coCellStyle();
                
                rows = spreadsheet.createRow((short) 3);
                rows.setHeight((short) 700);
                
                cells = rows.createCell(0, CellType.STRING);
                cells.setCellValue("Năm");
                cells.setCellStyle(cs);
                
                cells = rows.createCell(1, CellType.STRING);
                cells.setCellValue("Vé");
                cells.setCellStyle(cs);
                
                cells = rows.createCell(2, CellType.STRING);
                cells.setCellValue("Dịch vụ");
                cells.setCellStyle(cs);
                
                cells = rows.createCell(3, CellType.STRING);
                cells.setCellValue("Tổng");
                cells.setCellStyle(cs);
                
                
                for (int i = 0; i < List.size(); i++) {
                    Object[] obj = List.get(i);
                    rows = spreadsheet.createRow((short) 4 + i);
                    rows.setHeight((short) 500);
                    
                    cells = rows.createCell(0);
                    cells.setCellValue(obj[0].toString());
                    cells.setCellStyle(csc);
                    
                    cells = rows.createCell(1);
                    cells.setCellValue(obj[1].toString());
                    cells.setCellStyle(csc);
                    
                    cells = rows.createCell(2);
                    cells.setCellValue(obj[2].toString());
                    cells.setCellStyle(csc);
                    
                    cells = rows.createCell(3);
                    cells.setCellValue(obj[3].toString());
                    cells.setCellStyle(csc);
                }

                for (int i = 0; i < List.size(); i++) {
                    spreadsheet.autoSizeColumn(i);
                }

                out = new FileOutputStream(chooser.getSelectedFile() + ".xlsx");
                workbook.write(out);
                out.close();
                JOptionPane.showMessageDialog(null, "Export file excel thành công");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Export file excel thất bại");
                throw new RuntimeException(e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn ổ đĩa.");
        }
    }
    
    public static void exportDTTungThang(int Nam) throws SQLException{
        List<Object[]> List = tkdao.getDTTungThang(Nam);
        
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Save as");
        FileNameExtensionFilter f = new FileNameExtensionFilter("xls", "xlsx");
        FileOutputStream out = null;
        chooser.setFileFilter(f);
        
        int excel = chooser.showSaveDialog(null);
        
        if (excel == JFileChooser.APPROVE_OPTION) {
            
            try {
                workbook = new XSSFWorkbook();
                XSSFSheet spreadsheet = workbook.createSheet("Doanh thu năm "+Nam);
                
                XSSFRow rows = null;
                Cell cells = null;
                CellStyle cs = headerCellStyle();
                CellStyle csc = coCellStyle();
                
                rows = spreadsheet.createRow((short) 3);
                rows.setHeight((short) 700);
                
                cells = rows.createCell(0, CellType.STRING);
                cells.setCellValue("Tháng");
                cells.setCellStyle(cs);
                
                cells = rows.createCell(1, CellType.STRING);
                cells.setCellValue("Vé");
                cells.setCellStyle(cs);
                
                cells = rows.createCell(2, CellType.STRING);
                cells.setCellValue("Dịch vụ");
                cells.setCellStyle(cs);
                
                cells = rows.createCell(3, CellType.STRING);
                cells.setCellValue("Tổng");
                cells.setCellStyle(cs);
                
                
                for (int i = 0; i < List.size(); i++) {
                    Object[] obj = List.get(i);
                    rows = spreadsheet.createRow((short) 4 + i);
                    rows.setHeight((short) 500);
                    
                    cells = rows.createCell(0);
                    cells.setCellValue(obj[0].toString());
                    cells.setCellStyle(csc);
                    
                    cells = rows.createCell(1);
                    cells.setCellValue(obj[1].toString());
                    cells.setCellStyle(csc);
                    
                    cells = rows.createCell(2);
                    cells.setCellValue(obj[2].toString());
                    cells.setCellStyle(csc);
                    
                    cells = rows.createCell(3);
                    cells.setCellValue(obj[3].toString());
                    cells.setCellStyle(csc);
                }

                for (int i = 0; i < List.size(); i++) {
                    spreadsheet.autoSizeColumn(i);
                }

                out = new FileOutputStream(chooser.getSelectedFile() + ".xlsx");
                workbook.write(out);
                out.close();
                JOptionPane.showMessageDialog(null, "Export file excel thành công");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Export file excel thất bại");
                throw new RuntimeException(e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn ổ đĩa.");
        }
    }
    
    public static void exportDTThang(int Nam, int Thang) throws SQLException{
        List<Object[]> List = tkdao.getDTThang(Nam, Thang);
        
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Save as");
        FileNameExtensionFilter f = new FileNameExtensionFilter("xls", "xlsx");
        FileOutputStream out = null;
        chooser.setFileFilter(f);
        
        int excel = chooser.showSaveDialog(null);
        
        if (excel == JFileChooser.APPROVE_OPTION) {
            
            try {
                workbook = new XSSFWorkbook();
                XSSFSheet spreadsheet = workbook.createSheet("Doanh thu" +Thang + " năm "+Nam);
                
                XSSFRow rows = null;
                Cell cells = null;
                CellStyle cs = headerCellStyle();
                CellStyle csc = coCellStyle();
                
                rows = spreadsheet.createRow((short) 3);
                rows.setHeight((short) 700);
                
                cells = rows.createCell(0, CellType.STRING);
                cells.setCellValue("Ngày");
                cells.setCellStyle(cs);
                
                cells = rows.createCell(1, CellType.STRING);
                cells.setCellValue("Vé");
                cells.setCellStyle(cs);
                
                cells = rows.createCell(2, CellType.STRING);
                cells.setCellValue("Dịch vụ");
                cells.setCellStyle(cs);
                
                cells = rows.createCell(3, CellType.STRING);
                cells.setCellValue("Tổng");
                cells.setCellStyle(cs);
                
                
                for (int i = 0; i < List.size(); i++) {
                    Object[] obj = List.get(i);
                    rows = spreadsheet.createRow((short) 4 + i);
                    rows.setHeight((short) 500);
                    
                    cells = rows.createCell(0);
                    cells.setCellValue(obj[0].toString());
                    cells.setCellStyle(csc);
                    
                    cells = rows.createCell(1);
                    cells.setCellValue(obj[1].toString());
                    cells.setCellStyle(csc);
                    
                    cells = rows.createCell(2);
                    cells.setCellValue(obj[2].toString());
                    cells.setCellStyle(csc);
                    
                    cells = rows.createCell(3);
                    cells.setCellValue(obj[3].toString());
                    cells.setCellStyle(csc);
                }

                for (int i = 0; i < List.size(); i++) {
                    spreadsheet.autoSizeColumn(i);
                }

                out = new FileOutputStream(chooser.getSelectedFile() + ".xlsx");
                workbook.write(out);
                out.close();
                JOptionPane.showMessageDialog(null, "Export file excel thành công");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Export file excel thất bại");
                throw new RuntimeException(e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn ổ đĩa.");
        }
    }
    
    public static CellStyle headerCellStyle() {
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle.setBorderBottom(BorderStyle.THICK);
        cellStyle.setBorderLeft(BorderStyle.THICK);
        cellStyle.setBorderRight(BorderStyle.THICK);
        cellStyle.setBorderTop(BorderStyle.THICK);

        Font font = workbook.createFont();
        font.setBold(true);
        font.setFontName("Times New Roman");
        font.setFontHeight((short) 350);
        cellStyle.setFont(font);
        return cellStyle;
    }

    public static CellStyle coCellStyle() {
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THICK);
        cellStyle.setBorderRight(BorderStyle.THICK);
        cellStyle.setBorderTop(BorderStyle.THIN);

        Font font = workbook.createFont();
        font.setFontName("Times New Roman");
        font.setFontHeight((short) 250);
        cellStyle.setFont(font);
        return cellStyle;
    }
}

package Utilities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class ValidateCheck implements Serializable {
//Check Null & Max Length String

    static SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");

    public boolean CheckString(String NameString, String string, int length, boolean constraint) {
        if (constraint) {
            if (string.equals("")) {
                JOptionPane.showMessageDialog(null, NameString + " Đang Để Trống!", "Lỗi", 0);
                return false;
            }
            if (string.length() != length) {
                JOptionPane.showMessageDialog(null, NameString + " Phải Dài " + length + " Kí Tự!", "Lỗi", 0);
                return false;
            } else {
                return true;
            }
        } else if (constraint == false) {
            if (string.equals("")) {
                JOptionPane.showMessageDialog(null, NameString + " Đang Để Trống!", "Lỗi", 0);
                return false;
            }
            if (string.length() > length && length != -1) {
                JOptionPane.showMessageDialog(null, NameString + " Quá Dài!", "Lỗi", 0);
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
//Check Duplicase Key

    public boolean CheckDulicase(String NameStringAfter, String string, String NameStringBefore, String string1) {
        if (string.equals(string1)) {
            JOptionPane.showMessageDialog(null, NameStringAfter + " Trùng Mã Với " + NameStringBefore + "!", "Lỗi", 0);
            return false;
        }
        return true;
    }
    //Check Duplicase Key2

    public boolean CheckDulicase2(String NameStringAfter, String string, String NameStringBefore, String string1) {
        if (string.equals(string1)) {
            return true;
        }
        JOptionPane.showMessageDialog(null, NameStringAfter + "Không Trùng Với " + NameStringBefore + "!", "Lỗi", 0);
        return false;
    }
//Check String to Float 

    public boolean CheckFloat(String NameString, String string) {
        try {
            Float x = Float.parseFloat(string);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, NameString + " Nhập Vào Sai Kiểu Dữ Liệu!", "Lỗi", 0);
            return false;
        }
    }
    //Check String to Float 

    public boolean CheckInt(String NameString, String string) {
        try {
            int x = Integer.valueOf(string);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, NameString + " Nhập Vào Sai Kiểu Dữ Liệu!", "Lỗi", 0);
            return false;
        }
    }
//Check String to Date

    public boolean CheckDate(String NameString, String string) {
        try {
            Date CheckDate = formater.parse(string);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, NameString + " Nhập Vào Sai Kiểu Dữ Liệu!", "Lỗi", 0);
            return false;
        }
    }
//Check Null Date

    public boolean CheckNullDate(String NameString, Date date) {
        if (date == null) {
            JOptionPane.showMessageDialog(null, NameString + " Để Trống!", "Lỗi", 0);
            return false;
        }
        return true;
    }
//Check Date After And Before

    public boolean CheckAfterAndBefore(String NameStringAfter, Date after, String NameStringBefore, Date before) {
        if (after.getTime() < before.getTime()) {
            return true;
        }
        JOptionPane.showMessageDialog(null, NameStringAfter + " Sau Ngày " + NameStringBefore + "!", "Lỗi", 0);
        return false;
    }

//regex string
    public boolean RegexString(String NameString, String string) {
        if (string.matches("^[a-z A-Z]{1,50}$")) {
            return true;
        }
        JOptionPane.showMessageDialog(null, NameString + " Nhập Vào Sai Kiểu Dữ Liệu!", "Lỗi", 0);
        return false;
    }
//regex numbers

    public boolean RegexPhoneNumber(String NameString, String number) {
        if (number.matches("^(0|\\+84)(\\s|\\.)?((1[1-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$")) {
            return true;
        }
        JOptionPane.showMessageDialog(null, NameString + " Nhập Vào Sai Kiểu Dữ Liệu!", "Lỗi", 0);
        return false;
    }
//regex string and number

    public boolean RegexStringAndNumber(String NameString, String string) {
        if (string.matches("[a-zA-Z_0-9]")) {
            return true;
        }
        JOptionPane.showMessageDialog(null, NameString + " Nhập Vào Sai Kiểu Dữ Liệu!", "Lỗi", 0);
        return false;
    }
//regex Email

    public boolean RegexEmail(String NameString, String email) {
        if (email.matches("^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$")) {
            return true;
        }
        JOptionPane.showMessageDialog(null, NameString + " Nhập Vào Sai Kiểu Dữ Liệu!", "Lỗi", 0);
        return false;
    }

}

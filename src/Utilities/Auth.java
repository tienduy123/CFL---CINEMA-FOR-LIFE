
package Utilities;

import Entity.NhanVien;

public class Auth {
    
    public static NhanVien user = null;
    
    public static boolean isLogin(){
        return Auth.user != null;
    }
    
    public static boolean isManager(){
        return Auth.isLogin() && user.isChucVu();
    }
    
    public static void clear(){
        Auth.user = null;
    }
    
}

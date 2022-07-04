package Utilities;

import com.GUI.swing.ImageAvatar;
import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class XImage {

    private String pathDefaultFile = System.getProperty("user.dir");

    public void ReadAndScaleIMG(JLabel lbl, String file, int width, int height) {
        ImageIcon icon = new ImageIcon(pathDefaultFile + file);
        Image img = icon.getImage();
        lbl.setIcon(new ImageIcon(img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH)));
    }

    public File getImageFile(String hinhtam) {
        JFileChooser Jfile = new JFileChooser(pathDefaultFile);
        Jfile.setDialogTitle("Chọn Hình");
        int returnVal = Jfile.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            java.io.File file = Jfile.getSelectedFile();
            return file;
        } else {
            if (hinhtam == null) {
                JOptionPane.showMessageDialog(null, "Chưa Chọn Hình!");
                return null;
            }
            return null;
        }
    }

    public static void saveImagePhim(File src) {
        File dst = new File("imagePhim/", src.getName());
        if (!dst.getParentFile().exists()) {
            dst.getParentFile().mkdirs();
        }
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(dst.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void saveImageNhanVien(File src) {
        File dst = new File("imageNhanVien/", src.getName());
        if (!dst.getParentFile().exists()) {
            dst.getParentFile().mkdirs();
        }
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(dst.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void saveImageSuKien(File src) {
        File dst = new File("imageSuKien/", src.getName());
        if (!dst.getParentFile().exists()) {
            dst.getParentFile().mkdirs();
        }
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(dst.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static ImageIcon readImagePhim(String fileName) {
        File path = new File("imagePhim/", fileName);
        return new ImageIcon(path.getAbsolutePath());
    }

    public static ImageIcon readImageNhanVien(String fileName) {
        File path = new File("imageNhanVien/", fileName);
        return new ImageIcon(path.getAbsolutePath());
    }

    public static ImageIcon readImageSuKien(String fileName) {
        File path = new File("imageSuKien/", fileName);
        return new ImageIcon(path.getAbsolutePath());
    }

    public void ReadAndScaleIMG(ImageAvatar lbl, String file, int width, int height) {
        ImageIcon icon = new ImageIcon(pathDefaultFile + file);
        Image img = icon.getImage();
        lbl.setIcon(new ImageIcon(img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH)));
    }
}

package com.GUI.form.ThongKe;

import DAO.HoaDonDAO;
import DAO.ThongKeDAO;
import com.GUI.Chart.BarChart.BarChart;
import com.GUI.Chart.BarChart.ModelChart;
import com.GUI.Chart.ChartLine.ChartLine;
import com.GUI.Chart.ChartLine.ModelChartLine;
import com.GUI.Chart.ChartPie.ModelChartPie;
import com.GUI.Chart.CurveChart.ModelCurveChart;
import com.GUI.form.CustomerAnalysis.Customer;
import com.GUI.form.CustomerAnalysis.CustomerDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.String;
import javax.swing.DefaultComboBoxModel;

public class TKLuotXem_Form extends javax.swing.JPanel {

    ThongKeDAO tkDao = new ThongKeDAO();
    DefaultComboBoxModel cboModelThang = new DefaultComboBoxModel();
    DefaultComboBoxModel cboModelNam = new DefaultComboBoxModel();
    int month;
    int year;
    List<ModelChartLine> modelChartLines = new ArrayList<>();

    public TKLuotXem_Form() {
        initComponents();
        setOpaque(false);
        init();
    }


    public void init() {
        fillCboNam();
        fillCboThang();
        try {
            thongkeluotxem();
        } catch (SQLException ex) {
            Logger.getLogger(TKLuotXem_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        thongKeTheoMP();
        fillCurveChart();
    }

    public void fillCboThang() {
        cboThang.removeAllItems();
        for (int i = 1; i <= 12; i++) {
            cboModelThang.addElement(String.valueOf(i));
        }
        cboThang.setModel(cboModelThang);
        month = Integer.parseInt(cboThang.getSelectedItem().toString());
        System.out.println(month);
    }

    public void fillCboNam() {
        cboNam.removeAllItems();
        for (Integer nam : new HoaDonDAO().selectYear()) {
            cboModelNam.addElement(String.valueOf(nam));
        }
        cboNam.setModel(cboModelNam);
        year = Integer.parseInt(cboNam.getSelectedItem().toString());
        System.out.println(year);
    }

    public void thongkeluotxem() throws SQLException {
        BarChart barchartTKNam = new BarChart();
        barchartTKNam.addLegend("LƯỢT XEM", new Color(135, 189,245));
        String year2 = "";
        String month = "";
        try {
            year2 = cboModelNam.getSelectedItem().toString();
            month = cboModelThang.getSelectedItem().toString();
            System.out.println(month);
            System.out.println(year);
            year = Integer.valueOf(year2);
        } catch (Exception e) {
        }
        List<Object[]> list = tkDao.getTKLX(month, year2);
        for (Object obj[] : list) {
            barchartTKNam.addData(new ModelChart(obj[1].toString(), new double[]{Double.parseDouble(obj[0].toString())}));
        }
        jpanelTKNam.removeAll();
        jpanelTKNam.add(barchartTKNam, BorderLayout.CENTER);
        jpanelTKNam.validate();
    }

    public void thongKeTheoMP() {
        ChartLine chartlineTKNam = new ChartLine();
        try {
            List<ModelChartLine> modelChartLines = new ArrayList<>();
            List<Object[]> list = tkDao.getTKLX_TheoNam(year);
            for (int i = 0; i < list.size(); i++) {
                Object[] obj = list.get(i);
                modelChartLines.add(new ModelChartLine(obj[0].toString(), Double.parseDouble((String) obj[1])));
            }
            chartlineTKNam.setModel(modelChartLines);
        } catch (SQLException ex) {
            Logger.getLogger(TKLuotXem_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        jPanel1.removeAll();
        jPanel1.add(chartlineTKNam, BorderLayout.CENTER);
        jPanel1.validate();
    }
    
    void fillCurveChart(){
        List<Customer> listNam = new CustomerDAO().selectNam();
        List<Customer> listNu = new CustomerDAO().selectNu();
        curveChart1.addLegend("Nam", new Color(12,84,175), new Color(0,108,247));
        curveChart1.addLegend("Nữ", new Color(54,4,143), new Color(104,49,200));
        for (int i = 0; i < listNam.size(); i++) {
            Customer customerNam = listNam.get(i);
            Customer customerNu = listNu.get(i);
            curveChart1.addData(new ModelCurveChart(customerNam.getDate().toString(), new double[]{customerNam.getAge(),customerNu.getAge()}));
        }
        curveChart1.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpanelTKNam = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        chartLine1 = new com.GUI.Chart.ChartLine.ChartLine();
        curveChart1 = new com.GUI.Chart.CurveChart.CurveChart();
        cboNam = new javax.swing.JComboBox<>();
        cboThang = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jpanelTKNam.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        chartLine1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.add(chartLine1, java.awt.BorderLayout.CENTER);

        curveChart1.setBackground(new java.awt.Color(204, 204, 204));

        cboNam.setBackground(new java.awt.Color(224, 224, 224));
        cboNam.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        cboNam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hành động", "Kinh dị", "Trinh thám", "Hoạt hình" }));
        cboNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNamActionPerformed(evt);
            }
        });

        cboThang.setBackground(new java.awt.Color(224, 224, 224));
        cboThang.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        cboThang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hành động", "Kinh dị", "Trinh thám", "Hoạt hình" }));
        cboThang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboThangActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("LƯỢNG VÉ BÁN");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("CHỌN THÁNG");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("CHỌN NĂM");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jpanelTKNam, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addContainerGap(106, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(233, Short.MAX_VALUE)
                    .addComponent(curveChart1, javax.swing.GroupLayout.PREFERRED_SIZE, 846, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(361, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                    .addComponent(jpanelTKNam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(378, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(439, Short.MAX_VALUE)
                    .addComponent(curveChart1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(44, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboThangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboThangActionPerformed
        try {
            thongkeluotxem();
        } catch (SQLException ex) {
            Logger.getLogger(TKLuotXem_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cboThangActionPerformed

    private void cboNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNamActionPerformed
        try {
            thongkeluotxem();
            thongKeTheoMP();
        } catch (SQLException ex) {
            Logger.getLogger(TKLuotXem_Form.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_cboNamActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboNam;
    private javax.swing.JComboBox<String> cboThang;
    private com.GUI.Chart.ChartLine.ChartLine chartLine1;
    private com.GUI.Chart.CurveChart.CurveChart curveChart1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jpanelTKNam;
    // End of variables declaration//GEN-END:variables
}

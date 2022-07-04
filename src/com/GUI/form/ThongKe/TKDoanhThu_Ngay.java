package com.GUI.form.ThongKe;

import DAO.ThongKeDAO;
import com.GUI.Chart.CurveChart.ModelCurveChart;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import javax.swing.JLabel;

public class TKDoanhThu_Ngay extends javax.swing.JPanel {

    ThongKeDAO daotk = new ThongKeDAO();

    public TKDoanhThu_Ngay() {
        initComponents();
        setOpaque(false);
//        jPanel3.setComponentZOrder(this, 1);

        initText();

    }

    public void initText() {
        dongho();
        lblTitle.setFont(new Font("Seoge UI",Font.BOLD,40));
        double doanhThuHomNay = daotk.doanhThuHomNay();
        double doanhThuVsHomQua = doanhThuHomNay - daotk.doanhThuHomQua();
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat vn = NumberFormat.getInstance(localeVN);
        lblTongDTHomNay.setText(vn.format(doanhThuHomNay));
        if(doanhThuVsHomQua>0){
        lblDoanhThuVsHomQua.setText("+"+vn.format(doanhThuVsHomQua));
        }else{
            lblDoanhThuVsHomQua.setText(vn.format(doanhThuVsHomQua));
        }
        lblDoanhThuVe.setText(vn.format(daotk.doanhThuVeHomNay()));
        lblDoanhThuDV.setText(vn.format(daotk.doanhThuDVHomNay()));
        pnlPhim.setLayout(new GridLayout(0, 1, 5, 5));
        pnlPhim.setBackground(Color.white);
        List<String> list = daotk.select5PhimBanChay();
        for (int i = 0 ; i<list.size();i++) {
            JLabel lb = new JLabel(i+1+". " +list.get(i));
            lb.setFont(new Font("Verdana",Font.PLAIN,18));
            pnlPhim.add(lb);
            
        }
        bieuDo();
    }
    public void dongho() {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Calendar cal = new GregorianCalendar();
                        int second = cal.get(Calendar.SECOND);
                        int minute = cal.get(Calendar.MINUTE);
                        int hour = cal.get(Calendar.HOUR_OF_DAY);
                        String day = String.valueOf(cal.get(Calendar.DAY_OF_WEEK));
                        if(Integer.parseInt(day)<10){
                            day=0+String.valueOf(day);
                        }
                        String month=String.valueOf(cal.get(Calendar.MONTH));
                        if(Integer.parseInt(month)<10){
                            month=0+String.valueOf(month);
                        }
                        int year=cal.get(Calendar.YEAR);
                        lblTime.setText(String.valueOf(hour) + ":" + String.valueOf(minute) + ":" + String.valueOf(second)+" "+ 
                                            String.valueOf(year)+"-"+month+"-"+day);
                        Thread.sleep(1000);
                    } catch (Exception e) {

                    }
                }
            }
        });
        a.start();
    }
    public void bieuDo() {
        curveChart1.addLegend("Doanh thu", new Color(245, 189, 135), new Color(245, 189, 135));
        List<Object[]> list = daotk.doanhThuTheoGio();
        for (Object obj[] : list) {
            String gio = obj[0].toString();
            //0:0
            if (Integer.valueOf(gio.substring(0, gio.indexOf(':'))) < 10) {
                gio = "0" + gio;
            } else if (Integer.valueOf(gio.substring(gio.indexOf(':') + 1, gio.length())) < 10) {
                gio = gio.substring(0, gio.indexOf(':') + 1) + "0" + gio.substring(gio.indexOf(':') + 1, gio.length());
            }
            curveChart1.addData(new ModelCurveChart(gio, new double[]{Double.parseDouble(obj[1].toString())}));
        }
        curveChart1.start();
    }

    //new ModelChartLine(obj[0].toString(), Double.parseDouble(obj[1].toString())));
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblTongDTHomNay = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblDoanhThuVsHomQua = new javax.swing.JLabel();
        lblDoanhThuVe = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblDoanhThuDV = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        curveChart1 = new com.GUI.Chart.CurveChart.CurveChart();
        jPanel4 = new javax.swing.JPanel();
        pnlPhim = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 40)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 51, 51));
        lblTitle.setText("Doanh Thu Hôm Nay");
        add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 6, -1, -1));

        lblTime.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTime.setText("21:19:05 2021-12-12");
        lblTime.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 61, 371, 28));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Tổng Doanh Thu");

        lblTongDTHomNay.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lblTongDTHomNay.setText("90.000.000đ");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Chỉ số quan trọng"));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Doanh thu so với hôm qua");

        lblDoanhThuVsHomQua.setFont(new java.awt.Font("Tahoma", 1, 38)); // NOI18N
        lblDoanhThuVsHomQua.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDoanhThuVsHomQua.setText("99");

        lblDoanhThuVe.setFont(new java.awt.Font("Tahoma", 1, 38)); // NOI18N
        lblDoanhThuVe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDoanhThuVe.setText("99");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Tổng doanh thu vé");

        lblDoanhThuDV.setFont(new java.awt.Font("Tahoma", 1, 38)); // NOI18N
        lblDoanhThuDV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDoanhThuDV.setText("99");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Tổng doanh thu dịch vụ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDoanhThuVsHomQua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDoanhThuVe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14))
                        .addGap(0, 19, Short.MAX_VALUE))
                    .addComponent(lblDoanhThuDV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDoanhThuVsHomQua)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDoanhThuVe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDoanhThuDV)
                .addContainerGap(287, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Biểu đồ"));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(curveChart1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 31, 720, 500));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Top 5 phim bán chạy"));

        javax.swing.GroupLayout pnlPhimLayout = new javax.swing.GroupLayout(pnlPhim);
        pnlPhim.setLayout(pnlPhimLayout);
        pnlPhimLayout.setHorizontalGroup(
            pnlPhimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 287, Short.MAX_VALUE)
        );
        pnlPhimLayout.setVerticalGroup(
            pnlPhimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPhim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPhim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 806, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(lblTongDTHomNay)
                .addGap(564, 564, 564))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblTongDTHomNay))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 114, 1440, 680));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.GUI.Chart.CurveChart.CurveChart curveChart1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblDoanhThuDV;
    private javax.swing.JLabel lblDoanhThuVe;
    private javax.swing.JLabel lblDoanhThuVsHomQua;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTongDTHomNay;
    private javax.swing.JPanel pnlPhim;
    // End of variables declaration//GEN-END:variables
}

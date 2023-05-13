/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_gm.Asistencias;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RowsRenderer extends DefaultTableCellRenderer {

    private int columna;

    public RowsRenderer(int Colpatron) {
        this.columna = Colpatron;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
        setBackground(Color.white);
        table.setForeground(Color.black);
        super.getTableCellRendererComponent(table, value, selected, focused, row, column);
        if (table.getValueAt(row, columna).equals("Sábado") || table.getValueAt(row, columna).equals("Domingo")) {
            this.setForeground(Color.RED);
        } else {
            this.setForeground(Color.BLACK);
        }
        return this;
    }
}

package Modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class TextFielArredondada extends JTextField {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int arcWidth;
    private int arcHeight;

    public TextFielArredondada(int columns, int arcWidth, int arcHeight) {
        super(columns);
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
        setOpaque(false); // Torna o fundo do JTextField transparente
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Desenha o fundo com bordas arredondadas
        Shape roundedRect = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), arcWidth, arcHeight);
        g2.setColor(getBackground());
        g2.fill(roundedRect);

        // Desenha o texto
        super.paintComponent(g2);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Desenha a borda arredondada
        Shape roundedRect = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, arcWidth, arcHeight);
        g2.setColor(getForeground());
        g2.draw(roundedRect);
        g2.dispose();
    }

    @Override
    public Insets getInsets() {
        int value = Math.max(arcHeight / 4, arcWidth / 4);
        return new Insets(value, value, value, value);
    }
}
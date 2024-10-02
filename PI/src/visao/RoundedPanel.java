import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedPanel extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cornerRadius;

    public RoundedPanel(int radius) {
        this.cornerRadius = radius;
        setOpaque(false); // Isso torna o painel transparente, permitindo ver as bordas arredondadas
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Suaviza as bordas
        
        // Define a cor de fundo do painel
        g2.setColor(getBackground());
        
        // Desenha o painel com bordas arredondadas
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius));
        
        g2.dispose(); // Libera os recursos
    }
}
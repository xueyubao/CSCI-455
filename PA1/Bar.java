import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

/**
 * Bar class
 * A labeled bar that can serve as a single bar in a bar graph.
 * The text for the label is centered under the bar.
 *
 * NOTE: we have provided the public interface for this class. Do not change
 * the public interface. You can add private instance variables, constants,
 * and private methods to the class. You will also be completing the
 * implementation of the methods given.
 *
 */
public class Bar {
    private int bottom;
    private int left;
    private int width;
    private int barHeight;
    private double scale;
    private Color color;
    private String label;



    /**
     Creates a labeled bar.  You give the height of the bar in application
     units (e.g., population of a particular state), and then a scale for how
     tall to display it on the screen (parameter scale).

     @param bottom  location of the bottom of the label
     @param left  location of the left side of the bar
     @param width  width of the bar (in pixels)
     @param barHeight  height of the bar in application units
     @param scale  how many pixels per application unit
     @param color  the color of the bar
     @param label  the label at the bottom of the bar
     */
    public Bar(int bottom, int left, int width, int barHeight,
               double scale, Color color, String label) {
        this.bottom = bottom;
        this.left = left;
        this.width = width;
        this.barHeight = barHeight;
        this.scale = scale;
        this.color = color;
        this.label = label;


    }

    /**
     Draw the labeled bar.
     @param g2  the graphics context
     this is the method of drawing bar
     */
    public void draw(Graphics2D g2) {
        Font font = g2.getFont();
        FontRenderContext context = g2.getFontRenderContext();
        Rectangle2D labelBounds = font.getStringBounds(label, context);

        //get the height and width of the label
        int widthOfLabel = (int)labelBounds.getWidth();
        int heightOfLabel = (int)labelBounds.getHeight();

        // let the color be black, and firstly draw the string in the label
        g2.setColor(Color.BLACK);
        g2.drawString(label, left + width / 2 - widthOfLabel / 2, bottom );

        // get the height in pixel of the bar
        int pixelsHeightOfBar = (int)(barHeight * scale);

        // bar is a rectangle and we use rectangle class to create bar. And compute its x and y coordinates
        int positionX = left;
        int positionY = bottom - heightOfLabel - pixelsHeightOfBar;
        Rectangle rectangle = new Rectangle(positionX, positionY, width, pixelsHeightOfBar);   //create that rectangle

        //set the color
        g2.setColor(color);
        //fill the rectangle with the color
        g2.fill(rectangle);



    }
}


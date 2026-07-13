import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class MathArtTracker {
    public static void main(String[] args) {
        
        int width = 800;
        int height = 800;

        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        
        int centerX = width / 2;
        int centerY = height / 2;
        double scale = 0.05; 

        System.out.println("Image banna shuru ho gayi hai...");

        
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {

                
                double dx = x - centerX;
                double dy = y - centerY;
                double distance = Math.sqrt(dx * dx + dy * dy);

                
                double equationResult = Math.sin(distance * scale);

                
                int brightness = (int) (((equationResult + 1.0) / 2.0) * 255);

                
                int r = (int) (brightness * 0.2); 
                int g = (int) (brightness * 0.7); 
                int b = brightness; 

                
                int rgbColor = (r << 16) | (g << 8) | b;

                
                img.setRGB(x, y, rgbColor);
            }
        }

        
        try {
            File outputFile = new File("math_ripple_art.png");
            ImageIO.write(img, "png", outputFile);
            System.out.println("Mubarak ho! Image safaltapoorvak 'math_ripple_art.png' ke naam se save ho gayi hai.");
        } catch (Exception e) {
            System.out.println("Oops! Image save karne mein koi dikkat aayi: " + e.getMessage());
        }
    }
}
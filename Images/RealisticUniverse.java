import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class RealisticUniverse {

    // Deterministic pseudo-random hash generator (for pure mathematical noise without random generators)
    private static double hash(int x, int y) {
        int h = x * 374761393 + y * 668265263;
        h = (h ^ (h >> 13)) * 1274126177;
        return (double) (h & 0x7fffffff) / Integer.MAX_VALUE;
    }

    // Linear interpolation
    private static double lerp(double a, double b, double t) {
        return a + t * (b - a);
    }

    // 2D Value Noise with smoothstep (S-Curve) interpolation for organic gradients
    private static double noise2D(double x, double y) {
        int ix = (int) Math.floor(x);
        int iy = (int) Math.floor(y);
        double fx = x - ix;
        double fy = y - iy;

        // Smoothstep interpolation weights
        double ux = fx * fx * (3.0 - 2.0 * fx);
        double uy = fy * fy * (3.0 - 2.0 * fy);

        // Fetching 4 corner grid hashes
        double a = hash(ix, iy);
        double b = hash(ix + 1, iy);
        double c = hash(ix, iy + 1);
        double d = hash(ix + 1, iy + 1);

        // Interpolating horizontally and vertically
        return lerp(lerp(a, b, ux), lerp(c, d, ux), uy);
    }

    // Fractal Brownian Motion: Layering multiple noise octaves to create volumetric cloud texture
    private static double fbm(double x, double y, int octaves) {
        double value = 0.0;
        double amplitude = 0.55;
        double frequency = 1.0;
        double maxValue = 0.0;

        for (int i = 0; i < octaves; i++) {
            value += amplitude * noise2D(x * frequency, y * frequency);
            maxValue += amplitude;
            amplitude *= 0.5;
            frequency *= 2.0;
        }
        return value / maxValue;
    }

    // Domain Warping: Warping coordinates dynamically using noise to simulate organic plasma/fluid flow
    private static double warpedNoise(double x, double y) {
        double qx = fbm(x + 0.0, y + 0.0, 4);
        double qy = fbm(x + 5.2, y + 1.3, 4);

        double rx = fbm(x + 4.0 * qx + 1.7, y + 4.0 * qy + 9.2, 4);
        double ry = fbm(x + 4.0 * qx + 8.3, y + 4.0 * qy + 2.8, 4);

        return fbm(x + 4.0 * rx, y + 4.0 * ry, 5);
    }

    public static void main(String[] args) {
        int width = 1200;
        int height = 1200;
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        double centerX = width / 2.0;
        double centerY = height / 2.0;

        System.out.println("Generating cinematic mathematical universe...");

        for (int py = 0; py < height; py++) {
            for (int px = 0; px < width; px++) {
                
                // Normalizing coordinates [-3.5, 3.5] for wide perspective rendering
                double x = (px - centerX) / (width / 7.0);
                double y = (py - centerY) / (height / 7.0);

                // Distances and angles for spiral galaxy coordinates
                double dist = Math.sqrt(x * x + y * y);
                double angle = Math.atan2(y, x);

                // --- LAYER 1: CINEMATIC DUST CLOUDS (Warped fBm Nebula) ---
                // Generates deep nebula clouds in distinct colorful domains
                double gasTurbulence = warpedNoise(x * 1.5, y * 1.5);
                
                // Color Channels initialisation (Background deep purple space)
                double r = gasTurbulence * 0.15 + 0.02;
                double g = gasTurbulence * 0.05 + 0.01;
                double b = gasTurbulence * 0.35 + 0.05;

                // Bright highlight channels inside dense gas clouds (Golden & Turquoise glows)
                if (gasTurbulence > 0.45) {
                    double highlight = Math.pow((gasTurbulence - 0.45) / 0.55, 2.0);
                    r += highlight * 0.45; // Golden core hints
                    g += highlight * 0.25;
                    b += highlight * 0.10;
                }
                
                // Secondary gas glow (cyan/teal gas lanes)
                double tealGas = Math.sin(x * 0.8) * Math.cos(y * 0.8);
                tealGas = (tealGas + 1.0) / 2.0 * gasTurbulence;
                g += tealGas * 0.15;
                b += tealGas * 0.20;

                // --- LAYER 2: SPIRAL GALAXY WITH DUST LANES ---
                // Coordinates warped before calculation to make galaxy arms look naturally turbulent, not geometric
                double spiralWarp = fbm(x * 2.0, y * 2.0, 3) * 1.8;
                double spiralArms = Math.sin(angle * 2.0 - Math.log(dist + 0.15) * 4.0 + spiralWarp);
                spiralArms = (spiralArms + 1.0) / 2.0;

                // Soft center radial decay & arm dispersion
                double coreGlow = Math.exp(-dist * 2.0);
                double armDecay = spiralArms * Math.exp(-dist * 0.6) * 0.35;
                double galaxyGlow = coreGlow + armDecay;

                // Merging galaxy light into RGB (Soft glowing cream/orange star core)
                r += galaxyGlow * 0.95;
                g += galaxyGlow * 0.85;
                b += galaxyGlow * 0.65;

                // --- LAYER 3: MULTI-TIER STAR FIELD ---
                // Background tiny faint stars (high-density modulo frequency)
                double bgStarNoise = Math.sin(x * 654.0) * Math.sin(y * 732.0);
                if (bgStarNoise > 0.994) {
                    double intensity = (Math.sin(x * 1432.0 + y * 9234.0) + 1.0) / 2.0;
                    r += intensity * 0.4;
                    g += intensity * 0.4;
                    b += intensity * 0.5;
                }

                // Medium stars (soft glowing circular orbs)
                double starFieldNoise = Math.sin(x * 45.0 + y * 85.0) * Math.sin(x * 95.0 - y * 35.0);
                if (starFieldNoise > 0.9995) {
                    double starIntensity = (Math.sin(x * 827.0 + y * 192.0) + 1.0) / 2.0;
                    double softStarRadius = 0.04; // pixel bounds
                    // Simple distance check to local star point
                    double localX = x % 0.13 - 0.065;
                    double localY = y % 0.17 - 0.085;
                    double localDist = Math.sqrt(localX * localX + localY * localY);
                    if (localDist < softStarRadius) {
                        double starGlow = Math.exp(-localDist * 120.0) * starIntensity;
                        r += starGlow;
                        g += starGlow;
                        b += starGlow;
                    }
                }

                // Cinematic Foreground Stars with Cross Diffraction Spikes
                // Placing few very bright glowing stars procedurally
                double fgStarNoise = Math.sin(x * 7.1) * Math.sin(y * 11.3);
                if (fgStarNoise > 0.9997) {
                    double lx = (x % 0.42) - 0.21;
                    double ly = (y % 0.53) - 0.265;
                    double ldist = Math.sqrt(lx * lx + ly * ly);
                    
                    if (ldist < 0.25) {
                        double core = Math.exp(-ldist * 30.0);
                        // Cross diffraction spikes formula: 1 / (|x| * 200 + epsilon)
                        double spikeH = 1.0 / (Math.abs(lx) * 180.0 + 0.01) * Math.exp(-Math.abs(ly) * 15.0);
                        double spikeV = 1.0 / (Math.abs(ly) * 180.0 + 0.01) * Math.exp(-Math.abs(lx) * 15.0);
                        double spikeGlow = (spikeH + spikeV) * 0.12;

                        r += core * 1.0 + spikeGlow;
                        g += core * 0.9 + spikeGlow;
                        b += core * 0.8 + spikeGlow;
                    }
                }

                // --- LAYER 4: POST-PROCESSING (Gamma correction and Vignette) ---
                // Subtle Vignette: Fades the corners slightly to draw focus to center
                double vignette = 1.0 - (dist / 5.5);
                vignette = Math.min(Math.max(vignette, 0.0), 1.0);
                r *= vignette;
                g *= vignette;
                b *= vignette;

                // Clamp colors to standard RGB bounds
                int ir = (int) (Math.min(Math.max(r, 0.0), 1.0) * 255);
                int ig = (int) (Math.min(Math.max(g, 0.0), 1.0) * 255);
                int ib = (int) (Math.min(Math.max(b, 0.0), 1.0) * 255);

                // Writing to final image buffer
                int rgbColor = (ir << 16) | (ig << 8) | ib;
                img.setRGB(px, py, rgbColor);
            }
        }

        try {
            File outputFile = new File("cinematic_universe_math.png");
            ImageIO.write(img, "png", outputFile);
            System.out.println("Realistic math universe image saved successfully as 'cinematic_universe_math.png'!");
        } catch (Exception e) {
            System.out.println("An error occurred while saving the image: " + e.getMessage());
        }
    }
}
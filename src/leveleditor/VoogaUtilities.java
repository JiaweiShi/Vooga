/**
 * @author Michael Zhou (Dominator008)
 */
package leveleditor;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;
import com.golden.gamedev.util.ImageUtil;


public class VoogaUtilities
{
    public static BufferedImage getImageFromString (String src)
    {
        BufferedImage toreturn = null;
        try
        {
            toreturn =
                ImageUtil.getImage(new URL("file://" +
                                           new File(src).getCanonicalPath()),
                                   Color.MAGENTA);
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return toreturn;
    }


    public static BufferedImage toBufferedImage (Image image)
    {
        if (image instanceof BufferedImage)
        {
            return (BufferedImage) image;
        }
        image = new ImageIcon(image).getImage();
        boolean hasAlpha = hasAlpha(image);
        BufferedImage bimage = null;
        GraphicsEnvironment ge =
            GraphicsEnvironment.getLocalGraphicsEnvironment();
        try
        {
            int transparency = Transparency.OPAQUE;
            if (hasAlpha)
            {
                transparency = Transparency.BITMASK;
            }
            GraphicsDevice gs = ge.getDefaultScreenDevice();
            GraphicsConfiguration gc = gs.getDefaultConfiguration();
            bimage =
                gc.createCompatibleImage(image.getWidth(null),
                                         image.getHeight(null),
                                         transparency);
        }
        catch (HeadlessException e)
        {}
        if (bimage == null)
        {
            int type = BufferedImage.TYPE_INT_RGB;
            if (hasAlpha)
            {
                type = BufferedImage.TYPE_INT_ARGB;
            }
            bimage =
                new BufferedImage(image.getWidth(null),
                                  image.getHeight(null),
                                  type);
        }
        Graphics g = bimage.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return bimage;
    }


    public static boolean hasAlpha (Image image)
    {
        if (image instanceof BufferedImage)
        {
            BufferedImage bimage = (BufferedImage) image;
            return bimage.getColorModel().hasAlpha();
        }
        PixelGrabber pg = new PixelGrabber(image, 0, 0, 1, 1, false);
        try
        {
            pg.grabPixels();
        }
        catch (InterruptedException e)
        {}
        ColorModel cm = pg.getColorModel();
        return cm.hasAlpha();
    }

}

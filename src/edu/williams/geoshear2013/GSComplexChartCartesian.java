/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.williams.geoshear2013;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author cwarren
 */
public abstract class GSComplexChartCartesian extends GSComplexChart {

    protected int numMajorContoursX = 4;
    protected int numMinorContoursX = 4; // per major tick
    protected int numMajorContoursY = 1;
    protected int numMinorContoursY = 5; // per major tick

    // min and max for the actual value the chart displays (rather than the pixel/screen positions)
    protected double minValX = 0;
    protected double maxValX = 10;
    protected double minValY = -90;
    protected double maxValY = 90;

    protected double majorCountourStepX;
    protected double minorCountourStepX;
    protected double majorCountourStepY;
    protected double minorCountourStepY;

    protected String infoXVal="";
    protected String infoYVal="";

    @Override
    protected void GSComplexChartMouseClicked(java.awt.event.MouseEvent evt) {
        this.checkShowClick(evt);
        this.handleInfoFor(evt.getX()+2, evt.getY()+2);
        this.repaint();
    }

    protected Point2D.Double getPaintPoint(Point2D.Double valueP)
    {
        double valX = valueP.x;
        if (this.isUseLogScale())
        {
            valX = Math.log(valX);
        }
        double valY = valueP.y;
//        System.err.println("valX: "+valX);
//        System.err.println("valY: "+valY);
//        System.err.println("this.getMaxValY(): "+this.getMaxValY());
//        System.err.println("this.getMinValY(): "+this.getMinValY());
        return new Point2D.Double(this.frameLeft + this.generalInset + this.textAllowance + (((double)(this.frameWidth - this.frameLeft))*((valX-this.getMinValX())/(this.getMaxValX()-this.getMinValX()))),
                                     this.frameTop + this.frameHeight/2 - (((double)(this.frameHeight - this.frameTop)) * (valY/(this.getMaxValY()-this.getMinValY())) ));
    }

    @Override
    protected void paintPebbles(Graphics2D g2d) {
        g2d.setStroke(STROKE_MEDIUM);
        GSPebbleSet curPebs = this.watchedComplex.getCurrentlyDeformedPebbleSet().clone();
        curPebs.applyDeformation(this.watchedComplex.getUsedUI().getTentativeDeformationCopy());
        this.paintPebbleSet(g2d,curPebs);
    }

    protected void handleInfoFor(int x, int y)
    {
        int mx = x;
        int my = y;
        mx = mx - this.frameLeft - this.textAllowance - this.generalInset;
        //mx = mx - this.frameLeft - this.generalInset;
        my = my - this.frameTop - this.generalInset;
        if (mx < 0) { mx = 0; }
        if (my < 0) { my = 0; }
        if (mx > this.frameWidth) { mx = this.frameWidth; }
        if (my > this.frameHeight) { my = this.frameHeight; }
        //System.out.println("mx: "+mx+"     my: "+my);
        //double xCoef = (double)mx/(double)(this.frameWidth-this.textAllowance-this.generalInset);
        double xCoef = (double)mx/(double)(this.frameWidth-this.frameLeft);
        double yCoef = 1 - (double)my/(double)(this.frameHeight);
        double vxmax = this.getMaxValX();
        double vxmin = this.getMinValX();
        double xVal = (xCoef * (vxmax-vxmin)) + vxmin;
        double yVal = (yCoef * (this.getMaxValY()-this.getMinValY())) + this.getMinValY();

        this.infoXVal = Util.truncForDisplay(xVal);
        this.infoYVal = Util.truncForDisplay(yVal);

        this.infoString = this.infoXVal+", "+this.infoYVal;
        this.infoX = mx + this.frameLeft + this.textAllowance + this.generalInset;
        this.infoY = my + this.frameTop;
    }

    public void determineChartFrame()
    {
        this.frameLeft= this.generalInset + this.textAllowance;
        this.frameTop= this.generalInset;

        this.frameWidth = this.getWidth()-this.generalInset-this.generalInset-this.textAllowance-2;
        this.frameHeight = this.getHeight()-this.generalInset-this.generalInset-2;
        this.chartFrame = new BufferedImage(this.frameWidth+2,this.frameHeight+2,BufferedImage.TYPE_INT_RGB);

        Graphics2D g2d = (Graphics2D)(this.chartFrame.getGraphics());
        g2d.setBackground(Color.WHITE);
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, this.frameWidth+2, this.frameHeight+2);

        this.frameHeight -= this.textAllowance;

        this.paintContours(g2d);

        g2d.setColor(Color.BLACK);

        // label x min
        String label = this.logifyContourLabel(Util.truncForDisplay(this.getMinValX(), 2));
        g2d.drawString(label,
                this.frameLeft - 1,
                this.frameHeight+this.textAllowance);

        // lable x max
        label = this.logifyContourLabel(Util.truncForDisplay(this.getMaxValX(), 2));
        g2d.drawString(label,
                this.frameLeft + this.frameWidth - this.textAllowance - this.generalInset - (int)(g2d.getFontMetrics().getStringBounds(label, g2d).getWidth()),
                this.frameHeight+this.textAllowance);

        // label y max
        label = Util.truncForDisplay(this.getMaxValY(), 0);
        this.drawTurnedString(g2d, label, this.frameLeft, this.frameTop-1, TEXT_TURNER);

        // label y min
        label = Util.truncForDisplay(this.getMinValY(), 0);
        this.drawTurnedString(g2d, label, this.frameLeft, this.frameHeight - (int)(g2d.getFontMetrics().getStringBounds(label, g2d).getWidth()), TEXT_TURNER);

        // axes
        g2d.setStroke(STROKE_HEAVY);
        g2d.drawLine(this.frameLeft,this.frameHeight,this.frameWidth,this.frameHeight); // x-axis
        g2d.drawLine(this.frameLeft,2,this.frameLeft,this.frameHeight); // y-axis
    }

    @Override
    protected String getPebbleInfoString(GSPebble p) {
        return "Rf: "+Util.truncForDisplay(p.getRF())+"  phi: "+Util.truncForDisplay(Util.toDegrees(p.getThetaRad()),1);
    }

    @Override
    protected void paintContours(Graphics2D g2d) {

        String contourLabel;

        // minor contours (ticks)
        if (this.isShowContoursMinor())
        {
            g2d.setColor(Util.getLighterColorByStep(Color.LIGHT_GRAY,20));
            g2d.setStroke(STROKE_LIGHT);
            double minorTotX = (this.numMajorContoursX+1) * (this.numMinorContoursX +1);
            double minorSizeX = (double)(this.frameWidth-this.frameLeft) / minorTotX;
            double minorPosX = this.frameLeft;

            double minorTotY = (this.numMajorContoursY+1) * (this.numMinorContoursY +1);
            double minorSizeY = (double)(this.frameHeight-this.frameTop) / minorTotY;
            double minorPosY = this.frameTop;

            this.minorCountourStepX = (this.getMaxValX() - this.getMinValX()) / minorTotX;
            this.minorCountourStepY = (this.getMaxValY() - this.getMinValY()) / minorTotY;
            double minorValX = this.getMinValX();
            double minorValY = this.getMaxValY();

            for (int i=1; i<minorTotX; i++)
            {
                minorPosX += minorSizeX;
                minorValX += this.minorCountourStepX;
                g2d.drawLine((int)minorPosX, 2, (int)minorPosX, this.frameHeight);
                //System.out.println("x val is "+minorValX);
                contourLabel = this.logifyContourLabel(Util.truncForDisplay(minorValX,2));
                double labelOffset = g2d.getFontMetrics().getStringBounds(contourLabel, g2d).getWidth() / 2;
                g2d.drawString(contourLabel, (int)(minorPosX-labelOffset),this.frameHeight+this.textAllowance);
            }
            for (int i=1; i<minorTotY; i++)
            {
                minorPosY += minorSizeY;
                g2d.drawLine(this.frameLeft, (int)minorPosY, this.frameWidth, (int)minorPosY);
                minorValY -= this.minorCountourStepY;
                contourLabel = Util.truncForDisplay(minorValY,0);
                double labelOffset = g2d.getFontMetrics().getStringBounds(contourLabel, g2d).getWidth() / 2;
                this.drawTurnedString(g2d, contourLabel, this.frameLeft, (int)(minorPosY-labelOffset), TEXT_TURNER);
            }
        }

        // major contours (ticks)
        if (this.isShowContoursMajor())
        {
            g2d.setColor(Color.GRAY);
            g2d.setStroke(STROKE_MEDIUM);
            double majorTotX = this.numMajorContoursX+1;
            double majorSizeX = (double)(this.frameWidth-this.frameLeft) / majorTotX;
            double majorPosX = this.frameLeft;

            double majorTotY = this.numMajorContoursY+1;
            double majorSizeY = (double)(this.frameHeight-this.frameTop) / majorTotY;
            double majorPosY = this.frameTop;

            this.majorCountourStepX = (this.getMaxValX() - this.getMinValX()) / majorTotX;
            this.majorCountourStepY = (this.getMaxValY() - this.getMinValY()) / majorTotY;
            double majorValX = this.getMinValX();
            double majorValY = this.getMaxValY();

            for (int i=1; i<majorTotX; i++)
            {
                majorPosX += majorSizeX;
                g2d.drawLine((int)majorPosX, this.frameTop, (int)majorPosX, this.frameHeight);
                majorValX += this.majorCountourStepX;
                contourLabel = this.logifyContourLabel(Util.truncForDisplay(majorValX,2));
                double labelOffset = g2d.getFontMetrics().getStringBounds(contourLabel, g2d).getWidth() / 2;
                g2d.drawString(contourLabel, (int)(majorPosX-labelOffset),this.frameHeight+this.textAllowance);
                
            }
            for (int i=1; i<majorTotY; i++)
            {
                majorPosY += majorSizeY;
                g2d.drawLine(this.frameLeft, (int)majorPosY, this.frameWidth, (int)majorPosY);
                majorValY -= this.majorCountourStepY;
                contourLabel = Util.truncForDisplay(majorValY,0);
                double labelOffset = g2d.getFontMetrics().getStringBounds(contourLabel, g2d).getWidth() / 2;
                this.drawTurnedString(g2d, contourLabel, this.frameLeft, (int)(majorPosY-labelOffset), TEXT_TURNER);
            }
        }
    }

    public double getMaxValX() {
        if (this.isUseAdaptiveScale())
        {
            Util.todo("implement adaptive getMaxValX");
            return 0; // NOTE: placeholder to validate compile - remove when implementing this section
            // todo note: consider (GSComplex)(this.watchedComplex)).getPebbles() --> (GSComplex)(this.watchedComplex)).pebbleSets.get(0)
            // as per paintPebbles
//            double rfMax = this.watchedComplex.getPebbles().getMaxRf();  !! NOTE: generalize this away from using getMaxRf - pass in the potential max instead?
//            if (this.isUseLogScale())
//            {
//                rfMax = Math.log(rfMax);
//            }
//            double maxStep = this.numMajorContoursX + 1;
//            double maxX = 0;
//            while (maxX < rfMax) {maxX += maxStep; }
//            return maxX + this.getMinValX();
        } else {
            return maxValX;
        }
    }

    public void setMaxValX(double maxValX) {
        this.maxValX = maxValX;
    }

    public double getMaxValY() {
        return maxValY;
    }

    public void setMaxValY(double maxValY) {
        this.maxValY = maxValY;
    }

    public double getMinValX() {
        return minValX;
    }

    public void setMinValX(double minValX) {
        this.minValX = minValX;
    }

    public double getMinValY() {
        return minValY;
    }

    public void setMinValY(double minValY) {
        this.minValY = minValY;
    }
}

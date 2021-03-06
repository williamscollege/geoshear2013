/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.williams.geoshear2013;

import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;


/**
 *
 * @author cwarren
 */
public class GSEllipse {
    protected double x,y;
    protected double majorRadius,minorRadius;
    protected double thetaRad;
    
    protected Matrix2x2 matrix; // the affine tranform matrix that converts the unit circle into this ellipse;
    
    public Shape shape;
    
    /*------------------------------------------------------------------------*/
    public GSEllipse() { // unit circle is the default
        this(0, 0, 1, 1, 0);
    }
    public GSEllipse(double majorRadius, double minorRadius) {
        this(0, 0, majorRadius, minorRadius, 0);
    }
    public GSEllipse(double majorRadius, double minorRadius, double theta) {
        this(0, 0, majorRadius, minorRadius, theta);
    }
    public GSEllipse(double x, double y, double majorRadius, double minorRadius, double theta) {
        this.x = x;
        this.y = y;
        this.majorRadius = majorRadius;
        this.minorRadius = minorRadius;
        this.thetaRad = theta;
        
        this.setMatrixFromKeyData();
    }
    public GSEllipse(Matrix2x2 t) { // unit circle is the default
        new GSEllipse().deform(new Deformation(t));
    }
    /*------------------------------------------------------------------------*/

    @Override
    public GSEllipse clone() {
        return new GSEllipse(this.x,this.y,this.majorRadius,this.minorRadius,this.thetaRad);
    }
    
    @Override
    public String toString() {
        return this.keyDataAsString()+"\n"+this.getMatrix().toString();
    }

    public String keyDataAsString() {
        return "x: "+this.x+", y: "+this.y+", majorRadius: "+this.majorRadius+", minorRadius: "+this.minorRadius+", theta: "+this.thetaRad;
    }

    public void errDump() {
        System.err.println(this.toString());
    }
    
    /*------------------------------------------------------------------------*/

    public void deform(Deformation deformation) {
        Deformation dT = deformation.clone();
        if (dT.isShearing()) {
            AffineTransform shearTrans = AffineTransform.getShearInstance(deformation.m10*-1, deformation.m01*-1);
            Point2D curCenter = new Point2D.Double(this.x, this.y);
            shearTrans.transform(curCenter, curCenter);
            this.x = curCenter.getX();
            this.y = curCenter.getY();
        } else if (dT.isScaling()) {
            AffineTransform scaleTrans = AffineTransform.getScaleInstance(deformation.m00, deformation.m11);
            Point2D curCenter = new Point2D.Double(this.x, this.y);
            scaleTrans.transform(curCenter, curCenter);
            this.x = curCenter.getX();
            this.y = curCenter.getY();
        }  else if (dT.isRotational()) {
            AffineTransform rotTrans = AffineTransform.getRotateInstance(Math.acos(deformation.m00) * ((deformation.m01 > 0) ? -1 : 1));
            Point2D curCenter = new Point2D.Double(this.x, this.y);
            rotTrans.transform(curCenter, curCenter);
            this.x = curCenter.getX();
            this.y = curCenter.getY();
        } else {
            Point2D curCenter = new Point2D.Double(this.x, this.y);

            AffineTransform otherTrans = dT.asAffineTransform();
            otherTrans.transform(curCenter, curCenter);
            this.x = curCenter.getX();
            this.y = curCenter.getY();
        }

        this.matrix = this.matrix.times(deformation);
        this.setKeyDataFromMatrix();
    }
    
    /*------------------------------------------------------------------------*/

    /**
     * set the matrix that defines this ellipse from its center (x and y), axes (majorRadius and minorRadius) and rotation (thetaRad)
     */
    public final void setMatrixFromKeyData() {        
        Matrix2x2 scalingMatrix = new Matrix2x2(this.majorRadius, 0, 0, this.minorRadius);
        Matrix2x2 rotationMatrix = new Matrix2x2(Math.cos(this.thetaRad), -1*Math.sin(this.thetaRad), Math.sin(this.thetaRad), Math.cos(this.thetaRad));
        
        this.matrix = scalingMatrix.times(rotationMatrix);

        this.setShape();
    }
    
    public void setKeyDataFromMatrix() {
        Matrix2x2[] u_sig_vt = this.matrix.svd();
        
        this.majorRadius = u_sig_vt[1].m00;
        this.minorRadius = u_sig_vt[1].m11;
        this.thetaRad = Math.acos(u_sig_vt[2].m00); // 'REAL'
        
        if (u_sig_vt[2].m01 > 0) {  // the correct sign of the angle is determined by the 01 or 10 element of the vT matrix (they're inverted, so flip the text is using m10)
            this.thetaRad = this.thetaRad * -1;
        }

        // constrain angles between pi/2(90) and pi/-2(-90)
        while (this.thetaRad > Math.PI/2) { this.thetaRad -= Math.PI; }
        while (this.thetaRad < Math.PI/-2) { this.thetaRad += Math.PI; }
            
        this.setMatrixFromKeyData(); // resets the matrix based on the appropriately signed thetaRad
    }

    /**
     * set the shape object for this ellipse from its internal data
     */
    public void setShape() {
        this.shape = this.getAffineTransform().createTransformedShape(new Ellipse2D.Double(-1,-1,2,2)); // transform the unit circle
    }
    
    /**
     * set the center (x and y) of this ellipse relative to a new origin that's given in the coordinate of the original
     */
    public void shiftPosition(double x, double y) {
        this.x = this.x - x;
        this.y = this.y - y;
        this.setMatrixFromKeyData();
    }
    
    /*------------------------------------------------------------------------*/

    /**
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(double x) {
        this.x = x;
        this.setMatrixFromKeyData();
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(double y) {
        this.y = y;
        this.setMatrixFromKeyData();
    }

    public Point2D getCenterAsPoint2D() {
        return new Point2D.Double(this.x,this.y);
    }

    /**
     * @return the majorRadius
     */
    public double getMajorRadius() {
        return majorRadius;
    }

    /**
     * @param majorRadius the majorRadius to set
     */
    public void setMajorRadius(double majorRadius) {
        this.majorRadius = majorRadius;
        this.setMatrixFromKeyData();
    }

    /**
     * @return the minorRadius
     */
    public double getMinorRadius() {
        return minorRadius;
    }

    /**
     * @param minorRadius the minorRadius to set
     */
    public void setMinorRadius(double minorRadius) {
        this.minorRadius = minorRadius;
        this.setMatrixFromKeyData();
    }

    /**
     * @return the ration of the long axis to the short axis
     */
    public double getRF() {
        return this.getMajorRadius()/this.getMinorRadius();
    }
    
    /**
     * NOTE: thetaRad is internally inverted to implement counter-clockwise rotation
     * @return the thetaRad
     */
    public double getThetaRad() {
        return thetaRad;
    }

    /**
     * NOTE: thetaRad is internally inverted to implement counter-clockwise rotation
     * @param thetaRad the thetaRad to set
     */
    public void setThetaRad(double thetaRad) {
        this.thetaRad = thetaRad;
        this.setMatrixFromKeyData();
    }
    
    /**
     * @return the affine transform that converts the unit circle to this ellipse
     */
    public Matrix2x2 getMatrix() {
        return this.matrix;
    }

    /**
     * @return the affine transform that converts the unit circle to this ellipse
     */
    public AffineTransform getAffineTransform() {
        AffineTransform af = new AffineTransform(this.matrix.m00, this.matrix.m01, this.matrix.m10, this.matrix.m11,this.x, this.y*-1);
        return af;
    }    
}

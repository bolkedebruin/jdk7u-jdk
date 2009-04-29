/*
 * Copyright 2002-2007 Sun Microsystems, Inc.  All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Sun designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Sun in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Sun Microsystems, Inc., 4150 Network Circle, Santa Clara,
 * CA 95054 USA or visit www.sun.com if you need additional information or
 * have any questions.
 */
package org.jdesktop.swingx.designer.paint;

import java.awt.Paint;
import java.awt.TexturePaint;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 * Represents a TexturePaint.
 *
 * @author rbair
 */
public class Texture extends PaintModel {
    private static final Rectangle2D RECT = new Rectangle2D.Double(0, 0, 1, 1);
    private BufferedImage img;

    public Texture() {
    }

    public PaintControlType getPaintControlType() {
        return PaintControlType.control_rect;
    }

    public void setImage(BufferedImage img) {
        BufferedImage old = this.img;
        this.img = img;
        firePropertyChange("paint", old, this.img);
        firePropertyChange("image", old, this.img);
    }

    public final BufferedImage getImage() {
        return img;
    }

    public Paint getPaint() {
        return new TexturePaint(img, RECT);
    }


    public Texture clone() {
        Texture newTexture = new Texture();
        newTexture.img = this.img;
        return newTexture;
    }
}
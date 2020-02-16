package org.grichardson108.javafxopengl;

import static com.jogamp.opengl.GL.GL_COLOR_BUFFER_BIT;

import com.jogamp.opengl.GL2GL3;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLJPanel;
import com.jogamp.opengl.util.FPSAnimator;

/**
 * Minimal JOGL in JavaFX example.
 *
 * @author Mac70
 */
public class SwingGLJPanel extends GLJPanel implements GLEventListener {

    private static GLCapabilities prepareGLCapabilities() {
        GLProfile profile = GLProfile.getDefault();
        GLCapabilities caps = new GLCapabilities(profile);
        caps.setHardwareAccelerated(true);
        caps.setDoubleBuffered(true);
        return caps;
    }

    static FPSAnimator animator;
    private double tick;

    public SwingGLJPanel() {
        super(prepareGLCapabilities());
    }

    public void setup() {
        addGLEventListener(this);
        // addKeyListener(this);
        animator = new FPSAnimator(this, 60, false);
        animator.start();
    }

    @Override
    public void init(GLAutoDrawable drawable) {
        System.out.println("init");
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
        animator.stop();
        System.out.println("dispose");
        System.exit(0);
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        GL2GL3 g = drawable.getGL().getGL2GL3();
        g.glClearColor(0, (float) Math.sin(tick * Math.PI), 1, 1);
        g.glClear(GL_COLOR_BUFFER_BIT);

        tick = (tick + 0.01) % 1;
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        System.out.println("reshape");
    }
}
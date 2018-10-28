package br.com.CG;

import java.util.List;

import com.jogamp.common.util.locks.RecursiveLock;
import com.jogamp.nativewindow.NativeSurface;
import com.jogamp.opengl.GL;
import com.jogamp.opengl.GLAnimatorControl;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilitiesImmutable;
import com.jogamp.opengl.GLContext;
import com.jogamp.opengl.GLDrawable;
import com.jogamp.opengl.GLDrawableFactory;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLException;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.GLRunnable;
@SuppressWarnings("all")
public class AutoDrawable implements GLAutoDrawable{

	public void setRealized(boolean realized) {
		// TODO Auto-generated method stub
		
	}

	public boolean isRealized() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getSurfaceWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getSurfaceHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isGLOriented() {
		// TODO Auto-generated method stub
		return false;
	}

	public void swapBuffers() throws GLException {
		// TODO Auto-generated method stub
		
	}

	public GLCapabilitiesImmutable getChosenGLCapabilities() {
		// TODO Auto-generated method stub
		return null;
	}

	public GLCapabilitiesImmutable getRequestedGLCapabilities() {
		// TODO Auto-generated method stub
		return null;
	}

	public GLProfile getGLProfile() {
		// TODO Auto-generated method stub
		return null;
	}

	public NativeSurface getNativeSurface() {
		// TODO Auto-generated method stub
		return null;
	}

	public long getHandle() {
		// TODO Auto-generated method stub
		return 0;
	}

	public GLDrawableFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	public GLDrawable getDelegatedDrawable() {
		// TODO Auto-generated method stub
		return null;
	}

	public GLContext getContext() {
		// TODO Auto-generated method stub
		return null;
	}

	public GLContext setContext(GLContext newCtx, boolean destroyPrevCtx) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addGLEventListener(GLEventListener listener) {
		// TODO Auto-generated method stub
		
	}

	public void addGLEventListener(int index, GLEventListener listener) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		
	}

	public int getGLEventListenerCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean areAllGLEventListenerInitialized() {
		// TODO Auto-generated method stub
		return false;
	}

	public GLEventListener getGLEventListener(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean getGLEventListenerInitState(GLEventListener listener) {
		// TODO Auto-generated method stub
		return false;
	}

	public void setGLEventListenerInitState(GLEventListener listener, boolean initialized) {
		// TODO Auto-generated method stub
		
	}

	public GLEventListener disposeGLEventListener(GLEventListener listener, boolean remove) {
		// TODO Auto-generated method stub
		return null;
	}

	public GLEventListener removeGLEventListener(GLEventListener listener) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setAnimator(GLAnimatorControl animatorControl) throws GLException {
		// TODO Auto-generated method stub
		
	}

	public GLAnimatorControl getAnimator() {
		// TODO Auto-generated method stub
		return null;
	}

	public Thread setExclusiveContextThread(Thread t) throws GLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Thread getExclusiveContextThread() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean invoke(boolean wait, GLRunnable glRunnable) throws IllegalStateException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean invoke(boolean wait, List glRunnables) throws IllegalStateException {
		// TODO Auto-generated method stub
		return false;
	}

	public void flushGLRunnables() {
		// TODO Auto-generated method stub
		
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void display() {
		// TODO Auto-generated method stub
		
	}

	public void setAutoSwapBufferMode(boolean enable) {
		// TODO Auto-generated method stub
		
	}

	public boolean getAutoSwapBufferMode() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setContextCreationFlags(int flags) {
		// TODO Auto-generated method stub
		
	}

	public int getContextCreationFlags() {
		// TODO Auto-generated method stub
		return 0;
	}

	public GLContext createContext(GLContext shareWith) {
		// TODO Auto-generated method stub
		return null;
	}

	public GL getGL() {
		// TODO Auto-generated method stub
		return null;
	}

	public GL setGL(GL gl) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getUpstreamWidget() {
		// TODO Auto-generated method stub
		return null;
	}

	public RecursiveLock getUpstreamLock() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isThreadGLCapable() {
		// TODO Auto-generated method stub
		return false;
	}

}

package keyconfiguration;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.golden.gamedev.Game;
import com.golden.gamedev.GameObject;

import charactersprites.Player;

public  class SystemKeyObserver extends KeyObserver{
    private GameObject myGame;
    public SystemKeyObserver(GameObject game) {
        myGame = game;
    }

    @Override
    public void getActoinMethods(String action) {
        Class<?> c = myGame.getClass();
        Method[] methods = c.getMethods();
        for(Method m : methods){
            if(m.getName().equals("ESC"))
                System.out.println("esc");
            Annotation annotation = m.getAnnotation(KeyAnnotation.class);
            if(annotation instanceof KeyAnnotation ){
                KeyAnnotation key = (KeyAnnotation) annotation;
                if(key.action().equals(action)){
                    try {
                        m.invoke(myGame);
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}

package org.patch;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.LoaderClassPath;

import java.io.ByteArrayInputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class Swinghtml implements ClassFileTransformer {
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        if(className.equals("javax/swing/plaf/basic/BasicHTML")){
            try {
                ClassPool classPool = ClassPool.getDefault();
                classPool.appendClassPath(new LoaderClassPath(loader));
                CtClass clazz = classPool.makeClass(new ByteArrayInputStream(classfileBuffer), false);
                CtMethod method = clazz.getDeclaredMethod("isHTMLString");
                method.setBody("return false;");
                System.out.println("Successfully Patched.");
                return clazz.toBytecode();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Patch Failed.");
            }
        }
        return null;
    }
}
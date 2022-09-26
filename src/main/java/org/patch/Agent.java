package org.patch;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;


public class Agent {
    public static void premain(String agentArgs, Instrumentation instrumentation) {
        System.out.println("====== CVE-2022-39197 patch @burpheart ======");
        instrumentation.addTransformer(new Swinghtml(), true);
        Class[] allLoadedClasses = instrumentation.getAllLoadedClasses();
        for (Class loadedClass : allLoadedClasses) {
            if (loadedClass.getName() == "javax.swing.plaf.basic.BasicHTML" ) {
                try {
                    instrumentation.retransformClasses(loadedClass);

                    System.out.println("Successfully Replaced.");
                } catch (UnmodifiableClassException e) {
                    e.printStackTrace();
                    System.out.println("Replaced Failed.");
                }
            }
        }
    }
}
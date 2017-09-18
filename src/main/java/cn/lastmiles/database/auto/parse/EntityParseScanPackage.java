package cn.lastmiles.database.auto.parse;

import cn.lastmiles.database.auto.annotation.Table;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class EntityParseScanPackage {

    /**
     * Access and specify the package and package all the classes
     *
     * @param packageName package name
     * @return class names
     * @throws ClassNotFoundException ClassNotFoundException
     * @throws URISyntaxException     URISyntaxException
     * @throws IOException            IOException
     */
    public static Set<Class<?>> getClassName(String packageName)
            throws ClassNotFoundException, URISyntaxException, IOException {
        Set<Class<?>> clazzes = ParseScanPackage.findPackageAnnotationClass(packageName,
                Table.class);
        Iterator<Class<?>> clazzIterable = clazzes.iterator();
        while (clazzIterable.hasNext()) {
            if (!clazzIterable.next().isAnnotationPresent(Table.class)) {
                clazzIterable.remove();
            }
        }
        return clazzes;
    }
}

package cn.lastmiles.database.auto.parse;

import cn.lastmiles.database.auto.annotation.Table;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;

public class EntityParseScanPackage {

	/**
	 * 
	 * Access and specify the package and package all the classes
	 * 
	 * @param packageName
	 *            package name
	 * @return class names
	 * @throws ClassNotFoundException
	 *             ClassNotFoundException
	 * @throws URISyntaxException
	 *             URISyntaxException
	 * @throws IOException
	 *             IOException
	 */
	public static List<Class<?>> getClassName(String packageName)
			throws ClassNotFoundException, URISyntaxException, IOException {
		List<Class<?>> clazzes = ParseScanPackage.getClassName(packageName,
				true);
		Iterator<Class<?>> clazzIterable = clazzes.iterator();
		while (clazzIterable.hasNext()) {
			if (!clazzIterable.next().isAnnotationPresent(Table.class)) {
				clazzIterable.remove();
			}
		}
		return clazzes;
	}
}

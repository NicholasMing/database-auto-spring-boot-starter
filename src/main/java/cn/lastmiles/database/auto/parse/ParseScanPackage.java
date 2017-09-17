package cn.lastmiles.database.auto.parse;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ParseScanPackage {

	/**
	 * 
	 * Get a package (including all child package) under all the classes
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
		return getClassName(packageName, true);
	}

	/**
	 * Get a package under all the classes
	 * 
	 * @param packageName
	 *            packageName
	 * @param isChildPackage
	 *            isChildPackage
	 * @return class names
	 * @throws URISyntaxException
	 *             URISyntaxException
	 * @throws IOException
	 *             IOException
	 * @throws ClassNotFoundException
	 *             ClassNotFoundException
	 */
	public static List<Class<?>> getClassName(String packageName,
			boolean isChildPackage) throws URISyntaxException,
			ClassNotFoundException, IOException {
		List<Class<?>> classes = new ArrayList<Class<?>>();
		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();
		String packagePath = packageName.replace(".", "/");
		URL url = classLoader.getResource(packagePath);
		if (url != null) {
			String type = url.getProtocol();
			String path = url.toURI().getPath();
			if (type.equals("file")) {
				classes = getClassNameByFile(path, isChildPackage);
			} else if (type.equals("jar")) {
				classes = getClassNameByJar(path, isChildPackage);
			}
		} else {
			classes = getClassNameByJars(
					((URLClassLoader) classLoader).getURLs(), packagePath,
					isChildPackage);
		}
		return classes;
	}

	/**
	 * Get a package under all the classes by file
	 * 
	 * @param filePath
	 * @param className
	 * @param isChildPackage
	 * @return classes
	 * @throws ClassNotFoundException
	 */
	private static List<Class<?>> getClassNameByFile(String filePath,
			boolean isChildPackage) throws ClassNotFoundException {
		List<Class<?>> classes = new ArrayList<Class<?>>();
		File file = new File(filePath);
		if (!file.exists()) {
			return classes;
		}
		File[] childFiles = file.listFiles();
		for (File childFile : childFiles) {
			if (childFile.isDirectory()) {
				if (isChildPackage) {
					classes.addAll(getClassNameByFile(childFile.getPath(),
							isChildPackage));
				}
			} else {
				String childFilePath = childFile.getPath();
				if (childFilePath.endsWith(".class")) {
					childFilePath = childFilePath.substring(
							childFilePath.indexOf("/classes") + 9,
							childFilePath.lastIndexOf("."));
					childFilePath = childFilePath.replace("/", ".");
					classes.add(Class.forName(childFilePath));
				}
			}
		}
		return classes;
	}

	/**
	 * Get a package under all the classes by jar
	 * 
	 * @param jarPath
	 * @param isChildPackage
	 * @return classes
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	private static List<Class<?>> getClassNameByJar(String jarPath,
			boolean isChildPackage) throws ClassNotFoundException, IOException {
		List<Class<?>> classes = new ArrayList<Class<?>>();
		String[] jarInfo = jarPath.split("!");
		String jarFilePath = jarInfo[0].substring(jarInfo[0].indexOf("/"));
		String packagePath = jarInfo[1].substring(1);
		JarFile jarFile = new JarFile(jarFilePath);
		Enumeration<JarEntry> entrys = jarFile.entries();
		while (entrys.hasMoreElements()) {
			JarEntry jarEntry = entrys.nextElement();
			String entryName = jarEntry.getName();
			if (entryName.endsWith(".class")) {
				if (isChildPackage) {
					if (entryName.startsWith(packagePath)) {
						entryName = entryName.replace("/", ".").substring(0,
								entryName.lastIndexOf("."));
						classes.add(Class.forName(entryName));
					}
				} else {
					int index = entryName.lastIndexOf("/");
					String myPackagePath;
					if (index != -1) {
						myPackagePath = entryName.substring(0, index);
					} else {
						myPackagePath = entryName;
					}
					if (myPackagePath.equals(packagePath)) {
						entryName = entryName.replace("/", ".").substring(0,
								entryName.lastIndexOf("."));
						classes.add(Class.forName(entryName));
					}
				}
			}
		}
		return classes;
	}

	/**
	 * Get a package under all the classes by all jars
	 * 
	 * @param urls
	 * @param packagePath
	 * @param isChildPackage
	 * @return 类的完整名称
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private static List<Class<?>> getClassNameByJars(URL[] urls,
			String packagePath, boolean isChildPackage)
			throws URISyntaxException, ClassNotFoundException, IOException {
		List<Class<?>> classes = new ArrayList<Class<?>>();
		if (urls == null) {
			return classes;
		}
		for (URL url : urls) {
			String urlPath = url.toURI().getPath();
			// Ignore classes
			if (urlPath.endsWith("classes/")) {
				continue;
			}
			String jarPath = urlPath + "!/" + packagePath;
			classes.addAll(getClassNameByJar(jarPath, isChildPackage));
		}
		return classes;
	}
}

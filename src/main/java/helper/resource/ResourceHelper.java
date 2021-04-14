package helper.resource;

/**
 * 
 * @author Bhanu Pratap Singh
 *
 */
public class ResourceHelper {

	public static String getResourcePath(String path) {
        String basePath = System.getProperty("user.dir");
		return basePath +"/"+ path;
	}
}

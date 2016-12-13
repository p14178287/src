package pkgController;

@FunctionalInterface
public interface ScreenController {
	
	/**
	 * abstract method that forms a contract with the class
	 * that implements this interface
	 */
	public void setParentScreen(ScreensBeingSwitched switchingScreens);
	
}

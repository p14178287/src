package pkgController;

import java.util.List;

import javafx.animation.FadeTransition;
import javafx.scene.Node;
import javafx.util.Duration;
import main.ApplicationLoader;
import pkgModel.Customer;
import pkgView.Users.LoginPane;

@FunctionalInterface
public interface ScreenControlUtility {
	
	/**
	 * abstract method that forms a contract with the class
	 * that implements this interface
	 */
	 public void LoginController(ApplicationLoader applicationLoader, LoginPane view, List<Customer> model);
	 
	 
		   
}

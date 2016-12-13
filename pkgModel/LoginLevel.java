package pkgModel;


import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class LoginLevel implements Serializable {
	
	

		private String levelName;
		private Map<String, Employee> levels;

		public LoginLevel(String levelName) {
			this.levelName = levelName;
			levels = new HashMap<String, Employee>();
		}


		@Override
		public String toString() {
			//a non-standard toString that simply returns the course name,
			//so as to assist in displaying courses correctly in a ComboBox<Course>
			return levelName;
		}


	}




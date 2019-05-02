package Interfaces;
import java.util.*;
public interface ISavable {
	List<String> write();
	void read(List<String> savedValues);
}


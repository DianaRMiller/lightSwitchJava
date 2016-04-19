
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.BitSet;
import java.util.List;


public class LightSwitchesGame {

	public static void main(String[] args) throws IOException {
    //Object named data of type String List will iterate through all the lines from the file text lightsGame.txt
	List<String> data = Files.readAllLines(Paths.get("/Users/computeruser/Documents/lightsGame.txt"));
    //N of type int will parse the String data as an integer
	int N = Integer.parseInt(data.get(0));
	//BitSet class helps us manipulate the data from the text fiel that passes integers
    BitSet switches = new BitSet(N);
    //with the for loop we'll go through the data list starting at 1, the method size will return the number of
    //elements of the list
    for (int i = 1; i < data.size(); i++) {
        String[] line = data.get(i).split(" ");
        //Object named line of type array String will get the object data starting at index 1
        //The method .split will invoke 2 arguments "split-method" and limit the argument of zero, returning an array of strings
        int rangeStart = Integer.parseInt(line[0]), rangeEnd = Integer.parseInt(line[1]);
        if (rangeStart > rangeEnd) {
            int x = rangeStart;
            rangeStart = rangeEnd;
            rangeEnd = x;
        }
        //the flip method from object switches of type BitSet takes a range and changes the state of its data
        //along that range
        switches.flip(rangeStart, rangeEnd+1);
    }
    //Print the value of cardinality that counts how many places in the BitSet are 1's
    System.out.println(switches.cardinality());
}
}



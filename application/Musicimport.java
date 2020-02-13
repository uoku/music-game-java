package application;

import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Musicimport extends DataInputStream{
	public 	int[][] ve;
	public	int musicrow;
	@SuppressWarnings("deprecation")
	public Musicimport(InputStream arg0) throws FileNotFoundException {
		super(arg0);

		ArrayList<String> node = new ArrayList<String>();
		String Line,tempstring;
		String[] temparray= new String[4];
		
		
		try {
			while((Line=readLine()) != null) {
				tempstring = Line;
				temparray=tempstring.split("\\s");
				for(int i =0;i<temparray.length;i++) {
					node.add(temparray[i]);
				}	
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		int k = node.size()/4;
		int count =0;
		ve = new int[k][4];
		for(int i =0 ; i<k;i++) {
			for(int j= 0 ;j<4;j++) {
				ve[i][j]=Integer.parseInt((String)node.get(count));
				count++;
			}
		}
		musicrow = k;
	}
	
	
}


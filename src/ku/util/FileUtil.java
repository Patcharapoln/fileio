package ku.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * 
 * @author Patcharapol Nirunpornputta
 *
 */
public class FileUtil {
	
	/**
	 * Copy InputStream to the OutputStream one byte at a time.
	 * Close the InputStream and OutputStream when finished.
	 * @param in= input for reading
	 * @param out= output for writing
	 */
	static void copy(InputStream in, OutputStream out) {
		try {
			int count = in.read();
			while (count != -1) {
				out.write(count);
				count = in.read();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	/**
	 * Copy InputStream to the OutputStream using a byte array of size blocksize.
	 * Close the InputStream and OutputStream when finished.
	 * @param in = input for reading
	 * @param out = output for writing
	 * @param blocksize = size of array
	 */
	static void copy(InputStream in, OutputStream out, int blocksize) {
		byte[] buffer = new byte[blocksize];
		try {
			int count = in.read(buffer);
			while (count != -1) {
				out.write(buffer, 0, count);
				count = in.read(buffer);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	/**
	 * Copy InputStream to the OutputStream using a BufferedReader to read the InputStream
	 * and PrintWriter to write the OutputStream. Read and write one line at a time.
	 * @param in = input for reading
	 * @param out = output for writing
	 */
	static void bcopy(InputStream in, OutputStream out) {
		BufferedReader breader = new BufferedReader(new InputStreamReader(in));
		PrintWriter print = new PrintWriter(out);

		try {
			while (true) {
				String text = breader.readLine();
				if (text != null) {
					print.write(text);
				} else
					break;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
}

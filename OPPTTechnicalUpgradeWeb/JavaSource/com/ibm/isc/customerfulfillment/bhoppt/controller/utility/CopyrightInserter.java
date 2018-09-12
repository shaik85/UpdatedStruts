/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.Vector;


/**
 * Will add a copyright statement to each *.java file in the given directory and it's subdirectories.
 * Afterwards the files are saved using the old file name.
 * The change is only done if the copyright statement doesn't exist allready.
*/
public class CopyrightInserter 
{
	/**
	 * IBM Confidential
	 * Electronic Transport Order
	 * (C) Copyright IBM Corp. 1998, 2003
	 */

	CopyrightStatement copyright = null;
	/**
	 * As there are some variable contents in the Copyright statement one should allways  
	 * @param programName eg. Electronic Transport Order
	 * @param firstYear eg. 1998
	 * @param lastYear eg. 2003
	 * @throws InvalidParameterException if(programName==null||firstYear==null||lastYear==null||programName.length()==0||firstYear.length()==0||lastYear.length()==0)
	 */
	public CopyrightInserter(
		String programName,
		String firstYear,
		String lastYear)
		throws InvalidParameterException {
		copyright = new CopyrightStatement(programName, firstYear, lastYear);
	}

	/**
	 * Contains the valid Copyright statement
	 */
	class CopyrightStatement {
		String copyright = "IBM Confidential";  //$NON-NLS-1$
		String programName;
		String firstYear;
		String lastYear;

		String copyrightStatement;
		String copyrightStatementAsJavaComment;

		/**
         * CopyrightStatement
         * @param programName
         * @param firstYear
         * @param lastYear
         * @throws java.security.InvalidParameterException
         * @author thirumalai
         */
        public CopyrightStatement(
			String programName,
			String firstYear,
			String lastYear)
			throws InvalidParameterException {
			if (programName == null
				|| firstYear == null
				|| lastYear == null
				|| programName.length() == 0
				|| firstYear.length() == 0
				|| lastYear.length() == 0)
				throw new InvalidParameterException("Parameters aren't allowed to be null or \"\"");  //$NON-NLS-1$
			//preparations for a faster program execution
			setCopyrightStatement(programName, firstYear, lastYear);
			setCopyrightStatementAsJavaComment();
		}
		/**
		 * This string contains the lines of the Copyrightstatement.
		 * By having this separated we are able to check for this statement in all
		 * places, not only in Java comments.
		 * This is important if we choose to have WSAD to automatically include the statement upon class creation
		 */
		private void setCopyrightStatement(
			String programName,
			String firstYear,
			String lastYear) {
			copyrightStatement =
				"* "  //$NON-NLS-1$
					+ copyright
					+ System.getProperty("line.separator")  //$NON-NLS-1$
					+ "* "  //$NON-NLS-1$
					+ programName
					+ System.getProperty("line.separator")  //$NON-NLS-1$
					+ "* (C) Copyright IBM Corp. "  //$NON-NLS-1$
					+ firstYear
					+ ", "  //$NON-NLS-1$
					+ lastYear;
		}

		/**
		 *  This string is a valid Java comment containing the Copyright statement
		 *  IBM Confidential
		 *  Electronic Transport Order
		 *  (C) Copyright IBM Corp. 1998, 2003
		 */
		private void setCopyrightStatementAsJavaComment() {
			copyrightStatementAsJavaComment =
				System.getProperty("line.separator")  //$NON-NLS-1$
					+ "/*"  //$NON-NLS-1$
					+ System.getProperty("line.separator")  //$NON-NLS-1$
					+ copyrightStatement
					+ System.getProperty("line.separator")  //$NON-NLS-1$
					+ "*/"  //$NON-NLS-1$
					+ System.getProperty("line.separator");  //$NON-NLS-1$
		}

		/**
         * getCopyrightStatement
         *
         * @return
         */
		public String getCopyrightStatement() {
			return copyrightStatement;
		}

		/**
		 * getCopyrightStatementAsJavaComment
		 * 
		 * @return
		 */
		public String getCopyrightStatementAsJavaComment() {
			return copyrightStatementAsJavaComment;
		}

	}

	//I used all these inner classes to be able to distribute the program within one single file without pain
	class WriteFile {
		//copied from com.ibm.cccs.batch.core
		/**
         * writeFileData
         * @param outputFileName
         * @param text
         * @throws java.io.IOException
         * @author thirumalai
         */
        public void writeFileData(String outputFileName, String text)
			throws java.io.IOException {

			// create File
			File outputFile = new File(outputFileName);
			// create Filewriter
			FileWriter out = new FileWriter(outputFile);
			// write file
			out.write(text);
			// close file
			out.close();
		}
	}

	/**
	 * Contains a low level file read that I copied from com.ibm.cccs.batch.core
	 */
	class ReadFile {
		String eol = System.getProperty("line.separator");  //$NON-NLS-1$
		/**
         * readFileData
         * 
         * @param sFileName
         * @throws java.io.IOException
         * @return
         * @author thirumalai
         */
        public String readFileData(String sFileName)
			throws java.io.IOException {

			//29.10.03 T. Michelmann: The code below messed up with files > 50kB
			/*			String sTheFileContent = "";
			
						// create file  	
						File inputFile = new File(sFileName);
						//opens the file
						FileReader fr = new FileReader(inputFile);
						//this declares the char array
						char caData[] = new char[(char) inputFile.length()];
						//this gets the data, each char into the char array
						int i = fr.read(caData);
						//convert char array to string
						sTheFileContent = new String(caData, 0, i);
						//close the file
						fr.close();
			
						return sTheFileContent;
			*/
			BufferedReader in = new BufferedReader(new FileReader(sFileName));
			StringBuffer ret = new StringBuffer();
			String tempLine = null;
			do {
				tempLine = in.readLine();
				if (tempLine != null) {
					ret.append(tempLine);
					ret.append(eol);
				}
			} while (tempLine != null);
			in.close();
			return ret.toString();
		}
	}

	/**
	 * This class will help in getting a complete directory structure (excluding the start directory)
	 * 
	 */
	class DirectoryTraverser {
		//this Vector is a bit ugly as it is used by getAllDirs to save the result over the time of many calls to the same method. 
		private Vector ret = new Vector();

		/**
         * getAllDirectories
         * 
         * @param startDir
         * @return
         * @author thirumalai
         */
        public Vector getAllDirectories(String startDir) {
			Vector ret = getAllDirs(startDir);
			//as retAllDirs does not return the startDirectory I add this manually now
			ret.addElement(startDir);
			return ret;
		}

		/**
		 * @param startDir
		 * @return a Vector containing all dirs and the the paths to them EXCLUDING the start directory
		 */
		private Vector getAllDirs(String startDir) {
			//There are many much more elegant solutions for a depth first search
			//but I just wanted a quick solution without much thinking and searching
			File[] dirs = null;
			File startDirectory = new File(startDir);
			dirs = startDirectory.listFiles(new DirectoryFilter());
			for (int i = 0; i < dirs.length; i++) {
				ret.addElement(dirs[i].getAbsolutePath());
				getAllDirs(dirs[i].getAbsolutePath());
			}
			return ret;
		}
		class DirectoryFilter implements FileFilter {
			/**
             * accept
             * 
             * @see java.io.FileFilter#accept(java.io.File)
             * @author thirumalai
             */
            public boolean accept(File pathname) {
				return pathname.isDirectory();
			}
		}
	}

	class JavaFileFinder {
		/**
         * getAllJavaFilesWithinDirs
         * 
         * @param dir
         * @return
         * @author thirumalai
         */
        public String[] getAllJavaFilesWithinDirs(String dir) {
			String[] ret = null;
			File[] files = null;
			File directory = new File(dir);
			files = directory.listFiles(new JavaFileFilter());

			ret = new String[files.length];
			for (int i = 0; i < files.length; i++) {
				ret[i] = files[i].getAbsolutePath();
			}
			return ret;
		}
		class JavaFileFilter implements FilenameFilter {
			/**
             * accept
             * 
             * @see java.io.FilenameFilter#accept(java.io.File, java.lang.String)
             * @author thirumalai
             */
            public boolean accept(File pathname, String name) {
				return name.endsWith(".java");  //$NON-NLS-1$
			}
		}
	}

	/**
	 * @param source a String that has to be checked
	 * @return true if the copyright statement exists in any place in the String (either in the javadoc or in a normal comment)
	 */
	private boolean isCopyrightAlreadyExisting(String source) {
		return source.indexOf(copyright.getCopyrightStatement()) != -1;
	}

	/**
     * Will add a copyright statement to each *.java file in the given directory and it's subdirectories.
     * Afterwards the files are saved using the old file name.
     * The change is only done if the copyright statement doesn't exist allready.
     *
     * @param startDir
     * @return Vector
     */
	public Vector process(String startDir) {
		String[] files = null;
		Vector dirs = null;
		DirectoryTraverser d = new DirectoryTraverser();
		dirs = d.getAllDirectories(startDir);

		/*
		for (Iterator iter = dirs.iterator(); iter.hasNext();) {
			String element = (String) iter.next();
		}
		*/
		JavaFileFinder ff = new JavaFileFinder();
		int totalFilecounter = 0;
		int changedFileCounter = 0;
		Vector changedFiles = new Vector();
		for (Iterator iter = dirs.iterator(); iter.hasNext();) {
			String element = (String) iter.next();
			files = ff.getAllJavaFilesWithinDirs(element);
			totalFilecounter = totalFilecounter + files.length;
			for (int a = 0; a < files.length; a++) {
				//here we decide how the filename of the output file will be
				String changedFileName = insertCopyright(files[a], files[a]);
				if (changedFileName != null) {
					changedFileCounter++;
					changedFiles.addElement(changedFileName);
				}
			}
		}
		return changedFiles;
	}

	/**
	 * @param inFilename
	 * @param outFilename
	 * @return a null object if the file was not changed else the name of the file that contains the update
	 */
	private String insertCopyright(String inFilename, String outFilename) {
		String input = null;
		String sourceWithCopyright = null;
		//loaf the file
		try {
			input = new ReadFile().readFileData(inFilename);
		} catch (java.io.IOException e) {
			e.printStackTrace();
			return null;
		}
		if (!isCopyrightAlreadyExisting(input)) {
			//insert the copyright statement as comment
			sourceWithCopyright = insertCopyrightInCodeAsComment(input);
		} else //do nothing
			{
			return null;
		}

		//save the file
		try {
			new WriteFile().writeFileData(
				outFilename,
				sourceWithCopyright.toString());
			//				input);
		} catch (IOException e1) {
			e1.printStackTrace();
			return null;
		}
		return outFilename;
	}

	/**
	 * Will add the copyright statement right behind the first {
	 * @param codeWithoutCopyright
	 * @return the input value plus a comment following the first { that contains the copyright statement
	 */
	private String insertCopyrightInCodeAsComment(String codeWithoutCopyright) {
		//insert the copyright statement
		//find the first {
		int index = -1;
		index = codeWithoutCopyright.indexOf("{");  //$NON-NLS-1$
		StringBuffer outWithCopyright = new StringBuffer();
		outWithCopyright.append(codeWithoutCopyright.substring(0, index + 1));
		outWithCopyright.append(System.getProperty("line.separator"));  //$NON-NLS-1$
		outWithCopyright.append(copyright.getCopyrightStatementAsJavaComment());
		outWithCopyright.append(System.getProperty("line.separator"));  //$NON-NLS-1$
		outWithCopyright.append(codeWithoutCopyright.substring(index + 1));
		return outWithCopyright.toString();
	}

	/**
     * main method
     * 
     * @param args
     * @author thirumalai
     */
    public static void main(String[] args) {
		String startDir = "C:\\jad\\image";  //$NON-NLS-1$

		//String startDir = "C:\\temp\\proof_tests";
		Vector res = null;
		CopyrightInserter c =
			new CopyrightInserter("Electronic Transport Order", "1998", "2003");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$

		//start the processing
		long startTime = System.currentTimeMillis();
		res = c.process(startDir);
		long endTime = System.currentTimeMillis();
		//end the processing

		//Some additional information
		if (!res.isEmpty()) {
			for (Iterator iter = res.iterator(); iter.hasNext();) {
				String element = (String) iter.next();
			}
		}
	}
}

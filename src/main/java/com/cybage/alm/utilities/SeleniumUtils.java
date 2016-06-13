package com.cybage.alm.utilities;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class SeleniumUtils extends Base {
	static int i = 0;
	public static void takeScreenShots() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(Links.screenShotsDir + "\\Screen" + i + ".jpg"));
		i++;
	}

	public static void Zipped() {
		try {
			File inputFolder = new File(Links.zipFilePath);
			File outputFolder = new File("AutomationArtifacts.zip");
			ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(outputFolder)));
			BufferedInputStream in = null;
			byte[] data = new byte[1000];
			String files[] = inputFolder.list();
			for (int j = 0; j < files.length; i++) {
				in = new BufferedInputStream(new FileInputStream(inputFolder.getPath() + "/" + files[j]), 1000);
				out.putNextEntry(new ZipEntry(files[j]));
				int totalcount;
				while ((totalcount = in.read(data, 0, 1000)) != -1) {
					out.write(data, 0, totalcount);
				}
				out.closeEntry();
			}
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

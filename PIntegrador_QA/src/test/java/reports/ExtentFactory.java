package reports;

import com.aventstack.extentreports.ExtentReports;

public class ExtentFactory {
    public static ExtentReports getInstance() {
        ExtentReports extent = new ExtentReports();
        extent.setSystemInfo("OS", "Windows");
        extent.setSystemInfo("Navegador", "Chrome");
        extent.setSystemInfo("Ambiente", "QA");
        extent.setSystemInfo("Selenium WebDriver", "4.25.0");
        return extent;
    }
}

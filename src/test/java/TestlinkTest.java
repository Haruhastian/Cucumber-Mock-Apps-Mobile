import com.koltiva.qa.utils.BadakReporter;
import com.koltiva.qa.utils.TestResultReader;
import com.koltiva.qa.utils.constant.ReportGeneratorPolicy;
import com.koltiva.qa.utils.constant.SupportedReports;
import com.koltiva.qa.utils.model.TestLinkData;
import org.junit.Test;

public class TestlinkTest {

    private String sourceDir;
        private String testlinkURL = "https://tcm.apps.kolti.net/lib/api/xmlrpc/v1/xmlrpc.php";
        private String devKey="9081583daaa1fe21d00475e596b43c89";
        private String projectName="Testing";
        private String testPlanName="TestingTestPlant";
        private String buildName="Testing";
    private String platformName;
    private String reportsFrom="CUCUMBER";
    private String reportPolicy="STRICT";

//    @Test
//    public void testt(){
//        System.out.println("===Process Started===");
//        ReportGeneratorPolicy policy = null;
//        try {
//            policy = BadakReporter.searchEnum(ReportGeneratorPolicy.class, reportPolicy);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        if (policy == null) {
//            policy = ReportGeneratorPolicy.STRICT;
//        }
//
//        TestLinkData testLinkData = new TestLinkData().setUrlTestlink(testlinkURL)
//                .setDEVKEY(devKey)
//                .setTestProject(projectName)
//                .setTestPlan(testPlanName)
//                .setBuild(buildName)
//                .setReportPolicy(policy)
//                .setPlatFormName(platformName);
//        try {
//            SupportedReports type = BadakReporter.searchEnum(SupportedReports.class, reportsFrom);
//            if (type == null) {
//                type = SupportedReports.CUCUMBER;
//            }
//            if (sourceDir == null || sourceDir.trim().isEmpty()) {
//                BadakReporter.getReader(type, testLinkData).writeToTestLink();
//            } else {
//                BadakReporter.getReader(type, testLinkData, sourceDir).writeToTestLink();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("===Process Ended===");
//    }

    @Test
    public void test(){
        String jsonPath = System.getProperty("user.dir") + "/target/cucumber.json";
        TestResultReader testResultReader = new TestResultReader();
        try {
            testResultReader.initialize(testlinkURL,
                    devKey,
                    projectName,
                    testPlanName,
                    buildName,
                    "");
            testResultReader.readWithCucumber(jsonPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

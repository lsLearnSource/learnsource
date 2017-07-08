/**
 * Created by liangsheng on 2017/7/8.
 */
public class TestGit {
    private String testSource;
    private String test;

    private String test1;

    /**
     */
    public TestGit() {
        this("1");

    }

    /**
     * @param testSource
     */
    public TestGit(String testSource) {
        this.testSource = testSource;
    }

    public static void main(String[] args) {


        System.out.println("test git");

    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        this.test1 = test1;
    }

    public String getTestSource() {
        return testSource;
    }

    public void setTestSource(String testSource) {
        this.testSource = testSource;
    }
}

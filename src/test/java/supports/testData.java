package supports;

public class testData {
    private String testCaseId, url, username, password, reqCode, status, applicant;
    private String dept, section, depot, unit, reqDate, reportType, reportDate, reportPrintDate;
    private String note, printReasonDifferentDate, pathOfReportForSignature, reportForSignature, referenceDocs;
    private String employee1, employee2, salesSupport, manager;

    public testData(String testCaseId, String url, String username, String password, String reqCode, String status, String applicant, String dept, String section, String depot, String unit, String reqDate, String reportType, String reportDate, String reportPrintDate, String note, String printReasonDifferentDate, String pathOfReportForSignature, String reportForSignature, String referenceDocs, String employee1, String employee2, String salesSupport, String manager) {
        this.testCaseId = testCaseId;
        this.url = url;
        this.username = username;
        this.password = password;
        this.reqCode = reqCode;
        this.status = status;
        this.applicant = applicant;
        this.dept = dept;
        this.section = section;
        this.depot = depot;
        this.unit = unit;
        this.reqDate = reqDate;
        this.reportType = reportType;
        this.reportDate = reportDate;
        this.reportPrintDate = reportPrintDate;
        this.note = note;
        this.printReasonDifferentDate = printReasonDifferentDate;
        this.pathOfReportForSignature = pathOfReportForSignature;
        this.reportForSignature = reportForSignature;
        this.referenceDocs = referenceDocs;
        this.employee1 = employee1;
        this.employee2 = employee2;
        this.salesSupport = salesSupport;
        this.manager = manager;
    }

    public String getTestCaseId() {
        return testCaseId;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getReqCode() {
        return reqCode;
    }

    public String getStatus() {
        return status;
    }

    public String getApplicant() {
        return applicant;
    }

    public String getDept() {
        return dept;
    }

    public String getSection() {
        return section;
    }

    public String getDepot() {
        return depot;
    }

    public String getUnit() {
        return unit;
    }

    public String getReqDate() {
        return reqDate;
    }

    public String getReportType() {
        return reportType;
    }

    public String getReportDate() {
        return reportDate;
    }

    public String getReportPrintDate() {
        return reportPrintDate;
    }

    public String getNote() {
        return note;
    }

    public String getPrintReasonDifferentDate() {
        return printReasonDifferentDate;
    }

    public String getPathOfReportForSignature() {
        return pathOfReportForSignature;
    }

    public String getReportForSignature() {
        return reportForSignature;
    }

    public String getReferenceDocs() {
        return referenceDocs;
    }

    public String getEmployee1() {
        return employee1;
    }

    public String getEmployee2() {
        return employee2;
    }

    public String getSalesSupport() {
        return salesSupport;
    }

    public String getManager() {
        return manager;
    }
}

package model;

public class Account {

    private String accountName;
    private String webSite;
    private String industry;

    public Account(String accountName, String webSite, String industry) {
        this.accountName = accountName;
        this.webSite = webSite;
        this.industry = industry;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }
}
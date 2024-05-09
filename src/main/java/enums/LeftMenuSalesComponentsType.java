package enums;

public enum LeftMenuSalesComponentsType {
    DASHBOARDS("Dashboards"),
    ACTIVITIES("Activities"),
    ACCOUNTS("Accounts"),
    CONTACTS("Contacts"),

    CASES("Cases"),
    OPPORTUNITIES("Opportunities"),
    LEADS("Leads");


    private String menuName;
    public String getMenuName() {
        return menuName;
    }
    LeftMenuSalesComponentsType(String menuName){
        this.menuName = menuName;
    }
}

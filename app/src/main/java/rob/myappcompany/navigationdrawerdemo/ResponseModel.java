package rob.myappcompany.navigationdrawerdemo;

public class ResponseModel {

    private String COLUM_RESPONSE_TICKET;
    private String COLUM_RESPONSE_NAME;
    private String COLUM_FOREIGN_ID;
    private String COLUM_UPDATED_DATE_RESPONSE;
    private String ID;

    public ResponseModel(String COLUM_RESPONSE_TICKET, String COLUM_RESPONSE_NAME, String COLUM_FOREIGN_ID, String COLUM_UPDATED_DATE_RESPONSE, String ID) {
        this.COLUM_RESPONSE_TICKET = COLUM_RESPONSE_TICKET;
        this.COLUM_RESPONSE_NAME = COLUM_RESPONSE_NAME;
        this.COLUM_FOREIGN_ID = COLUM_FOREIGN_ID;
        this.COLUM_UPDATED_DATE_RESPONSE = COLUM_UPDATED_DATE_RESPONSE;
        this.ID = ID;
    }



    public String getCOLUM_RESPONSE_TICKET() {
        return COLUM_RESPONSE_TICKET;
    }

    public void setCOLUM_RESPONSE_TICKET(String COLUM_RESPONSE_TICKET) {
        this.COLUM_RESPONSE_TICKET = COLUM_RESPONSE_TICKET;
    }

    public String getCOLUM_RESPONSE_NAME() {
        return COLUM_RESPONSE_NAME;
    }

    public void setCOLUM_RESPONSE_NAME(String COLUM_RESPONSE_NAME) {
        this.COLUM_RESPONSE_NAME = COLUM_RESPONSE_NAME;
    }

    public String getCOLUM_FOREIGN_ID() {
        return COLUM_FOREIGN_ID;
    }

    public void setCOLUM_FOREIGN_ID(String COLUM_FOREIGN_ID) {
        this.COLUM_FOREIGN_ID = COLUM_FOREIGN_ID;
    }

    public String getCOLUM_UPDATED_DATE_RESPONSE() {
        return COLUM_UPDATED_DATE_RESPONSE;
    }

    public void setCOLUM_UPDATED_DATE_RESPONSE(String COLUM_UPDATED_DATE_RESPONSE) {
        this.COLUM_UPDATED_DATE_RESPONSE = COLUM_UPDATED_DATE_RESPONSE;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "ResponseModel{" +
                ", COLUM_RESPONSE_TICKET='" + COLUM_RESPONSE_TICKET + '\'' +
                ", COLUM_RESPONSE_NAME='" + COLUM_RESPONSE_NAME + '\'' +
                ", COLUM_FOREIGN_ID='" + COLUM_FOREIGN_ID + '\'' +
                ", COLUM_UPDATED_DATE_RESPONSE='" + COLUM_UPDATED_DATE_RESPONSE + '\'' +
                ", ID='" + ID + '\'' +
                '}';
    }

}
